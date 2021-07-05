package com.example.sqlitedata_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    DataBaseHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.addBtn);
        btn2=findViewById(R.id.viewBtn);
        btn3=findViewById(R.id.update);
        btn4=findViewById(R.id.delete);

        db1=new DataBaseHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db1.addStudent(new Student("Manasi","Pune","manasi@gmail.com"));

                Toast.makeText(MainActivity.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewAllStudent.class));

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db1.updateStudent(new Student("Sanjana","Mumbai","sanjana@gmail.com"));
                Toast.makeText(MainActivity.this,"Updated Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db1.deleteStudent("Manasi");
                Toast.makeText(MainActivity.this,"Deleted Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void readData()
    {
        List<Student> studentList=new ArrayList<>();

        studentList=db1.ViewAllStudent();
        String studentdata="";

        for (Student st:studentList)
        {
            studentdata="Name:"+st.getName()+" Address:"+st.getAddress()+" Email:"+st.getEmail();
            Log.d("Student",studentdata);
        }




    }
}