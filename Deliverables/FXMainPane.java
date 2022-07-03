


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Label label;
	
	Button hello;
	Button howdy;
	Button chinese;
	Button clear;
	Button exit;
	Button español;
	
	TextField text;
	
	//  declare two HBoxes
	HBox buttons;
	HBox notButtons;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() 
	{
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		label = new Label("Feedback");
		text = new TextField();
		
		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		español = new Button("Español");
		clear = new Button("Clear");
		exit = new Button("Exit");
		
		buttons = new HBox();
		notButtons = new HBox();
		
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(20));
		buttons.setSpacing(20);
		notButtons.setAlignment(Pos.CENTER);
		notButtons.setPadding(new Insets(20));
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
			manager = new DataManager();
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		buttons.getChildren().addAll(hello, howdy, chinese, español, clear, exit);
		notButtons.getChildren().addAll(label, text);
		getChildren().addAll(buttons, notButtons);
		
		hello.setOnAction(new ButtonClickHandler());
		howdy.setOnAction(new ButtonClickHandler());
		chinese.setOnAction(new ButtonClickHandler());
		español.setOnAction(new ButtonClickHandler());
		clear.setOnAction(new ButtonClickHandler());
		exit.setOnAction(new ButtonClickHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonClickHandler implements EventHandler<ActionEvent>
	{
		
		public void handle(ActionEvent event)
		{
			if (event.getTarget() == hello)
				text.setText(manager.getHello());
			else if (event.getTarget() == howdy)
				text.setText(manager.getHowdy());
			else if (event.getTarget() == chinese)
				text.setText(manager.getChinese());
			else if (event.getTarget() == español)
				text.setText(manager.getEspañol());
			else if (event.getTarget() == clear)
				text.setText("");
			else if (event.getTarget() == exit)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
	
}
	
