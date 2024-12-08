package com.itheima.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    //JFrame 界面，窗体
    //子类呢？也表示界面，窗体
    //规定：GameJFrame这个界面表示的就是游戏的主界面

    //创建一个二维数组 目的：用来管理数据，加载图片时会根据二维数组中的数据进行加载
    int [][] data=new int[4][4];
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //初始化图片（根据打乱之后的结果去加载图片）
        initImage();

        //让界面显示出来，建议写在最后
        this.setVisible(true);
    }
    //初始化数据（打乱）
    private void initData() {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index=r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }


        //给二维数组添加数据
        int index=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j]=tempArr[index];
                index++;
            }
        }

    }


    //初始化图片
    //添加图片时，需要按照二维数组中管理的数据添加图片
    private void initImage() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载图片的序号
                int num =data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\raoyi\\Desktop\\java code\\JavaGame\\image\\animal\\animal1\\"+num+".jpg"));
                //指定图片位置
                jLabel.setBounds(105*j, 105*i, 105, 105);
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
                //添加一次之后，number需要自增

            }
        }

    }

    private void initJMenuBar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar menuBar = new JMenuBar();

        //创建菜单上的两个选项的对象 (功能 关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem= new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单中
        menuBar.add(functionJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("坤坤爱拼图 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);

        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
    }

}
