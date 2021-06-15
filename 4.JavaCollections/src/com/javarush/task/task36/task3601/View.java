package com.javarush.task.task36.task3601;

import java.util.*;

public class View {
    public Controller controller = new Controller();
    
    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }
    
    
}