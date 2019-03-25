/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generadorhtml;

import analyzers.Esemanticos;
import analyzers.Parser;
import analyzers.Scanner;
import analyzers.sym;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dinora
 */
public class CrearHTML extends javax.swing.JFrame {
    DefaultTableModel model;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    /**
     * Creates new form crearHTML
     */
    public CrearHTML() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
    }
    
    public String OpenFile(File archivo){
        String documento = "";
        try{
           entrada = new FileInputStream(archivo);
           int  ascci;
           while((ascci=entrada.read())!= -1){
               char caracter = (char)ascci;
               documento += caracter;
           }
        } catch (Exception e) {}
        return documento;
    }
    
    public String SaveFile(File archivo, String documento){
        String mensaje = null;
        try{
           salida = new FileOutputStream(archivo);
           byte[] bytxt = documento.getBytes();
           salida.write(bytxt);
           mensaje = "Archivo Guardado";
        } catch (Exception e) {
        }
        return mensaje;
    }
    
    public void EscribirHTML(String contenido) throws FileNotFoundException, IOException{
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("PAGINA.html"),"utf-8"))){
            writer.write(contenido);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CreateHTMLErrores(ArrayList<Esemanticos> erroresLexicos, ArrayList<Esemanticos> erroresSintacticos) throws FileNotFoundException, IOException{
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("errores.html"),"utf-8"))){
            writer.write(ContenidoErroresHMTL(erroresLexicos, erroresSintacticos));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String ContenidoErroresHMTL(ArrayList<Esemanticos> erroresLexicos, ArrayList<Esemanticos> erroresSintacticos){
        String cuerpo = ""; 
        
        cuerpo += "<html>\n" +
                    "<head>\n"+
                        "<title>Errores</title>\n"+
                            "<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.min.css\">\n"+
                    "</head>\n" +
                    "<body>\n" +
                        "<table class=\"table\">\n" +
                            "<thead class=\"thead-dark\">\n"+
                                "<tr>\n" +
                                    "<th scope=\"col\">Simbolo</th>\n" +
                                    "<th scope=\"col\">Tipo</th>\n"+
                                    "<th scope=\"col\">Fila</th>\n"+
                                    "<th scope=\"col\">Columna</th>\n"+
                                    "<th scope=\"col\">Descripcion</th>\n"+
                                "</tr>\n"+
                            "</thead>\n"+
                            "<tbody>\n";
                                //ERRORES LÉXICOS
                                for(int i = 0; i < erroresLexicos.size(); i++){
                                    cuerpo += "<tr>\n";
                                    cuerpo += "<td>"+ erroresLexicos.get(i).id +"</td>\n";
                                    cuerpo += "<td>"+ erroresLexicos.get(i).tipo +"</td>\n";
                                    cuerpo += "<td>"+ erroresLexicos.get(i).fila +"</td>\n";
                                    cuerpo += "<td>"+ erroresLexicos.get(i).columna +"</td>\n";
                                    cuerpo += "<td>"+ erroresLexicos.get(i).descripcion +"</td>\n";
                                    cuerpo += "</tr>\n";
                                }
                                //ERRORES SINTÁCTICOS
                                for(int i = 0; i < erroresSintacticos.size(); i++){
                                    cuerpo += "<tr>\n";
                                    cuerpo += "<td>"+ erroresSintacticos.get(i).id +"</td>\n";
                                    cuerpo += "<td>"+ erroresSintacticos.get(i).tipo +"</td>\n";
                                    cuerpo += "<td>"+ erroresSintacticos.get(i).fila +"</td>\n";
                                    cuerpo += "<td>"+ erroresSintacticos.get(i).columna +"</td>\n";
                                    cuerpo += "<td>"+ erroresSintacticos.get(i).descripcion +"</td>\n";
                                    cuerpo += "</tr>\n";
                                }
        cuerpo +=           "</tbody>\n"+
                        "</table>\n"+
                        "<script type=\"text/javascript\" src=\"bootstrap.min.js\"></script>\n"+
                    "</body>\n" +
                "</html>\n";
                
        return cuerpo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEditor = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextConsola = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPaginaResultante = new javax.swing.JButton();
        btnListaErrores = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        btnCompilar.setBackground(new java.awt.Color(204, 102, 0));
        btnCompilar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        jTextAreaEditor.setBackground(new java.awt.Color(0, 51, 51));
        jTextAreaEditor.setColumns(20);
        jTextAreaEditor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextAreaEditor.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaEditor.setRows(5);
        jTextAreaEditor.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaEditor);

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jTextConsola.setBackground(new java.awt.Color(0, 51, 51));
        jTextConsola.setColumns(20);
        jTextConsola.setForeground(new java.awt.Color(255, 255, 255));
        jTextConsola.setRows(5);
        jScrollPane2.setViewportView(jTextConsola);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consola", jPanel2);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 51, 51));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO", "VALOR", "LINEA", "COLUMNA"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 102, 102));
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTable1);
        jTable1.getTableHeader().setBackground(Color.DARK_GRAY);
        jTable1.getTableHeader().setForeground(Color.BLACK);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Variables", jPanel3);

        btnPaginaResultante.setBackground(new java.awt.Color(204, 102, 0));
        btnPaginaResultante.setText("Ver página web resultante");
        btnPaginaResultante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaginaResultanteActionPerformed(evt);
            }
        });

        btnListaErrores.setBackground(new java.awt.Color(204, 102, 0));
        btnListaErrores.setText("Ver Errores");
        btnListaErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaErroresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCompilar, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnPaginaResultante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCompilar)
                        .addGap(21, 21, 21)
                        .addComponent(btnPaginaResultante)
                        .addGap(22, 22, 22)
                        .addComponent(btnListaErrores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem3.setText("Nuevo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Abrir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Guardar");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Guardar como");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem7.setText("Manual de Usuario");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Manual Técnico");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Acerca de");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        try{
           StringReader sr = new StringReader(jTextAreaEditor.getText());
           BufferedReader bf = new BufferedReader(sr);
           Parser lexico = new Parser(bf);
           Scanner sintactico = new Scanner(lexico);
//           Scanner sintactico = new Scanner(new Parser(new BufferedReader(new StringReader(jTextAreaEditor.getText()))));
           sintactico.parse();
           
           /*Verificando Errores*/
           if(lexico.ErroresLexicos.size() > 0 || sintactico.ErroresSintacticos.size() > 0){
                CreateHTMLErrores(lexico.ErroresLexicos,sintactico.ErroresSintacticos);
                this.jTextConsola.append("¡Se encontraron errores en el archivo!");
           }else{
                /*Crear la página de errores para que la vacie*/
                CreateHTMLErrores(lexico.ErroresLexicos,sintactico.ErroresSintacticos);
                
                /*Creando archivo HTML resultante*/
                EscribirHTML(sintactico.resultado);
                     
                /*Llenando la tabla de las variables */
                for(int i = 0; i < sintactico.lista_variables.size(); i++){
                    model.insertRow(model.getRowCount(), new Object[]{ sintactico.lista_variables.get(i).nombre, 
                                                                     sintactico.lista_variables.get(i).tipo,
                                                                     sintactico.lista_variables.get(i).valor,
                                                                     sintactico.lista_variables.get(i).linea,
                                                                     sintactico.lista_variables.get(i).columna});
                }
           }
           
//           /*Reporte de los tokens reconocidos durante el analisis*/
//           Symbol s = (Symbol)lexico.next_token();  //Obtiene el primer token
//           while(s.sym != 0){       //Si el token no es error... analizar
//               System.out.println("Lexema: " + s.value + " Token: " + s.sym);
//               s = (Symbol)lexico.next_token();
//           }
        }catch (Exception ex){
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCompilarActionPerformed
    
    /*ABRIR*/
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("uweb")){
                    String documento = OpenFile(archivo);
                    this.jTextAreaEditor.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null,"El archivo debe ser .gu");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /*GUARDAR COMO*/
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if(seleccionar.showDialog(null, "Guardar como") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("gu")){
                String documento = this.jTextAreaEditor.getText();
                String mensaje = SaveFile(archivo, documento);
                if(mensaje != null){
                    JOptionPane.showMessageDialog(rootPane, mensaje);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar documento html");
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /*NUEVO*/
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    /*VER PAGINA WEB RESULTANTE*/
    private void btnPaginaResultanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaginaResultanteActionPerformed
        try {
            Desktop.getDesktop().open(new java.io.File("PAGINA.html"));
        } catch (IOException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPaginaResultanteActionPerformed

    /*VER LA LISTA DE ERRORES*/
    private void btnListaErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaErroresActionPerformed
        try {
            Desktop.getDesktop().open(new java.io.File("errores.html"));
        } catch (IOException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnListaErroresActionPerformed

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
            java.util.logging.Logger.getLogger(CrearHTML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearHTML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearHTML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearHTML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearHTML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnListaErrores;
    private javax.swing.JButton btnPaginaResultante;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaEditor;
    private javax.swing.JTextArea jTextConsola;
    // End of variables declaration//GEN-END:variables
}
