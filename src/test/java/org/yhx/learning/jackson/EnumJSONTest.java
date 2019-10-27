/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: EnumJSONTest.java
 * Author:   bigmoon
 * Date:     19-10-23 下午8:32
 * Description: json-learning
 */

package org.yhx.learning.jackson;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.City;
import org.yhx.learning.jackson.entity.Distance;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉

 */
public class EnumJSONTest extends BaseTest {

    /**
     * enum 默认情况下序列化成json 是enum枚举name
     *
     * @return
     * @since 20191030
     */
    @Test
    public void serializingEnumTest() throws Exception {

        System.out.println(objectMapper.writeValueAsString(Distance.INCH));
    }

    @Test
    public void deSerializingEnumTest() throws Exception {
        String json = "\"INCH\"";
        Assert.assertEquals(objectMapper.readValue(json, Distance.class), Distance.INCH);
    }

    /**
     * 自定义枚举序列化
     * 可以通过jsonValue 枚举实现枚举对象转换成自定义的字段值
     * @author 17081794

     * @return
     * @since 20191030
     * @see @JsonValue
     */
    @Test
    public void serializingEnumByJsonValueTest()throws Exception{
        System.out.println(objectMapper.writeValueAsString(Distance.INCH));
    }

    /** 自定义枚举反序列化
     * 可以通过jsonValue 枚举实现枚举对象转换成自定义的字段值
     * @author 17081794

     * @return
     * @since 20191030
     * @see @JsonValue
     */
    @Test
    public void deSerializingCustomEnumTest()throws Exception{

        String jsonEnum="{\"distance2\":\"0.0254\"}";
        City city=objectMapper.readValue(jsonEnum,City.class);
        Assert.assertEquals(city.getDistance2().getMeters(),0.0254);
    }

    /**
        jackson 2.1.2 之后，可以通过新注解实现枚举转对象JSON的实现
     * @return
     * @since 20191030
     * @see @JsonFormat(Shape=Shape.OBJECT)
     */
    @Test
    public void enum2Object()throws Exception{

        System.out.println(objectMapper.writeValueAsString(Distance.INCH));
    }



}
