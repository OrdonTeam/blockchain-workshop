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
    private static final String BINARY = "6060604052341561000f57600080fd5b6108338061001e6000396000f3006060604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e4ea188811461007c57806325419e84146100f75780634534811d14610162578063a1e3e57a146101fa578063c934246114610277578063e81d4f2a146102d4575b600080fd5b341561008757600080fd5b6100e5600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061033d95505050505050565b60405190815260200160405180910390f35b341561010257600080fd5b610160600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061040495505050505050565b005b341561016d57600080fd5b610160600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650507fff0000000000000000000000000000000000000000000000000000000000000085351694602081013594506040013592506104c5915050565b341561020557600080fd5b610263600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506105b495505050505050565b604051901515815260200160405180910390f35b341561028257600080fd5b6102b86004357fff000000000000000000000000000000000000000000000000000000000000006024351660443560643561064a565b604051600160a060020a03909116815260200160405180910390f35b34156102df57600080fd5b610160600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506106f795505050505050565b60006002308585856000604051602001526040516c01000000000000000000000000600160a060020a0380871682028352858116820260148401528416026028820152603c810182805190602001908083835b602083106103af5780518252601f199092019160209182019101610390565b6001836020036101000a03801982511681845116808217855250505050505090500194505050505060206040518083038160008661646e5a03f115156103f457600080fd5b5050604051805195945050505050565b82600160a060020a031633600160a060020a031614151561042457600080fd5b600160a060020a03808416600090815260016020818152604080842094871684529390529082902090918390518082805190602001908083835b6020831061047d5780518252601f19909201916020918201910161045e565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050565b6104db6104d387878761033d565b84848461064a565b600160a060020a038781169116146104f257600080fd5b33600160a060020a031685600160a060020a031614151561051257600080fd5b600160a060020a0380871660009081526020818152604080832093891683529290528190206001918690518082805190602001908083835b602083106105695780518252601f19909201916020918201910161054a565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050505050565b600160a060020a03808416600090815260208181526040808320938616835292905281812090918390518082805190602001908083835b6020831061060a5780518252601f1990920191602091820191016105eb565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16949350505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f115156106e557600080fd5b50506020604051035195945050505050565b81600160a060020a031633600160a060020a031614151561071757600080fd5b600160a060020a0380841660009081526001602090815260408083209386168352929052819020908290518082805190602001908083835b6020831061076e5780518252601f19909201916020918201910161074f565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff1615156107b157600080fd5b600160a060020a0380841660009081526020818152604080832093861683529290528190206001918390518082805190602001908083836020831061047d5780518252601f19909201916020918201910161045e5600a165627a7a72305820ccf89a4c9905b4d58fbc574749f1dda3c9d6fcfc9a4a63e39310d148dbb320c60029";

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

    public RemoteCall<TransactionReceipt> addSignedPact(String one, String other, String pactId, byte[] v, byte[] r, byte[] s) {
        Function function = new Function(
                "addSignedPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId), 
                new org.web3j.abi.datatypes.generated.Bytes1(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
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
