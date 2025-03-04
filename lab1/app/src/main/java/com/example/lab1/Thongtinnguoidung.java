package com.example.lab1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Thongtinnguoidung extends AppCompatActivity {

    private EditText cmnd, name, address;
    private CheckBox book, travel, music;
    private RadioButton male, female, other;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thongtinnguoidung);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        onListen();
    }

    // Khởi tạo các View
    private void initViews() {
        cmnd = findViewById(R.id.editTextNumbercmnd);
        name = findViewById(R.id.editTextNumbername);
        address = findViewById(R.id.editTextNumberaddress);

        book = findViewById(R.id.checkBoxB);
        travel = findViewById(R.id.checkBoxT);
        music = findViewById(R.id.checkBoxM);

        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        other = findViewById(R.id.radioButton4);

        textViewResult = findViewById(R.id.textView10);
    }

    private void onListen() {
        findViewById(R.id.buttonupdate).setOnClickListener(this::onUpdate);
        findViewById(R.id.buttonreact).setOnClickListener(this::onReact);
        findViewById(R.id.imageButtonclose).setOnClickListener(this::onClose);
    }

    private void onClose(View view) {

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);


        Button btnYes = dialog.findViewById(R.id.btn_yes);
        Button btnNo = dialog.findViewById(R.id.btn_no);
        TextView title = dialog.findViewById(R.id.dialog_title);
        TextView message = dialog.findViewById(R.id.dialog_message);


        btnYes.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });


        btnNo.setOnClickListener(v -> dialog.dismiss());


        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialog.show();
    }

    private void onReact(View view) {
        // Xóa dữ liệu nhập
        cmnd.setText("");
        name.setText("");
        address.setText("");

        // Bỏ chọn CheckBox và RadioButton
        book.setChecked(false);
        travel.setChecked(false);
        music.setChecked(false);

        male.setChecked(false);
        female.setChecked(false);
        other.setChecked(false);

        // Xóa kết quả hiển thị
        textViewResult.setText("");

        Toast.makeText(this, "Đã reset thông tin", Toast.LENGTH_SHORT).show();
    }

    private void onUpdate(View view) {
        String cmndText = cmnd.getText().toString().trim();
        String nameText = name.getText().toString().trim();
        String addressText = address.getText().toString().trim();

        // Kiểm tra nhập đủ thông tin chưa
        if (nameText.isEmpty() || cmndText.isEmpty() || addressText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra họ tên và địa chỉ chỉ chứa chữ cái
        if (!nameText.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            Toast.makeText(this, "Họ tên chỉ được chứa chữ cái!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!addressText.matches("[a-zA-ZÀ-Ỹà-ỹ0-9\\s,]+")) {
            Toast.makeText(this, "Địa chỉ không hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ghi dữ liệu vào textView
        StringBuilder result = new StringBuilder();
        result.append("Họ tên: ").append(nameText).append("\n");
        result.append("CMND: ").append(cmndText).append("\n");
        result.append("Địa chỉ: ").append(addressText).append("\n");

        // Sở thích
        result.append("Sở thích: ");
        if (book.isChecked()) result.append("Book ");
        if (travel.isChecked()) result.append("Travel ");
        if (music.isChecked()) result.append("Music ");
        result.append("\n");

        // Giới tính
        result.append("Giới tính: ");
        if (male.isChecked()) {
            result.append("Nam");
        } else if (female.isChecked()) {
            result.append("Nữ");
        } else if (other.isChecked()) {
            result.append("Khác");
        }
        result.append("\n");

        // Hiển thị kết quả
        textViewResult.setText(result.toString());

        Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
    }
}
