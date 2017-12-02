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
    private static final String BINARY = "6060604052341561000f57600080fd5b6102998061001e6000396000f3006060604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632ceed05e8114610066578063ea6bf449146100a5578063ee58b6f9146100d0578063faf75720146100fd575b600080fd5b341561007157600080fd5b610091600160a060020a0360043581169060243581169060443516610128565b604051901515815260200160405180910390f35b34156100b057600080fd5b610091600160a060020a036004358116906024358116906044351661014e565b34156100db57600080fd5b6100fb600160a060020a0360043581169060243581169060443516610173565b005b341561010857600080fd5b6100fb600160a060020a036004358116906024358116906044351661020d565b600160209081526000938452604080852082529284528284209052825290205460ff1681565b6000602081815293815260408082208552928152828120909352825290205460ff1681565b33600160a060020a031682600160a060020a031614151561019357600080fd5b600160a060020a038084166000908152600160209081526040808320868516845282528083209385168352929052205460ff1615156101d157600080fd5b600160a060020a03928316600090815260208181526040808320948616835293815283822092909416815292529020805460ff19166001179055565b33600160a060020a031683600160a060020a031614151561022d57600080fd5b600160a060020a0392831660009081526001602081815260408084209587168452948152848320939095168252919093529120805460ff191690911790555600a165627a7a72305820add1dc18b942576c65052e95422bea99a2d685f7ee493c88b72405e94474cc030029";

    private SimplePactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SimplePactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public RemoteCall<Boolean> confirmedPacts(String param0, String param1, String param2) {
        Function function = new Function("confirmedPacts", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.Address(param2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> confirmPact(String one, String other, String pactId) {
        Function function = new Function(
                "confirmPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addPendingPact(String one, String other, String pactId) {
        Function function = new Function(
                "addPendingPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Address(pactId)), 
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
