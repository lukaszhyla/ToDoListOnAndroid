package com.lhyla.todolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lhyla.todolist.R;
import com.lhyla.todolist.data.ToDoItem;
import com.lhyla.todolist.useful_methods.UsefulMethods;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.MyViewHolder> {
    private List<ToDoItem> taskList;

    public ToDoListAdapter(List<ToDoItem> taskList, Context context) {
        this.taskList = taskList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.to_do_item_row, parent, false);
        UsefulMethods.printLogLH("ToDoListAdapter onCreateViewHolder()");
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ToDoItem toDoItem = taskList.get(position);
        holder.taskContentTextView.setText(toDoItem.getTaskContent());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView taskContentTextView;
        private Button doneTaskBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
            taskContentTextView = (TextView) itemView.findViewById(R.id.row_to_do_item_task_content_text_view);
            doneTaskBtn = (CheckBox) itemView.findViewById(R.id.row_to_do_item_done_task_btn);
        }
    }


}
