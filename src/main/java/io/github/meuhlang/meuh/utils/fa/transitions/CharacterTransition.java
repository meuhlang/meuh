package io.github.meuhlang.meuh.utils.fa.transitions;

import io.github.meuhlang.meuh.utils.fa.Transition;

public class CharacterTransition implements Transition {

  private final int mCodepoint;

  public CharacterTransition(final int codepoint) {
    mCodepoint = codepoint;
  }

  @Override
  public boolean accept(int codePoint) {
    return codePoint == mCodepoint;
  }

  @Override
  public String toString() {
    return Character.toString(mCodepoint);
  }
}
