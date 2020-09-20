import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;


public class WorkWithArrays {

    /* 
    Необходимо написать класс, содержащий следующие методы-утилиты для работы с массивами:
    1) Расчет суммы всех элементов массива.
    2) Нахождение максимального элемента массива.
    3) Нахождение минимального элемента массива.
    4) Вычисление среднего арифметического элементов массива.
    5) Вычисление количества элементов массива, мЕньших среднего арифметического.
    6) Вычисление количества элементов массива, бОльших среднего арифметического.
    7) Подсчет количества четных элементов массива
    8) Подсчет количества нечетных элементов массива.
    9) Сортировка массива. Алгоритм сортировки можно выбрать любой, но реализовать его необходимо самостоятельно.

    Дополнительно реализовать метод main, запускающий программу и вызывающий один из указанных методов по требованию пользователя.
    Желательно внести изменения в уже созданный в рамках первого задания проект.

    Полученная программа должна работать следующим образом:
    1) Запуск программы.
    2) Вывод в консоль краткой справки пользователя с указанием команд для вызова того или иного метода из перечисленных выше.
    3) Пользовательский ввод команды и массива для работы с ним.
    4) Вызов необходимого метода с параметром - введенным пользователем массивом.
    5) Отображение результата работы метода с кратким описанием.

    Факультативное задание:
    1) Организовать ввод команд и параметров для операции из текстового файла.
    2) Организовать вывод результата работы программы в текстовый файл.
    3) Даны два больших упорядоченных массива целых чисел. Необходимо найти количество одинаковых элементов в них. 
    */

    // Проверка элементов массива на соответствие требованиям
    static int[] check_input_array(String[] input){
        
        // Обновление переменной ошибок
        error = "";

        // 1) Длина массива больше 50
        if (input.length > 50)
            error = "Error! The array's length is MORE than 50";

        // 2) Массив пустой
        if (input.length == 0)
            error = "Error! The array cannot be EMPTY";

        // Объвление переменной, в которую будут помещаться обработанные значения 
        int[] result = new int[input.length];

        // 3) Проверка на корректность вводных данных (values is Integer, values < Integer.MAX_VALUE, values > Integer.MIN_VALUE) 
        for(int i = 0; i < input.length; i++) {
            try {
                result[i] = Integer.parseInt(input[i]);                
            }
            catch (Exception e){
                error = "Error! The values must be Integer, values < Integer.MAX_VALUE, values > Integer.MIN_VALUE";
            }
            finally {
                if (error == "")
                    result[i] = Integer.parseInt(input[i]);
            }
        }

        if (error == ""){
            return result;
        }
        else
            return new int[]{};
            


    }
    static String error = "";

    public static void main(String[] args) throws IOException {

        // Объявление служебной переменной, ответственной за консольный ввод-вывод 
        Scanner in = new Scanner(System.in);        

        // Объявление начальных текстовых переменных
        String hello = "\nHello. Let's identify you. Please, input you array below by\n/*console line*/ num1 space1 num2 space3 etc...\nFor example:\n\n1 12 134 66 992 76 10 13\n\nDon't forget this:\n1) Max array's length = 50 (we can do more, but it's difficult for you - input 50 numbers and chek all points)\n2) Array's value is ONLY integer numbers\n3) Max array's value is Integer.MAX_VALUE = 2147483647\n4) Min array's value is Integer.MIN_VALUE = -2147483648\n5) Array cannot be empty\n";
        String menu = "\nHello. We are glad to see you in our small console utility for managing arrays.\nNow you can choose one point to do one actoin with you input Array.\nYou can see list of actions and actual command below this.\n\n";
        String list = "\n1) Calculation of the sum of all elements of the array.\ncommand ==> sum\n\n2) Finding the maximum element of the array.\ncommand ==> max\n\n3) Finding the minimum element of the array.\ncommand ==> min\n\n4) Calculation of the arithmetic mean of array elements.\ncommand ==> mean\n\n5) Calculation of the number of array elements that are less than the arithmetic mean.\ncommand ==> lessmean\n\n6) Calculation of the number of array elements greater than the arithmetic mean\ncommand ==> moremean\n\n7) Counting the number of even elements in an array\ncommand ==> even\n\n8) Counting the number of odd elements in an array\ncommand ==> odd\n\n9) Quick sorting of array elements\ncommand ==> qsort\n\n10) Exit\ncommand ==> exit\n\n11) Input array once again\ncommand ==> reset\n\n12) Compare two big arrays\ncommand ==> compare\n\n"; 
         
        // 1) Начало работы программы. Вывод начального экрана и ввод массива 
        System.out.println(hello);

        // Ввод строки, содержащей массив
        String array_input = in.nextLine();

        // Объявление служебных переменных
        String input, result = "";

        // Первоначальное разделение массива на элементы с любым количеством пробелов
        String[] array_split = array_input.split("[ ]+");        

        // Проверка элементов массива для дальнейшей работы с ним
        int[] array = check_input_array(array_split);

        // Объявление переменной для выхода из цикла
        boolean exit = true;

        // Обработка ошибок ввода (ввод до правильного ввода массива)
        while (error != "") {
            System.out.println("You have an error!\n" + error + "\nPlease, repeat input!\n\n");
            array_input = in.nextLine();
            array_split = array_input.split("[ ]+");        
            array = check_input_array(array_split);
    
        }

        // Основной loop-цикл работы программы
        while(exit){

            // Вывод информационного сообщения и массива
            System.out.println(menu + list + "Your array:\n");
            MethodsForArrays.print(array_split);

            // Вывод результата предыдущей операции
            System.out.println(result);

            // Получение команды от пользователя
            input = in.nextLine();

            // Обработка команды
            switch (input){
                // Сумма элементов массива
                case "sum": {
                    int sum = MethodsForArrays.task1(array);
                    result = "\nSum of all elements of the array (your last command) = " + Integer.toString(sum) + "\n";
                    break;
                }
                // Максимальное значение элементов массива
                case "max": {
                    int max = MethodsForArrays.task2(array);
                    result = "\nMaximum element of the array (your last command) = " + Integer.toString(max) + "\n";
                    break;
                }
                // Минимальное значение элементов массива
                case "min": {
                    int min = MethodsForArrays.task3(array);
                    result = "\nMinimum element of the array (your last command) = " + Integer.toString(min) + "\n";
                    break;
                }
                // Среднее значение элементов массива
                case "mean": {
                    double mean = MethodsForArrays.task4(array);
                    result = "\nArithmetic mean of array elements (your last command) = " + Double.toString(mean) + "\n";
                    break;
                }
                // Количество элементов массива, меньших среднего
                case "lessmean": {
                    int lessmean = MethodsForArrays.task5(array);
                    result = "\nNumber of array elements that are less than the arithmetic mean (your last command) = " + Integer.toString(lessmean) + "\n";
                    break;
                }
                // Количество элементов массива, больших среднего
                case "moremean": {
                    int moremean = MethodsForArrays.task6(array);
                    result = "\nNumber of array elements greater than the arithmetic mean (your last command) = " + Integer.toString(moremean) + "\n";
                    break;
                }
                // Количество чётных элементов массива
                case "even": {
                    int even = MethodsForArrays.task7(array);
                    result = "\nNumber of even elements in an array (your last command) = " + Integer.toString(even) + "\n";
                    break;
                }
                // Количество нечётных элементов массива
                case "odd": {
                    int odd = MethodsForArrays.task8(array);
                    result = "\nNumber of odd elements in an array (your last command) = " + Integer.toString(odd) + "\n";
                    break;
                }
                // Быстрая сортировка
                case "qsort": {
                    int[] qsort = array.clone();
                    MethodsForArrays.task9(qsort);
                    result = "\nQuick sorting of array elements (your last command):\n\n" + MethodsForArrays.print(qsort, true) + "\n";
                   
                    break;
                }
                // Выход из программы
                case "exit": {
                    exit = false;
                    break;
                }
                // Ввод нового массива
                case "reset": {
                    System.out.println(hello);
                    array_input = in.nextLine();
                    array_split = array_input.split("[ ]+");        
                    array = check_input_array(array_split);

                    while (error != "") {
                        System.out.println("You have an error!\n" + error + "\nPlease, repeat input!\n\n");
                        array_input = in.nextLine();
                        array_split = array_input.split("[ ]+");        
                        array = check_input_array(array_split);
                
                    }
                    result = "";
                    break;
                }

                case "compare": {                    
                    System.out.println("\nInput path to FILE with compare's arrays\n");
                    String path = in.nextLine();

                    String error_compare = "x";
                    FileReader file;// = new FileReader("");
                    Scanner file_read;// = new Scanner(file);
                    String first_array = "";
                    String second_array = "";

                    while (error_compare != "") {
                        try {
                            file = new FileReader(path);
                            file_read = new Scanner(file);
                            error_compare = "";
                            first_array = file_read.nextLine();
                            second_array = file_read.nextLine();                            
                            file_read.close();
                            file.close();
                            result = "";
                    
                        }
                        catch (Exception e) {
                            result = "\nYou have an error with opening file.\nRe-input path to FILE with compare's arrays\n" + e.getMessage() + "\n";
                            path = in.nextLine();                
                            error_compare = "x";
                        }                        
                    }
                    
                    String[] first_strings = first_array.split("[ ]+");
                    String[] second_strings = second_array.split("[ ]+");

                    int[] first_int = new int[first_strings.length];
                    int[] second_int = new int[second_strings.length];

                    try {
                        for (int i = 0; i < first_int.length; i++) {
                            first_int[i] = Integer.parseInt(first_strings[i]);
                            second_int[i] = Integer.parseInt(second_strings[i]);                            
                        }
                        result = "";
                    }
                    catch (Exception e) {
                        result = "\nError in file. Values in arrays are in wrong format.\nThe values must be Integer, values < Integer.MAX_VALUE, values > Integer.MIN_VALUE\n";
                    }
                    
                    HashSet<Integer> first_set = new HashSet<Integer>();
                    HashSet<Integer> first_set_copy = new HashSet<Integer>();
                    HashSet<Integer> second_set = new HashSet<Integer>();
                    
                    for (int i = 0; i < first_int.length; i++) {
                        first_set.add(first_int[i]);
                        first_set_copy.add(first_int[i]);
                    }
                                            
                    for (int i = 0; i < second_int.length; i++)
                        second_set.add(second_int[i]);
                                      

                    first_set.removeAll(second_set);
                    first_set_copy.removeAll(first_set);

                    Integer[] result_values = first_set_copy.toArray(new Integer[0]);

                    List<Integer> first_list = Arrays.stream(first_int).boxed().collect(Collectors.toList());
                    List<Integer> second_list = Arrays.stream(first_int).boxed().collect(Collectors.toList());                    
                    
                    int result_sum = 0;
                    for (int i = 0; i < result_values.length; i++){
                        int first_count = Collections.frequency(first_list, result_values[i]);
                        int second_count = Collections.frequency(second_list, result_values[i]);
                        result_sum += Math.min(first_count, second_count);
                    }

                    result = "\nThe arrays have " + Integer.toString(result_sum) + " equal elements\n";

                    break;
                }
            }
            
        }
        System.out.println("\nGoodbye!");

        // int[] array = { 10, 4, 2, 14, 67, 2, 11, 33, 1, 15 };
        
        // int[] array = {80, 35, 54, 63, 54, 61, 1, 42, 37, 2, 46, 55, 97, 46, 9, 81, 52, 24, 62, 50, 13, 41, 30, 44, 24, 86, 47, 19, 55, 69, 2, 21, 75, 14, 21, 99, 31, 92, 60, 88, 30, 85, 43, 35, 5, 67, 92, 84, 59, 73};
    }

}

class MethodsForArrays {

     // Рассчёт суммы всех элементов массива
    static int task1(int[] array) {
        int value = 0;
        for(int i = 0; i < array.length; i++){
            value += array[i];
        }
        return value;
    }

    // Поиск максимального элемента массива
    static int task2(int[] array) {
        int value = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if (array[i] > value)
                value = array[i];
        }
        return value;
    }

    // Поиск минимального элемента массива
    static int task3(int[] array) {
        int value = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if (array[i] < value)
                value = array[i];
        }
        return value;
    }

    // Вычисление среднего арифметического элементов массива
    static double task4(int[] array) {
        int value = task1(array);        
        return value / array.length;
    }

    // Количество элементов, меньших среднего арифметического
    static int task5(int[] array) {
        double value = task4(array);
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] < value)
                count++;
        }
        return count;
    }
    
    // Количество элементов, больших среднего арифметического
    static int task6(int[] array) {
        double value = task4(array);
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] > value)
                count++;
        }
        return count;
    }
    
    // Количество чётных элементов
    static int task7(int[] array) {        
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0)
                count++;
        }
        return count;
    }
    
    // Количество нечётных элементов
    static int task8(int[] array) {
        int count = task7(array);
        return array.length - count;
    }

    // Сортировка элементов массива
    static void task9(int[] array){
        if(array.length == 1)
            return;

        task9_core(array, 0, array.length - 1);
    }

    // Рекурсивное ядро метода быстрой сортировки
    static void task9_core(int[] array, int start, int end){
        if (start >= end)
            return;

        int start1 = start, end1 = end; 

        int temp;
        int i = -1;
        while (start != end){
            while (start <= end && i == -1 && array[start] <= array[end] || start >= end && i == 1 && array[start] >= array[end])
                end += i;
            
            if (end <= end1 && end >= start1){
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;

                temp = start;
                start = end;
                end = temp;               
            }
            i *= -1;
            end += i;                       
        }       

        task9_core(array, start1, start - 1);
        task9_core(array, start + 1, end1);

    }

    // Метод вывод int массива на экран
    static void print(int[] array){
        for(int i = 0; i < array.length; i++) {           
            System.out.print(Integer.toString(array[i]) + "\t");
        }
        System.out.println("");
    }
    
    static void print(Integer[] array){
        for(int i = 0; i < array.length; i++) {           
            System.out.print(Integer.toString(array[i]) + "\t");
        }
        System.out.println("");
    }
    
    // Метод вывод String массива на экран
    static void print(String[] array){
        for(int i = 0; i < array.length; i++) {           
            System.out.print("|" + array[i] + "|" + "\t");
        }
        System.out.println("");
    }

    // Метод преобразования String массива в строку
    static String print(int[] array, boolean k){
        String result = "";
        for(int i = 0; i < array.length; i++) {           
            result += "|" + Integer.toString(array[i]) + "|" + "\t";
        }
        result += "\n";
        return result;
    }
}

