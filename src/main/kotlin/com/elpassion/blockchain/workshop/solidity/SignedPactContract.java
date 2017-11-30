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
 * <p>Generated with web3j version 3.1.1.
 */
public final class SignedPactContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61060e8061001e6000396000f30060606040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632ceed05e81146100925780637cdd641d146100d1578063921f57c5146101115780639e7961b31461016c578063c934246114610197578063dee1b774146101f4578063e27cf0e01461024d578063ea6bf44914610278575b600080fd5b341561009d57600080fd5b6100bd600160a060020a03600435811690602435811690604435166102a3565b604051901515815260200160405180910390f35b34156100dc57600080fd5b6100ff600160a060020a03600435811690602435811690604435166064356102c9565b60405190815260200160405180910390f35b341561011c57600080fd5b61016a600160a060020a03600435811690602435811690604435166064357fff000000000000000000000000000000000000000000000000000000000000006084351660a43560c435610352565b005b341561017757600080fd5b61016a600160a060020a03600435811690602435811690604435166103c1565b34156101a257600080fd5b6101d86004357fff00000000000000000000000000000000000000000000000000000000000000602435166044356064356103f1565b604051600160a060020a03909116815260200160405180910390f35b34156101ff57600080fd5b61016a600160a060020a03600435811690602435811690604435166064357fff000000000000000000000000000000000000000000000000000000000000006084351660a43560c43561049e565b341561025857600080fd5b61016a600160a060020a03600435811690602435811690604435166104d8565b341561028357600080fd5b6100bd600160a060020a0360043581169060243581169060443516610503565b600160209081526000938452604080852082529284528284209052825290205460ff1681565b6000600230868686866000604051602001526040516c01000000000000000000000000600160a060020a039687168102825294861685026014820152928516840260288401529316909102603c820152605081019190915260700160206040518083038160008661646e5a03f1151561034157600080fd5b505060405180519695505050505050565b610369610361888888886102c9565b8484846103f1565b600160a060020a0388811691161461038057600080fd5b505050600160a060020a0393841660009081526020818152604080832095871683529481528482209390951681529190935220805460ff1916600117905550565b33600160a060020a031683600160a060020a03161415156103e157600080fd5b6103ec838383610528565b505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f1151561048c57600080fd5b50506020604051035195945050505050565b6104ad610361888888886102c9565b600160a060020a038781169116146104c457600080fd5b6104cf878787610568565b50505050505050565b33600160a060020a031682600160a060020a03161415156104f857600080fd5b6103ec838383610568565b6000602081815293815260408082208552928152828120909352825290205460ff1681565b600160a060020a0392831660009081526001602081815260408084209587168452948152848320939095168252919093529120805460ff19169091179055565b600160a060020a038084166000908152600160209081526040808320868516845282528083209385168352929052205460ff1615156105a657600080fd5b600160a060020a03928316600090815260208181526040808320948616835293815283822092909416815292529020805460ff191660011790555600a165627a7a72305820c7f8dcbf696abde701eee331a2a6a42cf236cfdf5395ee011b844ce11db1d61b0029";

    private SignedPactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SignedPactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public static RemoteCall<SignedPactContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedPactContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignedPactContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedPactContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static SignedPactContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedPactContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SignedPactContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedPactContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
