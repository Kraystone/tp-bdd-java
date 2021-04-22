package com.example.tp_bdd; // A remplacer par votre package

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NotesDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_PRENOM, MySQLiteHelper.COLUMN_NOTE_MATHS, MySQLiteHelper.COLUMN_NOTE_SVT, MySQLiteHelper.COLUMN_NOTE_informatique}; //ajouter vos colonnes...

    public NotesDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Notes createNotes(String prenom, String note_maths, String note_SVT, String note_informatique) { // ajouter vos variables. Perso, j'ai utilisé des float pour les notes (décimaux)
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_PRENOM, prenom);
        values.put(MySQLiteHelper.COLUMN_NOTE_MATHS, note_maths);
        values.put(MySQLiteHelper.COLUMN_NOTE_SVT, note_SVT);
        values.put(MySQLiteHelper.COLUMN_NOTE_informatique, note_informatique);

        long insertId = database.insert(MySQLiteHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Notes newNotes = cursorToNotes(cursor);
        cursor.close();
        return newNotes;
    }

    public List<Notes> getAllNotes() {
        List<Notes> notes = new ArrayList<Notes>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Notes note = cursorToNotes(cursor);
            notes.add(note);
            cursor.moveToNext();
        }

        cursor.close();
        return notes;
    }

    private Notes cursorToNotes(Cursor cursor) {
        Notes notes = new Notes();
        notes.setId(cursor.getLong(0));
        notes.setPrenom(cursor.getString(1));
        notes.setNote_maths(cursor.getString(2));
        notes.setNote_SVT(cursor.getString(3));
        notes.setNote_informatique(cursor.getString(4));
        // Ajouter vos setters
        return notes;
    }
    public void deleteNote(long id) {
        System.out.println("Suppression des notes avec l'ID : " + id);
        database.delete(MySQLiteHelper.TABLE_NAME, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }
}