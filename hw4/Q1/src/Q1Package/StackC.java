/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;
import java.util.EmptyStackException;

/**
 * Created by amd3 on 20.03.2017.
 */
public class StackC<E> implements StackInterface<E>
{
    private Node<E> head;
    private int size;

    /**
     * no parameter constructor
     */
    public StackC() {
        head = new Node<E>();
        size = 0;
    }

    @Override
    public E pop()
    {
        if (isEmpty()) {
            return null;
        } else {
            E item = head.data;
            head = head.next;
            size--;
            return item;
        }
    }

    @Override
    public void push(E other)
    {
        Node<E> newNode = new Node<E>(other);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public boolean isEmpty()
    {
        if(this.size == 0)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String myString = "";


        if(size()<=0)
            throw new EmptyStackException();

        for (int i = size()-1; i >=0; i--) {
            myString += pop() + " ";
        }

        return myString;
    }

    /**
     * node inner class
     */
    private class Node<E>
    {
        private E data;
        private Node<E> next;

        /**
         * no parameter constuctor
         */
        public Node()
        {
            this.data = null;
            this.next = null;
        }

        /**
         * constructor
         * @param dataItem data
         */
        public Node(E dataItem)
        {
            this.data = dataItem;
            this.next = null;
        }

        /**
         * two parameter constructor
         * @param dataItem
         * @param nodeRef
         */
        public Node(E dataItem, Node<E> nodeRef)
        {
            this.data = dataItem;
            this.next = nodeRef;
        }
    }
}

