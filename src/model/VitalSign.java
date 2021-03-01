/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static java.lang.Double.POSITIVE_INFINITY;
import java.util.*;
/**
 *
 * @author reaso
 */
public class VitalSign {
    String date;
    HashMap<String,ArrayList<Range>> tableMap = new HashMap<String,ArrayList<Range>>();
    String ageGroup;
    double respiratoryRate;
    double heartRate;
    double systolicBloodPressure;
    double weightInKilos;
    double weightInPounds;
    
    public VitalSign(String date,
                     String ageGroup,
    double respiratoryRate,
    double heartRate,
    double systolicBloodPressure,
    double weightInKilos,
    double weightInPounds) {
        ArrayList<Range>  newBorn = new ArrayList<Range>(Arrays.asList(new Range(30,50),new Range(120,160),new Range(50,70),new Range(2,3),new Range(4.5,7)));
        ArrayList<Range>  infant = new ArrayList<Range>(Arrays.asList(new Range(20,30),new Range(80,140),new Range(70,100),new Range(4,110),new Range(9,22)));
        ArrayList<Range>  toddler = new ArrayList<Range>(Arrays.asList(new Range(20,30),new Range(80,130),new Range(80,110),new Range(10,14),new Range(22,31)));
        ArrayList<Range>  preschooler = new ArrayList<Range>(Arrays.asList(new Range(20,30),new Range(80,120),new Range(80,110),new Range(14,18),new Range(31,40)));
        ArrayList<Range>  schoolAge = new ArrayList<Range>(Arrays.asList(new Range(20,30),new Range(70,110),new Range(80,120),new Range(20,42),new Range(41,92)));
        ArrayList<Range>  adolescent = new ArrayList<Range>(Arrays.asList(new Range(12,20),new Range(55,102),new Range(110,120),new Range(50,POSITIVE_INFINITY),new Range(110,POSITIVE_INFINITY)));
        tableMap.put("newBorn",newBorn);
        tableMap.put("infant",infant);
        tableMap.put("toddler",toddler);
        tableMap.put("preschooler",preschooler);
        tableMap.put("schoolAge",schoolAge);
        tableMap.put("adolescent",adolescent);
        this.date = date;
        this.ageGroup = ageGroup;
        this.respiratoryRate = respiratoryRate;
        this.heartRate = heartRate;
        this.systolicBloodPressure = systolicBloodPressure;
        this.weightInKilos = weightInKilos;
        this.weightInPounds = weightInPounds;
    }
    
    boolean vitalIsNormal( ) {
        ArrayList<Range> patienVitaltList = tableMap.get(this.ageGroup);
        if (!patienVitaltList.get(0).isInRange(this.respiratoryRate)) {
            return false;
        }
        if (!patienVitaltList.get(1).isInRange(this.heartRate)) {
            return false;
        }
        if (!patienVitaltList.get(2).isInRange(this.systolicBloodPressure)) {
            return false;
        }
        if (!patienVitaltList.get(3).isInRange(this.weightInKilos)) {
            return false;
        }
        if (!patienVitaltList.get(4).isInRange(this.weightInPounds)) {
            return false;
        }
        
        return true;
         
    }
    public boolean isThisVitalSignNormal(String input)  {
        ArrayList<Range> patienVitaltList = tableMap.get(this.ageGroup);
        if (input.equals("respiratoryRate")) {
            return patienVitaltList.get(0).isInRange(this.respiratoryRate);
        }
        if (input.equals("heartRate")) {
           return patienVitaltList.get(1).isInRange(this.heartRate);
        }
        if (input.equals("systolicBloodPressure")) {
           return patienVitaltList.get(2).isInRange(this.systolicBloodPressure);
        }
        if (input.equals("weightInKilos")) {
           return patienVitaltList.get(3).isInRange(this.weightInKilos);
        }
        if (input.equals("weightInPounds")) {
           return patienVitaltList.get(4).isInRange(this.weightInPounds);
        }
        return false;
    }
    

    public String getDate() {
        return date;
    }

    public HashMap<String, ArrayList<Range>> getTableMap() {
        return tableMap;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public double getRespiratoryRate() {
        return respiratoryRate;
    }

    public double getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }
    
    public String toString(){
    String toPrint = this.date + " RespiratoryRate: " + this.respiratoryRate + "; HeartRate: " + this.heartRate + "; SystolicBloodPressure: " +
                     this.systolicBloodPressure + "; WeightInKilos: " + this.weightInKilos+ "; WeightInPounds: " + this.weightInPounds;
    return toPrint;
    }
    
}
