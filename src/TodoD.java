import java.awt.*;
import java.awt.event.*;
// import java.sql.PreparedStatement;
// import java.util.List;
import java.sql.*;
import javax.swing.*;

public class TodoD extends Registration{

    public static boolean statusmimp=false, statusimp=false ,statusnimp=false;
    public static String data,title;
    public static int index=1,pref,i=0,id=0,x=50,y=50,value,ind,tempvalue;

    // main frame consists of all elements given below

    public static JFrame f = new JFrame();
    public static Image icon = Toolkit.getDefaultToolkit().getImage("C:\\BTech\\College Work\\CS\\Completed Projects\\Todo List Java using Database\\src\\image.jpg");
    public static JLabel todo = new JLabel("Todo List");
    public static JButton logout = new JButton("Log Out");
    public static JButton create = new JButton("Create");
    public static JButton view = new JButton("View All");
    public static JButton delete = new JButton("Delete");
    public static JButton update = new JButton("Update");

    // Create function is below containing all these elements in it

    public static JLabel titlecreate = new JLabel("Enter Title Below");
    public static JTextField titleenter = new JTextField();
    public static JLabel textbelow = new JLabel("Enter Your Text Below");
    public static JTextArea areabelow = new JTextArea();
    public static JLabel textimp = new JLabel("Select Importance");
    public static JButton mimp = new JButton("Most Important");
    public static JLabel selectmimp = new JLabel("Double Click to Select Option");
    public static JButton imp = new JButton("Important");
    public static JLabel selectimp = new JLabel("Double Click to Select Option");
    public static JButton nimp = new JButton("Not So Important");
    public static JLabel selectnimp = new JLabel("Double Click to Select Option");
    public static JButton note = new JButton("Create a Note");
    public static JButton backselect = new JButton("Back");
    
    // All Elements which are used under view all, delete , update are given below
    public static String impo[] = {"Most Important","Important","Not so Important"};
    
    public static JLabel titleview = new JLabel("Title");
    public static JTextField titleviewfield = new JTextField();
    
    public static JLabel prefview = new JLabel("Preference");
    public static JComboBox<String> menu = new JComboBox<String>(impo);
    
    public static JLabel indexview = new JLabel("Index");
    
    public static JLabel textview = new JLabel("Text");
    public static JTextArea areaview = new JTextArea();
    
    public static JButton backview = new JButton("Back");
    public static JButton previous = new JButton("Previous");
    public static JButton next = new JButton("Next");
    public static JPanel panelview = new JPanel();
    public static JScrollPane scrollview = new JScrollPane(areabelow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public static JButton backbtn = new JButton("Back");
    public static JLabel mes = new JLabel("Visit \" Create \" section to see it here");
    public static JLabel message = new JLabel("Nothing to show");
    public static JLabel choose = new JLabel("Select a Note to see it here");
    public static JButton updatebtn = new JButton("Update");
    public static JButton deletebtn = new JButton("Delete");

    // All colors needed in the Todo list
    public static Color lightgreen = new Color(76,230,0);
    public static Color lightblue = new Color(107,100,230);
    public static Color lightred = new Color(255,100,100);
    public static Color lightorange = new Color(255,200,120);
    public static Color lightpink = new Color(255,100,255);
    public static Color purple = new Color(191,0,230);
    public static Color lightpurple = new Color(197,180,230);

    // Mouse listener of all the function needed in the Todod list
    public static MouseListener logoutfunction2(){
        logout.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                logout.setBackground(purple);
            }
            public void mouseExited(MouseEvent e){
                logout.setBackground(lightpurple);
            }
        });
        return null;
    }

    public static MouseListener viewfunction2(){
        view.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                view.setBackground(Color.blue);
            }
            public void mouseExited(MouseEvent e){
                view.setBackground(lightblue);
            }
        });
        return null;
    }
    
    
    public static MouseListener createfunction2(){
        create.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                create.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e){
                create.setBackground(lightgreen);
            }
        });
        return null;
    }
    
    public static MouseListener deletefunction2(){
        delete.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                delete.setBackground(Color.red);
            }
            public void mouseExited(MouseEvent e){
                delete.setBackground(lightred);
            }
        });
        return null;
    }
    
    public static MouseListener updatefunction2(){
        update.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                update.setBackground(Color.orange);
            }
            public void mouseExited(MouseEvent e){
                update.setBackground(lightorange);
            }
        });
        return null;
    }
    
    public static MouseListener notefunction2(){
        note.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                note.setBackground(Color.green);   
            }
            public void mouseExited(MouseEvent e){
                note.setBackground(lightgreen);
            }
        });
        return null;
    }
    
    public static MouseListener mimpfunction2(){
        mimp.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                mimp.setBackground(purple);
            }
            public void mouseExited(MouseEvent e){
                mimp.setBackground(lightpurple);
            }
        });
        return null;
    }

    public static MouseListener mimpfunction3(){
        mimp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount()==1){
                    selectmimp.setVisible(true);
                    selectimp.setVisible(false);
                    selectnimp.setVisible(false);
                }
                if(me.getClickCount()==2){
                    selectmimp.setVisible(false);
                    selectimp.setVisible(false);
                    selectnimp.setVisible(false);
                    mimp.setForeground(Color.black);
                    imp.setForeground(Color.white);
                    nimp.setForeground(Color.white);
                    pref = 2;
                    statusmimp = true;
                    statusimp = false;
                    statusnimp = false;
                }
            }
        });
        return null;
    }
    
    public static MouseListener impfunction2(){
        imp.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                imp.setBackground(Color.orange);
            }
            public void mouseExited(MouseEvent e){
                imp.setBackground(lightorange);
            }
        });
        return null;
    }
    
    public static MouseListener impfunction3(){
        imp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount()==1){
                    selectmimp.setVisible(false);
                    selectimp.setVisible(true); 
                    selectnimp.setVisible(false);
                }
                if(me.getClickCount()==2){
                    selectmimp.setVisible(false);
                    selectimp.setVisible(false); 
                    selectnimp.setVisible(false);
                    mimp.setForeground(Color.WHITE);
                    imp.setForeground(Color.black);
                    nimp.setForeground(Color.white);
                    pref = 1;
                    statusmimp=false;
                    statusimp=true;
                    statusnimp = false;
                }
            }
        });
        return null;
    }
    
    public static MouseListener nimpfunction2(){
        nimp.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                nimp.setBackground(Color.red);
            }
            public void mouseExited(MouseEvent e){
                nimp.setBackground(lightred);
            }
        });
        return null;
    }
    
    public static MouseListener nimpfunction3(){
        nimp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount()==1){
                    selectmimp.setVisible(false);
                    selectimp.setVisible(false); 
                    selectnimp.setVisible(true);
                }
                if(me.getClickCount()==2){
                    selectmimp.setVisible(false);
                    selectimp.setVisible(false); 
                    selectnimp.setVisible(false);
                    mimp.setForeground(Color.white);
                    imp.setForeground(Color.white);
                    nimp.setForeground(Color.black);
                    pref = 0;
                    statusmimp=false;
                    statusimp=false;
                    statusnimp = true;
                }
            }
        });
        return null;
    }
    
    public static MouseListener backselectfunction2(){
        backselect.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                backselect.setBackground(Color.blue);
            }
            public void mouseExited(MouseEvent e){
                backselect.setBackground(lightblue);
            }
        });
        return null;
    }
    
    public static MouseListener backviewfunction2(){
        backview.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                backview.setBackground(Color.blue);
            }
            public void mouseExited(MouseEvent e){
                backview.setBackground(lightblue);
            }
        });
        return null;
    }
    
    public static MouseListener backbtnfunction2(){
        backbtn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                backbtn.setBackground(Color.blue);
            }
            public void mouseExited(MouseEvent e){
                backbtn.setBackground(lightblue);
            }
        });
        return null;
    }

    public static MouseListener updatebtnfunction2(){
        updatebtn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                updatebtn.setBackground(Color.orange);
            }
            public void mouseExited(MouseEvent e){
                updatebtn.setBackground(lightorange);
            }
        });
        return null;
    }
    
    public static MouseListener deletebtnfunction2(){
        deletebtn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                deletebtn.setBackground(Color.red);
            }
            public void mouseExited(MouseEvent e){
                deletebtn.setBackground(lightred);
            }
        });
        return null;
    }

    // All the Action listeners needed in the Todo list
    
    public static ActionListener createfunction1(){
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Visibiilityfalse();
                
                titlecreate.setVisible(true);
                titleenter.setVisible(true);
                textbelow.setVisible(true);
                areabelow.setVisible(true);
                areabelow.setEditable(true);
                scrollview.setVisible(true);
                textimp.setVisible(true);
                mimp.setVisible(true);
                selectmimp.setVisible(false);
                imp.setVisible(true);
                selectimp.setVisible(false);
                nimp.setVisible(true);
                selectnimp.setVisible(false);
                note.setVisible(true);
                backselect.setVisible(true);
            }
        });
        return null;
    }
    
    public static void Visibiilityfalse(){
        
        create.setVisible(false);
        view.setVisible(false);
        delete.setVisible(false);
        update.setVisible(false);
        logout.setVisible(false);
        todo.setVisible(false);
    }

    public static void Visibiilitytrue(){

        create.setVisible(true);
        view.setVisible(true);
        delete.setVisible(true);
        update.setVisible(true);
        logout.setVisible(true);
        todo.setVisible(true);
        
    }
    
    public static ActionListener backselectfunction1(){
        backselect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Visibiilitytrue();

                titlecreate.setVisible(false);
                titleenter.setVisible(false);
                textbelow.setVisible(false);
                areabelow.setVisible(false);
                scrollview.setVisible(false);
                textimp.setVisible(false);
                mimp.setVisible(false);
                selectnimp.setVisible(false);
                imp.setVisible(false);
                selectimp.setVisible(false);
                nimp.setVisible(false);
                selectnimp.setVisible(false);
                note.setVisible(false);
                backselect.setVisible(false);
            }
        });
        return null;
    }
    
    public static ActionListener backbtnfunction1(){
        backbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Visibiilitytrue();

                backbtn.setVisible(false);
                mes.setVisible(false);
                message.setVisible(false);
                deletebtn.setVisible(false);
                updatebtn.setVisible(false);
            }
        });
        return null;
    }

    public static ActionListener backviewfunction1(){
        backview.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Visibiilitytrue();

                titleview.setVisible(false);
                titleviewfield.setVisible(false);
                prefview.setVisible(false);
                menu.setVisible(false);
                indexview.setVisible(false);
                textview.setVisible(false);
                backview.setVisible(false);
                next.setVisible(false);
                previous.setVisible(false);
                panelview.setVisible(false);
                areaview.setVisible(false);
                scrollview.setVisible(false);
                updatebtn.setVisible(false);
                choose.setVisible(false);
                deletebtn.setVisible(false);
            }
        });
        return null;
    }

    public static ActionListener logoutfunction1(){
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                areaview.setText("");
                titleviewfield.setText("");
                menu.setSelectedIndex(0);
                f.dispose();
                Registration.frame();
                Registration.loginbtn.setVisible(false);
            }
        });
        return null;
    }

    public static void RestoreDefaultView(){
        areabelow.setText("");
        titleenter.setText("");
        mimp.setForeground(Color.white);
        imp.setForeground(Color.white);
        nimp.setForeground(Color.white);

    }

    public static int GetLastIndex(int id){
        int index=0;
        try {
            PreparedStatement pst = conn.prepareStatement("select * from info",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            ID = id;
            rs.first();
            while(rs.next()){
                if(ID==rs.getInt("ID")){
                    if(index<=rs.getInt("value")){
                        index = rs.getInt("value");
                    }
                }
            };
        } catch (Exception e) {
            System.out.println("Error in getlastindex");
            e.printStackTrace();
        }
        return index;
    }
    
    public static int GetNextToLastIndex(int id){
        int index=0;
        try {
            PreparedStatement pst = conn.prepareStatement("select * from info",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            ID = id;
            rs.first();
            while(rs.next()){
                if(ID==rs.getInt("ID")){
                    if(index<=rs.getInt("value")){
                        index = rs.getInt("value");
                    }
                }
            };
        } catch (Exception e) {
            System.out.println("Error in getlastindex");
            e.printStackTrace();
        }
        return ++index;
    }

    public static int GetFirstIndex(int id){
        int index=0;
        try {
            PreparedStatement pst = conn.prepareStatement("select * from info",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            while(rs.next()){
                if(rs.getInt("ID")==id){
                    if(rs.getInt("value")>=1){
                        index = rs.getInt("value");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getfirstindex");
            e.printStackTrace();
        }
        return index;
    }

    public static int getID(){
        
        String checkuser = Registration.getuser();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from signup",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            while(rs.next()){
                if(checkuser.equals(rs.getString("username"))){
                    ID = rs.getInt("ID");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getID");
            e.printStackTrace();
        }
        return ID;
    }

    public static ActionListener notefunction1(){
        note.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(titleenter.getText().equals(" ")||titleenter.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(),"    Please Enter Title First","Warning", JOptionPane.ERROR_MESSAGE);
                }
                else if(areabelow.getText().equals("")||areabelow.getText().equals(" ")){
                    JOptionPane.showMessageDialog(new JFrame(), "   Please Enter Text First", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                else if(!((statusmimp==true&&statusimp==false&&statusnimp==false)||(statusmimp==false&&statusimp==true&&statusnimp==false)||(statusmimp==false&&statusimp==false&&statusnimp==true))){
                    JOptionPane.showMessageDialog(new JFrame(), "   Please Select Importance First", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int pr = pref;
                    int ind = index;
                    title = titleenter.getText();
                    data = areabelow.getText();
                    try {
                        PreparedStatement pst = conn.prepareStatement("insert into info(ID,value,title,preference,data) values(?,?,?,?,?)");
                        ID = getID();
                        ind = GetNextToLastIndex(ID);
                        pst.setInt(1, ID);
                        pst.setInt(2, ind);
                        pst.setString(3, title);
                        pst.setInt(4, pr);
                        pst.setString(5, data);
                        pst.executeUpdate();
                        RestoreDefaultView();
                        JOptionPane.showMessageDialog(new JFrame(), "           Note Created\n Visit \"View All\" section to see it", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        System.out.println("Error in notefunction1");
                        ex.printStackTrace();
                    }
                }
            }
        });
        return null;
    }

    public static ActionListener viewfunction1(){
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                todo.setVisible(false);
                create.setVisible(false);
                update.setVisible(false);
                delete.setVisible(false);
                view.setVisible(false);
                logout.setVisible(false);
                DisplayListView1();
            }
        });
        return null;
    }

    public static MouseListener btnmouselistener(JButton btn){
        btn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btn.setBackground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e){
                btn.setBackground(lightblue);
            }
        });
        return null;
    }

    public static void VisibilitySettingList1Continue(){

        titleview.setVisible(true);
        titleviewfield.setVisible(true);
        prefview.setVisible(true);
        menu.setVisible(true);
        textview.setVisible(true);
        areaview.setVisible(true);
        choose.setVisible(false);
    }

    public static ActionListener btnactionlistener(JButton btn,int id){
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VisibilitySettingList1Continue();
                try {
                    value = Integer.parseInt(btn.getText());
                    PreparedStatement pst = conn.prepareStatement("select * from info",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = pst.executeQuery();
                    rs.first();
                    while(rs.next()){
                        if((rs.getInt("ID")==id)&&(rs.getInt("value")==value)){
                            ind = value;
                            titleviewfield.setText(rs.getString("title"));
                            areaview.setText(rs.getString("data"));
                            if(rs.getInt("preference")==0){
                                menu.setSelectedIndex(0);
                            }
                            else if(rs.getInt("preference")==1){
                                menu.setSelectedIndex(1);
                            }
                            else{
                                menu.setSelectedIndex(2);
                            }
                        }
                    }
                    
                } catch (Exception ex) {
                    System.out.println("Error in btnactionlistener");
                    ex.printStackTrace();
                }
            }
        });
        return null;
    }

    public static JButton CreateButton(int x,int y,int index,int id){
        JButton btncreate = new JButton(String.valueOf(index));
        btncreate.addActionListener(btnactionlistener(btncreate,id));
        btncreate.addMouseListener(btnmouselistener(btncreate));
        btncreate.setBounds(x, y, 50, 50);
        btncreate.setBackground(lightblue);
        btncreate.setForeground(Color.white);
        btncreate.setVisible(true);
        return btncreate;
    }

    
    public static void VisibilitySettingList1(){
        titleview.setVisible(false);
        titleviewfield.setVisible(false);
        prefview.setVisible(false);
        menu.setVisible(false);
        textview.setVisible(false);
        choose.setVisible(true);
        backview.setVisible(true);
        next.setVisible(true);
        previous.setVisible(true);
        panelview.setVisible(true);
        areaview.setVisible(false);
        scrollview.setVisible(true);
        
    }
    
    public static void InVisibilitySettingList1(){
        titleview.setVisible(false);
        titleviewfield.setVisible(false);
        prefview.setVisible(false);
        menu.setVisible(false);
        textview.setVisible(false);
        backview.setVisible(true);
        next.setVisible(true);
        previous.setVisible(true);
        panelview.setVisible(true);
        areaview.setVisible(false);
        scrollview.setVisible(true);
        
    }

    public static void BoundSettingList1(){
        titleview.setBounds(200, 50, 150, 30);
        titleviewfield.setBounds(350, 50, 200, 30);
        prefview.setBounds(200, 100, 150, 30);
        menu.setBounds(350, 100, 200, 30);
        textview.setBounds(200, 150, 150, 30);
        areaview.setBounds(350, 150, 350, 200);
        panelview.setBounds(0, 0, 100, 650);
        scrollview.setBounds(0, 0, 100, 650);
        backview.setBounds(350, 500, 200, 30);
        choose.setBounds(300, 200, 400, 50);
    }
    
    public static void FontSettingList1(){
        titleview.setFont(new Font("ALGERIAN",Font.BOLD,20));
        prefview.setFont(new Font("ALGERIAN",Font.BOLD,20));
        indexview.setFont(new Font("ALGERIAN",Font.BOLD,20));
        textview.setFont(new Font("ALGERIAN",Font.BOLD,20));
        choose.setFont(new Font("ALGERIAN",Font.BOLD,20));
        
    }
    
    public static void DisablingElementsInList1(){
        // areaview.setEnabled(false);
        areaview.setEditable(false);
        menu.setEnabled(false);
        // menu.setEditable(false);
        titleviewfield.setEditable(false);
        // titleviewfield.setEnabled(false);
    }
    
    public static void getMessage(){
        panelview.setBackground(Color.green);
        message.setVisible(true);
        mes.setVisible(true);
        message.setFont(new Font("ALGERIAN",Font.BOLD,20));
        mes.setFont(new Font("ALGERIAN",Font.BOLD,20));
        message.setBounds(350, 150, 200, 200);
        mes.setBounds(250, 300, 600, 300);
    }
    
    public static void GetNoOfButtons(int id){
        int run=1, index = GetLastIndex(id);
        while(run<=index){
            JButton btn = CreateButton(x,y,run,id);
            panelview.add(btn);
            y+=50;
            run++;
        }
        y=50;
    }

    public static void button(int id){
        GetNoOfButtons(id);
        VisibilitySettingList1Continue();
        areaview.setSelectedTextColor(Color.BLACK);
        titleviewfield.setSelectedTextColor(Color.BLACK);
        menu.setForeground(Color.BLACK);
    }

    public static void View(int id){
        
        button(id);        

        VisibilitySettingList1();
        
        BoundSettingList1();
        
        FontSettingList1();

        DisablingElementsInList1();
    }
    
    public static void DisplayListView1(){
        ID = getID();
        index = GetFirstIndex(ID);
        if(index==0){
            panelview.setVisible(false);
            scrollview.setVisible(false);
            getMessage();
            backbtn.setVisible(true);
            backbtn.setBounds(350, 500, 200, 30);
            deletebtn.setVisible(false);
            updatebtn.setVisible(false);
            // f.remove(panelview);
            // f.remove(scrollview);
        }
        else{
            panelview.removeAll();
            panelview.add(scrollview);
            View(ID);
        }
    }

    public static void Updateindex(int id,int index){
        try {
            PreparedStatement pst = conn.prepareStatement("select * from info where ID=? and value=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            pst.setInt(2, index);
            ResultSet rs = pst.executeQuery();
            rs.first();
            while(rs.next()){
                if(id==rs.getInt("ID")){
                    if(index<=rs.getInt("value")){
                        tempvalue = rs.getInt("value")-1;
                        PreparedStatement pst1 = conn.prepareStatement("select * from info where ID=? and value=?");
                        pst1.setInt(1, id);
                        pst1.setInt(2, tempvalue);
                        pst1.executeUpdate();
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Error in Updateindex()");
        }
    }

    public static ActionListener deletebtnfunction1(int id,int index){
        deletebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(choose.isVisible()){
                    JOptionPane.showMessageDialog(new JFrame(), "Please Select a Note First to Delete it", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                else if(message.isVisible()){
                    deletebtn.setVisible(false);
                }
                else{
                    deletebtn.setVisible(true);
                    try {
                        PreparedStatement pst = conn.prepareStatement("delete from info where ID=? and value=?");
                        pst.setInt(1, id);
                        pst.setInt(2, index);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(new JFrame(), "Note Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        backview.doClick();
                        backbtn.doClick();
                        // Updateindex(id, index);
                    } catch (Exception ex) {
                        System.out.println("Error in deletebtnfunction1()");
                        ex.printStackTrace();
                    }
                }
            }
        });
        return null;
    }
    
    public static void EnablingElementsInList1(){
        // areaview.setEnabled(false);
        areaview.setEditable(true);
        menu.setEnabled(true);
        // menu.setEditable(false);
        titleviewfield.setEditable(true);
        // titleviewfield.setEnabled(false);
    }

    public static ActionListener updatebtnfunction1(){
        updatebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(choose.isVisible()){
                    JOptionPane.showMessageDialog(new JFrame(), "Please Select a Note First to Update it", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                else if(message.isVisible()){
                    updatebtn.setVisible(false);
                }
                else{
                    updatebtn.setVisible(true);
                    if(titleviewfield.equals("")||titleviewfield.equals(" ")){
                        JOptionPane.showMessageDialog(new JFrame(), "Title Can Not Be Blank", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(areaview.equals("")||areaview.equals(" ")){
                        JOptionPane.showMessageDialog(new JFrame(), "Text Can Not Be Blank", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try {
                            PreparedStatement pst = conn.prepareStatement("select * from info",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = pst.executeQuery();
                            rs.first();
                            while(rs.next()){
                                if(ID==rs.getInt("ID")&&ind==rs.getInt("value")){
                                    deletebtnfunction1(ID, ind);
                                    PreparedStatement pst1 = conn.prepareStatement("insert into info(ID,value,title,preference,data) values(?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                    pst1.setInt(1, ID);
                                    pst1.setInt(2, ind);
                                    pst1.setString(3, titleviewfield.getText());
                                    pst1.setInt(4, menu.getSelectedIndex());
                                    pst1.setString(5, areaview.getText());
                                    pst1.executeUpdate();
                                    JOptionPane.showMessageDialog(new JFrame(), "Note Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error in updatebtnfunction1");
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        return null;
    }

    public static ActionListener updatefunction1(){
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Visibiilityfalse();
                DisplayListView1();
                EnablingElementsInList1();
                updatebtn.setVisible(true);
            }
        });
        return null;
    }

    public static ActionListener deletefunction1(){
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Visibiilityfalse();;
                DisplayListView1();
                deletebtn.setVisible(true);
            }
        });
        return null;
    }
    
    
    // All primary functions given below 
    
    public static void ColorSetting(){
        
        // All foreground Colors are below
        
        logout.setForeground(Color.white);
        todo.setForeground(Color.CYAN);
        create.setForeground(Color.white);
        update.setForeground(Color.white);
        delete.setForeground(Color.white);
        view.setForeground(Color.white);
        
        note.setForeground(Color.white);
        mimp.setForeground(Color.white);
        imp.setForeground(Color.white);
        nimp.setForeground(Color.white);
        backselect.setForeground(Color.white);
        updatebtn.setForeground(Color.white);
        deletebtn.setForeground(Color.white);
        backbtn.setForeground(Color.white);
        backview.setForeground(Color.white);
        
        // All Background colors are below
        
        logout.setBackground(lightpurple);
        
        create.setBackground(lightgreen);
        update.setBackground(lightorange);
        delete.setBackground(lightred);
        view.setBackground(lightblue);
        
        note.setBackground(lightgreen);
        mimp.setBackground(lightpurple);
        imp.setBackground(lightorange);
        nimp.setBackground(lightred);
        backselect.setBackground(lightblue);

        updatebtn.setBackground(lightorange);
        deletebtn.setBackground(lightred);
        backbtn.setBackground(lightblue);
        backview.setBackground(lightblue);
    }
    
    public static void VisibilitySetting(){
        
        logout.setVisible(true);
        create.setVisible(true);
        update.setVisible(true);
        delete.setVisible(true);
        view.setVisible(true);
        todo.setVisible(true);
        
        titlecreate.setVisible(false);
        titleenter.setVisible(false);
        areabelow.setVisible(false);
        scrollview.setVisible(false);
        textbelow.setVisible(false);
        textimp.setVisible(false);
        mimp.setVisible(false);
        selectmimp.setVisible(false);
        imp.setVisible(false);
        selectimp.setVisible(false);
        nimp.setVisible(false);
        selectnimp.setVisible(false);
        note.setVisible(false);
        backselect.setVisible(false);
        
        backbtn.setVisible(false);
        choose.setVisible(false);
        updatebtn.setVisible(false);
        deletebtn.setVisible(false);
    }
    
    public static void BoundSetting(){
        
        todo.setBounds(275, 50, 500, 80);
        create.setBounds( 350, 200, 200, 30);
        update.setBounds(350, 280, 200, 30);
        delete.setBounds(350, 360, 200, 30);
        view.setBounds(350, 440, 200, 30);
        logout.setBounds(350, 520, 200, 30);
        
        titlecreate.setBounds( 280, 25, 300, 60);
        titleenter.setBounds( 280, 85, 300, 30);
        textbelow.setBounds( 50, 120, 400, 60);
        areabelow.setBounds( 50, 200, 350, 200);
        scrollview.setBounds(50, 200, 350, 200);
        textimp.setBounds( 500, 120, 400, 60);
        mimp.setBounds( 550, 200, 200, 30);
        selectmimp.setBounds( 500, 230, 350, 30);
        imp.setBounds( 550, 280, 200, 30);
        selectimp.setBounds( 500, 310, 350, 30);
        nimp.setBounds( 550, 360, 200, 30);
        selectnimp.setBounds( 500, 390, 350, 30);
        note.setBounds( 350, 450, 200, 30);
        backselect.setBounds( 350, 530, 200, 30);

        updatebtn.setBounds(350, 450, 200, 30);
        deletebtn.setBounds(350, 450, 200, 30);
    }
    
    public static void FontSetting(){
        
        todo.setFont(new Font("ALGERIAN",Font.BOLD,70));
        
        textbelow.setFont(new Font("ALGERIAN",Font.BOLD,30));
        textimp.setFont(new Font("ALGERIAN",Font.BOLD,30));
        titlecreate.setFont(new Font("ALGERIAN",Font.BOLD,30));
        selectmimp.setFont(new Font("ALGERIAN",Font.BOLD,20));
        selectimp.setFont(new Font("ALGERIAN",Font.BOLD,20));
        selectnimp.setFont(new Font("ALGERIAN",Font.BOLD,20));
        
    }
    
    public static void ListenerSetting(){
        
        // All ActionListeners given below are
        
        create.addActionListener(createfunction1());
        note.addActionListener(notefunction1());
        logout.addActionListener(logoutfunction1());
        
        backselect.addActionListener(backselectfunction1());
        
        view.addActionListener(viewfunction1());
        
        backview.addActionListener(backviewfunction1());
        backbtn.addActionListener(backbtnfunction1());
        updatebtn.addActionListener(updatebtnfunction1());
        update.addActionListener(updatefunction1());
        delete.addActionListener(deletefunction1());
        deletebtn.addActionListener(deletebtnfunction1(getID(),index));
        
        // All MouseListeners given below are as follows
        
        logout.addMouseListener(logoutfunction2());
        create.addMouseListener(createfunction2());
        update.addMouseListener(updatefunction2());
        delete.addMouseListener(deletefunction2());
        view.addMouseListener(viewfunction2());
        
        note.addMouseListener(notefunction2());
        
        mimp.addMouseListener(mimpfunction2());
        mimp.addMouseListener(mimpfunction3());
        imp.addMouseListener(impfunction2());
        imp.addMouseListener(impfunction3());
        nimp.addMouseListener(nimpfunction2());
        nimp.addMouseListener(nimpfunction3());
        backselect.addMouseListener(backselectfunction2());
        updatebtn.addMouseListener(updatebtnfunction2());
        deletebtn.addMouseListener(deletebtnfunction2());
        backbtn.addMouseListener(backbtnfunction2());
        backview.addMouseListener(backviewfunction2());
    }
    
    public static void frame(){
        // Basic initialization of any particular frame in any java application
        f.setVisible(true);
        f.setResizable(false);
        f.setSize(900,650);
        f.setLayout(null);
        f.setTitle("Todo List");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // adding and setting the elements in the swing window frame in java 
        f.setIconImage(icon);
        
        f.add(create);f.add(view);f.add(delete);f.add(update);f.add(todo);f.add(logout);
        
        f.add(titlecreate);f.add(titleenter);
        f.add(textbelow);/*scrollbelow.add(areabelow);f.add(scrollbelow);*/f.add(areabelow);
        f.add(textimp);f.add(mimp);f.add(selectmimp);f.add(imp);f.add(selectimp);f.add(nimp);f.add(selectnimp);
        f.add(backselect);f.add(note);
        panelview.add(scrollview);scrollview.add(areaview);
        f.add(titleview);f.add(titleviewfield);f.add(textview);f.add(areaview);f.add(indexview);f.add(prefview);f.add(menu);f.add(next);f.add(previous);f.add(panelview);f.add(backview);
        f.add(message);f.add(mes);f.add(backbtn);f.add(choose);f.add(updatebtn);f.add(deletebtn);
        
        ListenerSetting();
        
        VisibilitySetting();
        
        FontSetting();
        
        ColorSetting();
        
        BoundSetting();
        
        
    }


    public static void main(String[] args) {
        frame();

    }
}
