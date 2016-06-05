package model;
import java.util.Scanner;
import view.*;

/**
 *
 * @author Edward
 */
public class Flat {   
    
    //max price of 1 m2 for MDM-program
    public static double mdmMetr = 5247.00;

    private final double value;
    private final double metr;
    private boolean orItsMdm;
    private double mediumprice;  
    
    
    Scanner in = new Scanner(System.in);

    public Flat () {
    
    SimpleView.typePrice();    
    this.value = in.nextDouble();
    
    SimpleView.sumOfmeters();
    this.metr = in.nextDouble();
    }

    public Flat(double value, double metr) {
  
        this.value = value;
        this.metr = metr;
        
    }
    
    public double getMediumPrice() {        
    double mediumprice = this.value/this.metr;    
    return mediumprice;     
    
    }
    
    public void showMediumprice() {
        System.out.println("Average price of the 1 m2: "+ getMediumPrice());
    }
    
    public double getDifference () {
    return mdmMetr - getMediumPrice();      
    }
    
     public void showDifference () {
     System.out.println("Difference between current price of 1 m2 and max price of 1 m2 MDM: " + getDifference());
    }
     
     public double getValue () {
    
    return value;
    }
  
   
  
    
}