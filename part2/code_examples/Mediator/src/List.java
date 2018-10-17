

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List implements ListSelectionListener {
	public JList list;

	private ArrayList<ListListener> listeners = new ArrayList<ListListener>();

	public List() {
		list = new JList(new String[] { "Arkansas", "Alabama", "Illinois",
				"Iowa" });
		list.addListSelectionListener(this);
	}

	public void addListener(ListListener l) {
		listeners.add(l);
	}

	public String getText() {
		return list.getSelectedValue().toString();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		for (ListListener listListener : listeners) {
			listListener.update(this);
		}
	}
}