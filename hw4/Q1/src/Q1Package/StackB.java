/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by amd3 on 20.03.2017.
 */
public class StackB<E> implements StackInterface<E> {

    public ArrayList<E> myArrayList;

    /**
     * no parameter constructor
     */
    public StackB() {
        myArrayList = new ArrayList<E>();
    }

    @Override
    public E pop() {
        int sizeOfStack = this.size();
        return myArrayList.remove(sizeOfStack-1);
    }

    @Override
    public void push(E other) {
        myArrayList.add(other);
    }

    @Override
    public boolean isEmpty() {
        if(myArrayList.isEmpty() == true)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return myArrayList.size();
    }

    @Override
    public String toString() {
        String myString = "";


        if (size()<=0)
            throw new EmptyStackException();

        for (int i = size() - 1; i >=0; i--)
            myString += pop() + " " ;

        return myString;
    }

}
