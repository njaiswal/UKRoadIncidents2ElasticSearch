package com.nj.search.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NonDeliveriesProcessor implements Processor{
    private Logger logger = LoggerFactory.getLogger(CsvDataProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        if(message != null){
            Object body = message.getBody();
            if(body instanceof List){
                List documents = (List) body;
                logger.error("Could not deliver {} documents", documents.size());
            } else {
                logger.error("Could not determine type of message body:{} for error reporting", body.toString());
            }
        } else {
            logger.error("No message found in exchange for purpose of error reporting");
        }
    }
}
