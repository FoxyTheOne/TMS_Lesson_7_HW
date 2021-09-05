package com.tms.document;

import java.io.PrintWriter;

public class DocumentCheck {
    // Валидный номер документа должен иметь длину 15 символов
    public static int numberLength15 (String numberOfDoc) {
        char[] array = numberOfDoc.toCharArray();
        int countChar = 0;

        for (int e : array) {
            countChar++;
        }

        if (countChar == 15) {
            return 0;
        } else if (countChar > 15){
            return 101;
        } else {
            return 102;
        }
    }

    // Номером документа является строка, состоящая из букв и цифр (без служебных символов)
    public static int onlyNumAndLetter (String numberOfDoc) {
        char[] array = numberOfDoc.toCharArray();
        int countNotNumOrLetter = 0;

        for (int e : array) {
            if (!Character.isLetterOrDigit(e)) {
                countNotNumOrLetter++;
            }
        }

        if (countNotNumOrLetter == 0) {
            return 0;
        } else {
            return 103;
        }
    }

    // Проверить начинается ли номер документа с docnum или kontract
    public static int beginsWithDocnumOrKontract (String numberOfDoc) {
        if (numberOfDoc.startsWith("docnum") || numberOfDoc.startsWith("kontract")) {
            return 0;
        } else {
            return 104;
        }
    }
}
