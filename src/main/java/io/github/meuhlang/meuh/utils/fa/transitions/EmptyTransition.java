package io.github.meuhlang.meuh.utils.fa.transitions;

import io.github.meuhlang.meuh.utils.fa.Transition;

public class EmptyTransition implements Transition {

  @Override
  public boolean accept(int codePoint) {
    return codePoint == Transition.EMPTY_STRING;
  }

  @Override
  public String toString() {
    return "ε";
  }
}
