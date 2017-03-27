/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q2Package;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        try {

            Scanner myscan = new Scanner(new File("test.csv")).useDelimiter(",");
            PrintWriter pw = new PrintWriter("testResult_2.csv");

            while (myscan.hasNextLine()) {
                myQueue myQueue1 = new myQueue();
                myQueue myQueue2 = new myQueue();
                myQueue myQueue3 = new myQueue();
                myQueue myQueue4 = new myQueue();

                Queue tempQueue1 = new LinkedList();
                Queue tempQueue2 = new LinkedList();
                Queue tempQueue3 = new LinkedList();
                Queue tempQueue4 = new LinkedList();



                String temp = myscan.nextLine();
                String[] temp2 = temp.split(",");

                for (int i=0; i<temp2.length; i++) {
                    myQueue1.add(temp2[i]);
                    myQueue2.add(temp2[i]);
                    myQueue3.add(temp2[i]);
                    myQueue4.add(temp2[i]);

                    tempQueue1.add(temp2[i]);
                    tempQueue2.add(temp2[i]);
                    tempQueue3.add(temp2[i]);
                    tempQueue4.add(temp2[i]);
                }

                myQueue1.reverse();
                myQueue2.reverse();
                myQueue3.reverse();
                myQueue4.reverse();

                pw.write("**************** Reverse() ****************\n");
                pw.write("Size 1: " + myQueue1.size() + " " + "Queue 1: " + myQueue1.toString() + "\n");
                pw.write("Size 2: " + myQueue2.size() + " " + "Queue 2: " + myQueue2.toString() + "\n");
                pw.write("Size 3: " + myQueue3.size() + " " + "Queue 3: " + myQueue3.toString() + "\n");
                pw.write("Size 4: " + myQueue4.size() + " " + "Queue 4: " + myQueue4.toString() + "\n");


                pw.write("************** reverseQueue() **************\n");
                pw.write("Size 5: " + myQueue1.size() + " " + "Queue 5: " + myQueue1.reverseQueue(tempQueue1) + "\n");
                pw.write("Size 6: " + myQueue2.size() + " " + "Queue 6: " + myQueue2.reverseQueue(tempQueue2) + "\n");
                pw.write("Size 7: " + myQueue3.size() + " " + "Queue 7: " + myQueue3.reverseQueue(tempQueue3) + "\n");
                pw.write("Size 8: " + myQueue4.size() + " " + "Queue 8: " + myQueue4.reverseQueue(tempQueue4) + "\n");



            }
            pw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
