package RC4;


import java.util.ArrayList;
import java.util.List;

public class RC4Cipher {

    static char [] initial(String key){
        char [] keych = key.toCharArray();
        char [] S= new char [256];
        char [] K = new char [256];
        char temp;
        for (char i = 0; i < 256; i++) {
            S[i]=i;
            K[i]=keych[i % keych.length];
        }
        int  j =0;
        for (int i = 0; i < 256; i++) {
            j=(j+S[i]+K[i])%256;
            temp = S[i];
            S[i]=S[j];
            S[j]=temp;

        }
        return S;
    }
    static char[] key_gene(char []S,int pl_lenth){
        int i=0 ,j=0;
        char temp;
        char [] sub_keys = new char [pl_lenth];
        for (int k = 0; k <pl_lenth; k++) {
            i = (i+1)%256;
            j=(j+S[i])%256;
            temp = S[i];
            S[i]=S[j];
            S[j]=temp;
            sub_keys[k]=S[(S[i]+S[j])%256];
        }
        return sub_keys;
    }
    static String encrypt(String plain , String key){
        char [] plch = plain.toCharArray();
        String  ci = "";
        char [] S= initial(key);
        char [] sub_keys = key_gene(S, plch.length);
        for (int i = 0; i < sub_keys.length; i++) {
            ci +=(char) ( plch[i]^sub_keys[i]);

        }
        return ci;
    }
    static String decrypt(String plain , String key){
        char [] plch = plain.toCharArray();
        String  ci = "";
        char [] S= initial(key);
        char [] sub_keys = key_gene(S, plch.length);
        for (int i = 0; i < sub_keys.length; i++) {
            //ci += Integer.toString( plch[i]^sub_keys[i]);
            ci +=(char) ( plch[i]^sub_keys[i]);
        }
        return ci;
    }


}

