/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mahasiswa;

import Koneksi.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Apps extends javax.swing.JFrame {

    private Connection conn;
    
    public Apps() {
        initComponents();
        conn = koneksi.getConnection();
        
        getData();
    }
    
//    private void getData() {
//        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
//        model.setRowCount(0);
//        
//        try {
//            String sql = "SELECT * FROM datamahas";
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            
//            while (rs.next()) {
//                String nama = rs.getString("nama_siswa");
//                int nim = rs.getInt("nim");
//                String jenis_kelamin = rs.getString("jenis_kelamin");
//                String kelas = rs.getString("kelas");
//                String jurusan = rs.getString("jurusan");
//                String tempat_lahir = rs.getString("tempat_lahir");
//                String jCalendar = rs.getString("tanggal_lahir");
//                
//                Object[] rowData = {nama, nim, jenis_kelamin, kelas, jurusan, tempat_lahir, jCalendar};
//                model.addRow(rowData);
//            }
//            JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil");
//            rs.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal");
//            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
    
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
    model.setRowCount(0);
    
    try {
        String sql = "SELECT * FROM datamahas";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            String nama = rs.getString("nama_siswa");
            int nim = rs.getInt("nim");
            String jenis_kelamin = rs.getString("jenis_kelamin");
            String kelas = rs.getString("kelas");
            String jurusan = rs.getString("jurusan");
            String tempat_lahir = rs.getString("tempat_lahir");

            // Mengambil tanggal dari database sebagai java.sql.Date
            Date tanggalLahir = rs.getDate("tanggal_lahir");

            // Mengubah tanggal menjadi String untuk ditampilkan di tabel (opsional)
            String tglLahirStr = new SimpleDateFormat("yyyy-MM-dd").format(tanggalLahir);

            // Menambahkan data ke dalam tabel
            Object[] rowData = {nama, nim, jenis_kelamin, kelas, jurusan, tempat_lahir, tglLahirStr};
            model.addRow(rowData);
        }

        JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil");
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Koneksi Database Gagal");
        Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
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

        jk = new javax.swing.ButtonGroup();
        kelas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        reguler = new javax.swing.JRadioButton();
        nonreguler = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jurusanBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfTempatLahir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jCalendar = new de.wannawork.jcalendar.JCalendarComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Data Mahasiswa");

        jLabel2.setText("Nama");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nim");

        jLabel4.setText("Jenis Kelamin");

        jk.add(laki);
        laki.setText("Laki - Laki");

        jk.add(perempuan);
        perempuan.setText("Perempuan");

        jLabel5.setText("Kelas");

        kelas.add(reguler);
        reguler.setText("Reguler");

        kelas.add(nonreguler);
        nonreguler.setText("Non - Reguler");

        jLabel6.setText("Jurusan");

        jurusanBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Sistem Informasi", "Bisnis Digital" }));
        jurusanBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jurusanBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Tempat Lahir");

        jLabel8.setText("Tanggal Lahir");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Nim", "Jenis Kelamin", "Kelas", "Jurusan", "Tempat Lahir", "Tanggal Lahir"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(81, 81, 81)
                                .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jurusanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNim)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(reguler)
                                            .addComponent(laki))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(perempuan)
                                            .addComponent(nonreguler))))))
                        .addGap(64, 64, 64)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(979, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(laki)
                    .addComponent(perempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nonreguler)
                    .addComponent(reguler, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jurusanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnCari)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jurusanBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jurusanBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jurusanBoxActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

        try {
        // Query untuk menghapus data di tabel datamahas berdasarkan nim
        String sql = "DELETE FROM datamahas WHERE nim = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        
        // Mengambil NIM dari input form
        int nim = Integer.parseInt(tfNim.getText());
        
        // Mengisi parameter SQL dengan nim
        st.setInt(1, nim);
        
        // Eksekusi query
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dihapus: " + e.getMessage());
        Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
    }
        
//        try {
//            String sql = "DELETE FORM datamahas where nim='" + tfNim.getText() + "'";
//            conn = (Connection) koneksi.getConnection();
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.execute();
//
//            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Gagal Mengubah Data");
//        }     
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
//       String jk = null;
//       String kelas = null;
//        
//        if(laki.isSelected()) {
//            jk = "Laki - Laki";
//        } else if(perempuan.isSelected()) {
//            jk = "Perempuan";
//        }
//        
//        if(reguler.isSelected()) {
//            kelas = "Reguler";
//        } else if(nonreguler.isSelected()) {
//            kelas = "Non Reguler";
//        }        
//        
////        try {
////            String sql = "INSERT INTO datamahas VALUES ('" +tfNama.getText()+ "','" +tfNim.getText()+ "','" +jk+ "','" +kelas+ "','" +jurusanBox.getSelectedItem()+ "','" +tfTempatLahir.getText()+ "','" + jCalendar.getCalendar() + "')";
////            Connection con = (Connection) koneksi.getConnection();
////            PreparedStatement pst = con.prepareStatement(sql);
////            pst.execute();
////            
////            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan");
////        } catch (HeadlessException | SQLException e) {
////            JOptionPane.showMessageDialog(null, "Gagal Menyimpan");
////        }
//        try {
//            String sql = "INSERT INTO datamahas VALUES ('" +tfNama.getText()+ "','" +tfNim.getText()+ "','" +jk+ "','" +kelas+ "','" +jurusanBox.getSelectedItem()+ "','" +tfTempatLahir.getText()+ "','" + jCalendar.getCalendar() + "')";
//            java.sql.Connection conn=(Connection)koneksi.getConnection();
//            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }

try {
        String sql = "INSERT INTO datamahas (nama_siswa, nim, jenis_kelamin, kelas, jurusan, tempat_lahir, tanggal_lahir) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        
        // Mengambil data dari form input
        String namaSiswa = tfNama.getText();
        int nim = Integer.parseInt(tfNim.getText());
        String jenisKelamin = laki.isSelected() ? "Laki - Laki" : "Perempuan";
        String kelas = reguler.isSelected() ? "Reguler" : "Non - Reguler";
        String jurusan = jurusanBox.getSelectedItem().toString();
        String tempatLahir = tfTempatLahir.getText();

        // Mengambil tanggal dari JCalendar dan mengubahnya menjadi java.sql.Date
        java.util.Date utilDate = jCalendar.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        // Mengisi parameter SQL dengan data yang sudah diambil
        st.setString(1, namaSiswa);
        st.setInt(2, nim);
        st.setString(3, jenisKelamin);
        st.setString(4, kelas);
        st.setString(5, jurusan);
        st.setString(6, tempatLahir);
        st.setDate(7, sqlDate);  // Mengatur tanggal lahir
        
        // Eksekusi query
        st.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
        Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        int baris = tbl_data.rowAtPoint(evt.getPoint());
        
        String nama = tbl_data.getValueAt(baris, 0).toString(); tfNama.setText(nama);
        String nim = tbl_data.getValueAt(baris, 1).toString(); tfNim.setText(nim);
        String tempat_lahir = tbl_data.getValueAt(baris, 4).toString(); tfTempatLahir.setText(tempat_lahir);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

    try {
        // Query untuk memperbarui data di tabel datamahas berdasarkan nim
        String sql = "UPDATE datamahas SET nama_siswa = ?, jenis_kelamin = ?, kelas = ?, jurusan = ?, tempat_lahir = ?, tanggal_lahir = ? WHERE nim = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        
        // Mengambil data dari form input
        String namaSiswa = tfNama.getText();
        String jenisKelamin = laki.isSelected() ? "Laki - Laki" : "Perempuan";
        String kelas = reguler.isSelected() ? "Reguler" : "Non - Reguler";
        
        // Mengambil nilai yang dipilih dari JComboBox jurusan
        String jurusan = jurusanBox.getSelectedItem().toString();
        
        String tempatLahir = tfTempatLahir.getText();

        // Mengambil tanggal dari JCalendar dan mengubahnya menjadi java.sql.Date
        java.util.Date utilDate = jCalendar.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        // Mengisi parameter SQL dengan data yang sudah diambil
        st.setString(1, namaSiswa);
        st.setString(2, jenisKelamin);
        st.setString(3, kelas);
        st.setString(4, jurusan);  // Menggunakan nilai dari JComboBox
        st.setString(5, tempatLahir);
        st.setDate(6, sqlDate);  // Mengatur tanggal lahir
        
        // Nim sebagai parameter terakhir (penentu data yang ingin diubah)
        int nim = Integer.parseInt(tfNim.getText());
        st.setInt(7, nim);
        
        // Eksekusi query
        st.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal diupdate: " + e.getMessage());
        Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
    }


        
//       String jenis_kelamin = null;
//       String kelas = null;
//        
//        if(laki.isSelected()) {
//            jenis_kelamin = "Laki - Laki";
//        } else if(perempuan.isSelected()) {
//            jenis_kelamin = "Perempuan";
//        }
//        
//        if(reguler.isSelected()) {
//            kelas = "Reguler";
//        } else if(perempuan.isSelected()) {
//            kelas = "Non Reguler";
//        }        
//        
//        try {
//            String sql ="UPDATE datamahas SET nama = '"+tfNama.getText()+"', nim = '"+tfNim.getText()+"', jurusan = '"+jurusanBox.getSelectedItem()+"',alamat= '"+tfTempatLahir.getText()+"' WHERE nim = '"+tfNim.getText()+"'";
//            conn = (Connection) koneksi.getConnection();
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.execute();
//            
//            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Gagal Mengubah Data");
//        }
    }//GEN-LAST:event_btnEditActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apps().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jk;
    private javax.swing.JComboBox<String> jurusanBox;
    private javax.swing.ButtonGroup kelas;
    private javax.swing.JRadioButton laki;
    private javax.swing.JRadioButton nonreguler;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JRadioButton reguler;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNim;
    private javax.swing.JTextField tfTempatLahir;
    // End of variables declaration//GEN-END:variables

}

