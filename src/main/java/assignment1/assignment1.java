package assignment1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

//简单的文本编辑器

public class assignment1 extends JFrame {
    public JTextPane textPane = new JTextPane(); //文本窗格d，编辑窗口
    public JFileChooser filechooser = new JFileChooser(); //文件选择器

    public assignment1()
    {
        super("Text Editor");

        Action[] actions=			//菜单项的各种功能
                {

                };
        setJMenuBar(createJMenuBar(actions));		//根据actions创建菜单栏
        Container container=getContentPane();
        container.add(textPane, BorderLayout.CENTER);

        setSize(800,600);
        setVisible(true);
        //	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar createJMenuBar(Action[] actions)	//创建菜单栏的函数
    {
        JMenuBar menubar=new JMenuBar();
        JMenu menuFile=new JMenu("File");
        JMenu menuSearch=new JMenu("Search");
        JMenu menuView=new JMenu("View");
        JMenu menuManage=new JMenu("Manage");
        JMenu menuHelp=new JMenu("Help");


        menuFile.add(new JMenuItem(actions[0]));
        menuFile.add(new JMenuItem(actions[1]));
        menuFile.add(new JMenuItem(actions[2]));
        menuFile.add(new JMenuItem(actions[3]));


        menuSearch.add(new JMenuItem(actions[4]));
        menuSearch.add(new JMenuItem(actions[5]));
        menuSearch.add(new JMenuItem(actions[6]));


        menuHelp.add(new JMenuItem(actions[7]));
        menuHelp.add(new JMenuItem(actions[8]));


        menubar.add(menuFile);
        menubar.add(menuSearch);
        menubar.add(menuView);
        menubar.add(menuManage);
        menubar.add(menuHelp);
        return menubar;
    }


    public static void main(String[] args)
    {
        new assignment1();
    }
}


