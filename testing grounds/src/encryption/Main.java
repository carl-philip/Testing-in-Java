package encryption;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String message = "CBT";
        long msg = strToLong(message);

        int p = 7919;
        int q = 7907;
        int n = p*q; //62 615 533
        int e = 401; // 401
        int d = 156109;

        long enc = crypt(msg, e, n);
        long dec = crypt(enc, d, n);

        System.out.println(longToStr(enc));
        System.out.println(longToStr(dec));
    }

    public static long crypt (long msg, int e, int n) {
        long tmp = 1;
        for (int i = 0; i < e; i++) {
            tmp = (tmp * msg) % n;
        }
        return tmp;
    }

    public static long strToLong(String s) {
        long dec = 0;
        for(int i = 0;i < s.length();i++) {
            dec += s.charAt(i) << i*8;
        }
        return dec;
    }

    public static String longToStr(long dec) {
        ArrayList<Character> letters = new ArrayList<Character>();
        long tmp = dec;
        char c;
        String message = "";
        while (tmp != 0) {
            c = (char) (tmp % Math.pow(2, 8));
            letters.add(c);
            tmp -= (int) c;
            tmp = tmp >> 8;
        }
        for (int i = 0;i < letters.toArray().length;i++) {
            message += letters.get(i);
        }
        return message;
    }
}
