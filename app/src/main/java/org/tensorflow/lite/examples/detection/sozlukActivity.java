package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class sozlukActivity extends AppCompatActivity {
    String languages[];
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sozluk);
        languages=getResources().getStringArray(R.array.languages);
        recyclerView=findViewById(R.id.recycler);
        Myadapter myadapter = new Myadapter(this, languages);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}