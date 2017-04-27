package com.example.ghana.lifeline;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class search extends AppCompatActivity {
    Button filter;
    TextView blood;
    Spinner s3;
    String selection;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        filter=(Button)findViewById(R.id.filter);
        blood=(TextView)findViewById(R.id.blood);
        s3=(Spinner)findViewById(R.id.s3);
        db=openOrCreateDatabase("records", Context.MODE_PRIVATE,null);
        final String[] blood=new String[]{"Select One","A+","A-","B+","B-","O+","O-","AB+","AB-","A1+","A1-","A2+","A2-","A1B+","A1B-","A2B+","A2B-"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(search.this,android.R.layout.simple_spinner_item,blood);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selection=blood[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s3.setAdapter(adapter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.rawQuery("SELECT * FROM DETAILS WHERE BLOOD='" +selection+ "'",null);
                if(c.moveToFirst()){
                    Intent intent=new Intent(search.this,Donors.class);
                    intent.putExtra("BLOOD",selection);
                    startActivity(intent);
                }
            }
        });
    }
}
