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
}
