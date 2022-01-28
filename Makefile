all: test build

clean:
	mvn clean

build:
	go build .

test:
	go test \
		-coverpkg=github.com/meuhlang/meuh/... \
		-coverprofile=coverage.out \
		./...
	go tool cover -func=coverage.out
	go tool cover -html=coverage.out -o coverage.html

mkdocs:
	docker run \
		--mount "type=bind,src=${PWD}/site,dst=/work" \
		--workdir /work \
		--rm \
		--publish 8000:8000 \
		lvjp/mkdocs:v1.2.3-3 mkdocs \
		serve \
		--dev-addr 0.0.0.0:80000

mkdocs-build:
	docker run \
		--mount "type=bind,src=${PWD}/site,dst=/work" \
		--workdir /work \
		--rm \
		lvjp/mkdocs:v1.2.3-3 mkdocs \
		build

mkdocs-validate: mkdocs-build
	docker run \
    	--rm \
    	--mount "type=bind,src=${PWD}/site/site,dst=/work/meuh,ro" \
    	--workdir /work \
    	lvjp/html-proofer:v3.19.1-0 \
    	htmlproofer \
    	--allow-hash-href \
    	--enforce-https \
    	--url-ignore '/fonts.gstatic.com/'

.PHONY: all clean build test mkdocs mkdocs-build mkdocs-validate
