package Aplication;
import Employe.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisbursementOutput extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
//    JPanel panel3 = new JPanel();

    JLabel label1 = new JLabel("Total Disbursement");

    JTextField field1 = new JTextField(22);

    JButton button1 = new JButton("Done");
    JButton button2 = new JButton("Export");
//    JButton button4 = new JButton("Addition");
//    JButton button5 = new JButton("Deduction");
//    JButton button6 = new JButton("Bonus");
//    JButton button7 = new JButton("Salary Breakdown");

    int totalDisbursement=0;

    public DisbursementOutput() {
        setTitle("Salary Disbursement");
        setSize(1210, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(1190, 700));
        panel1.setBorder(BorderFactory.createTitledBorder("Details"));
        field1.setEditable(false);

        EmployeData person = new EmployeData();
        person.employeeList();

        int arrSize = person.recordList.size();

        String[] columnName = new String[]{"Employe ID", "Name", "Bank Account", "Total Salary", "Bonus", "Overtime", "Others", "Deduction", "Disbursement"};
        Object[][] tblData = new Object[arrSize][];

        int i = 0;
        for (EmployeData data : person.recordList) {
            tblData[i] = new Object[]{data.getId(), data.getName(), data.getBankAcc(), data.getSalaryT(), data.getBonus(), data.getOT(), data.getCommission(), data.getDT(), data.getSalaryDisbursement()};
            i++;
            totalDisbursement = totalDisbursement + data.getSalaryDisbursement();
        }
        field1.setText(totalDisbursement+"");

        JTable table = new JTable(tblData, columnName);
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1180,665));
        table.setEnabled(false);
        table.setAutoCreateRowSorter(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SalaryDisbursement disbursement = new SalaryDisbursement();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                person.exportTableData(table);
            }
        });

        panel1.add(scrollPane);

        panel2.add(label1);
        panel2.add(field1);
        panel2.add(button2);
        panel2.add(button1);

//        panel3.add(label1);
//        panel3.add(field1);

        add(panel1);
//        add(panel3);
        add(panel2);

        setVisible(true);

    }
}

