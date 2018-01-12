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
    private static final String BINARY = "6060604052341561000f57600080fd5b6109e18061001e6000396000f3006060604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e4ea188811461008757806325419e84146101025780634534811d1461016d578063929d898f14610205578063a1e3e57a146102b1578063c93424611461032e578063e81d4f2a1461038b575b600080fd5b341561009257600080fd5b6100f0600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506103f495505050505050565b60405190815260200160405180910390f35b341561010d57600080fd5b61016b600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506104bb95505050505050565b005b341561017857600080fd5b61016b600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650507fff00000000000000000000000000000000000000000000000000000000000000853516946020810135945060400135925061057c915050565b341561021057600080fd5b61016b600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650507fff0000000000000000000000000000000000000000000000000000000000000085358116956020810135955060408101359450606081013590911692506080810135915060a0013561066b565b34156102bc57600080fd5b61031a600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061076295505050505050565b604051901515815260200160405180910390f35b341561033957600080fd5b61036f6004357fff00000000000000000000000000000000000000000000000000000000000000602435166044356064356107f8565b604051600160a060020a03909116815260200160405180910390f35b341561039657600080fd5b61016b600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506108a595505050505050565b60006002308585856000604051602001526040516c01000000000000000000000000600160a060020a0380871682028352858116820260148401528416026028820152603c810182805190602001908083835b602083106104665780518252601f199092019160209182019101610447565b6001836020036101000a03801982511681845116808217855250505050505090500194505050505060206040518083038160008661646e5a03f115156104ab57600080fd5b5050604051805195945050505050565b82600160a060020a031633600160a060020a03161415156104db57600080fd5b600160a060020a03808416600090815260016020818152604080842094871684529390529082902090918390518082805190602001908083835b602083106105345780518252601f199092019160209182019101610515565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050565b61059261058a8787876103f4565b8484846107f8565b600160a060020a038781169116146105a957600080fd5b33600160a060020a031685600160a060020a03161415156105c957600080fd5b600160a060020a0380871660009081526020818152604080832093891683529290528190206001918690518082805190602001908083835b602083106106205780518252601f199092019160209182019101610601565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050505050565b6106816106798a8a8a6103f4565b8787876107f8565b600160a060020a038a811691161461069857600080fd5b6106a661058a8a8a8a6103f4565b600160a060020a038981169116146106bd57600080fd5b600160a060020a03808a16600090815260208181526040808320938c1683529290528190206001918990518082805190602001908083835b602083106107145780518252601f1990920191602091820191016106f5565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050505050505050565b600160a060020a03808416600090815260208181526040808320938616835292905281812090918390518082805190602001908083835b602083106107b85780518252601f199092019160209182019101610799565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16949350505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f1151561089357600080fd5b50506020604051035195945050505050565b81600160a060020a031633600160a060020a03161415156108c557600080fd5b600160a060020a0380841660009081526001602090815260408083209386168352929052819020908290518082805190602001908083835b6020831061091c5780518252601f1990920191602091820191016108fd565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16151561095f57600080fd5b600160a060020a038084166000908152602081815260408083209386168352929052819020600191839051808280519060200190808383602083106105345780518252601f1990920191602091820191016105155600a165627a7a7230582031190b1afaa525a5ee0077c59f429d4c6914112a40799439b7f02ffa79c5a0450029";

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

    public RemoteCall<TransactionReceipt> addFullySignedPact(String one, String other, String pactId, byte[] oneV, byte[] oneR, byte[] oneS, byte[] otherV, byte[] otherR, byte[] otherS) {
        Function function = new Function(
                "addFullySignedPact", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId), 
                new org.web3j.abi.datatypes.generated.Bytes1(oneV), 
                new org.web3j.abi.datatypes.generated.Bytes32(oneR), 
                new org.web3j.abi.datatypes.generated.Bytes32(oneS), 
                new org.web3j.abi.datatypes.generated.Bytes1(otherV), 
                new org.web3j.abi.datatypes.generated.Bytes32(otherR), 
                new org.web3j.abi.datatypes.generated.Bytes32(otherS)), 
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
