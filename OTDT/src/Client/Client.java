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
//    public void run(){
//        try {
//            Socket socket = new Socket("127.0.0.1", 5000);
//            osw = new OutputStreamWriter(socket.getOutputStream());
////            writer = new PrintWriter(osw);
//
////            try {
////
////                Scanner readFile = new Scanner(employeData.otdt);
////                while (readFile.hasNextLine()){
////                    String line = readFile.nextLine();
////                    writer.write(line + "\n");
////                    writer.flush();
////                }
////                writer.write("<eof>\n");
////                writer.flush();
////            }
////            catch (IOException e){
////                System.out.println(e.getMessage());
////            }
//
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//
//    }

    public void connect(){
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
//
            osw = new OutputStreamWriter(socket.getOutputStream());
            writer = new PrintWriter(osw);

            isr = new InputStreamReader(socket.getInputStream());
            reader = new Scanner(isr);

            employeData = new EmployeData();
//
//            FileWriter fileWriter = new FileWriter(employeData.otdt);
//            Thread getData = new Thread(){
//                @Override
//                public void run() {
//                    try {
//                        while (reader.hasNextLine()) {
//                            String line = reader.nextLine();
//                            if (line.equals("<eof>")) {
//                                break;
//                            }
//                            System.out.println(line);
//                            fileWriter.append(line + "\n");
//                            fileWriter.flush();
//                        }
//                        System.out.println("Data Updated");
//                    }
//                    catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                }
//            };
//
////            getData.start();
//
        }
        catch (IOException e){
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
//
//class DataBase{
//    EmployeData employeData;
//    OutputStreamWriter osw;
//    PrintWriter writer;
//    InputStreamReader isr;
//    Scanner reader;
//
//    DataBase(Socket socket){
//        try {
//
//            osw = new OutputStreamWriter(socket.getOutputStream());
//            writer = new PrintWriter(osw);
//
//            isr = new InputStreamReader(socket.getInputStream());
//            reader = new Scanner(isr);
//
//            employeData = new EmployeData();
//
////            FileWriter fileWriter = new FileWriter(employeData.otdt);
////            Thread getData = new Thread(){
////                @Override
////                public void run() {
////                    try {
////                        while (reader.hasNextLine()) {
////                            String line = reader.nextLine();
////                            if (line.equals("<eof>")) {
////                                break;
////                            }
////                            System.out.println(line);
////                            fileWriter.append(line + "\n");
////                            fileWriter.flush();
////                        }
////                        System.out.println("Data Updated");
////                    }
////                    catch (Exception e){
////                        System.out.println(e.getMessage());
////                    }
////                }
////            };
//
////            getData.start();
//
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    public void sendData(){
//        try {
//            Scanner readFile = new Scanner(employeData.otdt);
//            while (readFile.hasNextLine()){
//                String line = readFile.nextLine();
//                writer.write(line + "\n");
//                writer.flush();
//            }
//            writer.write("<eof>\n");
//            writer.flush();
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
