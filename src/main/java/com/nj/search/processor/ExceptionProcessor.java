package com.nj.search.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExceptionProcessor implements Processor{

    private Logger logger = LoggerFactory.getLogger(ExceptionProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        Map<String, Object> headers = exchange.getIn().getHeaders();

        logger.error("Error processing message. body:{} headers:{}", body, headers.toString());
    }
}
