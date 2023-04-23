package Menu;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			JFrame frame = new MenuFrame();
			frame.setTitle("Menu Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
