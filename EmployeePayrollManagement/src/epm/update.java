package epm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField txteid;
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtdob;
	private JTextField txtemail;
	private JTextField txtcontact;
	private JTextField txtpaddress;
	private JTextField txtpc;
	private JTextField txtdept;
	private JTextField txtdesignation;
	private JTextField txtdh;
	private JTextField txtsalary;
	private JTextField txtjob;
	private JTextField txtcaddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String gender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	/**
	 * Create the frame.
	 */
	
	public update() {
		setTitle("Employee Registration");
		
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID:");
		lblNewLabel_1.setBounds(5, 5, 111, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Permenant Address:");
		lblNewLabel_9.setBounds(370, 5, 146, 55);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(5, 60, 64, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Post Code:");
		lblNewLabel_3.setBounds(370, 60, 96, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name:");
		lblNewLabel_4.setBounds(5, 115, 64, 55);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Department:");
		lblNewLabel_5.setBounds(370, 115, 91, 55);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gender:");
		lblNewLabel_6.setBounds(5, 170, 64, 55);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Designation:");
		lblNewLabel_7.setBounds(370, 170, 91, 55);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Date Of Birth:");
		lblNewLabel_10.setBounds(5, 225, 91, 55);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("Date Hired:");
		lblNewLabel_8.setBounds(370, 225, 64, 55);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(5, 280, 57, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_12 = new JLabel("Basic Salary:");
		lblNewLabel_12.setBounds(370, 280, 74, 55);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("Contact:");
		lblNewLabel_11.setBounds(5, 335, 57, 55);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_14 = new JLabel("Job Title:");
		lblNewLabel_14.setBounds(370, 335, 74, 55);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_13 = new JLabel("Current Address:");
		lblNewLabel_13.setBounds(5, 390, 133, 55);
		contentPane.add(lblNewLabel_13);
		
		txteid = new JTextField();
		txteid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				try {
					String eid=txteid.getText();
					pst=(PreparedStatement) con.prepareStatement("select * from register where eid=?");
					pst.setString(1, eid);
					ResultSet rs=pst.executeQuery();
					
					  if(rs.next()==true)
					  {
			
						  String fname=rs.getString(3);
						  String lname=rs.getString(4);
						  String DOB=rs.getString(5);
						  String Email=rs.getString(6);
						  String Contact=rs.getString(7);
						  String Address1=rs.getString(8);
						  String Address2=rs.getString(9);
						  String postcodei=rs.getString(10);
						  String department=rs.getString(11);
						  String designation=rs.getString(12);
						  String datehired=rs.getString(13);
						  String salary=rs.getString(14);
						  String job=rs.getString(15);
						  
						  
						  	txtfname.setText(fname);
							txtlname.setText(lname);
							txtdob.setText(DOB);
							txtemail.setText(Email);
							txtcontact.setText(Contact);
							txtcaddress.setText(Address1);
							txtpaddress.setText(Address2);
							txtpc.setText(postcodei);
							txtdept.setText(department);
							txtdesignation.setText(designation);
							txtdh.setText(datehired);
							txtsalary.setText(salary);
							txtjob.setText(job);   

					  }
					  else {
						  
						    txteid.setText("");
							txtfname.setText("");
							txtlname.setText("");
							//gender;
							txtdob.setText("");
							txtemail.setText("");
							txtcontact.setText("");
							txtcaddress.setText("");
							txtpaddress.setText("");
							txtpc.setText("");
							txtdept.setText("");
							txtdesignation.setText("");
							txtdh.setText("");
							txtsalary.setText("");
							txtjob.setText("");
						 
					}
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			
			}
		});
		txteid.setBounds(85, 22, 146, 20);
		contentPane.add(txteid);
		txteid.setColumns(10);
		
		txtfname = new JTextField();
		txtfname.setBounds(85, 77, 146, 20);
		txtfname.setColumns(10);
		contentPane.add(txtfname);
		
		txtlname = new JTextField();
		txtlname.setBounds(85, 132, 146, 20);
		txtlname.setColumns(10);
		contentPane.add(txtlname);
		
		txtdob = new JTextField();
		txtdob.setBounds(85, 242, 146, 20);
		txtdob.setColumns(10);
		contentPane.add(txtdob);
		
		txtemail = new JTextField();
		txtemail.setBounds(85, 297, 146, 20);
		txtemail.setColumns(10);
		contentPane.add(txtemail);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(85, 352, 146, 20);
		txtcontact.setColumns(10);
		contentPane.add(txtcontact);
		
		txtpaddress = new JTextField();
		txtpaddress.setBounds(497, 9, 234, 47);
		txtpaddress.setColumns(10);
		contentPane.add(txtpaddress);
		
		txtpc = new JTextField();
		txtpc.setBounds(459, 77, 146, 20);
		txtpc.setColumns(10);
		contentPane.add(txtpc);
		
		txtdept = new JTextField();
		txtdept.setBounds(459, 132, 146, 20);
		txtdept.setColumns(10);
		contentPane.add(txtdept);
		
		txtdesignation = new JTextField();
		txtdesignation.setBounds(459, 187, 146, 20);
		txtdesignation.setColumns(10);
		contentPane.add(txtdesignation);
		
		txtdh = new JTextField();
		txtdh.setBounds(459, 242, 146, 20);
		txtdh.setColumns(10);
		contentPane.add(txtdh);
		
		txtsalary = new JTextField();
		txtsalary.setBounds(459, 297, 146, 20);
		txtsalary.setColumns(10);
		contentPane.add(txtsalary);
		
		txtjob = new JTextField();
		txtjob.setBounds(459, 352, 146, 20);
		txtjob.setColumns(10);
		contentPane.add(txtjob);
		
		txtcaddress = new JTextField();
		txtcaddress.setBounds(104, 398, 234, 47);
		txtcaddress.setColumns(10);
		contentPane.add(txtcaddress);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gender = "male";
			}
		});
		rdbtnNewRadioButton.setBounds(75, 186, 63, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gender = "female";
			}
		});
		rdbtnFemale.setBounds(140, 186, 74, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		buttonGroup.add(rdbtnOther);
		rdbtnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gender = "other";
			}
		});
		rdbtnOther.setBounds(221, 186, 74, 23);
		contentPane.add(rdbtnOther);
		
		JButton btnNewButton = new JButton("Update Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String Eid = txteid.getText();
				
				String firstname= txtfname.getText();
				String lastname = txtlname.getText();
				//String Gender = gender;
				String DOB =txtdob.getText();
				String Email = txtemail.getText();
				String Contact =txtcontact.getText();
				String Address1 =txtcaddress.getText();
				String Address2 =txtpaddress.getText();
				String postalcodei =txtpc.getText();
				String department =txtdept.getText();
				String designation = txtdesignation.getText();
				String datehired =txtdh.getText();
				String salary=txtsalary.getText();
				String job = txtjob.getText();
				
				
				try 
				{
					pst=(PreparedStatement) con.prepareStatement("update register set  firstname=?,lastname=?, "
							+ "DOB=? , Email=?,Contact =?,Address1=?,Address2=?,postalcodei=?,"
							+ "department=?,designation=?,datehired=?,salary=?,job=? where eid=?");
					
					pst.setString(1, firstname);
					pst.setString(2, lastname);
					//pst.setString(2, Gender);
					pst.setString(3, DOB);
					pst.setString(4, Email);
					pst.setString(5, Contact);
					pst.setString(6, Address1);
					pst.setString(7, Address2);
					pst.setString(8, postalcodei);
					pst.setString(9, department);
					pst.setString(10, designation);
					pst.setString(11, datehired);
					pst.setString(12, salary);
					pst.setString(13, job);
					pst.setString(14, Eid);
					
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Record Updated..");
					}
				
				   catch(SQLException e1)
				
				    {
					   	e1.printStackTrace();
				    }
				
				
		
			}
		});
		btnNewButton.setBounds(569, 395, 136, 45);
		contentPane.add(btnNewButton);
		
		
	}
}
