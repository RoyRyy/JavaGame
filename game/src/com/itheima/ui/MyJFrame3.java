package com.itheima.ui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    JButton jtb1=new JButton("点我啊");
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
    }

    public MyJFrame3(){
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("事件演示");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        //给整个窗体添加键盘监听
        this.addKeyListener(this);
        jtb1.setBounds(0,0,100,50);
        //给按钮绑定鼠标事件
        jtb1.addKeyListener(this);

        this.getContentPane().add(jtb1);
        this.setVisible(true);
    }
}
