package view;

import javax.swing.BoxLayout;
import javax.swing.JToolBar;

import app.MainFrame;

public class Palette extends JToolBar{
	
	public Palette() {
		super(JToolBar.VERTICAL);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(MainFrame.getInstance().getActionManager().getSelectAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getTriangleAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getRectangleAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getCircleAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getResizeAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getRotateAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getDragAndDropAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getDeleteElementAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getCopyAction());
		add(MainFrame.getInstance().getActionManager().getCutAction());
		add(MainFrame.getInstance().getActionManager().getPasteAction());
	}
}
