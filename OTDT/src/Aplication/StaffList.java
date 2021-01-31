package Aplication;

import Client.Client;
import Employe.EmployeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class StaffList extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JLabel searchLabel = new JLabel("Employee Name");

    JTextField searchField = new JTextField(12);

    JButton button1 = new JButton("Show");
    JButton button2 = new JButton("Show All");
    JButton button3 = new JButton("Back");

    JTextArea textArea = new JTextArea(25,35);
    JScrollPane scroll = new JScrollPane(textArea);

    public void showAll(EmployeData person){
        Client client = new Client();
        client.updateData();
        person.employeeList();
        textArea.setText("");
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scroll.getViewport().setBackground(Color.white);
        scroll.getViewport().add(textArea);
        revalidate();

        for (EmployeData data : person.recordList) {
            textArea.append("Employee ID\t: " + data.getId() + "\n");
            textArea.append("Name\t: " + data.getName() + "\n");
            textArea.append("\n\n");
        }
    }

    StaffList(int x, int y){
        setTitle("OTDT->Employee List");
        setBounds(x, y, 450, 610);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(410, 70));
        panel1.setBorder(BorderFactory.createTitledBorder("Search"));
        panel2.setPreferredSize(new Dimension(410, 440));
        panel2.setBorder(BorderFactory.createTitledBorder("Details"));
        textArea.setEditable(false);

        EmployeData personD = new EmployeData();
        personD.employeeList();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //scroll.getViewport().setBackground(Color.white);
                scroll.getViewport().add(textArea);
                revalidate();
                String searchData = searchField.getText();

                int flag = 0;
                if(!searchField.getText().equals("")) {
                    for (EmployeData data : personD.recordList) {
                        if (data.getName().equals(searchData)) {
                            textArea.append("Employee ID\t: " + data.getId() + "\n");
                            textArea.append("Name\t: " + data.getName() + "\n");
                            textArea.append("\n\n");
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        textArea.append("No Records Found");
                    }
                }
                else {
                    textArea.append("Please Enter a Name");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll(personD);
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Search search = new Search(getX(), getY());
            }
        });


        panel1.add(searchLabel);
        panel1.add(searchField);
        panel1.add(button1);
        panel1.add(button2);

        panel2.add(scroll);

        panel3.add(button3);

        add(panel1);
        add(panel2);
        add(panel3);
        setVisible(true);
    }
}
