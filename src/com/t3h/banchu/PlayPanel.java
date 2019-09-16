package com.t3h.banchu;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    int xBg;
    Image bgImg;
    int hBg, wBg;
    int xI1, xI2, delta;

    PlayPanel() {
//        setBackground(Color.BLACK);
        setSize(400, 600);
        setLayout(null);
        intImageBg();
        intThread();
    }

    void intImageBg() {
        bgImg = new ImageIcon(
                getClass().getResource("/img/bg (2).jpg")
        ).getImage();
        hBg = 500;
        wBg = 500 * bgImg.getWidth(null) / bgImg.getHeight(null);
        xI1 = 0;
        xI2 = xI1 + wBg;
        delta = wBg - 400;//bgImg.getWidth(null) - 400;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        // tao anh
        Image menuImg = new ImageIcon(
                getClass().getResource("/img/menu.jpg")
        ).getImage();
//        Image tankImg = new ImageIcon(
//                getClass().getResource("/img/tank (1).png")
//        ).getImage();
        g2d.drawImage(menuImg, 0, 0, 400, 100, null);
        g2d.drawImage(bgImg, xI1, 100, wBg, 500, null);
        g2d.drawImage(bgImg, xI2, 100, wBg, 500, null);
        //g2d.drawImage(tankImg, 170, 540, 60, 60, null);
    }

    void intThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    xI1--;
                    xI2--;
                    if (xI2 == - delta) {
                        xI1 = -delta;
                        xI2 = 400;
                    }
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

//Vẽ xe tăng
//Nhấn nút lên xuống sang phải sang trái thì xe tăng sẽ di chuyển theo
//key press Java Swing
//Vẽ chữ rơi từ trên xuống
