/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;

/**
 *
 * @author LENOVO
 */
public class modelLeer {
    
     private String path = "C:\\archivo\\texto.txt"; 
     private String texto = ""; 

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return texto;
    }
    public void setMessage(String message) {
        this.texto = message;
    }
}

