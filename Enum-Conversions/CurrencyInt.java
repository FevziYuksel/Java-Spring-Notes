
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;
import org.hibernate.engine.jdbc.Size;

import java.util.Arrays;
import java.util.Locale;

@ToString
public enum CurrencyInt {


    DOLLAR(1),
    EURO(2),
    TURKISH_LIRA(3),
    POUND(4);

    Currency(int i) {}

    String getText(){
        return this.name();
    }

     //Int to Enum and Enum to Int

     public static CurrencyInt intToEnum(int number){
     //If enums are ordered
     CurrencyInt currency = null;
     try{
     currency = CurrencyInt.values()[number];
     }
     catch(Exception e){
      throw new IllegalArgumentException("Currency is not present in data");
     }
     return currency;

     }
    public static int EnumToInt(CurrencyInt currency){
        //If enums are ordered
        return currency.ordinal();
    }

    public static CurrencyInt chooseCurrency(int number){

        return switch (number) {
            case 1-> CurrencyInt.DOLLAR;
            case 2 -> CurrencyInt.EURO;
            case 3 -> CurrencyInt.TURKISH_LIRA;
            case 4 -> CurrencyInt.POUND;
            default -> throw new IllegalArgumentException("Currency is not present in data");
        };
    }
 



}




