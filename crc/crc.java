package crc;

import java.util.*;

class crc {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Emter the message code");
        String message = sc.nextLine();
        System.out.println("Emter the generator code");
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
                for (int j = 0; j < divisor.length; j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }
        System.out.println("Checksum code is: ");
        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }
        for (int i : data) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Emter the checksum");
        String checksum = sc.nextLine();
        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(checksum.charAt(i) + "");
        }
        for (int i = 0; i < checksum.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }
        boolean valid = true;
        for (int ele : data) {
            if (ele == 1) {
                valid = false;
                break;
            }
        }
        if (valid)
            System.out.println("Valid stream");
        else
            System.out.println("Invalid stream");
    }

}