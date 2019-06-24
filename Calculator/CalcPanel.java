import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class CalcPanel{

   private inPanel input;

   public CalcPanel(){
   
      setLayout(new BorderLayout());
   
      input = new inPanel();
      add(input, BorderLayout.NORTH);
   
   
   
   }
}