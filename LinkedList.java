/**
 * an object of this class represents a LinkedList of country objects
 */
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>
{
   private Node<T> head;
   private int listSize;
/**
 * Linked List constructor
 */
   public LinkedList()
   {
      head = null;
      listSize = 0;
   }
/**
 * add method adds generic data to list and increments listsize
 * @param data
 */
   public void add(T data)
   {
      Node<T> toAdd = new Node<>(data);
      if (head == null)
      {
         head = toAdd;
      } else
      {
         Node<T> temp = head;
         while (temp.getNext() != null)
         {
            temp = temp.getNext();
         }
         temp.setNext(toAdd);
      }
      listSize++;
   }
/**
 * contains method checks list for match and returns that generic data
 * @param data
 * @return
 */
   public T contains(T data)
   {
      Node<T> temp = head;
      while (temp != null)
      {
         T tempData = temp.getData();
         if (tempData.equals(data)) {
            return tempData;
         }
         temp = temp.getNext();
      }
      return null;
   }
/** returns linked list size
 */
   public int size()
   {
      return listSize;
   }
/**
 * toString method prints linked list
 */
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      Node<T> temp = head;
      while (temp != null)
      {
         sb.append(" \n");
         sb.append(temp.toString());
         temp = temp.getNext();
      }
      return sb.toString();
   }

   @Override
   public Iterator<T> iterator()
   {
      return new ListIterator();
   }
   
   public class ListIterator implements Iterator<T> {
      
      private Node<T> current;
      /**
       * list iterator constructor
       */
      public ListIterator() {
         current = head;
      }

      public boolean hasNext()
      {
         return current != null;
      }

      public T next()
      {
         if (hasNext()) {
            T data = current.getData();
            current = current.getNext();
            return data;
         }
         return null;
      }
      
   }

}
