package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import fileIO.FileReader;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import k3m.ArrayOfZerosAndOnes;
import k3m.K3mWrapper;


public class PrimaryController {
    @FXML
    ImageView imageView;
    @FXML
    ImageView imageView1;
    @FXML
    ImageView imageView2;
    @FXML
    ImageView imageView3;


    WritableImage writableImage;
    public static Image fin;
    File file;

    @FXML
    public void loadFile() throws IOException {
        Stage stage = new Stage();
        file = FileReader.chooseFile(stage);
        writableImage = utils.otsuBinarization.otsuMethod(FileReader.loadFile(file));
        imageView.setImage(writableImage);
    }
    @FXML
    public void loadFile2() throws IOException {


        Image img = writableImage;

        Image writableImage2 = K3mWrapper.processAlgorithm(utils.otsuBinarization.otsuMethod(FileReader.loadFile(file)));

        Image writableImage1 = minutia.minutiaDetection.detect(writableImage2);

        imageView1.setImage(writableImage2);
        imageView2.setImage(writableImage1);
        imageView3.setImage(fin);
    }

}
