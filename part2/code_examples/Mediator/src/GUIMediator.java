

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMediator implements ListListener {

	private Pane pane;
	private ButtonPanel buttonPanel;

	public GUIMediator(final List list, final Pane pane,
			final ButtonPanel buttonPanel) {
		list.addListener(this);
		this.pane = pane;
		this.buttonPanel = buttonPanel;
		ActionListener lowerCaseListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (buttonPanel.lowercaseButton.isSelected()) {
					buttonPanel.uppercaseButton.setSelected(false);
					pane.setInformationText(pane.getInformationText()
							.toLowerCase());
					pane.updateText(list.getText());
				}
			}
		};
		buttonPanel.lowercaseButton.addActionListener(lowerCaseListener);

		ActionListener upperCaseListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (buttonPanel.uppercaseButton.isSelected()) {
					buttonPanel.lowercaseButton.setSelected(false);
					pane.setInformationText(pane.getInformationText()
							.toUpperCase());
					pane.updateText(list.getText());
				}
			}
		};
		buttonPanel.uppercaseButton.addActionListener(upperCaseListener);

	}

	@Override
	public void update(List src) {
		pane.updateText(src.getText());
		buttonPanel.updateButtons(src.getText());
		
	}

}
