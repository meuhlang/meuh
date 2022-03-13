package io.github.meuhlang.meuh.utils.fa;

import com.google.common.base.Preconditions;
import com.google.common.graph.Network;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class Utils {

  private Utils() {
    throw new UnsupportedOperationException();
  }

  public static Set<Node> computeEmptyStringClosure(
      final Network<Node, Transition> graph, final Node initial) {
    Preconditions.checkNotNull(graph);
    Preconditions.checkArgument(graph.nodes().contains(initial));

    final Set<Node> visited = new LinkedHashSet<>();
    final List<Node> toVisit = new LinkedList<>();
    toVisit.add(initial);

    while (!toVisit.isEmpty()) {
      final Node from = toVisit.remove(0);
      for (final Node to : graph.successors(from)) {
        final boolean acceptEmptyString =
            graph.edgesConnecting(from, to).stream()
                .anyMatch(t -> t.accept(Transition.EMPTY_STRING));
        if (acceptEmptyString) {
          toVisit.add(to);
        }
      }
    }

    return visited;
  }
}
