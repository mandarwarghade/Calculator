package com.app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button mul;
    private Button div;
    private Button add;
    private Button sub;
    private Button clear;
    private Button equal;
    private TextView info;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btnzero);
        add = findViewById(R.id.btnadd);
        sub = findViewById(R.id.btnsub);
        mul = findViewById(R.id.btnmul);
        equal = findViewById(R.id.btnequal);
        div = findViewById(R.id.btndiv);
        info = findViewById(R.id.tvControll);
        result = findViewById(R.id.tvResult);
        clear = findViewById(R.id.btnclear);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() == 0 && result.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "First enter the number", Toast.LENGTH_SHORT).show();
                } else if (result.getText().length() != 0) {

                    ACTION = ADDITION;
                    result.setText(String.valueOf(val1) + " +");

                } else {
                    compute();
                    ACTION = ADDITION;
                    result.setText(String.valueOf(val1) + " +");
                    info.setText(null);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() == 0 && result.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "First enter the number", Toast.LENGTH_SHORT).show();
                } else if (result.getText().length() != 0) {

                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + " -");

                } else {
                    compute();
                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + " -");
                    info.setText(null);
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() == 0 && result.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "First enter the number", Toast.LENGTH_SHORT).show();
                } else if (result.getText().length() != 0) {

                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + " *");

                } else {
                    compute();
                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + " *");
                    info.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() == 0 && result.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "First enter the number", Toast.LENGTH_SHORT).show();
                } else if (result.getText().length() != 0) {

                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + " /");

                } else {
                    compute();
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + " /");
                    info.setText(null);
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() == 0 && result.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "First enter the number", Toast.LENGTH_SHORT).show();
                } else {
                    compute();
                    ACTION = EQU;
                    result.setText(result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                    info.setText(null);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));

                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }

        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }


    }

}
