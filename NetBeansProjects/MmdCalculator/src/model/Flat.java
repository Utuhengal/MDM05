package model;
import java.util.Scanner;
import view.*;

/**
 *
 * @author Edward
 */
public class Flat {   
    
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
        System.out.println("Средняя цена за метр квадратный "+ getMediumPrice());
    }
    
    public double getDifference () {
    return mdmMetr - getMediumPrice();      
    }
    
     public void showDifference () {
     System.out.println("Разница между МДМ м2 " + getDifference());
    }
     
     public double getValue () {
    
    return value;
    }
  
   
  
    
}