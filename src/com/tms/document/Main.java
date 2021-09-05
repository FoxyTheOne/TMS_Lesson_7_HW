package com.tms.document;

import java.io.*;
import java.util.Scanner;

/**
 * Допустим есть файл с номерами документов.
 * Номером документа является строка, состоящая из букв и цифр(без служебных символов).
 * Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
 * Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum(далее любая
 * последовательность букв/цифр) или kontract(далее любая последовательность букв/цифр).
 *
 * Написать программу для чтения информации из входного файла - путь к входному файлу должен задаваться через консоль.
 *
 * Программа должна проверять номера документов на валидность.
 * Валидные номера документов следует записать в один файл-отчет.
 * Невалидные номера документов следует записать в другой файл-отчет, но после номеров документов следует добавить
 * информацию о том, почему этот документ невалиден.
 */

public class Main {
    public static void main(String[] args) {
        // Путь к входному файлу должен задаваться через консоль
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к входному файлу (пример - C:\\example.txt): ");

        String pathForReading = sc.nextLine(); // Введенный путь к файлу

        String pathForValidDocNumber = "C:\\java\\TeachMeSkills\\TMS_Lesson_7_HW\\ValidDocNumber.txt";
        String pathForInvalidDocNumber = "C:\\java\\TeachMeSkills\\TMS_Lesson_7_HW\\InvalidDocNumber.txt";

        try (BufferedReader fr = new BufferedReader (new FileReader(pathForReading));
             PrintWriter fwValid = new PrintWriter (new BufferedWriter (new FileWriter (pathForValidDocNumber, true)));
             PrintWriter fwInvalid = new PrintWriter (new BufferedWriter (new FileWriter (pathForInvalidDocNumber, true)))) {
            // " ,true" - для добавления новой информации в конец файла, без стирания предыдущей информации

            String docNumbers;
            while ((docNumbers = fr.readLine()) != null) { // Каждый цикл считываем одну строку, пока не закончится документ
                System.out.println();
                System.out.println("Номер документа: " + docNumbers);
                // Проверяем каждую строку:
                int check1 = DocumentCheck.numberLength15(docNumbers);
                int check2 = DocumentCheck.onlyNumAndLetter(docNumbers);
                int check3 = DocumentCheck.beginsWithDocnumOrKontract(docNumbers);

                if (check1 == 0 && check2 == 0 && check3 == 0) {
                    fwValid.println(docNumbers); // Вывод строковой информации в файл, с переводом строки
                    System.out.println("Валидный номер документа записан в файл " + pathForValidDocNumber);
                } else {
                    fwInvalid.println(docNumbers + " - невалидный номер документа:");
                    if (check1 == 101) {
                        fwInvalid.println("длина больше 15 символов");
                    } else if (check1 == 102) {
                        fwInvalid.println("длина меньше 15 символов");
                    }
                    if (check2 == 103) {
                        fwInvalid.println("номер документа содержит служебные символы");
                    }
                    if (check3 == 104) {
                        fwInvalid.println("номер документа не начинается с docnum или kontract");
                    }
                    fwInvalid.println();
                    System.out.println("! Невалидный номер документа записан в файл " + pathForInvalidDocNumber);
                }
            }

        } catch (FileNotFoundException e1) {
            System.out.println();
            System.out.println("Файл не найден. Проверьте путь к файлу");
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println();
            System.out.println(e2);
            e2.printStackTrace();
        }
    }
}
