package com.example.appbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float get_weight, get_height, result_number = 0;
    Button btn_cal;
    TextView show_result_number, show_result_text;
    EditText weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getId() {
        btn_cal =findViewById(R.id.btn_cal);
        show_result_number = findViewById(R.id.show_result_number);
        show_result_text = findViewById(R.id.show_result_text);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
    }

    public String checkBMI(float bmi) {
        String result = null;
        if(bmi < 18) {
            result = "Người gầy";
        } else if(bmi < 24.9){
            result = "Người bình thường";
            } else if(bmi < 29.9) {
            result = "Người béo phì độ I";
                } else if(bmi < 34.9){
            result = "Người béo phì độ II";
                    }if(bmi > 35) {
            result = "Người béo phì độ III";
                    }

        return result;
    }

    public void btn_cal(View view) {

        getId();

        if(TextUtils.isEmpty(weight.getText().toString().trim()) || TextUtils.isEmpty(height.getText().toString().trim())) {
            Toast.makeText(this, "Bạn chưa nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            get_weight = Float.valueOf(weight.getText().toString());
            get_height = Float.valueOf(height.getText().toString());

                result_number = get_weight/(get_height*get_height);

                show_result_number.setText("BMI: " + String.valueOf(result_number));

                show_result_text.setText(checkBMI(result_number));
        }

    }
}