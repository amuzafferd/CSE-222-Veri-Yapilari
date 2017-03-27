/**
 * Created by Ahmet Muzaffer Dülger on 13.03.2017.
 */

public class myStringBuilder<E>
{
    protected SingleLinkedList<E> myLinkList;

    public myStringBuilder()
    {
        myLinkList = new SingleLinkedList<E>();
    }

    /**
     * gelen parametreyi link list e ekler
     * @param other
     * @return this
     * @throws Exception
     */
    public myStringBuilder append(char other) throws Exception
    {
        if(other == ' ')
            throw new Exception("Bos karakter");
        else
            myLinkList.add(other);
        return this;
    }

    /**
     * gelen parametreyi link list e ekler
     * @param other
     * @return this
     * @throws Exception
     */
    public myStringBuilder append(String other) throws Exception
    {
        if(other == null)
            throw new Exception("Bos string");
        else
            myLinkList.add(other);
        return this;
    }

    /**
     * gelen parametreyi link list e ekler
     * @param other
     * @return this
     */
    public myStringBuilder append(int other)
    {
        myLinkList.add(other);
        return this;
    }

    /**
     * gelen parametreyi link list e ekler
     * @param other
     * @return this
     */
    public myStringBuilder append(double other)
    {
        myLinkList.add(other);
        return this;
    }

    /**
     * gelen parametreyi link list e ekler
     * @param other
     * @return this
     */
    public myStringBuilder append(float other)
    {
        myLinkList.add(other);
        return this;
    }

    /**
     * Uses indexes and get method
     * @throws Exception
     */
    public String toString1() throws Exception
    {
        String list = "";

        for (int i = 0; i < myLinkList.getSize(); i++) {
            list += myLinkList.get(i);
            list += ' ';
        }

        return list;
    }

    /**
     * Uses toString method of the linked list
     * @throws Exception
     */
    public String toString3() throws Exception
    {
        String list = "";

        list += myLinkList.toString();

        return list;
    }
}