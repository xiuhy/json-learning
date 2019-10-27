package org.yhx.learning.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;

/**
 * 练习手册来自：https://www.baeldung.com/jackson
 */
public class BaseTest {

    ObjectMapper objectMapper;

    @BeforeClass
    public void setup(){
        objectMapper= new ObjectMapper();
    }
}
