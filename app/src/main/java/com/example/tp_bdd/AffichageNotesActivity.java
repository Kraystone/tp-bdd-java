package com.example.tp_bdd; // Votre package

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AffichageNotesActivity extends ListActivity {
    private NotesDataSource datasource;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations); //Votre layout où est votre ListView
        datasource = new NotesDataSource(this);
        datasource.open();
        maj();
        listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //id de la liste
                HashMap item = (HashMap) parent.getItemAtPosition(position);
                String vraiId = "";
                Iterator iterator = item.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry mapEntry = (Map.Entry) iterator.next();
                    if (mapEntry.getKey().equals("id")) {
                        vraiId = (String) mapEntry.getValue();
                    }
                }
                datasource.deleteNote(Long.parseLong(vraiId));
                maj();
            }
        });
    }

    private void maj() {
        List<Notes> values = datasource.getAllNotes();

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for (int compteur = 0; compteur < values.size(); compteur++) {
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put("prenom", values.get(compteur).getPrenom());
            temp.put("note_maths", values.get(compteur).getNote_maths());
            temp.put("note_SVT", values.get(compteur).getNote_SVT());
            temp.put("note_informatique", values.get(compteur).getNote_informatique());
            temp.put("id", Long.toString(values.get(compteur).getId()));
            //vos variables

            list.add(temp);
        }

        setContentView(R.layout.activity_informations);
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.listview_personnalisee, // Nom du fichier de votre ListView personnalisée
                new String[]{"prenom", "note_maths", "note_SVT", "note_informatique"}, // à compléter avec vos autres variables
                new int[]{R.id.prenom, R.id.note_maths, R.id.note_SVT, R.id.note_informatique} // à compléter avec les ID vos TextView qui afficheront les valeurs
        );

        setListAdapter(adapter);
    }
}