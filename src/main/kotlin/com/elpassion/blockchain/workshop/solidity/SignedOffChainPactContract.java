package com.elpassion.blockchain.workshop.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class SignedOffChainPactContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61068c8061001e6000396000f3006060604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632ceed05e811461009d57806374ecda07146100dc5780637cdd641d14610134578063921f57c5146101745780639e7961b3146101b5578063c9342461146101e0578063dee1b77414610225578063e27cf0e014610266578063ea6bf44914610291575b600080fd5b34156100a857600080fd5b6100c8600160a060020a03600435811690602435811690604435166102bc565b604051901515815260200160405180910390f35b34156100e757600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a031960843581169060a4359060c4359060e43590610104351661012435610144356102e2565b005b341561013f57600080fd5b610162600160a060020a0360043581169060243581169060443516606435610385565b60405190815260200160405180910390f35b341561017f57600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a03196084351660a43560c43561040e565b34156101c057600080fd5b610132600160a060020a0360043581169060243581169060443516610448565b34156101eb57600080fd5b610209600435600160f860020a031960243516604435606435610478565b604051600160a060020a03909116815260200160405180910390f35b341561023057600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a03196084351660a43560c435610525565b341561027157600080fd5b610132600160a060020a0360043581169060243581169060443516610556565b341561029c57600080fd5b6100c8600160a060020a0360043581169060243581169060443516610581565b600160209081526000938452604080852082529284528284209052825290205460ff1681565b6102f96102f18c8c8c8c610385565b888888610478565b600160a060020a038b811691161461031057600080fd5b61032761031f8c8c8c88610385565b848484610478565b600160a060020a038c811691161461033e57600080fd5b505050600160a060020a03978816600090815260208181526040808320998b16835298815288822097909916815295909752505050919020805460ff191660011790555050565b6000600230868686866000604051602001526040516c01000000000000000000000000600160a060020a039687168102825294861685026014820152928516840260288401529316909102603c820152605081019190915260700160206040518083038160008661646e5a03f115156103fd57600080fd5b505060405180519695505050505050565b61041d61031f88888888610385565b600160a060020a0388811691161461043457600080fd5b61043f8787876105a6565b50505050505050565b33600160a060020a031683600160a060020a031614151561046857600080fd5b6104738383836105a6565b505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f1151561051357600080fd5b50506020604051035195945050505050565b61053461031f88888888610385565b600160a060020a0387811691161461054b57600080fd5b61043f8787876105e6565b33600160a060020a031682600160a060020a031614151561057657600080fd5b6104738383836105e6565b6000602081815293815260408082208552928152828120909352825290205460ff1681565b600160a060020a0392831660009081526001602081815260408084209587168452948152848320939095168252919093529120805460ff19169091179055565b600160a060020a038084166000908152600160209081526040808320868516845282528083209385168352929052205460ff16151561062457600080fd5b600160a060020a03928316600090815260208181526040808320948616835293815283822092909416815292529020805460ff191660011790555600a165627a7a72305820b37defc1fe22c479f57133950f7f091aa48a53083d40eb6834cecf7fd7071c450029";

    protected SignedOffChainPactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SignedOffChainPactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> pendingPacts(String param0, String param1, String param2) {
        Function function = new Function("pendingPacts", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.Address(param2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> uploadPact(String one, String other, String pactId, BigInteger otherNonce, byte[] otherV, byte[] otherR, byte[] otherS, BigInteger oneNonce, byte[] oneV, byte[] oneR, byte[] oneS) {
        Function function = new Function(
                "uploadPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId), 
                new org.web3j.abi.datatypes.generated.Uint256(otherNonce), 
                new org.web3j.abi.datatypes.generated.Bytes1(otherV), 
                new org.web3j.abi.datatypes.generated.Bytes32(otherR), 
                new org.web3j.abi.datatypes.generated.Bytes32(otherS), 
                new org.web3j.abi.datatypes.generated.Uint256(oneNonce), 
                new org.web3j.abi.datatypes.generated.Bytes1(oneV), 
                new org.web3j.abi.datatypes.generated.Bytes32(oneR), 
                new org.web3j.abi.datatypes.generated.Bytes32(oneS)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> pactHash256(String one, String other, String pactId, BigInteger nonce) {
        Function function = new Function("pactHash256", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> addSignedPendingPact(String one, String other, String pactId, BigInteger nonce, byte[] v, byte[] r, byte[] s) {
        Function function = new Function(
                "addSignedPendingPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.generated.Bytes1(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addOwnedPendingPact(String one, String other, String pactId) {
        Function function = new Function(
                "addOwnedPendingPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> recoverAddress(byte[] hash, byte[] v, byte[] r, byte[] s) {
        Function function = new Function("recoverAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.generated.Bytes1(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> confirmSignedPact(String one, String other, String pactId, BigInteger nonce, byte[] v, byte[] r, byte[] s) {
        Function function = new Function(
                "confirmSignedPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.generated.Bytes1(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> confirmOwnedPact(String one, String other, String pactId) {
        Function function = new Function(
                "confirmOwnedPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> confirmedPacts(String param0, String param1, String param2) {
        Function function = new Function("confirmedPacts", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.Address(param2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<SignedOffChainPactContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedOffChainPactContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignedOffChainPactContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedOffChainPactContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static SignedOffChainPactContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedOffChainPactContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SignedOffChainPactContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedOffChainPactContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
