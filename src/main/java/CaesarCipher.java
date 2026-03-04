
public class CaesarCipher {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String message, int key) {
        String codeAlphabet = codeAlphabet(key);
        System.out.println(codeAlphabet);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (message.charAt(i) == alphabet.charAt(j)) {
                    stringBuilder.append(codeAlphabet.charAt(j));
                }
                if (alphabet.indexOf(message.charAt(i)) == -1) {
                    stringBuilder.append(message.charAt(i));
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public String decrypt(String message, int key) {
        String codeAlphabet = codeAlphabet(key);
        System.out.println(codeAlphabet);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (message.charAt(i) == codeAlphabet.charAt(j)) {
                    stringBuilder.append(alphabet.charAt(j));
                }
                if (codeAlphabet.indexOf(message.charAt(i)) == -1) {
                    stringBuilder.append(message.charAt(i));
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public String codeAlphabet(int key) {
        int length = alphabet.length();
        if (key < 0) {
            while (key < 0) {
                key += length;
            }
        } else if (key >= length) {
            while ((key >= length)) {
                key -= length;
            }
        }
        int countingKey = key;
        System.out.println(key);
        String codeAlphabet;
        if (countingKey >= 0) {
            codeAlphabet = alphabet.substring(alphabet.length() - countingKey) + alphabet.substring(0, alphabet.length() - countingKey);
        } else {
            codeAlphabet = alphabet.substring(alphabet.length() + countingKey) + alphabet.substring(0, alphabet.length() + countingKey);
        }

        return codeAlphabet;
    }



}
