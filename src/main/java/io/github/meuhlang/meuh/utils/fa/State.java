package io.github.meuhlang.meuh.utils.fa;

import com.google.common.collect.ImmutableSet;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface State {

  ImmutableSet<Node> nodes();

  class Builder extends State_Builder {}
}
