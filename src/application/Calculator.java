package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utilities.MathHelper;

public class Calculator extends Application {

	@FXML
	public TextField tfnum1, tfnum2;

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("myCaLcuLATOR");

			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(12);

			Scene scene = new Scene(grid, 350, 350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			VBox fields = new VBox();
			fields.setSpacing(10.0);

			Label number1 = new Label("Number 1:");
			tfnum1 = new TextField();
			Label number2 = new Label("Number 2:");
			tfnum2 = new TextField();

			fields.getChildren().addAll(number1, tfnum1, number2, tfnum2);
			grid.add(fields, 8, 3, 2, 1);

			HBox hbButtons = new HBox();
			hbButtons.setSpacing(10.0);

			Button button1 = new Button("+");
			Button button2 = new Button("-");
			Button button3 = new Button("*");
			Button button4 = new Button("%");

			button1.getStyleClass().add("button");
			button2.getStyleClass().add("button");
			button3.getStyleClass().add("button");
			button3.getStyleClass().add("button");
			grid.getStyleClass().add("grid");

			number1.setTextFill(Color.WHITE);
			number2.setTextFill(Color.WHITE);

			hbButtons.getChildren().addAll(button1, button2, button3, button4);

			grid.add(hbButtons, 8, 6, 2, 1);

			VBox results = new VBox();
			results.setSpacing(10.0);

			Label tfresult = new Label("Result:");
			TextField result = new TextField();

			tfresult.setTextFill(Color.WHITE);

			results.getChildren().addAll(tfresult, result);

			grid.add(results, 8, 8, 2, 1);

			button1.setOnAction(event -> {
				result.setText(Double.toString(MathHelper.addValues(tfnum1.getText(), tfnum2.getText())));
			});

			button2.setOnAction(event -> {
				result.setText(Double.toString(MathHelper.subtractValues(tfnum1.getText(), tfnum2.getText())));
			});

			button3.setOnAction(event -> {
				result.setText(Double.toString(MathHelper.multiplyValues(tfnum1.getText(), tfnum2.getText())));
			});

			button4.setOnAction(event -> {
				result.setText(Double.toString(MathHelper.divideValues(tfnum1.getText(), tfnum2.getText())));
			});

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("Number formatting exception " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
