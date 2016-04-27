package com.example.hb2006.helloandroid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hb2006 on 2016-04-27.
 */
public class MemberActicity extends Activity implements View.OnClickListener{
    private static final String PROVIDER_URI =
            "content://com.superdroid.StudentsProvider";
    final MemberDAO = new MemberDAT(getApplicationContext(), "member.db" , null , 1);
    TextView result = (TextView) findViewById(R.id.result);
    EditText joinUid = (EditText) findViewById(R.id.joinUid);
    EditText joinPassword = (EditText) findViewById(R.id.joinPassword);
    EditText joinName = (EditText) findViewById(R.id.joinName);
    EditText looinUid = (EditText) findViewById(R.id.looinUid);
    EditText looinPassword = (EditText) findViewById(R.id.looinPassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);
        (Button)findViewById(R.id.joinBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String uid = joinUid.getText().toString();
                String password = joinPassword.getText().toString();
                String name = joinName.getText().toString();

                memberDAO.insert(uid, password, name);
                result.setText(memberDAO.getResult());
            }
            });
            (Button)findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    String uid = loginUid.getText().toString();
                    String password = loginPassword.getText().toString();
                    result.setText(memberDAO.getResult());
                }
             });
        (Button)findViewById(R.id.boardBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });
        (Button)findViewById(R.id.writeBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });
    }
        /*Button joinBtn = (Button)findViewById(R.id.joinBtn);
        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        Button boardBtn = (Button)findViewById(R.id.boardBtn);
        Button writeBtn = (Button)findViewById(R.id.writeBtn);
        */
    /*joinBtn.setOnClickListener(this);*/
    }

    public void join(View view){
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(
                "com.example.hb2006.helloandroid","com.example.hb2006.helloandroid.Join");
        intent.setComponent(componentName);
        startActivity(intent);

    }

    public  void login(View view){
        Intent intent = new Intent();
        ComponentName name = new ComponentName(
                "com.example.hb2006.helloandroid","com.example.hb2006.helloandroid.Login");

        intent.setComponent(name);
        startActivity(intent);
    }

    public  void board(View view){
        Intent intent = new Intent();
        ComponentName name = new ComponentName(
                "com.example.hb2006.helloandroid","com.example.hb2006.helloandroid.Board");

        intent.setComponent(name);
        startActivity(intent);
    }

    public  void write(View view){
        Intent intent = new Intent();
        ComponentName name = new ComponentName(
                "com.example.hb2006.helloandroid","com.example.hb2006.helloandroid.Write");

        intent.setComponent(name);
        startActivity(intent);
    }

    public void clickJoinBtn(View view){
        switch (view.getId()){
            case R.id.join_btn : {
                ContentValues val = new ContentValues();
                val.put("uid","hong");
                val.put("password","1");
                val.put("name","홍길동");
                getContentResolver().insert(Uri.PROVIDER_URI);
            }
            case R.id.show_join_query :{

            }
        }
    }
}