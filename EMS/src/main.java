import Aplication.*;
import Employe.EmployeData;
import Employe.OTDT;
import Login.*;
import Server.Server;

public class main {
    public static void main(String[] args) {
//        Thread thread = new Thread();
        Server server = new Server();
        server.start();
//      Login start = new Login();
        Search s = new Search();
//        OTDT otdt = new OTDT();
//        NewEntry n = new NewEntry();
//        EmployeData n = new EmployeData();
//        n.employeeList();
//        n.generateID();
    }
}
