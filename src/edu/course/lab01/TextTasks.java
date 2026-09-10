package edu.course.lab01;

public class TextTasks {

    static public String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; --i) {
            result += str.charAt(i);
        }

        return result;
    }

    static public Boolean palindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (right > left) {
            char ch1 = str.charAt(left);
            char ch2 = str.charAt(right);
            if (!(Character.isAlphabetic(ch1) || Character.isDigit(ch1))) {
                left++;
                continue;
            }

            if (!(Character.isAlphabetic(ch2) || Character.isDigit(ch2))) {
                right--;
                continue;
            }

            ch1 = Character.toLowerCase(ch1);
            ch2 = Character.toLowerCase(ch2);

            if (Character.compare(ch1, ch2) != 0) return false;
            left++;
            right--;

        }
        return true;
    }
}
