/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiasi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author idrus
 */
public class ProsesSatu {

    int hashValue;
    int basisValue;
    int windowValue;
    
    long[] fingerprint = new long[10000000];

    void mainframe(String DATA_PATH) throws FileNotFoundException {
        String value = null;
        String words = null;
   //     File f = new File(DATA_PATH);
   //     StringBuilder sb = new StringBuilder();
   //     Scanner scanner = new Scanner(f);
   //     scanner.useDelimiter("\n");

        int i = 0;
        char[] a = new char[hashValue];
        int j = 0;
        int z = 0;
        int c = 0;
        long temp = 0;
        long[] hash = new long[10000000];
        long[][] window = new long[1000][100];
//        while (scanner.hasNext()) {
//            value = scanner.next();
//            value = value.replace("\n", "");
//            value = value.replace("\r", "");
//            value = value.replace(" ", "");
//
//            sb.append(value + "");
//        }

        words = doFilter(DATA_PATH);
        words = words.toLowerCase();

        for (i = 0; i <= words.length() - hashValue; i++) {
            z = i;
            for (j = 0; j < hashValue; j++) {
                a[j] = words.charAt(z);
                //System.out.print(""+a[j]);
                z += 1;
            }
            
            //nilai a salah. coba a[j] diconvert jadi string (array ke string)
            hash[i] = rollingHash(a);
//            System.out.println(" Hash = "+hash[i]);

        }
        for (i = 0; i <= words.length() - hashValue; i++) {
            z = i;
            for (j = 0; j < windowValue; j++) {
                window[i][j] = hash[z];
                z += 1;

            }
        }

        for (i = 0; i <= words.length() - hashValue; i++) {
            temp = min(window[i]);
            j = 0;
            while (fingerprint[j] != 0) {
                if (temp == fingerprint[j]) {
                    break;
                }
                j++;
            }
            if (fingerprint[j] == 0) {
                fingerprint[c] = temp;
                c += 1;
            }
        }
    }

    public int hitung(long[] a) {
        int b = 0, jum = 0;
        while (a[b] != 0) {
            b++;
            jum++;

        }
        return jum;

    }

    public long min(long[] a) {
        long min = a[0];
        for (int i = 1; i < windowValue; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;

    }

    public Long rollingHash(char[] sub) {
        long hash_value = 0;
        int ascii;
        int prev_hash = 0;
        int basis = basisValue;
        int c_awal = 0;
        int length = sub.length - 1;
        if (prev_hash == 0) {
            for (int i = 0; i <= length; i++) {
                ascii = sub[i];
                hash_value += ((long) ((long)ascii * (long)Math.pow(basis, length - i)));
//                System.out.println("basis = " +basis);
//                System.out.println("lenght = "+length);
//                System.out.println("X = "+hash_value+ " asci = "+ascii+" pangkat = "+Math.pow(basis, length - i));
//                System.out.println(" "+hash_value+ " "+(long)ascii+" "+(long)Math.pow(basis, length - i));
            }
        } else {
            hash_value = prev_hash - (long) (c_awal * Math.pow(basis, length));
            hash_value *= basis;
            hash_value += sub[length];
        }
        c_awal = sub[0];
        prev_hash = (int) hash_value;

        return hash_value;
    }

    public static String doFilter(String sourceDocument) {
        sourceDocument = sourceDocument.replaceAll("[^A-Za-z0-9]", "");
        sourceDocument = sourceDocument.replaceAll("\\s+", "");
        sourceDocument = sourceDocument.replace(".", "");
        sourceDocument = sourceDocument.replace(",", "");
        sourceDocument = sourceDocument.replace(":", "");
        sourceDocument = sourceDocument.replace("\n", "");
        sourceDocument = sourceDocument.replace("\r", "");
        sourceDocument = sourceDocument.replace(" ", "");
        //System.out.println(""+sourceDocument);
        return sourceDocument;
    }

}
