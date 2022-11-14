package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.MauSac;
import services.IChiTietDepService;
import services.IMauSacService;
import services.impl.ChiTietDepService;
import services.impl.MauSacService;
import utilities.Helper;

/**
 *
 * @author chiltk
 */
public class FrmMauSac extends javax.swing.JFrame {

    private IMauSacService iMauSacService;
    private DefaultTableModel dtm;
    private Helper helper;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public FrmMauSac() {
        initComponents();
        iMauSacService = new MauSacService();
        helper = new Helper();
        loadToTable(iMauSacService.getAll());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_Them = new swing.Button();
        txt_Timkiem = new swing.TextField();
        btn_Capnhat = new swing.Button();
        lbl_Total = new javax.swing.JLabel();
        txt_Ten = new swing.TextField();
        rd_ngungkd = new swing.RadioButtonCustom();
        rd_dangkd = new swing.RadioButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txt_Ma = new swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Màu sắc");

        btn_Them.setBackground(new java.awt.Color(153, 153, 153));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setLabel("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        txt_Timkiem.setLabelText("Tìm kiếm");
        txt_Timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TimkiemCaretUpdate(evt);
            }
        });

        btn_Capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_Capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Capnhat.setLabel("Cập nhật");
        btn_Capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapnhatActionPerformed(evt);
            }
        });

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setText("Total: 0");

        txt_Ten.setLabelText("Tên màu sắc");

        buttonGroup1.add(rd_ngungkd);
        rd_ngungkd.setText(" Ngừng kinh doanh");
        rd_ngungkd.setActionCommand("");

        buttonGroup1.add(rd_dangkd);
        rd_dangkd.setSelected(true);
        rd_dangkd.setText("Đang kinh doanh");

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày  sửa cuối", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txt_Timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 533, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        MauSac m = new MauSac();
        if (checkNull()) {
            return;
        }
        String result;
        for (int i = 1; i < iMauSacService.getAll().size() + 1; i++) {
            result = "MS0" + i;
            if (iMauSacService.getObj(result) == null) {
                m.setMa(result);
                break;
            } else {
                continue;
            }
        }
        if (iMauSacService.getObj(txt_Ma.getText()) == null) {
//            if (iMauSacService.getObj(txt_Ma.getText()) != null) {
//                JOptionPane.showMessageDialog(this, "Da ton tai !");
//                return;
//            }
            m.setMa(txt_Ma.getText());
            m.setTen(txt_Ten.getText());
            m.setNgayThem(new Date());
            m.setNgaySuaCuoi(new Date());
            if (rd_dangkd.isSelected()) {
                m.setTrangThai(0);
            } else {
                m.setTrangThai(1);
            }
            iMauSacService.save(m);
            loadToTable(iMauSacService.getAll());
            helper.alert(this, "Thêm thành công!");

        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void txt_TimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TimkiemCaretUpdate
        loadToTable(iMauSacService.findByName(txt_Timkiem.getText()));
    }//GEN-LAST:event_txt_TimkiemCaretUpdate

    private void btn_CapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapnhatActionPerformed
        int row = tblBang.getSelectedRow();
        MauSac m = iMauSacService.getObj(tblBang.getValueAt(row, 0).toString());
        if (checkNull()) {
            return;
        }

        m.setTen(txt_Ten.getText());
        m.setNgaySuaCuoi(new Date());
        if (rd_dangkd.isSelected()) {
            m.setTrangThai(0);
        } else {
            m.setTrangThai(1);
        }
        iMauSacService.save(m);
        loadToTable(iMauSacService.getAll());
        helper.alert(this, "Sửa thành công!");     
    }//GEN-LAST:event_btn_CapnhatActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        int row = tblBang.getSelectedRow();
        MauSac m = iMauSacService.getObj((String) tblBang.getValueAt(row, 0));
        txt_Ma.setText(m.getMa());
        txt_Ten.setText(m.getTen());
        rd_dangkd.setSelected(m.getTrangThai() == 0);
        rd_ngungkd.setSelected(m.getTrangThai() == 1);
    }//GEN-LAST:event_tblBangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMauSac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_Capnhat;
    private swing.Button btn_Them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.RadioButtonCustom rd_dangkd;
    private swing.RadioButtonCustom rd_ngungkd;
    private javax.swing.JTable tblBang;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Ten;
    private swing.TextField txt_Timkiem;
    // End of variables declaration//GEN-END:variables
     private void loadToTable(List<MauSac> list) {
        dtm = (DefaultTableModel) tblBang.getModel();
        dtm.setRowCount(0);
        for (MauSac x : list) {
            dtm.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                format.format(x.getNgayThem()),
                format.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
        lbl_Total.setText("Total: " + list.size());
    }

    private boolean checkNull() {
        if (helper.checkNull(txt_Ten, "Tên")
                || helper.checkRegex(txt_Ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        } else if (!rd_ngungkd.isSelected() && !rd_dangkd.isSelected()) {
            helper.error(this, "chưa chọn trạng thái");
            return true;
        }
        return false;

    }
}