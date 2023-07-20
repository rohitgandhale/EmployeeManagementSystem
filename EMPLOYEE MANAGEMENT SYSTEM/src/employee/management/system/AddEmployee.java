package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
     JTextField tfname,tffname,tfaddress,tfphone,tfadhaar,tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel labelempid ,lblempid;
    JButton add,back;
    AddEmployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAn SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(180, 150, 150, 37);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 37);
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(180, 200, 150, 35);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

         tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 37);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

         tfaddress = new JTextField();
        tfaddress.setBounds(180, 250, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone No.");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 37);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(180, 300, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "Btech", "MBA", "MCA", "MA", "Mtech", "MSC", "Phd"};
         cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(600, 300, 150, 37);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(180, 350, 150, 30);
        add(tfdesignation);

        JLabel labeladhaar = new JLabel("Adhhar Number");
        labeladhaar.setBounds(400, 350, 150, 30);
        labeladhaar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladhaar);

        tfadhaar = new JTextField();
        tfadhaar.setBounds(600, 350, 150, 37);
        add(tfadhaar);

         labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

         lblempid = new JLabel("" + number);
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);

         add = new JButton("Add details");add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add(add);

         back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);


        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource()== add){
             String name=tfname.getText();
             String fname=tffname.getText();
             String dob= ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
             String salary=tfsalary.getText();
             String address=tfaddress.getText();
             String phone=tfphone.getText();
             String email=tfemail.getText();
             String education= (String) cbeducation.getSelectedItem();
             String designation=tfdesignation.getText();
             String adhaar=tfadhaar.getText();
             String empid=lblempid.getText();

             try{
                 Con con=new Con();
                 String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhaar+"','"+empid+"') ";
                 con.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Details added successfully");
                 setVisible(false);
                 new Home();
             }catch (Exception e){
                 e.printStackTrace();
             }

         }else {
             setVisible(false);
             new Home();
         }
    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}

