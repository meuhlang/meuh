package io.github.meuhlang.meuh.core;

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

import java.util.List;

public class DummyData {

  private List<String> mData;

  public void setData(final List<String> data) {
    if (data != null) {
      mData = List.copyOf(data);
    } else {
      mData = null;
    }
  }

  public List<String> getData() {
    if (mData != null) {
      return List.copyOf(mData);
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return new StringBuilder("DummyData{data=")
        .append(mData)
        .append('}')
        .toString();
  }

}
