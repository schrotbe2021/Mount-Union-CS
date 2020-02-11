/*
    Ben Schroth
    PA1 CS370
    Dr. Klayder
        Description: An operating system simulator that simulates process being 
                    ran using the Round Robin Algorithm
        Log: [Date, Time (Hours), Description]
             [9/3, 1.0, GUI Design, Documentation, Added supporting classes]
             [9/4, 1.0, Added constructor Simulator.java, Added validityCheck() to simulator,
                        Tested to make sure validity checks are working]
             [9/10, 1.5, Added fillArray() method, general cleaning up of code]
             [9/11, 1.0, Finished read button but no output]
             [9/12, 1.0, Fixed problem of no output after pressing stats button, 
                         added ticker and newList to schedule processes.]
             [9/17, 3.0, Cleaned up documentation, Finished ticker, added readList
                         Added running clock, Added JSlider, run/pause button gets
                         information from slider]
             [11/2, 5.0 Added move to runningList and move to waitingList]
             [11/3 3.0 Made processes able to jump from ready to running, running
                        to waiting, and waiting to running]
             [11/5, 4.0 Added calculation for CPU utilization, throughput, and 
                        waiting times]
             [11/13, 2.0 Added FirstResponse, turnaround time, dispatch latency, 
                        and added more documentation.]
             
        Revisions:
             [12/3, .5 Fixed dispatch latency to only when it goes into running.]
             [12/4, 1.0 Added documentation for data members in Process.java & Simulator.java
                        Fixed doc to say Operating System simulator. Fixed average wait time
                        to correct formula.
 */
package pa2_package;

public class ProcessJFrame extends javax.swing.JFrame {

    private final Simulator sim;
    private Integer tickValue;
    
    public ProcessJFrame() {
        initComponents();
        sim = new Simulator(inputArea, outputArea); // Initializes simulator. 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        statsButton = new javax.swing.JButton();
        tickButton = new javax.swing.JButton();
        runPauseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        inputLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        outputLabel = new javax.swing.JLabel();
        clearText = new javax.swing.JButton();
        tickSlider = new javax.swing.JSlider();
        tickLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        readButton.setText("Read Data");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        statsButton.setText("Stats");
        statsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsButtonActionPerformed(evt);
            }
        });

        tickButton.setText("Tick");
        tickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tickButtonActionPerformed(evt);
            }
        });

        runPauseButton.setText("Run/Pause");
        runPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runPauseButtonActionPerformed(evt);
            }
        });

        inputArea.setColumns(20);
        inputArea.setRows(5);
        jScrollPane1.setViewportView(inputArea);

        inputLabel.setText("Input:");

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane2.setViewportView(outputArea);

        outputLabel.setText("Output:");

        clearText.setText("Clear Text Areas");
        clearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextActionPerformed(evt);
            }
        });

        tickSlider.setMajorTickSpacing(100);
        tickSlider.setMaximum(5000);
        tickSlider.setMinimum(100);
        tickSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        tickSlider.setPaintTicks(true);
        tickSlider.setValue(3000);
        tickSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tickSliderStateChanged(evt);
            }
        });

        tickLabel.setText("Tick Speed:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearText)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outputLabel)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tickSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(aboutButton)
                                .addGap(18, 18, 18)
                                .addComponent(readButton)
                                .addGap(18, 18, 18)
                                .addComponent(statsButton)
                                .addGap(18, 18, 18)
                                .addComponent(tickButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(runPauseButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tickLabel)
                                .addGap(59, 59, 59))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutButton)
                    .addComponent(readButton)
                    .addComponent(statsButton)
                    .addComponent(tickButton)
                    .addComponent(runPauseButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(inputLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tickLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tickSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        clearText();
        inputArea.setText("Ben Schroth\n" 
                + "Operating System Simulator v3.0\n"
                + "PA2 CSC370\n" 
                + "    Notes: An operating system simulator taking data in and scheduling the proceses using the ROund Robin Algorithm.");
        
    }//GEN-LAST:event_aboutButtonActionPerformed
    // Displays about information.
    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        outputArea.setText("");
        sim.validityCheck();
        sim.fillArray();
    }//GEN-LAST:event_readButtonActionPerformed
    // Clears output, validates data and fills the array.
    private void clearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextActionPerformed
        clearText();
    }//GEN-LAST:event_clearTextActionPerformed

    private void statsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsButtonActionPerformed

        sim.statsButton();
        
    }//GEN-LAST:event_statsButtonActionPerformed

    private void tickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tickButtonActionPerformed

        sim.tickButton();
    
    }//GEN-LAST:event_tickButtonActionPerformed

    private void runPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runPauseButtonActionPerformed
        sim.runPauseButton(tickSlider);
        
    }//GEN-LAST:event_runPauseButtonActionPerformed

    private void tickSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tickSliderStateChanged
        tickLabel.setText("Tick Speed: " + Integer.toString(tickSlider.getValue()) + " ms");
        tickValue = tickSlider.getValue();
        
    }//GEN-LAST:event_tickSliderStateChanged

    
    public void clearText(){
        inputArea.setText("");
        outputArea.setText("");
    } // Method makes it easier to clear text areas.
    
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
            java.util.logging.Logger.getLogger(ProcessJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton clearText;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JButton readButton;
    private javax.swing.JButton runPauseButton;
    private javax.swing.JButton statsButton;
    private javax.swing.JButton tickButton;
    private javax.swing.JLabel tickLabel;
    private javax.swing.JSlider tickSlider;
    // End of variables declaration//GEN-END:variables
}
