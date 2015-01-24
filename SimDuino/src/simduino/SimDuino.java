/*
 * PROGETTO LINGUAGGI E TRADUTTORI
 * Nunzio Meli,Simone Sorge,Alex Finocchiaro
 */

/**
 * @author Meli Nunzio
 * @author Sorge Simone
 * @author Finocchiaro Alessandro
 */


import java.io.*;
   

   
public class SimDuino {
  static public void main(String argv[]) {    
    /* Start the parser */
    try {
      parser p = new parser(new Lexer(new FileReader(argv[0])));
      Object result = p.parse().value;      
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


