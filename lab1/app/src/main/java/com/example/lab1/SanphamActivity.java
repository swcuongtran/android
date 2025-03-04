package com.example.lab1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SanphamActivity extends AppCompatActivity {

    ListView lv2;
    SanPham sp;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sanpham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        handleEvents();
    }

    private void handleEvents() {
    }

    private void addControls(){
        lv2 = findViewById(R.id.lv2);
        sanPhamAdapter = new SanPhamAdapter(SanphamActivity.this,R.layout.item);

        sanPhamAdapter.add(new SanPham("Ổi",R.drawable.oi,"Ổi ruột đỏ",12));
        sanPhamAdapter.add(new SanPham("Lựu",R.drawable.luu,"Lựu ruột đỏ",14));
        sanPhamAdapter.add(new SanPham("Vải",R.drawable.vai,"Vải thiều",15));
        lv2.setAdapter(sanPhamAdapter);
    }
}