package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, MouseListener {
    int[][] data = new int[4][4];
    int x = 0; // 空白块的行
    int y = 0; // 空白块的列

    //定义一个变量，记录当前展示图片的路径
    String path="image\\animal\\animal1\\";

    //定义一个二维数组，存储正确的数据
    int[][] win={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据
        initData();

        // 初始化图片
        initImage();

        // 让界面显示出来
        this.setVisible(true);

        // 给整个界面添加鼠标监听
        this.addMouseListener(this);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (tempArr[index] == 0) {
                    x = i;
                    y = j; // 记录空白块的位置
                }
                data[i][j] = tempArr[index];
                index++;
            }
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (victory()) {
            //显示胜利的图标
            JLabel winJLabel = new JLabel(new ImageIcon("C:\\Users\\raoyi\\Desktop\\java code\\JavaGame\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);
            }
        }

        ImageIcon icon = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(icon);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        menuBar.add(functionJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("坤坤爱拼图 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    //按下不松时会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==65){
            //把界面中所有的图片全部删除
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon icon = new ImageIcon("image\\background.png");
            JLabel background = new JLabel(icon);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }
    //松开按键时调用
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，此方法需要直接结束，不能再执行下面的移动代码了
        if(victory()){
            //1.返回结果
            //2.结束方法
            return;
        }

        int code = e.getKeyCode();
        if (code == 37 && y < 3) { // 左
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage();
        } else if (code == 38 && x < 3) { // 上
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage();
        } else if (code == 39 && y > 0) { // 右
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage();
        } else if (code == 40 && x > 0) { // 下
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
        }else if (code == 65) {
            initImage();
        }else if(code==87){
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x=3;
            y=3;
            initImage();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 获取鼠标点击的位置
        int clickX = e.getX();
        int clickY = e.getY();

        // 计算点击位置的行列
        int row = (clickY - 134) / 105;
        int col = (clickX - 83) / 105;

        // 判断是否在有效范围内
        if (row >= 0 && row < 4 && col >= 0 && col < 4) {
            // 判断是否是空白块旁边
            if ((row == x && Math.abs(col - y) == 1) || (col == y && Math.abs(row - x) == 1)) {
                // 交换空白块和点击块
                data[x][y] = data[row][col];
                data[row][col] = 0;
                x = row;
                y = col;
                initImage();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    //判断data数组中的数据是否和win数组中的相同
    //如果全部相同，返回true,否则返回false
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            //i:依次表示二维数组data里面的索引
            //data[i]:依次表示每一个一维数组
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] !=win[i][j]) {
                    //只要有一个数据不一样，则返回false
                    return false;
                }

            }
        }
        //循环结束数组遍历比较完毕
        return true;
    }
}

