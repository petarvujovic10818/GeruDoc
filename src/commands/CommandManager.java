package commands;

import java.util.ArrayList;

import app.MainFrame;

public class CommandManager {
	
	private ArrayList<AbstractCommand> commands=new ArrayList<AbstractCommand>();
	private int currentCommand=0;
	
	public void addCommand(AbstractCommand command) {
		while(currentCommand<commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	public void doCommand() {
		if(currentCommand<commands.size()) {
			commands.get(currentCommand++).doCommand();
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if(currentCommand==commands.size()) {
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
	}
	
	public void undoCommand() {
		if(currentCommand>0) {
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		if(currentCommand==0) {
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
	}
	
}
