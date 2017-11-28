#!/usr/bin/env bash
rm -r local-testnet/data
geth --datadir=local-testnet/data init local-testnet/custom-genesis.json