
package mmdcalculator;
import model.*;
import view.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.regex.Pattern;
/**
 *
 * @author Edward
 */
public class MmdCalculator {
public static double dPriceFromTxt;
public static double dSizeFromTxt;

public static void main(String[] args) throws FileNotFoundException, IOException  {  
    
     SimpleView.showOption();
     Scanner in = new Scanner (System.in);       
     
     int press = in.nextInt(); 
     
     switch (press) {
     
        case 1:
              
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
                
                System.out.println("Укажите путь к файлу");
                Scanner txt = new Scanner(System.in);
                String txtfilename = in.next();

           BufferedReader rd = new BufferedReader(new FileReader(txtfilename));
           
           {
            String s;
            while ((s = rd.readLine()) != null) {
         
        Pattern iniPrice = Pattern.compile("Price(\\:|\\s?)\\d+(,|\\.|\\s|)\\d+");     
        Matcher matchPrice = iniPrice.matcher(s);
        while (matchPrice.find()) {
        String PriceGroup = matchPrice.group();
        
        Pattern iniPrice2 = Pattern.compile("\\D");
        Matcher matchPrice2 = iniPrice2.matcher(PriceGroup);
        
        String txtPrice = matchPrice2.replaceAll("");
        
        MmdCalculator.dPriceFromTxt = Double.parseDouble(txtPrice);
        }

{
        
        Pattern iniSize = Pattern.compile("Size(\\:|\\s?)\\d+(,|\\.|\\s|)\\d+");     
        Matcher matchSize = iniSize.matcher(s.replace(",", "."));
        while (matchSize.find()) {
        String SizeGroup = matchSize.group();        
        Pattern iniSize2 = Pattern.compile("[^\\d ,]".replace(",", "\\."));            
        Matcher matchSize2 = iniSize2.matcher(SizeGroup);        
        String txtSize = matchSize2.replaceAll("");
        
        MmdCalculator.dSizeFromTxt = Double.parseDouble(txtSize);                
        
        Flat fromTxt = new Flat(dPriceFromTxt, dSizeFromTxt);                 
                
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
    
        }
        
            }
        
           }  
                   break;  

           }
            case 3: 
 
 Scanner forUrl = new Scanner(System.in);
 System.out.println("Введите ссылку на URL с сайта http://otodom.pl");
 String url = forUrl.nextLine();
 
 Document doc = Jsoup.connect(url).get();
  
 Elements elemPrice = doc.select(".box-price-value");
 
 Elements elemSize = doc.select("div.area-lane > span.big");
  
 String IniPrice = elemPrice.first().text();
 String IniSize = elemSize.text();
 
 String forPatter = "[^0-9 , ]".replaceAll("\\s",""); 
 Pattern pattern = Pattern.compile(forPatter); 
 
 Matcher priceMatch = pattern.matcher(IniPrice); 
 Matcher sizeMatch = pattern.matcher(IniSize);

 String PriceFromUrl = priceMatch.replaceAll("");
 
 String SizeFromUrl = sizeMatch.replaceAll("");

   try {
  
     Double dPriceFromUrl = Double.parseDouble(PriceFromUrl.replace(",", "."));    
       
     Double dSizeFromUrl = Double.parseDouble(SizeFromUrl.replace(",", "."));  
       
     Flat fUrl = new Flat(dPriceFromUrl,dSizeFromUrl);
                fUrl.getValue();
                fUrl.showMediumprice();
                fUrl.showDifference();            
            
            
        if (fUrl.getMediumPrice() <= Flat.mdmMetr) 
        {
            
        SimpleView.isEligible();
        } else 
            
        {
        SimpleView.isNotEligible();
        }              
       break;  

  } catch (NumberFormatException e) {
      System.out.println("Something is going wrong");
  }
    
      }
    }
}