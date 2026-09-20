public class Task4TextProcessing {
    public static void run() {
        subTask1();
        subTask2();
        subTask3();
        subTask4();
        subTask5();
    }

    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();

        if (cleanStr.isEmpty()) return true;

        String reversedStr = new StringBuilder(cleanStr).reverse().toString();

        return cleanStr.equals(reversedStr);
    }

    public static boolean isPalindrome(char[] str) {
        return isPalindrome(String.valueOf(str));
    }


    public static void subTask1() {
        final String str = "А роза упала на лапу Азора";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str.toCharArray()));

    }

    public static String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] chars = input.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);

        int start = 0;
        for (int end = 0; end < n; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        reverse(chars, start, n - 1);

        return new String(chars);
    }

    public static char[] reverseWords(char[] str) {
        return reverseWords(String.valueOf(str)).toCharArray();
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void subTask2() {
        String str = "А роза упала на лапу Азора";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords(str.toCharArray()));
    }

    public static void subTask3() {
        String str = "А9 роза 5упала 1на лапу Аз0ора";
        final String VOWELS = "aeiouyаеёиоуыэюя";
        final String CONSONANTS = "bcdfghjklmnpqrstvwxyzбвгджзйклмнпрстфхцчшщ";
        int vowelsCounter = 0;
        int consonantsCounter = 0;
        int whitespacesCounter = 0;
        int numbersCounter = 0;


        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch == ' ') whitespacesCounter++;
            else if (Character.isDigit(ch)) numbersCounter++;
            else if (VOWELS.indexOf(ch) != -1) vowelsCounter++;
            else if (CONSONANTS.indexOf(ch) != -1) consonantsCounter++;

        }

        System.out.println("Строка: " + str +
                "\nКоличество гласных: " + vowelsCounter +
                "\nКоличество согласных: " + consonantsCounter +
                "\nКоличество пробелов: " + whitespacesCounter +
                "\nКоличество цифр: " + numbersCounter);
    }

    public static String encrypt(String text, int k) {
        if (text.isEmpty()) return "";

        k = (k % 26 + 26) % 26;
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (ch >= 'a' && ch <= 'z') {
                chars[i] = (char) ('a' + (ch - 'a' + k) % 26);
            } else if (ch >= 'A' && ch <= 'Z') {
                chars[i] = (char) ('A' + (ch - 'A' + k) % 26);
            }
        }

        return String.valueOf(chars);
    }

    public static String decrypt(String text, int k) {
        return encrypt(text, -k);
    }

    public static void subTask4() {
        String str = "zdarova mir";
        String encryptedStr = encrypt(str, 5);
        System.out.println("Encrypted str: " + encryptedStr);
        String decryptedStr = decrypt(encryptedStr, 5);
        System.out.println("Decrypted str: " + decryptedStr);

    }

    public static String findLongestWord(String text) {
        if (text.isEmpty()) return "";


        char[] chars = text.toCharArray();
        int maxStart = 0;
        int maxLength = 0;

        int currentStart = 0;
        int currentLength = 0;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                if (currentLength == 0) {
                    currentStart = i;
                }
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
                currentLength = 0;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStart = currentStart;
        }

        if (maxLength == 0) {
            return "";
        }

        return String.valueOf(chars, maxStart, maxLength);
    }

    public static void subTask5() {
        String str = "А роза упала на лапу Азора";
        System.out.println("Предложение: " + str);
        System.out.println("Самое длинное слово: " + findLongestWord(str));
    }

}
