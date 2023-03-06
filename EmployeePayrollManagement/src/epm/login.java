package epm;

import javax.swing.*;

import epm.Main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login extends JFrame {

    private JTextField txtusername;
    private JPasswordField txtpassword;

    public static void main(String[] args) {
        new login();
    
    }

    Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public void Connect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/epm","root","Sagar@123");
			
		}
		catch(ClassNotFoundException ex)
		{
			
		}
		catch(SQLException ex)
		{
			
		}
	}
	

    
    public login() {
    	super("login Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JLabel usernameLabel = new JLabel("Username:");
        txtusername = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        txtpassword = new JPasswordField();
        
    	Connect();

        
        JButton logininButton = new JButton("login");
        logininButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		try {
					Statement stmt = con.createStatement();
					String sql = "select * from users where username = '"+txtusername.getText()+"' and password = '"+txtpassword.getText().toString()+"' ";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successfull..!!","Login Success..!!",JOptionPane.INFORMATION_MESSAGE);
						Main.main(null);
						dispose();

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Check The Credentials..!!");
					}
					con.close();
        		}catch(Exception e1)
        		{
        			JOptionPane.showMessageDialog(null, "Database Error..!!", "Database Error", 2);
        		}
        	
        	}
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		txtusername.setText(null);
        		txtpassword.setText(null);
        		
        	}
        });

        panel.add(usernameLabel);
        panel.add(txtusername);
        panel.add(passwordLabel);
        panel.add(txtpassword);
        panel.add(logininButton);
        panel.add(clearButton);

        getContentPane().add(panel, BorderLayout.CENTER);

        Color bgColor = new Color(37, 37, 37);
        Color fgColor = Color.WHITE;
        Color accentColor = new Color(90, 200, 250);

        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        Font font = new Font("Segoe UI", Font.PLAIN, 14);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(fgColor);
        passwordLabel.setFont(font);
        passwordLabel.setForeground(fgColor);
        txtusername.setFont(font);
        txtpassword.setFont(font);
        logininButton.setFont(font);
        clearButton.setFont(font);

        logininButton.setBackground(accentColor);
        logininButton.setForeground(Color.WHITE);
        logininButton.setBorderPainted(false);
        logininButton.setFocusPainted(false);

        clearButton.setBackground(bgColor);
        clearButton.setForeground(fgColor);
        clearButton.setBorder(BorderFactory.createLineBorder(accentColor));
        clearButton.setFocusPainted(false);

        txtusername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, accentColor));
        txtusername.setBackground(bgColor);
        txtusername.setForeground(fgColor);
        txtusername.setCaretColor(fgColor);

        txtpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, accentColor));
        txtpassword.setBackground(bgColor);
        txtpassword.setForeground(fgColor);
        txtpassword.setCaretColor(fgColor);

        setVisible(true);
    }
}

