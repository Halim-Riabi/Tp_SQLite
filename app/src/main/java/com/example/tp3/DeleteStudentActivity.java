package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteStudentActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        Button delete=findViewById(R.id.delete);
        EditText identifiant=findViewById(R.id.edidentifiant);
        Context context=this;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(identifiant.getText().toString()!=""){
                    DeleteStudent(Integer.parseInt(identifiant.getText().toString()));
                    Intent i=new Intent(context, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(context,"veilleez saisir l'identifiant d'etudiant",Toast.LENGTH_SHORT);
                }
            }
        });

    }

    private void DeleteStudent(int id) {
        Helper helper =new Helper(DeleteStudentActivity.this);
        helper.deleteEtudiant(id);
    }
}