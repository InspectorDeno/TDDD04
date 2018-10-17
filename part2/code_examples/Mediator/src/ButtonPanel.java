

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel {
	public JPanel buttonPanel = new JPanel();
	public JRadioButton uppercaseButton;
	public JRadioButton lowercaseButton;

	public ButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());

		lowercaseButton = new JRadioButton("Lowercase");
		buttonPanel.add(lowercaseButton);
		
		uppercaseButton = new JRadioButton("Uppercase");
		buttonPanel.add(uppercaseButton);
	}

	public void updateButtons(String text) {
		lowercaseButton.setEnabled(text.startsWith("A"));
		uppercaseButton.setEnabled(text.endsWith("a"));
	}

}