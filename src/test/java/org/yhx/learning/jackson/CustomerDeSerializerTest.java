package org.yhx.learning.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.Car;
import org.yhx.learning.jackson.entity.NestObj;
import org.yhx.learning.jackson.module.CarDeserializer;

public class CustomerDeSerializerTest extends BaseTest {


    @Test
    public void test() throws Exception {
        String json = "{ \"brand2\" : \"Ford\", \"doors1\" : 6 }";

        SimpleModule module = new SimpleModule();
        CarDeserializer carDeserializer = new CarDeserializer(Car.class);
        module.addDeserializer(Car.class, carDeserializer);
        this.objectMapper.registerModule(module);
        Car car = this.objectMapper.readValue(json, Car.class);
        System.out.println(car);
    }

    @Test
    public void nestTest() throws Exception {
        String json = "{\"car\":{ \"brand2\" : \"Ford\", \"doors1\" : 6 },\"name\":\"test\"}";

        //#region manual add serializer/deserializer
//        SimpleModule module = new SimpleModule();
//        CarDeserializer carDeserializer = new CarDeserializer(Car.class);
//        module.addDeserializer(Car.class, carDeserializer);
//        this.objectMapper.registerModule(module);
        //#endregion

        NestObj car = this.objectMapper.readValue(json, NestObj.class);
        System.out.println(car);
    }


}
