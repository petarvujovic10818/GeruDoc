package actions;

public class ActionManager {

	private AboutAction aboutAction;
	private RenameAction renameAction;
	private DeleteAction deleteAction;
	private NewNodeAction newNodeAction;
	
	private CircleAction circleAction;
	private RectangleAction rectangleAction;
	private TriangleAction triangleAction;
	
	private SaveProjectAction saveProjectAction;
	private OpenProjectAction openProjectAction;
	private SaveAsProjectAction saveAsProjectAction;
	private SwitchWorkspaceAction switchWorkspaceAction;
	
	private SelectAction selectAction;
	private ResizeAction resizeAction;
	private RotateAction rotateAction;
	
	private DeleteElementAction deleteElementAction;
	private DragAndDropAction dragAndDropAction;
	
	private UndoAction undoAction;
	private RedoAction redoAction;
	
	private CopyAction copyAction;
	private CutAction cutAction;
	private PasteAction pasteAction;
	
	private DocumentCopyAction documentCopyAction;
	private DocumentCutAction documentCutAction;
	private DocumentPasteAction documentPasteAction;
	
	private PreviewAction previewAction;
	private ShareDocumentAction shareDocumentAction;
	private ShareDocumentToAction shareDocumentToAction;
	
	
	public ActionManager() {
		initialiseActions();
	}
	
	private void initialiseActions() {
		aboutAction=new AboutAction();
		renameAction=new RenameAction();
		deleteAction=new DeleteAction();
		newNodeAction=new NewNodeAction();
		
		circleAction=new CircleAction();
		rectangleAction=new RectangleAction();
		triangleAction=new TriangleAction();
		
		saveProjectAction=new SaveProjectAction();
		openProjectAction=new OpenProjectAction();
		saveAsProjectAction=new SaveAsProjectAction();
		switchWorkspaceAction=new SwitchWorkspaceAction();
		
		selectAction=new SelectAction();
		rotateAction=new RotateAction();
		resizeAction=new ResizeAction();
		
		deleteElementAction=new DeleteElementAction();
		dragAndDropAction=new DragAndDropAction();
		
		undoAction=new UndoAction();
		redoAction=new RedoAction();
		
		copyAction=new CopyAction();
		cutAction=new CutAction();
		pasteAction=new PasteAction();
		
		documentCopyAction=new DocumentCopyAction();
		documentCutAction=new DocumentCutAction();
		documentPasteAction=new DocumentPasteAction();
		
		previewAction=new PreviewAction();
		shareDocumentAction=new ShareDocumentAction();
		shareDocumentToAction=new ShareDocumentToAction();
		
	}
	
	public DocumentCopyAction getDocumentCopyAction() {
		return documentCopyAction;
	}
	
	public DocumentCutAction getDocumentCutAction() {
		return documentCutAction;
	}
	
	public DocumentPasteAction getDocumentPasteAction() {
		return documentPasteAction;
	}
	
	public ShareDocumentToAction getShareDocumentToAction() {
		return shareDocumentToAction;
	}
	
	public void setShareDocumentToAction(ShareDocumentToAction shareDocumentToAction) {
		this.shareDocumentToAction = shareDocumentToAction;
	}
	
	public ShareDocumentAction getShareDocumentAction() {
		return shareDocumentAction;
	}
	
	public void setShareDocumentAction(ShareDocumentAction shareDocumentAction) {
		this.shareDocumentAction = shareDocumentAction;
	}
	
	public PreviewAction getPreviewAction() {
		return previewAction;
	}
	
	public void setPreviewAction(PreviewAction previewAction) {
		this.previewAction = previewAction;
	}
	
	public CopyAction getCopyAction() {
		return copyAction;
	}
	
	public void setCopyAction(CopyAction copyAction) {
		this.copyAction = copyAction;
	}
	
	public CutAction getCutAction() {
		return cutAction;
	}
	
	public void setCutAction(CutAction cutAction) {
		this.cutAction = cutAction;
	}
	
	public PasteAction getPasteAction() {
		return pasteAction;
	}
	
	public void setPasteAction(PasteAction pasteAction) {
		this.pasteAction = pasteAction;
	}
	
	public RedoAction getRedoAction() {
		return redoAction;
	}
	
	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}
	
	public UndoAction getUndoAction() {
		return undoAction;
	}
	
	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}
	
	public DragAndDropAction getDragAndDropAction() {
		return dragAndDropAction;
	}
	
	public void setDragAndDropAction(DragAndDropAction dragAndDropAction) {
		this.dragAndDropAction = dragAndDropAction;
	}
	
	public DeleteElementAction getDeleteElementAction() {
		return deleteElementAction;
	}
	
	public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
		this.deleteElementAction = deleteElementAction;
	}
	
	public SelectAction getSelectAction() {
		return selectAction;
	}
	
	public void setSelectAction(SelectAction selectAction) {
		this.selectAction = selectAction;
	}
	
	public RotateAction getRotateAction() {
		return rotateAction;
	}
	
	public void setRotateAction(RotateAction rotateAction) {
		this.rotateAction = rotateAction;
	}
	
	public ResizeAction getResizeAction() {
		return resizeAction;
	}
	
	public void setResizeAction(ResizeAction resizeAction) {
		this.resizeAction = resizeAction;
	}
	
	public SwitchWorkspaceAction getSwitchWorkspaceAction() {
		return switchWorkspaceAction;
	}
	
	public void setSwitchWorkspaceAction(SwitchWorkspaceAction switchWorkspaceAction) {
		this.switchWorkspaceAction = switchWorkspaceAction;
	}
	
	public SaveAsProjectAction getSaveAsProjectAction() {
		return saveAsProjectAction;
	}
	
	public void setSaveAsProjectAction(SaveAsProjectAction saveAsProjectAction) {
		this.saveAsProjectAction = saveAsProjectAction;
	}
	
	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}
	
	public void setOpenProjectAction(OpenProjectAction openProjectAction) {
		this.openProjectAction = openProjectAction;
	}
	
	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}
	
	public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
		this.saveProjectAction = saveProjectAction;
	}
	
	public void setNewNodeAction(NewNodeAction newNodeAction) {
		this.newNodeAction = newNodeAction;
	}
	
	public NewNodeAction getNewNodeAction() {
		return newNodeAction;
	}

	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public void setAboutAction(AboutAction aboutAction) {
		this.aboutAction = aboutAction;
	}

	public RenameAction getRenameAction() {
		return renameAction;
	}

	public void setRenameAction(RenameAction renameAction) {
		this.renameAction = renameAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	public void setDeleteAction(DeleteAction deleteAction) {
		this.deleteAction = deleteAction;
	}
	
	public TriangleAction getTriangleAction() {
		return triangleAction;
	}
	
	public void setTriangleAction(TriangleAction triangleAction) {
		this.triangleAction = triangleAction;
	}
	
	public CircleAction getCircleAction() {
		return circleAction;
	}
	
	public void setCircleAction(CircleAction circleAction) {
		this.circleAction = circleAction;
	}
	
	public RectangleAction getRectangleAction() {
		return rectangleAction;
	}
	
	public void setRectangleAction(RectangleAction rectangleAction) {
		this.rectangleAction = rectangleAction;
	}
}