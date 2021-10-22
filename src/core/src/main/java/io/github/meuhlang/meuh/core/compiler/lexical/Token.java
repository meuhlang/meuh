package io.github.meuhlang.meuh.core.compiler.lexical;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface Token {
    int startLine();

    int startCharacter();

    int endLine();

    int endCharacter();

    String value();

    TokenType type();

    class Builder extends Token_Builder {
        @Override
        public Builder startLine(final int startLine) {
            Preconditions.checkArgument(startLine >= 0);
            return super.startLine(startLine);
        }

        @Override
        public Builder startCharacter(final int startCharacter) {
            Preconditions.checkArgument(startCharacter >= 0);
            return super.startCharacter(startCharacter);
        }

        @Override
        public Builder endLine(final int endLine) {
            Preconditions.checkArgument(endLine >= 0);
            return super.endLine(endLine);
        }

        @Override
        public Builder endCharacter(final int endCharacter) {
            Preconditions.checkArgument(endCharacter >= 0);
            return super.endCharacter(endCharacter);
        }

        @Override
        public Builder value(final String value) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(value));
            return super.value(value);
        }

        @Override
        public Token build() {
            final int startLine = startLine();
            final int endLine = endLine();
            Preconditions.checkArgument(
                    endLine >= startLine,
                    "start line (%s) must be greater than end line (%s)",
                    startLine,
                    endLine
            );

            final int startCharacter = startCharacter();
            final int endCharacter = endCharacter();
            Preconditions.checkArgument(
                    !(endLine == startLine && startCharacter >= endCharacter),
                    "On the same line, start character (%s) must be greater than end character (%s)",
                    startCharacter,
                    endCharacter
            );

            return super.build();
        }
    }
}
