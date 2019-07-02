package com.teenstitans.awesomedemo;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_toolbar)
    Toolbar toolBar;
    @BindView(R.id.id_recycler_view)
    RecyclerView recyclerView;

    private List<MainItem> listData = new ArrayList<>();

    private MainAdapter mainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolBar.setTitle("AwesomeDemo");
        toolBar.setTitleTextColor(getResources().getColor(R.color.colorBlack));
        setSupportActionBar(toolBar);
        toolBar.setOnMenuItemClickListener(onMenuItemClick);

        initData();

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager1);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this, R.drawable.divider));
        mainAdapter = new MainAdapter(this, listData);
        recyclerView.setAdapter(mainAdapter);

        toolBar.setOnMenuItemClickListener(onMenuItemClick);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = item -> {
        int id = item.getItemId();
        if (id == R.id.id_action_done) {
            doneDialog(listData.toString());
        }
        return true;
    };

    private void doneDialog(String content) {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("编辑完成啦")
                .setContentText(content)
                .setConfirmText("知道了")
                .show();
    }

    private void initData() {
        MainItem mainItem1 = new MainItem();
        List<SubItem> listItemData1 = new ArrayList<>();
        SubItem subItem1 = new SubItem();
        subItem1.setSubIndex(0);
        subItem1.setInput1(0);
        subItem1.setInput2(0);
        listItemData1.add(subItem1);
        mainItem1.setIndex(0);
        mainItem1.setSubItem(listItemData1);

        MainItem mainItem2 = new MainItem();
        List<SubItem> listItemData2 = new ArrayList<>();
        SubItem subItem2 = new SubItem();
        subItem2.setSubIndex(0);
        subItem2.setInput1(0);
        subItem2.setInput2(0);
        listItemData2.add(subItem1);
        mainItem2.setIndex(1);
        mainItem2.setSubItem(listItemData2);

        MainItem mainItem3 = new MainItem();
        List<SubItem> listItemData3 = new ArrayList<>();
        SubItem subItem3 = new SubItem();
        subItem3.setSubIndex(0);
        subItem3.setInput1(0);
        subItem3.setInput2(0);
        listItemData3.add(subItem3);
        mainItem3.setIndex(2);
        mainItem3.setSubItem(listItemData3);

        listData.add(mainItem1);
        listData.add(mainItem2);
        listData.add(mainItem3);
    }
}
