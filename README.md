# cron-expression-parser

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
./bin/cron-expression-parser "0 0 1 1 1 /cmd"
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

