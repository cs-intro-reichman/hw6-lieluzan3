import java.awt.Color;


public class Editor4 {

    public static void main(String[] args) {
        // Verify the correct number of arguments
        if (args.length != 2) {
            System.out.println("Usage: java Editor4 <sourceFile> <steps>");
            return;
        }

        try {
            String source = args[0];
            int n = Integer.parseInt(args[1]);

            if (n <= 0) {
                System.out.println("Error: Number of steps must be a positive integer.");
                return;
            }

            Color[][] sourceImage = Runigram.read(source);

           
            Color[][] grayscaleImage = Runigram.grayScaled(sourceImage);

           
            Runigram.setCanvas(sourceImage);
            Runigram.morph(sourceImage, grayscaleImage, n);

        } catch (NumberFormatException e) {
            System.out.println("Error: Steps must be an integer.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


