/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.Shipping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adity
 */
public class shippingHomePanel extends javax.swing.JPanel {
    Connection connection;
    String selectedOrder="";
    String selectedOrderDate="";
    String orderItems="";
    /**
     * Creates new form shippingHomePanel
     */
    public shippingHomePanel(Connection connection) {
        this.connection = connection;
    
        initComponents();
        populateshipmentOrderTable(connection);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderItems = new javax.swing.JLabel();
        txtOrderItems = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShipmentOrders = new javax.swing.JTable();
        btnFinalizeOrder = new javax.swing.JButton();
        lblSupplyOrders = new javax.swing.JLabel();
        btnViewOrder = new javax.swing.JButton();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(25, 56, 82));

        lblOrderItems.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderItems.setText("Order Items:");

        tblShipmentOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Date", "Order Items", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblShipmentOrders);

        btnFinalizeOrder.setText("Raise for Delivery");
        btnFinalizeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizeOrderActionPerformed(evt);
            }
        });

        lblSupplyOrders.setBackground(new java.awt.Color(255, 255, 255));
        lblSupplyOrders.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblSupplyOrders.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplyOrders.setText("SHIPMENT ORDERS");

        btnViewOrder.setText("View Order");
        btnViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderActionPerformed(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Raise for Delivery", "cancelled" }));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSupplyOrders)
                        .addGap(436, 436, 436))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblOrderItems)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnFinalizeOrder)
                                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(174, 174, 174)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewOrder))
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblSupplyOrders)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewOrder)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderItems)
                    .addComponent(txtOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnFinalizeOrder)
                .addContainerGap(196, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizeOrderActionPerformed
        // TODO add your handling code here:
        try{
            PreparedStatement preparedStatement =connection.prepareStatement("insert into delivery_orders values(?,?,?,?)");

                preparedStatement.setString(1,selectedOrder);
                preparedStatement.setString(2,selectedOrderDate);
                preparedStatement.setString(3,orderItems);
                preparedStatement.setString(4,cbStatus.getSelectedItem().toString());

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Delivery Request Raised Successfully..");
                txtOrderItems.setText("");
        }
        catch(SQLException e){
            System.out.println("Error Connecting Database" + e);
            JOptionPane.showMessageDialog(this,"Delivery Request Already Raised..");

        }
    }//GEN-LAST:event_btnFinalizeOrderActionPerformed

    private void btnViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex  = tblShipmentOrders.getSelectedRow();

        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select a Row to View");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblShipmentOrders.getModel();
         orderItems = (String) model.getValueAt(selectedRowIndex,2);
//        String orderTotal = (String) model.getValueAt(selectedRowIndex,3);
        selectedOrder = (String) model.getValueAt(selectedRowIndex,0);
        selectedOrderDate = (String) model.getValueAt(selectedRowIndex,1);
 
        txtOrderItems.setText(orderItems);
    }//GEN-LAST:event_btnViewOrderActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed
    
    public void populateshipmentOrderTable(Connection connection){
        DefaultTableModel model = (DefaultTableModel) tblShipmentOrders.getModel();
        model.setRowCount(0);
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from shipment_orders");
            ResultSet rs = preparedStatement.executeQuery(); 
            while(rs.next()){
            Object[] rows = new Object[4];
            rows[0]= rs.getString(1);
            rows[1]=rs.getString(2);
            rows[2]=rs.getString(3);
            rows[3]=rs.getString(5);
            
            model.addRow(rows);
            }
        }
        catch(SQLException e){System.out.println(e);}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizeOrder;
    private javax.swing.JButton btnViewOrder;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderItems;
    private javax.swing.JLabel lblSupplyOrders;
    private javax.swing.JTable tblShipmentOrders;
    private javax.swing.JTextField txtOrderItems;
    // End of variables declaration//GEN-END:variables
}
