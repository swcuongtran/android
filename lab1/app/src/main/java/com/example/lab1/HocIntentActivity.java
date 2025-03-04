package com.example.lab1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

public class HocIntentActivity extends AppCompatActivity {
    Button btnOpenSecond;
    Button btnChonHinh;
    ImageView imgHinh;
    EditText edtTen,edtGia;
    TextInputLayout txtTen,txtGia;
    Button btnSave;
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        handleEvents();
    }

    private void handleEvents() {
        btnOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HocIntentActivity.this,HocIntentResultActivity.class);
                startActivity(intent);
            }
        });
        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HocIntentActivity.this,HocIntentResultActivity.class);
                String _ten = edtTen.getText().toString();
                String _gia = edtGia.getText().toString();
                int _g = Integer.parseInt(_gia);
                boolean isValid = true;
                if(_ten.isEmpty()){
                    txtTen.setError("Ten is not Empty");
                    isValid =false;
                }
                else {
                    txtTen.setError(null);
                }
                if(isValid){
                    intent.putExtra("ten",_ten);
                    intent.putExtra("gia",_g);
                    startActivity(intent);
                }
            }
        });
    }

    private void addControl() {
        btnOpenSecond = findViewById(R.id.btnNhap);
        btnChonHinh = findViewById(R.id.btnChon);
        imgHinh = findViewById(R.id.imgHinh);
        edtTen = findViewById(R.id.edtTen);
        edtGia = findViewById(R.id.edtGia);
        txtTen = findViewById(R.id.txtTen);
        txtGia = findViewById(R.id.txtGia);
        btnSave = findViewById(R.id.btnSave);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Uri uriImg = data.getData();
            try {
                Bitmap img = MediaStore.Images.Media.getBitmap(getContentResolver(),uriImg);
                imgHinh.setImageBitmap(img);
            } catch (IOException e) {
                Toast.makeText(HocIntentActivity.this,"Error loading Image",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }
}