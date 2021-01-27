package Aplication;

import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEntry extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JLabel label1 = new JLabel("Employe ID");
    JLabel label2 = new JLabel("Name");
    JLabel label3 = new JLabel("Bank Account");
    JLabel label4 = new JLabel("Department");
    JLabel label5 = new JLabel("Designation");
    JLabel label6 = new JLabel("Area");
    JLabel label7 = new JLabel("Mobile No");
    JLabel label8 = new JLabel("Email");
    JLabel label9 = new JLabel("Address");
    JLabel label10 = new JLabel("Base Salary");
    JLabel label11 = new JLabel("Mobile Allowance");
    JLabel label12 = new JLabel("Medical Allowance");
    JLabel label13 = new JLabel("Experience Allowance");
    JLabel label14 = new JLabel("Education Allowance");
    JLabel label15 = new JLabel("Rent Allowance");
    JLabel label16 = new JLabel("Other Allowance");

    public static JTextField field1 = new JTextField(22);
    JTextField field2 = new JTextField("Required",22);
    JTextField field3 = new JTextField("Required",22);
//    JTextField field4 = new JTextField("N/A",22);
//    JTextField field5 = new JTextField("N/A",22);
//    JTextField field6 = new JTextField("N/A",22);
    JTextField field7 = new JTextField("N/A",22);
    JTextField field8 = new JTextField("N/A",22);
    JTextField field9 = new JTextField("N/A",22);
    JTextField field10 = new JTextField("0",22);
    JTextField field11 = new JTextField("0",22);
    JTextField field12 = new JTextField("0",22);
    JTextField field13 = new JTextField("0",22);
    JTextField field14 = new JTextField("0",22);
    JTextField field15 = new JTextField("0",22);
    JTextField field16 = new JTextField("0",22);

    JTextField displayField = new JTextField(36);

    JButton button1 = new JButton("Save");
    JButton button2 = new JButton("Done");
    JButton button3 = new JButton("Get ID");

    PositionList positionN = new PositionList();


    public NewEntry() {
        setTitle("Employee Entry");
        setSize(450, 580);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setLayout(new GridLayout(16, 2));
        panel1.setPreferredSize(new Dimension(410, 410));
        panel1.setBorder(BorderFactory.createTitledBorder("Details"));
        panel2.setPreferredSize(new Dimension(410, 70));
        panel2.setBorder(BorderFactory.createTitledBorder("Actions"));
        displayField.setEditable(false);
        field1.setEditable(false);
        field1.setText("");

        EmployeData personN = new EmployeData();

        personN.employeeList();
        positionN.departmentList();
        positionN.designationList();
        positionN.areaList();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                if (!field1.getText().equals("") && !field2.getText().equals("") && !field2.getText().equals("Required") && !field3.getText().equals("") && !field3.getText().equals("Required") && !positionN.comboBox1.getSelectedItem().equals("Please Select") && !positionN.comboBox2.getSelectedItem().equals("Select Department") && !positionN.comboBox2.getSelectedItem().equals("Please Select") && !positionN.comboBox3.getSelectedItem().equals("Please Select")) {
                    personN.setId(field1.getText());
                    personN.setName(field2.getText());
                    personN.setBankAcc(field3.getText());
                    personN.setDepartment(positionN.comboBox1.getSelectedItem()+"");
                    personN.setDesignation(positionN.comboBox2.getSelectedItem()+"");
                    personN.setArea(positionN.comboBox3.getSelectedItem()+"");
                    personN.setMobNumber(field7.getText());
                    personN.setEmail(field8.getText());
                    personN.setAddress(field9.getText());
                    try {
                        personN.setSalaryB(Integer.parseInt(field10.getText()));
                        personN.setMobAll(Integer.parseInt(field11.getText()));
                        personN.setMedAll(Integer.parseInt(field12.getText()));
                        personN.setExpAll(Integer.parseInt(field13.getText()));
                        personN.setEduAll(Integer.parseInt(field14.getText()));
                        personN.setRentAll(Integer.parseInt(field15.getText()));
                        personN.setOtherAll(Integer.parseInt(field16.getText()));
                    }
                    catch (Exception f){
                        displayField.setText("Invalid Input");
                        flag = 1;
                    }

                    if(flag == 0) {
                        personN.saveData();
                        personN.saveOTDT();
                        dispose();
                        NewEntry entry = new NewEntry();
                        entry.displayField.setText("Data Saved");
                    }
                } else {
                    displayField.setText("Please Enter Required Data");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UpdateData updateData = new UpdateData();
            }
        });


        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(field2);
        panel1.add(label3);
        panel1.add(field3);
        panel1.add(label4);
        panel1.add(positionN.comboBox1);
        panel1.add(label5);
        panel1.add(positionN.comboBox2);
        panel1.add(label6);
        panel1.add(positionN.comboBox3);
        panel1.add(label7);
        panel1.add(field7);
        panel1.add(label8);
        panel1.add(field8);
        panel1.add(label9);
        panel1.add(field9);
        panel1.add(label10);
        panel1.add(field10);
        panel1.add(label11);
        panel1.add(field11);
        panel1.add(label12);
        panel1.add(field12);
        panel1.add(label13);
        panel1.add(field13);
        panel1.add(label14);
        panel1.add(field14);
        panel1.add(label15);
        panel1.add(field15);
        panel1.add(label16);
        panel1.add(field16);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        panel3.add(displayField);

        add(panel1);
        add(panel3);
        add(panel2);

        setVisible(true);

    }
}

