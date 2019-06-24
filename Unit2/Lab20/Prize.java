import java.awt.Color;

public class Prize
  extends Spot
{
   public Prize(int x, int y, int r)
   {
      super(x, y, r, Color.RED);
   }
   
   public void lightup()
   {
      c = Color.YELLOW;
   }
}
