/**
 * Created by Ahmet Muzaffer Dülger on 13.03.2017.
 * Bu proje soru 1, soru 2 ve soru 3'ü içermektedir.
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            myStringBuilder myBuilder = new myStringBuilder();
            myStringBuilder myBuilder2 = new myStringBuilder();

            FileWriter fw = new FileWriter("result1.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            FileWriter fw3 = new FileWriter("result3.txt");
            BufferedWriter bw3 = new BufferedWriter(fw3);


            Scanner myForUser = new Scanner( new File("numbers.txt"));
            while (myForUser.hasNext()) {
                myBuilder.append(myForUser.next());
            }

            myBuilder2.append("CSE");
            myBuilder2.append("-");
            myBuilder2.append("222");
            myBuilder2.append("Veri");
            myBuilder2.append("Yapilari");


            bw.write(myBuilder.toString1());
            bw3.write(myBuilder.toString3());


            System.out.println("After reverse\n" + myBuilder2.myLinkList.reverseToString(myBuilder2.myLinkList.getHead()));

            bw.close();
            bw3.close();
            fw.close();
            fw3.close();
        }
        catch (Exception e)
        {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}