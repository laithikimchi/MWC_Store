package views;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import models.KhuyenMai;
import services.IKhuyenMaiService;
import services.impl.KhuyenMaiService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmKhuyenMai extends java.awt.Dialog {

    /**
     * Creates new form FrmKM
     */
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private IKhuyenMaiService iKhuyenMaiService = new KhuyenMaiService();
    private Helper helper = new Helper();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private KhuyenMai khuyenMai;
    private Page pg = new Page();
    Integer limit = 5;
    Integer totalData = 0;

    public FrmKhuyenMai(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData(iKhuyenMaiService.getAll());
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        date_NgayBatDau.setDate(new Date());
        date_NgayKetThuc.setDate(new Date());
        setTitle("Danh sách khuyến mãi");
        pagination(txt_Search.getText());
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
    }

    public void pagination(String ten) {
        totalData = iKhuyenMaiService.findByName(ten).size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        if (pg.getTotalPage() < pg.getCurrent()) {
            pagination1.setPagegination(pg.getTotalPage(), pg.getTotalPage());
            loadData(iKhuyenMaiService.pagination(pg.getTotalPage(), limit, ten));
        } else {
            pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            loadData(iKhuyenMaiService.pagination(pg.getCurrent(), limit, ten));
        }
        clearForm();
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                loadData(iKhuyenMaiService.pagination(page, limit, ten));
                pg.setCurrent(page);
            }
        });
    }

    private void loadData(List<KhuyenMai> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_danhSach.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuyenMai km : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,
                km.getMa(),
                km.getTen(),
                km.getPhantramgiam() + "%",
                km.getSoLuong(),
                helper.formatDate(km.getNgayBatDau()),
                helper.formatDate(km.getNgayKetThuc())
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_Ma = new swing.TextField();
        txt_TenKM = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txt_Search = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_danhSach = new javax.swing.JTable();
        txt_PhanTramGiam = new swing.TextField();
        date_NgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_NgayKetThuc = new com.toedter.calendar.JDateChooser();
        btn_Them = new swing.Button();
        btn_CapNhat = new swing.Button();
        btn_ChonKhuyenMai = new swing.Button();
        btn_Xoa = new swing.Button();
        sp_SoLuong = new swing.Spinner();
        jPanel2 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();
        lbl_QR = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        txt_TenKM.setToolTipText("");
        txt_TenKM.setLabelText("Tên khuyến mãi :");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KHUYẾN MÃI");

        txt_Search.setToolTipText("");
        txt_Search.setLabelText("Search");
        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });

        tb_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "% Giảm", "Số lượng", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        tb_danhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_danhSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_danhSach);
        if (tb_danhSach.getColumnModel().getColumnCount() > 0) {
            tb_danhSach.getColumnModel().getColumn(3).setMinWidth(65);
            tb_danhSach.getColumnModel().getColumn(3).setMaxWidth(65);
            tb_danhSach.getColumnModel().getColumn(4).setMinWidth(70);
            tb_danhSach.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        txt_PhanTramGiam.setToolTipText("");
        txt_PhanTramGiam.setLabelText(" Phần trăm giảm :");

        date_NgayBatDau.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ngày bắt đầu :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Ngày kết thúc :");

        date_NgayKetThuc.setDateFormatString("dd-MM-yyyy");

        btn_Them.setBackground(new java.awt.Color(102, 102, 102));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_CapNhat.setBackground(new java.awt.Color(102, 102, 102));
        btn_CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.setToolTipText("");
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        btn_ChonKhuyenMai.setBackground(new java.awt.Color(0, 137, 187));
        btn_ChonKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChonKhuyenMai.setActionCommand("Chọn khuyến mãi");
        btn_ChonKhuyenMai.setLabel("Chọn khuyến mãi");
        btn_ChonKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonKhuyenMaiActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 51, 255));

        pagination1.setBackground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_TenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_QR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_ChonKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(date_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sp_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_PhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_CapNhat, btn_Them, btn_Xoa});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_PhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(date_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ChonKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_QR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    private KhuyenMai getForm() {
        String ma = txt_Ma.getText().trim();
        ma = ma.replaceAll(" ", "");
        String result = "MWCSTORES" + ma.toUpperCase();
        KhuyenMai km = new KhuyenMai();
        km.setMa(ma.toUpperCase());
        km.setTen(txt_TenKM.getText());
        km.setSoLuong((int) sp_SoLuong.getValue());
        km.setPhantramgiam(Float.parseFloat(txt_PhanTramGiam.getText()));
        km.setNgayBatDau(date_NgayBatDau.getDate());
        km.setNgayKetThuc(date_NgayKetThuc.getDate());
        km.setHinhAnh(ma.toUpperCase() + ".png");
        try {
            String filePath = "images/voucher/" + ma.toUpperCase() + ".png";
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(result.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 500, 500, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
            System.out.println("Qr code has been generated at the location " + filePath);

        } catch (Exception e) {
            System.out.println(e);
        }
        return km;
    }

    public void clearForm() {
        tb_danhSach.setRowSelectionAllowed(false);
        txt_Ma.setText("");
        txt_TenKM.setText("");
        txt_PhanTramGiam.setText("");
        sp_SoLuong.setValue(0);
        lbl_QR.setIcon(null);

    }

    private boolean check() {
        if (helper.checkNull(txt_Ma, "Mã") || helper.checkNull(txt_TenKM, "Tên khuyến mãi") || helper.checkNull(txt_PhanTramGiam, "Phần trăm giảm")) {
            return false;
        }
        if (helper.checkRegex(txt_Ma, "[a-zA-Z0-9]*", "Mã không được chứa ký hiệu đặc biệt")) {
            return false;
        }
        try {
            float f = Float.parseFloat(txt_PhanTramGiam.getText().trim());
        } catch (NumberFormatException e) {
            helper.error(this, "Phần trăm giảm không chứa chữ !");
            return false;
        }
        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            String batDau = sdf.format(date_NgayBatDau.getDate());
            String ketThuc = sdf.format(date_NgayKetThuc.getDate());
            String hienTai = sdf.format(currentDate);
            date1 = sdf.parse(batDau);
            date2 = sdf.parse(ketThuc);
            date3 = sdf.parse(hienTai);
            long getDiff = date2.getTime() - date1.getTime();
            long getHienTai = date1.getTime() - date3.getTime();
            if (getHienTai < 0) {
                helper.error(this, "Ngày bắt đầu phải >= ngày hiện tại");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        String ma = txt_Ma.getText().trim();
        ma = ma.replaceAll(" ", "");
        if (check()) {
            if (iKhuyenMaiService.getObj(ma) == null) {
                iKhuyenMaiService.save(getForm());
                pagination(txt_Search.getText());
                helper.alert(this, "Thêm thành công!");
            } else {
                helper.error(this, "Đã có mã này rồi không thể thêm !!");
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            if (check()) {
                KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 1).toString());
                km.setMa(txt_Ma.getText().toUpperCase());
                km.setPhantramgiam(Float.parseFloat(txt_PhanTramGiam.getText()));
                km.setSoLuong((int) sp_SoLuong.getValue());
                km.setNgayBatDau(date_NgayBatDau.getDate());
                km.setNgayKetThuc(date_NgayKetThuc.getDate());
                iKhuyenMaiService.save(km);
                pagination(txt_Search.getText());
                helper.alert(this, "Cập nhật thành công");
            }
        }
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_ChonKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonKhuyenMaiActionPerformed
        int row = tb_danhSach.getSelectedRow();
        KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 1).toString());
        if (row == -1) {
            helper.error(this, "Vui lòng chọn khuyến mãi!");
            return;
        }
        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;
        try {
            String ketThuc = sdf.format(km.getNgayKetThuc());
            String hienTai = sdf.format(currentDate);
            date1 = sdf.parse(ketThuc);
            date2 = sdf.parse(hienTai);
            long getDiff = date1.getTime() - date2.getTime();
            if (getDiff < 0) {
                helper.error(this, "Khuyến mại đã hết hạn");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (km.getSoLuong() == 0) {
            helper.error(this, "Đã hết mã khuyến mãi!");
        } else {
            String tenKM = (String) tb_danhSach.getValueAt(row, 1);
            khuyenMai = km;
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công khuyến mãi " + tenKM);
            panel.showNotification();
            this.dispose();
        }
    }//GEN-LAST:event_btn_ChonKhuyenMaiActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            String result = txt_Ma.getText().replace("MWCSTORES", "").trim();
            String fileName = "images/voucher/" + result + ".png";
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println("File anh QR da xoa");
            } else {
                System.out.println("Xin loi, khong co File anh QR de xoa.");
            }
            KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 1).toString());
            iKhuyenMaiService.delete(km);
            pagination(txt_Search.getText());
            helper.alert(this, "Xóa thành công");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        // TODO add your handling code here:
        pagination(txt_Search.getText());
    }//GEN-LAST:event_txt_SearchCaretUpdate

    private void tb_danhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachMousePressed
        // TODO add your handling code here:
        tb_danhSach.setRowSelectionAllowed(true);
        int row = tb_danhSach.getSelectedRow();
        KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 1).toString());
        txt_Ma.setText(km.getMa());
        txt_TenKM.setText(km.getTen());
        txt_PhanTramGiam.setText(String.valueOf(km.getPhantramgiam()));
        sp_SoLuong.setValue(km.getSoLuong());
        date_NgayBatDau.setDate(km.getNgayBatDau());
        date_NgayKetThuc.setDate(km.getNgayKetThuc());
        ImageIcon i = utilities.ImageUltil.resizeIcon(new ImageIcon("images/voucher/" + km.getHinhAnh()), lbl_QR.getWidth(), lbl_QR.getHeight());
        lbl_QR.setIcon(i);
    }//GEN-LAST:event_tb_danhSachMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKhuyenMai dialog = new FrmKhuyenMai(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_CapNhat;
    private swing.Button btn_ChonKhuyenMai;
    private swing.Button btn_Them;
    private swing.Button btn_Xoa;
    private com.toedter.calendar.JDateChooser date_NgayBatDau;
    private com.toedter.calendar.JDateChooser date_NgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_QR;
    private swing.Pagination pagination1;
    private swing.Spinner sp_SoLuong;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_danhSach;
    private swing.TextField txt_Ma;
    private swing.TextField txt_PhanTramGiam;
    private swing.TextField txt_Search;
    private swing.TextField txt_TenKM;
    // End of variables declaration//GEN-END:variables
    public KhuyenMai getKM() {
        if (khuyenMai == null) {
            return null;
        } else if (khuyenMai.getSoLuong() > 0) {
            return khuyenMai;
        } else {
            return null;
        }
    }
}
