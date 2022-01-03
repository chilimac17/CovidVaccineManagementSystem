/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Covid19;

/**
 *
 * @author Admin
 */

import static Covid19.AdminstratorForm.jTableA2;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import static Covid19.ClinicianForm.jCTable;
import static Covid19.RecipientForm.infoBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ClinicianList<E> extends AbstractList<E> {
   private CNode<E> head;     

   // Constructs a new empty list.
   public ClinicianList() {
      head = null;
   }
  public void removeClinician(E newCID)
	{ 
	   
	   ClinicianList.CNode<E> current = head;
	   ClinicianList.CNode<E> temp = null;
	
		if(current != null && current.CID.equals(newCID)){
			
			head = current.next;
			return;
		}
		
		while(current != null && ! current.CID.equals(newCID)){
			temp = current;
			current = current.next;
			
			if(current == null){
				return;
			}
		}
		temp.next = current.next;
		
	}
public void addClinician(E a, E b,E c,E d, E e,E f) {
		ClinicianList.CNode<E> newCNode = new ClinicianList.CNode(a,b,c,d,e,f, null);
		if (head == null)
			head = newCNode;
		else {
			ClinicianList.CNode<E> temp = head;
			while (temp.next != null) 
				temp = temp.next;
			temp.next = newCNode;
		}
		}
    public void updateClinician(E newCID,E a, E b,E c,E d, E e,E f){
  
       ClinicianList.CNode<E> current = head;
	   ClinicianList.CNode<E> temp= null;
	   	   if(current == null ){
			return;
		}
  
		
		while(current != null ){
                      if (current.CID.equals(newCID))
                      {
                             current.CID=a;
                             current.CName=b;
                current.VC1=c;
                current.VC2=d;
                current.VC3=e;
                current.Total=f;
             
                return;
                      }
			current = current.next;
                }       
   }
   public E findTotalofVaccineName(E vname, E type) {
	   
	
	   
       ClinicianList.CNode<E> current = head;
	  
	   	  
		if(current.next == null){
		if (type.equals("Pfizer-BioNTech"))
                    return current.VC1;
                else if (type.equals("Moderna"))
                    return current.VC2;
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    return current.VC3;
                else if (type.equals("N/A"))
                    return current.Total;
                }
		while(current != null){
			if (current.CID.equals(vname)){
			if (type.equals("Pfizer-BioNTech"))
                    return current.VC1;
                else if (type.equals("Moderna"))
                    return current.VC2;
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    return current.VC3;
                         else if (type.equals("N/A"))
                    return current.Total;
			}
			current = current.next;
			}
			return null;
		}    
   
  public void updateAfterAppointment(E vCID, E type) {
       ClinicianList.CNode<E> current = head;
	  String c ;int i;
	   	  
		if(current.next == null){
		if (type.equals("Pfizer-BioNTech"))
                {   
                c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    {  c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                }
                c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                     return;
                }
		while(current != null){
                     if (current.CID.equals(vCID))
			if (type.equals("Pfizer-BioNTech"))
                {   
                   c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                   
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    { c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i-1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                    return;
                }
                
                   
			current = current.next;
			}
           
			}
  public boolean checkInventory(E vCID, E type) {
       ClinicianList.CNode<E> current = head;
	  String c ;int i;
	   	  
		if(current.next == null){
		if (type.equals("Pfizer-BioNTech"))
                {   
                c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i-1;
                    if (i<-1)
                   return true;
                   
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i-1;
                     if (i<-1)
                   return true;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    {  c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i-1;
                    if (i<-1)
                   return true;
                }
                }
		while(current != null){
                     if (current.CID.equals(vCID))
			if (type.equals("Pfizer-BioNTech"))
                {   
                   c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i-1;
                  if (i<-1)
                   return true;
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i-1;
                     if (i<-1)
                   return true; if (i<-1)
                   return true;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    { c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i-1;
                 if (i<-1)
                   return true;
                }
                
                   
			current = current.next;
			}
           return false;
			}
  public void updateAfterRemove(E vCID, E type) {
       ClinicianList.CNode<E> current = head;
	  String c ;int i;
	   	  
		if(current.next == null){
		if (type.equals("Pfizer-BioNTech"))
                {   
                c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    {  c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                }
                c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                     return;
                }
		while(current != null){
                     if (current.CID.equals(vCID))
			if (type.equals("Pfizer-BioNTech"))
                {   
                   c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                   
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    { c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                    return;
                }
                
                   
			current = current.next;
			}
           
			}
  /*public void changeAfterUpdate(E pRID, E pCID, E pVID, E cRID, E cCID, E cVID) {
        if (pRID.equals(cCID) && (pCID.equals(cCID)))
            return;
        if (pRID.equals(cRID))
        {
            if (! pCID.equals(cCID))
                    {
                        
                            this.updateAfterAppointment(cCID, cVID);
                            this.updateAfterRemove(pCID, pVID);
                        
                    }
            
        }
        
        else 
        {
        
        }
     
      
      
      
      
      
      
      
      
      ClinicianList.CNode<E> current = head;
	  String c ;int i;
	   	  
		if(current.next == null){
		if (type.equals("Pfizer-BioNTech"))
                {   
                c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    {  c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                }
                c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                     return;
                }
		while(current != null){
                     if (current.CID.equals(vCID))
			if (type.equals("Pfizer-BioNTech"))
                {   
                   c = (String) current.VC1;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC1= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                   
                }
                else if (type.equals("Moderna"))
                    {   c = (String) current.VC2;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC2= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                }
                else if (type.equals("Johnson & Johnson’s Janssen"))
                    { c = (String) current.VC3;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.VC3= (E) c;
                    c = (String) current.Total;
                i=Integer.parseInt(c);  
                    i=i+1;
                    c=String.valueOf(i);
                    current.Total= (E) c;
                    return;
                }
                
                   
			current = current.next;
			}
           
			}
  */
public void writeFile()
        {  
            try {
                FileWriter br = new FileWriter("Clinician.txt");
                BufferedWriter brw = new BufferedWriter(br);
                CNode<E> temp = head;
		while ( temp != null)                
		{ 
                  brw.write(temp.CID+","+ temp.CName+","+temp.VC1+","+temp.VC2+","+temp.VC3+","+temp.Total);
                  brw.newLine();
			temp = temp.next;
		}
                 
                brw.close();
                br.close();
              
                
            
            } catch (IOException ex) {
              infoBox("ERROR","ERROR MESSAGE");
            }
		
        }	
	
   public E get(int index) {
      CNode<E> current = head;
      for(int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.CID;
   }
    
 public void display()
	{        DefaultTableModel model = (DefaultTableModel)jCTable.getModel();
         if (model.getRowCount() > 0)        
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
              
              
		CNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.CID, temp.CName,temp.VC1,temp.VC2,temp.VC3, temp.Total});
                 
			temp = temp.next;
		}
     
	}
  public void displayTable(DefaultTableModel model)
        {  
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
		ClinicianList.CNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.CID, temp.CName,temp.VC1,temp.VC2,temp.VC3, temp.Total});
                 
			temp = temp.next;
		}
        }
	
  
   public int size() {
      int count = 0;
      CNode<E> current = head;
      while (current != null) {
         current = current.next;
         count++;
      }
      return count;
   }
    
   
   

   private static class CNode<E> {

       public CNode<E> next;
       public E CID;
       public E CName;
      public E	VC1;
      public E VC2;
      public E VC3;
      public E Total;
      
      public CNode(E a, E b,E c,E d, E e,E f) {
         this(a,b,c,d,e,f, null);
      }
	  
      public CNode(E a, E b,E c,E d, E e,E f, CNode next) {
       this.CID=a;
       this.CName=b;
       this.VC1=c;
       this.VC2=d;
       this.VC3=e;
       this.Total=f;
         this.next = next;
      }
   }
 //  
  
}
