package Employe;

import Client.Client;

import java.io.IOException;
import java.util.Scanner;

public class OTDT {

    public OTDT() {
         Client client = new Client();
//         client.updateData();

        EmployeData staff = new EmployeData();
        staff.employeeList();


        try {
            Scanner readOTDT = new Scanner(staff.otdt);
            while (readOTDT.hasNextLine()) {
                String data = readOTDT.nextLine();
                String[] dataSplit = data.split(";");

                for (EmployeData person : staff.recordList) {
                    if (dataSplit[0].equals(person.getId())) {
                        person.setOtHours(Integer.parseInt(dataSplit[10]));
                        person.setOtDays(Integer.parseInt(dataSplit[11]));
                        person.setCommission(Integer.parseInt(dataSplit[12]));
                        person.setDtHours(Integer.parseInt(dataSplit[13]));
                        person.setDtDays(Integer.parseInt(dataSplit[14]));
                        person.setDtAmt(Integer.parseInt(dataSplit[15]));

                        person.setBonus(Integer.parseInt(dataSplit[9]));
//                        person.setOT(Integer.parseInt(dataSplit[10]), Integer.parseInt(dataSplit[11]));
//                        person.setCommission(Integer.parseInt(dataSplit[12]));
//                        person.setDT(Integer.parseInt(dataSplit[13]), Integer.parseInt(dataSplit[14]), Integer.parseInt(dataSplit[15]));
                    }
                }
            }

            for (EmployeData person : staff.recordList) {
                person.updateData();

            }

            staff.saveDataUpdate();

            readOTDT.close();

        } catch (Exception e) {

        }
    }
}
