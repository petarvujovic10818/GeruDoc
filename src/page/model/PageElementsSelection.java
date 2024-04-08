package page.model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import elements.PageElement;

public class PageElementsSelection implements Transferable,ClipboardOwner{
	
	static public DataFlavor elementFlavor;
	
	private DataFlavor[] supportedFlavors = { elementFlavor };
	public ArrayList<PageElement> pageElements=new ArrayList<PageElement>(); 
	
	public PageElementsSelection(ArrayList<PageElement>pageElements) {
		this.pageElements=pageElements;
		try {

			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Elements");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor))
			return (pageElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(elementFlavor));
	}
	
}
