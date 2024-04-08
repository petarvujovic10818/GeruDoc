package tree.model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class DocumentNodeSelection implements Transferable,ClipboardOwner{
	
	static public DataFlavor documentFlavor;
	
	private DataFlavor[] supportedFlavors = { documentFlavor };
	private Document document;
	
	public DocumentNodeSelection(Document document) {
		this.document=document;
		try {

			documentFlavor = new DataFlavor(Class.forName("tree.model.Document"), "Document");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(documentFlavor))
			return (document);
		else
			throw new UnsupportedFlavorException(documentFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(documentFlavor));
	}

}
