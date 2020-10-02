package com.example.Shabir_Ahmad142_appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DataOperations extends AppCompatActivity {
    Button dataEntry;
    Button dataValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_operations);
        dataEntry= (Button)findViewById(R.id.data_entry_button);

        dataEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Dashboard.class);
                startActivity(intent);
            }
        });


        dataValidation = (Button)findViewById(R.id.data_validation_button);
        dataValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DataValidation.class);
                startActivity(intent);
            }
        });

    }


}

