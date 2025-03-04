package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.imageView5).setOnClickListener(this::onClickCal);
        findViewById(R.id.imageView7).setOnClickListener(this::onClickInfo);
        findViewById(R.id.imageView8).setOnClickListener(this::onClickMenu);
        findViewById(R.id.imageView9).setOnClickListener(this::onClickSanPham); // Thay đổi mở SanphamActivity
        findViewById(R.id.imageViewContact).setOnClickListener(this::onClickContact);
    }

    public void onClickCal(View view) {
        startActivity(new Intent(MainActivity.this, Maytinh.class));
    }

    public void onClickInfo(View view) {
        startActivity(new Intent(MainActivity.this, Thongtinnguoidung.class));
    }

    public void onClickMenu(View view) {
        startActivity(new Intent(MainActivity.this, Danhmuc.class));
    }

    public void onClickContact(View view) {
        startActivity(new Intent(MainActivity.this, ContactActivity.class));
    }

    // Thêm phương thức mở SanphamActivity
    public void onClickSanPham(View view) {
        startActivity(new Intent(MainActivity.this, SanphamActivity.class));
    }
}
