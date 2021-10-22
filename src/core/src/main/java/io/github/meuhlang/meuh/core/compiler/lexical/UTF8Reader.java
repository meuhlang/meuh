package io.github.meuhlang.meuh.core.compiler.lexical;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class UTF8Reader {
    private final InputStream input;
    private final byte[] buffer = new byte[4];

    public UTF8Reader(final InputStream input) {
        Preconditions.checkNotNull(input);
        Preconditions.checkArgument(input.markSupported(), "input must support mark");

        this.input = input;
    }

    public String readCharacter() throws IOException {
        final int length = nextCharacterLength();

        final var read = input.readNBytes(buffer, 0, length);
        if (read <= 0) {
            return null;
        }

        if (read != length) {
            throw new IOException();
        }

        return new String(buffer, 0, length, StandardCharsets.UTF_8);
    }

    private int nextCharacterLength() throws IOException {
        input.mark(1);

        final var read = input.read();
        if (read < 0) {
            return 0;
        }

        input.reset();

        if ((read & 0x80) == 0x00) {
            return 1;
        } else if ((read & 0xE0) == 0xC0) {
            return 2;
        } else if ((read & 0xF0) == 0xE0) {
            return 3;
        } else if ((read & 0xF8) == 0xF0) {
            return 4;
        } else {
            throw new IOException("Not supported encoding: " + read);
        }
    }
}
