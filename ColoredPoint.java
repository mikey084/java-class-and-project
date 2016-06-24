/**
 * An object of this class represents a colored point for each data entry on the plot
 */
import java.awt.*;
public class ColoredPoint extends Point
{
   private Color color;
   private double originalX;
   private double originalY;
   private int mappedX;
   private int mappedY;
   /**
    * Colored Point constructor 
    * @param color
    * @param mappedX
    * @param mappedY
    * @param originalX
    * @param originalY
    */
   public ColoredPoint(Color color, int mappedX, int mappedY, 
         double originalX, double originalY) {
      super(mappedX, mappedY);
      this.color = color;
      this.originalX = originalX;
      this.originalY = originalY;
      this.mappedX = mappedX;
      this.mappedY = mappedY;
   }
   /**
    * color getter method
    * @return color  color of point
    */
   public Color getColor() {
      return color;
   }
   /**
    * get label
    * @return label  string of label of plotted point
    */
   public String getLabel() {
      return "(" + originalX + ", " + mappedY + ")";
   }
   
}
