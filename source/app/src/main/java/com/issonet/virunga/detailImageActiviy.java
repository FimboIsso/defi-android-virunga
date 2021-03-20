package com.issonet.virunga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.issonet.virunga.models.donnees;

public class detailImageActiviy extends AppCompatActivity {

    donnees myObject ;

    private TextView txt_titre,
            txt_description;
    private ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image_activiy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myObject = (donnees) getIntent().getSerializableExtra("myObject");
        setTitle(myObject.getTitle());


        txt_titre = findViewById(R.id.txt_titre);
        img_view = findViewById(R.id.img_view);
        txt_description = findViewById(R.id.txt_description);

        txt_titre.setText(myObject.getTitle());
        txt_description.setText(myObject.getDescription());
        img_view.setImageResource(myObject.getImage_url());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}