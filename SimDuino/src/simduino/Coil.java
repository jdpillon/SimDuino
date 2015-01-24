/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simduino;

/**
 * @author Meli Nunzio
 * @author Sorge Simone
 * @author Finocchiaro Alessandro
 */
public class Coil {

    private int port;
    private int type;
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
      
    public Coil(int port, int type) {
        this.port = port;
        this.type = type;
    }
   
}
