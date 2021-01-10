package Aplication;

import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateData extends JFrame {
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
    JLabel label10 = new JLabel("Base Salary");
    JLabel label11 = new JLabel("Mobile Allowance");
    JLabel label12 = new JLabel("Medical Allowance");
    JLabel label13 = new JLabel("Experience Allowance");
    JLabel label14 = new JLabel("Education Allowance");
    JLabel label15 = new JLabel("Rent Allowance");
    JLabel label16 = new JLabel("Other Allowance");

    JLabel searchLabel = new JLabel("Employe ID");

   public static JTextField field1 = new JTextField(22);
    JTextField field2 = new JTextField(22);
    JTextField field3 = new JTextField(22);
//    JTextField field4 = new JTextField(22);
//    JTextField field5 = new JTextField(22);
//    JTextField field6 = new JTextField(22);
    JTextField field7 = new JTextField(22);
    JTextField field8 = new JTextField(22);
    JTextField field9 = new JTextField(22);
    JTextField field10 = new JTextField(22);
    JTextField field11 = new JTextField(22);
    JTextField field12 = new JTextField(22);
    JTextField field13 = new JTextField(22);
    JTextField field14 = new JTextField(22);
    JTextField field15 = new JTextField(22);
    JTextField field16 = new JTextField(22);

    JTextField searchField = new JTextField(22);
    public JTextField displayField = new JTextField(36);

    JButton button1 = new JButton("Update");
    JButton button2 = new JButton("Done");
    JButton button3 = new JButton("Show");
    JButton button4 = new JButton("New Entry");
    JButton button5 = new JButton("Remove");

    PositionList positionU = new PositionList();

    public int frameid;

    public void showDataU(EmployeData personU, PositionList positionU){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        positionU.comboBox1.setSelectedIndex(0);
        positionU.comboBox2.setSelectedIndex(0);
        positionU.comboBox3.setSelectedIndex(0);
        field7.setText("");
        field8.setText("");
        field9.setText("");
        field10.setText("");
        field11.setText("");
        field12.setText("");
        field13.setText("");
        field14.setText("");
        field15.setText("");
        field16.setText("");


        String searchData = searchField.getText().toUpperCase();

        int flag = 0;
        if (!searchField.getText().equals("")) {
            for (EmployeData data : personU.recordList) {
                if (data.getId().equals(searchData)) {
                    field1.setText(data.getId());
                    field2.setText(data.getName());
                    field3.setText(data.getBankAcc());
                    positionU.comboBox1.setSelectedItem(data.getDepartment());
                    positionU.comboBox2.setSelectedItem(data.getDesignation());
                    positionU.comboBox3.setSelectedItem(data.getArea());
                    field7.setText(data.getMobNumber());
                    field8.setText(data.getEmail());
                    field9.setText(data.getAddress());
                    field10.setText(data.getSalaryB()+"");
                    field11.setText(data.getMobAll()+"");
                    field12.setText(data.getMedAll()+"");
                    field13.setText(data.getExpAll()+"");
                    field14.setText(data.getEduAll()+"");
                    field15.setText(data.getRentAll()+"");
                    field16.setText(data.getOtherAll()+"");
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

    public UpdateData() {
        setTitle("Employee Update");
        setSize(450, 680);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panel1.setLayout(new GridLayout(16, 2));
        panel1.setPreferredSize(new Dimension(410, 400));
        panel1.setBorder(BorderFactory.createTitledBorder("Details"));
        panel2.setPreferredSize(new Dimension(410, 70));
        panel2.setBorder(BorderFactory.createTitledBorder("Actions"));
        panel4.setPreferredSize(new Dimension(410, 70));
        panel4.setBorder(BorderFactory.createTitledBorder("Search"));
        field1.setEditable(false);
        displayField.setEditable(false);
        positionU.comboBox1.setEnabled(false);
        positionU.comboBox3.setEnabled(false);

        EmployeData personU = new EmployeData();
        personU.employeeList();



        positionU.departmentList();
        positionU.designationList();
        positionU.areaList();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                if (!field1.getText().equals("")) {
                    for(EmployeData dataU : personU.recordList){
                        if(dataU.getId().equals(field1.getText().toUpperCase())){
                            dataU.setId(field1.getText());
                            dataU.setName(field2.getText());
                            dataU.setBankAcc(field3.getText());
                            dataU.setDepartment(positionU.comboBox1.getSelectedItem()+"");
                            dataU.setDesignation(positionU.comboBox2.getSelectedItem()+"");
                            dataU.setArea(positionU.comboBox3.getSelectedItem()+"");
                            dataU.setMobNumber(field7.getText());
                            dataU.setEmail(field8.getText());
                            dataU.setAddress(field9.getText());
                            try {
                                dataU.setSalaryB(Integer.parseInt(field10.getText()));
                                dataU.setMobAll(Integer.parseInt(field11.getText()));
                                dataU.setMedAll(Integer.parseInt(field12.getText()));
                                dataU.setExpAll(Integer.parseInt(field13.getText()));
                                dataU.setEduAll(Integer.parseInt(field14.getText()));
                                dataU.setRentAll(Integer.parseInt(field15.getText()));
                                dataU.setOtherAll(Integer.parseInt(field16.getText()));
                            }
                            catch (Exception f){
                                displayField.setText("Invalid Input");
                                flag = 1;
                            }
                        }
                    }

                    if(flag == 0) {
                        for (EmployeData dataU : personU.recordList) {
                            dataU.newData();
                        }

                        personU.updateData();
                        displayField.setText("Data Updated");
                    }
                }
                else {
                    displayField.setText("Please select an employee to Update");
                }
            }
        });

//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.setText("");
//                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//                //scroll.getViewport().setBackground(Color.white);
//                scroll.getViewport().add(textArea);
//                revalidate();
//
//                for (Record get : recordList) {
//                    textArea.append("Name\t: " + get.name + "\n");
//                    textArea.append("Mobile No\t: " + get.mobNumber + "\n");
//                    textArea.append("Email\t: " + get.email + "\n");
//                    textArea.append("Address\t: " + get.address + "\n");
//                    textArea.append("\n\n");
//
//                }
//            }
//        });
//
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.setText("");
//                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//                scroll.getViewport().setBackground(Color.white);
//                scroll.getViewport().add(textArea);
//                revalidate();
//                String searchData = field5.getText();
//
//                int flag = 0;
//                if (!field5.getText().equals("")) {
//                    for (Record data : recordList) {
//                        if (data.name.equals(searchData)) {
//                            textArea.append("Name\t: " + data.name + "\n");
//                            textArea.append("Mobile No\t: " + data.mobNumber + "\n");
//                            textArea.append("Email\t: " + data.email + "\n");
//                            textArea.append("Address\t: " + data.address + "\n");
//                            textArea.append("\n\n");
//                            flag = 1;
//                        }
//                    }
//                    if (flag == 0) {
//                        textArea.append("No Records Found");
//                    }
//                } else {
//                    textArea.append("Please Enter a Name");
//                }
//            }
//        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                if(frameid == 0) {
                    Search application = new Search();
                    application.searchField.setText(field1.getText());
                    application.showDetails(personU);
                }
                else{
                    SalaryBreakdown breakdown = new SalaryBreakdown();
                    breakdown.searchField.setText(field1.getText());
                    breakdown.showSalaryBreakdown(personU);
                    breakdown.displayField.setText("");
                    breakdown.frameid = 0;
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDataU(personU, positionU);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NewEntry entry = new NewEntry();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field1.getText().equals("")) {
                    try {
                        for (EmployeData dataU : personU.recordList) {
                            if (dataU.getId().equals(field1.getText())) {
                                personU.recordList.remove(dataU);
                            }
                        }
                    }
                    catch (Exception f){
                        f.getMessage();
                    }


                    for (EmployeData dataU : personU.recordList) {
                        dataU.newData();
                    }

                    personU.updateData();
                    displayField.setText("Data Removed");
                }
                else {
                    displayField.setText("Please select an employee to Remove");
                }
            }
        });


        panel4.add(searchLabel);
        panel4.add(searchField);
        panel4.add(button3);

        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(field2);
        panel1.add(label3);
        panel1.add(field3);
        panel1.add(label4);
        panel1.add(positionU.comboBox1);
        panel1.add(label5);
        panel1.add(positionU.comboBox2);
        panel1.add(label6);
        panel1.add(positionU.comboBox3);
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
        panel2.add(button4);
        panel2.add(button5);

        panel3.add(displayField);

        panel5.add(button2);

        add(panel4);
        add(panel1);
        add(panel3);
        add(panel2);
        add(panel5);

        setVisible(true);

    }
}

