package Login;

import Aplication.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame {
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel6 = new JPanel();
    JLabel label3 = new JLabel("Name");
    JLabel label4 = new JLabel("Mobile No");
    JLabel label5 = new JLabel("User ID");
    JLabel label6 = new JLabel("Password");
    JTextField field3 = new JTextField(22);
    JTextField field4 = new JTextField(22);
    JTextField field5 = new JTextField(22);
    JTextField field6 = new JTextField(22);
    JTextField field8 = new JTextField(35);
    JButton button3 = new JButton("Save");
    JButton button4 = new JButton("Done");

    public Registration(int x, int y) {
        setTitle("Registration");
        setBounds(x, y, 450, 250);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel3.setLayout(new GridLayout(4, 2));
        panel3.setPreferredSize(new Dimension(420,110));
        panel3.setBorder(BorderFactory.createTitledBorder("Details"));
        LoginData person = new LoginData();

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field5.getText().equals("") && !field6.getText().equals("")) {
                    person.name = field3.getText();
                    person.mobNumber = field4.getText();
                    person.userId = field5.getText();
                    person.password = field6.getText();
                    person.saveData();

                    field8.setText("Data Saved");

                    field3.setText("");
                    field4.setText("");
                    field5.setText("");
                    field6.setText("");
                } else {
                    field8.setText("Please Enter User ID & Password");
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Search application = new Search(getX(), getY());
            }
        });

        panel3.add(label3);
        panel3.add(field3);
        panel3.add(label4);
        panel3.add(field4);
        panel3.add(label5);
        panel3.add(field5);
        panel3.add(label6);
        panel3.add(field6);
        panel4.add(button3);
        panel4.add(button4);
        panel6.add(field8);
        field8.setEditable(false);
        add(panel3);
        add(panel4);
        add(panel6);
        setVisible(true);
    }
}
