package io.github.meuhlang.meuh.core.compiler.lexical;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UTF8ReaderTest {
    @Test
    public void testEmpty() throws IOException {
        final var input = new ByteArrayInputStream(new byte[0]);
        final var reader = new UTF8Reader(input);
        final var read = reader.readCharacter();
        Assert.assertNull(read);
        Assert.assertEquals(input.available(), 0);
    }

    @DataProvider(name = "nominal")
    public Object[][] provideNominal() {
        return new Object[][]{
                new Object[]{new byte[]{0x41}, "A"},
                new Object[]{new byte[]{(byte)0xC3, (byte)0xA9}, "é"},
                new Object[]{new byte[]{(byte)0xE2, (byte)0x82,(byte)0xAC}, "€"},
                new Object[]{new byte[]{(byte)0xF0, (byte)0x9D, (byte)0x84, (byte)0x9E}, "\uD834\uDD1E"},
        };
    }

    @Test(dataProvider = "nominal")
    public void testNominal(final byte[] input, final String output) throws IOException {
        final var stream = new ByteArrayInputStream(input);
        final var reader = new UTF8Reader(stream);

        Assert.assertEquals(reader.readCharacter(), output);
        Assert.assertEquals(stream.available(), 0);
    }
}
