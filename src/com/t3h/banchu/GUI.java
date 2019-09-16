package com.t3h.banchu;

import javax.swing.*;

public class GUI extends JFrame {

    GUI(){
        setSize(400,600);
//        setLocation(400,300);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(null);
        PlayPanel playPanel = new PlayPanel();
        add(playPanel);
    }
}
