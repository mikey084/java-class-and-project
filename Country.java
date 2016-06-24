/**
 * An object of this class represents a Country with its subscriptions per year
 */

import java.text.DecimalFormat;
import java.util.Iterator;



public class Country
{
   /** country class private instance variables
    */
   private String countryName;
   private LinkedList<SubscriptionYear> subscriptions;


/**
 * Country constructor creates new linkedlist
 * @param name   of country
 */
   public Country(String name){
      this.countryName = name;
      subscriptions = new LinkedList<>();

   }
/**
 * add subscription method creates and adds to the new linked list
 * @param year     of country
 * @param subscription    number subs for that year
 */
   public void addSubscriptionYear(int year, double subscription){
      SubscriptionYear toAdd = new SubscriptionYear(year, subscription);
      subscriptions.add(toAdd);

   }
   /**
    * getter check for invalid years, endYear cannot come before startYear
    * @return result   number of subscriptions for year
    */
   public double getNumSubscriptionsForPeriod(int startYear, int endYear){
      if (endYear < startYear){
         System.out.println("invalid start and end year");
         return -1;
      }
      else{
         double result = 0.0;
         Iterator<SubscriptionYear> itr = subscriptions.iterator();
         while (itr.hasNext()) {
            SubscriptionYear curr = itr.next();
            if (startYear <= curr.getYear() && endYear >= curr.getYear()) {
               result += curr.getSubscriptions();
            }
         }
         return result;
      }
   }
   /**
    * getter method
    * @return  countryName 
    */
   public String getName() {
      return countryName;
   }
   
   public LinkedList<SubscriptionYear> getSubscriptionData() {
      return subscriptions;
   }
   
/**
 * to string method uses stringbuilder 
 * return string
 */
   public String toString(){
      StringBuilder sb = new StringBuilder();
      DecimalFormat df = new DecimalFormat("#.##");
      sb.append(countryName);
      sb.append(": ");
      Iterator<SubscriptionYear> itr = subscriptions.iterator();
      while (itr.hasNext()) {
         sb.append(df.format(itr.next().getSubscriptions()));
         sb.append(" ");
      }
      return sb.toString();
   } 
   /**
    *  comparing two country objects using only country name
    *  equals method used in list check comparing input to existing 
    *  return boolean if country object is found
    */
   @Override
   public boolean equals(Object country){
      if (country instanceof Country) {
         if (this.countryName.equalsIgnoreCase(((Country) country).getName())) {
            return true;
         }
      }
      return false;
   }
}
