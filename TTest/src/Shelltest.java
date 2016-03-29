import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;


public class Shelltest extends Shell {
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Shelltest(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmDatei = new MenuItem(menu, SWT.CASCADE);
		mntmDatei.setText("Datei");
		
		Menu menu_1 = new Menu(mntmDatei);
		mntmDatei.setMenu(menu_1);
		
		MenuItem mntmLaden = new MenuItem(menu_1, SWT.NONE);
		mntmLaden.setText("Laden");
		
		MenuItem mntmSpeichern = new MenuItem(menu_1, SWT.NONE);
		mntmSpeichern.setText("Speichern\tStrg+t");
		
		MenuItem mntmEinstellungen = new MenuItem(menu, SWT.NONE);
		mntmEinstellungen.setText("Einstellungen");
		
		CoolBar coolBar = new CoolBar(this, SWT.FLAT | SWT.VERTICAL);
		FormData fd_coolBar = new FormData();
		fd_coolBar.bottom = new FormAttachment(0, 73);
		fd_coolBar.right = new FormAttachment(0, 150);
		fd_coolBar.top = new FormAttachment(0, 27);
		fd_coolBar.left = new FormAttachment(0);
		coolBar.setLayoutData(fd_coolBar);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(0, 228);
		fd_tabFolder.right = new FormAttachment(0, 432);
		fd_tabFolder.top = new FormAttachment(0);
		fd_tabFolder.left = new FormAttachment(0, 145);
		tabFolder.setLayoutData(fd_tabFolder);
		
		TabItem Suchen = new TabItem(tabFolder, SWT.NONE);
		Suchen.setText("Suchen");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		Suchen.setControl(composite);
		composite.setLayout(new FormLayout());
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(0, 10);
		fd_lblNewLabel.left = new FormAttachment(0, 10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("New Label");
		
		text = new Text(composite, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(0, 186);
		fd_text.top = new FormAttachment(0, 10);
		fd_text.left = new FormAttachment(0, 88);
		text.setLayoutData(fd_text);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.right = new FormAttachment(0, 269);
		fd_btnNewButton.top = new FormAttachment(0, 10);
		fd_btnNewButton.left = new FormAttachment(0, 202);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("New Button");
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(0, 185);
		fd_table.right = new FormAttachment(0, 269);
		fd_table.top = new FormAttachment(0, 46);
		fd_table.left = new FormAttachment(0, 10);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Test");
		setSize(450, 296);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
