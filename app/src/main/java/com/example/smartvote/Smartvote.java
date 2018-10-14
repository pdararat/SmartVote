package com.example.smartvote;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Smartvote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartvote);

        final Button smartvote = findViewById(R.id.button);
        smartvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText TextNumberEditText = findViewById(R.id.TextNumber);
                String Number = TextNumberEditText.getText().toString();
                if (Number.length() != 13) {
                    String massage = "กรุณากรอกหมายเลขบัตรประชาชน13หลัก";
                    Toast num = Toast.makeText(Smartvote.this, massage, Toast.LENGTH_LONG);
                    num.show();
                }
                else if(Number.length()==13) {
                    String print = " " ;
                    if (Number.equals("1111111111111")||Number.equals("2222222222222")){
                        print = "คุณเป็นผู้มีสิทธิเลือกตั้ง";
                    }
                    else {
                        print = "คุณไม่มีสิทธิเลือกตั้ง";
                    }
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Smartvote.this);
                    dialog.setTitle("ผลการตรวจสบสิทธิเลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.setCancelable(false);
                    dialog.show();
                }
            }

            });
    }

private boolean ssNumber(String Number) {
    char a = Number.charAt(0);
    int b = 0;
    int c = Number.length();
    for (int i = 0; i < c; i++) {
        if (Number.charAt(i) == a) {
            b++;
        }
    }
    if (b != c) {
        return false;
    } else {
        return true;
    }
  }
}
