package ExpenseForm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExpsenseFormApp extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        // Set up the scene
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ExpenseForm/view/ExpenseForm.fxml")));
        primaryStage.setTitle("Expense Form Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch(args);
    }
}
