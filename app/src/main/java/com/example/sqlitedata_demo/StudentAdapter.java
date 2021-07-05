package com.example.sqlitedata_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    List<Student> studentList;
    Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.student_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {

        Student student=studentList.get(position);
        holder.sname.setText(student.getName());
        holder.saddress.setText(student.getAddress());
        holder.semail.setText(student.getEmail());

        holder.supdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Student Updated"+student.getName(),Toast.LENGTH_LONG).show();
            }
        });
        holder.sdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Student Deleted"+student.getName(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView sname,saddress,semail;
        ImageView supdate,sdelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sname=itemView.findViewById(R.id.textView);
            saddress=itemView.findViewById(R.id.textView3);
            semail=itemView.findViewById(R.id.textView2);

            supdate=itemView.findViewById(R.id.imageView2);
            sdelete=itemView.findViewById(R.id.imageView);

        }
    }
}
