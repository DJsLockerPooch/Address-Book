package addressbook;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.Collections;

public class AddressFrame extends javax.swing.JFrame {

    public AddressFrame() {
        // Create the table model
        model = new PersonTableModel();

        // Add people (Take these out if you don't want "default" people)
        // Create controls
        initComponents();

        // Set the ZIP code to always draw with 5 digits
        TableColumn zip = tblPeople.getColumnModel().getColumn(5);
        zip.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object o) {
                Integer value = (Integer) o;
                String s = String.format("%05d", value);
                setText(s);
            }
        });

        // Set up column widths
        tblPeople.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblPeople.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblPeople.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblPeople.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblPeople.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblPeople.getColumnModel().getColumn(5).setPreferredWidth(60);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeople = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newPerson = new javax.swing.JMenuItem();
        sortMenu = new javax.swing.JMenu();
        sortName = new javax.swing.JMenuItem();
        sortAddress = new javax.swing.JMenuItem();
        sortCity = new javax.swing.JMenuItem();
        sortState = new javax.swing.JMenuItem();
        sortZip = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Address Book");

        tblPeople.setModel(model);
        jScrollPane1.setViewportView(tblPeople);

        fileMenu.setText("File");

        newPerson.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        newPerson.setText("New Person");
        newPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPersonActionPerformed(evt);
            }
        });
        fileMenu.add(newPerson);

        jMenuBar1.add(fileMenu);

        sortMenu.setText("Sort");

        sortName.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.META_MASK));
        sortName.setText("Name (Last, First)");
        sortName.setEnabled(false);
        sortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortNameActionPerformed(evt);
            }
        });
        sortMenu.add(sortName);

        sortAddress.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.META_MASK));
        sortAddress.setText("Address");
        sortAddress.setEnabled(false);
        sortAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortAddressActionPerformed(evt);
            }
        });
        sortMenu.add(sortAddress);

        sortCity.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.META_MASK));
        sortCity.setText("City");
        sortCity.setEnabled(false);
        sortCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortCityActionPerformed(evt);
            }
        });
        sortMenu.add(sortCity);

        sortState.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.META_MASK));
        sortState.setText("State");
        sortState.setEnabled(false);
        sortState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortStateActionPerformed(evt);
            }
        });
        sortMenu.add(sortState);

        sortZip.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.META_MASK));
        sortZip.setText("Zip");
        sortZip.setEnabled(false);
        sortZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortZipActionPerformed(evt);
            }
        });
        sortMenu.add(sortZip);

        jMenuBar1.add(sortMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortNameActionPerformed

        model.sort(new Person.NameComparator());

    }//GEN-LAST:event_sortNameActionPerformed

    private void newPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPersonActionPerformed

        String firstName = JOptionPane.showInputDialog("Enter the first name of the person.");
        String lastName = JOptionPane.showInputDialog("Enter the last name of the person.");
        String address = JOptionPane.showInputDialog("Enter the address of the person.");
        String city = JOptionPane.showInputDialog("Enter the city of the person.");
        String state = JOptionPane.showInputDialog("Enter the state of the person.");
        int zip = Integer.parseInt(JOptionPane.showInputDialog("Enter the zip of the person."));

        model.addPerson(new Person(firstName, lastName, address, city, state, zip));

        sortName.setEnabled(true);
        sortAddress.setEnabled(true);
        sortZip.setEnabled(true);
        sortCity.setEnabled(true);
        sortState.setEnabled(true);

    }//GEN-LAST:event_newPersonActionPerformed

    private void sortAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortAddressActionPerformed

        model.sort(new Person.AddressComparator());

    }//GEN-LAST:event_sortAddressActionPerformed

    private void sortCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortCityActionPerformed

        model.sort(new Person.CityComparator());

    }//GEN-LAST:event_sortCityActionPerformed

    private void sortStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortStateActionPerformed

        model.sort(new Person.StateComparator());

    }//GEN-LAST:event_sortStateActionPerformed

    private void sortZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortZipActionPerformed

        model.sort(new Person.ZipComparator());

    }//GEN-LAST:event_sortZipActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddressFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newPerson;
    private javax.swing.JMenuItem sortAddress;
    private javax.swing.JMenuItem sortCity;
    private javax.swing.JMenu sortMenu;
    private javax.swing.JMenuItem sortName;
    private javax.swing.JMenuItem sortState;
    private javax.swing.JMenuItem sortZip;
    private javax.swing.JTable tblPeople;
    // End of variables declaration//GEN-END:variables
	private PersonTableModel model;
}
