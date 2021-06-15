package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.FakeModel;

public class Controller {
    private Model model;
    
    public void setModel(Model model){
        this.model = model;
    }
    
    public void onShowAllUsers(){
        
        model.loadUsers();
    }
}