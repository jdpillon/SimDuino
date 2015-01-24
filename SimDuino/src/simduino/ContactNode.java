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
public class ContactNode {    

    private ArrayList<ContactNode> child_node;

    private Rung rung;
    private boolean isRootNode;
    private Contact contact;
    
    
    
    /****FUNZIONE: findMax_ToValue_FromContactList****/
    /**
    * Ciascun oggetto Contact ha un attributo from di tipo int
    * trova il massimo valore dell'attributo from tra tutti i contatti
    * presenti in un rung.
    **/
    public int findMax_ToValue_FromContactList(Rung rung){
		int max=0;
		for(Contact cnt: rung.getSection1()){
			if(cnt.getTo()>max){
				max=cnt.getTo();
			}
		}
		return max;
    }

    /****FUNZIONE: findContactWithSource****/
    /**
    * Trova tutti i contatti che hanno l'attributo from uguale a from.
    **/
    private ArrayList<Contact> findContactWithSource(Rung rung,int from){
        ArrayList<Contact> contact_found=new ArrayList<>();
	for(Contact cnt: rung.getSection1()){
	    if(cnt.getFrom()==from){
		contact_found.add(cnt);
	    }
	}
	return contact_found;
    }
   
    /****FUNZIONE: buildTree****/
    /**
    * Funzione che crea ricorsivamente l'albero dei contatti in un rung.
    **/
    public boolean buildTree(int from,int maxTo){
       ArrayList<Contact> contact_found;
       contact_found=findContactWithSource(rung,from);
       
       if(from==0&&contact_found.isEmpty())
           return false;
       /****DEBUG****/
       /*System.out.println("****");
       for(Contact cnts:contact_found){
        System.out.println("Contatti trovati per from:"+from);
       }
       System.out.println("****");*/
       /************/
       
       if(!(contact_found.isEmpty())){
          if(from<maxTo){
            for(Contact cnt:contact_found){
                ContactNode child=new ContactNode(rung,cnt);
                child_node.add(child);
                if(!child.buildTree(cnt.getTo(),maxTo))
                    return false;
            }
          }else
              return false;          
       }
              return true;
    }
   
    
     /****FUNZIONE: toString()****/
    /**
    * Funzione che ricorsivamente trova l'espressione logica corrispondente
    * all'albero appena creato.
    * Bisogna invocarla dopo aver costruito l'albero.
    **/
    @Override
    public String toString(){
     String str="";
     
     boolean isFirst=true;
     for(ContactNode cnt:child_node){
            if(isFirst){
                isFirst=false;
                str=str+"(";
            }else{
                 str=str+"||";
            }
         if(!isRootNode){
            if(contact.getType()==0)
             str=str+cnt.toString()+"&&var"+String.valueOf(contact.getPort())+"==HIGH";
            else if(contact.getType()==1)
             str=str+cnt.toString()+"&&!(var"+String.valueOf(contact.getPort())+"==HIGH)"; 
         }else{
            str=str+cnt.toString();
         }
     }
     
   
     if(child_node.isEmpty()&&!isRootNode){
         
         if(this.findMax_ToValue_FromContactList(rung)!=contact.getTo()){
             System.out.println("Inavalid Ladder Diagram");
             System.exit(1);
         }
         
         if(contact.getType()==0)
            str=str+"var"+String.valueOf(contact.getPort())+"==HIGH";
         else if(contact.getType()==1)
            str=str+"!(var"+String.valueOf(contact.getPort())+"==HIGH)";
     }else
         str=str+")";
     return str;
    }
    
    
   /****FUNZIONE: visit()****/
    /**
    * Funzione di visita depth-first dell'albero.
    * Per ogni nodo dell'albero viene stampato il node e i nodi figli.
    **/
    public void visit(){
     for(ContactNode cnt:child_node){
         cnt.visit();
     }
     
     for(ContactNode cnt:child_node){
         if(!isRootNode)
            System.out.println("Node:"+this.contact.getTo()+"Child:"+cnt.contact.getTo());
         else
            System.out.println("Node:0 Child:"+cnt.contact.getTo());  
     }
     


    }
    
    public boolean isRootNode() {
        return isRootNode;
    }

    public void setIsRootNode(boolean isRootNode) {
        this.isRootNode = isRootNode;
    }
    
    public ArrayList<ContactNode> getContact_node() {
        return child_node;
    }

    public void setContact_node(ArrayList<ContactNode> contact_node) {
        this.child_node = contact_node;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public ContactNode(Rung rung,Contact contact){
     child_node=new ArrayList();
     this.rung=rung;
     this.contact=contact;
     this.isRootNode=false;
    }
    
    public ContactNode(Rung rung){
        child_node=new ArrayList();
        this.isRootNode=true;
        this.rung=rung;
    }
}
