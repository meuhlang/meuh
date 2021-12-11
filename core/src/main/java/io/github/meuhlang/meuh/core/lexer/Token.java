package io.github.meuhlang.meuh.core.lexer;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Objects;

public class Token {

  public enum Type {
    DATA,
    LINE_ENDING,
    EOF
  }

  private final Type mType;
  private final int mOffset;
  private final byte[] mValue;

  public Token(final Type type, final int offset, final byte[] value) {
    if (Type.EOF.equals(type)) {
      mType = type;
      mOffset = 0;
      mValue = new byte[0];
    } else {
      mType = Preconditions.checkNotNull(type);
      Preconditions.checkArgument(offset >= 0);
      Preconditions.checkArgument(value != null && value.length > 0);
      mOffset = offset;
      mValue = value;
    }
  }

  public Type getType() {
    return mType;
  }

  public int getOffset() {
    return mOffset;
  }

  public byte[] getValue() {
    return mValue;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Token token = (Token) o;
    return mOffset == token.mOffset && mType == token.mType && Arrays.equals(mValue,
        token.mValue);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(mType, mOffset);
    result = 31 * result + Arrays.hashCode(mValue);
    return result;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", mType)
        .add("offset", mOffset)
        .add("value", mValue)
        .toString();
  }
}
