package utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class utils {
    public  static int[] getColor(Image image , double pixelHeight, double pixelWidth) {
        int [] RGB = new int [3];
        // Getting pixel color by position x=100 and y=40
        PixelReader pixelReader = image.getPixelReader();
        int col=  pixelReader.getArgb((int)(pixelWidth),(int)(pixelHeight));
        RGB[0]  = (col & 0x00ff0000) >> 16;
        RGB[1] = (col & 0x0000ff00) >> 8;
        RGB[2]  =  col & 0x000000ff;
        return  RGB;
    }
    public static WritableImage simpleBinarizationWithTreshold (Image image, int treshhold){
        double x = image.getWidth();
        double y = image.getHeight();

        PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(
                pixelReader,
                (int)image.getWidth(),
                (int)image.getHeight());

        PixelWriter writer = writableImage.getPixelWriter();

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                int[] RGB = getColor(image,i,j);
                int color = (RGB[0]+RGB[1]+RGB[2])/3;
                if(color > treshhold)
                    color = 255;
                else
                    color = 0;
                writer.setColor(j,i, Color.rgb(color,color,color));
            }
        }

        return writableImage;
    }
}
