package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HocIntentResultActivity extends AppCompatActivity {
    ListView lvDanhSach;
    Button btnNhap;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_intent_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        handleEvent();
        addControl();

    }

    private void handleEvent() {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        btnNhap.setOnClickListener(v -> {
            Intent intent = new Intent(HocIntentResultActivity.this, HocIntentActivity.class);
            startActivity(intent);
        });
    }

    private void addControl() {
        btnNhap = findViewById(R.id.button12);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        Intent intentResult = getIntent();
        String ten = intentResult.getStringExtra("ten");
        int gia = intentResult.getIntExtra("gia",0);
        String thongtin = "Ten: "+ten+"\n Gia"+gia;
        adapter.add(thongtin);
        lvDanhSach.setAdapter(adapter);
    }
}