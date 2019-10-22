package org.yhx.learning.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    ObjectMapper objectMapper;

    @BeforeClass
    public void setup(){
        objectMapper= new ObjectMapper();
    }
}
