package Client;

import Employe.EmployeData;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(){
        EmployeData employeData = new EmployeData();

        try {
            Socket socket = new Socket("127.0.0.1", 5000);

//            File A = new File("A.txt");
//            File B = new File("B.txt");
//            File C = new File("C.txt");


            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(osw);

            Scanner readFile = new Scanner(employeData.otdt);
            while (readFile.hasNextLine()){
                String line = readFile.nextLine();
                writer.write(line + "\n");
                writer.flush();
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
