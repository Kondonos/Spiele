package gui;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

import keyboard.Keys;

public class Keyboard {
	Composite keyboard;
	Button[] button;
	
	public Keyboard(Shell shell,Keys keys) {
		this.keyboard=new Composite(shell, SWT.NONE);
		button=new Button[75];
	}
}
