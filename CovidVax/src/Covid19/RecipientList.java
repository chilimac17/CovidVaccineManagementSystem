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
import static Covid19.AdminstratorForm.adminList;
import static Covid19.AdminstratorForm.jTableA1;
import static Covid19.ClinicianForm.jCTable;
import static Covid19.RecipientForm.infoBox;
import java.awt.ComponentOrientation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import static Covid19.RecipientForm.jRTable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RecipientList<E> extends AbstractList<E> {
   private RNode<E> head;     

   public RecipientList() {
      head = null;
   }

   public void removeRecipient(E newRID)
	{ 
	   
	   RNode<E> current = head;
	   RNode<E> temp = null;
	
		if(current != null && current.RID.equals(newRID)){
			
			head = current.next;
			return;
		}
		
		while(current != null && ! current.RID.equals(newRID)){
			temp = current;
			current = current.next;
			
			if(current == null){
				return;
			}
		}
		temp.next = current.next;
		
	}
   
   public void addRecipient(E a,E b, E c, E d, E e,E f, E g,E h, E i,E j,E k,E l, E m) {
		RNode<E> newRNode = new RNode(a, b, c, d, e,f,g,h,i,j,k,l,m, null);
		if (head == null)
                {
                    head = newRNode;
                }
		else {
			RNode<E> temp = head;
			while (temp.next != null) 
                        { 
			 temp = temp.next;
                        }
			
                        temp.next = newRNode;
		}
		}
 
   
   public void updateRecipient(E newRID,E a,E b, E c, E d, E e,E f, E g,E h, E i,E j,E k,E l,E m){
  
       RNode<E> current = head;
	   RNode<E> temp= null;
	   	   if(current == null ){
			return;
		}
 
		while(current != null ){
                      if (current.RID.equals(newRID))
                      {
                             current.RID=a;
                             current.RName=b;
                current.DOB=c;
                current.sex=d;
                current.address=e;
                current.preQ1=f;
                current.preQ2=g;
                current.preQ3=h;
                current.preQ4=i;
                current.preQ5=j;
                current.preQ6=k;
                current.preCDose=l;
                current.numDose=m;
                return;
                      }
			current = current.next;
                }       
   }
 public E findVaccineName(E vRID) {
	   
	
	   RNode<E> current = head;
	  
	   	  
		if(current.next == null)
			return current.preCDose;
		while(current != null){
			if (current.RID.equals(vRID)){
			return current.preCDose;
			}
			
			current = current.next;
			}
			return null;
		}	
    public E findDose(E vDose) {
	   
	
	   RNode<E> current = head;
	  
	   	  
		if(current.next == null)
			return current.numDose;
		while(current != null){
			if (current.RID.equals(vDose)){
			return current.numDose;
			}
			
			current = current.next;
			}
			return null;
		}                  
   public E get(int index) {
      RNode<E> current = head;
      for(int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.RID;
   }

   public void display()
        {   
	
        DefaultTableModel model = (DefaultTableModel)jRTable.getModel();
           if (model.getRowCount() > 0)
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
           
         DefaultTableModel model1 = (DefaultTableModel)jTableA1.getModel();
          if (model1.getRowCount() > 0)       
        while(model1.getRowCount() > 0)
         {
            model1.removeRow(0);
                }      
           
		RNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.RID, temp.RName,temp.DOB,temp.sex,temp.address, temp.preQ1,temp.preQ2,temp.preQ3,temp.preQ4,temp.preQ5,temp.preQ6,temp.preCDose,temp.numDose});
                  model1.addRow(new Object[]{temp.RID, temp.RName,temp.DOB,temp.sex,temp.address, temp.preQ1,temp.preQ2,temp.preQ3,temp.preQ4,temp.preQ5,temp.preQ6,temp.preCDose,temp.numDose});
		
                  temp = temp.next;
		}
        }
	public void displayTable(DefaultTableModel model)
        {  
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
		RNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.RID, temp.RName,temp.DOB,temp.sex,temp.address, temp.preQ1,temp.preQ2,temp.preQ3,temp.preQ4,temp.preQ5,temp.preQ6,temp.preCDose,temp.numDose});
                  temp = temp.next;
		}
        }
  public void writeFile()
        {  
            try {
                FileWriter br = new FileWriter("Recipient.txt");
                BufferedWriter brw = new BufferedWriter(br);
                RNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  brw.write(temp.RID+","+ temp.RName+","+temp.DOB+","+temp.sex+","+temp.address+","+ temp.preQ1+","+temp.preQ2+","+temp.preQ3+","+temp.preQ4+","+temp.preQ5+","+temp.preQ6+","+temp.preCDose+","+temp.numDose);
                  brw.newLine();
			temp = temp.next;
		}
                 
                brw.close();
                br.close();
              
                
            infoBox("SUCCESSFULLY SAVED","INFORMATION");
            } catch (IOException ex) {
              infoBox("ERROR","ERROR MESSAGE");
            }
		
        }	
	
  
   public int size() {
      int count = 0;
      RNode<E> current = head;
      while (current != null) {
         current = current.next;
         count++;
      }
      return count;
   }
    
   
   

  
   private static class RNode<E> {

       
	public RNode<E> next;
       public E RID;
       public E RName;
       public E DOB;
       public E sex;
       public E address;
       public E preQ1;
       public E preQ2;
       public E preQ3;
       public E preQ4;
       public E preQ5;
       public E preQ6;
       public E numDose;
       public E preCDose;
      
      public RNode(E a,E b, E c, E d, E e,E f, E g,E h, E i,E j,E k,E l,E m) {
         this(a, b, c, d, e,f,g,h,i,j,k,l,m, null);
         
      }
	  
      public RNode(E a,E b, E c, E d, E e,E f, E g,E h, E i,E j,E k,E l,E m, RNode next) {
    	  this.RID=a;
          this.RName=b;
          this.DOB=c;
          this.sex=d;
          this.address=e;
          this.preQ1=f;
          this.preQ2=g;
          this.preQ3=h;
          this.preQ4=i;
          this.preQ5=j;
          this.preQ6=k;
          
         
          this.preCDose=l;
          this.numDose=m;
         this.next = next;
      }
   }
 //  





  
}