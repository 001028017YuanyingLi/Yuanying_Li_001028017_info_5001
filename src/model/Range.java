/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author reaso
 */
public class Range {
    double low;
    double high;
    
    public Range(double low, double high) {
        this.low = low;
        this.high = high;    
    } 
    
    public boolean isInRange(double input) {
        if (input < low || input > high) {
            return false;
        } 
        return true;
    }
    
}
