package fxtut.form;

import javafx.application.Application;
import javafx.scene.SceneBuilder;
import javafx.stage.Stage;

public class Form extends Application {
	
	public static void main(String... args) {
		launch(args);
	}	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Form");
		
		stage.setScene(
				SceneBuilder.create()
				.root(new FormView())
				.width(500)
				.height(275)
				.build());
		
		stage.show();
	}

}
