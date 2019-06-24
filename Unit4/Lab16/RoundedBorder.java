import java.awt.*;
import javax.swing.border.Border;
/*
 * Changes the border of a JComponent to a circular or elliptical shape. RoundedBorder overrides the paintBorder method
 * in border to a rounded shape. RoundedBorder retains information about its radius and current color
 * 
 * @author Anup Bagali
 * @version 1.5
 * 
 */
public class RoundedBorder implements Border {
   /*
    * Radius of the RoundedBorder
    */
   public int radius; 
   /*
    * Current Color of the RoundedBorder
    */
   public Color currentCol;
   
   /*
    * Instantiates a new RoundedBorder object.
    * @param radius Radius of border
    * @param color Desired starting color of border
    * 
    */
   public RoundedBorder(int radius, Color color) {
      this.radius = radius;
      currentCol = color;
   }
   /*
    * (non-Javadoc)
    * @see javax.swing.border.Border#getBorderInsets(java.awt.Component)
    */
   public Insets getBorderInsets(Component c) {
      return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
   }
   /*
    * (non-Javadoc)
    * @see javax.swing.border.Border#isBorderOpaque()
    */
   public boolean isBorderOpaque() {
      return true;
   }
   /*
    * Paints the inside area of the border to the current color and creates a white border
    * @see javax.swing.border.Border#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
    */
   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      g.setColor(getCol());
      g.fillRoundRect(x+15, y+5, width-30, height-15, radius, radius);
      g.setColor(Color.white);
      g.drawRect(x,y,width,height);
   }
   /*
    * Returns the current color of the border
    * @return current color of the border
    */
   public Color getCol(){
      return currentCol;
   }
   /*
    * Sets the current color of the border
    * @param desired color
    */
   public void setColor(Color a){
      currentCol = a;
   }
   /*
    * Fills the JComponent with a different color by calling the paintBorder method
    * @param c desired JComponent to be changed
    * @param b desired color to be changed to
    * @see javax.swing.border.Border#paintBorder(java.awt.Component, java.awt.Graphics, int, int, int, int)
    * 
    */
   public void fillPeg(Component c,Color b){
      setColor(b);
      paintBorder(c, c.getGraphics(), c.getX()+15,c.getY()+5,c.getWidth()-30,c.getHeight()-15);
      
      
      
   }
       
}