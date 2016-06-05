
package mmdcalculator;
import model.*;
import view.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Edward
 * 
 */
public class MmdCalculator {


public static void main(String[] args) throws FileNotFoundException, IOException  {  
    
     SimpleView.showOption();
     
     try {
     Scanner in = new Scanner (System.in);       
     
     int press = in.nextInt(); 
     
     switch (press) {
     
        case 1:
             //values from keybord
            
            Flat fromKeybord = new Flat();                 
                
                fromKeybord.getValue();
                fromKeybord.showMediumprice();
                fromKeybord.showDifference();            
       
        if (fromKeybord.getMediumPrice() <= Flat.mdmMetr) 
        {
            
        SimpleView.isEligible();
        } else 
            
        {
        SimpleView.isNotEligible();
        }       
        
       break;    
       
        
            case 2:                
                //values from txt file
                FromTxt uie = new FromTxt();
                try {
                uie.readTxt();
                }catch (FileNotFoundException e) {System.out.println("File was not found");
                MmdCalculator.main(args);

                return;
               
                }
                
                double flprice = uie.getDPriceFromTxt();
                double flsize = uie.getDSizeFromTxt();
                
                Flat fromTxt = new Flat(flprice, flsize);
                
                fromTxt.getValue();
                fromTxt.showMediumprice();
                fromTxt.showDifference();            
       
        if (fromTxt.getMediumPrice() <= Flat.mdmMetr) 
        {
            
        SimpleView.isEligible();
        } else 
            
        {
        SimpleView.isNotEligible();
        }          
     break;
            case 3 :
       //values from URL (otodom.pl)
                FromUrl fromUrl = new FromUrl();
                fromUrl.readUrl();
                
                double urlsize = fromUrl.getdSizeFromUrl();
                double urlprice = fromUrl.getdPriceFromUrl();
                
                
                Flat frurl = new Flat(urlprice, urlsize);
                
                frurl.getValue();
                frurl.showMediumprice();
                frurl.showDifference();            
       
        if (frurl.getMediumPrice() <= Flat.mdmMetr) 
        {
            
        SimpleView.isEligible();
        } else 
            
        {
        SimpleView.isNotEligible();
        } 
        break;
           
        default:
            System.out.println("Wrong number");
            MmdCalculator.main(args);
     }
     } catch (InputMismatchException |IOException |IllegalArgumentException e) {System.out.println("Something is going wrong");
     MmdCalculator.main(args);
   
}

}
}