package com.cdv.mobili.integration_tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Apagar essa classe ao gerar release- serve somente para testes rápidos de prova de conceito
 */
public class Teste {

    public static void main (String[] args)
    {
        Pattern p = Pattern.compile( "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}");
        String str = "12.123.123/0001-12";
        Matcher m = p.matcher(str);
        System.out.println(m.matches() ? "match! =)" : "no match =(");

    }
}
