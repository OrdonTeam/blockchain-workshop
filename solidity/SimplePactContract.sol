pragma solidity ^0.4.0;


contract SimplePactContract {

    event PactConfirmed(address one, address other, string pactId);

    mapping (address => mapping (address => mapping (string => bool))) confirmedPacts;

    function addFullySignedPact(address one, address other, string pactId, byte oneV, bytes32 oneR, bytes32 oneS, byte otherV, bytes32 otherR, bytes32 otherS) {
        require(one == recoverAddress(pactHash256(one, other, pactId), oneV, oneR, oneS));
        require(other == recoverAddress(pactHash256(one, other, pactId), otherV, otherR, otherS));
        confirmedPacts[one][other][pactId] = true;
        PactConfirmed(one, other, pactId);
    }

    function isConfirmed(address one, address other, string pactId) constant public returns (bool) {
        return confirmedPacts[one][other][pactId];
    }

    function pactHash256(address one, address other, string pactId) constant public returns (bytes32) {
        return sha256(this, one, other, pactId);
    }

    function recoverAddress(bytes32 hash, byte v, bytes32 r, bytes32 s) pure private returns (address) {
        return ecrecover(keccak256(hash), uint8(v), r, s);
    }
}