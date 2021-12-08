package io.github.meuhlang.meuh.cli.cmd.dummy;

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

import io.github.meuhlang.meuh.cli.Command;
import io.github.meuhlang.meuh.core.DummyData;
import java.util.List;

public class DummyCommand implements Command {

  public int run(final String[] args) {
    final DummyData dd = new DummyData();
    if (args.length > 0) {
      dd.setData(List.of(args));
    }

    System.out.println(dd);

    return 0;
  }

}
