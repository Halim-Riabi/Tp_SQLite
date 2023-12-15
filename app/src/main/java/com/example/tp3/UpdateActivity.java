package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Button update =findViewById(R.id.update);
        EditText id=(EditText) findViewById(R.id.editTextText);
        EditText newmark=(EditText) findViewById(R.id.markupdated);
        Context context=this;
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!id.getText().toString().equals("") && !newmark.getText().toString().equals("")) {
                updateStudent(Integer.parseInt(id.getText().toString()),Integer.parseInt(newmark.getText().toString()));
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
                    }
                else{
                Toast.makeText(context,"Veillez saisir correctement",Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    private void updateStudent(int id, int newmark) {
        Helper helper=new Helper(UpdateActivity.this);
        helper.updateEtudiant(id,newmark);
    }
}