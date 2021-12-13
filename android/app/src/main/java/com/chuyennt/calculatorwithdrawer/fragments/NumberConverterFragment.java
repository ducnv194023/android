package com.chuyennt.calculatorwithdrawer.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.chuyennt.calculatorwithdrawer.R;

public class NumberConverterFragment extends Fragment {
    private int temp;
    private String result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_converter, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);
        EditText editText = view.findViewById(R.id.editTextTextPersonName);
        Button btHandle = view.findViewById(R.id.button);
        TextView rs1 = view.findViewById(R.id.textView4);
        TextView rs2 = view.findViewById(R.id.textView5);
        TextView rs3 = view.findViewById(R.id.textView6);
        TextView rs4 = view.findViewById(R.id.textView7);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                result = "";
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                result = editText.getText().toString();
            }
        });

        btHandle.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (Integer.parseInt(String.valueOf(spinner.getSelectedItem()))) {
                    case 2: {
                        if (result.matches("[01]*")) {
                            temp = Integer.parseInt(result, 2);
                            System.out.println(Integer.toOctalString(temp));
                            rs1.setText("Binary : " + Integer.toBinaryString(temp));
                            rs2.setText("Octal : " + Integer.toOctalString(temp));
                            rs3.setText("Decimal : " + temp);
                            rs4.setText("Hex : " + Integer.toHexString(temp));
                            break;
                        } else {
                            rs1.setText("Error");
                            rs2.setText("Error");
                            rs3.setText("Error");
                            rs4.setText("Error");
                        }
                        break;
                    }
                    case 8: {
                        if (result.matches("[01234567]*")) {
                            temp = Integer.parseInt(result, 8);
                            System.out.println(Integer.toOctalString(temp));
                            rs1.setText("Binary : " + Integer.toBinaryString(temp));
                            rs2.setText("Octal : " + Integer.toOctalString(temp));
                            rs3.setText("Decimal : " + temp);
                            rs4.setText("Hex : " + Integer.toHexString(temp));
                        } else {
                            rs1.setText("Error");
                            rs2.setText("Error");
                            rs3.setText("Error");
                            rs4.setText("Error");
                        }
                        break;
                    }
                    case 10: {
                        if (result.matches("[0123456789]*")) {
                            temp = Integer.parseInt(result);
                            System.out.println(Integer.toOctalString(temp));
                            rs1.setText("Binary : " + Integer.toBinaryString(temp));
                            rs2.setText("Octal : " + Integer.toOctalString(temp));
                            rs3.setText("Decimal : " + temp);
                            rs4.setText("Hex : " + Integer.toHexString(temp));
                        } else {
                            rs1.setText("Error");
                            rs2.setText("Error");
                            rs3.setText("Error");
                            rs4.setText("Error");
                        }
                        break;
                    }
                    case 16: {
                        if (result.matches("[0123456789abcdef]*")) {
                            temp = Integer.parseInt(result, 16);
                            System.out.println(Integer.toOctalString(temp));
                            rs1.setText("Binary : " + Integer.toBinaryString(temp));
                            rs2.setText("Octal : " + Integer.toOctalString(temp));
                            rs3.setText("Decimal : " + temp);
                            rs4.setText("Hex : " + Integer.toHexString(temp));
                        } else {
                            rs1.setText("Error");
                            rs2.setText("Error");
                            rs3.setText("Error");
                            rs4.setText("Error");
                        }
                        break;
                    }
                }
            }
        });
        return  view;
    }
}