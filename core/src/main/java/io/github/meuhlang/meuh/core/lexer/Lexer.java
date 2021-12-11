package io.github.meuhlang.meuh.core.lexer;

import com.google.common.base.Preconditions;
import io.github.meuhlang.meuh.core.lexer.Token.Type;
import java.io.IOException;
import java.util.Arrays;

public class Lexer {

  private final byte[] mInput;
  private int mOffset;

  public Lexer(final byte[] file) {
    Preconditions.checkArgument(file != null);
    mInput = Arrays.copyOf(file, file.length);
  }

  public Token produce() {
    if (mOffset >= mInput.length) {
      return new Token(Type.EOF, 0, null);
    }

    int i;
    for(i = mOffset; i < mInput.length; i++) {

    }
    while(mOffset < mInput.length) {

    }


    return null;
  }
}
