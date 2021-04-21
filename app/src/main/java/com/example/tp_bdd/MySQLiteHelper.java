package com.example.tp_bdd; // A changer par votre package

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_NOTE_MATHS = "note_maths";
    public static final String COLUMN_NOTE_SVT = "note_SVT";
    public static final String COLUMN_NOTE_informatique = "note_informatique";
	// A vous de définir les autres colonnes...

    private static final String DATABASE_NAME = "epsinotes.db"; // Le plus logique est de donner le même nom que votre appli
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_PRENOM
            + " text not null, " + COLUMN_NOTE_MATHS + " text not null, " + COLUMN_NOTE_SVT + " text not null, " + COLUMN_NOTE_informatique + " text not null); "; // A vous de modifier la requête en ajoutant les autres colonnes


// C'est terminé pour cette classe, les méthodes ci-dessous sont des méthodes de base

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "MàJ de la version " + oldVersion + " vers "
                        + newVersion + ", les vieilles données ont été supprimées");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}