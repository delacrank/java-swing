package frameapplications;

import java.awt.*;
import javax.swing.*;

import frameapplications.dataexchange.DataExchangeFrame;
import frameapplications.menu.MenuFrame;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			JFrame frame = new DataExchangeFrame();
			frame.setTitle("DataExchange Application");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
