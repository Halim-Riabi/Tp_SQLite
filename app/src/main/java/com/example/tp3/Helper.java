package com.example.tp3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Helper extends SQLiteOpenHelper {
    public Helper(Context context) {
        super(context, "etudiantManager", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE etudiant(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, lastName TEXT, mark INTEGER)");
    }
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS etudiant");
    onCreate(db);
}
    public void insertEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", etudiant.getName());
        values.put("lastName", etudiant.getLastName());
        values.put("mark", etudiant.getMark());
        db.insert("etudiant", null, values);
        db.close();
    }
    public void updateEtudiant(int id, int newMark) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mark", newMark);
        db.update("etudiant", values, "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteEtudiant(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("etudiant", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public Cursor getAllEtudiants() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM etudiant", null);
    }
}