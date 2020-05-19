package main;

import java.io.IOException;

import fileIO.FileReader;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.App;

public class PrimaryController {
    @FXML
    ImageView imageView;
    @FXML
    ImageView imageView1;

    WritableImage writableImage;


    @FXML
    public void loadFile() throws IOException {
        Stage stage = new Stage();
        writableImage = utils.otsuBinarization.otsuMethod(FileReader.loadFile(stage));
        imageView.setImage(writableImage);
    }
    @FXML
    public void loadFile2() throws IOException {
        Stage stage = new Stage();
        WritableImage writableImage = FileReader.loadFile(stage);
        imageView1.setImage(writableImage);
    }
    @FXML
    public void handleMenuBar(KeyEvent keyEvent) {
    }
}
