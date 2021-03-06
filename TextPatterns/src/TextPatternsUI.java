import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.datatransfer.DataFlavor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Date: Jun 5, 2016 
 * Author: Calum Patrick 
 * Program: TextPatterns
 * Purpose: Take a plaintext input from clipboard or a textArea box and filter it
 * for either email addresses, phone numbers, or web-site URLs. Display the results
 * in a textArea box, and allow the user to copy the contents to their clipboard. 
 */

// TODO: Write event for "copy to clipboard" button, test.

    public class TextPatternsUI extends javax.swing.JFrame {
    private String stringRegex="";
    private Matcher compiler;
    String compiled;
    
    // REGEX SEARCH PATTERNS
    private final String rEmail = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]{2,6}+";
    private final String rPhone = "(\\d{3}|\\(\\d{3}\\))?(\\s|-|\\.)?(\\d{3})(\\s|-|\\.)?(\\d{4})";
    private final String rWebsite = "(http(s)?:\\/\\/.)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";  
    
    
    
    
    // Creates new form TextPatternsUI
    
    public TextPatternsUI() {
        initComponents();
        
    }

    // Grabs the user's clipboard contents 
   
    public static String getClip() throws Exception {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = (String) clipboard.getData(DataFlavor.stringFlavor);
        return result;
    }
    
    // Compiles regex into groups and appends results to output textArea.
    public void appendResults() {
        stringRegex = sourceTextArea.getText();
        while (compiler.find()) {
        System.out.println(compiler.group());
        outputTextArea.append(compiler.group()+"\n");
        }
    }

    
    
/**
 * Find what the user wants to search for, and which RegEx search pattern to compile,
 * then compiles it.
 * 
 * Mode 0 = Email
 * Mode 1 = Phone Numbers
 * Mode 2 = Web-site URLs
 * 
 */
    public void compileReg() {
        int mode;
        if (modeEmailsRadio.isSelected()) {
            mode = 0;
            System.out.println("Searching for emails...");
            compiler = Pattern.compile(rEmail).matcher(stringRegex);
        } else if (modePhoneRadio.isSelected()) {
            mode = 1;
            System.out.println("Searching for phone numbers...");
            compiler = Pattern.compile(rPhone).matcher(stringRegex);
        } else {
            mode = 2;
            System.out.println("Searching for website URLs...");
            compiler = Pattern.compile(rWebsite).matcher(stringRegex);
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

        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel4 = new javax.swing.JPanel();
        modeOptionsGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modeEmailsRadio = new javax.swing.JRadioButton();
        modePhoneRadio = new javax.swing.JRadioButton();
        modeWebsiteRadio = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sourceClipboardButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceTextArea = new javax.swing.JTextArea();
        sourceGoButton = new javax.swing.JButton();
        sourceClearButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        outputResultsLabel = new javax.swing.JLabel();
        outputClearButton = new javax.swing.JButton();
        outputClipboardButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabs.setToolTipText("");

        jLabel1.setText("What would you like to search for?");

        modeOptionsGroup.add(modeEmailsRadio);
        modeEmailsRadio.setText("Emails");

        modeOptionsGroup.add(modePhoneRadio);
        modePhoneRadio.setText("Phone Numbers");

        modeOptionsGroup.add(modeWebsiteRadio);
        modeWebsiteRadio.setText("Website URLs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modeWebsiteRadio)
                    .addComponent(modePhoneRadio)
                    .addComponent(modeEmailsRadio)
                    .addComponent(jLabel1))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(modeEmailsRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modePhoneRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modeWebsiteRadio)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        tabs.addTab("Mode", new javax.swing.ImageIcon(getClass().getResource("/more.png")), jPanel1, ""); // NOI18N

        jLabel3.setText("Text input:");

        sourceClipboardButton.setText("Copy from clipboard");
        sourceClipboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceClipboardButtonActionPerformed(evt);
            }
        });

        sourceTextArea.setColumns(20);
        sourceTextArea.setLineWrap(true);
        sourceTextArea.setRows(2);
        jScrollPane1.setViewportView(sourceTextArea);

        sourceGoButton.setText("Go");
        sourceGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceGoButtonActionPerformed(evt);
            }
        });

        sourceClearButton.setText("Clear");
        sourceClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(sourceClearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sourceGoButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                        .addComponent(sourceClipboardButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceClipboardButton)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceClearButton)
                    .addComponent(sourceGoButton))
                .addGap(15, 15, 15))
        );

        tabs.addTab("Source", new javax.swing.ImageIcon(getClass().getResource("/download-arrow.png")), jPanel2); // NOI18N

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane2.setViewportView(outputTextArea);

        outputResultsLabel.setText("Results:");

        outputClearButton.setText("Clear");
        outputClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputClearButtonActionPerformed(evt);
            }
        });

        outputClipboardButton.setText("Copy results to clipboard");
        outputClipboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputClipboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(outputResultsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outputClipboardButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 519, Short.MAX_VALUE)
                        .addComponent(outputClearButton)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputResultsLabel)
                    .addComponent(outputClipboardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputClearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Output", new javax.swing.ImageIcon(getClass().getResource("/tick-sign.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceClipboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceClipboardButtonActionPerformed
        try {
            // Copy text from clipboard into input box
            sourceTextArea.setText(getClip());
        } catch (Exception ex) {
            Logger.getLogger(TextPatternsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sourceClipboardButtonActionPerformed

    private void sourceClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceClearButtonActionPerformed
        // Clear Button
        sourceTextArea.setText("");
    }//GEN-LAST:event_sourceClearButtonActionPerformed

    private void sourceGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceGoButtonActionPerformed
        // Go button,
        outputTextArea.setText("");
        stringRegex = sourceTextArea.getText();
        compileReg();
        appendResults();
        compiled = outputTextArea.getText();
        
    }//GEN-LAST:event_sourceGoButtonActionPerformed

    // Set output textArea to empty string.
    private void outputClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputClearButtonActionPerformed
        // output clear button
        outputTextArea.setText("");
    }//GEN-LAST:event_outputClearButtonActionPerformed

    
    // Create new clipbard variable. Set clipboard to output textArea contents.
    private void outputClipboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputClipboardButtonActionPerformed
        // output clipboard button 
        StringSelection stringSelection = new StringSelection(compiled);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
      
    }//GEN-LAST:event_outputClipboardButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Customized look and feel code to show the OS's default UI elements 
       
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextPatternsUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton modeEmailsRadio;
    private javax.swing.ButtonGroup modeOptionsGroup;
    private javax.swing.JRadioButton modePhoneRadio;
    private javax.swing.JRadioButton modeWebsiteRadio;
    private javax.swing.JButton outputClearButton;
    private javax.swing.JButton outputClipboardButton;
    private javax.swing.JLabel outputResultsLabel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JButton sourceClearButton;
    private javax.swing.JButton sourceClipboardButton;
    private javax.swing.JButton sourceGoButton;
    public static javax.swing.JTextArea sourceTextArea;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
  
    

}
