package com.teenstitans.awesomedemo;

/**
 * Created by guoren on 2019-7-1 16:47
 * Usage
 */
public class SubItem {

    private int subIndex;
    private Object input1 = 0;
    private Object input2 = 0;

    public int getSubIndex() {
        return subIndex;
    }

    public void setSubIndex(int subIndex) {
        this.subIndex = subIndex;
    }

    public Object getInput1() {
        return input1;
    }

    public void setInput1(Object input1) {
        this.input1 = input1;
    }

    public Object getInput2() {
        return input2;
    }

    public void setInput2(Object input2) {
        this.input2 = input2;
    }

    @Override
    public String toString() {
        return "SubItem{" +
                "subIndex=" + subIndex +
                ", input1=" + input1.toString() +
                ", input2=" + input2.toString() +
                '}'+ "\n";
    }
}
