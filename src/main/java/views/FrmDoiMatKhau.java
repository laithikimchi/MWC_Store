package views;

import models.NguoiDung;
import services.INguoiDungService;
import services.impl.NguoiDungService;
import utilities.Helper;

/**
 *
 * @author homna
 */
public class FrmDoiMatKhau extends javax.swing.JPanel {

    
    private INguoiDungService iNguoiDungService = new NguoiDungService();
    private NguoiDung nguoidung;
    private Helper helper = new Helper();
    private String fileName;
    
    public FrmDoiMatKhau(NguoiDung nd) {
        this.nguoidung = nd;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        lbl_err_renewpass = new javax.swing.JLabel();
        lbl_err_newpass = new javax.swing.JLabel();
        txt_oldPassword = new swing.PasswordField();
        lbl_err_oldpass = new javax.swing.JLabel();
        txt_newPassword = new swing.PasswordField();
        txt_reNewPassword = new swing.PasswordField();
        btn_changePass = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("ĐỔI MẬT KHẨU");

        lbl_err_renewpass.setFont(lbl_err_renewpass.getFont().deriveFont(lbl_err_renewpass.getFont().getSize()-1f));
        lbl_err_renewpass.setForeground(java.awt.Color.red);
        lbl_err_renewpass.setText(" ");

        lbl_err_newpass.setFont(lbl_err_newpass.getFont().deriveFont(lbl_err_newpass.getFont().getSize()-1f));
        lbl_err_newpass.setForeground(java.awt.Color.red);
        lbl_err_newpass.setText(" ");

        txt_oldPassword.setLabelText("Mật khẩu hiện tại");
        txt_oldPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setShowAndHide(true);
        txt_oldPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_oldPasswordCaretUpdate(evt);
            }
        });

        lbl_err_oldpass.setFont(lbl_err_oldpass.getFont().deriveFont(lbl_err_oldpass.getFont().getSize()-1f));
        lbl_err_oldpass.setForeground(java.awt.Color.red);
        lbl_err_oldpass.setText(" ");

        txt_newPassword.setLabelText("Mật khẩu mới");
        txt_newPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setShowAndHide(true);
        txt_newPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_newPasswordCaretUpdate(evt);
            }
        });

        txt_reNewPassword.setLabelText("Xác nhận mật khẩu mới");
        txt_reNewPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setShowAndHide(true);
        txt_reNewPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reNewPasswordCaretUpdate(evt);
            }
        });

        btn_changePass.setBackground(new java.awt.Color(102, 102, 102));
        btn_changePass.setForeground(new java.awt.Color(255, 255, 255));
        btn_changePass.setText("SUBMIT");
        btn_changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_err_oldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(lbl_err_newpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(txt_reNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(lbl_err_renewpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(txt_newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(btn_changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_err_oldpass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_err_newpass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_err_renewpass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_changePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_oldPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_oldPasswordCaretUpdate
        String oldPass = new String(txt_oldPassword.getPassword());
        if (!oldPass.equals(nguoidung.getMatKhau())) {
            lbl_err_oldpass.setText("Mật khẩu không chính xác!");
        } else {
            lbl_err_oldpass.setText(" ");
        }
    }//GEN-LAST:event_txt_oldPasswordCaretUpdate

    private void txt_newPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_newPasswordCaretUpdate
        if (txt_newPassword.getPassword().length < 8) {
            lbl_err_newpass.setText("Tối thiểu 8 kí tự!");
        } else {
            lbl_err_newpass.setText(" ");
        }
    }//GEN-LAST:event_txt_newPasswordCaretUpdate

    private void txt_reNewPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reNewPasswordCaretUpdate
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (!reNewPass.equals(newPass)) {
            lbl_err_renewpass.setText("Xác nhận mật khẩu không khớp!");
        } else {
            lbl_err_renewpass.setText(" ");
        }
    }//GEN-LAST:event_txt_reNewPasswordCaretUpdate

    private void btn_changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePassActionPerformed
        String oldPass = new String(txt_oldPassword.getPassword());
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (oldPass.equals(nguoidung.getMatKhau()) && newPass.length() >= 8 && newPass.equals(reNewPass)) {
            if (helper.confirm(this, "Xác nhận đổi mật khẩu ?")) {
                nguoidung.setMatKhau(reNewPass);
                iNguoiDungService.save(nguoidung);
                helper.alert(this, "Mật khẩu đã được thay đổi!");
                txt_oldPassword.setText("");
                txt_newPassword.setText("");
                txt_reNewPassword.setText("");
            }
        } else {
            helper.error(this, "Không thành công!");
        }
    }//GEN-LAST:event_btn_changePassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_changePass;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_err_newpass;
    private javax.swing.JLabel lbl_err_oldpass;
    private javax.swing.JLabel lbl_err_renewpass;
    private swing.PasswordField txt_newPassword;
    private swing.PasswordField txt_oldPassword;
    private swing.PasswordField txt_reNewPassword;
    // End of variables declaration//GEN-END:variables
}
