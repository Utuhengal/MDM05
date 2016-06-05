package view;

/**
 *
 * @author Edward
 */
public class SimpleView {    
   
public static void showOption () {    
 System.out.println("Select option:");
 System.out.println("1 - Enter data manually");
 System.out.println("2 - Read data from the file");
 System.out.println("3 - Read data from the site: otodom.pl");

}

public static void showPrice() {
    System.out.println("Price of the flat:");
}

public static void typePrice () {
    System.out.println("Provide price of the flat:");
}

public static void sumOfmeters () {
    System.out.println("Total size of the flat (m2):");
}

public static void isEligible () {
System.out.println("Flat is eligible for MDM program");
}

public static void isNotEligible () {
System.out.println("Flat is not eligible for MDM program");
}

}
