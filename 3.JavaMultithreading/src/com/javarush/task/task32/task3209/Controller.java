package com.javarush.task.task32.task3209;



import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;


public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;
    
    
    public static void main(String[] args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }



    public void saveDocumentAs(){
        view.selectHtmlTab(); // переключаем вкладку
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter()); // устанавливаем фильтр
        int result = jFileChooser.showSaveDialog(view); // 0 файл выбран 1 отменен -1 ошибка

        if (result == JFileChooser.APPROVE_OPTION){ // если result 0 значит выбор файла прошел успешно
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());// надпись на окне
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter,document,0, document.getLength());
                fileWriter.close();

            }catch (Exception e){
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocument(){
        view.selectHtmlTab(); // переключаем вкладку

        if (currentFile != null){ // если result 0 значит выбор файла прошел успешно

            view.setTitle(currentFile.getName());// надпись на окне
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter,document,0, document.getLength());
                fileWriter.close();

            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }else saveDocumentAs();
    }

    public void openDocument(){
        view.selectHtmlTab(); // переключаем вкладку
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter()); // устанавливаем фильтр
        int result = jFileChooser.showOpenDialog(view); // 0 файл выбран 1 отменен -1 ошибка

        if (result == JFileChooser.APPROVE_OPTION){ // если result 0 значит выбор файла прошел успешно
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.resetUndo();
            view.setTitle(currentFile.getName());// надпись на окне
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader,document,0);
                fileReader.close();

            }catch (Exception e){
                ExceptionHandler.log(e);
            }

        }
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public String getPlainText()  {
        StringWriter stringWriter = null;
        try {
            stringWriter = new StringWriter();
            new HTMLEditorKit().write(stringWriter,document,0, document.getLength());
        }catch (IOException e){
            ExceptionHandler.log(e);
        }catch (BadLocationException e){
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader  stringReader = new StringReader(text);
        try {
           new HTMLEditorKit().read(stringReader, document, 0);
        }catch (Exception e){
            ExceptionHandler.log(e);
        }


    }
    
    public Controller(View view){
        this.view = view;
    }

    public void resetDocument(){
        UndoListener undoListener = view.getUndoListener();
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());  // удаляем слушателя
            document = new HTMLDocument();
        }
        document =(HTMLDocument) new HTMLEditorKit().createDefaultDocument(); // присваиваем документ по умолчанию
        document.addUndoableEditListener(undoListener);
        view.update();
    }

    public HTMLDocument getDocument(){
        return document;
    }
    
    public void init(){
        createNewDocument();
    }
    
    public void exit(){
        System.exit(0);
    }
}