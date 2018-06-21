package com.ce17b020.mynotebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class Activity3 extends AppCompatActivity {
   public int myPriority;
   public boolean visible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent i = getIntent();
        myPriority= i.getIntExtra("p1",0);
        visible=i.getBooleanExtra("b1",true);
        String str2;
        str2 = i.getStringExtra("k1");
        TextView t1 =(TextView)findViewById(R.id.textView);
        t1.setText(str2);
        String title;
        title=i.getStringExtra("k2");
        TextView t2 = (TextView)findViewById(R.id.textView2);
        t2.setText(title);
    }
    public void edit(View v){
        Intent i = new Intent(Activity3.this,Activity2.class);
        TextView t1 = (TextView)findViewById(R.id.textView);
        TextView t2 = (TextView)findViewById(R.id.textView2);
        String title = t2.getText().toString();
        String str = t1.getText().toString();
        String key="k1";
        String key2="k2";
        i.putExtra(key,str);
        i.putExtra(key2,title);
        startActivity(i);
    }
    public void home(View view){
        Intent intent= new Intent(Activity3.this,MainActivity.class);
        TextView t1 = (TextView)findViewById(R.id.textView);
        TextView t2 = (TextView)findViewById(R.id.textView2);
        String title = t2.getText().toString();
        String str = t1.getText().toString();
        String key="k1";
        String key2="k2";
        String p="p1";
        String b="b1";
        intent.putExtra(key,str);
        intent.putExtra(key2,title);
        intent.putExtra(p,myPriority);
        intent.putExtra(b,visible);
        startActivity(intent);

    }
    public void share(View view){
        TextView t1= (TextView)findViewById(R.id.textView2);
        String title= t1.getText().toString();
        TextView t2= (TextView)findViewById(R.id.textView);
        String content= t2.getText().toString();
        String message=title+"- \n"+content;
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(whatsappIntent);
    }

    }

