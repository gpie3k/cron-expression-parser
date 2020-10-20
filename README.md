# cron-expression-parser

## Prerequisites

Install sdkman (recommended for installing gradle and java)
- https://sdkman.io/install

Required tools:
- gradle: 6.1.1
- java: 8.0.265.hs-adpt
- git

## Usage

Download release package and unzip it.
Execute script from bin folder. You can also add bin folder to your PATH variable. 
E.x.:

```
cd cron-experession-parser
./bin/cron-expression-parser "0 0 1 1 1 /cmd"
```

## Development

Clone Repository:
```
git clone git@github.com:gpie3k/cron-expression-parser.git
```

Build tools
```
gradle build
```

Distribution package is created in folder:
```
./build/distributions
```

Main class: 
```
src/main/groovy/org.gpie3k.cron.parser.App
```

Tests are in folder
```
./src/test/groovy
```

