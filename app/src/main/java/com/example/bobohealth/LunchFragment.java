package com.example.bobohealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LunchFragment extends Fragment {
    float totalCalories = 0;  // 用于保存总卡路里
    EditText calorieInput;
    TextView output;
    Button addButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lunch, container, false);

        calorieInput = view.findViewById(R.id.calorie);
        output = view.findViewById(R.id.out);
        addButton = view.findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalories();
            }
        });
        return view;
    }

    private void addCalories() {
        String input = calorieInput.getText().toString();
        if (!input.isEmpty()) {
            float calorie = Float.parseFloat(input);
            totalCalories += calorie;
            output.setText(String.format("午餐摄入：%.2f kcal", totalCalories));
        } else {
            Toast.makeText(getActivity(), "卡路里不可以为空", Toast.LENGTH_SHORT).show();
        }
    }
}