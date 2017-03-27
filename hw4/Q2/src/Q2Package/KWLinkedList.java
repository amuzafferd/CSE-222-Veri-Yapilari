/**
 * Created by amd3 on 24.03.2017.
 */
package Q2Package;

import java.util.*;

/** Class KWLinkedList implements a subset of the
 List interface using a double linked list
 and a ListIterator.
 @author Koffman and Wolfgang
 */

public class KWLinkedList extends AbstractSequentialList {

    // Data fields
    /** A reference to the head of the list */
    private Node head = null;
    /** A reference to the end of the list */
    private Node tail = null;
    /** The size of the list */
    protected int size = 0;

    // Methods
    /** Insert an object at the beginning of the list.
     @param obj - the object to be added
     */
    public void addFirst(Object obj) {
        add(0, obj);
    }

    /** Insert an object at the end of the list.
     @param obj - the object to be added
     */
    public void addLast(Object obj) {
        add(size, obj);
    }

    /** Add an item at the specified index.
     @param index - The index at which the object is to be
     inserted.
     @param obj - The object to be inserted.
     @throws IndexOutOfBoundsException - if the index is out
     of range (i < 0 || i > size()) */
    public void add(int index, Object obj) {
        listIterator(index).add(obj);
    }

    /** Get the first element in the list.
     @return The first element in the list.
     */
    public Object getFirst() {
        return head.data;
    }

    /** Get the last element in the list.
     @return The last element in the list.
     */
    public Object getLast() {
        return tail.data;
    }

    /** Get the element in the list specified by an index
     @param index The index of the element desired
     @return The value at the position specified
     */
    public Object get(int index) {
        return listIterator(index).next();
    }

    /** Query the size of the list
     @return The number of objects in the list
     */
    public int size() {
        return size;
    }

    /** Remove an item at the specified index.
     @param index - The index at which the object is to be
     removed.
     @throws IndexOutOfBoundsException - if the index is out
     of range (i < 0 || i > size())
     */
    public Object remove(int index) {
        Object returnValue = null;
        ListIterator iter = listIterator(index);
        if (iter.hasNext()) {
            returnValue = iter.next();
            iter.remove();
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return returnValue;
    }

    /** Return an Iterator to the list
     @return an Itertor tot the list
     */
    public Iterator iterator() {
        return new KWListIter(0);
    }

    /** Return a ListIterator to the list
     @return a ListItertor to the list
     */
    public ListIterator listIterator() {
        return new KWListIter(0);
    }

    /** Return a ListIterator that begins at index
     @param index - The position the iteration is to begin
     @return a ListIterator that begins at index
     */
    public ListIterator listIterator(int index) {
        return new KWListIter(index);
    }

    /** Return a ListIterator that begins at the same
     place as an existing ListIterator
     @param iter - The other ListIterator
     @return a ListIterator that is a copy of iter
     */
    public ListIterator listIterator(ListIterator iter) {
        return new KWListIter( (KWListIter) iter);
    }

    // Inner Classes
    /** A Node is the building block for the linked list */
    private static class Node {
        /** The data value. */
        private Object data;
        /** The link to the next node */
        private Node next = null;
        /** The link to the previous node */
        private Node prev = null;
        /** Construct a node with the given data value
         *  @param dataItem - The data value */
        private Node(Object dataItem) {
            data = dataItem;
        }
    }

    /** Inner class to implement the ListIterator interface */
    private class KWListIter
            implements ListIterator {
        /** A reference to the next item */
        private Node nextItem;
        /** A refernce to the last item returned */
        private Node lastItemReturned;
        /** The index of the current item */
        private int index = 0;

        /** Construct an ListIter that will reference the indexth item
         @param i - The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null;
            // Special case of last item
            if (i == size) {
                index = size;
                nextItem = null;
            }
            else { // start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /** Construct a KWListIter that is a copy of another KWListIter
         @param other - The other KWListIter
         */
        public KWListIter(KWListIter other) {
            nextItem = other.nextItem;
            index = other.index;
        }

        /** Indicate whether movement forward is defined
         @return true if call to next will not throw an exception
         */
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Indicate whether movement backward is defined
         @return true if call to previous will not throw an exception
         */
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /** Return the index of the next item to be returned by next
         @return the index of the next item to be returned by next
         */
        public int nextIndex() {
            return index;
        }

        /** Return the index of the next item to be returned by previous
         @return the index of the next item to be returned by previous
         */
        public int previousIndex() {
            return index - 1;
        }

        /** Move the iterator forward and return the next item
         @return the next item in the list
         @throws NoSuchElementException if there is no such object
         */
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /** Move the iterator backward and return the previous item
         @return the previous item in the list
         @throws NoSuchElementException if there is no such object
         */
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) {
                nextItem = tail;
            }
            else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**** BEGIN EXERCISE ****/
        /** Replace the last item returned with a new value
         *  @param obj The new value
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        public void set(Object obj) {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            lastItemReturned.data = obj;
        }

        /** Remove the last item returned. This can only be
         *  done once per call to next or previous.
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        public void remove() {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            // Unlink this item from its next neighbor
            if (lastItemReturned.next != null) {
                lastItemReturned.next.prev = lastItemReturned.prev;
            }
            else { // Item is the tail
                tail = lastItemReturned.prev;
                if (tail != null) {
                    tail.next = null;
                }
                else { // list is now empty
                    head = null;
                }
            }
            // Unlink this item from its prev neighbor
            if (lastItemReturned.prev != null) {
                lastItemReturned.prev.next = lastItemReturned.next;
            }
            else { // Item is the head
                head = lastItemReturned.next;
                if (head != null) {
                    head.prev = null;
                }
                else {
                    tail = null;
                }
            }
            // Invalidate lastItemReturned
            lastItemReturned = null;
            // decrement both size and index
            size--;
            index--;
        }

        /**** END EXERCISE ****/

        /** Add a new item between the item that will be returned
         *  by next and the item that will be returned by previous.
         *  If previous is called after add, the element added is returned.
         *  @param obj - The item to be inserted
         */
        public void add(Object obj) {
            if (head == null) { // add to an empty list
                head = new Node(obj);
                tail = head;
            }
            else if (nextItem == head) { // insert at head
                // Create a new node
                Node newNode = new Node(obj);
                // link it to the nextItem
                newNode.next = nextItem; //step 1
                // link nextItem to the new node
                nextItem.prev = newNode; //step 2
                // The new node is now the head
                head = newNode; //step 3
            }
            else if (nextItem == null) { // insert at tail
                // Create a new node
                Node newNode = new Node(obj);
                // Link the tail to the new node
                tail.next = newNode; //step 1
                // Link the new node to the tail
                newNode.prev = tail; //step 2
                // The new node is the new tail
                tail = newNode; //step 3
            }
            else { // insert into the middle
                // Create a new node
                Node newNode = new Node(obj);
                // Link it to nextItem.prev
                newNode.prev = nextItem.prev; //step 1
                nextItem.prev.next = newNode; //step 2
                // Link it to the nextItem
                newNode.next = nextItem; //step 3
                nextItem.prev = newNode; //step 4
            }
            // Increase size and index
            size++;
            index++;
        } // end of method add
    }
}