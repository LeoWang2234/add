package com.ecust.pojo;

/**
 * Created by cheng on 2018/4/13.
 */
public class Option {

    public Option(String type, Integer index,  String name,String logic) {
        this.type = type;
        this.index = index;
        this.logic = logic;
        this.name = name;
    }
    // ÀàÐÍ
    private String type;
    // ±àºÅ
    private Integer index;
    // Ãû×Ö
    private String name;
    // Âß¼­
    private String logic;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIndex() {

        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    @Override
    public String toString() {
        return "Option{" +
                "type='" + type + '\'' +
                ", index=" + index +
                ", logic='" + logic + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
