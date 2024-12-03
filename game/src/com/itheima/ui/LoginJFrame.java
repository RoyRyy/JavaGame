package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame:登录界面，以后跟登录相关的代码都写在这里

    public LoginJFrame() {
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("坤坤 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}
