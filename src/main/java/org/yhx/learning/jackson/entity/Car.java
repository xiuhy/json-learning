package org.yhx.learning.jackson.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.yhx.learning.jackson.module.CarDeserializer;
import org.yhx.learning.jackson.module.CarSerializer;

@JsonDeserialize(using = CarDeserializer.class)
@JsonSerialize(using = CarSerializer.class)
public class Car {
    private String brand = null;
    private int doors = 0;

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    public Car() {
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", doors=").append(doors);
        sb.append('}');
        return sb.toString();
    }
}
