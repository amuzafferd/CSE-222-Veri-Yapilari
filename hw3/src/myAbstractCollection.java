/**
 * Created by Ahmet Muzaffer Dülger on 13.03.2017.
 */

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

public class myAbstractCollection extends AbstractCollection
{

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * parametre olarak gelen iki objeyi birbirine ekler ve ekrana basar
     * @param other1
     * @param other2
     */
    public void appendAnything(AbstractCollection other1, AbstractCollection other2)
    {
        ArrayList temp = new ArrayList();
        temp.addAll(other1);
        temp.addAll(other2);

        System.out.println(temp);
    }
}
