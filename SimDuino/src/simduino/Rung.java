/*
 * PROGETTO LINGUAGGI E TRADUTTORI
 * Nunzio Meli,Simone Sorge,Alex Finocchiaro
 */
package simduino;

import java.util.ArrayList;

/**
 * @author Meli Nunzio
 * @author Sorge Simone
 * @author Finocchiaro Alessandro
 */
public class Rung {

    private ArrayList<Contact> section1;
    private Coil section2;
    
    public ArrayList<Contact> getSection1() {
        return section1;
    }

    public void setSection1(ArrayList<Contact> section1) {
        this.section1 = section1;
    }

    public Coil getSection2() {
        return section2;
    }

    public void setSection2(Coil section2) {
        this.section2 = section2;
    }

    public Rung(ArrayList<Contact> section1, Coil section2) {
        this.section1 = section1;
        this.section2 = section2;
    }
 
}
