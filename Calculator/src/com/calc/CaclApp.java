package com.calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaclApp {
    private JFrame frame;
    double firstnumber, secondnumber, result;
    String oper, anserw;


    private JPanel panelMain;
    private JButton but0;
    private JButton but1;
    private JButton but4;
    private JButton butPlus;
    private JButton butSub;
    private JButton but3;
    private JButton butPM;
    private JButton butEqual;
    private JButton butMult;
    private JButton butDot;
    private JButton but2;
    private JButton but5;
    private JButton but6;
    private JButton but7;
    private JButton butPer;
    private JButton but9;
    private JButton butDel;
    private JButton but8;
    private JButton butBaksp;
    private JButton butSplit;
    private JTextField textField1;

    public CaclApp() {
        frame = new JFrame();
        frame.setBounds(100, 100, 247, 360);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(10, 11, 211, 32);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);

        JButton butBaksp = new JButton("<--");
        butBaksp.setBounds(10, 54, 50, 50);
        frame.getContentPane().add(butBaksp);

        JButton butDel = new JButton("C");
        butDel.setBounds(65, 54, 50, 50);
        frame.getContentPane().add(butDel);

        JButton butPer = new JButton("%");
        butPer.setBounds(120, 54, 50, 50);
        frame.getContentPane().add(butPer);

        JButton butPlus = new JButton("+");
        butPlus.setBounds(175, 54, 50, 50);
        frame.getContentPane().add(butPlus);

        JButton but7 = new JButton("7");
        but7.setBounds(10, 104, 50, 50);
        frame.getContentPane().add(but7);

        JButton but8 = new JButton("8");
        but8.setBounds(65, 104, 50, 50);
        frame.getContentPane().add(but8);

        JButton but9 = new JButton("9");
        but9.setBounds(120, 104, 50, 50);
        frame.getContentPane().add(but9);

        JButton butSplit = new JButton("/");
        butSplit.setBounds(175, 104, 50, 50);
        frame.getContentPane().add(butSplit);

        JButton but4 = new JButton("4");
        but4.setBounds(10, 159, 50, 50);
        frame.getContentPane().add(but4);

        JButton but5 = new JButton("5");
        but5.setBounds(65, 159, 50, 50);
        frame.getContentPane().add(but5);

        JButton but6 = new JButton("6");
        but6.setBounds(120, 159, 50, 50);
        frame.getContentPane().add(but6);

        JButton butSub = new JButton("-");
        butSub.setBounds(175, 159, 50, 50);
        frame.getContentPane().add(butSub);

        JButton but1 = new JButton("1");
        but1.setBounds(10, 204, 50, 50);
        frame.getContentPane().add(but1);

        JButton but2 = new JButton("2");
        but2.setBounds(65, 204, 50, 50);
        frame.getContentPane().add(but2);

        JButton but3 = new JButton("3");
        but3.setBounds(120, 204, 50, 50);
        frame.getContentPane().add(but3);

        JButton butMult = new JButton("*");
        butMult.setBounds(175, 204, 50, 50);
        frame.getContentPane().add(butMult);

        JButton but0 = new JButton("0");
        but0.setBounds(10, 259, 50, 50);
        frame.getContentPane().add(but0);

        JButton butDot = new JButton(".");
        butDot.setBounds(65, 259, 50, 50);
        frame.getContentPane().add(butDot);

        JButton butPM = new JButton("+/-");
        butPM.setBounds(120, 259, 50, 50);
        frame.getContentPane().add(butPM);

        JButton butEqual = new JButton("=");
        butEqual.setBounds(175, 259, 50, 50);
        frame.getContentPane().add(butEqual);


        but0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but0.getText();
                textField1.setText(EnterNumber);
            }
        });

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but1.getText();
                textField1.setText(EnterNumber);
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but2.getText();
                textField1.setText(EnterNumber);
            }
        });


        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but3.getText();
                textField1.setText(EnterNumber);
            }
        });


        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but4.getText();
                textField1.setText(EnterNumber);
            }
        });

        but5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but5.getText();
                textField1.setText(EnterNumber);
            }
        });

        but6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but6.getText();
                textField1.setText(EnterNumber);
            }
        });

        but7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but7.getText();
                textField1.setText(EnterNumber);
            }
        });

        but8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but8.getText();
                textField1.setText(EnterNumber);
            }
        });

        but9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField1.getText() + but9.getText();
                textField1.setText(EnterNumber);
            }
        });
        butDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(null);
            }
        });
        butPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        butBaksp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String backspace=null;

                if(textField1.getText().length()>0){
                    StringBuilder strB = new StringBuilder(textField1.getText());
                    strB.deleteCharAt(textField1.getText().length() - 1);
                    backspace = strB.toString();
                    textField1.setText(backspace);
                }
            }
        });
        butPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                firstnumber = Double.parseDouble(textField1.getText());
                textField1.setText("");
                oper = "+";
            }
        });
        butSplit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstnumber = Double.parseDouble(textField1.getText());
                textField1.setText("");
                oper = "/";
            }
        });
        butSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstnumber = Double.parseDouble(textField1.getText());
                textField1.setText("");
                oper = "-";
            }
        });
        butMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstnumber = Double.parseDouble(textField1.getText());
                textField1.setText("");
                oper = "*";
            }
        });
        butPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double ops = Double.parseDouble(String.valueOf(textField1.getText()));
                ops = ops*(-1);
                textField1.setText(String.valueOf(ops));
            }
        });
        butPer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstnumber = Double.parseDouble(textField1.getText());
                textField1.setText("");
                oper = "%";
            }
        });

        butEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String anserw;
                secondnumber = Double.parseDouble(textField1.getText());
                if (oper=="+")
                {
                    result = firstnumber + secondnumber;
                    anserw = String.format("%.2f",result);
                    textField1.setText(anserw);
                }else if (oper=="-"){
                    result = firstnumber - secondnumber;
                    anserw = String.format("%.2f",result);
                    textField1.setText(anserw);
                }else if(oper=="*"){
                result = firstnumber * secondnumber;
                anserw = String.format("%.2f",result);
                textField1.setText(anserw);
            }else if(oper=="/"){
                result = firstnumber / secondnumber;
                anserw = String.format("%.2f",result);
                textField1.setText(anserw);}}
        });

        butDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String EnterNumber = textField1.getText() + butDot.getText();
                textField1.setText(EnterNumber);
            }
        });

    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
