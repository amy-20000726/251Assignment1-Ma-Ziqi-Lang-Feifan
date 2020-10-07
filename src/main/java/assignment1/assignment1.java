package assignment1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

//简单的文本编辑器

public class assignment1 extends JFrame {
    public JTextPane textPane = new JTextPane();
    public JFileChooser filechooser = new JFileChooser();

    public assignment1()
    {
        super("Text Editor");
//create classes of actions
        Action[] actions=
                {
                        new New(),
                        new Open(),
                        new Save(),
                        new Exit(),

                        new Cut(),
                        new Copy(),
                        new Paste(),

                        new About(),
                        new Help(),
                        new Print(),
                };
        setJMenuBar(createJMenuBar(actions));
        Container container=getContentPane();
        container.add(textPane, BorderLayout.CENTER);

        //set size of the screen
        setSize(800,600);
        //set windows visible
        setVisible(true);

    }

    //create menu bar
    private JMenuBar createJMenuBar(Action[] actions)
    {
        JMenuBar menubar=new JMenuBar();
        JMenu menuFile=new JMenu("File");
        JMenu menuSearch=new JMenu("Search");
        JMenu menuView=new JMenu("View");
        JMenu menuManage=new JMenu("Manage");
        JMenu menuHelp=new JMenu("Help");

    //Assign drop-down Windows
        //File
        menuFile.add(new JMenuItem(actions[0]));
        menuFile.add(new JMenuItem(actions[1]));
        menuFile.add(new JMenuItem(actions[2]));
        menuFile.add(new JMenuItem(actions[3]));
        menuFile.add(new JMenuItem(actions[4]));

        //Search
        menuSearch.add(new JMenuItem(actions[4]));
        menuSearch.add(new JMenuItem(actions[5]));
        menuSearch.add(new JMenuItem(actions[6]));

        //Help
        menuHelp.add(new JMenuItem(actions[7]));
        menuHelp.add(new JMenuItem(actions[8]));


        menubar.add(menuFile);
        menubar.add(menuSearch);
        menubar.add(menuView);
        menubar.add(menuManage);
        menubar.add(menuHelp);
        return menubar;
    }

    //New
    class New extends AbstractAction
    {

    }

    //Open
    class Open extends AbstractAction
    {

    }


    //Save
    class Save extends AbstractAction
    {

    }


    //Exit
    class Exit extends AbstractAction
    {

    }


    //Cut
    class Cut extends AbstractAction
    {

    }


    //Copy
    class Copy extends AbstractAction
    {

    }


    //Paste
    class Paste extends AbstractAction
    {

    }


    //About
    class About extends AbstractAction
    {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        public About()
        {
            super("brief message");
        }
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(assignment1.this,"Some basic functions of notepad are realized\r\n"
                    + "\r\n"
                    + "","About",JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Help
    class Help extends AbstractAction
    {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        public Help()
        {
            super("group numbers' information");
        }
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(assignment1.this,"Feifan_Lang  Ziqi_Ma","group numbers' information",JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Print
    class Print extends AbstractAction
    {

    }
    public static void main(String[] args)
    {
        new assignment1();
    }
}


