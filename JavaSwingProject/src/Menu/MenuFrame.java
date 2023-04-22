package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuFrame extends JFrame{

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	class TestAction extends AbstractAction {
		public TestAction(String name) {
			super(name);
		}
		
		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME) + " selected");
		}
	}
	
	public MenuFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		fileMenu.addSeparator();
		
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		readonlyItem = new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean saveOk = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("insertItem");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("OverType");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY,  new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		popup = new JPopupMenu();
		
				
		
		
	}
}
