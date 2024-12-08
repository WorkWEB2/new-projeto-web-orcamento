package br.com.jera.tads.apimanutencaoequipamento.commom;

public class Util {
    public static String onlyNumbers(String str) {
        return str.replaceAll("[^0-9]", "");
    }
}
