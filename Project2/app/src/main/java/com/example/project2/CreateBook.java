package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class CreateBook extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText text1,text2,text3,text4,text5;
    Stack<String> bookStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);
        dbHelper = new DataHelper(this);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        text5=(EditText) findViewById(R.id.editText5);
        text5=(EditText) findViewById(R.id.editText5);
        bt1=(Button) findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);
        bookStack = new Stack<>();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(id_b,title,writer,synopsis,availability) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString()+"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString()+"','" +
                        text5.getText().toString()+"')");

                String bookTitle = text2.getText().toString(); // Get the book title
                bookStack.push(bookTitle); // Push the book title onto the Stack

                Toast.makeText(getApplicationContext(),"Book has successfully been inserted",
                        Toast.LENGTH_LONG).show();
                Booklist.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
//TODO Auto-generated method stub
            finish();
        }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

