package com.example.practice610;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
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
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        context = this;
        db = AppDatabase.getAppDatabase(context);
        productList = db.productDao().getAllProduct();
        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item, (Cursor) productList, new String[]{
                "ID", "NAME", "QUANTITY"}, new int[]{R.id.tvId, R.id.tvName, R.id.tvQuantity},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lvProducts.setAdapter(simpleCursorAdapter);

    }
}