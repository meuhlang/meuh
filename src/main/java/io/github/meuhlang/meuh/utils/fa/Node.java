package io.github.meuhlang.meuh.utils.fa;

/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

import java.util.UUID;
import org.inferred.freebuilder.FreeBuilder;
import org.inferred.freebuilder.IgnoredByEquals;

@FreeBuilder
public interface Node {

  UUID id();

  @IgnoredByEquals
  boolean isTerminal();

  class Builder extends Node_Builder {
    public Builder() {
      id(UUID.randomUUID());
      isTerminal(false);
    }
  }
}
