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

import io.github.meuhlang.meuh.core.DummyData;
import picocli.CommandLine;

@CommandLine.Command
public class DummyCommand implements Runnable {

  @CommandLine.Parameters(paramLabel = "data", description = "one or more dummy data")
  String[] data;

  @Override
  public void run() {
    final DummyData dd;
    if (data == null) {
      dd = new DummyData.Builder().build();
    } else {
      dd = new DummyData.Builder().addData(data).build();
    }

    System.out.println(dd);
  }
}
