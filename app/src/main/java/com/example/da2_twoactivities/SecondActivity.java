package com.example.da2_twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        Intent i=getIntent();
        String str=i.getStringExtra("firstmsg");
        TextView tx1=(TextView) findViewById(R.id.t1);
        tx1.setText(str);
        Button b1=(Button) findViewById(R.id.button);
        EditText t1=(EditText)findViewById(R.id.e);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=t1.getText().toString();
                Intent in=new Intent();
                in.putExtra("reply",str1);
                setResult(3,in);
                finish();
            }
        });
    }
}