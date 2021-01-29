import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        OTDT otdt = new OTDT();

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running...");
            System.out.println("Waiting for connection...");

            File temp = new File("temp.txt");

            while (true) {
                Socket socket = server.accept();

                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                Scanner reader = new Scanner(isr);

                String clientName = reader.nextLine();
                System.out.println(clientName + " Connected...");

                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(osw);

                Scanner fileReader = new Scanner(otdt.otdt);
                FileWriter fileWriter = new FileWriter(temp);

                Thread receive = new Thread(){
                    @Override
                    public void run() {
                        try {
                            while (reader.hasNextLine()) {
                                String line = reader.nextLine();
                                if (line.equals("<eof>")) {
                                    otdt.updateFile(temp);
                                    break;
                                }
                                System.out.println(line);
                                fileWriter.append(line + "\n");
                                fileWriter.flush();
                            }
                            System.out.println("Disconnected...");
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                };
                receive.start();


                Thread send = new Thread(){
                    @Override
                    public void run() {
                        while (fileReader.hasNextLine()){
                            String line = fileReader.nextLine();
                            writer.write(line + "\n");
                            writer.flush();
                        }
                        writer.write("<eof>\n");
                        writer.flush();
                        System.out.println("Disconnected...");
                    }
                };
                send.start();


//                socket.close();
//                System.out.println("Disconnected...");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class OTDT{
    File otdt = new File("OTDT.txt");

    public void updateFile(File file) {
        try {
            Scanner scn = new Scanner(file);
            FileWriter updateData = new FileWriter(otdt);

            while (scn.hasNextLine()) {
                updateData.write(scn.nextLine() + "\n");
            }

            updateData.close();
            scn.close();

            file.delete();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
