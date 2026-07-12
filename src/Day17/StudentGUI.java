package Day17;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame implements ActionListener {

    JLabel lblId, lblName, lblEmail;

    JTextField txtId, txtName, txtEmail;

    JButton btnSave, btnSearch, btnUpdate, btnDelete, btnDisplay, btnClear;

    JTable table;

    DefaultTableModel model;

    StudentDAO dao = new StudentDAO();

    public StudentGUI() {

        setTitle("Student Management System");

        setSize(750, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        // ================= Labels =================

        lblId = new JLabel("Student ID");
        lblId.setBounds(30, 30, 100, 25);
        add(lblId);

        lblName = new JLabel("Name");
        lblName.setBounds(30, 70, 100, 25);
        add(lblName);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 110, 100, 25);
        add(lblEmail);

        // ================= Text Fields =================

        txtId = new JTextField();
        txtId.setBounds(150, 30, 150, 25);
        add(txtId);

        txtName = new JTextField();
        txtName.setBounds(150, 70, 200, 25);
        add(txtName);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 110, 250, 25);
        add(txtEmail);

        // ================= Buttons =================

        btnSave = new JButton("Save");
        btnSave.setBounds(30, 170, 90, 30);
        add(btnSave);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(130, 170, 90, 30);
        add(btnSearch);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(230, 170, 90, 30);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(330, 170, 90, 30);
        add(btnDelete);

        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(430, 170, 90, 30);
        add(btnDisplay);

        btnClear = new JButton("Clear");
        btnClear.setBounds(530, 170, 90, 30);
        add(btnClear);

        // ================= JTable =================

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        sp.setBounds(30, 230, 670, 200);

        add(sp);

        // ================= Action Listener =================

        btnSave.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);

        // Load data when GUI starts
        displayTable();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // ================= SAVE =================

        if (e.getSource() == btnSave) {

            if (name.isEmpty() || email.isEmpty()) {

                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }

            if (!email.matches(regex)) {

                JOptionPane.showMessageDialog(this, "Invalid Email.");
                return;
            }

            dao.insertStudent(new Student(name, email));

            JOptionPane.showMessageDialog(this, "Student Added Successfully.");

            displayTable();

            txtName.setText("");
            txtEmail.setText("");
        }

        // ================= SEARCH =================

        if (e.getSource() == btnSearch) {

            if (txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Enter Student ID.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            Student student = dao.searchStudent(id);

            if (student != null) {

                txtName.setText(student.getName());
                txtEmail.setText(student.getEmail());

            } else {

                JOptionPane.showMessageDialog(this, "Student Not Found.");
            }
        }

        // ================= UPDATE =================

        if (e.getSource() == btnUpdate) {

            if (txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Enter Student ID.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            Student student = new Student(id, name, email);

            dao.updateStudent(student);

            JOptionPane.showMessageDialog(this, "Student Updated Successfully.");

            displayTable();
        }

        // ================= DELETE =================

        if (e.getSource() == btnDelete) {

            if (txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Enter Student ID.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            dao.deleteStudent(id);

            JOptionPane.showMessageDialog(this, "Student Deleted Successfully.");

            displayTable();

            txtId.setText("");
            txtName.setText("");
            txtEmail.setText("");
        }

        // ================= DISPLAY =================

        if (e.getSource() == btnDisplay) {

            displayTable();
        }

        // ================= CLEAR =================

        if (e.getSource() == btnClear) {

            txtId.setText("");
            txtName.setText("");
            txtEmail.setText("");
        }

    }

    // ================= DISPLAY TABLE =================

    private void displayTable() {

        model.setRowCount(0);

        ArrayList<Student> list = dao.getAllStudents();

        for (Student student : list) {

            model.addRow(new Object[] {

                    student.getStudentId(),
                    student.getName(),
                    student.getEmail()

            });

        }

    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new StudentGUI());

    }

}