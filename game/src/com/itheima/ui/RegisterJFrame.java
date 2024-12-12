package com.itheima.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //跟注册相关的代码都写在这个界面中
    public RegisterJFrame() {
        setSize(488,500);
        //设置界面的标题
        this.setTitle("坤坤 注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        getContentPane();
    }
}
