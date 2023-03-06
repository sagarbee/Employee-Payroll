package epm;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        super("Employee Management System");
        setTitle("Welcome To Main System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(51, 51, 51));

        // Create employee menu and sub-menu items
        JMenu employeeMenu = new JMenu("Employee Details");
        employeeMenu.setForeground(Color.WHITE);
        employeeMenu.setFont(new Font("Roboto", Font.PLAIN, 14));

        JMenuItem registerItem = new JMenuItem("Register Employee");
        registerItem.setForeground(Color.WHITE);
        registerItem.setBackground(new Color(45, 52, 54));
        registerItem.setFont(new Font("Roboto", Font.PLAIN, 14));

        JMenuItem deRegisterItem = new JMenuItem("De-Register Employee");
        deRegisterItem.setForeground(Color.WHITE);
        deRegisterItem.setBackground(new Color(45, 52, 54));
        deRegisterItem.setFont(new Font("Roboto", Font.PLAIN, 14));

        JMenuItem updateItem = new JMenuItem("Update Employee Details");
        updateItem.setForeground(Color.WHITE);
        updateItem.setBackground(new Color(45, 52, 54));
        updateItem.setFont(new Font("Roboto", Font.PLAIN, 14));

        JMenuItem searchItem = new JMenuItem("Search Employee Details");
        searchItem.setForeground(Color.WHITE);
        searchItem.setBackground(new Color(45, 52, 54));
        searchItem.setFont(new Font("Roboto", Font.PLAIN, 14));

        employeeMenu.add(registerItem);
        employeeMenu.addSeparator();
        employeeMenu.add(deRegisterItem);
        employeeMenu.addSeparator();
        employeeMenu.add(updateItem);
        employeeMenu.addSeparator();
        employeeMenu.add(searchItem);

        // Create salary menu
        JMenu salaryMenu = new JMenu("Salary Details");
        salaryMenu.setForeground(Color.WHITE);
        salaryMenu.setFont(new Font("Roboto", Font.PLAIN, 14));

        // Add menus to menu bar
        menuBar.add(employeeMenu);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setMaximumSize(new Dimension(20, 20));
        separator_1.setOrientation(SwingConstants.VERTICAL);
        menuBar.add(separator_1);
        menuBar.add(salaryMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Fill Salary Details");
        salaryMenu.add(mntmNewMenuItem);
        mntmNewMenuItem.setForeground(Color.WHITE);
        mntmNewMenuItem.setBackground(new Color(45, 52, 54));
        mntmNewMenuItem.setFont(new Font("Roboto", Font.PLAIN, 14));
        
        JSeparator separator = new JSeparator();
        salaryMenu.add(separator);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salary Report");
        salaryMenu.add(mntmNewMenuItem_1);
        mntmNewMenuItem_1.setForeground(Color.WHITE);
        mntmNewMenuItem_1.setBackground(new Color(45, 52, 54));
        mntmNewMenuItem_1.setFont(new Font("Roboto", Font.PLAIN, 14));
        

        setJMenuBar(menuBar);

        // Set background color
        getContentPane().setBackground(new Color(236, 240, 241));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
