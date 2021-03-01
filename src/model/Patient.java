/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;

/**
 *
 * @author reaso
 */
public class Patient {
    String name;
    ArrayList<VitalSign> vitalSignList;
 
    public Patient(String name, VitalSign vitalSigntable) {
        this.name = name;
        this.vitalSignList = new ArrayList<>();
        this.vitalSignList.add(vitalSigntable);
    }
    
    public boolean isPatientNormal() {
        return this.vitalSignList.get(this.vitalSignList.size() - 1).vitalIsNormal();
    }    
    
    public VitalSign newVitalSign(String date,
                                  String ageGroup,
                                  double respiratoryRate,
                                  double heartRate,
                                  double systolicBloodPressure,
                                  double weightInKilos,
                                  double weightInPounds) {
        VitalSign current =  new VitalSign(date,
                                           ageGroup,
                                           respiratoryRate,
                                           heartRate,
                                           systolicBloodPressure,
                                           weightInKilos,
                                           weightInPounds);
        vitalSignList.add(current);
        return current;
    }
    
    public boolean isThisVitalSignNormal(String input)  {
        return this.vitalSignList.get(this.vitalSignList.size() - 1).isThisVitalSignNormal(input);
    }

    public String getName() {
        return name;
    }

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }
    
    
}
