package org.yhx.learning.jackson.module;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.yhx.learning.jackson.entity.Car;

import java.io.IOException;

/**
 * jackson 自定义序列化
 */
public class CarSerializer extends StdSerializer<Car> {

    public CarSerializer(Class zclass){
        super(zclass);
    }
    @Override
    public void serialize(Car value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("car-Brand",value.getBrand());
        gen.writeNumberField("car-doors",value.getDoors());
        gen.writeEndObject();
    }
}
