package com.example.sqlitedata_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private final static int DATA_BASE_VERSION=1;
    private final static String DATA_BASENAME="StudentDatabase";
    private final static String TABLE_NAME="student";
    private final static String name="name";
    private final static String address="address";
    private final static String email="email";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATA_BASENAME, null, DATA_BASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table="CREATE TABLE "+TABLE_NAME+ "("+name+
                " varchar(100), "+address+" varchar(100),"+email+" varchar"+" )";

        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }

    public void addStudent(Student student)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(name,student.getName());
        contentValues.put(address,student.getAddress());
        contentValues.put(email,student.getEmail());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();


    }

    public List<Student>ViewAllStudent()
    {
        List<Student> studentList=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String selectAllRecords="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(selectAllRecords,null);

        if (cursor.moveToFirst())
        {


            do {
                Student student=new Student();
                student.setName(cursor.getString(0));
                student.setAddress(cursor.getString(1));
                student.setEmail(cursor.getString(2));

                studentList.add(student);

            }while (cursor.moveToNext());
        }

        return studentList;
    }

    public void updateStudent(Student student)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

      //  contentValues.put(name,student.getName());
        contentValues.put(address,student.getAddress());
        contentValues.put(email,student.getEmail());

        sqLiteDatabase.update(TABLE_NAME,contentValues,name +"=?",new String[]{student.getName()});

        sqLiteDatabase.close();

    }

    public void deleteStudent(String name1)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,name+"=?",new String[]{name1

        });
        sqLiteDatabase.close();
    }
}











