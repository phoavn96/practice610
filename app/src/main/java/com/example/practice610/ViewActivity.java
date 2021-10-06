package com.example.practice610;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.practice610.db.AppDatabase;
import com.example.practice610.db.Product;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    public static Context context;
    private static AppDatabase db;
    private SimpleCursorAdapter simpleCursorAdapter;

    private RecyclerView recyclerView;
    private ListView lvProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        context = this;
        db = AppDatabase.getAppDatabase(context);
        db.productDao().getAllProduct();
        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item, cursor, new String[]{

        lvProducts.setAdapter(simpleCursorAdapter);

    }
}