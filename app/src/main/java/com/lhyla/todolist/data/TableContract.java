package com.lhyla.todolist.data;

import android.provider.BaseColumns;
import android.provider.ContactsContract;

/**
 * Created by RENT on 2017-07-25.
 */

public class TableContract {
    private TableContract() {
    }

    public static class ToDoTable implements BaseColumns {
        public static final String TABLE_NAME = "ToDoTable";
        public static final String COL_TASK_CONTENT = "task";
        public static final String COL_IS_DONE = "isDone";
    }
}
