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
package io.github.meuhlang.meuh.core.compiler.lexical;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Optional;

public class Lexer {

    private final Reader input;

    public Lexer(final String input) {
        this.input = new StringReader(Preconditions.checkNotNull(input));
    }

    public Optional<String> fetchToken() throws IOException {
        final StringBuilder builder = new StringBuilder();

        for (;;) {
            final int read = input.read();
            if (read == -1 || (char)read == ' ') {
                break;
            }

            builder.append((char)read);
        }

        if (builder.length() == 0) {
            return Optional.empty();
        }

        return Optional.of(builder.toString());
    }
}
