/*
 * Changes
 * Adding of the action listener to getStudents button
 * Creation of getStudent Object class
 * Edition of the Main Class
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
//import java.util.*;
import javax.swing.border.TitledBorder;

public class ExamSystem3 extends JFrame {

    // Table
    JTable tblStudents;
    JButton btnStudents = new JButton("Students");
    JButton btnAddMarks = new JButton("Add Marks");
    JButton btnViewProfile = new JButton("View Profile");
    JButton btnViewMarks = new JButton("View Marks");
    JButton btnExit = new JButton("Exit");
    JButton btnSaveProfile = new JButton("Save");
    JButton btnSaveRecord = new JButton("Save");
    JButton btnClearRecord = new JButton("Clear");
    JButton btnClearProfile = new JButton("Clear");
    JButton btnAddStudent = new JButton("Add Student");
    JButton btnSearch = new JButton("Search");

    JLabel lblRegistration1 = new JLabel("Reg Number:");
    JLabel lblRegistration = new JLabel("Reg Number:");
    JLabel lblFname1 = new JLabel("First Name: ");
    JLabel lblSname1 = new JLabel("Second Name: ");
    JLabel lblFname = new JLabel("First Name: ");
    JLabel lblLname = new JLabel("Last Name: ");
    JLabel lblSname = new JLabel("Second Name: ");
    JLabel lblDob = new JLabel("DOB: ");
    JLabel lblGender = new JLabel("Sex: ");
    JLabel lblClass = new JLabel("Class: ");
    JLabel lblClass1 = new JLabel("Class: ");

    JLabel lblMath = new JLabel("Maths: ");
    JLabel lblEnglish = new JLabel("English: ");
    JLabel lblKiswahili = new JLabel("Kiswahili: ");
    JLabel lblScience = new JLabel("Science: ");
    JLabel lblReligion = new JLabel("Religion: ");

    JTextField txtRegistration1 = new JTextField(12);
    JTextField txtRegistration = new JTextField(12);
    JTextField txtFname = new JTextField(12);
    JTextField txtLname = new JTextField(12);
    JTextField txtSname = new JTextField(12);
    JTextField txtDob = new JTextField(12);

    JTextField txtFname2 = new JTextField(12);
    JTextField txtSname2 = new JTextField(12);
    JTextField txtClass2 = new JTextField(12);

    JTextField txtMath = new JTextField(12);
    JTextField txtEnglish = new JTextField(12);
    JTextField txtKiswahili = new JTextField(12);
    JTextField txtScience = new JTextField(12);
    JTextField txtReligion = new JTextField(12);

    String[] genderString = new String[]{"Male", "Female"};
    JComboBox<String> genderCB = new JComboBox<>(genderString); //add this to the panel/ frame
    String[] classString = new String[]{"Form One", "Form Two", "Form Three", "Form Four"};
    JComboBox<String> classCB = new JComboBox<>(classString); //add this to the panel/ frame

    JPanel blankPage;
    JPanel sidebar;
    JPanel details;
    JPanel pRegistration;
    JPanel pAddrecord;
    JPanel actions;
    JPanel actions2;

    // add to the parent container (e.g. a JFrame):
//add(genderCB);
// get the selected item:
//String selectedGender = (String) genderCB.getSelectedItem();
    ExamSystem3() {

        txtFname2.setEditable(false);
        txtSname2.setEditable(false);
        txtClass2.setEditable(false);

        blankPage = new JPanel(new GridLayout(0, 1));
        blankPage.setBorder(new TitledBorder("Information Section"));

        details = new JPanel(new GridLayout(0, 2, 2, 3));
        details.setBorder(new TitledBorder("Enter student's admission details"));
        details.add(lblRegistration1);
        details.add(txtRegistration1);
        details.add(lblFname);
        details.add(txtFname);
        details.add(lblLname);
        details.add(txtLname);
        details.add(lblSname);
        details.add(txtSname);
        details.add(lblClass);
        details.add(classCB);
        details.add(lblGender);
        details.add(genderCB);
        details.add(lblDob);
        details.add(txtDob);

        pAddrecord = new JPanel(new GridLayout(0, 5, 2, 2));
        pAddrecord.setBorder(new TitledBorder("Enter student's Marks Below"));
        pAddrecord.add(lblMath);
        pAddrecord.add(lblEnglish);
        pAddrecord.add(lblKiswahili);
        pAddrecord.add(lblScience);
        pAddrecord.add(lblReligion);
        pAddrecord.add(txtMath);
        pAddrecord.add(txtEnglish);
        pAddrecord.add(txtKiswahili);
        pAddrecord.add(txtScience);
        pAddrecord.add(txtReligion);

        actions = new JPanel(new FlowLayout());
        actions.setBorder(new TitledBorder("Action Buttons"));
        actions.add(btnSaveProfile);
        actions.add(btnClearProfile);

        actions2 = new JPanel(new FlowLayout());
        actions2.setBorder(new TitledBorder("Action Buttons"));
        actions2.add(btnSaveRecord);
        actions2.add(btnClearRecord);

        pRegistration = new JPanel();
        pRegistration.setBorder(new TitledBorder("Enter Reg. Number and Search"));
        JPanel innerPReg1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPReg1.add(lblRegistration);
        innerPReg1.add(txtRegistration);
        innerPReg1.add(btnSearch);
        JPanel innerPReg2 = new JPanel(new GridLayout(0, 4, 2, 3));
        innerPReg2.add(lblFname1);
        innerPReg2.add(txtFname2);
        innerPReg2.add(lblSname1);
        innerPReg2.add(txtSname2);
        innerPReg2.add(lblClass1);
        innerPReg2.add(txtClass2);
        pRegistration.add(innerPReg1, BorderLayout.NORTH);
        pRegistration.add(innerPReg2, BorderLayout.CENTER);

        sidebar = new JPanel(new GridLayout(0, 1));
        sidebar.setBorder(new TitledBorder("Sidebar"));
        btnStudents.setBackground(Color.LIGHT_GRAY);
        btnStudents.setBorderPainted(false);
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setBorderPainted(false);
        btnAddStudent.setBackground(Color.LIGHT_GRAY);
        btnAddStudent.setBorderPainted(false);
        btnAddMarks.setBackground(Color.LIGHT_GRAY);
        btnAddMarks.setBorderPainted(false);
        btnViewProfile.setBackground(Color.LIGHT_GRAY);
        btnViewProfile.setBorderPainted(false);
        btnSaveRecord.setBackground(Color.LIGHT_GRAY);
        btnClearRecord.setBackground(Color.ORANGE);
        btnSaveProfile.setBackground(Color.LIGHT_GRAY);
        btnViewMarks.setBackground(Color.LIGHT_GRAY);
        btnViewMarks.setBorderPainted(false);
        btnExit.setBackground(Color.RED);
        btnExit.setBorderPainted(false);
        btnClearProfile.setBackground(Color.ORANGE);
        sidebar.add(btnStudents);
        sidebar.add(btnAddStudent);
        sidebar.add(btnViewProfile);
        sidebar.add(btnAddMarks);
        sidebar.add(btnViewMarks);
        sidebar.add(btnExit);

        add(sidebar, BorderLayout.WEST);
        add(blankPage, BorderLayout.CENTER);
        //add(sidebar, BorderLayout.SOUTH);

        btnStudents.addActionListener(new ButtonListener());
        btnSearch.addActionListener(new ButtonListener());
        btnAddMarks.addActionListener(new ButtonListener());
        btnViewProfile.addActionListener(new ButtonListener());
        btnViewMarks.addActionListener(new ButtonListener());
        btnSaveProfile.addActionListener(new ButtonListener());
        btnClearProfile.addActionListener(new ButtonListener());
        btnExit.addActionListener(new ButtonListener());
        btnSaveRecord.addActionListener(new ButtonListener());
        btnClearRecord.addActionListener(new ButtonListener());
        btnAddStudent.addActionListener(new ButtonListener());

        //pack();
        setSize(700, 400);
        setTitle("Exam Sytstem");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnExit) {
                dispose();
                setVisible(false);
            } else if (e.getSource() == btnStudents) {

                /*
                 * First; Set up a function/ method that retrieves the student details from the flat file/json data
                 * This code is using the static data below for Demo Purposes
                 */
                getStudents();

            } else if (e.getSource() == btnViewProfile) {
                /*Get the selected row from the student table, and display the data*/
//                int[] selection = tblStudents.getSelectedRows();
//                for (int i = 0; i < selection.length; i++) {
//                    selection[i] = tblStudents.convertRowIndexToModel(selection[i]);
//                    System.out.println(selection[i]);
//                }
                new StudentProfile();

            } else if (e.getSource() == btnAddStudent) {
                //Get Add students details
                blankPage.removeAll();
                blankPage.add(details, BorderLayout.CENTER);
                blankPage.add(actions, BorderLayout.SOUTH);
                blankPage.revalidate();
                blankPage.repaint();

            } else if (e.getSource() == btnClearProfile) {
                txtRegistration1.setText("");
                txtFname.setText("");
                txtLname.setText("");
                txtSname.setText("");
                txtDob.setText("");

            } else if (e.getSource() == btnAddMarks) {
                blankPage.removeAll();
                blankPage.add(pRegistration, BorderLayout.NORTH);
                blankPage.add(pAddrecord, BorderLayout.CENTER);
                blankPage.add(actions2, BorderLayout.SOUTH);
                blankPage.revalidate();
                blankPage.repaint();
                //
            } else if (e.getSource() == btnViewMarks) {
                //
            } else if (e.getSource() == btnClearRecord) {
                //
            }
        }//End of SUBMIT button.
    }

    public void getStudents() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Vector<Object> rows = new Vector<Object>();
        Vector<Object> rows2 = new Vector<Object>();
        Vector<Object> rows3 = new Vector<Object>();

        rows.add("Marrie");
        rows.add("Jane");
        rows.add("Njuge");
        rows.add("Female");
        rows.add("22/04/1995");
        rows.add("10235");
        rows.add("Form One");
        data.add(rows);

        rows2.add("Reagan");
        rows2.add("Omondi");
        rows2.add("Onyango");
        rows2.add("Male");
        rows2.add("22/04/1995");
        rows2.add("45263");
        rows2.add("Form One");
        data.add(rows2);

        rows3.add("Bon");
        rows3.add("Slak");
        rows3.add("Marsh");
        rows3.add("Male");
        rows3.add("22/04/1995");
        rows3.add("10535");
        rows3.add("Form One");
        data.add(rows3);

        // Column Names
        Vector<String> headers = new Vector<String>();
        headers.add("First Name");
        headers.add("Second Name");
        headers.add("Last Name");
        headers.add("Sex");
        headers.add("DoB");
        headers.add("Reg Number");
        headers.add("Class");

        // Initializing the JTable
        tblStudents = new JTable(data, headers);
        JScrollPane sp1 = new JScrollPane(tblStudents);

        blankPage.add(sp1);
        blankPage.revalidate();
        blankPage.repaint();
    }

    public void getMarks() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Vector<Object> rows = new Vector<Object>();
        Vector<Object> rows2 = new Vector<Object>();
        Vector<Object> rows3 = new Vector<Object>();

        rows.add("Marrie");
        rows.add("Jane");
        rows.add("Njuge");
        rows.add("Female");
        rows.add("22/04/1995");
        rows.add("10235");
        rows.add("Form One");
        data.add(rows);

        rows2.add("Reagan");
        rows2.add("Omondi");
        rows2.add("Onyango");
        rows2.add("Male");
        rows2.add("22/04/1995");
        rows2.add("45263");
        rows2.add("Form One");
        data.add(rows2);

        rows3.add("Bon");
        rows3.add("Slak");
        rows3.add("Marsh");
        rows3.add("Male");
        rows3.add("22/04/1995");
        rows3.add("10535");
        rows3.add("Form One");
        data.add(rows3);

        // Column Names
        Vector<String> headers = new Vector<String>();
        headers.add("First Name");
        headers.add("Second Name");
        headers.add("Last Name");
        headers.add("Sex");
        headers.add("DoB");
        headers.add("Reg Number");
        headers.add("Class");

        // Initializing the JTable
        tblStudents = new JTable(data, headers);
        JScrollPane sp1 = new JScrollPane(tblStudents);

        blankPage.add(sp1);
        blankPage.revalidate();
        blankPage.repaint();
    }

    public static void main(String[] args) {
        //System.out.println("Reagan Omondi");
        ExamSystem3 es = new ExamSystem3();
        es.getStudents();
    }

    /* *
     ** Another class
     ** Inner Class Starts Here
     ** View Student Profile
     * */
    public class StudentProfile {

        JTable tblStudentRecords;
        JPanel pTable;
        JPanel pDetails;
        JPanel pMain = new JPanel(new BorderLayout(0, 1));
        JButton btnSearchRecord = new JButton("Search");

        JLabel lblRegNo = new JLabel("Registration Number: ");
        JLabel lblName = new JLabel("Name: ");
        JLabel lblSex = new JLabel("Sex: ");
        JLabel lblClass = new JLabel("Class: ");

        JTextField txtRegNo = new JTextField(12);
        JTextField txtName = new JTextField(12);
        JTextField txtSex = new JTextField(12);
        JTextField txtClass = new JTextField(12);

        public StudentProfile() {
            txtName.setEditable(false);
            txtSex.setEditable(false);
            txtClass.setEditable(false);

            pDetails = new JPanel(new BorderLayout(0, 1));
            pDetails.setBorder(new TitledBorder("Enter Reg. Number and Search"));
            JPanel innerPReg1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            innerPReg1.add(lblRegNo);
            innerPReg1.add(txtRegNo);
            innerPReg1.add(btnSearchRecord);
            JPanel innerPReg2 = new JPanel(new GridLayout(0, 4, 2, 3));
            innerPReg2.add(lblName);
            innerPReg2.add(txtName);
            innerPReg2.add(lblSex);
            innerPReg2.add(txtSex);
            innerPReg2.add(lblClass);
            innerPReg2.add(txtClass);
            pDetails.add(innerPReg1, BorderLayout.NORTH);
            pDetails.add(innerPReg2, BorderLayout.CENTER);

            pTable = new JPanel();
            pTable.setBorder(new TitledBorder("Student's Records..."));
            record();

            btnSearchRecord.setBackground(Color.LIGHT_GRAY);
            btnSearchRecord.setBorderPainted(false);
            //btnSearchRecord.addActionListener(new ButtonListener());

            pMain.add(pDetails, BorderLayout.NORTH);
            pMain.add(pTable, BorderLayout.CENTER);

            blankPage.removeAll();
            blankPage.add(pMain);
            blankPage.revalidate();
            blankPage.repaint();

        }

        public void record() {
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();

            Vector<Object> rows = new Vector<Object>();
            Vector<Object> rows2 = new Vector<Object>();
            Vector<Object> rows3 = new Vector<Object>();

            rows.add("12");
            rows.add("12");
            rows.add("54");
            rows.add("63");
            rows.add("12");
            rows.add("45");
            data.add(rows);

            rows2.add("14");
            rows2.add("52");
            rows2.add("52");
            rows2.add("83");
            rows2.add("22");
            rows2.add("65");
            data.add(rows2);

            rows3.add("56");
            rows3.add("52");
            rows3.add("14");
            rows3.add("45");
            rows3.add("65");
            rows3.add("45");
            data.add(rows3);

            // Column Names
            Vector<String> headers = new Vector<String>();
            headers.add("Maths");
            headers.add("English");
            headers.add("Kisw");
            headers.add("History");
            headers.add("Religion");
            headers.add("Science");

            // Initializing the JTable
            tblStudentRecords = new JTable(data, headers);
            JScrollPane sp1 = new JScrollPane(tblStudentRecords);
            pTable.add(sp1);

        }
    }
    /* *
     ** Inner Class Ends Here
     ** View Student Profile
     * */

}

