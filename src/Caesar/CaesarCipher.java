package Caesar;

public class CaesarCipher {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String cipherEncrypt(String msg, int shift) {
        msg = msg.toLowerCase();

        String cipherText = "";

        for (int i = 0; i < msg.length(); i++) {

            int charPosition = ALPHABET.indexOf(msg.charAt(i));

            int keyVal = (shift + charPosition) % 26;

            char replaceVal = ALPHABET.charAt(keyVal);

            cipherText += replaceVal;

        }

        return cipherText;
    }

    public String cipherDecypt(String msg, int shift) {
        msg = msg.toLowerCase();

        String plainText = "";

        for (int i = 0; i < msg.length(); i++) {

            int charPosition = ALPHABET.indexOf(msg.charAt(i));

            int keyVal = (charPosition - shift) % 26;

            if (keyVal < 0) {

                keyVal = ALPHABET.length() + keyVal;

            }

            char replaceVal = ALPHABET.charAt(keyVal);

            plainText += replaceVal;

        }

        return plainText;
    }

}