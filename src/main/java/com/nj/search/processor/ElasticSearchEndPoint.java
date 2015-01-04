package com.nj.search.processor;

import org.apache.camel.Exchange;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ElasticSearchEndPoint {
    private Logger logger = LoggerFactory.getLogger(ElasticSearchEndPoint.class);
    Client client;

    public ElasticSearchEndPoint(String eshost, int esport){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("client.transport.ignore_cluster_name", true)
                .put("client.transport.sniff", true)
                .build();
        this.client =    new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(eshost,esport));
        logger.info("Created ElasticSearch Client");
    }

    public void bulkIndex(Exchange ex){
        List<Map> documents = ex.getIn().getBody(List.class);

        String indexName = ex.getIn().getHeader("ES.INDEX_NAME", String.class);
        String type = ex.getIn().getHeader("ES.TYPE", String.class);

        logger.debug("Going to bulk index: {} documents with index:{} and type:{}", documents.size(), indexName, type);

        BulkRequestBuilder bulkRequest = this.client.prepareBulk();

        for(Map d: documents){
            bulkRequest.add(client.prepareIndex(indexName, type).setSource(d));
        }

        BulkResponse bulkResponse = bulkRequest.execute().actionGet();

        int successCount = 0;
        int failureCount = 0;

        for(BulkItemResponse itemResponse: bulkResponse.getItems()){
            if(!itemResponse.isFailed()){
                successCount++;
            } else {
                failureCount++;
                logger.error("Failed to index document. Error message: {}",itemResponse.getFailureMessage());
            }
        }

        logger.info("Request to Bulk index {} documents done in {}ms with success:{} failure:{}",
                documents.size(),
                bulkResponse.getTookInMillis(),
                successCount,
                failureCount);

    }
}
