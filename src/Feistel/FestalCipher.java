package Feistel;

import java.util.*;

public class FestalCipher {
    static String prevright;
    static String prevleft;
    static String newright ;
    static String newleft;
    public static String to64bit(String eightLetters){
        String _64bit="";
        String _8bit;
        for (int i = 0; i < eightLetters.length(); i++) {
            _8bit=Integer.toBinaryString(eightLetters.charAt(i));

            while(_8bit.length()<8){
                _8bit="0"+_8bit;
            }

            _64bit+=_8bit;
        }

        return _64bit;
    }
    public static String to32bit(String fourLetters){
        String _32bit="";
        String _8bit;
        for (int i = 0; i < fourLetters.length(); i++) {
            _8bit=Integer.toBinaryString(fourLetters.charAt(i));

            while(_8bit.length()<8){
                _8bit="0"+_8bit;
            }

            _32bit+=_8bit;
        }

        return _32bit;
    }
    static public String shiftleft(String prev,int shifttimes){
        return prev.substring(shifttimes)+prev.substring(0, shifttimes);


    }
    static public List<String> generatkey(String key){
        List<String> subkey1 = new ArrayList<>();
        String prevle="";
        String prevri="";
        String newleftk="";
        String newrightk="";
        String newkey="";
        key = to32bit(key);


        for (int i = 0; i < 16; i++) {
            newkey= shiftleft(key,1);



            subkey1.add(newkey);
            key = newkey;

        }
        return subkey1;
    }

    static public String formating (String plain){
        while(plain.length()%8!=0){
            plain+="x";
        }
        return plain;
    }
    static  void fun(String key, String fun){

        if(fun == "AND")
            newright= And(prevright, key);
        else
            newright= or(prevright, key);


    }
    static String or(String one,String two){
        long lone= Long.parseLong(one, 2);
        long ltwo= Long.parseLong(two, 2);
        long xorded = lone | ltwo ;

        String storded = Long.toBinaryString(xorded);
        while(storded.length()<one.length())
            storded="0"+storded;
        return storded;
    }
    static String And(String one,String two){
        long lone= Long.parseLong(one, 2);
        long ltwo= Long.parseLong(two, 2);
        long xorded = lone & ltwo ;

        String strxored = Long.toBinaryString(xorded);
        while(strxored.length()<one.length())
            strxored="0"+strxored;
        return strxored;}
    static String xor(String one,String two){
        long lone= Long.parseLong(one, 2);
        long ltwo= Long.parseLong(two, 2);
        long xorded = lone ^ ltwo ;

        String strxored = Long.toBinaryString(xorded);
        while(strxored.length()<one.length())
            strxored="0"+strxored;
        return strxored;}
    static String encrypt(String plain,String key,String func){
        plain = formating(plain);
        List<String> subkey1 = new ArrayList<>();
        //System.out.println("for"+plain);
        subkey1=generatkey(key);
        String _8byte,_64bit, temp="",cipher="",fincipher="";
        for (int i = 0; i < plain.length(); i+=8) {
            _8byte = plain.substring(i, i+8);
            _64bit=to64bit(_8byte);

            prevleft = _64bit.substring(0,_64bit.length()/2);
            prevright = _64bit.substring(_64bit.length()/2);

            for (int j = 0; j < 16; j++) {

                fun(subkey1.get(j),func);
                newright=xor(newright, prevleft);
                prevleft= prevright;
                prevright=newright;
            }

            cipher= newright+prevleft;


            cipher=toFinalCipher(cipher);
            fincipher+=cipher;
        }

        return fincipher;
    }
    static String decrypt(String cipher,String key, String func){
        List<String> subkey1 = new ArrayList<>();
        cipher = formating(cipher);
        subkey1=generatkey(key);
        String _8bute,_64bit, temp="",plain="",fincipher="";
        for (int i = 0; i < cipher.length(); i+=8) {
            _8bute = cipher.substring(i, i+8);
            _64bit=to64bit(_8bute);

            prevleft = _64bit.substring(0,32);
            prevright = _64bit.substring(32);

            for (int j = 0; j < subkey1.size(); j++) {
                fun(subkey1.get(subkey1.size()-1-j), func);
                newright=xor(newright, prevleft);
                prevleft= prevright;
                prevright=newright;
            }

            plain= newright+prevleft;

            plain=toFinalCipher(plain);
            fincipher+=plain;
        }

        return fincipher;
    }
    public static String toFinalCipher(String _64bit){
        String _8bit;
        String cipher="";
        for (int i = 0; i < 64; i+=8) {

            _8bit=""+(char)Integer.parseInt(_64bit.substring(i, i+8),2);

            cipher +=_8bit;
        }

        return cipher;
    }
//    public static void main(String[] args) {
//
//        String enresult,dersult;
//        enresult=encryption("abcdefghijklmn","abcd","AND");
//
//
//        dersult= decryption(enresult, "abcd","AND");
//
//        System.out.println(dersult);
//    }
}