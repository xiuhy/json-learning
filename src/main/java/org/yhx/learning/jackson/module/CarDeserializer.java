package org.yhx.learning.jackson.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.yhx.learning.jackson.entity.Car;

import java.io.IOException;

/**
 * jackson 自定义反序列化
 */
public class CarDeserializer extends StdDeserializer<Car> {

    public CarDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Car deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Car car = new Car();

        while (!p.isClosed()) {

            JsonToken token = p.nextToken();

            if (JsonToken.FIELD_NAME.equals(token)) {
                String fieldName = p.currentName();
                System.out.println("current field name:" + fieldName);

                token = p.nextToken();

                if ("brand2".equals(fieldName)) {
                    car.setBrand(p.getValueAsString());
                } else if ("doors1".equals(fieldName)) {
                    car.setDoors(p.getValueAsInt());
                }
            }
        }
        return car;
    }
}
