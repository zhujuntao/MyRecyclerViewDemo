package com.example.hzcj.myrecyclerviewdemo;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.hzcj.myrecyclerviewdemo.adapter.MultipleItemAdapter;
import com.example.hzcj.myrecyclerviewdemo.adapter.NormalRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    private String[] data= new String[] {"安卓","iOS", "前端","后台", "UI","运维", "产品","架构", "项目","开发", "web端","数据分析", "C语言","Java运维"};
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));

        MultipleItemAdapter multipleItemAdapter=new MultipleItemAdapter(this,data);
        recyclerView.setAdapter(multipleItemAdapter);

//        NormalRecyclerViewAdapter adapter=new NormalRecyclerViewAdapter(this,data);
//        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new NormalRecyclerViewAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this,data[position]+"---点击了---",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void OnItemLongClick(View view, int position) {
//                Toast.makeText(MainActivity.this,data[position]+"---长按了---",Toast.LENGTH_SHORT).show();
//            }
//        });



//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
//        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));








    }
}
