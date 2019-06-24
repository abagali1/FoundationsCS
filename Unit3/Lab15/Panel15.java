   //Name: ________________________  Date: __________________

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel15 extends JPanel
{
   public Panel15(){
      setLayout(new BorderLayout());
      
      JTextArea a = new JTextArea("The quick brown fox jumps over the ");
      a.append("lazy dog.");
      a.setFont(new Font("Serif", 0, 12));
      a.setLineWrap(true);
      a.setWrapStyleWord(true);
      add(a, "Center");
      
      JPanel bottom = new JPanel(new FlowLayout());
      bottom.add(new NamePanel(a));
      bottom.add(new StylePanel(a));
      bottom.add(new SizePanel(a));
      add(bottom, "South");
   }
}