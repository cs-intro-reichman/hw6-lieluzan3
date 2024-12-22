import java.awt.Color;

/**
 * Demonstrates the scaling (resizing) operation featured by Runigram.java. 
 * The program receives three command-line arguments: a string representing the name
 * of the PPM file of a source image, and two integers that specify the width and the
 * height of the scaled, output image. For example, to scale/resize ironman.ppm to a width
 * of 100 pixels and a height of 900 pixels, use: java Editor2 ironman.ppm 100 900
 */
public class Editor2 {

    public static void main(String[] args) {
        
        if (args.length != 3) {
            System.out.println("Usage: java Editor2 <filename> <width> <height>");
            return;
        }

        try {
            String filename = args[0];
            int newWidth = Integer.parseInt(args[1]);
            int newHeight = Integer.parseInt(args[2]);

            // Validate width and height
            if (newWidth <= 0 || newHeight <= 0) {
                System.out.println("Error: Width and height must be positive integers.");
                return;
            }

            // Read the original image
            Color[][] originalImage = Runigram.read(filename);

            // Scale the image
            Color[][] scaledImage = Runigram.scaled(originalImage, newWidth, newHeight);

            // Display the original image
            Runigram.setCanvas(originalImage);
            Runigram.display(originalImage);
            StdDraw.pause(2000);

            // Display the scaled image
            Runigram.setCanvas(scaledImage);
            Runigram.display(scaledImage);

        } catch (NumberFormatException e) {
            System.out.println("Error: Width and height must be integers.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
