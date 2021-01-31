package Aplication;
import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deduction extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
//    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JLabel label1 = new JLabel("Employe ID");
    JLabel label2 = new JLabel("Name");
    JLabel label3 = new JLabel("Bank Account");
    JLabel label4 = new JLabel("Hours");
    JLabel label5 = new JLabel("Days");
    JLabel label6 = new JLabel("Amount");

    JLabel searchLabel = new JLabel("Employe ID");

    JTextField field1 = new JTextField(22);
    JTextField field2 = new JTextField(22);
    JTextField field3 = new JTextField(22);
    JTextField field4 = new JTextField(22);
    JTextField field5 = new JTextField(22);
    JTextField field6 = new JTextField(22);

    //    JTextField searchField = new JTextField(22);
    JTextField displayField = new JTextField(36);

    JButton button1 = new JButton("Save");
//    JButton button2 = new JButton("Done");
    JButton button3 = new JButton("Back");

    public void showDeduction(EmployeData person, String searchData){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("0");
        field5.setText("0");
        field6.setText("0");

        displayField.setText("");



        int flag = 0;
        if (!searchData.equals("")) {
            for (EmployeData data : person.recordList) {
                if (data.getId().equals(searchData)) {
                    field1.setText(data.getId());
                    field2.setText(data.getName());
                    field3.setText(data.getBankAcc());
                    field4.setText(data.getDtHours()+"");
                    field5.setText(data.getDtDays()+"");
                    field6.setText(data.getDtAmt()+"");
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

    public Deduction(int x, int y) {
        setTitle("EMS->Deduction");
        setBounds(x, y, 450, 400);
//        setSize(450, 400);
//        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(410, 210));
        panel1.setLayout(new GridLayout(5, 2));
        panel1.setBorder(BorderFactory.createTitledBorder("Auto"));
        panel2.setLayout(new GridLayout(1, 2));
        panel2.setPreferredSize(new Dimension(410, 60));
        panel2.setBorder(BorderFactory.createTitledBorder("Manual"));
//        panel3.setPreferredSize(new Dimension(410, 70));
//        panel3.setBorder(BorderFactory.createTitledBorder("Actions"));

        field1.setEditable(false);
        field2.setEditable(false);
        field3.setEditable(false);
//        field4.setEditable(false);
//        field5.setEditable(false);
//        field6.setEditable(false);

        displayField.setEditable(false);

        EmployeData person = new EmployeData();

        person.employeeList();

//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int flag = 0;
//                for (EmployeData data : person.recordList) {
//                    if (data.getId().equals(field1.getText())) {
//                        try {
//                            int hours = Integer.parseInt(field4.getText());
//                            int days = Integer.parseInt(field5.getText());
//                            int amount = Integer.parseInt(field6.getText());
//
//                            data.setDtDays(days);
//                            data.setDtHours(hours);
//                            data.setDtAmt(amount);
//                            data.setDT(hours, days, amount);
//                        }
//                        catch (Exception f){
//                            System.out.println(f.getMessage());
//                            displayField.setText("Invalid Input");
//                            flag = 1;
//                        }
//                    }
//                }
//                if(flag == 0) {
//                    for (EmployeData dataU : person.recordList) {
//                        //dataU.newData();
//                        dataU.updateOTDT();
//                    }
//
//                    person.saveOTDTUpdate();
//                    displayField.setText("Data Updated");   }
//            }
//        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                for (EmployeData data : person.recordList) {
                    if (data.getId().equals(field1.getText())) {
                        try {
                            int hours = Integer.parseInt(field4.getText());
                            int days = Integer.parseInt(field5.getText());
                            int amount = Integer.parseInt(field6.getText());

                            data.setDtDays(days);
                            data.setDtHours(hours);
                            data.setDtAmt(amount);
                            data.setDT();
//                            data.setDT(hours, days, amount);
                        }
                        catch (Exception f){
                            System.out.println(f.getMessage());
                            displayField.setText("Invalid Input");
                            flag = 1;
                        }
                    }
                }
                if(flag == 0) {
                    for (EmployeData dataU : person.recordList) {
                        //dataU.newData();
                        dataU.updateOTDT();
                    }

                    person.saveOTDTUpdate();
                    displayField.setText("Data Updated");

                    dispose();
                    SalaryDisbursement disbursement = new SalaryDisbursement(getX(), getY());
                    disbursement.searchField.setText(field1.getText());
                    disbursement.showSalaryDisbursement(person);
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SalaryDisbursement disbursement = new SalaryDisbursement(getX(), getY());
                disbursement.searchField.setText(field1.getText());
                disbursement.showSalaryDisbursement(person);
            }
        });

//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                UpdateData update = new UpdateData();
//            }
//        });

        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(field2);
        panel1.add(label3);
        panel1.add(field3);
        panel1.add(label4);
        panel1.add(field4);
        panel1.add(label5);
        panel1.add(field5);

        panel2.add(label6);
        panel2.add(field6);

        panel5.add(button1);
//        panel5.add(button2);
        panel5.add(button3);

        panel4.add(displayField);

        add(panel1);
        add(panel2);
        add(panel4);
//        add(panel3);
        add(panel5);

        setVisible(true);

    }
}
