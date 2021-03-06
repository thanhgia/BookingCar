
import gia.dao.CarDAO;
import gia.dto.CarDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class ManagerCar extends javax.swing.JFrame {

    private DefaultTableModel tblModelCar = null;
    int count = 0;

    /**
     * Creates new form ManagerCar
     */
    public ManagerCar() {
        initComponents();
        myInit();
        loadData();

    }

    private void myInit() {
        try {
            tblModelCar = (DefaultTableModel) tblListCar.getModel();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showData(List<CarDTO> list) {
        tblModelCar.setRowCount(0);
        for (CarDTO carDTO : list) {
            tblModelCar.addRow(carDTO.toVector());
        }

    }

    private void loadData() {
        try {
            CarDAO dao = new CarDAO();
            List<CarDTO> result = dao.loadCarManager();
            showData(result);
        } catch (Exception ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLice = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtSeat = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListCar = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Manager Car");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Car information"));

        jLabel2.setText("License Plate:");

        jLabel3.setText("Brand:");

        jLabel4.setText("Color:");

        jLabel5.setText("Amount Of Seat:");

        jLabel6.setText("Price:");

        jLabel7.setText("State:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel8.setText("Ex:12A-12345");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLice)
                            .addComponent(txtBrand)
                            .addComponent(txtColor)
                            .addComponent(txtSeat)
                            .addComponent(txtPrice)
                            .addComponent(txtState, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(19, 19, 19))
        );

        tblListCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "License Plate", "Brand", "Color", "Seat", "Price", "State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblListCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListCarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListCar);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnBack)
                        .addGap(325, 325, 325)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:

            String licensePlate = txtLice.getText();
            String brand = txtBrand.getText();
            String color = txtColor.getText();

            String state = txtState.getText();
            String seat = txtSeat.getText();//check blank seat
            String money = txtPrice.getText();//check blank price 

            boolean checkDataUpdate = checkValid.CheckValid.checkCar(licensePlate, brand, color, seat, money, state);
            if (checkDataUpdate == true) {
                int amountOfSeat = Integer.parseInt(txtSeat.getText());
                float price = Float.parseFloat(txtPrice.getText());
                CarDTO car = new CarDTO(licensePlate, brand, color, amountOfSeat, price, state);
                CarDAO dao = new CarDAO();
                boolean check = dao.update(car);
                if (check == true) {
                    JOptionPane.showMessageDialog(null, "Update success");
                    int row = tblListCar.getSelectedRow();
                    tblModelCar.setValueAt(licensePlate, row, 0);
                    tblModelCar.setValueAt(brand, row, 1);
                    tblModelCar.setValueAt(color, row, 2);
                    tblModelCar.setValueAt(amountOfSeat, row, 3);
                    tblModelCar.setValueAt(price, row, 4);
                    tblModelCar.setValueAt(state, row, 5);
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field is not blank.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerCar.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            String licensePlate = txtLice.getText();
            String brand = txtBrand.getText();
            String color = txtColor.getText();
            String stateTest = txtState.getText();
            String state = "Not using";
            String seat = txtSeat.getText();//check blank seat
            String money = txtPrice.getText();//check blank price 
            if (stateTest.equalsIgnoreCase("Free") == true) {

                boolean checkDataUpdate = checkValid.CheckValid.checkCar(licensePlate, brand, color, seat, money, state);
                if (checkDataUpdate == true) {
                    int amountOfSeat = Integer.parseInt(txtSeat.getText());
                    float price = Float.parseFloat(txtPrice.getText());
                    CarDTO car = new CarDTO(licensePlate, brand, color, amountOfSeat, price, state);
                    CarDAO dao = new CarDAO();
                    boolean check = dao.update(car);
                    if (check == true) {
                        JOptionPane.showMessageDialog(null, "Delete success");
                        int row = tblListCar.getSelectedRow();
                        tblModelCar.setValueAt(licensePlate, row, 0);
                        tblModelCar.setValueAt(brand, row, 1);
                        tblModelCar.setValueAt(color, row, 2);
                        tblModelCar.setValueAt(amountOfSeat, row, 3);
                        tblModelCar.setValueAt(price, row, 4);
                        tblModelCar.setValueAt(state, row, 5);
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete failed");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Field is not blank.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please choose car has state is free");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerCar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblListCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCarMouseClicked
        try {
            // TODO add your handling code here:
            count++;
            int row = tblListCar.getSelectedRow();
            String LisencePlate = (String) tblModelCar.getValueAt(row, 0);

            CarDAO carDao = new CarDAO();
            CarDTO carDto = carDao.loadCarsByLicensePlate(LisencePlate);

            txtLice.setText(carDto.getLicensePlate());
            txtBrand.setText(carDto.getBrand());
            txtColor.setText(carDto.getColor());
            txtSeat.setText(carDto.getAmountOfSeat() + "");
            txtPrice.setText(carDto.getPrice() + "");
            if (carDto.getState().equalsIgnoreCase("Busy") == true) {
                txtState.setText("Busy");
            } else {
                txtState.setText("Free");
            }
        } catch (Exception ex) { 
            Logger.getLogger(ManagerCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtLice.setEditable(false);
        txtBrand.setEditable(false);
        txtSeat.setEditable(false);
        txtState.setEditable(false);
        btnAdd.setEnabled(false);

    }//GEN-LAST:event_tblListCarMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtLice.setText("");
        txtBrand.setText("");
        txtColor.setText("");
        txtSeat.setText("");
        txtState.setText("");
        txtPrice.setText("");
        btnAdd.setEnabled(true);
        txtLice.setEditable(true);
        txtBrand.setEditable(true);
        txtSeat.setEditable(true);
        txtState.setEditable(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            txtLice.setEditable(false);
            txtBrand.setEditable(false);
            txtSeat.setEditable(false);
            txtState.setEditable(false);

            String licensePlate = txtLice.getText();
            String brand = txtBrand.getText();
            String color = txtColor.getText();
            String state = txtState.getText();
            String seat = txtSeat.getText();//check blank seat
            String money = txtPrice.getText();//check blank price 

            boolean checkData = checkValid.CheckValid.checkCar(licensePlate, brand, color, seat, money, state);
            if (checkData == true) {
                if (state.equalsIgnoreCase("Free") == true) {
                    int amountOfSeat = Integer.parseInt(txtSeat.getText());
                    float price = Float.parseFloat(txtPrice.getText());
                    CarDTO dto = new CarDTO(licensePlate, brand, color, amountOfSeat, price, state);
                    CarDAO dao = new CarDAO();
                    boolean check = dao.addCar(dto);
                    if (check) {
                        JOptionPane.showMessageDialog(null, "Add sucessfull");
                    } else {
                        JOptionPane.showMessageDialog(null, "Add fail");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fill in state must be Free");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Feild is not blank or License Plate wrong format.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagerCar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ManageAdminSytem manage = new ManageAdminSytem();
        dispose();
        manage.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblListCar;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLice;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSeat;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
