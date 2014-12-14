package com.nj.search.mapping;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class RefDataMgrTest {


    @BeforeClass
    public void oneTimeSetUp() throws Exception {
        RefDataMgr.loadReferenceData();
    }

    @DataProvider(name = "refData", parallel = true)
    public Object[][] refData_testcases() throws FileNotFoundException {
        return new Object[][] {
                { "Road_Type.1", "Roundabout" },
                { "Junction_Control.4", "Give way or uncontrolled" },
                { "Weather_Conditions.10", null }
        };
    }

    @Test(dataProvider = "refData", enabled = true)
    public void testServices(String k, String v) throws Exception {

        String [] kk = k.split("\\.");
        String k1 = kk[0];
        String k2 = kk[1];

        String actual = null;

        if(k1.equals("Road_Type")) {
            actual = RefDataMgr.data().getRoad_Type().get(k2);
        } else if(k1.equals("Junction_Control")) {
            actual = RefDataMgr.data().getJunction_Control().get(k2);
        } else if(k1.equals("Weather_Conditions")){
            actual = RefDataMgr.data().getWeather_Conditions().get(k2);
        } else {
            Assert.fail("Test did not correctly identify key:" + k1);
        }

        if(v != null) {
            Assert.assertTrue(v.equals(actual), "Verified: " + k + " = " + v + "actual=" + actual);
        }
    }

    @AfterClass
    public void oneTimeTearDown() {
    }
}
