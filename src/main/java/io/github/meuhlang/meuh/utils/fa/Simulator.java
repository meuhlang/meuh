package io.github.meuhlang.meuh.utils.fa;

import com.google.common.base.Preconditions;
import java.util.Set;

public class Simulator {

  private final Nfa mNfa;

  private Set<Node> mState;

  public Simulator(final Nfa nfa) {
    mNfa = Preconditions.checkNotNull(nfa);
  }

  public void initialize() {}

  public boolean isTerminal() {
    return mState.stream().anyMatch(Node::isTerminal);
  }

  public boolean canAcceptMore() {
    mNfa.getInitial();
    throw new UnsupportedOperationException();
  }
}
