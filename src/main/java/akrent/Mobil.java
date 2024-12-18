/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package akrent;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.ZoneId;
/**
 *
 * @author BuahPir
 */
public class Mobil extends javax.swing.JFrame {

    /**
     * Creates new form Mobil
     */
    private DefaultTableModel model;
    public Mobil() {
        initComponents();
        scaleImage();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        
        model = new DefaultTableModel();
        
        TabelMobil.setModel(model);
        model.addColumn("ID Mobil");
        model.addColumn("Jenis Mobil");
        model.addColumn("No. Polisi");
        model.addColumn("Tahun");
        model.addColumn("Warna");
        model.addColumn("Harga");
        
        loadData();
    }
    
    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);

        try {
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM mobil;";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getInt("id_mobil");
                o[1] = r.getString("jenis_mobil");
                o[2] = r.getString("no_polisi");
                o[3] = r.getInt("tahun");
                o[4] = r.getString("warna");
                o[5] = r.getInt("harga");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
    private void scaleImage(){
        ImageIcon icon = new ImageIcon((getClass().getResource("/car.png")));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel1.setIcon(scaledIcon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        inputMobil = new javax.swing.JTextField();
        inputPolisi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputWarna = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SubmitMobil = new javax.swing.JButton();
        inputHarga = new javax.swing.JTextField();
        inputTahun = new javax.swing.JTextField();
        editMobil = new javax.swing.JButton();
        deleteMobil = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        TabelMobil = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Beranda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("car");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_car.png"))); // NOI18N
        jLabel2.setText("  Jenis Mobil");

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Jenis Mobil");

        inputMobil.setForeground(new java.awt.Color(102, 102, 102));
        inputMobil.setText("Masukkan Jenis Mobil");
        inputMobil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputMobilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputMobilFocusLost(evt);
            }
        });

        inputPolisi.setForeground(new java.awt.Color(102, 102, 102));
        inputPolisi.setText("Masukkan No Polisi");
        inputPolisi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPolisiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPolisiFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("No Polisi");

        jLabel5.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tahun");

        inputWarna.setForeground(new java.awt.Color(102, 102, 102));
        inputWarna.setText("Masukkan Warna Mobil");
        inputWarna.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputWarnaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputWarnaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Warna");

        jLabel7.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Harga");

        SubmitMobil.setText("Submit");
        SubmitMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitMobilMouseClicked(evt);
            }
        });
        SubmitMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitMobilActionPerformed(evt);
            }
        });

        inputHarga.setForeground(new java.awt.Color(102, 102, 102));
        inputHarga.setText("Masukkan Harga Rental");
        inputHarga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputHargaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputHargaFocusLost(evt);
            }
        });

        inputTahun.setForeground(new java.awt.Color(102, 102, 102));
        inputTahun.setText("Masukkan Tahun Mobil");
        inputTahun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTahunFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTahunFocusLost(evt);
            }
        });

        editMobil.setText("Edit");
        editMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMobilMouseClicked(evt);
            }
        });
        editMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMobilActionPerformed(evt);
            }
        });

        deleteMobil.setText("Delete");
        deleteMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMobilActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputMobil)
                            .addComponent(inputPolisi)
                            .addComponent(inputTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(SubmitMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputWarna, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(inputHarga))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(540, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitMobil)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMobil))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteMobil))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        TabelMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMobilMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(TabelMobil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 1266, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inputMobilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputMobilFocusGained
        // TODO add your handling code here:
        if (inputMobil.getText().equals("Masukkan Jenis Mobil")) {
            inputMobil.setText("");
            inputMobil.setForeground(new Color (0,0,0));
        }
    }//GEN-LAST:event_inputMobilFocusGained

    private void inputMobilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputMobilFocusLost
        // TODO add your handling code here:
        if (inputMobil.getText().equals("")) {
            inputMobil.setText("Masukkan Jenis Mobil");
            inputMobil.setForeground(new Color (102,102,102));
        }
    }//GEN-LAST:event_inputMobilFocusLost

    private void inputPolisiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPolisiFocusGained
        // TODO add your handling code here:
        if (inputPolisi.getText().equals("Masukkan No Polisi")) {
            inputPolisi.setText("");
            inputPolisi.setForeground(new Color (0,0,0));
        }
    }//GEN-LAST:event_inputPolisiFocusGained

    private void inputPolisiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPolisiFocusLost
        // TODO add your handling code here:
        if (inputPolisi.getText().equals("")) {
            inputPolisi.setText("Masukkan No Polisi");
            inputPolisi.setForeground(new Color (102,102,102));
        }
    }//GEN-LAST:event_inputPolisiFocusLost

    private void inputWarnaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputWarnaFocusGained
        // TODO add your handling code here:
        if (inputWarna.getText().equals("Masukkan Warna Mobil")) {
            inputWarna.setText("");
            inputWarna.setForeground(new Color (0,0,0));
        }
    }//GEN-LAST:event_inputWarnaFocusGained

    private void inputWarnaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputWarnaFocusLost
        // TODO add your handling code here:
        if (inputWarna.getText().equals("")) {
            inputWarna.setText("Masukkan Warna Mobil");
            inputWarna.setForeground(new Color (102,102,102));
        }
    }//GEN-LAST:event_inputWarnaFocusLost

    private void SubmitMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitMobilActionPerformed
        // TODO add your handling code here:
        if (inputMobil.getText().equals("Masukkan Jenis Mobil") || inputPolisi.getText().equals("Masukkan No Polisi") || inputTahun.getText().equals("Masukkan Tahun Mobil") || inputWarna.getText().equals("Masukkan Warna Mobil") || inputHarga.getText().equals("Masukkan Harga Rental")){
            jLabel8.setForeground(Color.red);
            jLabel8.setText("Error, Pastikan anda memasukkan Semua data");
            
            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            return;
        }
        String mobil = inputMobil.getText();
        String polisi = inputPolisi.getText();
        String date = inputTahun.getText(); // Assuming inputTahun returns a String

        int year = 0; // Default value for the year
        if (date != null && !date.trim().isEmpty()) {
            try {
                year = Integer.parseInt(date);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format: " + date);
                return; // Stop execution if the year format is invalid
            }
        } else {
            System.out.println("Year input is null or empty!");
            return; // Stop execution if the year is null
        }

        String warna = inputWarna.getText();
        String harga = inputHarga.getText();

        try {
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "INSERT INTO mobil (jenis_mobil, no_polisi, tahun, warna, harga) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, mobil);
            p.setString(2, polisi);
            p.setInt(3, year); // Insert year into the database
            p.setString(4, warna);
            p.setString(5, harga);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
        } finally {
            loadData(); // Reload data after insertion
            jLabel8.setForeground(Color.green);
            jLabel8.setText("Succes, Telah memasukkan data");
            
            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            inputMobil.setText("Masukkan Jenis Mobil");
            inputMobil.setForeground(new Color (102,102,102));
            inputPolisi.setText("Masukkan No Polisi");
            inputPolisi.setForeground(new Color (102,102,102));
            inputTahun.setText("Masukkan Tahun Mobil");
            inputTahun.setForeground(new Color(102,102,102));
            inputWarna.setText("Masukkan Warna Mobil");
            inputWarna.setForeground(new Color (102,102,102));
            inputHarga.setText("Masukkan Harga Rental");
            inputHarga.setForeground(new Color(102,102,102));
        }

    }//GEN-LAST:event_SubmitMobilActionPerformed

    private void inputHargaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputHargaFocusGained
        // TODO add your handling code here:
        if (inputHarga.getText().equals("Masukkan Harga Rental")) {
            inputHarga.setText("");
            inputHarga.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputHargaFocusGained

    private void inputHargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputHargaFocusLost
        // TODO add your handling code here:
        if (inputHarga.getText().equals("")) {
            inputHarga.setText("Masukkan Harga Rental");
            inputHarga.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputHargaFocusLost

    private void inputTahunFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTahunFocusGained
        // TODO add your handling code here:
        if (inputTahun.getText().equals("Masukkan Tahun Mobil")) {
            inputTahun.setText("");
            inputTahun.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputTahunFocusGained

    private void inputTahunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTahunFocusLost
        // TODO add your handling code here:
        if (inputTahun.getText().equals("")) {
            inputTahun.setText("Masukkan Tahun Mobil");
            inputTahun.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputTahunFocusLost

    private void TabelMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMobilMouseClicked
        // TODO add your handling code here:
        int i = TabelMobil.getSelectedRow();
        if (i == -1) {
            // tak ada baris terseleksi
            return;
        }

        String mobil = model.getValueAt(i, 1).toString();
        inputMobil.setForeground(new Color(0,0,0));
        inputMobil.setText(mobil);

        String polisi = model.getValueAt(i, 2).toString();
        inputPolisi.setForeground(new Color(0,0,0));
        inputPolisi.setText(polisi);

        String tahun = model.getValueAt(i, 3).toString();
        inputTahun.setForeground(new Color(0,0,0));
        inputTahun.setText(tahun);

        String warna = model.getValueAt(i, 4).toString();
        inputWarna.setForeground(new Color(0,0,0));
        inputWarna.setText(warna);

        String harga = model.getValueAt(i, 5).toString();
        inputHarga.setForeground(new Color(0,0,0));
        inputHarga.setText(harga);

    }//GEN-LAST:event_TabelMobilMouseClicked

    private void editMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMobilActionPerformed
        // TODO add your handling code here:
        int i = TabelMobil.getSelectedRow();
        if (i == -1) {
            jLabel8.setForeground(Color.red);
            jLabel8.setText("Error, Pastikan anda memasukkan Semua data atau memilih data");

            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            return;
        }
        String id = model.getValueAt(i, 0).toString();
        String  mobil = inputMobil.getText();
        String no_polisi = inputPolisi.getText();
        String tahun = inputTahun.getText();
        String warna = inputWarna.getText();
        String harga = inputHarga.getText();
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "UPDATE mobil SET jenis_mobil = ?, no_polisi = ?, tahun = ?, warna = ?, harga = ? WHERE id_mobil = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, mobil);
            p.setString(2, no_polisi);
            p.setString(3, tahun);
            p.setString(4, warna);
            p.setString(5, harga);
            p.setString(6, id);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.out.println("Terjadi error");
        } finally {
            loadData();
            jLabel8.setForeground(Color.green);
            jLabel8.setText("Succes, Telah edit data");
            
            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            inputMobil.setText("Masukkan Jenis Mobil");
            inputMobil.setForeground(new Color (102,102,102));
            inputPolisi.setText("Masukkan No Polisi");
            inputPolisi.setForeground(new Color (102,102,102));
            inputTahun.setText("Masukkan Tahun Mobil");
            inputTahun.setForeground(new Color(102,102,102));
            inputWarna.setText("Masukkan Warna Mobil");
            inputWarna.setForeground(new Color (102,102,102));
            inputHarga.setText("Masukkan Harga Rental");
            inputHarga.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_editMobilActionPerformed

    private void deleteMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMobilActionPerformed
        // TODO add your handling code here:
        int i = TabelMobil.getSelectedRow();
        if (i == -1) {
            jLabel8.setForeground(Color.red);
            jLabel8.setText("Error, Pastikan anda memilih data");

            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            return;
        }
        String id = model.getValueAt(i, 0).toString();
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "DELETE FROM mobil WHERE id_mobil = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.err.println("Terjadi Error");
        } finally {
            loadData();
            jLabel8.setForeground(Color.green);
            jLabel8.setText("Succes, Telah menghapus data");
            
            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel8.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            inputMobil.setText("Masukkan Jenis Mobil");
            inputMobil.setForeground(new Color (102,102,102));
            inputPolisi.setText("Masukkan No Polisi");
            inputPolisi.setForeground(new Color (102,102,102));
            inputTahun.setText("Masukkan Tahun Mobil");
            inputTahun.setForeground(new Color(102,102,102));
            inputWarna.setText("Masukkan Warna Mobil");
            inputWarna.setForeground(new Color (102,102,102));
            inputHarga.setText("Masukkan Harga Rental");
            inputHarga.setForeground(new Color(102,102,102));
        }
         
    }//GEN-LAST:event_deleteMobilActionPerformed

    private void SubmitMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMobilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitMobilMouseClicked

    private void editMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMobilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editMobilMouseClicked

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
            java.util.logging.Logger.getLogger(Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitMobil;
    private javax.swing.JTable TabelMobil;
    private javax.swing.JButton deleteMobil;
    private javax.swing.JButton editMobil;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputMobil;
    private javax.swing.JTextField inputPolisi;
    private javax.swing.JTextField inputTahun;
    private javax.swing.JTextField inputWarna;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
