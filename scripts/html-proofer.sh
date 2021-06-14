#!/usr/bin/env sh

set -o errexit
set -o nounset

_container() {
  if comand -v docker > /dev/null 2>&1; then
    docker "$@"
  elif command -v podman > /dev/null 2>&1; then
    podman "$@"
  else
    echo "No linux containers implementations found." >&2
    return 1
  fi
}

_build() {
  _container build \
    --tag local/meuh/html-proofer:latest \
    - < ./scripts/html-proofer.Dockerfile
}

_htmlproofer() {
  _container run \
    --rm \
    --mount "type=bind,src=${PWD}/site/site,dst=/work/meuh,ro,z" \
    --workdir /work \
    local/meuh/html-proofer:latest \
    "$@"
}

main() {
  cd "$(dirname "$0")/.."

  if [ ! -d ./site/site ]; then
    echo "Site is not generated. Folder ./site/site not found." >&2
    exit 1
  fi

  _build

  _htmlproofer . \
    --allow-hash-href \
    --enforce-https \
    --url-ignore '/fonts.gstatic.com/'
}

main
