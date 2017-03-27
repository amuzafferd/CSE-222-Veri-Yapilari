/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package BonusPackage;
import java.util.LinkedList;

public class PriorityQueueB<E>
{
    private LinkedList myQ;

    /**
     * no parameter constructor
     */
    public PriorityQueueB()
    {
        myQ = new LinkedList();
    }

    /**
     * queue'nun bos olup olmadigini kontrol eder
     * @return myQ.isEmpty()
     */
    public boolean isEmpty() {
        return myQ.isEmpty();
    }

    /**
     * queue'nun eleman sayisini return eder
     * @return myQ.size()
     */
    public int size() {
        return myQ.size();
    }

    /**
     * parametre olarak aldigi elemani queue'ya ekler
     * @param element queue'ya eklenecek eleman
     */
    public void insert(E element){
        myQ.add(element);
    }

    /**
     * queue'da bulunan en kucuk elemani siler
     * @return minimumValue
     */
    public String deleteMin(){
        String minimumValue = myQ.get(0).toString();

        for (int i = 0; i < size(); i++) {

            if (myQ.get(i) instanceof String)
            {
                if(minimumValue.compareTo(myQ.get(i).toString())>0)
                    minimumValue = myQ.get(i).toString();
            }
            else if(minimumValue.compareTo(myQ.get(i).toString())>0)
                if(minimumValue.length()>=myQ.get(i).toString().length()){
                    minimumValue = myQ.get(i).toString();
                }
        }
        for (int i = 0; i < size(); i++) {
            if(minimumValue == myQ.get(i))
                myQ.remove(i);
        }
        return minimumValue;
    }

    @Override
    public String toString() {
        String myString = "";

        for (int i = 0 ; i < size(); i++)
            myString += myQ.get(i) + " ";

        return myString;
    }

}
