package com.calc;

import java.awt.*;

public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run () {
                try {
                    CaclApp app = new CaclApp();
                    app.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}