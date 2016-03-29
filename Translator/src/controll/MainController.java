package controll;

import javax.swing.JTable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.DeviceData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

import view.Translator;

public class MainController {
	private Shell shell;
	private Display display;
	private Translator trans;
	private TableEditor editorRaw,editorKana,editorMean;
	private TableCursor cursor;
	private ControlEditor editor;
	
	
	public MainController (){
		this.display=new Display();
		//System.out.println(display.toString());
		this.shell=new Shell(display,SWT.ON_TOP|SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.RESIZE);
		this.trans=new Translator(shell,this);
		this.editorRaw=new TableEditor(trans.getInput());
		editorRaw.grabHorizontal=true;
		editorRaw.horizontalAlignment=SWT.LEFT;
		resizingTables(trans.getInput());
		run();
	}
	private void resizingTables(Table table) {
		Composite comp=table.getParent();
		comp.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle area = comp.getClientArea();
				Point size = table.computeSize(SWT.DEFAULT, SWT.DEFAULT);
				ScrollBar vBar = table.getVerticalBar();
				int width = area.width - table.computeTrim(0,0,0,0).width - vBar.getSize().x;
				if (size.y > area.height + table.getHeaderHeight()) {
					// Subtract the scrollbar width from the total column width
					// if a vertical scrollbar will be required
					Point vBarSize = vBar.getSize();
					width -= vBarSize.x;
				}
				table.setSize(area.width, area.height);
				table.getColumns()[0].setWidth(width);
			}
		});
		
	}
	private void run() {
		shell.pack();
		shell.open();
		 while (!shell.isDisposed()) {
			 if (!display.readAndDispatch()) {
		        display.sleep();
			 }
		 }

		 display.dispose();
	}
	public void handleEvent(TypedEvent e) {
		System.out.println(e.getSource()+" "+((Widget)e.getSource()).getData());
		String s=e.getSource().toString();
		if(s.startsWith("Table")){
			SelectionEvent se=(SelectionEvent) e;
			Table table=(Table)se.getSource();	
			if(table.getData().equals("RAW")){
				modifyinput(table,se);
			}
			
			
		}
	}
	private void modifyinput(Table table, SelectionEvent se) {
		Control oldeditor=editorRaw.getEditor();
		if(oldeditor!=null)oldeditor.dispose();
		
		TableItem item=(TableItem)se.item;
		if(item==null)return;
		Text newEditor=new Text(table, SWT.NONE);
		newEditor.setText(item.getText(0));
		newEditor.addModifyListener(new ModifyListener() {	
			@Override
			public void modifyText(ModifyEvent me) {
				Text text=(Text) editorRaw.getEditor();
				editorRaw.getItem().setText(new String[] {text.getText()});
				table.showItem(item);
				System.out.println(text.getText());
			}
		});
		
		final TableCursor cursor = new TableCursor(table, SWT.NONE);
		final ControlEditor editor = new ControlEditor(cursor);
		editor.grabHorizontal = true;
		editor.grabVertical = true;

		newEditor.addTraverseListener(new TraverseListener() {
			
			@Override
			public void keyTraversed(TraverseEvent e) {
				int currentSelectionIndex = table.getSelectionIndex();
                switch (e.detail) {
                case SWT.TRAVERSE_TAB_NEXT:
                    table.setSelection(currentSelectionIndex + 1);
                    e.doit = false;
                    break;
                case SWT.TRAVERSE_TAB_PREVIOUS:
                    int index = currentSelectionIndex - 1;
                    table.setSelection(index);
                    e.doit = false;
                    break;
                }
                
				
			}
		});
		newEditor.selectAll();
		newEditor.setFocus();
		editorRaw.setEditor(newEditor, item, 0);
	}
}
