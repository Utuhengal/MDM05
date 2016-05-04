
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FromTxt {
    
   private static double dPriceFromTxt;
   private static double dSizeFromTxt;
   
public void readTxt() throws IOException, FileNotFoundException {
    
    System.out.println("Укажите путь к файлу");
    Scanner in = new Scanner (System.in);     

         Scanner txt = new Scanner(System.in);
         String txtfilename = in.next();
   
       BufferedReader rd= new BufferedReader(new FileReader(txtfilename));

            String s;
          
            while ((s = rd.readLine()) != null)
                  
            {
        Pattern iniPrice = Pattern.compile("Price(\\:|\\s?)\\d+(,|\\.|\\s|)\\d+");     
        Matcher matchPrice = iniPrice.matcher(s);
        while (matchPrice.find()) {
        String PriceGroup = matchPrice.group();
        
        Pattern iniPrice2 = Pattern.compile("\\D");
        Matcher matchPrice2 = iniPrice2.matcher(PriceGroup);
        
        String txtPrice = matchPrice2.replaceAll("");
        
        dPriceFromTxt = Double.parseDouble(txtPrice);

       
        }     
                  
            {
        Pattern iniSize = Pattern.compile("Size(\\:|\\s?)\\d+(,|\\.|\\s|)\\d+");     
        Matcher matchSize = iniSize.matcher(s.replace(",", "."));
        while (matchSize.find()) {
        String SizeGroup = matchSize.group();        
        Pattern iniSize2 = Pattern.compile("[^\\d ,]".replace(",", "\\."));            
        Matcher matchSize2 = iniSize2.matcher(SizeGroup);        
        String txtSize = matchSize2.replaceAll("");
        
         dSizeFromTxt = Double.parseDouble(txtSize);                   
   
}

            }
         
            }
      
}
public double getDPriceFromTxt () {
        return dPriceFromTxt;
        }
        
public double getDSizeFromTxt () {
        return dSizeFromTxt;
        }
        
}





           
                     

           
    
    

