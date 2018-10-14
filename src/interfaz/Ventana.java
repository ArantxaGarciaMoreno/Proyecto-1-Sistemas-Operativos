package interfaz;


public class Ventana extends javax.swing.JFrame {

   
    public Ventana() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productionIcon = new javax.swing.JLabel();
        productoresLabel = new javax.swing.JLabel();
        almacenesLabel = new javax.swing.JLabel();
        bateriasLabel = new javax.swing.JLabel();
        pantallasLabel = new javax.swing.JLabel();
        cablesLabel = new javax.swing.JLabel();
        cantPBTextField = new javax.swing.JTextField();
        cantPPTextField = new javax.swing.JTextField();
        cantPCTextField = new javax.swing.JTextField();
        cantBTextField = new javax.swing.JTextField();
        cantPTextField = new javax.swing.JTextField();
        cantCTextField = new javax.swing.JTextField();
        contratarPBButton = new javax.swing.JButton();
        contratarPPButton = new javax.swing.JButton();
        contratarPCButton = new javax.swing.JButton();
        despedirPBButton = new javax.swing.JButton();
        despedirPPButton = new javax.swing.JButton();
        despedirPCButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        unidadesLabel = new javax.swing.JLabel();
        unidadesLabel2 = new javax.swing.JLabel();
        unidadesLabel3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productionIcon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productionIcon.setForeground(new java.awt.Color(255, 255, 255));
        productionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productionIcon.png"))); // NOI18N
        productionIcon.setText("PRODUCCIÓN");
        getContentPane().add(productionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        productoresLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productoresLabel.setForeground(new java.awt.Color(255, 255, 255));
        productoresLabel.setText("PRODUCTORES");
        getContentPane().add(productoresLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        almacenesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        almacenesLabel.setForeground(new java.awt.Color(255, 255, 255));
        almacenesLabel.setText("ALMACENES");
        getContentPane().add(almacenesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        bateriasLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        bateriasLabel.setForeground(new java.awt.Color(255, 255, 255));
        bateriasLabel.setText("BATERIAS");
        getContentPane().add(bateriasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        pantallasLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        pantallasLabel.setForeground(new java.awt.Color(255, 255, 255));
        pantallasLabel.setText("PANTALLAS");
        getContentPane().add(pantallasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        cablesLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        cablesLabel.setForeground(new java.awt.Color(255, 255, 255));
        cablesLabel.setText("CABLES");
        getContentPane().add(cablesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        cantPBTextField.setEditable(false);
        cantPBTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantPBTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 40, -1));

        cantPPTextField.setEditable(false);
        cantPPTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantPPTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, -1));

        cantPCTextField.setEditable(false);
        cantPCTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantPCTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 40, -1));

        cantBTextField.setEditable(false);
        cantBTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantBTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 50, -1));

        cantPTextField.setEditable(false);
        cantPTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantPTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 50, -1));

        cantCTextField.setEditable(false);
        cantCTextField.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cantCTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 50, -1));

        contratarPBButton.setBackground(new java.awt.Color(0, 153, 153));
        contratarPBButton.setText("CONTRATAR");
        contratarPBButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(contratarPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 120, -1));

        contratarPPButton.setBackground(new java.awt.Color(0, 153, 153));
        contratarPPButton.setText("CONTRATAR");
        contratarPPButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(contratarPPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 120, -1));

        contratarPCButton.setBackground(new java.awt.Color(0, 153, 153));
        contratarPCButton.setText("CONTRATAR");
        contratarPCButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(contratarPCButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 120, -1));

        despedirPBButton.setBackground(new java.awt.Color(255, 0, 0));
        despedirPBButton.setText("DESPEDIR");
        despedirPBButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(despedirPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 100, -1));

        despedirPPButton.setBackground(new java.awt.Color(255, 0, 0));
        despedirPPButton.setText("DESPEDIR");
        despedirPPButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(despedirPPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 100, -1));

        despedirPCButton.setBackground(new java.awt.Color(255, 0, 0));
        despedirPCButton.setText("DESPEDIR");
        despedirPCButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(despedirPCButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 100, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 660, 10));

        unidadesLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        unidadesLabel.setText("UNIDADES");
        getContentPane().add(unidadesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        unidadesLabel2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        unidadesLabel2.setText("UNIDADES");
        getContentPane().add(unidadesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        unidadesLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        unidadesLabel3.setText("UNIDADES");
        getContentPane().add(unidadesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo_de_madera_natural.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel almacenesLabel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bateriasLabel;
    private javax.swing.JLabel cablesLabel;
    private javax.swing.JTextField cantBTextField;
    private javax.swing.JTextField cantCTextField;
    private javax.swing.JTextField cantPBTextField;
    private javax.swing.JTextField cantPCTextField;
    private javax.swing.JTextField cantPPTextField;
    private javax.swing.JTextField cantPTextField;
    private javax.swing.JButton contratarPBButton;
    private javax.swing.JButton contratarPCButton;
    private javax.swing.JButton contratarPPButton;
    private javax.swing.JButton despedirPBButton;
    private javax.swing.JButton despedirPCButton;
    private javax.swing.JButton despedirPPButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel pantallasLabel;
    private javax.swing.JLabel productionIcon;
    private javax.swing.JLabel productoresLabel;
    private javax.swing.JLabel unidadesLabel;
    private javax.swing.JLabel unidadesLabel2;
    private javax.swing.JLabel unidadesLabel3;
    // End of variables declaration//GEN-END:variables
}
