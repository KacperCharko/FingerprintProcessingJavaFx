package fileIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {


    public static WritableImage loadFile(Stage stage){
        File file = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Szukaj mnie");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg","*.png","*.jpeg","*.bmp","*.tiff","*.tif","*.gif"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file != null){
            BufferedImage buffered=null;
            try {
                buffered = ImageIO.read(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Image imagePicked = null;
            imagePicked = SwingFXUtils.toFXImage(buffered,null);

            double width = imagePicked.getWidth();
            double eight = imagePicked.getHeight();

            PixelReader pixelReader = imagePicked.getPixelReader();

           return  new WritableImage(
                    pixelReader,
                    (int)imagePicked.getWidth(),
                    (int)imagePicked.getHeight());
        }
        return null;
    }
}
