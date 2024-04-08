package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import actions.ActionManager;
import tree.controller.WindowListener;
import tree.view.MyTree;
import view.LeftPanel;
import view.MyMenuBar;
import view.MyToolBar;
import view.Palette;
import view.RightPanel;

public class MainFrame extends JFrame implements ClipboardOwner{
	
	private static MainFrame instance=null; //singleton - one instance of main frame 
	private MyMenuBar menuBar;
	private MyToolBar toolBar; //on the top
	private MyTree myTree; //for document hierarchy 
	private ActionManager actionManager; //all actions we have
	private RightPanel rightPanel;
	private Palette palette;
	
	
	private Clipboard clipboard=new Clipboard("Gerudok clipboard"); //clipobard for copy,paste...
	
		private MainFrame() {
			super();
		}
		
		private void initialise() {
			actionManager=new ActionManager();
			myTree=new MyTree();
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension d=kit.getScreenSize();
			int screenHeight=d.height;
			int screenWidth=d.width;
			setSize((int)(screenWidth/1.2),(int)(screenHeight/1.2));
			setTitle("Rukovodilac dokumentima");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			
			Image img=kit.getImage("images/toolimg.jpg");
			setIconImage(img);
			
			menuBar = new MyMenuBar();
			setJMenuBar(menuBar);
			
			toolBar = new MyToolBar();
			add(toolBar, BorderLayout.NORTH);
			
			LeftPanel leftPanel=new LeftPanel();
			leftPanel.add(myTree);
			this.add(leftPanel,BorderLayout.WEST);
			
			rightPanel=new RightPanel();
			add(rightPanel,BorderLayout.EAST);
			
			JScrollPane scrollPane = new JScrollPane(leftPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setMinimumSize(new Dimension(150,150));
			
			JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,rightPanel);
			splitPane.setDividerLocation(150);
			this.add(splitPane,BorderLayout.CENTER);
			
			palette=new Palette();
			add(palette,BorderLayout.EAST);
			
			this.addWindowListener(new WindowListener());
		}
		
		public static MainFrame getInstance() {
			if(instance==null) {
				instance=new MainFrame();
				instance.initialise();
			}
			return instance;
		}
		
		public MyTree getMyTree() {
			return myTree;
		}

		public ActionManager getActionManager() {
			return actionManager;
		}
		
		public RightPanel getRightPanel() {
			return rightPanel;
		}

		@Override
		public void lostOwnership(Clipboard clipboard, Transferable contents) {
			System.out.println("Lost Ownership");
		}
		
		public Clipboard getClipboard() {
			return clipboard;
		}
}