#!/bin/bash
set -e
rm -r solidity-out
rm -r src/main/kotlin/com/elpassion/blockchain/workshop/solidity
for f in `ls solidity`
do
    solName=solidity/$f
    solc solidity/$f --overwrite --bin --abi --optimize -o solidity-out
    binName="solidity-out/$(basename "$f" .sol).bin"
    abiName="solidity-out/$(basename "$f" .sol).abi"
    web3j solidity generate "$binName" "$abiName" -o src/main/kotlin -p com.elpassion.blockchain.workshop.solidity
done

for f in `ls solidity-out`
do
    if [[ "$f" == *.bin ]] ; then
        binName="solidity-out/$f"
        abiName="solidity-out/$(basename "$f" .bin).abi"
        web3j solidity generate "$binName" "$abiName" -o src/main/kotlin -p com.elpassion.blockchain.workshop.solidity
    fi
done