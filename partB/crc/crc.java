package partB.crc;

import java.util.*;
import java.math.*;

class crc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message bits");
        String message = sc.nextLine();

        System.out.println("Enter the generator bits");
        String generator = sc.nextLine();
        int[] data = new int[message.length() + generator.length() - 1];
        int[] divisor = new int[generator.length()];

        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        for (int i = 0; i < generator.length(); i++) {
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < generator.length(); j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }

        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        System.out.println("Checksum code is :");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
        System.out.println("Enter the checksum code : ");
        String checksum = sc.nextLine();
        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];

        for (int i = 0; i < checksum.length(); i++) {
            data[i] = Integer.parseInt(checksum.charAt(i) + "");
        }

        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < generator.length(); j++)
                    data[i + j] ^= divisor[j];
            }
        }

        boolean isValid = true;
        for (int num : data) {
            if (num == 1) {
                isValid = false;
                break;
            }
        }
        if (isValid)
            System.out.println("Invalid Data Stream");
        else
            System.out.println("Valid Data Stream");

    }
}