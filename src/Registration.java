import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration{

    public static String name,username,emailid,password,checkuser;
    public static int ID=0;

    public static JFrame f = new JFrame();
    public static JButton exit = new JButton("Exit");
    public static JButton back = new JButton("Back");
    public static JLabel namelabel = new JLabel("Name");
    public static JLabel usernamelabel = new JLabel("Username");
    public static JLabel passwordlabel = new JLabel("Password");
    public static JLabel emailidlabel = new JLabel("Email ID");
    public static JTextField namefield = new JTextField();
    public static JTextField emailidfield = new JTextField();
    public static JTextField usernamefield = new JTextField();
    public static JPasswordField passwordfield = new JPasswordField();
    public static JLabel loginlabel = new JLabel("Login In");
    public static JLabel signuplabel = new JLabel("Sign Up");
    public static JButton login = new JButton("Log In");
    public static JButton signup = new JButton("Sign Up");
    public static JButton signupbtn = new JButton("Sign Up");
    public static JButton loginbtn = new JButton("Log In");

    public static Connection conn = DB.dbconnect();

    public static void signupbounds(){
        back.setBounds(150, 400, 200, 30);
        signuplabel.setBounds(200, 25, 200, 30);
        signupbtn.setBounds(150, 325, 200, 30);
        namelabel.setBounds(50, 80, 150, 30);
        namefield.setBounds(200, 80, 200, 30);
        usernamelabel.setBounds(50, 140, 150, 30);
        usernamefield.setBounds(200, 140, 200, 30);
        emailidlabel.setBounds(50, 200, 150, 30);
        emailidfield.setBounds(200, 200, 200, 30);
        passwordlabel.setBounds(50, 260, 150, 30);
        passwordfield.setBounds(200, 260, 200, 30);
    }

    public static void loginbounds(){
        loginlabel.setBounds(200, 25, 200, 30);
        back.setBounds(150, 400, 200, 30);
        usernamelabel.setBounds(50, 100, 150, 30);
        usernamefield.setBounds(200, 100, 200, 30);
        passwordlabel.setBounds(50, 175, 150, 30);
        passwordfield.setBounds(200, 175, 200, 30);
        loginbtn.setBounds(150, 325, 200, 30);
    }

    public static void ClearAll(){
        namefield.setText("");
        usernamefield.setText("");
        emailidfield.setText("");
        passwordfield.setText("");
    }

    public static ActionListener loginfunction1(){
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                exit.setVisible(false);
                signup.setVisible(false);
                back.setVisible(true);
                loginlabel.setVisible(true);
                usernamelabel.setVisible(true);
                usernamefield.setVisible(true);
                passwordlabel.setVisible(true);
                passwordfield.setVisible(true);
                loginbtn.setVisible(true);
                loginbounds();
                ClearAll();
            }
        });
        return null;
    }
    
    public static ActionListener signupfunction1(){
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit.setVisible(false);
                signup.setVisible(false);
                login.setVisible(false);
                back.setVisible(true);
                signuplabel.setVisible(true);
                namelabel.setVisible(true);
                namefield.setVisible(true);
                usernamelabel.setVisible(true);
                usernamefield.setVisible(true);
                emailidlabel.setVisible(true);
                emailidfield.setVisible(true);
                passwordlabel.setVisible(true);
                passwordfield.setVisible(true);
                signupbtn.setVisible(true);
                signupbounds();
                ClearAll();
            }
        });
        return null;
    }

    public static ActionListener signupbtnfunction1(){
        signupbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    name = namefield.getText();
                    username = usernamefield.getText();
                    emailid = emailidfield.getText();
                    password = String.valueOf(passwordfield.getPassword());
                    PreparedStatement pst3 = conn.prepareStatement("select * from signup where username=?");
                    pst3.setString(1, username);
                    ResultSet rs3 = pst3.executeQuery();
                    PreparedStatement pst1 = conn.prepareStatement("select * from signup where emailid=?");
                    pst1.setString(1, emailid);
                    ResultSet rs = pst1.executeQuery();
                    if(rs3.next()){
                        JOptionPane.showMessageDialog(new JFrame(), "Username already exists", "Warning", JOptionPane.PLAIN_MESSAGE);
                    }
                    if(rs.next()){
                        JOptionPane.showMessageDialog(new JFrame(), "Email ID already exists", "Warning", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        if(name.equals("")||name.equals(" ")){
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter Name First", "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(username.equals("")||username.equals(" ")){
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter Username First", "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                        else if((emailid.equals("")||emailid.equals(" "))){
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter Email ID First", "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(password.equals("")||password.equals(" ")){
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter Password First", "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            PreparedStatement pst = conn.prepareStatement("insert into signup(ID,name,username,emailid,password) values(?,?,?,?,?)");
                            PreparedStatement pst2 = conn.prepareStatement("select * from signup where ID=?");
                            pst2.setInt(1, ID);
                            ResultSet rs2 = pst2.executeQuery();
                            if(rs2.next()){
                                ID++;
                            }
                            else{
                                pst.setInt(1, ID);
                                pst.setString(2, name);
                                pst.setString(3, username);
                                pst.setString(4, emailid);
                                pst.setString(5, password);
                                pst.executeUpdate();
                                ClearAll();
                                JOptionPane.showMessageDialog(new JFrame(), "You have Registered Successfully");
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        return null;
    }

    public static void setuser(){
        checkuser = username;
    }

    public static String getuser(){
        return checkuser;
    }

    public static ActionListener loginbtnfunction1(){
        loginbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    username = usernamefield.getText();
                    setuser();
                    password = String.valueOf(passwordfield.getPassword());
                    if(username.equals("")||username.equals(" ")){
                        JOptionPane.showMessageDialog(new JFrame(), "Please Enter Username First", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        PreparedStatement pst = conn.prepareStatement("select * from signup where username=? and password=?");
                        pst.setString(1, username);
                        pst.setString(2, password);
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                            f.dispose();
                            TodoD.frame();
                        }
                        else{
                            JOptionPane.showMessageDialog(new JFrame(), "Incorrect username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        return null;
    }
    
    public static ActionListener backfunction1(){
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                signup.setVisible(true);
                login.setVisible(true);
                exit.setVisible(true);
                back.setVisible(false);
                signuplabel.setVisible(false);
                namelabel.setVisible(false);
                namefield.setVisible(false);
                usernamelabel.setVisible(false);
                usernamefield.setVisible(false);
                emailidlabel.setVisible(false);
                emailidfield.setVisible(false);
                passwordlabel.setVisible(false);
                passwordfield.setVisible(false);
                signupbtn.setVisible(false);
                loginbtn.setVisible(false);
                loginlabel.setVisible(false);
            }
        });
        return null;
    }

    public static ActionListener exitfunction1(){
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        return null;
    }

    public static void ListenerSetting(){

        exit.addActionListener(exitfunction1());
        signup.addActionListener(signupfunction1());
        login.addActionListener(loginfunction1());
        back.addActionListener(backfunction1());
        signupbtn.addActionListener(signupbtnfunction1());
        loginbtn.addActionListener(loginbtnfunction1());

    }

    public static void FontSetting(){

        signuplabel.setFont(new Font("ALGERIAN",Font.BOLD,25));
        loginlabel.setFont(new Font("ALGERIAN",Font.BOLD,25));
        namelabel.setFont(new Font("ALGERIAN",Font.BOLD,20));
        usernamelabel.setFont(new Font("ALGERIAN",Font.BOLD,20));
        emailidlabel.setFont(new Font("ALGERIAN",Font.BOLD,20));
        passwordlabel.setFont(new Font("ALGERIAN",Font.BOLD,20));
    }

    public static void BoundSetting(){
        exit.setBounds(150, 300, 200, 30);
        signup.setBounds( 150, 100, 200, 30);
        login.setBounds( 150, 200, 200, 30);
        namelabel.setBounds( 2, 32, 200, 30);
        back.setBounds(150, 400, 200, 30);
        signuplabel.setBounds(200, 25, 200, 30);
        loginlabel.setBounds(150, 35, 200, 30);
        namelabel.setBounds(50, 80, 150, 30);
        namefield.setBounds(200, 80, 200, 30);
        usernamelabel.setBounds(50, 140, 150, 30);
        usernamefield.setBounds(200, 140, 200, 30);
        emailidlabel.setBounds(50, 200, 150, 30);
        emailidfield.setBounds(200, 200, 200, 30);
        passwordlabel.setBounds(50, 260, 150, 30);
        passwordfield.setBounds(200, 260, 200, 30);
    }
    
    public static void VisibilitySetting(){
        namelabel.setVisible(false);
        usernamelabel.setVisible(false);
        emailidlabel.setVisible(false);
        passwordlabel.setVisible(false);
        namefield.setVisible(false);
        usernamefield.setVisible(false);
        emailidfield.setVisible(false);
        passwordfield.setVisible(false);
        loginlabel.setVisible(false);
        signuplabel.setVisible(false);
        exit.setVisible(true);
        signup.setVisible(true);
        login.setVisible(true);
        back.setVisible(false);
        
    }

    public static void frame(){

        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        f.setTitle("Registration Form");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(namelabel);f.add(passwordlabel);f.add(emailidlabel);f.add(usernamelabel);f.add(signuplabel);f.add(loginlabel);
        f.add(namefield);f.add(emailidfield);f.add(passwordfield);f.add(usernamefield);
        f.add(signup);f.add(login);f.add(exit);f.add(back);f.add(loginbtn);f.add(signupbtn);

        ListenerSetting();

        BoundSetting();

        VisibilitySetting();

        FontSetting();
        
    }

    public static void main(String[] args) {
        frame();
    }

}