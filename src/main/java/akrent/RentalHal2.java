/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package akrent;

import java.awt.Color;
import java.awt.Image;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.sql.PreparedStatement; 
import java.sql.Connection; 
/**
 *
 * @author BuahPir
 */
public class RentalHal2 extends javax.swing.JFrame {
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    /**
     * Creates new form RentalHal2
     */
    public RentalHal2() {
        initComponents();
        loadPenyewa();
        scaleImage();
        loadMobil();
        loadHarga();
        loadJaminan();
        getHarga.setEditable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
        
    private void scaleImage(){
        ImageIcon icon = new ImageIcon((getClass().getResource("/car.png")));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(icon_car.getWidth(), icon_car.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        icon_car.setIcon(scaledIcon);
    }
    
    public void loadHarga() {
        try {
            // Get database connection
            Connection c = KoneksiDatabase.getKoneksi();

            // Create SQL query with parameter
            String sql = "SELECT harga FROM mobil WHERE jenis_mobil = ?";

            // Use PreparedStatement
            PreparedStatement p = c.prepareStatement(sql);

            // Get the selected item from comboBoxMobil
            String jenis_mobil = comboBoxMobil.getSelectedItem().toString();
            p.setString(1, jenis_mobil); // Set the parameter value

            // Execute the query
            ResultSet r = p.executeQuery();

            // Check if a result exists
            if (r.next()) {
                // Get the 'harga' value
                String harga = r.getString("harga");
                
                getHarga.setText(harga);
                // Parse inputLama to integer
                int lama = Integer.parseInt(inputLama.getText());
                int hargaInt = Integer.parseInt(harga);
                
                // Handle "Dalam Kota"
                if (inputPaket.getSelectedItem().equals("Dalam Kota")) {
                    if (lama >= 10) {
                        int total = hargaInt * lama;
                        int discount = (int) (total * 0.8); // Apply 20% discount
                        getHarga.setText(String.valueOf(discount));
                    } else if (lama > 1) {
                        int total = hargaInt * lama;
                        getHarga.setText(String.valueOf(total));
                    } else {
                        getHarga.setText(harga);
                        
                    }
                }
                else if (inputPaket.getSelectedItem().equals("Luar Kota")) {
                    int total = hargaInt + 50000; // Add 50,000 for "Luar Kota"
                    if (lama >= 10) {
                        int totalHarga = total * lama;
                        int discountedHarga = (int) (totalHarga * 0.7); // Apply 30% discount
                        getHarga.setText(String.valueOf(discountedHarga));
                    } else if (lama > 1) {
                        int totalKT = total * lama;
                        getHarga.setText(String.valueOf(totalKT));
                    } else {
                        getHarga.setText(String.valueOf(total));
                        
                    }
                } else {
                    getHarga.setText(harga);
                }

            } else {
                // If no result, clear the text field
                getHarga.setText("");
            }

            // Close resources
            r.close();
            p.close();
        } catch (Exception e) {
            // Print error for debugging
            System.err.println("Error loading harga: " + e.getMessage());
        }
    }


    public void loadMobil() {
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT jenis_mobil FROM mobil;";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                String jenis_mobil = r.getString("jenis_mobil");
                comboBoxMobil.addItem(jenis_mobil);
            }
            r.close();
            s.close();
        }catch (Exception e) {
        }
    }
    public void loadJaminan() {
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT jenis_jaminan, unit FROM jaminan;";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                String jenis_jaminan = r.getString("jenis_jaminan");
                String unit = r.getString("unit");
                comboBoxJaminan.addItem(jenis_jaminan +" "+ unit );
            }
            r.close();
            s.close();
        }catch (Exception e) {
        }
    }
    public void loadPenyewa() {
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT nama FROM penyewa;";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                String nama = r.getString("nama");
                comboBoxNama.addItem(nama);
            }
            r.close();
            s.close();
        }catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        icon_car = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxNama = new javax.swing.JComboBox<>();
        comboBoxMobil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        getHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputTgl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputKembali = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputLama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboBoxJaminan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        inputPaket = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        inputAmbil = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jButton1.setText("Beranda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        icon_car.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_car.setText("car");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(icon_car, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(712, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(icon_car, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Masukkan Data Rental");

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel3.setText("Data Rental");

        jLabel4.setText("Penyewa");

        comboBoxNama.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxNamaItemStateChanged(evt);
            }
        });

        comboBoxMobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMobilItemStateChanged(evt);
            }
        });
        comboBoxMobil.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboBoxMobilPropertyChange(evt);
            }
        });

        jLabel5.setText("Mobil");

        getHarga.setText("jTextField1");
        getHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getHargaActionPerformed(evt);
            }
        });
        getHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                getHargaKeyTyped(evt);
            }
        });

        jLabel6.setText("Harga");

        inputTgl.setForeground(new java.awt.Color(102, 102, 102));
        inputTgl.setText("Masukkan Tanggal Kontrak");
        inputTgl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTglFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTglFocusLost(evt);
            }
        });
        inputTgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTglActionPerformed(evt);
            }
        });

        jLabel7.setText("Tanggal Kontrak");

        inputKembali.setForeground(new java.awt.Color(102, 102, 102));
        inputKembali.setText("Masukkan Jam Kembali");
        inputKembali.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputKembaliFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputKembaliFocusLost(evt);
            }
        });
        inputKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputKembaliActionPerformed(evt);
            }
        });

        jLabel8.setText("Jam Kembali");

        inputLama.setForeground(new java.awt.Color(102, 102, 102));
        inputLama.setText("Masukkan Lama Penyewaan");
        inputLama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputLamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputLamaFocusLost(evt);
            }
        });
        inputLama.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputLamaInputMethodTextChanged(evt);
            }
        });
        inputLama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLamaActionPerformed(evt);
            }
        });
        inputLama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputLamaKeyTyped(evt);
            }
        });

        jLabel9.setText("Lama Penyewaan");

        comboBoxJaminan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxJaminanItemStateChanged(evt);
            }
        });
        comboBoxJaminan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboBoxJaminanPropertyChange(evt);
            }
        });

        jLabel1.setText("Jaminan");

        inputPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dalam Kota", "Luar Kota" }));
        inputPaket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputPaketItemStateChanged(evt);
            }
        });
        inputPaket.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inputPaketPropertyChange(evt);
            }
        });

        jLabel10.setText("Paket");

        submitButton.setText("Next");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        inputAmbil.setForeground(new java.awt.Color(102, 102, 102));
        inputAmbil.setText("Masukkan Jam Ambil");
        inputAmbil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputAmbilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputAmbilFocusLost(evt);
            }
        });
        inputAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAmbilActionPerformed(evt);
            }
        });

        jLabel11.setText("Jam Ambil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxMobil, 0, 370, Short.MAX_VALUE)
                            .addComponent(comboBoxNama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getHarga)
                            .addComponent(inputTgl)
                            .addComponent(inputKembali)
                            .addComponent(inputLama)
                            .addComponent(comboBoxJaminan, javax.swing.GroupLayout.Alignment.TRAILING, 0, 370, Short.MAX_VALUE)
                            .addComponent(inputPaket, javax.swing.GroupLayout.Alignment.TRAILING, 0, 370, Short.MAX_VALUE)
                            .addComponent(inputAmbil))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxNama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxNamaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxNamaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxNamaItemStateChanged

    private void comboBoxMobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMobilItemStateChanged
        // TODO add your handling code here:
        loadHarga();
    }//GEN-LAST:event_comboBoxMobilItemStateChanged

    private void getHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getHargaActionPerformed

    private void comboBoxMobilPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboBoxMobilPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMobilPropertyChange

    private void inputTglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTglActionPerformed

    private void inputKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputKembaliActionPerformed

    private void inputLamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLamaActionPerformed

    private void comboBoxJaminanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxJaminanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxJaminanItemStateChanged

    private void comboBoxJaminanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboBoxJaminanPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxJaminanPropertyChange

    private void inputPaketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputPaketItemStateChanged
        // TODO add your handling code here:
        loadHarga();
    }//GEN-LAST:event_inputPaketItemStateChanged

    private void inputPaketPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inputPaketPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPaketPropertyChange

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        if (inputTgl.getText().equals("Masukkan Tanggal Kontrak") || inputAmbil.getText().equals("Masukkan Jam Ambil") || inputKembali.getText().equals("Masukkan Jam Kembali") || inputLama.getText().equals("Masukkan Lama Penyewaan")) {
            jLabel12.setForeground(Color.red);
            jLabel12.setText("Error, Pastikan anda memasukkan Semua data");
            
            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel12.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            return;
        } 
        String penyewa = comboBoxNama.getSelectedItem().toString();
        String mobil = comboBoxMobil.getSelectedItem().toString();
        String harga = getHarga.getText();
        String tgl_kontrak = inputTgl.getText();
        String jam_ambil = inputAmbil.getText();
        String jam_kembali = inputKembali.getText();
        String lama = inputLama.getText();
        String jaminan = comboBoxJaminan.getSelectedItem().toString();
        String paket = inputPaket.getSelectedItem().toString();
        try {
            int harga1 = Integer.parseInt(harga);
        // Convert the string to java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat(tgl_kontrak);
            Date today = Calendar.getInstance().getTime();
            String tgl = dateFormat.format(today);

            // Parse the string into a LocalTime object
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime ambilTime = LocalTime.parse(jam_ambil, formatter);

            // Convert LocalTime to java.sql.Time
            Time ambil = Time.valueOf(ambilTime);

            LocalTime kembaliTime = LocalTime.parse(jam_kembali, formatter);

            // Convert LocalTime to java.sql.Time
            Time kembali = Time.valueOf(kembaliTime);

        // Convert java.util.Date to java.sql.Date
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "INSERT INTO rental (penyewa, jenis_mobil, harga, tgl_kontrak, jam_ambil, jam_kembali, jenis_jaminan, jenis_paket, lama_sewa) VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, penyewa);   
            p.setString(2, mobil);
            p.setInt(3, harga1);
            p.setString(4, tgl); 
            p.setTime(5, ambil); 
            p.setTime(6, kembali); 
            p.setString(7, jaminan);
            p.setString(8, paket);
            p.setString(9, lama);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
        } finally {
            jLabel9.setForeground(Color.green);
            jLabel9.setText("Succes, Telah memasukkan data");

            javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
                jLabel9.setText(""); // Clear the error message
            });
            timer.setRepeats(false); // Ensure the timer runs only once
            timer.start();
            new Riwayat().setVisible(true);
            this.dispose();  
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void inputAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAmbilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAmbilActionPerformed

    private void inputTglFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTglFocusGained
        // TODO add your handling code here:
        if (inputTgl.getText().equals("Masukkan Tanggal Kontrak")) {
            inputTgl.setText("");
            inputTgl.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputTglFocusGained

    private void inputTglFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTglFocusLost
        // TODO add your handling code here:
        if (inputTgl.getText().equals("")) {
            inputTgl.setText("Masukkan Tanggal Kontrak");
            inputTgl.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputTglFocusLost

    private void inputAmbilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputAmbilFocusGained
        // TODO add your handling code here:
        if (inputAmbil.getText().equals("Masukkan Jam Ambil")) {
            inputAmbil.setText("");
            inputAmbil.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputAmbilFocusGained

    private void inputAmbilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputAmbilFocusLost
        // TODO add your handling code here:
        if (inputAmbil.getText().equals("")) {
            inputAmbil.setText("Masukkan Jam Ambil");
            inputAmbil.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputAmbilFocusLost

    private void inputKembaliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputKembaliFocusGained
        // TODO add your handling code here:
        if (inputKembali.getText().equals("Masukkan Jam Kembali")) {
            inputKembali.setText("");
            inputKembali.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputKembaliFocusGained

    private void inputKembaliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputKembaliFocusLost
        // TODO add your handling code here:
        if (inputKembali.getText().equals("")) {
            inputKembali.setText("Masukkan Jam Kembali");
            inputKembali.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputKembaliFocusLost

    private void inputLamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLamaFocusGained
        // TODO add your handling code here:
        loadHarga();
        if (inputLama.getText().equals("Masukkan Lama Penyewaan")) {
            inputLama.setText("");
            inputLama.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputLamaFocusGained

    private void inputLamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLamaFocusLost
        // TODO add your handling code here:
        if (inputLama.getText().equals("")) {
            inputLama.setText("Masukkan Lama Penyewaan");
            inputLama.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_inputLamaFocusLost

    private void getHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_getHargaKeyTyped
        // TODO add your handling code here:
        loadHarga();
    }//GEN-LAST:event_getHargaKeyTyped

    private void inputLamaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputLamaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLamaInputMethodTextChanged

    private void inputLamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputLamaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLamaKeyTyped

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
            java.util.logging.Logger.getLogger(RentalHal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalHal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalHal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalHal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentalHal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxJaminan;
    private javax.swing.JComboBox<String> comboBoxMobil;
    private javax.swing.JComboBox<String> comboBoxNama;
    private javax.swing.JTextField getHarga;
    private javax.swing.JLabel icon_car;
    private javax.swing.JTextField inputAmbil;
    private javax.swing.JTextField inputKembali;
    private javax.swing.JTextField inputLama;
    private javax.swing.JComboBox<String> inputPaket;
    private javax.swing.JTextField inputTgl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
