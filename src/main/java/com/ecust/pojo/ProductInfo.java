package com.ecust.pojo;

import java.io.Serializable;

/**
 * Created by cheng on 2018/4/13.
 */
public class ProductInfo implements Serializable {

    // 产品类型
    private String type;
    // 产品需要的功能选项
    private String functions;

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "type='" + type + '\'' +
                ", functions='" + functions + '\'' +
                '}';
    }
}
