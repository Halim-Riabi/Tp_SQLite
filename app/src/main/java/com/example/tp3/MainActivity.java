package com.example.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Gestion> gestion = new ArrayList<>();
        gestion.add(new Gestion("add", R.drawable.add));
        gestion.add(new Gestion("delete", R.drawable.delete));
        gestion.add(new Gestion("update", R.drawable.update));
        gestion.add(new Gestion("view", R.drawable.view));
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.item_view, gestion);
        ListView list = findViewById(R.id.list);
        Context context = this;
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Gestion item = (Gestion) adapterView.getItemAtPosition(i);
                if (item.getMethode().equals("add")) {
                    Intent intent = new Intent(context, AddStudentActivity.class);
                    startActivity(intent);
                } else if (item.getMethode().equals("delete")) {
                    Intent intent = new Intent(context, DeleteStudentActivity.class);
                    startActivity(intent);
                } else if (item.getMethode().equals("update")) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    startActivity(intent);

                } else if (item.getMethode().equals("view")) {
                    String students = view();
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Student List");
                    builder.setMessage(students);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();

                }

            }
        });

    }

    @NonNull
    private String view() {
        Helper dbHelper = new Helper(getApplicationContext());
        Cursor cursor = dbHelper.getAllEtudiants();
        StringBuilder studentsInfo = new StringBuilder();
        if (cursor != null && cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex("_id");
            int nameColumnIndex = cursor.getColumnIndex("name");
            int lastNameColumnIndex = cursor.getColumnIndex("lastName");
            int markColumnIndex = cursor.getColumnIndex("mark");
            do {
                int idd = cursor.getInt(idColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                String lastName = cursor.getString(lastNameColumnIndex);
                int mark = cursor.getInt(markColumnIndex);
                studentsInfo
                        .append("ID: ").append(idd)
                        .append(", Prénom: ").append(name)
                        .append(", Nom: ").append(lastName)
                        .append(", Note: ").append(mark)
                        .append("\n");
            } while (cursor.moveToNext());
            cursor.close();
        } else {
            // Aucun étudiant trouvé dans la base de données
            studentsInfo.append("Aucun étudiant trouvé.");

        }
        return studentsInfo.toString();
    }
}