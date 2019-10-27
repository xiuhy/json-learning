/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: MapTest.java
 * Author:   bigmoon
 * Date:     19-10-24 下午5:31
 * Description: json-learning
 */

package org.yhx.learning.jackson;

import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.MyValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since 20191030
 */
public class MapTest extends BaseTest {


    /** 
     * map 对象转换成json字符串
     * @return 
     * @since 20191030
     */
    @Test
    public void map2Json()throws Exception{

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        // 常规打印
        System.out.println(objectMapper.writeValueAsString(map));
        //格式化后的json打印方式
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));

    }

    /**
     * map Object 对象作为key时候，Object对象如果没有实现ToString 则可能会无法正产显示对象属性，只能显示对象内存地址；
     * 可以自定义序列化对象
     * @return
     * @since 20191030
     */
    @Test
    public void mapObj2Json()throws Exception{

        Map<String,MyValue> map=new HashMap<>();
        map.put("a",new MyValue("a",1));
        map.put("b",new MyValue("b",2));
        
        System.out.println(objectMapper.writeValueAsString(map));

        Map<MyValue,String> map2=new HashMap<>();
        map2.put(new MyValue("a",1),"a");
        map2.put(new MyValue("b",2),"b");
        System.out.println(objectMapper.writeValueAsString(map2));

    }



}
