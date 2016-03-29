package application;
	
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private Stage stage;
	private TableView<String> inputview,kanaview,meaningview;
	private Button translateButton,saveButton;
	
	@Override
	public void start(Stage primaryStage) {
		this.stage=primaryStage;
		mainWindow();
	}
	
	
	public void mainWindow() {
		
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
			AnchorPane anchor=loader.load();
			
			this.stage.setMinHeight(400.00);
			this.stage.setMinWidth(600.0);
			
			MainWindowController controller=new MainWindowController(this);
			loader.setController(controller);
			VBox vbox=(VBox) anchor.getChildren().get(0);
				ObservableList<Node> nodes=vbox.getChildren();
				MenuBar menu=(MenuBar)nodes.get(0);
				GridPane gridpane=(GridPane) nodes.get(1);
				ObservableList< Node> gridnodes=gridpane.getChildren();
				this.inputview=(TableView<String>)gridnodes.get(0);
				this.kanaview=	(TableView<String>)gridnodes.get(1);
				this.meaningview=(TableView<String>)gridnodes.get(2);
				HBox hbox=(HBox) nodes.get(2);
				ObservableList<Node> hboxnodes=hbox.getChildren();
				this.translateButton=(Button)hboxnodes.get(0);
				this.saveButton=(Button) hboxnodes.get(1);
			this.inputview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			controller.initinputrows(this.inputview);
			controller.setEvents();
		
			Scene scene=new Scene(anchor);
			this.stage.setScene(scene);
			this.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TableView<String> getInputview() {
		return inputview;
	}
	public TableView<String> getKanaview() {
		return kanaview;
	}
	public TableView<String> getMeaningview() {
		return meaningview;
	}
	public Button getSaveButton() {
		return saveButton;
	}
	public Button getTranslateButton() {
		return translateButton;
	}


	public static void main(String[] args) {
		launch(args);
	}
}
