package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.MauSac;
import models.Size;
import services.IMauSacService;
import services.ISizeService;
import services.impl.MauSacService;
import services.impl.SizeService;
import swing.Table;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmMauSac1 extends javax.swing.JPanel {

    private IMauSacService iMauSacService;
    private DefaultTableModel dtm;
    private Helper helper;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form FrmSizeOK
     */
    public FrmMauSac1() {
        initComponents();
        iMauSacService = new MauSacService();
        helper = new Helper();
        loadToTable(iMauSacService.getAll());
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }

    public boolean check() {

        if (helper.checkNull(txt_Ten, "Kích cỡ")) {
            return true;
        } else {
            try {
                float f = Float.parseFloat(txt_Ten.getText().trim());
            } catch (NumberFormatException e) {
                helper.error(this, "Kích cỡ không chứa chữ !");
                return true;
            }
            return false;
        }
    }

    public void clear() {
        txt_Ma.setText("");
        txt_Ten.setText("");
        rd_DangKinhDoanh.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txt_Ma = new swing.TextField();
        rd_DangKinhDoanh = new swing.RadioButtonCustom();
        rd_NgungKinhDoanh = new swing.RadioButtonCustom();
        btn_update = new swing.Button();
        btn_add = new swing.Button();
        txt_search = new swing.TextField();
        txt_Ten = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        lbl_Total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        buttonGroup1.add(rd_DangKinhDoanh);
        rd_DangKinhDoanh.setSelected(true);
        rd_DangKinhDoanh.setText("Đang kinh doanh");

        buttonGroup1.add(rd_NgungKinhDoanh);
        rd_NgungKinhDoanh.setText("Ngừng kinh doanh");

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_search.setLabelText("Search");
        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });

        txt_Ten.setToolTipText("");
        txt_Ten.setLabelText("Tên :");
        txt_Ten.setName(""); // NOI18N

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày sửa cuối", "Trạng thái"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setText("Total: 0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MÀU SẮC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
         int row = tblBang.getSelectedRow();
        MauSac m = iMauSacService.getObj(tblBang.getValueAt(row, 0).toString());
        if (checkNull()) {
            return;
        }

        
        m.setNgaySuaCuoi(new Date());
        if (rd_DangKinhDoanh.isSelected()) {
            m.setTrangThai(0);
        } else {
            m.setTrangThai(1);
        }
        iMauSacService.save(m);
        loadToTable(iMauSacService.getAll());
        helper.alert(this, "Sửa thành công!");;
        clear();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
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
            m.setMa(txt_Ma.getText());
            m.setTen(txt_Ten.getText());
            m.setNgayThem(new Date());
            m.setNgaySuaCuoi(new Date());
            if (rd_DangKinhDoanh.isSelected()) {
                m.setTrangThai(0);
            } else {
                m.setTrangThai(1);
            }
            iMauSacService.save(m);
            loadToTable(iMauSacService.getAll());
            helper.alert(this, "Thêm thành công!");

        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        // TODO add your handling code here:
        clear();
         loadToTable(iMauSacService.findByName(txt_search.getText()));
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        int row = tblBang.getSelectedRow();
        MauSac m = iMauSacService.getObj((String) tblBang.getValueAt(row, 0));
        txt_Ma.setText(m.getMa());
        txt_Ten.setText(m.getTen());
        rd_DangKinhDoanh.setSelected(m.getTrangThai() == 0);
        rd_NgungKinhDoanh.setSelected(m.getTrangThai() == 1);
    }//GEN-LAST:event_tblBangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.RadioButtonCustom rd_DangKinhDoanh;
    private swing.RadioButtonCustom rd_NgungKinhDoanh;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblBang;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Ten;
    private swing.TextField txt_search;
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
        } else if (!rd_NgungKinhDoanh.isSelected() && !rd_DangKinhDoanh.isSelected()) {
            helper.error(this, "chưa chọn trạng thái");
            return true;
        }
        return false;

    }
}
