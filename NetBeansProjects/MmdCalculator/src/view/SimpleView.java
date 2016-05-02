package view;
import model.Flat;
import mmdcalculator.*;
import controller.*;
/**
 *
 * @author Edward
 */
public class SimpleView {    
   
public static void showOption () {    
 System.out.println("Выбирите метод: 1 - ввести данные вручную, Выбирите метод: 2 - считать данные с файла, 3- считать данные с сайта"); 

}

public static void showPrice() {
    System.out.println("Стоимость квартиры:");
}

public static void typePrice () {
    System.out.println("Введите стоимость квартиры:");
}

public static void sumOfmeters () {
    System.out.println("Введите общий метраж квартиры:");
}

public static void isEligible () {
System.out.println("Квартира подходит под МДМ");
}

public static void isNotEligible () {
System.out.println("Квартира не подходит под МДМ");
}


}
