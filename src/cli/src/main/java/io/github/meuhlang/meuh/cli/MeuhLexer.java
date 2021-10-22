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

import io.github.meuhlang.meuh.core.compiler.lexical.Lexer;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command
public class MeuhLexer implements Runnable {

    @CommandLine.Parameters(
            paramLabel = "line",
            description = "one ore more line to lex"
    )
    String[] lines;

    @Override
    public void run() {
        for (final String line : lines) {
            final var lexer = new Lexer(line);
            System.out.println("Line: " + line);

            try {
                for (; ; ) {
                    final var token = lexer.fetchToken();
                    if (token.isEmpty()) {
                        break;
                    }

                    System.out.println("Token: " + token.get());
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }
}
