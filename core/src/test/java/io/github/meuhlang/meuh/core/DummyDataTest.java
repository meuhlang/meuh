package io.github.meuhlang.meuh.core;

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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.List;
import org.testng.annotations.Test;

public class DummyDataTest {

  @Test
  public void testEmptyConstructor() {
    final DummyData dd = new DummyData();
    assertNull(dd.getData());
  }

  @Test
  public void testConstructor() {
    final DummyData dd = new DummyData();

    final List<String> input = List.of("on", "two", "three");
    dd.setData(input);
    assertEquals(dd.getData(), input);
  }
}
