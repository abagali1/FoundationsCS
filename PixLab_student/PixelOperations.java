//
// Torbert, 24 July 2013
//
import java.awt.Color;
import java.awt.image.BufferedImage;
//
public class PixelOperations
{
   public Color[][] getArray(BufferedImage img)
   {
      Color[][] arr;
   	//
      int numcols = img.getWidth();
      int numrows = img.getHeight();
   	//
      arr = new Color[numrows][numcols];
   	//
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            int rgb = img.getRGB(k,j);
         	//
            arr[j][k] = new Color(rgb);
         }
      }
   	//
      return arr;
   }
   public void setImage(BufferedImage img, Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            //
            int rgb = tmp.getRGB();
            //
            img.setRGB(k,j,rgb);
         }
      }
   }
   //
	/**********************************************************************/
	//
	// pixel operations
	// 
   public void zeroBlue(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[j][k] = new Color( tmp.getRed(), tmp.getGreen(), 0 );
         }
      }
   }
	//--------> your new methods go here   <--------------
   public void negate(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[j][k] = new Color( 255-tmp.getRed(), 255-tmp.getGreen(), 255-tmp.getBlue() );
         }
      }
   }
   
   public void gray(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int gray = (int)((tmp.getRed()+tmp.getGreen()+tmp.getBlue())/3);
            arr[j][k] = new Color(gray,gray,gray);
         }
      }
   }
   public void sepia(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int red = (int)((0.393*tmp.getRed())+(0.769*tmp.getGreen())+(0.189*tmp.getBlue()));
            int green = (int)((0.349*tmp.getRed())+(0.686*tmp.getGreen())+(0.168*tmp.getBlue()));
            int blue = (int)((0.272*tmp.getRed())+(0.534*tmp.getGreen())+(0.131*tmp.getBlue()));
            if(red>255)
               red = 255;
            if(green>255)
               green=255;
            if(blue>255)
               blue=255;
            
            arr[j][k] = new Color(red,green,blue);
         }
      }
   }
   public void blur(Color[][] arr){
      for(int j = 1; j < arr.length - 1; j++)
      {
         for(int k = 1; k < arr[0].length-1; k++)
         {
            Color cur = arr[j][k];
            Color t = arr[j-1][k];
            Color b = arr[j+1][k];
            Color l = arr[j][k+1];
            Color r = arr[j][k-1];
            
            int avgR = ((int)((cur.getRed()+t.getRed()+b.getRed()+l.getRed()+r.getRed())/5));
            int avgB = ((int)((cur.getBlue()+t.getBlue()+b.getBlue()+l.getBlue()+r.getBlue())/5));
            int avgG = ((int)((cur.getGreen()+t.getGreen()+b.getGreen()+l.getGreen()+r.getGreen())/5));
            
            arr[j][k] = new Color(avgR,avgB,avgG);
         }
      }
   }
   public void post(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int red = tmp.getRed();
            int green = tmp.getGreen();
            int blue = tmp.getBlue();
            
            if(red>=63 && red<=128)
               red = 95;
            if(green>63 && green<=128)
               green=95;
            if(blue>=63 && blue<=128)
               blue = 95;
            arr[j][k] = new Color(red,green,blue);
         }
      }
   }
   
   public void cSplash(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            if(tmp.getRed()<(tmp.getBlue()+tmp.getGreen())){
               int gray = (int)((tmp.getRed()+tmp.getGreen()+tmp.getBlue())/3);
               arr[j][k] = new Color(gray,gray,gray);
            }else{
               arr[j][k] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
            }
               
            
         }
      }
   }
   
   public void mirrorLR(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            arr[j][arr[0].length-1-k] = arr[j][k];
            
         }
      }
   }
   
   public void mirrorUD(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            arr[arr.length-1-j][k] = arr[j][k];
         }
      }
   }
   
   public void flipLR(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length/2; k++)
         {
            Color tmp = arr[j][arr[0].length-1-k];           
            arr[j][arr[0].length-1-k] = arr[j][k];
            arr[j][k] = tmp;
         }
      }
   }
   
   public void flipUD(Color[][] arr){
      for(int j = 0; j < arr.length/2; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[arr.length-1-j][k];
            arr[arr.length-1-j][k] = arr[j][k];
            arr[j][k] = tmp;
         }
      }
   }
   public void sun(Color[][] arr){
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int g = (int)(tmp.getGreen()-(tmp.getGreen()*0.20));
            int b = (int)(tmp.getBlue()-(tmp.getBlue()*0.20));
            arr[j][k] = new Color(tmp.getRed(), g, b);
         }
      }
   }
   
   public void pixe(Color[][] arr){
      for(int j = 1; j < arr.length - 1; j++)
      {
         for(int k = 1; k < arr[0].length-1; k++)
         {
            Color cur = arr[j][k];
            Color t = arr[j-1][k];
            Color b = arr[j+1][k];
            Color l = arr[j][k+1];
            Color r = arr[j][k-1];
            Color ldu = arr[j-1][k-1];
            Color ldd = arr[j-1][k+1];
            Color rdu = arr[j+1][k+1];
            Color rdd = arr[j+1][k-1];
            
            int avgR = ((int)((cur.getRed()+t.getRed()+b.getRed()+l.getRed()+r.getRed()+ldu.getRed()+ldd.getRed()+rdd.getRed()+rdu.getRed())/9));
            int avgB = ((int)((cur.getBlue()+t.getBlue()+b.getBlue()+l.getBlue()+r.getBlue()+ldu.getBlue()+ldd.getBlue()+rdd.getBlue()+rdu.getBlue())/9));
            int avgG = ((int)((cur.getGreen()+t.getGreen()+b.getGreen()+l.getGreen()+r.getGreen()+ldu.getGreen()+ldd.getGreen()+rdd.getGreen()+rdu.getGreen())/9));
            
            arr[j][k] = new Color(avgR,avgB,avgG);
         }
      }
   }
   
   
	
	
  
}
//
// end of file
//