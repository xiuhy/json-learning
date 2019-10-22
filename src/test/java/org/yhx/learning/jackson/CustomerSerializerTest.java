package org.yhx.learning.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.Car;
import org.yhx.learning.jackson.module.CarSerializer;

public class CustomerSerializerTest extends BaseTest {


    @Test
    public void test()throws Exception{

        Car car=new Car("BMW",2);
        SimpleModule module=new SimpleModule();
        CarSerializer carDeserializer=new CarSerializer(Car.class);
        module.addSerializer(Car.class, carDeserializer);
        this.objectMapper.registerModule(module);
        String  jsonCar=this.objectMapper.writeValueAsString(car);
        System.out.println(jsonCar);
    }
}
