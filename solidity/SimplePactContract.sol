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
}