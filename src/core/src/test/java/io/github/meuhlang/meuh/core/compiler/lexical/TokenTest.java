package io.github.meuhlang.meuh.core.compiler.lexical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest {
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = ".*greater than end line.*"
    )
    public void testBadLines() {
        new Token.Builder()
                .startLine(42)
                .endLine(24)
                .startCharacter(24)
                .endCharacter(42)
                .build();
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
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

    @Test
    public void testNominal() {
        new Token.Builder()
                .startLine(0)
                .endLine(100)
                .startCharacter(42)
                .endCharacter(24)
                .value("dummy value")
                .type(TokenType.KEYWORD)
                .build();
    }

    @Test
    public void testDummy() {
        var str = new String("€");
        Assert.assertEquals(str.getBytes().length, 3);
    }
}