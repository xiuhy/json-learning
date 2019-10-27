package org.yhx.learning.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.testng.annotations.Test;

public class JSONTreeTest extends BaseTest {

    /**
     * JSON to jsonNode
     * @throws Exception
     */
    @Test
    public void createJSONTreeTest()throws  Exception{
        String json = "{ \"f1\" : \"v1\" } ";
        JsonNode jsonTree=objectMapper.readTree(json);
        System.out.println(jsonTree.get("f1").asText());
    }

    /**
     * jsonNode to json
     */
    @Test
    public void jsonNode2JSONTest() throws Exception{
        String json = "{ \"f1\" : \"v1\" } ";
        JsonNode jsonTree=objectMapper.readTree(json);
        String json2=objectMapper.writeValueAsString(jsonTree);
        System.out.println(json2);
    }

    /**
     * 通过不同方式获取node节点数据
     * @throws Exception
     */
    @Test
    public void getJsonNodeField()throws Exception{

        String json="{\n" +
                "    \"field1\" : \"value1\",\n" +
                "    \"field2\" : 999 ,\n" +
                "    \"name\" : 999 ,\n" +
                " \"identification\" :  {\n" +
                "        \"name\" : \"James\",\n" +
                "        \"ssn\": \"ABC123552\"\n" +
                "    }"+
                "}";
        JsonNode jsonNode=objectMapper.readTree(json);
        //通过get 获取字段信息内容，但是返回对象还是JsonNode
        System.out.println(jsonNode.get("field1").asText());
        //还可以通过at方式，通过path查询字段值
        System.out.println(jsonNode.at("/identification/name").asText());
        System.out.println(jsonNode.findValues("name"));
    }

    @Test
    public void nullValueTest()throws Exception{
        String json = "{ \"f1\":\"Hello\", \"f2\":null }";
        JsonNode jsonNode=objectMapper.readTree(json);
        //当节点值为null时，可以通过 get(xxx).asText(defaultValue).
        // 当当前jsonNode value是null的时候需按照defaultValue执行
        System.out.println(jsonNode.get("f2").asText("default"));
        //必须是有该字段，且该字段为null,使用isNull才合适
        System.out.println(jsonNode.get("f2").isNull());
        //查询不存在节点直接返回null
        Assert.assertNull(jsonNode.get("f3"));
    }
}
