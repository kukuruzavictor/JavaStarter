//Програма-гра. Просить користувача правильно відповісти на питання.

package com.company;
import java.util.Scanner;

public class MagicPrint {

// головний метод, робить запит на введення та створює об'єкт нашого класу
// дає безмежну можливість ввести правильну відповідь
    public static void main (String[] args){
        System.out.print ("ДАЙТЕ ПРАВИЛЬНУ ВІДПОВІДЬ!\nЯку мову програмування Ви вивчаєте? (4 букви): ");
        String word = wordRequest();
        MagicPrint MP = new MagicPrint(word);

        // toUpperCase використано, щоб спростити перевірку правильних рядків з різним регістром
        while (!(word.toUpperCase().equals("JAVA"))){
            System.out.print ("НЕПРАВИЛЬНО!\nПрочерки вказують на неправильну літеру. Спробуйте ще: ");
            word = wordRequest();
            MP = new MagicPrint(word);
        }
        System.out.print ("ПРАВИЛЬНО!!! Ви відгадали! :)");
    }

// конструктор. приймає рядок
    public MagicPrint(String word){
        String check = wordCheck(word);              // перевіряє рядок
        String[] result = wordToArray(word, check);  // перетворює в масив
        printArray(result);                          // виводить масив
    }

// метод запускає запит на введення рядка
// фільтрує кількість символів – повертає значення тільки при 4
// дає безмежну кількість спроб при введенні
    public static String wordRequest(){
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        while (word.length()!=4){
            System.out.print ("Спробуйте ще раз! Слово з ЧОТИРЬОХ букв: ");
            word = in.nextLine();
        }
        return word;
    }

// метод приймає рядок, та перевіряє його правильність
// незважає на регістр, тобто "jAVa" буде правильним
// повертає "рядок-шаблон правильності", наприклад JavA->1111, Mama->0101, kava->0111
    public static String wordCheck(String word){
        String result = "";
        if (word.charAt(0)=='j' || word.charAt(0)=='J'){
            result+="1";
        } else {result+='0';}
        if (word.charAt(1)=='a' || word.charAt(1)=='A'){
            result+="1";
        } else {result+='0';}
        if (word.charAt(2)=='v' || word.charAt(2)=='V'){
            result+="1";
        } else {result+='0';}
        if (word.charAt(3)=='a' || word.charAt(3)=='A'){
            result+="1";
        } else {result+='0';}
        return result;
    }

// метод приймає введений рядок та шаблон правильності літер
// конвертує рядок в масив для виведення
// використовує окремий метод letterToArray() для конвертування літер в масив поокремо
    public static String[] wordToArray(String word, String check){
        String[] result = new String[5];
        String[] letter0 = letterToArray(word.charAt(0), check.charAt(0));
        String[] letter1 = letterToArray(word.charAt(1), check.charAt(1));
        String[] letter2 = letterToArray(word.charAt(2), check.charAt(2));
        String[] letter3 = letterToArray(word.charAt(3), check.charAt(3));
        for (int i=0; i<5; i++){
            result[i]=letter0[i]+" "+letter1[i]+" "+letter2[i]+" "+letter3[i];
        }
        return result;
    }

// метод приймає один символ рядка та символ з "шаблону правильності"
// повертає масив однієї літери, залежно від її правильності, використовуючи підготовлені шаблони
    public static String[] letterToArray(char letter, char check){
        String[] letterLine = new String[5];
        if ((letter=='A' || letter =='a') & check=='1') {
            letterLine[0] = "    " + letter + "    ";
            letterLine[1] = "   " + letter + " " + letter + "   ";
            letterLine[2] = "  " + letter + "   " + letter + "  ";
            letterLine[3] = " " + letter + " " + letter + " " + letter + " " + letter + " ";
            letterLine[4] = letter + "       " + letter;
        } else if ((letter=='J' || letter =='j') & check=='1') {
            letterLine[0] = "      " + letter + " " + letter;
            letterLine[1] = "        " + letter;
            letterLine[2] = "        " + letter;
            letterLine[3] = letter + "       " + letter;
            letterLine[4] = " " + letter + " " + letter + " " + letter + " " + letter + " ";
        } else if ((letter=='V' || letter =='v') & check=='1') {
            letterLine[0] = letter + "       " + letter;
            letterLine[1] = " " + letter + "     " + letter + " ";
            letterLine[2] = "  " + letter + "   " + letter + "  ";
            letterLine[3] = "   " + letter + " " + letter + "   ";
            letterLine[4] = "    " + letter + "    ";
        }
        else{
            letterLine[0] = "         ";
            letterLine[1] = "         ";
            letterLine[2] = "  "+letter+" "+letter+" "+letter+"  ";
            letterLine[3] = "         ";
            letterLine[4] = "         ";
        }
        return letterLine;
    }

// метод приймає масив та виводить його
    public static void printArray(String[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

}
