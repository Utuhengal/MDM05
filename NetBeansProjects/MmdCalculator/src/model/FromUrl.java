
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class FromUrl {
private static double dPriceFromUrl;
private static double dSizeFromUrl;

public  void readUrl () throws FileNotFoundException, IOException  {  

 Scanner forUrl = new Scanner(System.in);
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

  
  dPriceFromUrl = Double.valueOf(PriceFromUrl.replace(",", "."));    
       
  dSizeFromUrl = Double.valueOf(SizeFromUrl.replace(",", "."));  
       

  }  
    
public double getdPriceFromUrl () {
        return dPriceFromUrl;
        }

public double getdSizeFromUrl () {
        return dSizeFromUrl;
        }

        }
    

