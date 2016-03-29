package view;

import java.util.UUID;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import controll.MainController;

public class Translator{
	private Shell shell;
	private Composite raw,kana,meaning,controlls;
	private FormLayout formlayout;
	private Button translate;
	private Table input,furi,mean;
	private MainController controller;
	
	
	public Translator(Shell shell,MainController controller){
		this.controller=controller;
		this.shell=shell;
		this.formlayout=new FormLayout();
		shell.setLayout(this.formlayout);
		
		raw=new Composite(this.shell,SWT.NONE);
		//raw.setVisible(false);
		raw.setBackground(new Color(shell.getDisplay(), new RGB(255, 0, 0)));
		FormData fdr=new FormData();
		fdr.top=new FormAttachment(0,10);
		fdr.left=new FormAttachment(0,10);
		fdr.right=new FormAttachment(33,-5);
		fdr.bottom=new FormAttachment(100,-100);
		raw.setLayoutData(fdr);
		System.out.println(raw.getLocation().toString());
		
		kana=new Composite(this.shell, SWT.NONE);
		//kana.setVisible(false);
		kana.setBackground(new Color(shell.getDisplay(), new RGB(0, 255, 0)));
		FormData fdk=new FormData();
		fdk.top=new FormAttachment(0,10);
		fdk.bottom=new FormAttachment(100,-100);
		fdk.right=new FormAttachment(66,-5);
		fdk.left=new FormAttachment(raw,5);
		kana.setLayoutData(fdk);
		
		meaning=new Composite(this.shell, SWT.NONE);
		//meaning.setVisible(false);
		meaning.setBackground(new Color(shell.getDisplay(), new RGB(0, 0, 255)));
		FormData fdm=new FormData(); 
		fdm.top=new FormAttachment(0,10);
		fdm.bottom=new FormAttachment(100,-100);
		fdm.right=new FormAttachment(100,-10);
		fdm.left=new FormAttachment(kana,10);
		meaning.setLayoutData(fdm);
	
		controlls=new Composite(shell, SWT.BORDER);
		//controlls.setVisible(false);
		controlls.setBackground(new Color(shell.getDisplay(), new RGB(255, 0, 255)));
		FormData fdc=new FormData();
		fdc.top=new FormAttachment(100,-100);
		fdc.bottom=new FormAttachment(100,-5);
		fdc.right=new FormAttachment(100,-5);
		fdc.left=new FormAttachment(0,10);
		controlls.setLayoutData(fdc);
		
		FillLayout filllayout=new FillLayout();
		raw.setLayout(filllayout);
		
		buildtables();
	}
	
	private void buildtables(){
		buildrawtable();
		buildkanatable();
		buildmeaningtable();
	}
	
	private void buildrawtable() {
		this.input=new Table(raw, SWT.SINGLE|SWT.V_SCROLL|SWT.BORDER);
		this.input.setHeaderVisible(false);
		this.input.setData("RAW");
		this.input.setLinesVisible(true);
		TableColumn in = new TableColumn(input, SWT.NULL);
		FillLayout fillLayout=new FillLayout();
		this.input.setLayout(fillLayout);
		
		for(int i=0;i<20;i++){
			TableItem item=new TableItem(input, SWT.NONE,i);
			item.setText(new String[]{""});
		}
		
		
		this.input.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				controller.handleEvent(e);
			}
		});
		
		in.pack();
		input.pack();
		System.out.println(input.getItemCount());
		
	}

	private void buildkanatable() {
		// TODO Auto-generated method stub
		
	}

	private void buildmeaningtable() {
		// TODO Auto-generated method stub
		
	}
	
	public Table getInput() {
		return input;
	}
	public Table getFuri() {
		return furi;
	}
	public Table getMean() {
		return mean;
	}
	
}
