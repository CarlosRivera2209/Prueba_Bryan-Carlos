package ahorcado;

import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private JuegoAhorcadoFijo juegoAhorcadoFijo;
    private JuegoAhorcadoAzar juegoAhorcadoAzar;
    AdminPalabrasSecretas adminPalabrasSecretas = new AdminPalabrasSecretas();

    public Main() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AhorcadoFijo = new javax.swing.JButton();
        Ahorcado_Azar = new javax.swing.JButton();
        Agregar_Palabra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        AhorcadoFijo.setText("Ahorcado Fijo");
        AhorcadoFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AhorcadoFijoActionPerformed(evt);
            }
        });

        Ahorcado_Azar.setText("Ahorcado Azar");
        Ahorcado_Azar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ahorcado_AzarActionPerformed(evt);
            }
        });

        Agregar_Palabra.setText("Agregar Palabra");
        Agregar_Palabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_PalabraActionPerformed(evt);
            }
        });

        jLabel1.setText("AHORCADOS");

        Salir.setBackground(new java.awt.Color(204, 0, 0));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 201, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Ahorcado_Azar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AhorcadoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Agregar_Palabra))
                                .addGap(181, 181, 181))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Salir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(AhorcadoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ahorcado_Azar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Agregar_Palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AhorcadoFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AhorcadoFijoActionPerformed

        String[] palabras = adminPalabrasSecretas.getPalabras();

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Selecciona una palabra:",
                "Ahorcado Fijo",
                JOptionPane.PLAIN_MESSAGE,
                null,
                palabras,
                palabras[0]);

        if (seleccion != null) {
            juegoAhorcadoFijo = new JuegoAhorcadoFijo(seleccion);

            JOptionPane.showMessageDialog(this, "Adivina la palabra secreta fija.");

            while (!juegoAhorcadoFijo.hasGanado() && juegoAhorcadoFijo.intentos > 0) {
                String letra = JOptionPane.showInputDialog(this, "Palabra actual: " + juegoAhorcadoFijo.palabraActual
                        + "\nIntentos restantes: " + juegoAhorcadoFijo.intentos
                        + "\nIngresa una letra:");

                if (letra == null || letra.isEmpty()) {

                    break;
                }

                char letraChar = letra.charAt(0);
                if (juegoAhorcadoFijo.verificarLetra(letraChar)) {
                    juegoAhorcadoFijo.actualizarPalabraActual(letraChar);
                    if (juegoAhorcadoFijo.hasGanado()) {
                        JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado. La palabra era: " + juegoAhorcadoFijo.palabraSecreta);
                    }
                } else {
                    juegoAhorcadoFijo.intentos--;
                    if (juegoAhorcadoFijo.intentos == 0) {
                        JOptionPane.showMessageDialog(this, "¡Lo siento! Has perdido. La palabra era: " + juegoAhorcadoFijo.palabraSecreta);
                    } else {
                        JOptionPane.showMessageDialog(this, "Letra incorrecta. Intenta de nuevo.");
                    }
                }
            }
        }
    }//GEN-LAST:event_AhorcadoFijoActionPerformed

    private void Ahorcado_AzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ahorcado_AzarActionPerformed

        juegoAhorcadoAzar = new JuegoAhorcadoAzar(adminPalabrasSecretas);

        JOptionPane.showMessageDialog(this, "Adivina la palabra secreta al azar.");

        do {
            String letra = JOptionPane.showInputDialog(this, "Palabra actual: " + juegoAhorcadoAzar.palabraActual
                    + "\nIntentos restantes: " + juegoAhorcadoAzar.intentos
                    + "\nIngresa una letra:");
            if (letra == null || letra.isEmpty()) {
                break;
            }
            char letraChar = letra.charAt(0);
            if (juegoAhorcadoAzar.verificarLetra(letraChar)) {
                juegoAhorcadoAzar.actualizarPalabraActual(letraChar);
                if (juegoAhorcadoAzar.hasGanado()) {
                    JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado. La palabra era: " + juegoAhorcadoAzar.palabraSecreta);
                    break;
                }
            } else {
                juegoAhorcadoAzar.intentos--;
                if (juegoAhorcadoAzar.intentos == -6) {
                    JOptionPane.showMessageDialog(this, "¡Lo siento! Has perdido. La palabra era: " + juegoAhorcadoAzar.palabraSecreta);
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Letra incorrecta. Intenta de nuevo.");
                }
            }
        } while (true);
    }//GEN-LAST:event_Ahorcado_AzarActionPerformed

    private void Agregar_PalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_PalabraActionPerformed
        String nuevaPalabra = JOptionPane.showInputDialog(this, "Ingresa una nueva palabra:");
        if (nuevaPalabra != null && !nuevaPalabra.isEmpty()) {
            adminPalabrasSecretas.agregarPalabra(nuevaPalabra);
            JOptionPane.showMessageDialog(this, "Palabra agregada exitosamente.");
        }
    }//GEN-LAST:event_Agregar_PalabraActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar_Palabra;
    private javax.swing.JButton AhorcadoFijo;
    private javax.swing.JButton Ahorcado_Azar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
