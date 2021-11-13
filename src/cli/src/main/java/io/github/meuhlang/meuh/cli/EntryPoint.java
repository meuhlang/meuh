/*
 * Copyright (C) 2021 VERDOÏA Laurent
 *
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
package io.github.meuhlang.meuh.cli;

import picocli.CommandLine;

@CommandLine.Command(name = "meuh")
public class EntryPoint implements Runnable {

    private static final String[] MEUH = new String[]{
            "<Meuh...>",
            "  \\   ^__^",
            "   \\  (oo)\\_______",
            "      (__)\\       )\\/\\",
            "          ||----w |",
            "          ||     ||"
    };

    @Override
    public void run() {
        for (final String line : MEUH) {
            System.out.println(line);
        }
    }

    public static void main(String... args) {
        final int exitCode = new CommandLine(new EntryPoint()).execute(args);
        System.exit(exitCode);
    }
}
