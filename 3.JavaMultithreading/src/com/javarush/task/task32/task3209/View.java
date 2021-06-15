package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener=new UndoListener(undoManager);


    public void showAbout(){ // диалоговое окно о программе
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Кудинов Валентин 2020");
    }

    public void update(){ // берем шнтмл документ у контроллера и отображаем его в htmlTextPane
        HTMLDocument htmlDocument = controller.getDocument();
        htmlTextPane.setDocument(htmlDocument);
    }

    public void selectHtmlTab(){ // выбирает вкладку Html
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public boolean isHtmlTabSelected(){ // выбрана ли вкладка HTML ее индекс 0
        int indexSelectedTab = tabbedPane.getSelectedIndex();
        return indexSelectedTab == 0;
    }
    
    public void undo(){ // отменяет последнее действие
       try{
           undoManager.undo();
       }catch(CannotUndoException e){
           ExceptionHandler.log(e);
       }
    }
    
    public void redo(){ // возвращает ранее отмененное действие
    try{
           undoManager.redo();
       }catch(CannotRedoException e){
           ExceptionHandler.log(e);
       }
    }

    public View(){
        try{
            setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }

    }
    
    public void resetUndo(){
        	undoManager.discardAllEdits();
    }
    
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    
    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
    
    public Controller getController(){
        return controller;
    }
    
    public UndoListener getUndoListener(){
        return undoListener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionString = e.getActionCommand();
        if (actionString.equals("Новый")){
            controller.createNewDocument();
        }else if (actionString.equals("Открыть")){
            controller.openDocument();
        }else if (actionString.equals("Сохранить")){
            controller.saveDocument();
        }else if (actionString.equals("Сохранить как...")){
            controller.saveDocumentAs();
        }else if (actionString.equals("Выход")){
            controller.exit();
        }else if (actionString.equals("О программе")){
            showAbout();
        }

    }
    
    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }
    
    public void exit(){
        controller.exit();
    }
    
    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }
    
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",jScrollPaneHTML);
        JScrollPane jScrollPanePlain = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPanePlain);
        tabbedPane.setPreferredSize(new Dimension(400,200));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    
    public void initGui(){
        initEditor();
        initMenuBar();
        pack();
    }
    
    public void selectedTabChanged(){
        String text;
        if (tabbedPane.getSelectedIndex() == 0){
            text = plainTextPane.getText();
            controller.setPlainText(text);
        }else if (tabbedPane.getSelectedIndex() == 1){
            text = controller.getPlainText();
            plainTextPane.setText(text);
        }
        resetUndo();
    }
}