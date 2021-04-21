package com.example.tp_bdd; // A remplacer par votre package


// A compléter avec les autres variables, leurs getters et leurs setters. Pensez que vous pouvez les générer automatiquement
public class Notes {
    private long id;
    private String prenom;
    private String note_maths;

    public String getNote_SVT() {
        return note_SVT;
    }

    public void setNote_SVT(String note_SVT) {
        this.note_SVT = note_SVT;
    }

    public String getNote_informatique() {
        return note_informatique;
    }

    public void setNote_informatique(String note_informatique) {
        this.note_informatique = note_informatique;
    }

    private String note_SVT;
    private String note_informatique;

    public String getNote_maths() {
        return note_maths;
    }

    public void setNote_maths(String note_maths) {
        this.note_maths = note_maths;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

}