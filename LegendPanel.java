/**
 * an object of this class serves as the legend for the plot graph
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LegendPanel extends JPanel
{
   
   private int width;
   private int height;
   private String[] names;
   private Color[] colors;
  /**
   * Legend Constructor creates legend object
   * @param width
   * @param height
   * @param names
   * @param colors
   */
   public LegendPanel(int width, int height, String[] names, Color[] colors){
      this.width = width;
      this.height = height;
      this.names = names;
      this.colors = colors;
   }
   /**
    * paint component method assigns random color array to each country 
    */
   public void paintComponent(Graphics graphic){
   super.paintComponent(graphic);
   Graphics2D g2d = (Graphics2D) graphic;
   int increment = height / names.length;
   for (int i = 0; i < names.length; i++) {
      g2d.setColor(colors[i]);
      g2d.fillOval(40, i * increment + 10, 10, 10);
      g2d.drawString(names[i], 70 , i * increment +10);
   }
   }
}
