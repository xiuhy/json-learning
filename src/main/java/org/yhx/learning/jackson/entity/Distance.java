/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: Test.java
 * Author:   bigmoon
 * Date:     19-10-23 上午11:39
 * Description: json-learning
 */

package org.yhx.learning.jackson.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 */
//@JsonFormat(shape = JsonFormat.Shape.OBJECT) enum2Object测试案例使用该行代码
public enum Distance {
    KILOMETER("km", 1000),
    MILE("miles", 1609.34),
    METER("meters", 1),
    INCH("inches", 0.0254),
    CENTIMETER("cm", 0.01),
    MILLIMETER("mm", 0.001);

    private String unit;
    private final double meters;

    private Distance(String unit, double meters) {
        this.unit = unit;
        this.meters = meters;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonValue
    public double getMeters() {
        return meters;
    }
}
