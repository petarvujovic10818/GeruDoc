package state;

import java.awt.event.MouseEvent;

import commands.DeleteElementCommand;
import view.PageView;

public class DeleteElementState extends State{
	
	private PageView med;
	
	public DeleteElementState(PageView med) {
		this.med=med;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		med.getCommandManager().addCommand(new DeleteElementCommand(med.getPage().getModel(),med.getPage().getSelectionModel()));	 
	}
	
}
