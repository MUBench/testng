package test.github299;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.testng.reporters.jq.Main;
import test.SimpleBaseTest;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ChronologicalPanelXMLTest extends SimpleBaseTest {
    @Test
    public void closesDivForChronologicalClass() throws IOException {
        TestNG tng = create(DummyTest.class);
        tng.addListener(new Main());

        tng.run();

        String xmlOutput = Files.readFile(new File(tng.getOutputDirectory(), "index.html"));
        assertThat(xmlOutput).contains("</div> <!-- chronological-class -->");
    }
}
