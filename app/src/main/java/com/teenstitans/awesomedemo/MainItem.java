package com.teenstitans.awesomedemo;

import java.util.List;

/**
 * Created by guoren on 2019-7-1 16:41
 * Usage
 */
public class MainItem {
    private int index;
    private List<SubItem> subItem;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<SubItem> getSubItem() {
        return subItem;
    }

    public void setSubItem(List<SubItem> subItem) {
        this.subItem = subItem;
    }

    @Override
    public String toString() {
        return "MainItem{" +
                "index=" + index +
                ", subItem=" + subItem +
                '}' + "\n\n";
    }
}
