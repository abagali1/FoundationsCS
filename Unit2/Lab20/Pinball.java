import java.awt.Color;
import java.awt.Graphics;

public class Pinball extends Spot{

   private int dx,dy,rightEdge,leftEdge;

   public Pinball(){
      super(200,200,50,Color.RED);
   }
   public void setbound(int r, int l){
      rightEdge = r;
      leftEdge = l;
   }
   public void tick(){
      x += dx;
      y += dy;
      if (x - r <= 0) {
         dx = littlerandom();
      }
      if (x + r >= rightEdge) {
         dx = (-littlerandom());
      }
      if (y - r <= 0) {
         dy = littlerandom();
      }
      if (y + r >= leftEdge) {
         dy = (-littlerandom());
      }
   }
   public int littlerandom()
   {
      return (int)(Math.random() * 6 + 3);
   }
}