package com.example.lab1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import module.ArrayAdapterProduct;
import module.Product;

public class HocGridviewActivity extends AppCompatActivity {
    GridView gvShopping;
    ArrayAdapter<String> adapterShopping;
    ArrayAdapterProduct adapterProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_gridview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        HandleEvents();
    }

    private void HandleEvents() {
    }

    private void addControls() {
        gvShopping = findViewById(R.id.gv);
        adapterProduct = new ArrayAdapterProduct(HocGridviewActivity.this,R.layout.item_product);
        gvShopping.setAdapter(adapterProduct);
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
        adapterProduct.add(new Product("Oi",12000,R.drawable.oi));
    }
}