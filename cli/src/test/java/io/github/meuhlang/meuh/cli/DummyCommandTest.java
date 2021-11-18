package io.github.meuhlang.meuh.cli;

import org.testng.annotations.Test;
import org.testng.util.Strings;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DummyCommandTest {

    @Test
    public void noArgs() throws Exception {
        final String outText = tapSystemOutNormalized(() -> {
            final String errText = tapSystemErr(() -> EntryPoint.buildCommandLine().execute("dummy"));
            assertTrue(Strings.isNullOrEmpty(errText));
        });

        assertEquals(outText, "DummyData{data=[]}\n");
    }

    @Test
    public void answerToLifeUniverseAndEverything() throws Exception {
        final String outText = tapSystemOutNormalized(() -> {
            final String errText = tapSystemErr(() -> EntryPoint.buildCommandLine().execute("dummy", "42"));
            assertTrue(Strings.isNullOrEmpty(errText));
        });

        assertEquals(outText, "DummyData{data=[42]}\n");
    }

}
