/**
 * and object of this class represents a node of type <T> generic
 * @author Rafeeks
 *
 * @param <T>
 */

public class Node<T>
{
   /**
    *  node generic instance variables
    */
   private T data;
   private Node<T> next;
   
/**
 * Node constructor takes in generic T data
 * @param data
 */
   public Node( T data){
      this.data = data;
   }
/**
 * overloaded constructor T data and  node generic next
 * @param data
 * @param next
 */
   public Node(T data, Node<T> next){
      this.data = data;
      this.next = next;
   }
   public T getData(){
      return data;
   }
   public Node<T> getNext(){
      return next;
   }
   public void setNext(Node<T> next){
      this.next = next;
   }
   public void setData(T data){
      this.data = data;
   }
   /**
    * toSTring method returns string representation of generic data
    */
   public String toString(){
      return data.toString();
   }
     
}

