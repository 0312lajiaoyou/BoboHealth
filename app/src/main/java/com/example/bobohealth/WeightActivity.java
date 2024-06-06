package com.example.bobohealth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightActivity extends AppCompatActivity {
    private static final String TAG = "WeightActivity";
    private ArrayList<HashMap<String, String>> listItems = new ArrayList<>();

    private ListView mylist;
    private SimpleAdapter listItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        mylist = findViewById(R.id.weightlist);
        //接收传入数据
        Intent intent = getIntent();
        Float weight1 = intent.getFloatExtra("weight_key",0);
        Log.i(TAG, "onCreate: get weight2=" + weight1);
        TextView myout = findViewById(R.id.out);
        myout.setText(String.format("今日体重：%.2f " + "kg", weight1));

        // 获取数据库中的数据并显示在listview中
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = null;
        try {
            c = db.query("tb_weight", new String[]{"WEIGHT", "DATE"}, null, null, null, null, "DATE DESC"); // 添加了DESC来逆序输出
            if (c != null && c.moveToFirst()) {
                do {
                    String weight = c.getString(c.getColumnIndexOrThrow("WEIGHT"));
                    String date = c.getString(c.getColumnIndexOrThrow("DATE"));
                    if (weight != null && date != null) {
                        listItems.add(new HashMap<String, String>() {{
                            put("itemTitle", weight+"kg");
                            put("itemDetail", date);
                        }});
                    }
                } while (c.moveToNext());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Column not found", e);
        } finally {
            if (c != null) c.close();
            db.close(); // 关闭数据库
        }

        SimpleAdapter listItemAdapter = new SimpleAdapter(
                WeightActivity.this, listItems,
                R.layout.list_item2,
                new String[]{"itemTitle", "itemDetail"},
                new int[]{R.id.itemTitle, R.id.itemDetail}
        );
        mylist.setAdapter(listItemAdapter);
        mylist.setEmptyView(findViewById(R.id.nodata));
        // 初始化列表
        refreshListView();
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取点击的项
                HashMap<String, String> map = (HashMap<String, String>) parent.getItemAtPosition(position);
                String weight = map.get("itemTitle").replace("kg", "");
                String date = map.get("itemDetail");

                // 显示确认删除的对话框
                new AlertDialog.Builder(WeightActivity.this)
                        .setTitle("确认删除")
                        .setMessage("确定要删除日期为 " + date + " 的体重记录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从数据库中删除记录
                                DBHelper helper = new DBHelper(WeightActivity.this);
                                SQLiteDatabase db = helper.getWritableDatabase();
                                String[] selectionArgs = {weight, date};
                                int rowsDeleted = db.delete("tb_weight", "WEIGHT=? AND DATE=?", selectionArgs);
                                if (rowsDeleted > 0) {
                                    // 刷新列表
                                    listItems.clear();
                                    refreshListView();
                                    Toast.makeText(WeightActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(WeightActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }
    // 刷新ListView的方法
    private void refreshListView() {
        // 清空现有数据
        listItems.clear();

        // 从数据库获取数据
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = null;
        try {
            c = db.query("tb_weight", new String[]{"WEIGHT", "DATE"}, null, null, null, null, "DATE DESC");
            if (c.moveToFirst()) {
                do {
                    String weight = c.getString(c.getColumnIndexOrThrow("WEIGHT"));
                    String date = c.getString(c.getColumnIndexOrThrow("DATE"));
                    listItems.add(new HashMap<String, String>() {{
                        put("itemTitle", weight + "kg");
                        put("itemDetail", date);
                    }});
                } while (c.moveToNext());
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Column not found", e);
        } finally {
            if (c != null) c.close();
            db.close();
        }

        // 如果这是第一次设置Adapter，则需要创建
        if (listItemAdapter == null) {
            listItemAdapter = new SimpleAdapter(
                    WeightActivity.this, listItems,
                    R.layout.list_item2,
                    new String[]{"itemTitle", "itemDetail"},
                    new int[]{R.id.itemTitle, R.id.itemDetail}
            );
            mylist.setAdapter(listItemAdapter);
        } else {
            // 否则，只需通知数据已改变
            listItemAdapter.notifyDataSetChanged();
        }
    }
    public void fanhui (View view){
        //open activity
        Intent intent = new Intent(this, HomepageActivity.class);
        startActivity(intent);
    }
    public void add (View view){
        //open activity
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}