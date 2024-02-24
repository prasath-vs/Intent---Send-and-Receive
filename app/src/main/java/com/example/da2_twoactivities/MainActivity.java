package com.example.da2_twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("First Activity");

        EditText txt1=(EditText) findViewById(R.id.e1);
        Button b1=(Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=txt1.getText().toString();
                Intent in=new Intent(MainActivity.this,SecondActivity.class);
                in.putExtra("firstmsg",s1);
                startActivityForResult(in,3);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3) {
            TextView txt1=(TextView) findViewById(R.id.textView2);
            TextView txt2=(TextView) findViewById(R.id.t);
            String result=data.getStringExtra("reply");
            txt1.setText("Reply Received");
            txt2.setText(result);
            EditText txt3=(EditText) findViewById(R.id.e1);
            txt3.setText("");
        }
    }
}