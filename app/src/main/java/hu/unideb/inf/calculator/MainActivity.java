package hu.unideb.inf.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;

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

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void handleButtonPressed(View view) {
        Button button = (Button) view;

        switch (button.getText().toString()) {
            case "CE":
                resultTextView.setText("0");
                break;
            case "=": resultTextView.setText(
                        calculate(resultTextView.getText().toString())
                      ); break;
            default:
                resultTextView.append(button.getText().toString());
        }
    }

    private String calculate(String expression) {
        String[] splitExpression = expression.split("[+\\-*/]");
        int op1 = Integer.parseInt(splitExpression[0]);
        int op2 = Integer.parseInt(splitExpression[1]);

        String operator = expression.replace(splitExpression[0], "");
        operator = operator.replace(splitExpression[1], "");

        Log.d("TEXT_OP", "Operands:" + op1 + " " + operator + " " + op2);
        return "ERROR";
    }
}