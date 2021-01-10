package Employe;

import Aplication.NewEntry;
import Aplication.UpdateData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PositionList {
    IDGenerate idG = new IDGenerate();



    //Department
    public  JComboBox comboBox1 = new JComboBox();
    public void departmentList(){
        comboBox1.addItem("Please Select");
        comboBox1.addItem("IT");
        comboBox1.addItem("Office");
        comboBox1.addItem("Lab");
        comboBox1.addItem("Marketing");

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                designationList();
                areaList();
                if(comboBox3.getSelectedIndex() == 0 || comboBox1.getSelectedIndex() == 0) {
                    NewEntry.field1.setText("");
                }
                else{
                    idG.setDepID(comboBox1.getSelectedIndex());
                    idG.setAreaID(comboBox3.getSelectedIndex());
                    idG.generateID();
                    NewEntry.field1.setText(idG.id);
                }

            }
        });
    }



    //Designation
    public JComboBox comboBox2 = new JComboBox();
    public void designationList(){
        comboBox2.removeAllItems();
        if(comboBox1.getSelectedIndex() == 1) {
            comboBox2.addItem("Please Select");
            comboBox2.addItem("Manager");
            comboBox2.addItem("Data Entry Incharge");
            comboBox2.addItem("Data Entry Staff");
        }
        else if(comboBox1.getSelectedIndex() == 2) {
            comboBox2.addItem("Please Select");
            comboBox2.addItem("Manager");
            comboBox2.addItem("Accounts Officer");
            comboBox2.addItem("Admin");
            comboBox2.addItem("Office Staff");
        }
        else if(comboBox1.getSelectedIndex() == 3) {
            comboBox2.addItem("Please Select");
            comboBox2.addItem("Lab Incharge");
            comboBox2.addItem("Lab Technician");
            comboBox2.addItem("Lab Staff");
        }
        else if(comboBox1.getSelectedIndex() == 4) {
            comboBox2.addItem("Please Select");
            comboBox2.addItem("Marketing Manager");
            comboBox2.addItem("Marketing Staff");
        }
        else{
            comboBox2.addItem("Select Department");
        }
    }


    //Area
    public  JComboBox comboBox3 = new JComboBox();
    public void areaList(){
        comboBox3.removeAllItems();
        if(comboBox1.getSelectedIndex() != 0) {
            comboBox3.addItem("Please Select");
            comboBox3.addItem("Dhaka");
            comboBox3.addItem("Chittagong");
            comboBox3.addItem("Rajshahi");
            comboBox3.addItem("Shylhet");
        }
        else{
            comboBox3.addItem("Select Department");
        }

        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comboBox3.getSelectedIndex() == 0 || comboBox1.getSelectedIndex() == 0) {
                    NewEntry.field1.setText("");
                }
                else{
                    idG.setDepID(comboBox1.getSelectedIndex());
                    idG.setAreaID(comboBox3.getSelectedIndex());
                    idG.generateID();
                    NewEntry.field1.setText(idG.id);
                }

            }
        });
    }
}
