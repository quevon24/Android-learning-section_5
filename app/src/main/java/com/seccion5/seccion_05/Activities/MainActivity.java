package com.seccion5.seccion_05.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.seccion5.seccion_05.Fragments.DataFragment;
import com.seccion5.seccion_05.Fragments.DetailsFragment;
import com.seccion5.seccion_05.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private Boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();
    }

    @Override
    public void sendData(String text) {
        // Llamar al metodo renderizarTexto de el DetailsFragment
        // pasando el texto que recibimos por parametro en este mismo metodo

        if (isMultiPanel) {
            // Instancia al fragmento que se quiere comunicar
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }

    }

    private void setMultiPanel() {
        // Estan los dos fragment renderizados?
        // True si hay dos fragments
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

}
