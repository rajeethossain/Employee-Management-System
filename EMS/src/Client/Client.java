package Client;

import Employe.EmployeData;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    EmployeData employeData;
    OutputStreamWriter osw;
    PrintWriter writer;
    InputStreamReader isr;
    Scanner reader;

    public Client(){
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            osw = new OutputStreamWriter(socket.getOutputStream());
            writer = new PrintWriter(osw);

            writer.write("EMS\n");
            writer.flush();

            isr = new InputStreamReader(socket.getInputStream());
            reader = new Scanner(isr);

            employeData = new EmployeData();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateData(){

        try {
            FileWriter fileWriter = new FileWriter(employeData.otdt);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.equals("<eof>")) {
                    break;
                }
                System.out.println(line);
                fileWriter.append(line + "\n");
                fileWriter.flush();
            }
            System.out.println("Data Updated");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void sendData(){
        try {
            Scanner readFile = new Scanner(employeData.otdt);
            while (readFile.hasNextLine()){
                String line = readFile.nextLine();
                writer.write(line + "\n");
                writer.flush();
            }
            writer.write("<eof>\n");
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
