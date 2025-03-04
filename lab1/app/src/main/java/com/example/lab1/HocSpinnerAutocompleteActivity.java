package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import module.MonHoc;
import module.SinhVien;

public class HocSpinnerAutocompleteActivity extends AppCompatActivity {
    Spinner SpinnerMonHoc;
    TextView txtMonHoc;
    ArrayList<String> arrMonHoc;
    ArrayAdapter<String> adapterMonHoc;
    ArrayList<MonHoc> arrMonHoc2;
    ArrayAdapter<MonHoc> adapterMonHoc2;
    EditText edtMaSv, edtTenSv, edtDiachi;
    Button btnSaveSv;
    ListView lvDanhSach;
    MonHoc monHoc = null;
    ArrayAdapter<SinhVien> adapterSinhVien;
    ArrayList<SinhVien> arrSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_spinner_autocomplete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        HandleEvents();
    }

    private void HandleEvents() {
        SpinnerMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                monHoc = adapterMonHoc2.getItem(position);
                txtMonHoc.setText(monHoc.getTenmh());
                adapterSinhVien.clear();
                adapterSinhVien.addAll(monHoc.getDsSinhVien());
                adapterSinhVien.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnSaveSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setMasv(edtMaSv.getText().toString());
                sv.setTensv(edtTenSv.getText().toString());
                sv.setDiachi(edtDiachi.getText().toString());
                arrSinhVien.add(sv);
                monHoc.getDsSinhVien().add(sv);
                adapterSinhVien.notifyDataSetChanged();
            }
        });
    }

    private void addControls() {
        txtMonHoc = findViewById(R.id.textView11);
        SpinnerMonHoc = findViewById(R.id.spinner10);
        edtMaSv = findViewById(R.id.editTextText4);
        edtTenSv = findViewById(R.id.editTextText7);
        edtDiachi = findViewById(R.id.editTextText6);
        btnSaveSv = findViewById(R.id.button10);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        arrMonHoc = new ArrayList<>();
        arrMonHoc.add("Android");
        arrMonHoc.add("Lap trinh co ban");
        arrMonHoc.add("Tin hoc van phong");
        arrMonHoc2 = new ArrayList<>();
        arrMonHoc2.add(new MonHoc("Android"));
        arrMonHoc2.add(new MonHoc("Nhap mon lap trinh"));
        arrMonHoc2.add(new MonHoc("Co so du lieu"));
        arrMonHoc2.add(new MonHoc("Xu ly anh"));

        adapterMonHoc2 = new ArrayAdapter<>(HocSpinnerAutocompleteActivity.this, android.R.layout.simple_spinner_dropdown_item,arrMonHoc2);
        SpinnerMonHoc.setAdapter(adapterMonHoc2);
        arrSinhVien = new ArrayList<>();
        adapterSinhVien = new ArrayAdapter<>(HocSpinnerAutocompleteActivity.this, android.R.layout.simple_list_item_1,arrSinhVien);
        lvDanhSach.setAdapter(adapterSinhVien);
    }
}