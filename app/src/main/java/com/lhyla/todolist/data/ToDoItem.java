package com.lhyla.todolist.data;

public class ToDoItem {
    private int id;
    private String taskContent;
    private int isDone;

    public ToDoItem(int id, String taskContent, int isDone) {
        this.id = id;
        this.taskContent = taskContent;
        this.isDone = isDone;
    }

    public ToDoItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }
}
