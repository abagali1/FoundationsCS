import javax.swing.JFrame;

public class Driver16 {

	public static void main(String[] args) {
        JFrame frame = new JFrame("Unit4, Lab16: MasterMind");
        frame.setSize(450, 400);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel16());
        frame.setVisible(true);

	}

}
