import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Parent root = new FXMLLoader(getClass().getResource("/view/ChessAppView.fxml")).getRoot();
        Scene scene = new Scene(new Group());
        stage.setScene(scene);
        stage.show();
    }
}
