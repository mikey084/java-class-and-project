/**
 * an object of this class is a subscription per year
 * @author Rafeeks
 *
 */

public class SubscriptionYear
{
/**
 * subscription year instance varibles
 * getters and setters
 */
   private int  year;
   private double subscriptions;
   // constructor for Subscription year object
   public SubscriptionYear(int numYear, double numSubscriptions){
      year = numYear;
      subscriptions = numSubscriptions;
   }
   // setter for years
   public void setYear(int year){
      this.year = year;     
   }
   // setter for subscriptions double
   public void setSubscriptions(double Subscriptions){
      this.subscriptions = Subscriptions;
   }
   // years getter
   public int getYear(){
      return year;
   }
   // subscriptions getter
   public double getSubscriptions(){
      return subscriptions;
   }
}

