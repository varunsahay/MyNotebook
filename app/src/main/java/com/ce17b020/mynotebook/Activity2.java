package com.ce17b020.mynotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public int myPriority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent i = getIntent();
        String str2=i.getStringExtra("k1");
        EditText e1 =(EditText) findViewById(R.id.editText3);
        e1.setText(str2);
        String title =i.getStringExtra("k2");
        EditText e2 = (EditText) findViewById(R.id.editText);
        e2.setText(title);
    }
    public void high(View view){
        myPriority=1;
    }
    public void medium(View view){
        myPriority=2;
    }
    public void low(View view){
        myPriority=3;
    }
    public void save(View v){
        String str ,title;
        String key="k1";
        String key2="k2";
        String p= "p1";
        String b="b1";
        boolean visible=true;
        EditText e1= (EditText)findViewById(R.id.editText3);
        EditText e2= (EditText)findViewById(R.id.editText);
        str= e1.getText().toString();
        title= e2.getText().toString();
        Intent i= new Intent(Activity2.this,Activity3.class);
        i.putExtra(key,str);
        i.putExtra(key2,title);
        i.putExtra(p,myPriority);
        i.putExtra(b,visible);
        startActivity(i);
    }




}
