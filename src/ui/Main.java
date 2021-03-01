/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import model.*;
import java.util.*;
/**
 *
 * @author Yuanying Li  - INFO 5001 - Assignment 3
 */
public class Main {
    public static void main(String[] args) {
        
        // part 1
        VitalSign lilyVitaiSign = new VitalSign("1/1/2022","newBorn", 40, 130, 60, 2.2, 5);
        Patient patient1 = new Patient("Lily", lilyVitaiSign);
        patient1.newVitalSign("2/25/2022","newBorn", 14, 130, 60, 2.2, 5);
        patient1.newVitalSign("2/13/2022","newBorn", 29, 100, 85, 16, 36);
        patient1.newVitalSign("2/15/2022","newBorn", 21, 75, 110, 30, 80);
        patient1.newVitalSign("2/28/2022","newBorn", 5555, 89, 130, 60, 120);
        
        
        VitalSign tomVitaiSign = new VitalSign("1/2/2022", "infant", 28, 140, 80, 8, 19);
        Patient patient2 = new Patient("Tom", tomVitaiSign);
        patient2.newVitalSign("2/27/2022","infant", 30, 131, 81, 9, 11);
        patient2.newVitalSign("2/28/2022","infant", 29, 132, 85, 8, 21);
        
        VitalSign jerryVitaiSign = new VitalSign("1/5/2022", "toddler", 26, 90, 100, 13, 25);
        Patient patient3 = new Patient("Jerry", jerryVitaiSign);
        patient3.newVitalSign("2/27/2022","toddler", 21, 96, 86, 13, 26);
        patient3.newVitalSign("2/28/2022","toddler", 27, 100, 91, 13, 27);
        
        VitalSign shawnVitaiSign = new VitalSign("1/6/2022", "preschooler", 29, 100, 85, 16, 36);
        Patient patient4 = new Patient("Shawn", shawnVitaiSign);
        patient4.newVitalSign("2/13/2022","preschooler", 26, 100, 87, 17, 35);
        patient4.newVitalSign("3/1/2022","preschooler", 27, 110, 90, 16, 32);
        
        VitalSign kristyVitaiSign = new VitalSign("2/2/2022", "schoolAge", 21, 75, 110, 30, 80);
        Patient patient5 = new Patient("Kristy", kristyVitaiSign);
        patient5.newVitalSign("2/15/2022","schoolAge", 24, 80, 111, 24, 55);
        patient5.newVitalSign("3/12/2022","schoolAge", 26, 90, 116, 41, 91);
        
        VitalSign jasonVitaiSign = new VitalSign("2/26/2022","adolescent", 18, 89, 130, 60, 120);
        Patient patient6 = new Patient("Jason", jasonVitaiSign);
        patient6.newVitalSign("2/27/2022","adolescent", 19, 101, 115, 60, 120);
        patient6.newVitalSign("2/28/2022","adolescent", 16, 56, 115, 40, 140);
        
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);
        patientList.add(patient5);
        patientList.add(patient6);
       
        System.out.println("----Part 1 : whether patient is normal----");
        for(Patient patient : patientList) {
                 if (patient.isPatientNormal() == true){
                     System.out.println("This patient " + patient.getName() + " is normal");
                 } else {
                        System.out.println("This patient " + patient.getName()+ " is abnormal");;
                    }
            }  
            
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        // part 2 and continue
        System.out.println("----Part 2 and Part 2 Continue: patient history and  if vital sign attributes is normal----");
        
        for (int i = 0; i < patientList.size();i++){
            System.out.println("----------------------------------------------------------");
            System.out.println("Patient name: " + patientList.get(i).getName());
            System.out.println("Age Group: " + patientList.get(i).getVitalSignList().get(patientList.get(i).getVitalSignList().size() - 1).getAgeGroup());
            System.out.println("VitalSign History: ");
            ArrayList<VitalSign> patientListHistory = patientList.get(i).getVitalSignList();
            for (int j = 0; j < patientListHistory.size(); j++) {
                System.out.println("Patient vitual sign " + j + ": " + patientListHistory.get(j));
            }
            System.out.println(); 
            VitalSign currentVitalSign = patientList.get(i).getVitalSignList().get(patientList.get(i).getVitalSignList().size() - 1);
            System.out.println("Latest VitalSign History: " + currentVitalSign);
            System.out.println(); 
            System.out.println("Vital Sign Warnings: "); 
            boolean hasIssue = false;
            
            if (patientList.get(i).isThisVitalSignNormal("respiratoryRate") == false) {
                hasIssue = true;
                System.out.println("Attention!!! respiratoryRate is abnormal, curret value is " + currentVitalSign.getRespiratoryRate());    
            } 
            if (patientList.get(i).isThisVitalSignNormal("heartRate") == false) {
               hasIssue = true;
               System.out.println("Attention!!! heartRate is abnormal, curret value is " + currentVitalSign.getHeartRate());
            }
            if (patientList.get(i).isThisVitalSignNormal("systolicBloodPressure") == false) {
               hasIssue = true;
               System.out.println("Attention!!! systolicBloodPressure is abnormal, current value is " + currentVitalSign.getSystolicBloodPressure());
            } 
            if (patientList.get(i).isThisVitalSignNormal("weightInKilos") == false) {
               hasIssue = true;
               System.out.println("Attention!!! weightInKilos is abnormal, curret value is " + currentVitalSign.getWeightInKilos());
            } 
            if (patientList.get(i).isThisVitalSignNormal("weightInPounds") == false) {
               hasIssue = true;
               System.out.println("Attention!!! weightInPounds is abnormal, curret value is " + currentVitalSign.getWeightInPounds());
            } 
            if (hasIssue == false) {
               System.out.println("Null");
            }
            System.out.println();    
        }
        System.out.println(); 
    }
}
