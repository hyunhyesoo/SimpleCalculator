package kr.ac.kopo.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btn_pl, btn_mi, btn_mu, btn_di, btn_mo;

    TextView text_rst;

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

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        btn_pl = findViewById(R.id.btn_pl);
        btn_mi = findViewById(R.id.btn_mi);
        btn_mu = findViewById(R.id.btn_mu);
        btn_di = findViewById(R.id.btn_di);
        btn_mo = findViewById(R.id.btn_mo);

        btn_pl.setOnClickListener(btnListener);
        btn_mi.setOnClickListener(btnListener);
        btn_mu.setOnClickListener(btnListener);
        btn_di.setOnClickListener(btnListener);
        btn_mo.setOnClickListener(btnListener);

        text_rst = findViewById(R.id.txt);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button eBtn = (Button) v;
            String str1 = edit1.getText().toString();
            String str2 = edit2.getText().toString();
            if (str1.equals("") || str2.equals("")) {
                Toast.makeText(getApplicationContext(), "숫자가 입력되지 않았습니다", Toast.LENGTH_SHORT).show();
                return;
            }
            double inputNum1 = Double.parseDouble(str1);
            double inputNum2 = Double.parseDouble(str2);
            double result = 0;

            if(eBtn == btn_pl){
                result = inputNum1 + inputNum2;
            } else if (eBtn == btn_mi) {
                result = inputNum1 - inputNum2;
            } else if (eBtn == btn_mu) {
                result = inputNum1 * inputNum2;
            } else if (eBtn == btn_di){
                if(inputNum2 == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = inputNum1 / inputNum2;
            } else {
                if(inputNum2 == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = inputNum1 % inputNum2;
            }
            text_rst.setText(String.format("계산 결과: %.3f", result));
        }
    };
}