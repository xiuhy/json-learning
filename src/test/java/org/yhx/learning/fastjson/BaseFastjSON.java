package org.yhx.learning.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

public class BaseFastjSON {

    @Test
    public void test(){
        String json="{\n" +
                "    \"field1\" : \"value1\",\n" +
                "    \"field2\" : 999\n" +
                " \"identification\" :  {\n" +
                "        \"name\" : \"James\",\n" +
                "        \"ssn\": \"ABC123552\"\n" +
                "    }"+
                "}";

        JSONObject jsonObject=JSON.parseObject(json);
        System.out.println(jsonObject.get("name"));
    }
}
