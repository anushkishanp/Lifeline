package com.example.ghana.lifeline;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Map;

import static android.R.attr.data;
import static android.R.attr.value;

public class login extends AppCompatActivity {
    String login;
    private Button log;
    private TextView tv, tv1, tv2;
    private EditText et, et1;
    private Spinner s;
    private String select;
    private String mobile;
    private String password;
    private DatabaseReference mroot = FirebaseDatabase.getInstance().getReference("Donors");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log = (Button) findViewById(R.id.login);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et = (EditText) findViewById(R.id.et);
        et1 = (EditText) findViewById(R.id.et1);
        s = (Spinner) findViewById(R.id.s);
        final String[] blood = new String[]{"Select One", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-", "A1+", "A1-", "A2+", "A2-", "A1B+", "A1B-", "A2B+", "A2B-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(login.this, android.R.layout.simple_spinner_item, blood);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                login = blood[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s.setAdapter(adapter);


        log.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                select = login;
                mobile = et.getText().toString().trim();
                password = et1.getText().toString().trim();
                DatabaseReference ref=mroot.child(select).child(mobile);
                ref.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            UserInformation info=dataSnapshot.getValue(UserInformation.class);
                            String contact=info.getContact();
                            String pwd=info.getPassword();
                            if (password.equals(pwd)){
                                Intent intent=new Intent(login.this,search.class);
                                startActivity(intent);
                            }
                            else{
                                showMessage("Login Denied!","Incorrect Password.");
                            }
                        }
                        else{
                            showMessage1("Invalid User!","Mobile number is not registered");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

        });
    }


    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(login.this, login.class);
                startActivity(intent);
            }
        });
        builder.show();
    }
    public void showMessage1(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(login.this, regist.class);
                startActivity(intent);
            }
        });
        builder.show();
    }
}






