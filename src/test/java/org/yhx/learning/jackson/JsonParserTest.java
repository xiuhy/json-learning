package org.yhx.learning.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.testng.annotations.Test;

public class JsonParserTest {

    @Test
    public void baseJsonParserTest() throws Exception {

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(carJson);

        while (!jsonParser.isClosed()) {
            //在parser 未关闭情况下遍历所有token，所有token指向具体意义，
            //参考 @see com.fasterxml.jackson.core.JsonToken
            JsonToken jsonToken = jsonParser.nextToken();
            System.out.println(jsonToken);

            if (JsonToken.FIELD_NAME == jsonToken) {
                String fieldName = jsonParser.currentName();
                //获取字段名称之后，必须nextToken获取field对应的value 否则无效
                JsonToken jsonToken2 = jsonParser.nextToken();
                String fieldValue = jsonParser.getValueAsString();
                System.out.println(String.format("jsonToken2=%s,field:%s,the value=%s", jsonToken2, fieldName, fieldValue));
            }
        }
    }
}
