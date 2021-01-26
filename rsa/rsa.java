package rsa;

import java.util.Scanner;

public class rsa {
    public static void main(String[] args) {
        int p = 0, q = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted: ");
        String message = in.nextLine();
        char[] msgA = message.toCharArray();
        boolean check = false;
        while (!check) {
            System.out.println("Enter two prime numbers: ");
            p = in.nextInt();
            q = in.nextInt();
            if (checkPrime(p) && checkPrime(q))
                check = true;
        }
        int n = p * q;
        int z = (p - 1) * (q - 1);
        int e = 0;
        for (int i = 2; i < z; i++) {
            if (gcd(i, z) == 1) {
                e = i;
                break;
            }
        }
        System.out.println("The value of e: " + e);
        System.out.println("Public key: (" + n + ", " + e + ")");
        int d;
        for (d = 2; d < z; d++)
            if ((e * d) % z == 1)
                break;
        System.out.println("The value of d: " + d);
        // ENCRYPTION => CONVERTING TO CIPHER TEXT
        int[] a = new int[message.length()];
        int[] c = new int[message.length()];
        int t = 0;
        for (int i = 0; i < message.length(); i++) {
            a[i] = (int) msgA[i];
            t = 1;
            for (int j = 0; j < e; j++)
                t = (t * a[i]) % n;
            c[i] = t;
        }
        System.out.println("Message ASCII Cipher");
        for (int i = 0; i < message.length(); i++)
            System.out.println(" " + msgA[i] + "\t " + a[i] + "\t " + c[i]);
        System.out.println("Message Cipher");
        for (int i = 0; i < message.length(); i++)
            System.out.print(c[i]);
        char cha[] = new char[message.length()];
        // DECRYPTION => CONVERTING CIPHER BACK TO MESSAGE
        System.out.println("\nDecrypting...");
        for (int i = 0; i < message.length(); i++) {
            t = 1;
            for (int j = 0; j < d; j++)
                t = (t * c[i]) % n;
            cha[i] = (char) t;
        }
        for (char ch : cha)
            System.out.print(ch);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static boolean checkPrime(int num) {
        if (num == 0 || num == 1)
            return false;
        else if (num == 2)
            return true;
        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;
        return true;
    }
}