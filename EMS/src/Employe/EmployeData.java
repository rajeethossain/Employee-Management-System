package Employe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeData {
    private String id;
    private String name;
    private String bankAcc;
    private String department;
    private String designation;
    private String area;
    private String mobNumber;
    private String email;
    private String address;

    private int salaryB;
    private int salaryT;
    private int mobAll;
    private int medAll;
    private int expAll;
    private int rentAll;
    private int eduAll;
    private int otherAll;
    private int Bonus;
    private int ot;
    private int otDays;
    private int otHours;
    private int dt;
    private int dtDays;
    private int dtHours;
    private int dtAmt;
    private int commission;
    private int salaryDays;
    private int salaryHours;
    private int salaryDisbursement;
    private int totalAll;


    //Set Data
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setSalaryB(int salaryB) {
        this.salaryB = salaryB;
    }

    public void setMobAll(int mobAll) {
        this.mobAll = mobAll;
    }

    public void setMedAll(int medAll) {
        this.medAll = medAll;
    }

    public void setRentAll(int rentAll) {
        this.rentAll = rentAll;
    }

    public void setEduAll(int eduAll) {
        this.eduAll = eduAll;
    }

    public void setExpAll(int expAll) {
        this.expAll = expAll;
    }

    public void setOtherAll(int otherAll) {
        this.otherAll = otherAll;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public void setOT(int hours, int days) {
        ot = (getSalaryHours()*hours) + (getSalaryDays()*days);
    }

    public void setOT(int ot) {
        this.ot = ot;
    }

    public void setDT(int hours, int days, int amount) {
        dt = (getSalaryHours()*hours) + (getSalaryDays()*days) + amount;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public void setSalaryT(int salaryT) {
        this.salaryT = salaryT;
    }
//
//    public void setSalaryDays() {
//        this.salaryDays = salaryB/30;
//    }
//
//    public void setSalaryHours() {
//        this.salaryHours = salaryDays/24;
//    }
//
    public void setSalaryDisbursement(int salaryDisbursement) {
        this.salaryDisbursement = salaryDisbursement;
    }

    public void setTotalAll(int totalAll) {
        this.totalAll = totalAll;
    }

    public void setOtDays(int otDays) {
        this.otDays = otDays;
    }

    public void setOtHours(int otHours) {
        this.otHours = otHours;
    }

    public void setDtDays(int dtDays) {
        this.dtDays = dtDays;
    }

    public void setDtHours(int dtHours) {
        this.dtHours = dtHours;
    }

    public void setDtAmt(int dtAmt) {
        this.dtAmt = dtAmt;
    }

    //Get Data
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getArea() {
        return area;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getSalaryB() {
        return salaryB;
    }

    public int getSalaryT() {
        salaryT = salaryB + mobAll + medAll + eduAll + rentAll + expAll + otherAll;
        return salaryT;
    }

    public int getMobAll() {
        return mobAll;
    }

    public int getMedAll() {
        return medAll;
    }

    public int getRentAll() {
        return rentAll;
    }

    public int getOtherAll() {
        return otherAll;
    }

    public int getBonus() {
        return Bonus;
    }

    public int getOT() {
        return ot;
    }

    public int getDT() {
        return dt;
    }

    public int getCommission() {
        return commission;
    }

    public int getEduAll() {
        return eduAll;
    }

    public int getExpAll() {
        return expAll;
    }

    public int getSalaryDays() {
        salaryDays = salaryB/30;
        return salaryDays;
    }

    public int getSalaryHours() {
        salaryHours = getSalaryDays()/24;
        return salaryHours;
    }

    public int getSalaryDisbursement() {
        salaryDisbursement = (salaryT + ot + Bonus + commission) - dt;
        return salaryDisbursement;
    }

    public int getTotalAll() {
        totalAll = mobAll + medAll + eduAll + expAll + rentAll + otherAll;
        return totalAll;
    }


    private File data = new File("Data.txt");
    private File temp = new File("Temp.txt");
    private File dSdata = new File("Disbursement.csv");
    public File otdt = new File("OTDT.txt");
//    private File sData = new File("StaffData.txt");

    public File getData() {
        return data;
    }


    //Write to File
    void writeFile(File file){
        try {
            FileWriter write = new FileWriter(file, true);

            write.append(id + ";" + name + ";" + bankAcc + ";" + department + ";" + designation + ";" + area + ";" + mobNumber + ";" + email + ";" + address + ";" + salaryB + ";" + mobAll + ";" + medAll + ";" + expAll + ";" + eduAll + ";" + rentAll + ";" + otherAll +  ";" + getTotalAll() + ";" + getSalaryT() + ";" + Bonus + ";" + ot + ";" + commission + ";" + dt + ";" + getSalaryDisbursement() + "\n");

            write.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Write StaffData
//    void writeStaffData(File file){
//        try {
//            FileWriter write = new FileWriter(file, true);
//
//            write.append(id + ";" + name + ";" + bankAcc + ";" + department + ";" + designation + ";" + area + ";" + mobNumber + ";" + email + ";" + address + "\n");
//
//            write.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }


    //Save OTDT data to File
//    public void writeOTDT(File file){
//        try {
//            FileWriter write = new FileWriter(file, true);
//
//            write.append(id + ";"  + Bonus + ";" + otHours + ";" + otDays + ";" + commission + ";" + dtHours + ";" + dtDays + ";" + dtAmt + "\n");
//
//            write.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void writeOTDT(File file){
        try {
            FileWriter write = new FileWriter(file, true);

            write.append(id + ";" + name + ";" + bankAcc + ";" + department + ";" + designation + ";" + area + ";" + mobNumber + ";" + email + ";" + address + ";"  + Bonus + ";" + otHours + ";" + otDays + ";" + commission + ";" + dtHours + ";" + dtDays + ";" + dtAmt + "\n");

            write.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //Update File
    public void updateFile(File file) {
        try {
            Scanner scn = new Scanner(temp);
            FileWriter updateData = new FileWriter(file);

            while (scn.hasNextLine()) {
                updateData.write(scn.nextLine() + "\n");
            }

            updateData.close();
            scn.close();

            temp.delete();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //New Entry
    public void saveData() {
        writeFile(data);
//        try {
//            FileWriter write = new FileWriter(data, true);
//
//            write.append(id + ";" + name + ";" + bankAcc + ";" + department + ";" + designation + ";" + area + ";" + mobNumber + ";" + email + ";" + address + ";" + salaryB + ";" + mobAll + ";" + medAll + ";" + expAll + ";" + eduAll + ";" + rentAll + ";" + otherAll +  ";" + getTotalAll() + ";" + getSalaryT() + ";" + Bonus + ";" + ot + ";" + commission + ";" + dt + ";" + getSalaryDisbursement() + "\n");
//
//            write.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void saveOTDT(){
        writeOTDT(otdt);
    }

//    public void saveStaffData(){
//        writeStaffData(sData);
//    }


    //Update Data
    public void updateData() {
        writeFile(temp);
//        try {
//            FileWriter newData = new FileWriter(temp, true);
//
//            newData.append(id + ";" + name + ";" + bankAcc + ";" + department + ";" + designation + ";" + area + ";" + mobNumber + ";" + email + ";" + address + ";" + salaryB + ";" + mobAll + ";" + medAll + ";" + expAll + ";" + eduAll + ";" + rentAll + ";" + otherAll +  ";" + getTotalAll() + ";" + getSalaryT() + ";" + Bonus +  ";" + ot + ";" + commission + ";" + dt + ";" + getSalaryDisbursement() + "\n");
//
//            newData.close();
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void saveDataUpdate(){
        updateFile(data);
    }

    public void updateOTDT(){
        writeOTDT(temp);
    }

    public void saveOTDTUpdate(){
        updateFile(otdt);
    }

//    public void updateStaffData(){
//        writeStaffData(temp);
//    }

//    public void saveStaffDataUpdate(){
//        updateFile(sData);
//    }



    //Disbursement Data
    public void exportTableData(JTable table){
        try {
            FileWriter export = new FileWriter(dSdata, true);
            for(int i=0; i<table.getColumnCount(); i++) {
                export.append(table.getModel().getColumnName(i)+",");
            }
            export.append("\n");
            for(int i=0; i<table.getRowCount(); i++){
                for(int j=0; j<table.getColumnCount(); j++){
                    export.append(table.getModel().getValueAt(i, j).toString()+",");
                }
                export.append("\n");
            }
            String dateTime = System.currentTimeMillis()+"";
            export.close();
            dSdata.renameTo(new File("C:\\Users\\rajee\\Desktop\\Exported"+dateTime+".xml"));
            dSdata.delete();
            JOptionPane.showMessageDialog(null,"Data Exported");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    //Employee List
    public ArrayList<EmployeData> recordList;
    public void employeeList() {
        recordList = new ArrayList<EmployeData>();
        try {
            Scanner read = new Scanner(data);
            try {
                while (read.hasNextLine()) {
                    String data = read.nextLine();
                    String[] dataSplit = data.split(";");
                    EmployeData personData = new EmployeData();
                    personData.setId(dataSplit[0]);
                    personData.setName(dataSplit[1]);
                    personData.setBankAcc(dataSplit[2]);
                    personData.setDepartment(dataSplit[3]);
                    personData.setDesignation(dataSplit[4]);
                    personData.setArea(dataSplit[5]);
                    personData.setMobNumber(dataSplit[6]);
                    personData.setEmail(dataSplit[7]);
                    personData.setAddress(dataSplit[8]);
                    personData.setSalaryB(Integer.parseInt(dataSplit[9]));
                    personData.setMobAll(Integer.parseInt(dataSplit[10]));
                    personData.setMedAll(Integer.parseInt(dataSplit[11]));
                    personData.setExpAll(Integer.parseInt(dataSplit[12]));
                    personData.setEduAll(Integer.parseInt(dataSplit[13]));
                    personData.setRentAll(Integer.parseInt(dataSplit[14]));
                    personData.setOtherAll(Integer.parseInt(dataSplit[15]));
                    personData.setTotalAll(Integer.parseInt(dataSplit[16]));
                    personData.setSalaryT(Integer.parseInt(dataSplit[17]));
                    personData.setBonus(Integer.parseInt(dataSplit[18]));
                    personData.setOT(Integer.parseInt(dataSplit[19]));
                    personData.setCommission(Integer.parseInt(dataSplit[20]));
                    personData.setDT(Integer.parseInt(dataSplit[21]));
                    personData.setSalaryDisbursement(Integer.parseInt(dataSplit[22]));

                    recordList.add(personData);

                }
                read.close();

            } catch (Exception f) {
                System.out.println(f.getMessage());
            }

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }
    }

//    public EmployeData(){
//        OTDT otdt = new OTDT();
//    }
}



