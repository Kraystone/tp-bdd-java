package com.example.tp_bdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button Voir_notes;
    private Button Ajouter_notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Voir_notes = (Button) findViewById(R.id.BTN_Voir_Notes);
        Ajouter_notes = (Button) findViewById(R.id.BTN_Ajouter_Notes);


        Ajouter_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrerNotes = new Intent(MainActivity.this, AjoutNoteActivity.class);
                startActivity(entrerNotes);
            }
        });
        Voir_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrerNotes1 = new Intent(MainActivity.this, AffichageNotesActivity.class);
                startActivity(entrerNotes1);
            }
        });
    }

}