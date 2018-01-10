# Blockchain Workshop

## Environment

### Solidity Compiler and Geth

Steps to install solc on Mac. Yes, it takes time. Yes, a lot of time.
```bash
brew update
brew upgrade
brew tap ethereum/ethereum
brew install ethereum
brew install solidity #It took around 40 minutes
brew linkapps solidity
```
For other guides refer to [Installing solidity](http://solidity.readthedocs.io/en/develop/installing-solidity.html)
and [Go Ethereum](https://github.com/ethereum/go-ethereum/wiki/Installation-Instructions-for-Mac)

Verify installation with `solc --version` and `geth version`.

### Web3j

Steps to install web3j on Mac.
```bash
brew tap web3j/web3j
brew install web3j
```
For more see [Web3j Commend Line](https://docs.web3j.io/command_line.html).

Verify installation with `web3j version`.

### IntelliJ

Get [IntelliJ](https://www.jetbrains.com/idea/download/)

Setup IntelliJ and then go to `Plugins -> Browse repositories -> Intellij-Solidity`

## Working with project

### Solidity 

Solidity contracts are in solidity directory.
We can recompile all of them and recreate java classes with `./regenerate-solidity.sh`

### Tests

To run test fast we recommend ganache.
```bash
npm install -g ganache-cli
```