package com.javarush.task.task36.task3608.model;

import java.util.*;
import com.javarush.task.task36.task3608.bean.*;

public class ModelData {
    private List<User> users = new ArrayList();
    
    public void setUsers(List<User> users){
        this.users = users;
    }
    
    public List<User> getUsers(){
        return users;
    }
}