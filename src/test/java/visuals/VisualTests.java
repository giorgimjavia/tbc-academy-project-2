package visuals;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import tests.LocationFilterTest;
import tests.SiteSearchTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class VisualTests extends SiteSearchTest {
    @Test
    public void homepageVisualTest() throws Exception {

        String baselinePath = "src/test/resources/baseline/homepage.png";
        String testPath = "src/test/resources/test/homepage.png";
        String diffPath = "src/test/resources/diff/homepage-diff.png";

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(testPath))
                .setFullPage(true));

        File baselineFile = new File(baselinePath);

        if (!baselineFile.exists()) {
            System.out.println("⚠️ Baseline missing. Copy " + testPath + " to baseline as the reference image.");
            return;
        }

        BufferedImage baselineImage = ImageIO.read(baselineFile);
        BufferedImage currentImage = ImageIO.read(new File(testPath));

        ImageComparison comparison = new ImageComparison(baselineImage, currentImage, new File(diffPath));
        ImageComparisonResult result = comparison.compareImages();


        Assert.assertEquals(result.getImageComparisonState(), ImageComparisonState.MATCH,
                "Visual regression detected! Diff saved at: " + diffPath);
    }
}
