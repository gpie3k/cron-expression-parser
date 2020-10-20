# cron-expression-parser

Command line application which parses a cron string and expands each field
to show the times at which it will run.

## Prerequisites

Install sdkman (recommended for installing gradle and java)
- https://sdkman.io/install

Install brew (MacOs)
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
```

Required tools:
- gradle: ```sdk i gradle 6.1.1```
- java: ```sdk i java 8.0.265.hs-adpt```
- git: ``brew install git``

## Usage

Download release package and unzip it.
Execute script from bin folder. You can also add bin folder to your PATH variable. 
E.x.:

```
cd cron-experession-parser
❯ ./bin/cron-expression-parser "*/15 0 1,15 * 1-5 /usr/bin/find"
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

## Development

Clone Repository:
```
git clone git@github.com:gpie3k/cron-expression-parser.git
```

Build application from commanline
```
gradle build
```

Distribution package is created in folder:
```
./build/distributions
```

IDE: 
- Install Intellij with JetBrains toolbox:
https://www.jetbrains.com/toolbox-app/
```
brew cask install jetbrains-toolbox
```

Main class: 
```
src/main/groovy/org.gpie3k.cron.parser.App
```

Tests are in folder
```
src/test/groovy
```

