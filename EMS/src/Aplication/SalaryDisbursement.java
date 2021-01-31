package Aplication;
import Client.Client;
import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaryDisbursement extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JLabel label1 = new JLabel("Employe ID");
    JLabel label2 = new JLabel("Name");
    JLabel label3 = new JLabel("Bank Account");
    JLabel label4 = new JLabel("Total Salary");
    JLabel label5 = new JLabel("Bonus");
    JLabel label6 = new JLabel("Overtime");
    JLabel label7 = new JLabel("Others");
    JLabel label8 = new JLabel("Deduction");
    JLabel label9 = new JLabel("Disbursement");
//    JLabel label10 = new JLabel("Other Allowance");
//    JLabel label11 = new JLabel("Total Salary");

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
//    JTextField field10 = new JTextField(22);
//    JTextField field11 = new JTextField(22);

    JTextField searchField = new JTextField(22);
    JTextField displayField = new JTextField(36);

    JButton button1 = new JButton("Show");
    JButton button2 = new JButton("Done");
    JButton button3 = new JButton("Edit");
    JButton button4 = new JButton("Addition");
    JButton button5 = new JButton("Deduction");
    JButton button6 = new JButton("Bonus");
    JButton button7 = new JButton("Salary Breakdown");
    JButton button8 = new JButton("Generate");


    public void showSalaryDisbursement(EmployeData person){
        Client client = new Client();
        client.updateData();
        OTDT otdt = new OTDT();
        person.employeeList();

        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        field7.setText("");
        field8.setText("");
        field9.setText("");
//        field10.setText("");
//        field11.setText("");
        displayField.setText("");

        String searchData = searchField.getText().toUpperCase();

        int flag = 0;
        if (!searchField.getText().equals("")) {
            for (EmployeData data : person.recordList) {
                if (data.getId().equals(searchData)) {
                    field1.setText(data.getId());
                    field2.setText(data.getName());
                    field3.setText(data.getBankAcc());
                    field4.setText(data.getSalaryT()+"");
                    field5.setText(data.getBonus()+"");
                    field6.setText(data.getOT()+"");
                    field7.setText(data.getCommission()+"");
                    field8.setText(data.getDT()+"");
                    field9.setText(data.getSalaryDisbursement()+"");
//                    field10.setText(data.getOtherAll()+"");
//                    field11.setText(data.getSalaryT()+"");
                    if(data.getBonus() == 1){
                        button6.setBackground(Color.green);
                    }
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


    public SalaryDisbursement(int x, int y) {
        setTitle("EMS->Salary Disbursement");
        setBounds(x, y, 450, 560);
//        setSize(450, 560);
//        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(410, 70));
        panel1.setBorder(BorderFactory.createTitledBorder("Search"));
        panel2.setLayout(new GridLayout(9, 2));
        panel2.setPreferredSize(new Dimension(410, 260));
        panel2.setBorder(BorderFactory.createTitledBorder("Details"));
        panel3.setPreferredSize(new Dimension(410, 90));
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
//        field10.setEditable(false);
//        field11.setEditable(false);

        displayField.setEditable(false);

//        Client client = new Client();
//        OTDT otdt = new OTDT();
        EmployeData person = new EmployeData();

        person.employeeList();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSalaryDisbursement(person);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (EmployeData dataU : person.recordList) {
//                    dataU.setOT(0);
//                    dataU.setDT(0);
//                    dataU.setCommission(0);
//
//                    dataU.updateData();
//                }

                person.saveDataUpdate();
                displayField.setText("Data Updated");

                dispose();
                Search search = new Search(getX(), getY());
                search.searchField.setText(field1.getText());
                search.showDetails(person);
                search.displayField.setText("");
            }
        });

//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                UpdateData edit = new UpdateData();
//                edit.searchField.setText(field1.getText());
//                edit.showDataU(person, edit.positionU);
//            }
//        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!field1.getText().equals("")) {
                    dispose();
                    Addition addition = new Addition(getX(), getY());
                    addition.showOvertime(person, field1.getText());
                }
                else{
                    displayField.setText("Please Enter an Employee ID");
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!field1.getText().equals("")) {
                    dispose();
                    Deduction deduction = new Deduction(getX(), getY());
                    deduction.showDeduction(person, field1.getText());
                }
                else{
                    displayField.setText("Please Enter an Employee ID");
                }

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (EmployeData data : person.recordList) {
                    if (data.getId().equals(field1.getText())) {
                        if(button6.getBackground() == Color.green){
                            button6.setBackground(null);
                            data.setBonus(0);
                            field5.setText("0");
                        }
                        else {
                            button6.setBackground(Color.green);
                            data.setBonus(1);
                            field5.setText("1");
                        }
                    }
                }
                for (EmployeData dataU : person.recordList) {
                    dataU.updateOTDT();
                }
                person.saveOTDTUpdate();
                displayField.setText("Data Updated");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SalaryBreakdown breakdown = new SalaryBreakdown(getX(), getY());
                breakdown.searchField.setText(field1.getText());
                breakdown.showSalaryBreakdown(person);
                breakdown.displayField.setText("");
                breakdown.frameid = 1;
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DisbursementOutput output = new DisbursementOutput();
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
//        panel2.add(label10);
//        panel2.add(field10);
//        panel2.add(label11);
//        panel2.add(field11);

        panel3.add(button4);
        panel3.add(button5);
        panel3.add(button7);
        panel3.add(button6);
        panel3.add(button8);

        panel5.add(button2);

        panel4.add(displayField);

        add(panel1);
        add(panel2);
        add(panel4);
        add(panel3);
        add(panel5);

        setVisible(true);

    }
}

