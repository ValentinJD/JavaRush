package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.*;
import javax.swing.undo.UndoManager;
import javax.swing.undo.*;

public class UndoListener implements UndoableEditListener { // будет следить за правками
                                                            // , которые можно отменить или вернуть.
    private UndoManager undoManager;
    
    public void	undoableEditHappened(UndoableEditEvent e){
        UndoableEdit anEdit = e.getEdit(); // получаем правку
        undoManager.addEdit(anEdit); // добавляем в менеджер
    }
    
    public UndoListener(UndoManager undoManager){
        this.undoManager = undoManager;
    }
}