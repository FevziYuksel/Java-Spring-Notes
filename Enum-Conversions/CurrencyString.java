package org.banking.mybankingapplication.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;
import org.hibernate.engine.jdbc.Size;

import java.util.Arrays;
import java.util.Locale;

@ToString
public enum CurrencyString {

    /**
     * Change fields to String ??
     * */

    DOLLAR("USD"),
    EURO("EUR"),
    TURKISH_LIRA("TRY"),
    POUND("GBP");

    Currency(String name) {}

    String getText(){
        return this.name();
    }

      // Enum to String and String to Enum

    public static CurrencyString fromText1(String text) {
        //Text must be exactly same
        CurrencyString currency = null;
        try{
            currency = CurrencyString.valueOf(text.toUpperCase());
        }catch (Exception e){
            throw new IllegalArgumentException("Currency is not present in data");
        }
        return currency;
    }
    public static String fromText2(CurrencyString currency) {

        String text ;
        try{
            text = currency.name();
        }catch (Exception e){
            throw new IllegalArgumentException("Currency is not present in data");
        }
        return text;
    }

    
   
    @JsonCreator
    public static CurrencyString fromText3(String text) {
        //Text must be exactly same
        for (CurrencyString c : CurrencyString.values()) {
            if (c.getText().equalsIgnoreCase(text)) {
                return c;
            }
        }
        throw new IllegalArgumentException("");
    }
    @JsonCreator
    public static CurrencyString fromText2(String text) {

        for (CurrencyString c : CurrencyString.values()) {
            if (text.toUpperCase().contains(c.getText())) {
                return c;
            }
        }
        throw new IllegalArgumentException("");
    }
    @JsonCreator
    public static CurrencyString fromText4(String text) {

        return Arrays.stream(CurrencyString.values())
                .filter(name -> text.toUpperCase().contains(name.name()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Currency is not present in data"));

    }





}




