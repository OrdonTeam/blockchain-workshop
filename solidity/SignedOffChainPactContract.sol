pragma solidity ^0.4.0;


contract SignedOffChainPactContract {

    mapping (address => mapping (address => mapping (address => bool))) public confirmedPacts;

    mapping (address => mapping (address => mapping (address => bool))) public pendingPacts;

    function addOwnedPendingPact(address one, address other, address pactId) public {
        require(one == msg.sender);
        addPendingPact(one, other, pactId);
    }

    function addSignedPendingPact(address one, address other, address pactId, uint nonce, byte v, bytes32 r, bytes32 s) public {
        require(one == recoverAddress(pactHash256(one, other, pactId, nonce), v, r, s));
        addPendingPact(one, other, pactId);
    }

    function addPendingPact(address one, address other, address pactId) private {
        pendingPacts[one][other][pactId] = true;
    }

    function confirmOwnedPact(address one, address other, address pactId) public {
        require(other == msg.sender);
        confirmPact(one, other, pactId);
    }

    function confirmSignedPact(address one, address other, address pactId, uint nonce, byte v, bytes32 r, bytes32 s) public {
        require(other == recoverAddress(pactHash256(one, other, pactId, nonce), v, r, s));
        confirmPact(one, other, pactId);
    }

    function confirmPact(address one, address other, address pactId) private {
        require(pendingPacts[one][other][pactId]);
        confirmedPacts[one][other][pactId] = true;
    }

    function uploadPact(address one, address other, address pactId, uint otherNonce, byte otherV, bytes32 otherR, bytes32 otherS, uint oneNonce, byte oneV, bytes32 oneR, bytes32 oneS) public {
        require(other == recoverAddress(pactHash256(one, other, pactId, otherNonce), otherV, otherR, otherS));
        require(one == recoverAddress(pactHash256(one, other, pactId, oneNonce), oneV, oneR, oneS));
        confirmedPacts[one][other][pactId] = true;
    }

    function pactHash256(address one, address other, address pactId, uint nonce) constant public returns (bytes32) {
        return sha256(this, one, other, pactId, nonce);
    }

    function recoverAddress(bytes32 hash, byte v, bytes32 r, bytes32 s) pure public returns (address) {
        return ecrecover(keccak256(hash), uint8(v), r, s);
    }
}