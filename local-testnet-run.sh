#!/usr/bin/env bash
geth --rpc --rpcport "8000" --datadir local-testnet/data --nodiscover --rpcapi "db,eth,net,web3" --mine --etherbase 0xa4d8e9cae4d04b093aac82e6cd355b6b963fb7ff
