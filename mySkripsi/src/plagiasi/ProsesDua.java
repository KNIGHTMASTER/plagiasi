/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiasi;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.provider.MD5;

/**
 *
 * @author idrus
 */
public class ProsesDua {

    int hashValue;
    int basisValue;
    int windowValue;
    
    BigInteger[] fingerprint = new BigInteger[10000000];

    void mainframe(String DATA_PATH) throws FileNotFoundException {
        String value = null;
        String words = null;
 
        int i = 0;
        char[] a = new char[hashValue];
        int j = 0;
        int z = 0;
        int c = 0;
        BigInteger temp = new BigInteger("0");
        BigInteger[] hash = new BigInteger[10000000];
        BigInteger[][] window = new BigInteger[1000][100];

        words = doFilter(DATA_PATH);
        System.out.println(""+words);
        words = words.toLowerCase();
        String kata[] = words.split(" ");
       System.out.println(""+kata.length);
        
        String gabung_kata[] = new String[kata.length - 1];
        System.out.println(" panjang kata = "+gabung_kata.length);
        String hasil_gabung = "";
        for (int k = 0; k < kata.length - 1; k++) {
            try {
                gabung_kata[k] = kata[k] + " " + kata[k + 1];
                MessageDigest m = MessageDigest.getInstance("MD5");
                m.update(gabung_kata[k].getBytes(),0,gabung_kata[k].length());
                System.out.println("gabung kata = "+gabung_kata[k]);
                hasil_gabung = ""+new BigInteger(1,m.digest()).toString(16);
                if(hasil_gabung.length() < 32){
                    hasil_gabung = "0"+hasil_gabung;
                }
                System.out.println(""+hasil_gabung);
                
                hash[k] = rollingHash(hasil_gabung.toCharArray());
            }
//        for (i = 0; i <= words.length() - hashValue; i++) {
//            z = i;
//            for (j = 0; j < hashValue; j++) {
//                a[j] = words.charAt(z);
//                System.out.print(""+a[j]);
//                z += 1;
//            }
//            
//            hash[i] = rollingHash(a);
//
//        }
            catch (NoSuchAlgorithmException ex) {
                System.out.println("error");
                Logger.getLogger(ProsesDua.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (i = 0; i <= gabung_kata.length - windowValue; i++) {
            z = i;
            for (j = 0; j < windowValue; j++) {
                window[i][j] = new BigInteger(""+hash[z]);
                z += 1;
                System.out.println("window = "+window[i][j]);
            }
        }

        for (i = 0; i <= gabung_kata.length - windowValue; i++) {
            temp = min(window[i]);
//            System.out.println("min = "+temp);
            j = 0;
            while (fingerprint[j]!=null) {
                if (temp.toString().equals(""+fingerprint[j].toString())) {
                    break;
                }
                j++;
            }
            if (fingerprint[j]==null) {
                fingerprint[c] = new BigInteger(""+temp);
                c += 1;
                System.out.println("fingerprint = "+fingerprint[c-1]);
            }
        }
    }

    public int hitung(BigInteger[] a) {
        int b = 0, jum = 0;
        while (a[b]!=null) {
            b++;
            jum++;

        }
        return jum;

    }

    public BigInteger min(BigInteger[] a) {
        BigInteger min = new BigInteger(""+a[0]);
        for (int i = 1; i < windowValue; i++) {
            if (min.compareTo(a[i])==1){
                min = new BigInteger(""+a[i].toString());
            }
        }
        return min;

    }

    public BigInteger rollingHash(char[] sub) {
        BigInteger hash_value = new BigInteger("0");
//        BigInteger upil =new BigInteger("20000000000000000000000000");
//        System.out.println("upil :"+upil.add(new BigInteger("3000000000000")));
        int ascii;
        BigInteger prev_hash = new BigInteger("0");
        int basis = basisValue;
        int c_awal = 0;
        int length = sub.length - 1;
        if (prev_hash.toString().equals("0")) {
            for (int i = 0; i <= length; i++) {
                ascii = sub[i];
                new BigInteger("676").pow(9);
                
                hash_value = new BigInteger(""+new BigInteger(""+hash_value.toString()).add(new BigInteger(""+ascii).multiply(new BigInteger(""+basis).pow(length - i))).toString());
              //  System.out.println("basis = " +basis);
              //  System.out.println("lenght = "+length);
              //  System.out.println("X = "+hash_value+ " asci = "+ascii+" pangkat = "+Math.pow(basis, length - i));
             //   System.out.println(" "+hash_value+ " "+(long)ascii+" "+(long)Math.pow(basis, length - i));
            }
        } else {
            //hash_value = prev_hash - (long) (c_awal * Math.pow(basis, length));
            hash_value = new BigInteger(""+prev_hash.subtract(new BigInteger(""+c_awal).multiply(new BigInteger(""+basis).pow(length))));
            //hash_value *= basis;
            hash_value = new BigInteger(""+hash_value.multiply(new BigInteger(""+basis)));
            //hash_value += sub[length];
            hash_value = new BigInteger(""+hash_value.multiply(new BigInteger(""+sub[length])));
        }
        c_awal = sub[0];
        //prev_hash = (int) hash_value;
        prev_hash = new BigInteger(""+hash_value.toString());
        System.out.println(" hash value = "+hash_value);

        return hash_value;
    }

    public static String doFilter(String sourceDocument) {
        sourceDocument = sourceDocument.replaceAll("[^A-Za-z0-9 ]", "");
   //     sourceDocument = sourceDocument.replaceAll("\\s+", "");
        sourceDocument = sourceDocument.replace(".", "");
        sourceDocument = sourceDocument.replace(",", "");
        sourceDocument = sourceDocument.replace(":", "");
        sourceDocument = sourceDocument.replace("\n", "");
    //    sourceDocument = sourceDocument.replace("\r", "");
     //  sourceDocument = sourceDocument.replace(" ", "");
        //System.out.println(""+sourceDocument);
        return sourceDocument;
    }

}
