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

import picocli.CommandLine;

@CommandLine.Command(name = "meuh")
public class EntryPoint {

  public static void main(String... args) {
    final var cmd = buildCommandLine();
    final int exitCode = cmd.execute(args);
    System.exit(exitCode);
  }

  static CommandLine buildCommandLine() {
    return new CommandLine(new EntryPoint()).addSubcommand("dummy", new DummyCommand());
  }
}
