
public class CaesarCipher {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String message, int key) {
        int length = alphabet.length();
        if (key >= length) {
            key = key % length;
            System.out.println("key: " + key);
        }

        String codeAlphabet = alphabet.substring(alphabet.length() - key) + alphabet.substring(0, alphabet.length() - key);
        System.out.println(codeAlphabet);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (message.charAt(i) == alphabet.charAt(j)){
                    stringBuilder.append(codeAlphabet.charAt(j));
                }
                if (alphabet.indexOf(message.charAt(i)) == -1){
                    stringBuilder.append(message.charAt(i));
                    break;
                }

                //System.out.println("message.charAt(i): " + message.charAt(i) + " alphabet.charAt(j): " + alphabet.charAt(j) + " codeAlphabet.charAt(j): " + codeAlphabet.charAt(j));
            }

        }
        System.out.println(stringBuilder);

        return stringBuilder.toString();

    }

    public String decrypt(String message, int key) {
        return "";
    }


}
