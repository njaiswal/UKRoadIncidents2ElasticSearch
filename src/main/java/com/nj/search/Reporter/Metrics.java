package com.nj.search.Reporter;


import com.nj.search.utils.CsvDataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Metrics {

    private Logger logger = LoggerFactory.getLogger(Metrics.class);

    @Autowired
    private CsvDataStore dataStore;


    public void report(){
        logger.info("Accidents List: {}, Accidents:{}, Casualities:{}, Vehicles: {}, MakeModel:{}, Accidents Full:{}, Accidents Completed:{}",
                dataStore.getAccidentIdList().size(),
                dataStore.getAccidents().size(),
                dataStore.getCasualties().size(),
                dataStore.getVehicles().size(),
                dataStore.getMakemodels().size(),
                dataStore.getAccidentsFullData().size(),
                dataStore.getAccidentIdCompletedList().size());
    }
}
