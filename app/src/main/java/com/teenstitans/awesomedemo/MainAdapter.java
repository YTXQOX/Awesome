package com.teenstitans.awesomedemo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by guoren on 2019-7-1 16:40
 * Usage
 */
public class MainAdapter extends BaseQuickAdapter<MainItem, BaseViewHolder> {
    private Context context;
    private List<MainItem> data;

    public MainAdapter(Context context, List<MainItem> data) {
        super(R.layout.layout_item, data);

        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, MainItem item) {
        helper.setText(R.id.id_item_hint1, "第" + (item.getIndex() + 1) + "-分值范围");
        helper.setText(R.id.id_item_hint2, (item.getIndex() + 1) + "-管理费用");

        RecyclerView recyclerView = helper.getView(R.id.id_item_recycler_view);
        TextView tvAdd = helper.getView(R.id.id_item_add);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager1);
        SubAdapter subAdapter = new SubAdapter(context, item.getIndex(), item.getSubItem());
        recyclerView.setAdapter(subAdapter);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubItem subItem1 = new SubItem();
                subItem1.setSubIndex(data.get(item.getIndex()).getSubItem().size());
                subItem1.setInput1(0);
                subItem1.setInput2(0);
                data.get(item.getIndex()).getSubItem().add(subItem1);

                notifyDataSetChanged();
            }
        });
    }
}