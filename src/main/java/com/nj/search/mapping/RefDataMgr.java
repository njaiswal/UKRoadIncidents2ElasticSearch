package com.nj.search.mapping;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileNotFoundException;

public  class RefDataMgr {

    private static ReferenceYamlData refData;

    public static void loadReferenceData() throws FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(ReferenceYamlData.class));
        refData = (ReferenceYamlData) yaml.load(RefDataMgr.class.getResourceAsStream("/mapping.yml"));
    }

    public static ReferenceYamlData data() {
        return refData;
    }
}