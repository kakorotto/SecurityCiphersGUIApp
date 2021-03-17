package Playfair;

//  If both letters are in the same column, take the letter below each one (going back to the top if at the bottom)
//  If both letters are in the same row, take the letter to the right of each one (going back to the left if at the farthest right)
//  If neither of the preceding two rules are true, form a rectangle with the two letters and take the letters on the horizontal opposite corner of the rectangle
//  If the letter is j or signs like (,.?),we don't convert them to any another letter
//  we don't encrypt number of letters is odd we don't convert last one

import java.util.*;

public class PlayfairCipher {

    public static String keyword , keyField = new String();
    public static char[][] matArr= new char[5][5];

    public void setKey(String key) {
        String keyString = new String();
        boolean flag = false;
        keyString = keyString + key.charAt(0);
        for (int i = 1; i < key.length(); i++) {
            for (int j = 0; j < keyString.length(); j++) {
                if (key.charAt(i) == keyString.charAt(j)) {
                    flag = true;
                }
            }
            if (flag == false) {
                keyString = keyString + key.charAt(i);
            }
            flag = false;
        }
        keyword = keyString;
    }

    public void Generator() {
        keyField = keyword;
        boolean flag = true;
        char current;
        for (int i = 0; i < 26; i++) {
            current = (char) (i + 97);
            if (current == 'j') {
                continue;
            }
            for (int j = 0; j < keyword.length(); j++) {
                if (current == keyword.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                keyField = keyField + current;
            }
            flag = true;
        }
        System.out.println(keyField);
        matrix();
    }

    private void matrix() {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matArr[i][j] = keyField.charAt(counter);
                System.out.print(matArr[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }

    private String format(String oldText) {
        int i, length;
        String text = new String();
        length = oldText.length();
        for (int tmp = 0; tmp < length; tmp++) {
            if (oldText.charAt(tmp) == 'j') {
                text = text + 'i';
            } else {
                text = text + oldText.charAt(tmp);
            }
        }
        length = text.length();
        for (i = 0; i < length - 1; i = i + 1) {
            if (text.charAt(i + 1) == text.charAt(i)) {
                text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
            }
        }
        return text;
    }

    private String[] Divide2Pairs(String newString) {
        String mainText = format(newString);
        int size = mainText.length();
        if (size % 2 != 0) {
            size++;
            mainText = mainText + 'x';
        }
        String x[] = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++) {
            x[i] = mainText.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return x;
    }

    public int[] GetDiminsions(char letter) {
        int[] key = new int[2];
        if (letter == 'j') {
            letter = 'i';
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matArr[i][j] == letter) {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }

    public String encryptMessage(String Source) {
        String srcArr[] = Divide2Pairs(Source);
        String Code = new String();
        char d1, d2;
        int div1[], div2[];
        for (String src_arr1 : srcArr) {
            d1 = src_arr1.charAt(0);
            d2 = src_arr1.charAt(1);
            div1 = GetDiminsions(d1);
            div2 = GetDiminsions(d2);
            if (div1[0] == div2[0]) {
                if (div1[1] < 4) {
                    div1[1]++;
                } else {
                    div1[1] = 0;
                }
                if (div2[1] < 4) {
                    div2[1]++;
                } else {
                    div2[1] = 0;
                }
            } else if (div1[1] == div2[1]) {
                if (div1[0] < 4) {
                    div1[0]++;
                } else {
                    div1[0] = 0;
                }
                if (div2[0] < 4) {
                    div2[0]++;
                } else {
                    div2[0] = 0;
                }
            } else {
                div1[1] = div1[1] + div2[1];
                div2[1] = div1[1] - div2[1];
                div1[1] = div1[1] - div2[1];
            }
            Code = Code + matArr[div1[0]][div1[1]]
                    + matArr[div2[0]][div2[1]];
        }
        return Code;
    }

    public String decryptMessage(String Code) {
        String mainText = new String();
        String srcArr[] = Divide2Pairs(Code);
        char d1, d2;
        int div1[], div2[];

        for (String src_arr1 : srcArr) {
            d1 = src_arr1.charAt(0);
            d2 = src_arr1.charAt(1);
            div1 = GetDiminsions(d1);
            div2 = GetDiminsions(d2);
            if (div1[0] == div2[0]) {
                if (div1[1] > 0) {
                    div1[1]--;
                } else {
                    div1[1] = 4;
                }
                if (div2[1] > 0) {
                    div2[1]--;
                } else {
                    div2[1] = 4;
                }
            } else if (div1[1] == div2[1]) {
                if (div1[0] > 0) {
                    div1[0]--;
                } else {
                    div1[0] = 4;
                }
                if (div2[0] > 0) {
                    div2[0]--;
                } else {
                    div2[0] = 4;
                }
            } else {
                div1[1] = div1[1] + div2[1];
                div2[1] = div1[1] - div2[1];
                div1[1] = div1[1] - div2[1];
            }
            mainText = mainText + matArr[div1[0]][div1[1]]+ matArr[div2[0]][div2[1]];
        }
        return mainText;
    }


}