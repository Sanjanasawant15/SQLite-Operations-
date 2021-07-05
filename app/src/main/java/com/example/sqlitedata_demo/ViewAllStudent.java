package com.example.sqlitedata_demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllStudent extends AppCompatActivity {
    List<Student> studentList;
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;
    DataBaseHelper db1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_student);

        recyclerView=findViewById(R.id.recycler_view);
        studentList=new ArrayList<>();
        db1=new DataBaseHelper(this);
        studentList=db1.ViewAllStudent();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentAdapter=new StudentAdapter(studentList,this);
        recyclerView.setAdapter(studentAdapter);
    }
}
