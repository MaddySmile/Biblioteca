/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;

/**
 *
 * @author MAÑANA - MLDF
 */
public class frameInicial extends javax.swing.JFrame {

    /**
     * Creates new form frameInicial
     */
    public frameInicial(controladorInicio ctrInicio) {
        initComponents();
        btAlumnos.addActionListener(ctrInicio);
        btLibros.addActionListener(ctrInicio);
        btSalir.addActionListener(ctrInicio);
        btInformes.addActionListener(ctrInicio);
        btPrestamos.addActionListener(ctrInicio);
       
     
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btAlumnos = new javax.swing.JButton();
        btLibros = new javax.swing.JButton();
        btPrestamos = new javax.swing.JButton();
        btInformes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(getIconImage());
        setResizable(false);

        btSalir.setText("Salir");

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btAlumnos.setFont(new java.awt.Font("Bodoni MT Black", 0, 14)); // NOI18N
        btAlumnos.setText("Alumnos");

        btLibros.setFont(new java.awt.Font("Bodoni MT Black", 0, 14)); // NOI18N
        btLibros.setText("Libros");

        btPrestamos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPrestamos.setText("Prestamos");

        btInformes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btInformes.setText("Informes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAlumnos)
                    .addComponent(btPrestamos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInformes))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlumnos)
                    .addComponent(btLibros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPrestamos)
                    .addComponent(btInformes))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btSalir)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    /**
     * @param args the command line arguments
     */
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                controladorInicio ctrInicio = new controladorInicio();
               frameInicial dialog = new frameInicial(ctrInicio);
               dialog.setVisible(true);
                
                       
            }
        });
    }

    public JButton getBtAlumnos() {
        return btAlumnos;
    }

    public void setBtAlumnos(JButton btAlumnos) {
        this.btAlumnos = btAlumnos;
    }

    public JButton getBtLibros() {
        return btLibros;
    }

    public void setBtLibros(JButton btLibros) {
        this.btLibros = btLibros;
    }

    public JButton getBtSalir() {
        return btSalir;
    }

    public void setBtSalir(JButton btSalir) {
        this.btSalir = btSalir;
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/pink.png"));


        return retValue;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlumnos;
    private javax.swing.JButton btInformes;
    private javax.swing.JButton btLibros;
    private javax.swing.JButton btPrestamos;
    private javax.swing.JButton btSalir;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
}
