/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simduino;

import java.util.ArrayList;
import java.util.Iterator;
import java_cup.runtime.lr_parser;

/**
 *
 * @author melix
 */
public class ContactNode {    

    private ArrayList<ContactNode> child_node;

    private Rung rung;
    private boolean isRootNode;
    private Contact contact;
    
    private ArrayList<Contact> findContactWithSource(Rung rung,int from){
        ArrayList<Contact> contact_found=new ArrayList<>();
	for(Contact cnt: rung.getSection1()){
	    if(cnt.getFrom()==from){
		contact_found.add(cnt);
	    }
	}
	return contact_found;
    }
   
    public boolean buildTree(int from,int maxTo){
       ArrayList<Contact> contact_found=new ArrayList<>();
       contact_found=findContactWithSource(rung,from);
       
       if(!(contact_found.isEmpty()&&from<maxTo)){
        for(Contact cnt:contact_found){
            ContactNode child=new ContactNode(rung,cnt);
            child_node.add(child);
            if(!child.buildTree(from+1,maxTo))
                return false;
        }
       }else{
         return false;
       }
       
       return true;
    }
   
    @Override
    public String toString(){
     String str="";
     
     boolean isFirst=true;
     for(ContactNode cnt:child_node){
            if(isFirst)
                isFirst=false;
            else{
                 str=str+"||";
            }
         if(!isRootNode){
            if(contact.getType()==0)
             str=str+cnt.toString()+"&&var"+String.valueOf(contact.getPort())+"==HIGH";
            else if(contact.getType()==1)
             str=str+cnt.toString()+"&&var"+"!("+String.valueOf(contact.getPort())+"==HIGH)"; 
         }else{
            str=str+cnt.toString();
         }
     }
     
     if(child_node.isEmpty()&&!isRootNode)
         if(contact.getType()==0)
            str="var"+String.valueOf(contact.getPort())+"==HIGH";
         else if(contact.getType()==1)
            str="!(var"+String.valueOf(contact.getPort())+"==HIGH)";
   
     return str;
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
