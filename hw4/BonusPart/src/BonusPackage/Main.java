/**
 * Created by amd3 on 24.03.2017.
 */

package BonusPackage;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        try
        {
            Scanner myscan = new Scanner(new File("test.csv")).useDelimiter(",");
            PrintWriter pw = new PrintWriter("testResult_3.csv");

            while (myscan.hasNextLine()) {
                PriorityQueueA myPQA1 = new PriorityQueueA();
                PriorityQueueB myPQB1 = new PriorityQueueB();

                String temp = myscan.nextLine();
                String[] temp2 = temp.split(",");

                for (int i=0; i<temp2.length; i++) {
                    myPQA1.insert(temp2[i]);
                    myPQB1.insert(temp2[i]);
                }

                System.out.println("A1: " + myPQA1.deleteMin());
                System.out.println("B1: " + myPQB1.deleteMin());

                pw.write("Size A1: " + myPQA1.size() + " " + "A 1: " + myPQA1.toString() + "\n");
                pw.write("Size B1: " + myPQB1.size() + " " + "B 1: " + myPQB1.toString() + "\n");
            }
            pw.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
