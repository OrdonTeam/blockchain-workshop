# Blockchain Workshop

## Environment

### Solidity Compiler

Steps to install solc on Mac. Yes, it takes time. Yes, a lot of time.
```bash
brew update
brew upgrade
brew tap ethereum/ethereum
brew install solidity #It took around 40 minutes
brew linkapps solidity
```
For other guides refer to [Installing solidity](http://solidity.readthedocs.io/en/develop/installing-solidity.html)

Verify installation with `solc --version`.

### Web3j

Steps to install web3j on Mac.
```bash
brew tap web3j/web3j
brew install web3j
```
For more see [Web3j Commend Line](https://docs.web3j.io/command_line.html).

### IntelliJ

Get [IntelliJ](https://www.jetbrains.com/idea/download/)

Setup IntelliJ and then go to `Plugins -> Browse repositories -> Intellij-Solidity`