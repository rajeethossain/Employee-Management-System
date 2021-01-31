package Employe;

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
    private int Bonus;
    private int otDays;
    private int otHours;
    private int dtDays;
    private int dtHours;
    private int dtAmt;
    private int commission;


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

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public void setCommission(int commission) {
        this.commission = commission;
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

    public int getBonus() {
        return Bonus;
    }

    public int getCommission() {
        return commission;
    }

    public int getOtDays() {
        return otDays;
    }

    public int getOtHours() {
        return otHours;
    }

    public int getDtDays() {
        return dtDays;
    }

    public int getDtHours() {
        return dtHours;
    }

    public int getDtAmt() {
        return dtAmt;
    }


    private File temp = new File("Temp.txt");
    public File otdt = new File("OTDT.txt");


    //Write to File
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


    public void saveOTDT(){
        writeOTDT(otdt);
    }



    //Update Data
    public void updateOTDT(){
        writeOTDT(temp);
    }

    public void saveOTDTUpdate(){
        updateFile(otdt);
    }


    //Employee List
    public ArrayList<EmployeData> recordList;
    public void employeeList() {
        recordList = new ArrayList<EmployeData>();
        try {
            Scanner read = new Scanner(otdt);
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
                    personData.setBonus(Integer.parseInt(dataSplit[9]));
                    personData.setOtHours(Integer.parseInt(dataSplit[10]));
                    personData.setOtDays(Integer.parseInt(dataSplit[11]));
                    personData.setCommission(Integer.parseInt(dataSplit[12]));
                    personData.setDtHours(Integer.parseInt(dataSplit[13]));
                    personData.setDtDays(Integer.parseInt(dataSplit[14]));
                    personData.setDtAmt(Integer.parseInt(dataSplit[15]));

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
}



