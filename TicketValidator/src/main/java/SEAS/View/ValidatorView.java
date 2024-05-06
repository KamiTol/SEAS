package SEAS.View;

import SEAS.Controller.ValidatorController;
import SEAS.Model.Domain.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidatorView extends javax.swing.JFrame {


    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private ValidatorController validatorController;

    public void setValidatorController(ValidatorController validatorController) {
        this.validatorController = validatorController;
    }

    public ValidatorView() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(20, 24, 27));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Validar Boleto");

        jButton1.setText("Buscar Boleto");

        jTable1.setBackground(new java.awt.Color(30, 33, 38));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel1)
                                                .addGap(40, 40, 40)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticketId = jTextField1.getText();
                Ticket ticket = new Ticket(ticketId); // Create a Ticket object
                ticket = validatorController.validateTicket(ticket); // Pass the Ticket object to validateTicket
                // If the ticket is valid, update the table model with the ticket data
                if (ticket != null) {
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                    {ticket.getId(), ticket.getPassengerId(), ticket.getPassengerName(), ticket.getPassengerSurname(), ticket.getPassengerIdType(), ticket.getCurrentAddress(), ticket.getPhoneNumber(), ticket.getLocation(), ticket.getPassengerCategory(), ticket.getFare(), ticket.getContactPerson(), ticket.getLuggageInfo()}
                            },
                            new String[]{
                                    "ID", "Passenger ID", "Passenger Name", "Passenger Surname", "Passenger ID Type", "Current Address", "Phone Number", "Location", "Passenger Category", "Fare", "Contact Person", "Luggage Info"
                            }
                    ));
                }
            }
        });
    }
}