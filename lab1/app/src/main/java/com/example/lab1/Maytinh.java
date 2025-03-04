package com.example.lab1;

import static android.system.Os.close;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Maytinh extends AppCompatActivity {
    private double number1 = 0;
    private double number2 = 0;

    private char operator = '\0';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maytinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView text = findViewById(R.id.editTextNumber);
        text.setFocusable(false);
        text.setClickable(false);

        onListen();
    }

    private void onListen() {
        TextView text = findViewById(R.id.editTextNumber);
        DecimalFormat df1 = new DecimalFormat("#.#");
        DecimalFormat df2 = new DecimalFormat("#.##");

        findViewById(R.id.buttonequal).setOnClickListener(this::onEqual);
        findViewById(R.id.buttonclear).setOnClickListener(this::onClear);
        findViewById(R.id.buttonclose).setOnClickListener(this::onClose);


        findViewById(R.id.buttonplus).setOnClickListener(this::onClick);
        findViewById(R.id.buttonplus).setOnClickListener(view -> operator = '+');
        findViewById(R.id.buttonsubstract).setOnClickListener(this::onClick);
        findViewById(R.id.buttonsubstract).setOnClickListener(view -> operator = '-');
        findViewById(R.id.buttonmulti).setOnClickListener(this::onClick);
        findViewById(R.id.buttonmulti).setOnClickListener(view -> operator = '*');
        findViewById(R.id.buttondivide).setOnClickListener(this::onClick);
        findViewById(R.id.buttondivide).setOnClickListener(view -> operator = '/');


        findViewById(R.id.button0).setOnClickListener(this::Round1);
        findViewById(R.id.button00).setOnClickListener(this::Round2);

        for (int i = 1; i < 10; i++) {
            findViewById(getResources().getIdentifier("button" + i, "id", getPackageName())).setOnClickListener(this::onNumber);
        }
    }

    private void onClick(View view) {
        TextView text = findViewById(R.id.editTextNumber);
        if (number1 != 0 && number2 != 0) {
            if (operator == '/') {
                number1 /= number2;
                text.setText(String.valueOf(number1));
            } else if (operator == '*') {
                number1 *= number2;
                text.setText(String.valueOf(number1));
            } else if (operator == '-') {
                number1 -= number2;
                text.setText(String.valueOf(number1));
            } else if (operator == '+') {
                number1 += number2;
                text.setText(String.valueOf(number1));
            }
            operator = '\0';
            number2 = 0;
        }
    }


    private void Round2(View view) {
        TextView text = findViewById(R.id.editTextNumber);
        DecimalFormat df1 = new DecimalFormat("#.##");
        if (number1 != 0) {
            number1 = Double.parseDouble(df1.format(number1));
            text.setText(String.valueOf(number1));
        }
    }

    private void Round1(View view) {
        TextView text = findViewById(R.id.editTextNumber);
        DecimalFormat df1 = new DecimalFormat("#.#");
        if (number1 != 0) {
            number1 = Double.parseDouble(df1.format(number1));
            text.setText(String.valueOf(number1));
        }
    }

    private void onNumber(View view) {
        String buttonText = ((Button) view).getText().toString();
        TextView text = findViewById(R.id.editTextNumber);

        if (operator == '\0') {
            number1 *= 10;
            number1 += Double.parseDouble(buttonText);
            text.setText(String.valueOf(number1));
        } else {
            text.setHint("");
            number2 *= 10;
            number2 += Double.parseDouble(buttonText);
            text.setText(String.valueOf(number2));
        }
    }

    private void onClose(View view) {
        finish();
    }

    private void onClear(View view) {
        TextView text = findViewById(R.id.editTextNumber);
        number1 = 0;
        number2 = 0;
        text.setText("");
        text.setHint("Nhập số tại đây");
    }

    private void onEqual(View view) {
        TextView text = findViewById(R.id.editTextNumber);
        if (operator == '/') {
            if (number2 == 0) {
                showAlertDialog();
            } else {
                number1 /= number2;
                text.setText(String.valueOf(number1));
            }
        } else if (operator == '*') {
            number1 *= number2;
            text.setText(String.valueOf(number1));
        } else if (operator == '-') {
            number1 -= number2;
            text.setText(String.valueOf(number1));
        } else if (operator == '+') {
            number1 += number2;
            text.setText(String.valueOf(number1));
        } else {
            if (number1 != 0) {
                text.setText(String.valueOf(number1));
            }
        }
        operator = '\0';
        number2 = 0;
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage("Div/0");
    }
}