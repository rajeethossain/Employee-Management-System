import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running...");
            System.out.println("Waiting for connection...");

            File otdt = new File("OTDT.txt");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected...");

                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                Scanner reader = new Scanner(isr);

                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(osw);

                Scanner fileReader = new Scanner(otdt);
                FileWriter fileWriter = new FileWriter(otdt);


//
                try {
                    while (reader.hasNextLine()) {
                        String line = reader.nextLine();
                        if (line.equals("<eof>")) {
                            break;
                        }
                        System.out.println(line);
                        fileWriter.append(line + "\n");
                        fileWriter.flush();
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

//
//                while (fileReader.hasNextLine()){
//                    String line = fileReader.nextLine();
//                    writer.write(line + "\n");
//                    writer.flush();
//                }
//                writer.write("<eof>\n");
//                writer.flush();

//                Thread receive = new Thread(){
//                    @Override
//                    public void run() {
//                        try {
//                            while (reader.hasNextLine()) {
//                                String line = reader.nextLine();
//                                if (line.equals("<eof>")) {
//                                    break;
//                                }
//                                System.out.println(line);
//                                fileWriter.append(line + "\n");
//                                fileWriter.flush();
//                            }
//                        }
//                        catch (Exception e){
//                            System.out.println(e.getMessage());
//                        }
//                    }
//                };
//                receive.start();
//
//                Thread send = new Thread(){
//                    @Override
//                    public void run() {
//                        while (filereader.hasNextLine()){
//                            String line = filereader.nextLine();
//                            writer.write(line + "\n");
//                            writer.flush();
//                        }
//                        writer.write("<eof>\n");
//                        writer.flush();
//                    }
//                };
//
//
//                send.start();


                socket.close();
                System.out.println("Disconnected...");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
