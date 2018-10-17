

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Pane {
	public JScrollPane scrollPane;
	private String informationText;
	private JTextPane innerPane;

	public Pane() {
		this.innerPane = new JTextPane();
		this.scrollPane = new JScrollPane(this.innerPane);
		this.setInformationText("This text is ONLY to be showed for ");
		innerPane.setMinimumSize(new Dimension(50, 200));
		scrollPane.setSize(new Dimension(50, 200));
	}

	public void updateText(Object object) {
		innerPane.setText(getInformationText() + object.toString());
	}

	public String getInformationText() {
		return informationText;
	}

	public void setInformationText(String informationText) {
		this.informationText = informationText;
	}

}