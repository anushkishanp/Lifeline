package com.example.ghana.lifeline;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class regist extends AppCompatActivity {
    private TextView error,error2;
    String selection;
    String selection1;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText name,age,dob,email,contact,password,address,pincode,city,confirm;
    private Button save;
    private Spinner getS1,getS2;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        error=(TextView)findViewById(R.id.error);
        error2=(TextView)findViewById(R.id.error2);
        final DatabaseReference root=FirebaseDatabase.getInstance().getReference();
        name = (EditText) findViewById(R.id.e1);
        age = (EditText) findViewById(R.id.e2);
        getS1 = (Spinner) findViewById(R.id.s1);
        getS2 = (Spinner) findViewById(R.id.s2);
        dob = (EditText) findViewById(R.id.e3);
        email = (EditText) findViewById(R.id.e4);
        contact = (EditText) findViewById(R.id.e5);
        password = (EditText) findViewById(R.id.e6);
        confirm = (EditText) findViewById(R.id.e7);
        address = (EditText) findViewById(R.id.e8);
        pincode = (EditText) findViewById(R.id.e9);
        city = (EditText) findViewById(R.id.e10);
        save = (Button) findViewById(R.id.b3);
        final String[] blood = new String[]{"Select One", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-", "A1+", "A1-", "A2+", "A2-", "A1B+", "A1B-", "A2B+", "A2B-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(regist.this, android.R.layout.simple_spinner_item, blood);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getS2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selection1 = blood[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getS2.setAdapter(adapter);
        final String[] sex = new String[]{"Select One", "Male", "Female", "Others"};
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(regist.this, android.R.layout.simple_spinner_item, sex);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getS1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selection = sex[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getS1.setAdapter(adapter1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !age.getText().toString().isEmpty() && !selection.equals("Select One") && !selection1.equals("Select One") && !dob.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !contact.getText().toString().isEmpty() && !password.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty() && !city.getText().toString().isEmpty()) {


                    if (password.getText().toString().equals(confirm.getText().toString())) {
                        String name1 = name.getText().toString().trim();
                        String age1 = age.getText().toString().trim();
                        String sex = selection;
                        String blood = selection1;
                        String dob1 = dob.getText().toString().trim();
                        String email1 = email.getText().toString().trim();
                        String contact1 = contact.getText().toString().trim();
                        String password1 = password.getText().toString().trim();
                        String address1 = address.getText().toString().trim();
                        String pincode1 = pincode.getText().toString().trim();
                        String city1 = city.getText().toString().trim();
                        final UserInformation userInformation=new UserInformation(name1,age1,sex,blood,dob1,email1,contact1,password1,address1,pincode1,city1);
                        if(blood.equals("A+")) {
                            final DatabaseReference ref = root.child("Donors").child("A+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                        if(blood.equals("A-")) {
                            final DatabaseReference ref = root.child("Donors").child("A-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("B+")) {
                            final DatabaseReference ref = root.child("Donors").child("B+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("B-")) {
                           final DatabaseReference ref = root.child("Donors").child("B-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("O+")) {
                            final DatabaseReference ref = root.child("Donors").child("O+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("O-")) {
                            final DatabaseReference ref = root.child("Donors").child("O-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("AB+")) {
                            final DatabaseReference ref = root.child("Donors").child("AB+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("AB-")) {
                            final DatabaseReference ref = root.child("Donors").child("AB-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A1+")) {
                            final DatabaseReference ref = root.child("Donors").child("A1").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A1-")) {
                            final DatabaseReference ref = root.child("Donors").child("A1-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A2+")) {
                            final DatabaseReference ref = root.child("Donors").child("A2+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A2-")) {
                            final DatabaseReference ref = root.child("Donors").child("A2-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A1B+")) {
                            final DatabaseReference ref = root.child("Donors").child("A1B+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A1B-")) {
                           final DatabaseReference ref = root.child("Donors").child("A1B-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A2B+")) {
                            final DatabaseReference ref = root.child("Donors").child("A2B+").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        if(blood.equals("A2B-")) {
                            final DatabaseReference ref = root.child("Donors").child("A2B-").child(contact1);
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        showMessage("Invalid Mobile Number!","Mobile number already registered.");
                                    }
                                    else{
                                        ref.setValue(userInformation);
                                        Intent intent = new Intent(regist.this, OTP.class);
                                        startActivity(intent);

                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }


                    } else {
                        error2.setHintTextColor(getResources().getColor(R.color.colorAccent));
                        error2.setHint("Passwords not matching");
                    }
                } else {
                    error.setHintTextColor(getResources().getColor(R.color.colorAccent));
                    error.setHint("*Fields cannot be left empty");
                }
            }

        });

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(regist.this,regist.class);
                startActivity(intent);
            }
        });
        builder.show();
    }

}






