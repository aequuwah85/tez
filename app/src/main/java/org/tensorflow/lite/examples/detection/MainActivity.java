package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import org.tensorflow.lite.examples.detection.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, textActivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetectorActivity.class);
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(this, sozlukActivity.class);
            startActivity(intent);
        });
    }
}