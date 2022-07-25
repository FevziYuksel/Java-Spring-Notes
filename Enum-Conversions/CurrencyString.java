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

    DOLLAR("dollar"),
    EURO("euro"),
    TURKISH_LIRA("lira"),
    POUND("pound");

    Currency(String name) {}

    String getText(){
        return this.name();
    }

      // Enum to String and String to Enum

    public static Currency fromText1(String text) {
        //Text must be exactly same
        Currency currency = null;
        try{
            currency = Currency.valueOf(text.toUpperCase());
        }catch (Exception e){
            throw new IllegalArgumentException("Currency is not present in data");
        }
        return currency;
    }
    public static String fromText2(Currency currency) {

        String text ;
        try{
            text = currency.name();
        }catch (Exception e){
            throw new IllegalArgumentException("Currency is not present in data");
        }
        return text;
    }

    
   
    @JsonCreator
    public static Currency fromText3(String text) {
        //Text must be exactly same
        for (Currency c : Currency.values()) {
            if (c.getText().equalsIgnoreCase(text)) {
                return c;
            }
        }
        throw new IllegalArgumentException("");
    }
    @JsonCreator
    public static Currency fromText2(String text) {

        for (Currency c : Currency.values()) {
            if (text.toUpperCase().contains(c.getText())) {
                return c;
            }
        }
        throw new IllegalArgumentException("");
    }
    @JsonCreator
    public static Currency fromText4(String text) {

        return Arrays.stream(Currency.values())
                .filter(name -> text.toUpperCase().contains(name.name()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Currency is not present in data"));

    }





}




