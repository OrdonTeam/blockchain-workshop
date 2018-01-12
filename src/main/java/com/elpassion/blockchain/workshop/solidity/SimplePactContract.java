package com.elpassion.blockchain.workshop.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
    private static final String BINARY = "6060604052341561000f57600080fd5b61043f8061001e6000396000f3006060604052600436106100565763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166325419e84811461005b578063a1e3e57a146100c6578063e81d4f2a14610143575b600080fd5b341561006657600080fd5b6100c4600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506101ac95505050505050565b005b34156100d157600080fd5b61012f600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061026d95505050505050565b604051901515815260200160405180910390f35b341561014e57600080fd5b6100c4600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061030395505050505050565b82600160a060020a031633600160a060020a03161415156101cc57600080fd5b600160a060020a03808416600090815260016020818152604080842094871684529390529082902090918390518082805190602001908083835b602083106102255780518252601f199092019160209182019101610206565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050565b600160a060020a03808416600090815260208181526040808320938616835292905281812090918390518082805190602001908083835b602083106102c35780518252601f1990920191602091820191016102a4565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16949350505050565b81600160a060020a031633600160a060020a031614151561032357600080fd5b600160a060020a0380841660009081526001602090815260408083209386168352929052819020908290518082805190602001908083835b6020831061037a5780518252601f19909201916020918201910161035b565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff1615156103bd57600080fd5b600160a060020a038084166000908152602081815260408083209386168352929052819020600191839051808280519060200190808383602083106102255780518252601f1990920191602091820191016102065600a165627a7a72305820934fbb1305e685fc9fde8892bc7c009479d3a5259a2a3e42dac1fd0eeaa52fdb0029";

    private SimplePactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SimplePactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
