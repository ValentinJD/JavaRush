package com.javarush.task.task23.task2304;

/* 
Inner 3
*/
import java.util.*;

import static com.javarush.task.task23.task2304.MockDB.getFakeNames;
import static com.javarush.task.task23.task2304.MockDB.getFakeTasks;

public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
    
    private class TaskDataProvider implements DbDataProvider<Task> {
        public void refreshAllData(Map criteria){
            Solution.this.tasks = getFakeTasks(criteria);
        }
    }
    
    private class NameDataProvider implements DbDataProvider<String> {
        public void refreshAllData(Map criteria){
            Solution.this.names = getFakeNames(criteria);
        }
    }
}
