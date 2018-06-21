package com.ce17b020.mynotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public int myPriority=4;
public boolean visible=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i= getIntent();
        String str2;
        str2 = i.getStringExtra("k1");
        TextView t1 =(TextView)findViewById(R.id.textView3);
        t1.setText(str2);
        String title;
        title=i.getStringExtra("k2");
        TextView t2 = (TextView)findViewById(R.id.textView4);
        t2.setText(title);
        Button b1=(Button)findViewById(R.id.button1);
        b1.setText(title);
        myPriority=i.getIntExtra("p1",0);
        TextView textView= (TextView)findViewById(R.id.textView2);
            switch(myPriority){
                case 1:textView.setBackgroundColor(getResources().getColor(R.color.high));break;
                case 2:textView.setBackgroundColor(getResources().getColor(R.color.medium));break;
                case 3:textView.setBackgroundColor(getResources().getColor(R.color.low));break;
                //default:textView.setBackgroundColor(getResources().getColor(R.color.medium));break;
            }
        visible=i.getBooleanExtra("b1",false);
            if(visible){
                b1.setVisibility(View.VISIBLE);
            }

    }
    public void note1(View v){
        Intent intent= new Intent(MainActivity.this,Activity3.class);
        TextView t1 = (TextView)findViewById(R.id.textView3);
        TextView t2 = (TextView)findViewById(R.id.textView4);
        String title = t2.getText().toString();
        String str = t1.getText().toString();
        String key="k1";
        String key2="k2";
        intent.putExtra(key,str);
        intent.putExtra(key2,title);
        startActivity(intent);
    }
    public void add(View v) {
        Intent i = new Intent(MainActivity.this, Activity2.class);
        startActivity(i);
    }
}
