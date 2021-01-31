package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Aplication.*;

 public class Login extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel label1 = new JLabel("User ID");
    JLabel label2 = new JLabel("Password");
    JTextField field1 = new JTextField(19);
    JTextField field2 = new JTextField(19);
    JTextField field7 = new JTextField(37);
//    JButton button1 = new JButton("Register");
    JButton button2 = new JButton("Login");

   public Login() {
        setTitle("OTDT->Login");
        setSize(450, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setLayout(new GridLayout(2,2));
        panel1.setPreferredSize(new Dimension(420, 80));
        panel1.setBorder(BorderFactory.createTitledBorder("Details"));
        ArrayList<LoginData> recordList = new ArrayList<LoginData>();
        LoginData person = new LoginData();

        try {
            Scanner read = new Scanner(person.loginData);
            try {
                while (read.hasNextLine()) {
                    String data = read.nextLine();
                    String[] dataSplit = data.split(";");
                    LoginData personData = new LoginData();
                    personData.name = dataSplit[0];
                    personData.mobNumber = dataSplit[1];
                    personData.userId = dataSplit[2];
                    personData.password = dataSplit[3];

                    recordList.add(personData);
                }
            } catch (Exception f) {
                f.getMessage();
            }
        } catch (FileNotFoundException f) {
            f.getMessage();
        }

//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                Registration registration = new Registration();
//            }
//        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                if (field1.getText().equals("")) {
                    field7.setText("Please Enter Email");
                } else if (field2.getText().equals("")) {
                    field7.setText("Please Enter Password");
                } else {
                    for (LoginData get : recordList) {
                        if (field1.getText().equals(get.userId) && field2.getText().equals(get.password)) {
                            field7.setText("Login Successful");
                            flag = 1;
                            Search application = new Search(getX(),getY());
                            dispose();
                        }
                    }
                    if (flag == 0) {
                        field7.setText("Login Unsuccessful");
                    }
                }
            }
        });

        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(field2);
        panel2.add(button2);
 //       panel2.add(button1);
        panel5.add(field7);
        field7.setEditable(false);
        add(panel1);
        add(panel2);
        add(panel5);
        setVisible(true);
    }
}
