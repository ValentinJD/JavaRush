package com.javarush.task.task36.task3608.model;

import java.util.*;
import com.javarush.task.task36.task3608.bean.User;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    
    public ModelData getModelData(){
        return modelData;
    }
    
    public void loadUsers(){
        modelData.getUsers().add(new User("Иван", 0, 0));
        modelData.getUsers().add(new User("Петр", 1, 1));
    }
    
}