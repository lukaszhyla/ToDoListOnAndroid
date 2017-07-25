package com.lhyla.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.lhyla.todolist.adapter.ToDoListAdapter;
import com.lhyla.todolist.data.ToDoItem;
import com.lhyla.todolist.useful_methods.UsefulMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoListActivity extends AppCompatActivity {
    private ToDoListAdapter toDoListAdapter;
    private List<ToDoItem> taskList;
    private RecyclerView recyclerView;

    @BindView(R.id.act_to_do_list_task_edit_text)
    protected EditText taskContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        ButterKnife.bind(this);
        taskList = new ArrayList<>();

        //Here will be downloading data from databases

        recyclerView = (RecyclerView) findViewById(R.id.act_to_do_list_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        addToRecycleView(reverseList(taskList));
    }

    private void addToRecycleView(List<ToDoItem> taskList) {
        toDoListAdapter = new ToDoListAdapter(taskList, ToDoListActivity.this);
        recyclerView.setAdapter(toDoListAdapter);
    }

    private List<ToDoItem> reverseList(List<ToDoItem> toDoItemList) {
        ToDoItem[] itemsArray = new ToDoItem[toDoItemList.size()];
        itemsArray = toDoItemList.toArray(itemsArray);

        List<ToDoItem> reversedList = new ArrayList<>();
        for (int j = itemsArray.length - 1; j >= 0; j--) {
            reversedList.add(itemsArray[j]);
        }
        return reversedList;
    }

    @OnClick(R.id.act_to_do_list_add_task_btn)
    protected void addTaskBtn() {
        addTask();
    }

    private void addTask() {
        String taskContent = taskContentEditText.getText().toString();
        if (!taskContent.equals("")) {
            ToDoItem toDoItem = new ToDoItem();
            taskList.add(toDoItem);
            toDoItem.setTaskContent(taskContent);
            addToRecycleView(reverseList(taskList));
            UsefulMethods.printLogLH("ToDoListActivity addTaskBtn() added");
        } else {
            UsefulMethods.printLogLH("ToDoListActivity addTaskBtn() notAdded");
        }
    }
}
