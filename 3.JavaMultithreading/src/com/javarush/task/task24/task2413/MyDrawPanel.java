package com.javarush.task.task24.task2413;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel implements ControllerEventListener {
    static JFrame f = new JFrame("Арканоид");
    public static MyDrawPanel drawPanel =new MyDrawPanel();

    public void setUpGui() {
        drawPanel = new MyDrawPanel();
        f.setContentPane(drawPanel);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    }

    @Override
    public void controlChange(ShortMessage event) {
        this.repaint();
    }

    public void paintComponent(Graphics var1) {
        if (true) {
            Graphics2D var2 = (Graphics2D)var1;
            int var3 = (int)(Math.random() * 250.0D);
            int var4 = (int)(Math.random() * 250.0D);
            int var5 = (int)(Math.random() * 250.0D);
            var1.setColor(new Color(var3, var4, var5));
            int var6 = (int)(Math.random() * 120.0D + 10.0D);
            int var7 = (int)(Math.random() * 120.0D + 10.0D);
            int var8 = (int)(Math.random() * 40.0D + 10.0D);
            int var9 = (int)(Math.random() * 40.0D + 10.0D);
            var1.fillRect(var8, var9, var6, var7);

        }

    }

    public void go() {
        this.setUpGui();
        f.setDefaultCloseOperation(3);

    }




}
