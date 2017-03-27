/**
 * Created by Ahmet Muzaffer Dülger on 24.03.2017.
 */

package Q1Package;

public interface StackInterface<E>
{
    /**
     * eleman silme islemi gerceklesir
     */
    public E pop();

    /**
     * parametre olarak gelen elemanı stack e ekler
     * @param other stack'e eklenecek eleman
     */
    public void push(E other);

    /**
     *  stack'in bos olup olmadigini kontrol eder
     * @return emptyOrNotEmpty
     */
    public boolean isEmpty();

    /**
     * stack'in eleman sayisini return eder
     * @return size
     */
    public int size();
}
