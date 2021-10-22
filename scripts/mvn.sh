#!/usr/bin/env bash

# Copyright (C) 2021 VERDOÏA Laurent
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program. If not, see <https://www.gnu.org/licenses/>.

set -o errexit
set -o nounset
set -o pipefail

cd "$(realpath "$(dirname "$0")/..")"

exec podman run \
  --tty \
  --interactive \
  --env "MAVEN_OPTS=-Dmaven.repo.local=/work/.cache/.m2/repository" \
  --mount "type=bind,src=${PWD},dst=/work,Z" \
  --workdir /work/src \
  maven:3.8.1-jdk-11 mvn "$@"
