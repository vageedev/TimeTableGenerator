/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import DBconnetions.DBconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class session_search extends javax.swing.JPanel {

    Generator generator;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form session_search
     */
    public session_search() {
        initComponents();
        con = DBconnect.connect();
        sessionsearch();
        lecSessionSearch();
        subCodeSession();
        groupSearch();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel111_searchSession = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        session_searchSession = new javax.swing.JTextArea();
        search_searchSession = new javax.swing.JButton();
        sessionlecturer_searchSession = new javax.swing.JComboBox<>();
        sessionId_searchSession = new javax.swing.JComboBox<>();
        sessionsubcode_searchSession = new javax.swing.JComboBox<>();
        search_searchLecturer = new javax.swing.JButton();
        search_subcodeSession = new javax.swing.JButton();
        sessiongroup_searchSession = new javax.swing.JComboBox<>();
        search_groupSession = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 51, 109));

        panel111_searchSession.setBackground(new java.awt.Color(137, 14, 137));
        panel111_searchSession.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Session Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        panel111_searchSession.setToolTipText("Select");

        session_searchSession.setEditable(false);
        session_searchSession.setColumns(20);
        session_searchSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        session_searchSession.setRows(5);
        session_searchSession.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(session_searchSession);

        search_searchSession.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search_searchSession.setText("Search");
        search_searchSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_searchSessionActionPerformed(evt);
            }
        });

        sessionlecturer_searchSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sessionlecturer_searchSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer Name" }));
        sessionlecturer_searchSession.setBorder(null);
        sessionlecturer_searchSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sessionId_searchSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sessionId_searchSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Session ID" }));
        sessionId_searchSession.setBorder(null);
        sessionId_searchSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sessionsubcode_searchSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sessionsubcode_searchSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code" }));
        sessionsubcode_searchSession.setBorder(null);
        sessionsubcode_searchSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        search_searchLecturer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search_searchLecturer.setText("Search");
        search_searchLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_searchLecturerActionPerformed(evt);
            }
        });

        search_subcodeSession.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search_subcodeSession.setText("Search");
        search_subcodeSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_subcodeSessionActionPerformed(evt);
            }
        });

        sessiongroup_searchSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sessiongroup_searchSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Group Number" }));
        sessiongroup_searchSession.setBorder(null);
        sessiongroup_searchSession.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        search_groupSession.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search_groupSession.setText("Search");
        search_groupSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_groupSessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel111_searchSessionLayout = new javax.swing.GroupLayout(panel111_searchSession);
        panel111_searchSession.setLayout(panel111_searchSessionLayout);
        panel111_searchSessionLayout.setHorizontalGroup(
            panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                                .addComponent(sessionId_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_searchSession))
                            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                                .addComponent(sessionlecturer_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_searchLecturer))
                            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                                .addComponent(sessionsubcode_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_subcodeSession))
                            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                                .addComponent(sessiongroup_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_groupSession)))))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        panel111_searchSessionLayout.setVerticalGroup(
            panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel111_searchSessionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionId_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_searchSession))
                .addGap(18, 18, 18)
                .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionlecturer_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_searchLecturer))
                .addGap(18, 18, 18)
                .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionsubcode_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_subcodeSession))
                .addGap(18, 18, 18)
                .addGroup(panel111_searchSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessiongroup_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_groupSession))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(panel111_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(panel111_searchSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_searchSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_searchSessionActionPerformed
        // TODO add your handling code here:

        FunctionSessionId f = new FunctionSessionId();

        ResultSet rs = null;

        String sessions = "sessions";

        rs = f.find(sessionId_searchSession.getSelectedItem().toString());

        try {

            //view the session details
            if (rs.next()) {

                session_searchSession.setText(rs.getString("sessions"));

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_search_searchSessionActionPerformed

    private void search_searchLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_searchLecturerActionPerformed
        // TODO add your handling code here:
        
        FunctionLecturerSession f = new FunctionLecturerSession();

        ResultSet rs = null;

        String session = "sessions";

        rs = f.find(sessionlecturer_searchSession.getSelectedItem().toString());

        try {

            //view the session details
            if (rs.next()) {

                session_searchSession.setText(rs.getString("sessions"));

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_search_searchLecturerActionPerformed

    private void search_subcodeSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_subcodeSessionActionPerformed
        // TODO add your handling code here:
        
        FunctionSubjectSession f = new FunctionSubjectSession();

        ResultSet rs = null;

        String session = "sessions";

        rs = f.find(sessionsubcode_searchSession.getSelectedItem().toString());

        try {

            //view the session details
            if (rs.next()) {

                session_searchSession.setText(rs.getString("sessions"));

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_search_subcodeSessionActionPerformed

    private void search_groupSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_groupSessionActionPerformed
        // TODO add your handling code here:
        
        FunctionGroupSession f = new FunctionGroupSession();

        ResultSet rs = null;

        String session = "sessions";

        rs = f.find(sessiongroup_searchSession.getSelectedItem().toString());

        try {

            //view the session details
            if (rs.next()) {

                session_searchSession.setText(rs.getString("sessions"));

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_search_groupSessionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel111_searchSession;
    private javax.swing.JButton search_groupSession;
    private javax.swing.JButton search_searchLecturer;
    private javax.swing.JButton search_searchSession;
    private javax.swing.JButton search_subcodeSession;
    private javax.swing.JComboBox<String> sessionId_searchSession;
    private javax.swing.JTextArea session_searchSession;
    private javax.swing.JComboBox<String> sessiongroup_searchSession;
    private javax.swing.JComboBox<String> sessionlecturer_searchSession;
    private javax.swing.JComboBox<String> sessionsubcode_searchSession;
    // End of variables declaration//GEN-END:variables

    private void sessionsearch(){      
        String sql = "select * from sessions";       
        try{            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                
                //load the combo box os sessionId
                sessionId_searchSession.addItem(rs.getString("sessionID"));                
            }                  }
        catch(Exception e){           
             JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);            
        }   }
    
    private void lecSessionSearch(){      
        String sql = "select * from sessions";       
        try{            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                sessionlecturer_searchSession.addItem(rs.getString("lecturer"));                
            }                  }
        catch(Exception e){           
             JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);            
        }   }
    
    private void subCodeSession(){      
        String sql = "select * from subject";       
        try{            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                sessionsubcode_searchSession.addItem(rs.getString("code"));              
            }                  }
        catch(Exception e){           
             JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);            
        }   }
    
    private void groupSearch(){      
        String sql = "select * from sessions";       
        try{            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                sessiongroup_searchSession.addItem(rs.getString("groupNo"));              
            }                  }
        catch(Exception e){           
             JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);            
        }   }
    
    public class FunctionSessionId {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
                ps = con.prepareStatement("select * from sessions where sessionID=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }
    
    public class FunctionLecturerSession {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
                ps = con.prepareStatement("select * from sessions where lecturer=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }
    
    public class FunctionSubjectSession {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
                ps = con.prepareStatement("select * from sessions where subCode=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }
    
    public class FunctionGroupSession {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
                ps = con.prepareStatement("select * from sessions where groupNo=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }


}