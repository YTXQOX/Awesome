package com.teenstitans.awesomedemo;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

/**
 * Created by guoren on 2019-7-1 16:40
 * Usage
 */
public class SubAdapter extends BaseQuickAdapter<SubItem, BaseViewHolder> {
    private Context context;
    private int index;
    private List<SubItem> subData;

    public SubAdapter(Context context, int index, List<SubItem> data) {
        super(R.layout.layout_sub_item, data);

        this.context = context;
        this.index = index;
        this.subData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, SubItem item) {
        TextInputEditText input1 = helper.getView(R.id.id_sub_item_input1);
        TextInputEditText input2 = helper.getView(R.id.id_sub_item_input2);

        input1.setHint(item.getInput1() + "");
        input2.setHint(item.getInput2() + "");
        input1.setText(item.getInput1() + "");
        input2.setText(item.getInput2() + "");

        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                subData.get(item.getSubIndex()).setInput1(s.toString());
            }
        });

        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                subData.get(item.getSubIndex()).setInput2(s.toString());
            }
        });
    }

}