package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.JEditorPane;
import javax.swing.text.*;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction { // подстрочный текст


    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            //получаем атрибуты текущего стиля и сохраняем в mutableAttributeSet как мару (вроде так)
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            //создаем пустое множество (HаshTable), которое имплементирует MutableAttributeSet (т.е. упрощенный вариант mutableAttributeSet)
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            //устанавливает пустому множеству атрибут Зачеркивания, если в исходном стиле не содержится атрибут Зачеркивания
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            //устанавливает editor'у, стиль множества, без замены существующих атрибутов.
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
