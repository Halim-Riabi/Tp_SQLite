package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Button add=findViewById(R.id.button);
        EditText nom=findViewById(R.id.ednom);
        EditText prenom=findViewById(R.id.edprenom);
        EditText note=findViewById(R.id.ednote);
        Context context=this;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nom.getText().toString().equals("") && !prenom.getText().toString().equals("") && !note.getText().toString().equals("")){
                    AddStudent(nom.getText().toString(),prenom.getText().toString(),Integer.parseInt(note.getText().toString()));
                    Intent i = new Intent(context, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(context,"Veillez saisir correctement",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AddStudent(String nom, String prenom, int note) {
        Etudiant nv=new Etudiant(-1,nom,prenom,note);
        Helper helper=new Helper(AddStudentActivity.this);
        helper.insertEtudiant(nv);
    }
}