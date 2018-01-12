pragma solidity ^0.4.0;


contract SimplePactContract {

    mapping (address => mapping (address => mapping (string => bool))) confirmedPacts;

    mapping (address => mapping (address => mapping (string => bool))) pendingPacts;

    function SimplePactContract() public {

    }

    function addPendingPact(address one, address other, string pactId) public {
        require(msg.sender == one);
        pendingPacts[one][other][pactId] = true;
    }

    function confirmPact(address one, address other, string pactId) public {
        require(msg.sender == other);
        require(pendingPacts[one][other][pactId]);
        confirmedPacts[one][other][pactId] = true;
    }

    function isConfirmed(address one, address other, string pactId) constant public returns (bool) {
        return confirmedPacts[one][other][pactId];
    }

    function addSignedPact(address one, address other, string pactId, byte v, bytes32 r, bytes32 s) public {
        require(one == recoverAddress(pactHash256(one, other, pactId), v, r, s));
        require(other == msg.sender);
        confirmedPacts[one][other][pactId] = true;
    }

    function pactHash256(address one, address other, string pactId) constant public returns (bytes32) {
        return sha256(this, one, other, pactId);
    }

    function recoverAddress(bytes32 hash, byte v, bytes32 r, bytes32 s) pure public returns (address) {
        return ecrecover(keccak256(hash), uint8(v), r, s);
    }
}