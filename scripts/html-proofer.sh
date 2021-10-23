#!/usr/bin/env sh

set -o errexit
set -o nounset

_htmlproofer() {
  docker run \
    --rm \
    --mount "type=bind,src=${PWD}/site/site,dst=/work/meuh,ro" \
    --workdir /work \
    lvjp/html-proofer:v3.19.1-0 \
    htmlproofer \
    "$@"
}

main() {
  cd "$(dirname "$0")/.."

  if [ ! -d ./site/site ]; then
    echo "Site is not generated. Folder ./site/site not found." >&2
    exit 1
  fi

  _htmlproofer . \
    --allow-hash-href \
    --enforce-https \
    --url-ignore '/fonts.gstatic.com/'
}

main
