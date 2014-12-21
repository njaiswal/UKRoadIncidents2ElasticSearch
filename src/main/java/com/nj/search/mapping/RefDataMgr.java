package com.nj.search.mapping;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileNotFoundException;

@Component
public  class RefDataMgr {

    private  ReferenceYamlData refData;
    private  static RefDataMgr instance = null;

    private RefDataMgr() throws FileNotFoundException {
        this.loadReferenceData();
    }

    public static RefDataMgr getInstance() throws FileNotFoundException {
        if(instance == null) {
            instance = new RefDataMgr();
        }
        return instance;
    }

    private void loadReferenceData() throws FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(ReferenceYamlData.class));
        this.refData = (ReferenceYamlData) yaml.load(RefDataMgr.class.getResourceAsStream("/mapping.yml"));
    }

    public ReferenceYamlData data() {
        return this.refData;
    }
}