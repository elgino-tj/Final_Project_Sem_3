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

public class UpdateBook extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText text1,text2,text3,text4,text5;
    Stack<String> bookStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);
        dbHelper = new DataHelper(this);
        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        text5=(EditText) findViewById(R.id.editText5);
        bookStack = new Stack<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE title = '" + getIntent().getStringExtra("title") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update biodata set title='" +
                        text2.getText().toString() + "', writer='" +
                        text3.getText().toString() + "', synopsis='" +
                        text4.getText().toString() + "', availability='" +
                        text5.getText().toString() + "' where id_b='" +
                        text1.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Sucessfully updated", Toast.LENGTH_LONG).show();
                Booklist.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public boolean onCreateOptionMenu(Menu menu) {
//Inflate the menu: this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
