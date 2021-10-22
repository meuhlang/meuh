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
import com.google.common.base.Strings;
import com.google.common.base.Verify;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface Token {
    int startLine();

    int endLine();

    int startCharacter();

    int endCharacter();

    String value();

    String type();

    class Builder extends Token_Builder {
        @Override
        public Builder startLine(final int startLine) {
            Preconditions.checkArgument(startLine > 0);
            return super.startLine(startLine);
        }

        @Override
        public Builder endLine(final int endLine) {
            Preconditions.checkArgument(endLine > 0);
            return super.endLine(endLine);
        }

        @Override
        public Builder startCharacter(final int startCharacter) {
            Preconditions.checkArgument(startCharacter > 0);
            return super.startCharacter(startCharacter);
        }

        @Override
        public Builder endCharacter(final int endCharacter) {
            Preconditions.checkArgument(endCharacter > 0);
            return super.endCharacter(endCharacter);
        }

        @Override
        public Builder value(final String value) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(value));
            return super.value(value);
        }

        @Override
        public Builder type(final String type) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(type));
            return super.type(type);
        }

        @Override
        public Token build() {
            final int startLine = startLine();
            final int endLine = endLine();

            Verify.verify(
                    endLine >= startLine,
                    "start line (%s) must be greater than end line (%s)",
                    startLine,
                    endLine
            );

            final int startCharacter = startCharacter();
            final int endCharacter = endCharacter();
            Verify.verify(
                    endLine != startLine || startCharacter < endCharacter,
                    "On the same line, start character (%s) must be greater than end character (%s)",
                    startCharacter,
                    endCharacter
            );

            return super.build();
        }
    }
}
