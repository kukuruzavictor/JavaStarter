package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DummyText {

    public static void main(String[] args) {
        String text = getString();
        String [] textArray = sentenceArray(text);
        System.out.println(lastThreeSentenceMerge(toConsonant(toUpperCase(textArray))));
        System.out.println();
        System.out.println("      У ТЕКСТІ ЗНАЙДЕНО:");
        System.out.println("      слів з 3 символів: "+wordCounter3(text));
        System.out.println("      слів з 5 символів: "+wordCounter5(text));
        System.out.println("      слів з 7 символів: "+wordCounter7(text));
        System.out.println("                 речень: "+sentenceCounter(textArray));
        int sumDates = date1(text)+date2(text);
        System.out.println("                    дат: "+sumDates);
        System.out.println("        сума всіх чисел: "+numbers(text));
        System.out.println("          17-те речення: "+seventeen(textArray));
        System.out.println("17-те речення навиворіт: "+seventeenReverse(seventeen(textArray)));
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

    public static String seventeen(String [] text){
        String sentence = text[16].trim();
        return sentence.substring(0,sentence.length()-1);
    }

    public static String seventeenReverse(String text){
        String [] seventeen = text.split("[ ]");
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

    public static String lastThreeSentenceMerge(String [] text){
        String result = "";
        for (int i=0; i<text.length; i++){
            if (i==text.length-2 || i==text.length-3){
                result+=text[i].substring(0, text[i].length()-2)+", ";
            } else {
                result+=text[i];
            }
        }
        return result;
    }

    public static String [] toConsonant (String [] text){
        Pattern p = Pattern.compile("[aeiouyAEIOUY]");
        for (int i=2; i<text.length; i+=3){
            Matcher m = p.matcher(text[i]);
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "*");
            }
            m.appendTail(sb);
            text[i]=sb.toString();
        }
        return text;
    }

    public static String [] toUpperCase(String [] text){
        for (int i=1; i<text.length; i+=2){
            text[i]=text[i].toUpperCase();
        }
        return text;
    }

    public static int sentenceCounter(String [] text){
        return text.length;
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

    public static String [] sentenceArray (String text){
        return text.split("(?<=[.?!] )");
    }

    public static String getString(){
        // https://www.blindtextgenerator.com/lorem-ipsum
        return "Li Europan lingues 45 es membres del sam familie. Lor separat 2004 existentie es un myth? Por 2055 22 scientie, musica, 1965-04-21 sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam 100до н.е. Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser neces";
    }
}

