pragma solidity ^0.4.0;
contract SimplePactContract {

    mapping(address => mapping(address => mapping(address => bool))) confirmedPacts;
    mapping(address => mapping(address => mapping(address => bool))) pendingPacts;

    function SimplePactContract() public {
    }

    function addPendingPact(address one, address other, address pactId) public {
        if (msg.sender != one) return;
        pendingPacts[one][other][pactId] = true;
    }

    function confirmPact(address one, address other, address pactId) public {
        if (msg.sender != other) return;
        if (!pendingPacts[one][other][pactId]) return;
        confirmedPacts[one][other][pactId] = true;
    }
}