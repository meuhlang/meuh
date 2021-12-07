package io.github.meuhlang.meuh.cli;

/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.util.Strings;

public class DummyCommandTest {

  @Test
  public void noArgs() throws Exception {
    final String outText =
        tapSystemOutNormalized(
            () -> {
              final String errText =
                  tapSystemErr(() -> new DummyCommand().run(new String[]{}));
              assertTrue(Strings.isNullOrEmpty(errText));
            });

    assertEquals(outText, "DummyData{data=null}\n");
  }

  @Test
  public void answerToLifeUniverseAndEverything() throws Exception {
    final String outText =
        tapSystemOutNormalized(
            () -> {
              final String errText =
                  tapSystemErr(() -> new DummyCommand().run(new String[]{"42"}));
              assertTrue(Strings.isNullOrEmpty(errText));
            });

    assertEquals(outText, "DummyData{data=[42]}\n");
  }
}
