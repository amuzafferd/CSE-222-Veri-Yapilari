/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by amd3 on 20.03.2017.
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E>
{
    /**
     * no parameter constructor
     */
    public StackA()
    {
        super();
    }

    @Override
    public E pop() {
        int sizeOfArray = this.size();
        return remove(sizeOfArray-1);
    }

    @Override
    public void push(E other) {
        add(other);
    }

    @Override
    public boolean isEmpty()
    {
        if(size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public int size()
    {
        return super.size();
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

