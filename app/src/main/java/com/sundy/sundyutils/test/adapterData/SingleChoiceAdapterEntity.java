package com.sundy.sundyutils.TestData.adapterData;

/**
 * 单选ListView适配器的数据源
 * Created by sundi on 2016/10/12.
 */
public class SingleChoiceAdapterEntity {
    private String num ;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SingleChoiceAdapterEntity{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
