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

import com.google.common.base.VerifyException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TokenTest {
    @Test(
            expectedExceptions = VerifyException.class,
            expectedExceptionsMessageRegExp = ".*greater than end line.*"
    )
    public void testBadLines() {
        new Token.Builder()
                .startLine(42)
                .endLine(24)
                .build();
    }

    @Test(
            expectedExceptions = VerifyException.class,
            expectedExceptionsMessageRegExp = ".*greater than end character.*"
    )
    public void testBadCharacters() {
        new Token.Builder()
                .startLine(12)
                .endLine(12)
                .startCharacter(42)
                .endCharacter(24)
                .build();
    }

    @DataProvider(name = "nominal")
    public Object[][] provideNominal() {
        return new Object[][]{
                {1, 100, 42, 24},
                {1, 1, 1, 2},
        };
    }

    @Test(dataProvider = "nominal")
    public void testNominal(final int startLine, final int endLine, final int startCharacter, final int endCharacter) {
        new Token.Builder()
                .startLine(startLine)
                .endLine(endLine)
                .startCharacter(startCharacter)
                .endCharacter(endCharacter)
                .value("dummy value")
                .type("dummy type")
                .build();
    }

}
