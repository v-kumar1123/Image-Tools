import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class ImageTools2 {

    public static int HORIZONTAL_FLIP = 1, VERTICAL_FLIP = 2, DOUBLE_FLIP = 3;

    /**
     * Loads an image.
     *
     * @param fileName The name of a file with an image
     * @return Returns the loaded image. null is returned if the image cannot be loaded.
     */
    public static BufferedImage load(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    /**
     * Copies and returns an image.
     *
     * @param img Receives a buffered image
     * @return Returns a copy of the received image. null is returned if the received image is null.
     */
    public static BufferedImage copy(BufferedImage img) {
        BufferedImage tempImage=img;

        return tempImage;
    }

    /**
     * Returns a new image with transparency enabled.
     *
     * @param img Receives a buffered image
     * @return returns a copy of the received image with a color mode that allows transparency.
     * null is returned if the received image is null.
     */
    public static BufferedImage copyWithTransparency(BufferedImage img) {
        if(img==null) {
            return  null;
        }
        BufferedImage transparent=new BufferedImage(img.getWidth(),img.getHeight(),TYPE_INT_ARGB);
        for(int x=0;x<img.getWidth();x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                transparent.setRGB(x,y,img.getRGB(x,y));
            }
        }
        return transparent;
        //TYPE_INT_ARGB – RGB color with transparency
    }

    /**
     * Checks if the provided image has transparency.
     *
     * @param img Receives a buffered image
     * @return returns true if the image has a transparent mode and false otherwise.
     */
    public static boolean hasTransparency(BufferedImage img) {
        if(img.getType()==TYPE_INT_ARGB) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Scales an image.
     *
     * @param img Receives a buffered image and two positive double scale values (percentages)
     * @param horizontalScale Value to scale horizontal by.
     * @param verticalScale Value to scale vertical by.
     * @return creates and returns a scaled copy of the received image,
     * null is returned if the received image is null or if non-positive scales are provided
     */
    public static BufferedImage scale(BufferedImage img, double horizontalScale, double verticalScale) {
        return null;
    }

    /**
     * Scales an image.
     *
     * @param img Receives a buffered image
     * @param newWidth New width to scale to.
     * @param newHeight New height to scale to.
     * @return creates and returns a scaled copy of the received image,
     * null is returned if the received image is null or if non-positive dimensions are provided
     */
    public static BufferedImage scale(BufferedImage img, int newWidth, int newHeight) {
        BufferedImage scaled=null;
        if(img==null) {
            return null;
        }
        for(int x=0;x<img.getWidth();x++) {
            for(int y=0;y<img.getHeight();y++) {
                if(img!=null) {
                    scaled=new BufferedImage(newWidth,newHeight,img.getColorModel().getTransparency());
                    Graphics2D g=(Graphics2D) scaled.getGraphics();
                    AffineTransform affineTransform=new AffineTransform();
                    affineTransform.scale(newWidth/img.getWidth(),newHeight/img.getHeight());
                    g.drawImage(img,affineTransform,null);
                }
            }
        }
        return scaled;
    }

    /**
     * Rotates an image.
     *
     * @param img Receives a buffered image
     * @param angle The angle to rotate to.
     * @return The rotated image. null is returned if the received image is null.
     */
    public static BufferedImage rotate(BufferedImage img, double angle) {
        return null;
    }

    /**
     * Flips an image.
     *
     * @param img Receives a buffered image
     * @param type Type of flip (int)
     * @return Creates and returns a flipped copy of the received image.
     * null is returned if the received image is null or if an invalid flipping value is provided
     */
    public static BufferedImage flip(BufferedImage img, int type) {
        return null;
    }

    /**
     * Blurs an image.
     *
     * @param img Receives a buffered image
     * @return creates and returns a blurred copy of the received image,
     * the blurring is created by blending each cell with its 8 neighbors.
     * Null is returned if the received image is null.
     */
    public static BufferedImage blur(BufferedImage img) {
        return null;
    }

    /**
     * Inverts an image's colors.
     *
     * @param img Receives a buffered image
     * @return Image with inverted colors. null is returned if the received image is null.
     */
    public static BufferedImage invertColor(BufferedImage img) {
        return null;
    }

    /**
     * Removes a certain percentage of an image's pixels.
     *
     * @param img Receives a buffered image
     * @param percentToRemove Percent to remove of the image.
     * @return creates and returns a copy of the received image with the given
     * percentage in decimal form of the images remaining non-fully transparent
     * pixels changed to be completely transparent. null is returned if the
     * received image is null or if non-positive percentage is provided.
     */
    public static BufferedImage removePixels(BufferedImage img, double percentToRemove) {
        return null;
    }

    /**
     * Removes a certain amount of pixels from an image.
     *
     * @param img Receives a buffered image
     * @param numToRemove number of pixels to remove
     * @return creates and returns a copy of the received image with the given
     * number of the images remaining pixels removed.
     * Non-fully transparent pixels are changed to be completely transparent.
     * null is returned if the received image is null or if non-positive number
     * is provided. Note: is there are not enough pixels in the image it will
     * remove as many as it can.
     */
    public static BufferedImage removePixels(BufferedImage img, int numToRemove) {
        return null;
    }

    /**
     * Fades an image.
     *
     * @param img Receives a buffered image
     * @param fade Double percentage to fade
     * @return Creates and returns a copy of the received image that has been
     * faded the given percentage. Fading is done by multiply the alpha value by (1-fade)
     * Null is returned if the received image is null or if non-positive fade value is provided
     * Note: any fade greater than 1 will be reduced to 1
     */
    public static BufferedImage fade(BufferedImage img, double fade) {
        return null;
    }

    /**
     * Lightens an image.
     *
     * @param img Receives a buffered image
     * @param lightenFactor double percentage to lighten
     * @return creates and returns a copy of the received image that has been
     * lightened by the given percentage + 1.
     * Null is returned if the received image is null or if non-positive lighten.
     * Factor value is provided.
     * Note: any colors that end up being larger than 255 will be changed to 255.
     */
    
    //NOT WORKING
    public static BufferedImage lighten(BufferedImage img, double lightenFactor) {
        BufferedImage lightened=new BufferedImage(img.getWidth(),img.getHeight(),TYPE_INT_ARGB);
        for(int x=0;x<img.getWidth();x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                lightened.setRGB(x,y,img.getRGB(x,y));
            }
        }/*
        for(int x=0;x<img.getWidth();x++) {
            //TODO: 4/4/19 HEY GUYS DONT FORGET TO DO THIS!!!
            for(int y=0;y<img.getHeight();y++) {
                Color color=new Color(lightened.getRGB(x,y));
                if((int)(color.getRed()+lightenFactor*color.getRed())>255||(int)(color.getBlue()+lightenFactor*color.getBlue())>255||(int)(color.getGreen()+lightenFactor*color.getGreen())>255) {
                    if((int)(color.getRed()+lightenFactor*color.getRed())>255) {
                        color=new Color(255,color.getBlue(),color.getGreen());
                    }
                    if((int)(color.getBlue()+lightenFactor*color.getBlue())>255) {
                        color=new Color(color.getRed(),255,color.getGreen());
                    }
                    if((int)(color.getGreen()+lightenFactor*color.getGreen())>255) {
                        color=new Color(color.getRed(),color.getBlue(),255);
                    }
                    lightened.setRGB(x,y,color.getRGB());
                }
                else {
                    color=new Color((int)(color.getRed()+color.getRed()*lightenFactor),(int)(color.getBlue()+color.getBlue()*lightenFactor),(int)(color.getGreen()+lightenFactor*color.getGreen()));
                    lightened.setRGB(x,y,color.getRGB());
                }
            }
        }*/
        return lightened;
    }

    /**
     * Darkens an image.
     *
     * @param img Receives a buffered image
     * @param darkenFactor double percentage to darken
     * @return creates and returns a copy of the received image that has been
     * darkened by 1 minus the given percentage.
     * null is returned if the received image is null or if non-positive.
     * Note: any colors that end up being larger than 255 will be
     * changed to 255.
     */
    public static BufferedImage darken(BufferedImage img, double darkenFactor) {
        return null;
    }
}