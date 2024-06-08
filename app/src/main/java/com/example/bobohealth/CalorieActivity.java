package com.example.bobohealth;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CalorieActivity extends ListActivity {
    private static final String TAG ="CalorieActivity";
    private ArrayList<HashMap<String,String>> listItems;
    private SimpleAdapter listItemAdapter;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Log.i(TAG, "收到消息" + msg.what);
                if (msg.what == 8) {
                    Log.i(TAG, "handleMessage:what=" + msg.what);
                    listItems = (ArrayList<HashMap<String, String>>) msg.obj;
                    listItemAdapter= new SimpleAdapter(CalorieActivity.this,listItems,
                            R.layout.list_item,
                            new String[]{"itemTitle","itemDetail"},
                            new int[]{R.id.itemTitle,R.id.itemDetail});
                    setListAdapter(listItemAdapter);
                }
                super.handleMessage(msg);
            }
        };

        //定义一个线程获取数据
        Thread t = new Thread(() -> {
            ArrayList<HashMap<String,String>> list= new ArrayList<HashMap<String,String>>();
            try {
                Document doc = Jsoup.connect("https://www.boohee.com/food/group/1").get();
                Elements tables = doc.select("ul.food-list > li.item");
                // 遍历所有食物项
                for (Element item : tables) {
                    String name = item.select("h4 a").text();
                    String calorie = item.select("p").text();
                    Log.i(TAG, "run:" + name + "==>" + calorie);
                    HashMap<String, String> food = new HashMap<>();
                    food.put("itemTitle", name);
                    food.put("itemDetail", calorie);
                    list.add(food);
                }
            } catch(MalformedURLException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
            //获取MSG对象，用于返回主线程
            Message msg = handler.obtainMessage(8, list);
            handler.sendMessage(msg);
        });
        t.start();
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this, HomepageActivity.class);
        startActivity(intent);
    }

}