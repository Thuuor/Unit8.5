import javax.swing.JOptionPane;

public class GraphicExample {

	public static void main(String[] args) {
		int number1 = Integer.parseInt(
				JOptionPane.showInputDialog(null,
						"Enter first number",
						"Adding",
						JOptionPane.QUESTION_MESSAGE));
		
		int number2 = Integer.parseInt(
				JOptionPane.showInputDialog(null,
						"Enter second number",
						"Adding",
						JOptionPane.QUESTION_MESSAGE));
		int result = number1 + number2;
		
		JOptionPane.showMessageDialog(null,
				"Total is: " + result,
				"Adding",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
