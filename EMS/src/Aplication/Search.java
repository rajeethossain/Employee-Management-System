package Aplication;
import Client.Client;
import Login.*;
import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JLabel label1 = new JLabel("Employe ID");
    JLabel label2 = new JLabel("Name");
    JLabel label3 = new JLabel("Bank Account");
    JLabel label4 = new JLabel("Department");
    JLabel label5 = new JLabel("Designation");
    JLabel label6 = new JLabel("Area");
    JLabel label7 = new JLabel("Mobile No");
    JLabel label8 = new JLabel("Email");
    JLabel label9 = new JLabel("Address");
    JLabel label10 = new JLabel("Total Salary");

    JLabel searchLabel = new JLabel("Employe ID");

    JTextField field1 = new JTextField(22);
    JTextField field2 = new JTextField(22);
    JTextField field3 = new JTextField(22);
    JTextField field4 = new JTextField(22);
    JTextField field5 = new JTextField(22);
    JTextField field6 = new JTextField(22);
    JTextField field7 = new JTextField(22);
    JTextField field8 = new JTextField(22);
    JTextField field9 = new JTextField(22);
    JTextField field10 = new JTextField(22);

    public JTextField searchField = new JTextField(22);
    JTextField displayField = new JTextField(36);

    JButton button1 = new JButton("Show");
    JButton button2 = new JButton("New User");
    JButton button3 = new JButton("Logout");
    JButton button4 = new JButton("Update Data");
    JButton button5 = new JButton("Salary Breakdown");
    JButton button6 = new JButton("Staff List");
    JButton button7 = new JButton("Salary Disbursement");

    public void showDetails(EmployeData person){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        field7.setText("");
        field8.setText("");
        field9.setText("");
        field10.setText("");
        displayField.setText("");

        String searchData = searchField.getText().toUpperCase();

        int flag = 0;
        if (!searchField.getText().equals("")) {
            for (EmployeData data : person.recordList) {
                if (data.getId().equals(searchData)) {
                    field1.setText(data.getId());
                    field2.setText(data.getName());
                    field3.setText(data.getBankAcc());
                    field4.setText(data.getDepartment());
                    field5.setText(data.getDesignation());
                    field6.setText(data.getArea());
                    field7.setText(data.getMobNumber());
                    field8.setText(data.getEmail());
                    field9.setText(data.getAddress());
                    field10.setText(data.getSalaryT()+"");
                    flag = 1;
                }
            }
            if (flag == 0) {
                displayField.setText("Employee not Found");
            }
        } else {
            displayField.setText("Please Enter an Employee ID");
        }
    }


    public Search() {
        setTitle("EMS->Employee Information");
        setSize(450, 610);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(410, 70));
        panel1.setBorder(BorderFactory.createTitledBorder("Search"));
        panel2.setLayout(new GridLayout(10, 2));
        panel2.setPreferredSize(new Dimension(410, 300));
        panel2.setBorder(BorderFactory.createTitledBorder("Details"));
        panel3.setPreferredSize(new Dimension(410, 100));
        panel3.setBorder(BorderFactory.createTitledBorder("Actions"));

        field1.setEditable(false);
        field2.setEditable(false);
        field3.setEditable(false);
        field4.setEditable(false);
        field5.setEditable(false);
        field6.setEditable(false);
        field7.setEditable(false);
        field8.setEditable(false);
        field9.setEditable(false);
        field10.setEditable(false);

        displayField.setEditable(false);

        EmployeData person = new EmployeData();
        Client client = new Client();

        person.employeeList();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetails(person);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Registration registration = new Registration();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UpdateData update = new UpdateData();
                update.searchField.setText(field1.getText());
                update.showDataU(person, update.positionU);
                update.displayField.setText("");
                update.frameid = 0;
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SalaryBreakdown breakdown = new SalaryBreakdown();
                breakdown.searchField.setText(field1.getText());
                breakdown.showSalaryBreakdown(person);
                breakdown.displayField.setText("");
                breakdown.frameid = 0;
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StaffList stafflist = new StaffList();
                stafflist.showAll(person);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SalaryDisbursement disbursement = new SalaryDisbursement();
                disbursement.searchField.setText(field1.getText());
                disbursement.showSalaryDisbursement(person);
                disbursement.displayField.setText("");
            }
        });

        panel1.add(searchLabel);
        panel1.add(searchField);
        panel1.add(button1);

        panel2.add(label1);
        panel2.add(field1);
        panel2.add(label2);
        panel2.add(field2);
        panel2.add(label3);
        panel2.add(field3);
        panel2.add(label4);
        panel2.add(field4);
        panel2.add(label5);
        panel2.add(field5);
        panel2.add(label6);
        panel2.add(field6);
        panel2.add(label7);
        panel2.add(field7);
        panel2.add(label8);
        panel2.add(field8);
        panel2.add(label9);
        panel2.add(field9);
        panel2.add(label10);
        panel2.add(field10);

        panel5.add(displayField);

        panel3.add(button6);
        panel3.add(button5);
        panel3.add(button4);
        panel3.add(button7);

        panel4.add(button3);
        panel4.add(button2);

        add(panel1);
        add(panel2);
        add(panel5);
        add(panel3);
        add(panel4);
        setVisible(true);

    }
}

