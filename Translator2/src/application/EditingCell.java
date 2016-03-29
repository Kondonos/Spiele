package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EditingCell extends TableCell<String, String>{
	private TextField textfield;
	
	public EditingCell(){}
	
	@Override
	public void startEdit(){
		super.startEdit();
		if(textfield==null){
			createTextField();
		}
		setGraphic(textfield);
		setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				textfield.requestFocus();
				textfield.selectAll();
			}
		});
	}
	@Override
	public void cancelEdit(){
		super.cancelEdit();
		setText((String)getItem());
		setContentDisplay(ContentDisplay.TEXT_ONLY);
	}
	
	
	private void createTextField() {
		textfield=new TextField(getString());
		textfield.setMinWidth(this.getWidth()-this.getGraphicTextGap()*2);
		textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if(e.getCode()==KeyCode.ENTER)
					commitEdit(textfield.getText());
				else if(e.getCode()==KeyCode.ESCAPE)
					cancelEdit();
				else if(e.getCode()==KeyCode.TAB){
					commitEdit(textfield.getText());
					TableColumn nextColumn = getNextColumn(!e.isShiftDown());
                    if (nextColumn != null) {
                        getTableView().edit(getTableRow().getIndex(), nextColumn);
                    }
				
				}
			}
		});
		
		textfield.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue && textfield != null) {
                    commitEdit(textfield.getText());
                }
            }
		});    
		
	}

	private String getString() {
		// TODO Auto-generated method stub
		return getItem()==null?"":getItem().toString();
	}
	
	private List<TableColumn<String, ?>> getLeaves(TableColumn<String, ?> root) {
        List<TableColumn<String, ?>> columns = new ArrayList<>();
        if (root.getColumns().isEmpty()) {
            //We only want the leaves that are editable.
            if (root.isEditable()) {
                columns.add(root);
            }
            return columns;
        } else {
            for (TableColumn<String, ?> column : root.getColumns()) {
                columns.addAll(getLeaves(column));
            }
            return columns;
        }
    }
	
	 private TableColumn<String, ?> getNextColumn(boolean forward) {
		 List<TableColumn<String, ?>> columns = new ArrayList<>();
	     for (TableColumn<String, ?> column : getTableView().getColumns()) {
	    	 columns.addAll(getLeaves(column));
	     }
	        //There is no other column that supports editing.
	    if (columns.size() < 2) {
	        return null;
	    }
	    int currentIndex = columns.indexOf(getTableColumn());
	    int nextIndex = currentIndex;
	    if (forward) {
	        nextIndex++;
	        if (nextIndex > columns.size() - 1) {
	        	nextIndex = 0;
	        }
	    } else {
	        nextIndex--;
	        if (nextIndex < 0) {
	        	nextIndex = columns.size() - 1;
	        }
	    }
	    return columns.get(nextIndex);
	 }
	 @Override
	    public void updateItem(String item, boolean empty) {
	        super.updateItem(item, empty);
	        if (empty) {
	            setText(null);
	            setGraphic(null);
	        } else {
	            if (isEditing()) {
	                if (textfield != null) {
	                    textfield.setText(getString());
	                }
	                setGraphic(textfield);
	                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	            } else {
	                setText(getString());
	                setContentDisplay(ContentDisplay.TEXT_ONLY);
	            }
	        }
	    }
	

	
}
