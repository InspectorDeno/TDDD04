

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUIComponents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List data = new List();
	private Pane pane = new Pane();
	private ButtonPanel buttonPanel = new ButtonPanel();

	public GUIComponents() {
		getContentPane().add(pane.scrollPane, BorderLayout.SOUTH);
		getContentPane().add(data.list, BorderLayout.CENTER);
		getContentPane().add(buttonPanel.buttonPanel, BorderLayout.EAST);
		new GUIMediator(data, pane, buttonPanel);
	}

	
	public GUIComponents getNew() {
		return new GUIComponents();
	}
	
	public static void main(String[] args) {
		GUIComponents gui = new GUIComponents();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setMinimumSize(new Dimension(400, 400));
		gui.setVisible(true);
	}

}
