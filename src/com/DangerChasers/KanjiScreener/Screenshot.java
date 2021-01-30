package com.DangerChasers.KanjiScreener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {
    public void capture() {
        try {
            Robot robot = new Robot();
            String format = "jpg";
            String filename = "screenshot." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenImage, format, new File(filename));

//            System.out.println("Screenshot saved");
        }
        catch (AWTException | IOException ex) {
            System.out.println(ex);
        }
    }
}
