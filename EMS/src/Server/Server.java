//package Server;
//
//import Employe.EmployeData;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Server extends Thread{
//    public void run() {
//        EmployeData employeData = new EmployeData();
//        try {
//            ServerSocket server = new ServerSocket(5000);
//            System.out.println("Server is running...");
//            System.out.println("Waiting for connection...");
//
//            while (true) {
//                Socket socket = server.accept();
//                System.out.println("Connected...");
//
////                File A = new File("A.txt");
//
//                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//                Scanner reader = new Scanner(isr);
////            fileName = reader.nextLine();
////            fileName = fileName + ".txt";
//
////            System.out.println(fileName);
//
//                FileWriter writer = new FileWriter(employeData.otdt);
////                FileWriter writer = new FileWriter(A);
//
//                while (reader.hasNextLine()) {
//                    String line = reader.nextLine();
//                    if(line.equals("<eof>")) {
//                        break;
//                    }
//                    System.out.println(line);
//                    writer.append(line + "\n");
//                    writer.flush();
//                }
//                socket.close();
//                System.out.println("Disconnected...");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
