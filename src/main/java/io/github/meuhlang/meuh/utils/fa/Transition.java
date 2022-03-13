package io.github.meuhlang.meuh.utils.fa;

@FunctionalInterface
public interface Transition {

  int EMPTY_STRING = -1;

  /**
   * Return all transitions reachable with the given code point.
   *
   * <p>EMPTY_STRING will be interpreted as an empty string.
   *
   * @param codePoint Code point to check
   * @return target node for the given code point
   * @see #EMPTY_STRING
   */
  boolean accept(int codePoint);
}
