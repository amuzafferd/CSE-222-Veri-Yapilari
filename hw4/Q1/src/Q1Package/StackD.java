/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amd3 on 20.03.2017.
 */
public class StackD<E> implements StackInterface<E>
{
    Queue<E> myQueue;

    /**
     * no parameter constructor
     */
    public StackD() {
        myQueue = new LinkedList<E>();
    }

    @Override
    public E pop() {
        return myQueue.remove();
    }

    @Override
    public void push(E other) {
        myQueue.add(other);
        for (int i=0; i<size()-1; i++)
            myQueue.add(myQueue.remove());
    }

    @Override
    public boolean isEmpty() {
        if (myQueue.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return myQueue.size();
    }

    @Override
    public String toString() {
        String myString = "";

        if (size()<=0)
            throw new EmptyStackException();

        for (int i = size() - 1; i >= 0; i--)
            myString += pop() + " ";


        return myString;
    }
}
