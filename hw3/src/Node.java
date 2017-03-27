/**
 * Created by Ahmet Muzaffer Dülger on 13.03.2017.
 */

public class Node<E>
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
     *
     * @param dataItem
     * @param nodeRef
     */
    public Node(E dataItem, Node<E> nodeRef)
    {
        this.data = dataItem;
        this.next = nodeRef;
    }

    /**
     * bir sonraki node u return eder.
     * @return next
     */
    public Node<E> getNext()
    {
        return next;
    }

    /**
     * node daki datayı getirir.
     * @return data
     */
    public E getData()
    {
        return data;
    }

    /**
     * bir sonraki node u set eder.
     * @param other
     */
    public void setNext(Node<E> other)
    {
        this.next = other;
    }

    /**
     * datayı set eder.
     * @param other
     */
    public void setData(E other)
    {
        this.data = other;
    }
}