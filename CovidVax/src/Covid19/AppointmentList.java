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

import static Covid19.AdminstratorForm.jTableA3;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import static Covid19.AppointmentForm.jATable;
import static Covid19.RecipientForm.infoBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;



public class AppointmentList<E> extends AbstractList<E> {
   private ApptNode<E> head;     

 
   public AppointmentList() {
      head = null;
   }
  
   
    public void removeAppointment(E newAID)
	{ 
	   
	   AppointmentList.ApptNode<E> current = head;
	   AppointmentList.ApptNode<E> temp = null;
	
		if(current != null && current.AptID.equals(newAID)){
			
			head = current.next;
			return;
		}
		
		while(current != null && ! current.AptID.equals(newAID)){
			temp = current;
			current = current.next;
			
			if(current == null){
				return;
			}
		}
		temp.next = current.next;
		
	}
public void addAppointment(E a, E b,E c,E d, E e,E f) {
		AppointmentList.ApptNode<E> ApptNode = new AppointmentList.ApptNode(a,b,c,d,e,f, null);
		if (head == null)
			head = ApptNode;
		else {
			AppointmentList.ApptNode<E> temp = head;
			while (temp.next != null) 
				temp = temp.next;
			temp.next = ApptNode;
		}
		}
    public void updateAppointment(E newAID,E a, E b,E c,E d, E e,E f){
  
       AppointmentList.ApptNode<E> current = head;
	   AppointmentList.ApptNode<E> temp= null;
	   	   if(current == null ){
			return;
		}
  
		
		while(current != null ){
                      if (current.AptID.equals(newAID))
                      {
                             current.AptID=a;
                             current.RtID=b;
                current.CtID=c;
                current.vName=d;
                current.Dose=e;
                current.AppTime=f;
             
                return;
                      }
			current = current.next;
                }       
   }
  public boolean checkAppointmentFull(E vCID){
      int count=0;
     DefaultTableModel model = (DefaultTableModel)jATable.getModel();
         for (int i = 0; i <model.getRowCount();i++)
         {
              if (model.getValueAt(i, 2).toString().equals(vCID))
                    count++  ;
              if (count>=10)
                  return true;
         }
         return false;
             
  }
  public boolean checkRecipientFull(E vRID){
      int count=0;
     DefaultTableModel model = (DefaultTableModel)jATable.getModel();
         for (int i = 0; i <model.getRowCount();i++)
         {
              if (model.getValueAt(i, 1).toString().equals(vRID))
                    count++  ;
              if (count>=1)
                  return true;
         }
         return false;
             
  }
 
   public E get(int index) {
      ApptNode<E> current = head;
      for(int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.AptID;
   }
public void display()
	{DefaultTableModel model = (DefaultTableModel)jATable.getModel();
         if (model.getRowCount() > 0)        
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
               
              
		AppointmentList.ApptNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.AptID, temp.RtID,temp.CtID,temp.vName,temp.Dose, temp.AppTime});
			temp = temp.next;
		}
     
	}
   public void displayTable(DefaultTableModel model)
        {  
        while(model.getRowCount() > 0)
         {
            model.removeRow(0);
                }
		AppointmentList.ApptNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  model.addRow(new Object[]{temp.AptID, temp.RtID,temp.CtID,temp.vName,temp.Dose, temp.AppTime});
			temp = temp.next;
		}
        }
public void writeFile()
        {  
            try {
                FileWriter br = new FileWriter("Appointment.txt");
                BufferedWriter brw = new BufferedWriter(br);
                AppointmentList.ApptNode<E> temp = head;
		while ( temp != null)                
		{ 
                  
                  brw.write(temp.AptID+","+temp.RtID+","+temp.CtID+","+temp.vName+","+temp.Dose+","+ temp.AppTime);
                  brw.newLine();
			temp = temp.next;
		}
                 
                brw.close();
                br.close();
              
                

            } catch (IOException ex) {
              infoBox("ERROR","ERROR MESSAGE");
            }
		
        }	
	

   public int size() {
      int count = 0;
      ApptNode<E> current = head;
      while (current != null) {
         current = current.next;
         count++;
      }
      return count;
   }

   
   
   

 
   private static class ApptNode<E> {

       public ApptNode<E> next;
       public E AptID;
       public E RtID;
       public E CtID;
       public E vName;
       public E Dose;
       public E AppTime;
       
      public ApptNode(E a,E b, E c, E d, E e, E f) {
         this(a,b,c,d,e,f, null);
      }
	  
      public ApptNode(E a, E b,E c, E d,E e, E f, ApptNode next) {
         this.AptID=a;
         this.RtID=b;
         this.CtID=c;
         this.vName=d;
         this.Dose=e;
         this.AppTime=f;
         this.next = next;
      }
   }
 //  
  
}
