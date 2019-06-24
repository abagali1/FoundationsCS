import javax.swing.JOptionPane;

public class Driverr08
{
  public static void main(String[] args)
    throws Exception
  {
    String address = JOptionPane.showInputDialog("Enter an email address");
    EMail em = new EMail(address);
    JOptionPane.showMessageDialog(null, em.toString());
    System.exit(0);
  }
}
