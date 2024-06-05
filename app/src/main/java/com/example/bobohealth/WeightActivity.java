package com.example.bobohealth;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

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
        ListView mylist = findViewById(R.id.weightlist);
        mylist.setAdapter(listItemAdapter);
        mylist.setEmptyView(findViewById(R.id.nodata));

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置监听器
            @Override
            public void onItemClick(AdapterView<?>  parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) parent.getItemAtPosition(position);
                Toast.makeText(WeightActivity.this, "数据读取成功", Toast.LENGTH_LONG).show();
            }
        });
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