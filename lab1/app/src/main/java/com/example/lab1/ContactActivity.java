package com.example.lab1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private Button btnSave, btnUpdate, btnDelete;
    private ListView lvContact;

    private ArrayList<String> contactList;
    private ArrayAdapter<String> adapter;
    private int selectedIndex = -1; // Lưu vị trí item đang được chọn

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Ánh xạ view
        editText1 = findViewById(R.id.editText1); // Mã
        editText2 = findViewById(R.id.editText2); // Tên
        editText3 = findViewById(R.id.editText3); // Số điện thoại

        btnSave = findViewById(R.id.button11);
        btnUpdate = findViewById(R.id.button15);
        btnDelete = findViewById(R.id.button14);
        lvContact = findViewById(R.id.listViewContacts);

        // Khởi tạo danh sách và adapter
        contactList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactList);
        lvContact.setAdapter(adapter);

        // Sự kiện khi nhấn nút Save
        btnSave.setOnClickListener(v -> {
            String ma = editText1.getText().toString().trim();
            String ten = editText2.getText().toString().trim();
            String sdt = editText3.getText().toString().trim();

            if (!ma.isEmpty() && !ten.isEmpty() && !sdt.isEmpty()) {
                String contact = "Mã: " + ma + " | Tên: " + ten + " | SĐT: " + sdt;
                contactList.add(contact);
                adapter.notifyDataSetChanged();
                clearFields(); // Xóa dữ liệu trên EditText sau khi thêm
            }
        });

        // Sự kiện khi chọn item trong ListView
        lvContact.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            String selectedContact = contactList.get(position);

            // Tách dữ liệu từ chuỗi hiển thị
            String[] parts = selectedContact.split("\\|");
            if (parts.length == 3) {
                editText1.setText(parts[0].replace("Mã:", "").trim());
                editText2.setText(parts[1].replace("Tên:", "").trim());
                editText3.setText(parts[2].replace("SĐT:", "").trim());
            }
        });

        // Sự kiện khi nhấn nút Update
        btnUpdate.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                String ma = editText1.getText().toString().trim();
                String ten = editText2.getText().toString().trim();
                String sdt = editText3.getText().toString().trim();

                if (!ma.isEmpty() && !ten.isEmpty() && !sdt.isEmpty()) {
                    String updatedContact = "Mã: " + ma + " | Tên: " + ten + " | SĐT: " + sdt;
                    contactList.set(selectedIndex, updatedContact);
                    adapter.notifyDataSetChanged();
                    clearFields(); // Xóa dữ liệu trên EditText sau khi cập nhật
                    selectedIndex = -1;
                }
            }
        });

        // Sự kiện khi nhấn nút Delete
        btnDelete.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                contactList.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                clearFields();
                selectedIndex = -1;
            }
        });
    }

    // Hàm xóa nội dung EditText
    private void clearFields() {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
    }
}
