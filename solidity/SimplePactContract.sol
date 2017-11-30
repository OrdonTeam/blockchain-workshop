pragma solidity ^0.4.0;
contract SimplePactContract {

    mapping(address => mapping(address => mapping(address => bool))) public confirmedPacts;
    mapping(address => mapping(address => mapping(address => bool))) public pendingPacts;

    function SimplePactContract() public {
    }

    function addPendingPact(address one, address other, address pactId) public {
        require(one == msg.sender);
        pendingPacts[one][other][pactId] = true;
    }

    function confirmPact(address one, address other, address pactId) public {
        require(other == msg.sender);
        require(pendingPacts[one][other][pactId]);
        confirmedPacts[one][other][pactId] = true;
    }
}