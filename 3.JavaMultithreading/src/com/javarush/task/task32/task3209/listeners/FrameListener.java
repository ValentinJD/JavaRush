package com.javarush.task.task32.task3209.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.javarush.task.task32.task3209.View;

public class FrameListener extends WindowAdapter { // слушатель закрытия окна
    private View view;
    
    public FrameListener(View view){
        this.view = view;
    }
    
    @Override
    public void	windowClosing(WindowEvent e){
        view.exit();
    }
    
   
}