package com.chuyennt.calculatorwithdrawer.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chuyennt.calculatorwithdrawer.R;

import java.util.ArrayList;

public class StandardCalFragment extends Fragment {

    private Button btCe;
    private Button btC;
    private ImageButton btBs;
    private Button btInverse;
    private TextView result;
    private TextView answer;
    private ArrayList<Double> num = new ArrayList<>();
    private ArrayList<String> op = new ArrayList<>();
    private int i = 0;
    private int j = 0;
    private boolean flag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_standard_cal, container, false);

        btCe = view.findViewById(R.id.buttonCe);
        btC = view.findViewById(R.id.buttonC);
        btBs = view.findViewById(R.id.buttonD);
        btInverse = view.findViewById(R.id.buttonInverse);
        result = view.findViewById(R.id.result);
        answer = view.findViewById(R.id.answer);

        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("0");
                result.setText("");
                i = 0;
                j = 0;
                num.clear();
                op.clear();
                flag = false;
            }
        });

        btCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("0");
            }
        });

        btInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().charAt(0) == '-') {
                    answer.setText(answer.getText().toString().substring(1));
                }
                else {
                    answer.setText("-"+answer.getText().toString());
                }
            }
        });

        btBs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.getText().toString().length() <= 1) {
                    answer.setText("0");
                }
                if (!answer.getText().toString().equals("0")) {
                    answer.setText(answer.getText().toString().substring(0,answer.getText().toString().length()-1));
                }
            }
        });

        for(int idButton = 0; idButton <=9; idButton++ ){
            int id = getResources().getIdentifier("button" + idButton, "id", getContext().getPackageName());
            View button = view.findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click(view);
                }
            });
        }

        for(int idButton = 10; idButton <=14; idButton++ ){
            int id = getResources().getIdentifier("button" + idButton, "id", getContext().getPackageName());
            View button = view.findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click1(view);
                }
            });
        }

        return view;
    }

    public void click(View view) {
        if (answer.getText().toString().equals("0")) {
            answer.setText("");
        }
        answer.setText(answer.getText().toString()+((Button)view).getText().toString());
    }

    public void click1(View view) {
        num.add(Double.parseDouble(answer.getText().toString()));
        op.add(((Button)view).getText().toString());
        if (flag) {
            result.setText(answer.getText().toString()+((Button)view).getText().toString());
            flag = false;
        } else {
            result.setText(result.getText().toString()+answer.getText().toString()+((Button)view).getText().toString());
        }
        answer.setText("0");
        if(((Button)view).getText().toString().equals("=")) {
            flag = true;
            if (op.get(j).equals("+")) {
                answer.setText(String.valueOf(num.get(i) + num.get(i+1)));
            } else if (op.get(j).equals("-")) {
                answer.setText(String.valueOf(num.get(i) - num.get(i+1)));
            } else if (op.get(j).equals("x")) {
                answer.setText(String.valueOf(num.get(i) * num.get(i+1)));
            } else if (op.get(j).equals("/")) {
                answer.setText(String.valueOf(num.get(i) / num.get(i+1)));
            }
            else answer.setText(String.valueOf(num.get(i)));
            num.clear();
            op.clear();
            i = 0;
            j = 0;
        }
    }
}