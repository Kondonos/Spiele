package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class MainWindowController {
	private Main main;
	
	public MainWindowController(Main main){
		this.main=main;
	}

	public void initinputrows(TableView<String> inputview) {
		ObservableList<String> data= FXCollections.observableArrayList();
		for(int i=0;i<500;i++) 
			data.add("");
		Callback<TableColumn<String, String>, TableCell<String, String>> cellFactory=new Callback<TableColumn<String,String>, TableCell<String,String>>() {
			
			@Override
			public TableCell call(TableColumn p) {
				return new EditingCell();
			}
		};
		TableColumn<String,String> in=(TableColumn<String, String>) inputview.getColumns().get(0);
		in.setCellValueFactory(new PropertyValueFactory<String,String>("RAW"));
		in.setCellFactory(cellFactory);
		
		inputview.setItems(data);
	}

	public void setEvents() {
		initinputrows(this.main.getInputview());
		
	}


}
