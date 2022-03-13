package io.github.meuhlang.meuh.utils.fa;

import com.google.common.graph.MutableNetwork;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Utils {

  @DataProvider(name = "computeEmptyStringClosure")
  public Iterator<Object[]> provideComputeEmptyStringClosure() {
    final List<Object[]> result = new LinkedList<>();

    final Node q0 = new Node.Builder().build();
    final Node q1 = new Node.Builder().build();
    final Node q2 = new Node.Builder().build();
    final Node q3 = new Node.Builder().build();
    final Node q4 = new Node.Builder().build();

    {
      final var graph = Nfa.newGraph();
      graph.addNode(q0);


    }

    // final MutableNetwork<Node, Transition>
    return result.iterator();
  }

  @Test(dataProvider = "computeEmptyStringClosure")
  public void testComputeEmptyStringClosure() {
    final MutableNetwork<Node, Transition> graph = Nfa.newGraph();
  }
}
