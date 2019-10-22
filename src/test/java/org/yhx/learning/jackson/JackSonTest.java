package org.yhx.learning.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.Car;
import org.yhx.learning.jackson.entity.MyValue;

import java.util.List;

public class JackSonTest extends BaseTest {

    /**
     * 对象转换成json字符串
     * @throws Exception
     */
    @Test
    public void toJSONStr()throws Exception{

        MyValue myValue=new MyValue("abc",123);
        System.out.println(objectMapper.writeValueAsString(myValue));
    }

    /**
     * 字符串json 转换成对象
     * @throws Exception
     */
    @Test
    public void toObj()throws Exception{
        String json="{\"name\":\"abc\",\"age\":123}";

        MyValue myValue=objectMapper.readValue(json,MyValue.class);
        System.out.println(myValue.name);
    }

    /**
     * 字符串json 转换成集合
     * 创建TypeReference 对象实现
     * @throws Exception
     */
    @Test
    public void toCollection()throws Exception{
        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        List<Car> cars=objectMapper.readValue(jsonArray, new TypeReference<List<Car>>(){});
        cars.stream().forEach(item->System.out.println(item));
    }

    /**
     * jackson可以忽略json中无法识别的字段，
     * 默认情况下json字符串中无法识别的字段会抛出异常
     * 可以通过字段DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
     * @throws Exception
     */
    @Test
    public void testIgnoreUnknownField()throws Exception{

        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String json="{\"name\":\"abc\",\"age\":123,\"sex\":\"woman\"}";
        MyValue myValue=objectMapper.readValue(json,MyValue.class);
        System.out.println(myValue.name);
    }


}
