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

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Optional;

import static org.testng.Assert.*;

public class LexerTest {

    @Test
    public void testEmpty() throws IOException {
        final var lexer = new Lexer("");
        assertEquals(lexer.fetchToken(), Optional.empty());
    }

    @Test
    public void testDummy() throws IOException {
        final var lexer = new Lexer("one two");

        assertEquals(lexer.fetchToken(), Optional.of("one"));
        assertEquals(lexer.fetchToken(), Optional.of("two"));
        assertEquals(lexer.fetchToken(), Optional.empty());
   }

}
