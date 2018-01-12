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
public final class SimplePactContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6106a18061001e6000396000f30060606040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e4ea188811461007157806325419e84146100ec578063a1e3e57a14610157578063c9342461146101d4578063e81d4f2a14610231575b600080fd5b341561007c57600080fd5b6100da600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061029a95505050505050565b60405190815260200160405180910390f35b34156100f757600080fd5b610155600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061036195505050505050565b005b341561016257600080fd5b6101c0600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061042295505050505050565b604051901515815260200160405180910390f35b34156101df57600080fd5b6102156004357fff00000000000000000000000000000000000000000000000000000000000000602435166044356064356104b8565b604051600160a060020a03909116815260200160405180910390f35b341561023c57600080fd5b610155600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061056595505050505050565b60006002308585856000604051602001526040516c01000000000000000000000000600160a060020a0380871682028352858116820260148401528416026028820152603c810182805190602001908083835b6020831061030c5780518252601f1990920191602091820191016102ed565b6001836020036101000a03801982511681845116808217855250505050505090500194505050505060206040518083038160008661646e5a03f1151561035157600080fd5b5050604051805195945050505050565b82600160a060020a031633600160a060020a031614151561038157600080fd5b600160a060020a03808416600090815260016020818152604080842094871684529390529082902090918390518082805190602001908083835b602083106103da5780518252601f1990920191602091820191016103bb565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050565b600160a060020a03808416600090815260208181526040808320938616835292905281812090918390518082805190602001908083835b602083106104785780518252601f199092019160209182019101610459565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16949350505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f1151561055357600080fd5b50506020604051035195945050505050565b81600160a060020a031633600160a060020a031614151561058557600080fd5b600160a060020a0380841660009081526001602090815260408083209386168352929052819020908290518082805190602001908083835b602083106105dc5780518252601f1990920191602091820191016105bd565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16151561061f57600080fd5b600160a060020a038084166000908152602081815260408083209386168352929052819020600191839051808280519060200190808383602083106103da5780518252601f1990920191602091820191016103bb5600a165627a7a72305820b2253e2567b6bb62adbb7a233f6f28a82862d0011bfb09106ea58e83e49191120029";

    private SimplePactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SimplePactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<byte[]> pactHash256(String one, String other, String pactId) {
        Function function = new Function("pactHash256", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> addPendingPact(String one, String other, String pactId) {
        Function function = new Function(
                "addPendingPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isConfirmed(String one, String other, String pactId) {
        Function function = new Function("isConfirmed", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteCall<TransactionReceipt> confirmPact(String one, String other, String pactId) {
        Function function = new Function(
                "confirmPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<SimplePactContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimplePactContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SimplePactContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimplePactContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static SimplePactContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimplePactContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SimplePactContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimplePactContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
