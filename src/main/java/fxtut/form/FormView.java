package fxtut.form;

import static javafx.geometry.Pos.CENTER;
import static javafx.scene.text.Font.font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.InsetsBuilder;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

public class FormView extends GridPane {

	private static final double GAP_SIZE = 10.0;
	private static final double INSETS_SIZE = 25.0;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int SPAN1 = 1;
	private static final int SPAN2 = 2;
	
	private int currentRow = 0;
	

	private FormModel model = new FormModel();

	public FormView() {
		setupLayout();

		addTitle("Welcome");
		addUserFieldWithLabel("User Name:");
		addPasswordFieldWithLabel("Password:");

		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		add(hbBtn, 1, 4);
		setGridLinesVisible(true);

		final Text actiontarget = new Text();
		add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Sign in button pressed");
			}
		});
	}

	private void addTitle(String title) {
		Text scenetitle = TextBuilder.create()
				.font(font("Tahoma", FontWeight.NORMAL, 20))
				.text(title)
				.build();
		int horizontalSpan = SPAN2;
		int verticalSpan = SPAN1;
		add(scenetitle, LEFT, currentRow++, horizontalSpan, verticalSpan);
	}
	
	private void addUserFieldWithLabel(String label) {
		add(new Label(label), LEFT, currentRow);
		add(new TextField(), RIGHT, currentRow++);		
	}
	
	private void addPasswordFieldWithLabel(String label) {
		add(new Label(label), LEFT, currentRow);
		add(new PasswordField(), RIGHT, currentRow++);
	}

	private void setupLayout() {
		GridPaneBuilder
				.create()
				.alignment(CENTER)
				.hgap(GAP_SIZE)
				.vgap(GAP_SIZE)
				.padding(
						InsetsBuilder.create().bottom(INSETS_SIZE)
								.top(INSETS_SIZE).left(INSETS_SIZE)
								.right(INSETS_SIZE).build())
		        .applyTo(this);
	}

}
