/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import services.IChatLieuService;
import services.impl.ChatLieuService;

/**
 *
 * @author homna
 */
public class FrmChatLieu extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private IChatLieuService chatLieuService;

    public FrmChatLieu() {
        chatLieuService = new ChatLieuService();
        initComponents();
        setLocationRelativeTo(null);
        trangThai();
        lbl_date.setText(getDateNow());
        loadTable(chatLieuService.getListSize());
        System.out.println(getDateNow());
        
    }
    
    
    public void trangThai(){
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdo_dangKinhDoanh);
        bg.add(rdo_ngungKinhDong);
        rdo_dangKinhDoanh.setSelected(true);
    }

    public String getDateNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        return date;
    }

    public void loadTable(List<ChatLieu> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tbo_table.getModel();
        defaultTableModel.setRowCount(0);
        for (ChatLieu chatLieu : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,
                chatLieu.getMa(),
                chatLieu.getTen(),
                chatLieu.getNgayThem(),
                chatLieu.getNgaySuaCuoi(),
                chatLieu.getTrangThai() == 0 ? "Đang kinh doanh":"Ngừng kinh doanh"
            });
        }
    }
    
    public int getTrangThaiInt(){
        if (rdo_dangKinhDoanh.isSelected()) {
            return 0;
        }else{
            return 1;
        }
    }
   
    public ChatLieu getdata(){
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setTen(txt_ten.getText().trim());
        chatLieu.setTrangThai(getTrangThaiInt());
        chatLieu.setNgayThem(Date.valueOf(getDateNow()));
        chatLieu.setNgaySuaCuoi(Date.valueOf(getDateNow()));
        return chatLieu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_ma = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new swing.TextField();
        rdo_dangKinhDoanh = new swing.RadioButtonCustom();
        rdo_ngungKinhDong = new swing.RadioButtonCustom();
        btn_them = new swing.Button();
        btn_sua = new swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbo_table = new javax.swing.JTable();
        txt_TimKiem = new swing.TextField();
        lbl_date = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_ma.setEditable(false);
        txt_ma.setLabelText("Mã");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Chất Liệu");

        txt_ten.setLabelText("Tên");

        rdo_dangKinhDoanh.setText("Đang kinh doanh");

        rdo_ngungKinhDong.setText("Ngừng kinh doanh");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Cập Nhật");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        tbo_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Ngày Thêm", "Ngày Sửa Cuối", "Trạng Thái"
            }
        ));
        tbo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbo_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbo_table);

        txt_TimKiem.setLabelText("Tìm kiếm");
        txt_TimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TimKiemCaretUpdate(evt);
            }
        });

        lbl_date.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rdo_ngungKinhDong, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(txt_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rdo_dangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(lbl_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdo_ngungKinhDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rdo_dangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        ChatLieu cl = getdata();
        String result;
        for (int i = 0; i < chatLieuService.getListSize().size() + 1; i++) {
            result = "CL" + i;
            if (chatLieuService.getObject(result) == null) {
                cl.setMa(result);
                break;
            } else {
                continue;
            }
        }
        if (cl.getTen().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Tên !");
            return;
        }
        chatLieuService.save(cl);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        loadTable(chatLieuService.getListSize());
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tbo_table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng rồi sửa !");
            return;
        }
        ChatLieu chatLieu = getdata();
        String ma = tbo_table.getValueAt(row, 1).toString();
        if (txt_ten.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được sửa rỗng !");
            return;
        }
        ChatLieu cl = chatLieuService.getObject(ma);
        cl.setTen(chatLieu.getTen());
        cl.setTrangThai(chatLieu.getTrangThai());
        cl.setNgaySuaCuoi(chatLieu.getNgaySuaCuoi());
        chatLieuService.save(cl);
        JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công !");
        loadTable(chatLieuService.getListSize());
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_TimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TimKiemCaretUpdate
        loadTable(chatLieuService.getSearch(txt_TimKiem.getText().trim()));
    }//GEN-LAST:event_txt_TimKiemCaretUpdate

    private void tbo_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbo_tableMouseClicked
        int row = tbo_table.getSelectedRow();
        txt_ma.setText(tbo_table.getValueAt(row, 1).toString());
        txt_ten.setText(tbo_table.getValueAt(row, 2).toString());
        if (tbo_table.getValueAt(row, 5).toString().equals("Đang kinh doanh")) {
            rdo_dangKinhDoanh.setSelected(true);
        }else{
            rdo_ngungKinhDong.setSelected(true);
        }
        
    }//GEN-LAST:event_tbo_tableMouseClicked

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
            java.util.logging.Logger.getLogger(FrmChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChatLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_sua;
    private swing.Button btn_them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_date;
    private swing.RadioButtonCustom rdo_dangKinhDoanh;
    private swing.RadioButtonCustom rdo_ngungKinhDong;
    private javax.swing.JTable tbo_table;
    private swing.TextField txt_TimKiem;
    private swing.TextField txt_ma;
    private swing.TextField txt_ten;
    // End of variables declaration//GEN-END:variables
}