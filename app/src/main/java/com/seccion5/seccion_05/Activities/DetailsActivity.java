package com.seccion5.seccion_05.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seccion5.seccion_05.Fragments.DetailsFragment;
import com.seccion5.seccion_05.R;

public class DetailsActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().getExtras() != null) {
            text = getIntent().getStringExtra("text");
        }

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);


    }
}
