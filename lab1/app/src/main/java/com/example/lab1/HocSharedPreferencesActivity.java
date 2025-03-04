package com.example.lab1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HocSharedPreferencesActivity extends AppCompatActivity {


    private EditText edtName, edtPass;
    private TextView txtErrName;
    private Button btnRegister, btnLogin;
    private CheckBox chkRemember;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "data_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_shared_preferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        HandleEvents();
    }

    private void addControls() {

        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        txtErrName = findViewById(R.id.txtErrName);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        chkRemember = findViewById(R.id.chkRemember);


        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    private void HandleEvents() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtName.getText().toString().trim();
                String password = edtPass.getText().toString().trim();

                // Kiểm tra ràng buộc
                if (username.isEmpty() || password.isEmpty()) {
                    txtErrName.setText("Không được để trống tên hoặc mật khẩu");
                    txtErrName.setVisibility(View.VISIBLE);
                    return;
                }

                if (password.length() <= 8) {
                    txtErrName.setText("Mật khẩu phải trên 8 ký tự");
                    txtErrName.setVisibility(View.VISIBLE);
                    return;
                }

                txtErrName.setVisibility(View.GONE);


                if (chkRemember.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(HocSharedPreferencesActivity.this);
                    builder.setTitle("Xác nhận");
                    builder.setMessage("Bạn có muốn lưu thông tin đăng nhập không?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", username);
                            editor.putString("password", password);
                            editor.apply();
                            Toast.makeText(HocSharedPreferencesActivity.this,
                                    "Đã lưu thông tin", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Không", null);
                    builder.show();
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtName.getText().toString().trim();
                String password = edtPass.getText().toString().trim();


                String savedUsername = sharedPreferences.getString("username", "");
                String savedPassword = sharedPreferences.getString("password", "");

                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    Toast.makeText(HocSharedPreferencesActivity.this,
                            "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(HocSharedPreferencesActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    txtErrName.setText("Tên đăng nhập hoặc mật khẩu không đúng");
                    txtErrName.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}