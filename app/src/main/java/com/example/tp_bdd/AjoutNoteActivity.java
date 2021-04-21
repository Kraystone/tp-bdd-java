package com.example.tp_bdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.sql.DataSource;

public class AjoutNoteActivity extends AppCompatActivity {
    private EditText Prenom;
    private EditText Note_maths;
    private EditText Note_SVT;
    private EditText Note_informatique;
    private Button BTN_Enregistrer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_note);
        Prenom = (EditText) findViewById(R.id.TN_Prenom);
        Note_maths = (EditText) findViewById(R.id.TN_Note_maths);
        Note_SVT = (EditText) findViewById(R.id.TN_Note_SVT);
        Note_informatique = (EditText) findViewById(R.id.TN_Note_informatique);
        BTN_Enregistrer = (Button) findViewById(R.id.BTN_Enregistrer);
        NotesDataSource datasource = new NotesDataSource(this);
        datasource.open();

        BTN_Enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Prenom1 = Prenom.getText().toString();
                String Note_SVT1 = Note_SVT.getText().toString();
                String Note_informatique1 = Note_informatique.getText().toString();
                String Note_Maths1 = Note_maths.getText().toString();
                datasource.createNotes(Prenom1, Note_SVT1, Note_informatique1, Note_Maths1);

            }
        });
    }
}