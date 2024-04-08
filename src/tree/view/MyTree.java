package tree.view;

import java.awt.datatransfer.Transferable;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import app.MainFrame;
import elements.PageElement;
import tree.controller.MyMouseListener;
import tree.controller.MyMouseListener2;
import tree.model.Document;
import tree.model.DocumentNodeSelection;
import tree.model.Page;
import tree.model.Project;
import tree.model.TreeModel;

public class MyTree extends JTree{
	
	private TreeModel treeModel;
	
	public MyTree() {
		treeModel=new TreeModel();
		setModel(treeModel);
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		addTreeSelectionListener(null);
		addMouseListener(new MyMouseListener());
		addMouseListener(new MyMouseListener2());
	}
	
	public void pasteDocument() {
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents (MainFrame.getInstance()); 
		if ((clipboardContent != null) &&
		 	(clipboardContent.isDataFlavorSupported (DocumentNodeSelection.documentFlavor))) {
			try {
				Document document = (Document) clipboardContent.getTransferData (DocumentNodeSelection.documentFlavor);					
		 		Object o=this.getLastSelectedPathComponent();
		 		if(o instanceof Project) {
		 			Project project=(Project)o;
		 			project.add(document);
		 		}
			}catch (Exception ex) {
		 		ex.printStackTrace ();
		 	}
		}
	}
	
	public void pasteDocument2() {
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents (MainFrame.getInstance()); 
		if ((clipboardContent != null) &&
		 	(clipboardContent.isDataFlavorSupported (DocumentNodeSelection.documentFlavor))) {
			try {
				Document document = (Document) clipboardContent.getTransferData (DocumentNodeSelection.documentFlavor);					
				Object o=this.getLastSelectedPathComponent();
		 		if(o instanceof Project) {
		 			Project project=(Project)o;
		 			Document doc=new Document(document.getName(),project);
		 			ArrayList<Page>pages=new ArrayList<Page>();
		 			pages=document.getPages();
		 			for(Page p:pages) {
		 				Page pg=new Page(p.getName(),doc);
		 				ArrayList<PageElement>elements=new ArrayList<PageElement>();
		 				elements=p.getModel().getPageElements();
		 				for(PageElement element:elements) {
		 					pg.getModel().addPageElements(element);
		 				}
		 				doc.add(pg);
		 			}
		 			project.add(doc);
		 		}
			}catch (Exception ex) {
		 		ex.printStackTrace ();
		 	}
		}
	}
	
}