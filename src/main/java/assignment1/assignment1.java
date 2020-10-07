package assignment1;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
public class assignment1 {


    public class main extends JFrame{

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private JMenuBar menuBar;
        //菜单栏
        private JMenu menu_File,menu_Edit,menu_Help,menu_View,menu_Manage;
        //菜单栏内的菜单
        private JMenuItem item_new,item_open,item_save,item_exit,item_print;
        //对于file菜单的子项
        private JMenuItem item_undo,item_cut,item_copy,item_stick,item_delete;
        //对于edit菜单的子项
        private JMenuItem item_about;
        //对于help菜单的子项


        public main() {
            initMenuBar();

            this.setJMenuBar(menuBar);
            this.setSize(800,600);
            this.setTitle("Text Editor");
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea jTextArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(jTextArea);
        }





        @SuppressWarnings("deprecation")
        public void initMenuBar() {
            menuBar = new JMenuBar();
            menu_File = new JMenu("File(F)");
            menu_File.setMnemonic('f');
            item_new = new JMenuItem("New");
            item_open = new JMenuItem("Open");
            item_save = new JMenuItem("Save");
            item_exit = new JMenuItem("Exit");
            item_print = new JMenuItem("Print");
            menu_File.add(item_new);
            menu_File.add(item_open);
            menu_File.add(item_save);
            menu_File.add(item_exit);
            menu_File.add(item_print);
            //File 菜单

            menu_Edit = new JMenu("Search(E)");
            menu_Edit.setMnemonic('e');
            item_undo = new JMenuItem("撤销");
            item_cut = new JMenuItem("剪切");
            item_copy = new JMenuItem("复制");
            item_stick = new JMenuItem("粘贴");
            item_delete = new JMenuItem("删除");
            menu_Edit.add(item_undo);
            menu_Edit.add(item_cut);
            menu_Edit.add(item_copy);
            menu_Edit.add(item_stick);
            menu_Edit.add(item_delete);
            //Edit 菜单

            menu_Help = new JMenu("Help(H)");
            menu_Help.setMnemonic('h');
            item_about = new JMenuItem("About");
            menu_Help.add(item_about);
            //Help 菜单

            menu_Manage = new JMenu("Manage");

            menu_View = new JMenu("View(O)");
//			menu_Format.setMnemonic('o');
//			item_word_format = new JMenuItem("字体(F)");
//			item_word_format.setAccelerator(KeyStroke.getKeyStroke('F',java.awt.Event.CTRL_MASK,false));//给item添加快捷键
//			menu_Format.add(item_word_format);




            menuBar.add(menu_File);
            menuBar.add(menu_Edit);
            menuBar.add(menu_View);
            menuBar.add(menu_Manage);
            menuBar.add(menu_Help);

        }



        public void main(String[] args) {
            main t5 = new main();
        }



    }
}
