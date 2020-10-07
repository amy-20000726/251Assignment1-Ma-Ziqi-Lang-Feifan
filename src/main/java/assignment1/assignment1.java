package assignment1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;
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
                        new Search(),
                        new Time(),
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


        menuFile.add(new JMenuItem(actions[4]));
        menuFile.add(new JMenuItem(actions[5]));
        menuFile.add(new JMenuItem(actions[6]));

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
        public New()
        {
            super("New    Ctrl+N");
        }
        public void actionPerformed(ActionEvent e)
        {
            textPane.setDocument(new DefaultStyledDocument());
        }
    }

    //Open
    class Open extends AbstractAction
    {
        public Open()
        {
            super("Open   Ctrl+O");
        }
        public void actionPerformed(ActionEvent e)
        {
            //Display Open File dialog
            int i=filechooser.showOpenDialog(assignment1.this);
            //Click the dialog box to open options
            if(i==JFileChooser.APPROVE_OPTION)
            {
                //Get selected document
                File file=filechooser.getSelectedFile();
                try
                {
                    InputStream is=new FileInputStream(file);
                    textPane.read(is, "d");
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }


    //Save
    class Save extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        public Save()
        {
            super("Save   Ctrl+S");
        }
        public void actionPerformed(ActionEvent e)
        {
            int i=filechooser.showSaveDialog(assignment1.this);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File f=filechooser.getSelectedFile();
                try
                {
                    FileOutputStream out=new FileOutputStream(f);
                    out.write(textPane.getText().getBytes());
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }


    //Exit
    class Exit extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        public Exit()
        {
            super("Exit");
        }
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
    }


    //Cut
    class Cut extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        public Cut()
        {
            super("Cut    Ctrl+X");
        }
        public void actionPerformed(ActionEvent e)
        {
            textPane.cut();
        }
    }


    //Copy
    class Copy extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        public Copy()
        {
            super("Copy    Ctrl+C");
        }
        public void actionPerformed(ActionEvent e)
        {
            textPane.copy();
        }
    }


    //Paste
    class Paste extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        public Paste()
        {
            super("Paste    Ctrl+V");
        }
        public void actionPerformed(ActionEvent e)
        {
            textPane.paste();
        }
    }


    //About
    class About extends AbstractAction
    {
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


