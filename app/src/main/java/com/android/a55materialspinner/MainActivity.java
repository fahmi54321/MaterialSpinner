package com.android.a55materialspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    MaterialSpinner spinner;
    List<Integer> listItems = new ArrayList<>();
    ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();

        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,listItems);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != -1){
                    int selected = Integer.parseInt(spinner.getItemAtPosition(i).toString());
                    if (selected %2 == 0){
                        spinner.setError("This is error message");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initItems() {
        for (int i=1;i<=100;i++){
            listItems.add(i);
        }
    }
}