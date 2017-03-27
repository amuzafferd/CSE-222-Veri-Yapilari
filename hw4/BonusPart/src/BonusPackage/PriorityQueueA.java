/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package BonusPackage;
import java.util.LinkedList;

public class PriorityQueueA<E> extends LinkedList<E>
{
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    /**
     * parametre olarak aldigi elemanı queue'ya ekler
     * @param element queue'ya eklenecek eleman
     */
    public void insert(E element){
        super.add(element);
    }

    /**
     * queue'daki en kucuk elemani silip ekrana basar
     * @return minimumValue
     */
    public String deleteMin(){
        String minimumValue = get(0).toString();

        for (int i = 0; i < size(); i++) {

            if (get(i) instanceof String)
            {
                if(minimumValue.compareTo(get(i).toString())>0)
                    minimumValue = get(i).toString();
            }
            else if(minimumValue.compareTo(get(i).toString())>0)
                if(minimumValue.length()>=get(i).toString().length()){
                    minimumValue = get(i).toString();
                }
        }
        for (int i = 0; i < size(); i++) {
            if(minimumValue == get(i))
                remove(i);
        }
        return minimumValue;
    }

    @Override
    public String toString() {
        String myString = "";

        for (int i = 0 ; i < size(); i++)
            myString += get(i) + " ";

        return myString;
    }

}
