/*
 * PROGETTO LINGUAGGI E TRADUTTORI
 * Nunzio Meli,Simone Sorge,Alex Finocchiaro
 */
package simduino;

/**
 * @author Meli Nunzio
 * @author Sorge Simone
 * @author Finocchiaro Alessandro
 */
public class Contact {

    private int from;
    private int to;
    private int port;
    private int type;
    
    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

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
   
    public Contact(int from, int to, int port, int type) {
        this.from = from;
        this.to = to;
        this.port = port;
        this.type = type;
    }
   
   
}
