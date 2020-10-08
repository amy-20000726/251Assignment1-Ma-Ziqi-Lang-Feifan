package assignment1;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.*;
import java.util.regex.*;

public class assignment1 {
    public static void main(String args[]){
        EditWindow win=new EditWindow();
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class EditWindow extends JFrame implements ActionListener{
    JFileChooser filechooser = new JFileChooser();      //File selector
    JMenuBar menubar;
    JPopupMenu mouseMenu;
    JMenu menu1,menu2,menu3,menu4,menu5;
    JMenuItem itemNew,itemNewWindow,itemSave,itemSaveAs,itemPrinting,
            itemPageSetup,itemCut,itemCopy,itemPaste,itemFind,itemReplace,itemOpen,
            itemView,itemAbout,mouseCut,mouseCopy,mousePaste,mouseDelet,mouseAll;
    JTextArea text1;
    EditWindow(){
        setTitle("Text Editor");
        setSize(600,670);
        setLocation(130,120);
        setVisible(true);


//*Menu bar settings:
//1. Documents:New New window Open Preservation Save as Printing
//2.Editing:Cut Copy Paste Search Replacement time&date
//3.View
//4.Help:About
//5.Manage
//


        menubar=new JMenuBar();
        menu1=new JMenu("File");menu1.setMnemonic('F');
        menu2=new JMenu("Edit");menu2.setMnemonic('E');
        menu3=new JMenu("View");menu3.setMnemonic('V');
        menu4=new JMenu("Help");menu4.setMnemonic('H');
        menu5=new JMenu("Manage");menu5.setMnemonic('M');

        //File
        itemNew=new JMenuItem("New              Ctrl+N");
        itemNewWindow=new JMenuItem("New Window         Ctrl+W");
        itemOpen=new JMenuItem("Open              Ctrl+O");
        itemSave=new JMenuItem("Save               Ctrl+S");
        itemSaveAs=new JMenuItem("Save as           Ctrl+E");
        itemPrinting=new JMenuItem("Print               Ctrl+P");
        itemPrinting=new JMenuItem("Print               Ctrl+P");
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        itemNewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        itemPrinting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        itemPrinting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        menu1.add(itemNew);menu1.add(itemNewWindow);menu1.add(itemOpen);menu1.add(itemSave);
        menu1.add(itemSaveAs);menu1.add(itemPrinting);

        //Edit
        itemCut=new JMenuItem("Cut         Ctrl+X");
        itemCopy=new JMenuItem("Copy         Ctrl+C");
        itemPaste=new JMenuItem("Paste         Ctrl+V");
        itemFind=new JMenuItem("Search         Ctrl+F");
        itemReplace=new JMenuItem("Time&Date         Ctrl+R");
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menu2.add(itemCut);menu2.add(itemCopy);menu2.add(itemPaste);
        menu2.add(itemFind);menu2.add(itemReplace);


        //View
        itemView =new JMenuItem("View");



        //Help
        itemAbout=new JMenuItem("About");
        menu4.add(itemAbout);


        //Make the menu display
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        menubar.add(menu5);
        setJMenuBar(menubar);

        validate();
        //Set up a listener
        itemNew.addActionListener(this);itemNewWindow.addActionListener(this);itemSave.addActionListener(this);
        itemSaveAs.addActionListener(this);itemPrinting.addActionListener(this);itemOpen.addActionListener(this);
        itemCut.addActionListener(this);itemCopy.addActionListener(this);itemPaste.addActionListener(this);
        itemFind.addActionListener(this);itemReplace.addActionListener(this);
        itemView.addActionListener(this);itemAbout.addActionListener(this);
        //Right click the menu settings
        mouseMenu=new JPopupMenu();
        mouseCut=new JMenuItem("Cut");mouseCopy=new JMenuItem("Copy");mousePaste=new JMenuItem("Paste");
        mouseDelet=new JMenuItem("Delete");mouseAll=new JMenuItem("Select");
        mouseMenu.add(mouseCut);mouseMenu.add(mouseCopy);mouseMenu.add(mousePaste);
        mouseMenu.add(mouseDelet);mouseMenu.add(mouseAll);
        //Add text field
        text1=new JTextArea();
        //Set up mouse monitor
        text1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if(e.getModifiers()==InputEvent.BUTTON3_MASK)
                    mouseMenu.show(text1,e.getX(),e.getY());
            }
        });
        mouseCut.addActionListener(this);mouseCopy.addActionListener(this);mousePaste.addActionListener(this);
        mouseDelet.addActionListener(this);mouseAll.addActionListener(this);
        //Add scroll bar
        JScrollPane scrollpane = new JScrollPane(text1);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollpane, BorderLayout.CENTER);
        //Line break
        text1.setLineWrap(true);
        validate();
    }

    public void actionPerformed(ActionEvent e){
        //
        if(e.getSource()==itemNew) {                                          //New
            text1.replaceRange("", 0, text1.getText().length());
        }else if(e.getSource()==itemNewWindow) {                               //New window

            EditWindow won=new EditWindow();

        }else if(e.getSource()==itemOpen) {                                   //open
            FileDialog openFile = new FileDialog(this, "打开文件", FileDialog.LOAD);  //File dialog
            openFile.setVisible(true);
            String filePath = openFile.getDirectory() + openFile.getFile();
            try{
                FileInputStream fis = new FileInputStream(filePath);
                byte[] content = new byte[fis.available()];
                fis.read(content);
                text1.setText(new String(content));
                text1.setCaretPosition(0);
                if(openFile.getFile() != null){
                    this.setTitle(openFile.getFile());
                }
                fis.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() ==  itemSave) {                                //Save
            int i = filechooser.showSaveDialog(EditWindow.this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(text1.getText().getBytes());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }else if(e.getSource() ==itemSaveAs) {                                //Save as
            int i = filechooser.showSaveDialog(EditWindow.this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(text1.getText().getBytes());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }else if(e.getSource()==itemPrinting) {                               //Print
            new PrintAction();
        }else if(e.getSource()==itemCopy || e.getSource()==mouseCopy) {       //Paste
            text1.copy();
        }else if(e.getSource()==itemCut || e.getSource()==mouseCut) {		  //Cut
            text1.cut();
        }else if(e.getSource()==itemPaste || e.getSource()==mousePaste) {     //Copy
            text1.paste();
        }else if(e.getSource()==mouseDelet) {                                 //Delete
            text1.cut();
        }else if(e.getSource()==mouseAll) {                                   //Select
            text1.selectAll();
        }else if(e.getSource()==itemFind) {                                   //Search
            new SearchAction();
        }

        else if(e.getSource()==itemAbout) {                                  //About----Ma Ziqi   Lang Feifan
            JOptionPane.showMessageDialog(EditWindow.this, "1:Ma Ziqi      2:Lang Feifan");
        }
    }


    //Search
    class SearchAction extends JFrame{
        JButton button1;
        JTextField textfile;
        JLabel titlelName1;
        SearchAction(){

            setLayout(null);
            setTitle("Search");
            setBounds(100,100,300,200);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            textfile=new JTextField(30);
            button1=new JButton("OK");
            titlelName1=new JLabel("Search");
            textfile.setBounds(100,30,120, 25);
            titlelName1.setBounds(15,30,70, 30);
            button1.setBounds(120, 100, 60, 25);
            add(textfile);
            add(button1);
            add(titlelName1);
            setVisible(true);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Pattern p;
                    Matcher m;
                    String ch1,ch2;
                    ch1=textfile.getText();
                    ch2=text1.getText();
                    p=Pattern.compile(ch1);
                    m=p.matcher(ch2);

                    while(m.find()) {
                        text1.select(m.start(), m.end());
                    }
                }
            });
            validate();
        }
    }








    //Print
    class PrintAction extends JFrame{
        JButton button1;
        PrintAction(){
            setLayout(new FlowLayout());
            setTitle("Print");
            setBounds(100,100,300,100);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            button1=new JButton("Print");
            add(button1);
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    try {
                        PrinterJob job = PrinterJob.getPrinterJob();     //Create print objects
                        if (!job.printDialog()) {                        //Cancel printing
                            return;
                        }
                        //Set up the print page
                        job.setPrintable(new Printable() {
                            @Override
                            public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) throws PrinterException {
                                // TODO Auto-generated method stub
                                if(pageIndex > 0) {                       //Determine the index of the currently printed page
                                    return Printable.NO_SUCH_PAGE;        //Out of print page number
                                }
                                return Printable.PAGE_EXISTS;            //The page can be printed
                            }
                        });
                        job.print();                                     //Realize printing
                    } catch (PrinterException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
    }
}



