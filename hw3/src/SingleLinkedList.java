/**
 * Created by Ahmet Muzaffer Dülger on 13.03.2017.
 */

public class SingleLinkedList<E>
{

    private Node<E> head;
    private int size;

    /**
     * node u return eder.
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * size ı return eder.
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * head i set eder.
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * size ı set eder.
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * no parameter constructor
     */
    public SingleLinkedList()
    {
        head = null;
        size = 0;
    }

    /**
     * single link list e gelen data yı ekler.
     * @param data
     */
    public void add(Object data)
    {
        Node temp = new Node(data);
        Node curr = head;

        if (head == null)
        {
            head = temp;
            ++size;
        }
        else
        {
            while (curr.getNext() != null)
            {
                curr = curr.getNext();
            }

            curr.setNext(temp);
            ++size;
        }
    }

    /**
     * verilen indexteki datayı return eder.
     * @param index
     * @return curr.getData()
     */
    public Object get(int index)
    {
        Node curr = head;
        for (int i = 0; i < index; i++)
        {
            curr = curr.getNext();
        }

        return curr.getData();
    }

    /**
     * verilen indexteki datayı siler
     * @param index
     */
    public void remove(int index)
    {
        Node curr = head;

        if (index == 0) {
            head = head.getNext();
        } else {
            for (int i = 1; i < index; i++)
            {
                curr = curr.getNext();
            }

            curr.setNext(curr.getNext().getNext());
        }

        this.size--;
    }

    /**
     * size ı return eder.
     * @return this.size
     */
    public int size()
    {
        return this.size;
    }

    /**
     * gönderilen link listi ve içerisindeki stringleri ters çevirir.
     * @param other
     * @return string
     */
    public String reverseToString(Node<String> other)
    {
        if (other == null || other.getNext() == null) {
            return reverse(other.getData());
        }

        return reverseToString(other.getNext()) + "<--" + reverse(other.getData());
    }

    /**
     * gönderilen stringi ters çevirir
     * @param source
     * @return string
     */
    public String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }

        return reverse;
    }

    /**
     * @return string
     */
    public String toString(){
        String retStr = "";

        Node<E> current = head;
        while(current != null){
            retStr += current.getData() + " ";
            current = current.getNext();

        }
        return retStr;
    }
}