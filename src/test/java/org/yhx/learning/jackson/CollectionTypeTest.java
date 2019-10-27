/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: CollectionTypeTest.java
 * Author:   bigmoon
 * Date:     19-10-24 下午4:47
 * Description: json-learning
 */

package org.yhx.learning.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.yhx.learning.jackson.entity.MyValue;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 默认情况下，json转换成java 集合是无法转换成具体通用类型，默认只能转换LinkedHashMap类型，例如List<LinkedHashMap>
 * 注：通用对象必须有无参构造函数，否则会有异常
 *
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since 20191030
 */
public class CollectionTypeTest extends BaseTest {

    //1.只要集合类型没有具体内容类型，即是Object 例如：List<Object>
    @Test
    public void testParseCollection() throws Exception {

        List<MyValue> list = Lists.newArrayList(new MyValue("a", 1), new MyValue("b", 2),
                new MyValue("c", 3));

        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);

        List listObj = objectMapper.readValue(json, List.class);
        Assert.assertEquals(listObj.get(0).getClass(), LinkedHashMap.class);
    }

    //通过TypeReference 方式实现通用类型，不需要转换LinkedHashMap类型
    @Test
    public void testParseCollection2() throws Exception {

        List<MyValue> list = Lists.newArrayList(new MyValue("a", 1), new MyValue("b", 2),
                new MyValue("c", 3));

        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);

        List<MyValue> listObj = objectMapper.readValue(json, new TypeReference<List<MyValue>>() {
        });
        Assert.assertEquals(listObj.get(0).getClass(), MyValue.class);
    }


    /**
     * 通过javaType 方式实现具体类型
     *
     * @since 20191030
     */
    @Test
    public void testParseCollection3() throws Exception {

        List<MyValue> list = Lists.newArrayList(new MyValue("a", 1), new MyValue("b", 2),
                new MyValue("c", 3));

        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);

        CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, MyValue.class);
        List<MyValue> listObj = objectMapper.readValue(json, javaType);
        Assert.assertEquals(listObj.get(0).getClass(), MyValue.class);
    }


}
