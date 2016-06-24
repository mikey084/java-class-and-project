import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;
public class GraphView extends JPanel
{

   private int width;
   private int height;
   private double plottedXmin;
   private double plottedXmax;
   private double plottedYmin;
   private double plottedYmax;
   private Font font;

   private LinkedList<ColoredPoint> plottedDataSet;
   private String[] countryNames;
   private Color[] colors;
   private Color color;
   /**
    * graphview constructor creates graph object by iteration
    * Iterates through Country LinkedList then iterates through each Country for
    * subscriptions
    * creates random color array
    * @param width
    * @param height
    * @param countries
    */

   public GraphView(int width, int height, Country countries){
      font = new Font("Serif", Font.PLAIN, 11);
      this.width = width;
      this.height = height;
      plottedXmin = 5000;
      plottedXmax = 0;
      plottedYmin = 5000;
      plottedYmax = 0;
      LinkedList<SubscriptionYear> subData = countries.getSubscriptionData();
      Iterator<SubscriptionYear> subItr = subData.iterator();
      while (subItr.hasNext()) {
         SubscriptionYear currSub = subItr.next();
         int year = currSub.getYear();
         // PROBLEM
         if (year < plottedXmin) {
            plottedXmin = year;
         }
         if (year > plottedXmax) {
            plottedXmax = year;
         }
         double data = currSub.getSubscriptions();
         if (data < plottedYmin) {
            plottedYmin = data;
         }
         if (data > plottedYmax) {
            plottedYmax = data;
         }
      }
         plottedDataSet = new LinkedList<ColoredPoint>();
         Random random = new Random();
         color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
         subData = countries.getSubscriptionData();
         subItr = subData.iterator();
         int index = 0;
         while (subItr.hasNext()) {
            SubscriptionYear currSub = subItr.next();
            if (index % 3 == 0) {
            double x = currSub.getYear();
            double mapX = map(x, plottedXmin, plottedXmax, 100, width - 100);
            double y = currSub.getSubscriptions();
            double mapY = map(y, plottedYmin, plottedYmax, height - 100, 100);
            System.out.println("X: " + x + "   Y: " + y);
            System.out.println("mapX: " + mapX + "   mapY: " + mapY);
            ColoredPoint cp = new ColoredPoint(color,(int) mapX, (int)mapY, x, y);
            plottedDataSet.add(cp);
            }
            index++;
         }
   }

   public GraphView(int width, int height, LinkedList<Country> countries)
   {
      font = new Font("Serif", Font.PLAIN, 11);
      this.width = width;
      this.height = height;
      plottedXmin = 5000;
      plottedXmax = 0;
      plottedYmin = 5000;
      plottedYmax = 0;
      Iterator<Country> countryItr = countries.iterator();
      while (countryItr.hasNext()) {
         Country currCountry = countryItr.next();
         LinkedList<SubscriptionYear> subData = currCountry.getSubscriptionData();
         Iterator<SubscriptionYear> subItr = subData.iterator();
         while (subItr.hasNext()) {
            SubscriptionYear currSub = subItr.next();
            int year = currSub.getYear();
            if (year < plottedXmin) {
               plottedXmin = year;
            }
            if (year > plottedXmax) {
               plottedXmax = year;
            }
            double data = currSub.getSubscriptions();
            if (data < plottedYmin) {
               plottedYmin = data;
            }
            if (data > plottedYmax) {
               plottedYmax = data;
            }
         }
      }
      plottedDataSet = new LinkedList<ColoredPoint>();
      colors = new Color[countries.size()];
      countryNames = new String[countries.size()];

      Random random = new Random();
      for (int i = 0; i < colors.length; i++) {
         colors[i] = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
      }
      countryItr = countries.iterator();
      int count = 0;
      while (countryItr.hasNext()) {
         Country currCountry = countryItr.next();
         LinkedList<SubscriptionYear> subData = currCountry.getSubscriptionData();
         Iterator<SubscriptionYear> subItr = subData.iterator();
         countryNames[count] = currCountry.getName();
         while (subItr.hasNext()) {
            SubscriptionYear currSub = subItr.next();
            double x = currSub.getYear();
            double mapX = map(x, plottedXmin, plottedXmax, 100, width - 100);
            double y = currSub.getSubscriptions();
            double mapY = map(y, plottedYmin, plottedYmax, height - 100, 100);
            ColoredPoint cp = new ColoredPoint(colors[count],(int) mapX, (int)mapY, x, y);
            plottedDataSet.add(cp);
         }
         count++;
      }
      /**
       * get countries for legend 
       */
   }
   public String[] getCountryNames() {
      return countryNames;
   }

   public Color[] getColors() {
      return colors;
   }

   public final double map(double value,
         double dataMin, double dataMax,
         double plottedMin, double plottedMax)
   {
      return plottedMin + (plottedMax - plottedMin) * ((value - dataMin) / (dataMax - dataMin));
   }
   /**
    * Paint method create graphics object and borders and String labels.
    * plottedDataSet stores colored points if colored points are at 0.00 not drawn
    */
   public void paintComponent(Graphics graphic){
      super.paintComponent(graphic);
      Graphics2D g2d = (Graphics2D) graphic;
      g2d.setFont(font);
      g2d.drawLine(75, height - 75, width, height - 75);
      g2d.drawLine(75, 0, 75, height - 75);
      g2d.drawString("1960", width /4 -150, height - 65);
      g2d.rotate(-Math.PI/2);
      g2d.drawString("Number of Subscriptions (per 100 people)", -height/2 , 50);
      g2d.rotate(Math.PI/2);
      g2d.drawString("Year", width / 2, height - 50);
      Iterator<ColoredPoint> pointItr = plottedDataSet.iterator();
      while (pointItr.hasNext()) {
         ColoredPoint cp = pointItr.next();
         g2d.setColor(cp.getColor());
         g2d.fillOval((int) cp.getX(), (int) cp.getY(), 10, 10);
         if ((int) cp.getY() < 580) {
            g2d.drawString(cp.getLabel(), (int)cp.getX() - 5, (int) cp.getY() - 5);
            System.out.println("Drawing at : " + cp.getLabel() + cp.getX() + ", " + cp.getY());
         }
      }
   }
}

