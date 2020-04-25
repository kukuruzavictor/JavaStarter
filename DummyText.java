package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DummyText {

    public static void main(String[] args) {
        String text = getString();
        System.out.println(lastThreeSentenceMerge(toConsonant(toUpperCase(text))));
        System.out.println("      У ТЕКСТІ ЗНАЙДЕНО:");
        System.out.println("      слів з 3 символів: "+wordCounter3(text));
        System.out.println("      слів з 5 символів: "+wordCounter5(text));
        System.out.println("      слів з 7 символів: "+wordCounter7(text));
        System.out.println("                 речень: "+sentenceCounter(text));
        int sumDates = date1(text)+date2(text);
        System.out.println("                    дат: "+sumDates);
        System.out.println("        сума всіх чисел: "+numbers(text));
        System.out.println("          17-те речення: "+seventeen(text));
        System.out.println("17-те речення навиворіт: "+seventeenReverse(text));
        System.out.println("                     + : кожне ДРУГЕ речення переведено до верхнього регістру");
        System.out.println("                     + : в кожному ТРЕТЬОМУ реченні замінено голосні літери на символ *");
        System.out.println("                     + : останні 3 речення об'єднані в одне використовуючи коми");
    }

    public static int date1(String text){
        int counter = 0;
        String regex = "\\b[0-9]{2,}[0-9]+до н[.]е[.]\\B";       // '10000до н.е.'
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public static int date2(String text){
        int counter = 0;
        String regex = "\\b[12][0-9]{3}(-[01][1-9]-[0-3][0-9])?\\b"; // '1998' OR '2303-12-31'
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public static int numbers(String text){
        int result = 0;
        String regex = "\\b[0-9]{2,}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        String textnumber = "";
        while (m.find()){
            textnumber = text.substring(m.start(),m.end());
            result+=Integer.parseInt(textnumber);
        }
        return result;
    }

    public static String seventeen(String text){
        String [] s = text.split("[.]");
        return s[16];
    }

    public static String seventeenReverse(String text){
        String [] s = text.split("[.]");
        String [] seventeen = s[16].split("[ ]");
        String result = "";
        String buffer;
        for (int i =0; i<seventeen.length/2; i++ ){
            buffer = seventeen[i];
            seventeen[i]=seventeen[seventeen.length-1-i];
            seventeen[seventeen.length-1-i]=buffer;
        }
        for (int i=0; i<seventeen.length; i++){
            result+=seventeen[i]+" ";
        }
        return result;
    }

    public static String lastThreeSentenceMerge(String text){
        String [] s = text.split("[.]");
        String result = "";
        for (int i=0; i<s.length; i++){
            if (i==s.length-2 || i==s.length-3){
                result+=s[i]+",";
            } else {
                result+=s[i]+".";
            }
        }
        return result;
    }

    public static String toConsonant (String text){
        String [] sentenceArray = text.split("[.]");
        Pattern p = Pattern.compile("[aeiouyAEIOUY]");
        String consonantText = "";
        for (int i=2; i<sentenceArray.length; i+=3){
            Matcher m = p.matcher(sentenceArray[i]);
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "*");
            }
            m.appendTail(sb);
            sentenceArray[i]=sb.toString();
        }
        for (int i=0; i<sentenceArray.length; i++){
            consonantText += sentenceArray[i]+".";
        }
        return consonantText;
    }

    // метод виконує також заміну голосних використовуючи toConsonant()
    public static String toUpperCase(String text){
        String [] sentenceArray = text.split("[.]");
        String upperText = "";
        for (int i=1; i<sentenceArray.length; i+=2){
            sentenceArray[i]=sentenceArray[i].toUpperCase();
        }
        for (int i=0; i<sentenceArray.length; i++){
            upperText += sentenceArray[i]+".";
        }
        return upperText;
    }

    public static int sentenceCounter(String text){
        int counter = 0;
        String regex = "[a-zA-Z ,:';-]+.";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public static int wordCounter3(String text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{3}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }
    public static int wordCounter5(String text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{5}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }
    public static int wordCounter7(String text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{7}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public static String getString(){
        // https://www.blindtextgenerator.com/lorem-ipsum
        return "Li Europan lingues 45 es membres del sam familie. Lor separat 2004 existentie es un myth. Por 2055 22 scientie, musica, 1965-04-21 sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam 100до н.е. Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser neces";
    }
}

