package com.example.practice610;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice610.db.AppDatabase;
import com.example.practice610.db.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase db;
    private Context context;
    EditText edName,edQuantity;
    Button btAdd,btView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        db = AppDatabase.getAppDatabase(context);

        edName = findViewById(R.id.edName);
        edQuantity = findViewById(R.id.edQuantity);
        btAdd = findViewById(R.id.btAdd);
        btView = findViewById(R.id.btView);
        btAdd.setOnClickListener(this);
        btView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                onRegister();
                break;
            case R.id.btView:
                onView();
            default:
                break;
        }
    }

    private void onView() {
        Intent intent=new Intent(getApplicationContext(),ViewActivity.class);
        startActivity(intent);
        finish();
    }

    private void onRegister() {

        Product product = new Product();
        product.name = edName.getText().toString();
        product.quantity =Integer.valueOf(edQuantity.getText().toString()) ;
        long id = db.productDao().insertProduct(product);
        if (id > 0) {
            Toast.makeText(this," Add Success",Toast.LENGTH_SHORT).show();
        }
    }


}