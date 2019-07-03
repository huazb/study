package com.study.enumtest;

/**
 * 状态枚举
 * @author 华志宾
 * @date 2019-03-26
 */
public enum StatusEnum {

    /**
     * 正常
     */
    NORMAL("normal", "正常"),
    /**
     * 作废
     */
    UNLESS("unless", "作废");

    /**
     *  value
     */
    private String value;
    /**
     * 描述
     */
    private String description;

    /**
     * 构造初始赋值
     * @param value
     * @param description
     */
    StatusEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
