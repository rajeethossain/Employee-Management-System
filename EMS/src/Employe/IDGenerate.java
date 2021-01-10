package Employe;

import java.util.ArrayList;

public class IDGenerate {
    public String depID;
    public String areaID;
    public String idCode;
    public String idCount;
    public String id;
    int depIndex;
    int areaIndex;


    public void setDepID(int index){
        depIndex = index;
    }

    public void setAreaID(int index){
        areaIndex = index;
    }

    void getDepID(){
        if(depIndex == 1){
            depID = "IT";
        }
        if(depIndex == 2){
            depID = "OF";
        }
        if(depIndex == 3){
            depID = "LB";
        }
        if(depIndex == 4){
            depID = "MK";
        }
    }

    void getAreaID(){
        if(areaIndex == 1){
            areaID = "DHA";
        }
        if(areaIndex == 2){
            areaID = "CTG";
        }
        if(areaIndex == 3){
            areaID = "RAJ";
        }
        if(areaIndex == 4){
            areaID = "SYL";
        }
    }

    public void generateID(){
        EmployeData person = new EmployeData();
        getDepID();
        getAreaID();
        idCode = depID + areaID;

        ArrayList<EmployeData> idList = new ArrayList<EmployeData>();

        person.employeeList();
        for (EmployeData data : person.recordList) {
            String[] idPart = data.getId().split("-");
            if (idPart[0].equals(idCode)) {
                idList.add(data);
            }
        }


        int flag = 0;
        for (int i = 1; i <= idList.size(); i++) {
            int flag1 = 0;
            for (EmployeData data : idList) {
                String[] idPart = data.getId().split("-");
                int idNo = Integer.parseInt(idPart[1]);
                if (i == idNo) {
                    flag1 = 1;
                    break;
                }
            }
            if (flag1 == 0) {
                idCount = i + "";
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            idCount = idList.size() + 1 + "";
        }

        id = idCode + "-" + idCount+"";
    }
}
