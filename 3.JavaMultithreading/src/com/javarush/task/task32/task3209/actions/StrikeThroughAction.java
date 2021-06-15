package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.*;

public class StrikeThroughAction extends  StyledEditorKit.StyledTextAction{ // зачеркивание текста
    
    public StrikeThroughAction() {
        super(null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }

    }
}
