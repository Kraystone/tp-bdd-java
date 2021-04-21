package com.example.tp_bdd; // Votre package

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AffichageNotesActivity extends ListActivity {
    private NotesDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations); //Votre layout où est votre ListView
        datasource = new NotesDataSource(this);
        datasource.open();
        List<Notes> values = datasource.getAllNotes();

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int compteur=0; compteur<values.size();compteur++){
            HashMap<String,String> temp = new HashMap<String,String>();
            temp.put("prenom",values.get(compteur).getPrenom());
            temp.put("note_maths",values.get(compteur).getNote_maths());
            temp.put("note_SVT",values.get(compteur).getNote_SVT());
            temp.put("note_informatique",values.get(compteur).getNote_informatique());
			//vos variables

            list.add(temp);
        }

        setContentView(R.layout.activity_informations);
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.listview_personnalisee, // Nom du fichier de votre ListView personnalisée
                new String[] {"prenom", "note_maths", "note_SVT", "note_informatique"}, // à compléter avec vos autres variables
                new int[] {R.id.prenom, R.id.note_maths, R.id.note_SVT, R.id.note_informatique} // à compléter avec les ID vos TextView qui afficheront les valeurs
        );

        setListAdapter(adapter);

    }
}