#!/bin/bash
set -e
rm -r solidity-out | true
rm -r src/main/kotlin/com/elpassion/blockchain/workshop/solidity | true
for f in `ls solidity`
do
    solName=solidity/$f
    solc solidity/$f --overwrite --bin --abi --optimize -o solidity-out
    binName="solidity-out/$(basename "$f" .sol).bin"
    abiName="solidity-out/$(basename "$f" .sol).abi"
    web3j solidity generate "$binName" "$abiName" -o src/main/java -p com.elpassion.blockchain.workshop.solidity
done
