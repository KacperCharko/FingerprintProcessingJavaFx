package utils;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import static utils.utils.getColor;

public class otsuBinarization {

    public static WritableImage otsuMethod (WritableImage image){

        Image img = greyScaleImage.returnGrayScaleImage(image);

        double x = image.getWidth();
        double y = image.getHeight();
        int totalNumberOfPixels = (int)(x*y);
        int[] table = new int [256];

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                int[] RGB = getColor(image,i, j);
                int hue = (RGB[0]);
                table[hue]++;
            }
        }
        int index =0;

        double choosenVariance = 999999999;
        for(int i = 0; i < 256; i++){
            double backgroundWeight=0;
            double backgroundMean=0;
            double backgroundVariance=0;
            double foregorundWeight=0;
            double foregroundMean=0;
            double foregroundVariance=0;

            //background
            for (int j = 0; j<i; j++){
                backgroundWeight +=table[j];
                backgroundMean += table[j]*j;
            }
            backgroundMean = backgroundMean/backgroundWeight;
            int pixelsInBackgroundCount = (int)backgroundWeight;
            backgroundWeight = backgroundWeight / totalNumberOfPixels;
            for (int jj = 0; jj <i; jj++){
                backgroundVariance += (Math.pow((jj - backgroundMean),2))*table[jj];
            }
            backgroundVariance = backgroundVariance/pixelsInBackgroundCount;



            for (int k = i; k<=255; k++){
                foregorundWeight +=table[k];
                foregroundMean += table[k]*k;
            }
            foregroundMean = foregroundMean/foregorundWeight;
            int pixelsInForeground = (int)foregorundWeight;
            foregorundWeight = foregorundWeight / totalNumberOfPixels;
            for (int kk = i; kk <=255; kk++){
                foregroundVariance += (Math.pow((kk - foregroundMean),2))*table[kk];
            }
            foregroundVariance = foregroundVariance/pixelsInForeground;

            //final calculating

            double withinVar = (backgroundWeight*backgroundVariance) + (foregorundWeight*foregroundVariance);

            if(choosenVariance > withinVar){
                choosenVariance = withinVar;
                index = i;
            }
        }

        WritableImage img1 = utils.simpleBinarizationWithTreshold(image,index);

        return img1;
    }

}
