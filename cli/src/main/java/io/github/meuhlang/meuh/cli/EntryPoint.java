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

import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Map;

/** The entry point of the dummy command. */
public class EntryPoint {

  private static final Map<String, CommandBuilder> COMMANDS;

  static {
    COMMANDS = Map.ofEntries(entry("dummy", DummyCommand::new));
  }

  /**
   * Entry point of the dummy command.
   *
   * @param args command line arguments
   */
  public static void main(final String... args) {
    if (args.length < 1) {
      throw new RuntimeException("No command given !");
    }

    final String commandName = args[0];
    final var commandBuilder = COMMANDS.get(commandName.toLowerCase());
    if (commandBuilder == null) {
      throw new RuntimeException("Unknown command: " + commandName);
    }

    final var commandArgs = Arrays.copyOfRange(args, 1, args.length);
    final int returnCode = commandBuilder.build().run(commandArgs);
    System.exit(returnCode);
  }

}
