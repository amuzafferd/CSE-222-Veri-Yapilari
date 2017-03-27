/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by amd3 on 24.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        try
        {
            StackA myStackA = new StackA();
            StackB myStackB = new StackB();
            StackC myStackC = new StackC();
            StackD myStackD = new StackD();

            Scanner myscan = new Scanner(new File("test.csv")).useDelimiter(",");
            PrintWriter pw = new PrintWriter("testResult_1.csv");

            while (myscan.hasNextLine()) {
                String temp = myscan.nextLine();
                String[] temp2 = temp.split(",");

                for (int i=0; i<temp2.length; i++) {
                    myStackA.push(temp2[i]);
                    myStackB.push(temp2[i]);
                    myStackC.push(temp2[i]);
                    myStackD.push(temp2[i]);
                }

                pw.write("Size A: " + myStackA.size() + " " + "StackA: " + myStackA.toString() + "\n");
                pw.write("Size B: " + myStackB.size() + " " + "StackB: " + myStackB.toString() + "\n");
                pw.write("Size C: " + myStackC.size() + " " + "StackC: " + myStackC.toString() + "\n");
                pw.write("Size D: " + myStackD.size() + " " + "StackD: " + myStackD.toString() + "\n");

            }
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Dosya hatasi: " + e);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}
