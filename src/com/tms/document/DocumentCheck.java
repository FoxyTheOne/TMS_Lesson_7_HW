package com.tms.document;

public class DocumentCheck {
    // Валидный номер документа должен иметь длину 15 символов
    public static boolean numberLength15 (String numberOfDoc) {
        char[] array = numberOfDoc.toCharArray();
        int countChar = 0;

        for (int e : array) {
            countChar++;
        }

        if (countChar == 15) {
            return true;
        } else {
            return false;
        }
    }

    // Номером документа является строка, состоящая из букв и цифр (без служебных символов)
    public static boolean onlyNumAndLetter (String numberOfDoc) {
        char[] array = numberOfDoc.toCharArray();
        int countNotNumOrLetter = 0;

        for (int e : array) {
            if (!Character.isLetterOrDigit(e)) {
                countNotNumOrLetter++;
            }
        }

        if (countNotNumOrLetter == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Проверить начинается ли номер документа с docnum или kontract
    public static boolean beginsWithDocnumOrKontract (String numberOfDoc) {
        if (numberOfDoc.startsWith("docnum") || numberOfDoc.startsWith("kontract")) {
            return true;
        } else {
            return false;
        }
    }
}
