/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewLeer;
import models.modelLeer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author LENOVO
 */
public class controllerLeer implements ActionListener {

    modelLeer modelleer;
    viewLeer viewleer;

    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewleer.jmi_leer) { 
                jmi_leer_action_performed();
            } else if (e.getSource() == viewleer.jmi_guardar) { 
                jmi_guardar_action_performed();
            }
        }

        
    };

    public controllerLeer(modelLeer modeleer, viewLeer viewleer) {
        this.modelleer = modeleer;
        this.viewleer = viewleer;

        this.viewleer.jmi_leer.addActionListener(actionlistener);
        this.viewleer.jmi_guardar.addActionListener(actionlistener);
        initComponents();
    }

    private void jmi_leer_action_performed() {
        this.readFile(modelleer.getPath());
    }
    
    private void jmi_guardar_action_performed() {
            modelleer.setMessage(viewleer.jta_texto.getText()); 
        this.writeFile(modelleer.getPath(), modelleer.getMessage()); 
        }

    private void readFile(String path) {
        try {
            String row; 
            try (FileReader archivo = new FileReader(path)) { 
                BufferedReader bufferedreader = new BufferedReader(archivo); 
                while ((row = bufferedreader.readLine()) != null) {
                    viewleer.jta_texto.setText(row);
                }
            }
        } catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        } catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }

    }

    public void writeFile(String path, String message) {
        try {
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, false); 

            try (PrintWriter printwriter = new PrintWriter(filewriter)) { 
                printwriter.println(message);
                printwriter.close();
            }
        } catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        } catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }

    public void initComponents() {
        viewleer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
