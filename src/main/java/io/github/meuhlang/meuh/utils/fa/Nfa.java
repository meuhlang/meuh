package io.github.meuhlang.meuh.utils.fa;

import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.Network;
import com.google.common.graph.NetworkBuilder;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Nfa {

  private Network<Node, Transition> mGraph;
  private Node mInitial;

  public Nfa(final Network<Node, Transition> graph, final Node initial) {
    mGraph = Preconditions.checkNotNull(graph);

    Preconditions.checkState(graph.nodes().contains(initial));
    mInitial = initial;
  }

  public Network<Node, Transition> getGraph() {
    return mGraph;
  }

  public Node getInitial() {
    return mInitial;
  }

  public Set<Node> computeClosure(final Node initial) {
    Preconditions.checkArgument(mGraph.nodes().contains(initial));

    final Set<Node> visited = new LinkedHashSet<>();
    final List<Node> toVisit = new LinkedList<>();
    toVisit.add(initial);

    while (!toVisit.isEmpty()) {
      final Node from = toVisit.remove(0);
      for (final Node to : mGraph.successors(from)) {
        final boolean acceptEmptyString =
            mGraph.edgesConnecting(from, to).stream()
                .anyMatch(t -> t.accept(Transition.EMPTY_STRING));
        if (acceptEmptyString) {
          toVisit.add(to);
        }
      }
    }

    return visited;
  }

  public static MutableNetwork<Node, Transition> newGraph() {
    return NetworkBuilder.directed()
        .allowsParallelEdges(true)
        .allowsSelfLoops(true)
        .nodeOrder(ElementOrder.unordered())
        .edgeOrder(ElementOrder.unordered())
        .build();
  }
}
