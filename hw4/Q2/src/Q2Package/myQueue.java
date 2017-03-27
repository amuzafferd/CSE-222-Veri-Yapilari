/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q2Package;
import java.util.ListIterator;
import java.util.Queue;

public class myQueue<E> extends KWLinkedList {

    /**
     * no parameter constructor
     */
    public myQueue() {
        super();
    }

    /**
     *  queue'yu recursive olarak ters ceviren fonksiyon
     */
    public void reverse() {
        E nextOfFirst;
        E PreviousOfLast;

        ListIterator<E> firstValue = listIterator();
        ListIterator<E> lastValue = listIterator(size);
        for (int i = 0; i < size / 2; i++) {
            nextOfFirst = firstValue.next();
            PreviousOfLast = lastValue.previous();
            firstValue.set(PreviousOfLast);
            lastValue.set(nextOfFirst);
        }
    }

    /**
     * parametre olarak aldiği queue objesini ters ceviren fonskiyon
     * @param myQ ters cevrilecek queue objesi
     * @return myQ2
     */
    public Queue<E> reverseQueue(Queue<E> myQ) {
        if (myQ.isEmpty())
            return myQ;
        else {
            E temp = myQ.poll();
            Queue<E> myQ2 = reverseQueue(myQ);
            myQ2.offer(temp);
            return myQ2;
        }
    }

    /**
     * myQueue class'inin toString() override'i
     * @return myString
     */
    @Override
    public String toString() {
        String myString = "";

        for (int i = 0 ; i < size(); i++)
            myString += get(i) + " ";

        return myString;
    }
}