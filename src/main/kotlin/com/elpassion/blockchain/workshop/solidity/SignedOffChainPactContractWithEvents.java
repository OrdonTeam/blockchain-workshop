package com.elpassion.blockchain.workshop.solidity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class SignedOffChainPactContractWithEvents extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6106c18061001e6000396000f3006060604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632ceed05e811461009d57806374ecda07146100dc5780637cdd641d14610134578063921f57c5146101745780639e7961b3146101b5578063c9342461146101e0578063dee1b77414610225578063e27cf0e014610266578063ea6bf44914610291575b600080fd5b34156100a857600080fd5b6100c8600160a060020a03600435811690602435811690604435166102bc565b604051901515815260200160405180910390f35b34156100e757600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a031960843581169060a4359060c4359060e43590610104351661012435610144356102e2565b005b341561013f57600080fd5b610162600160a060020a0360043581169060243581169060443516606435610356565b60405190815260200160405180910390f35b341561017f57600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a03196084351660a43560c4356103df565b34156101c057600080fd5b610132600160a060020a0360043581169060243581169060443516610419565b34156101eb57600080fd5b610209600435600160f860020a031960243516604435606435610449565b604051600160a060020a03909116815260200160405180910390f35b341561023057600080fd5b610132600160a060020a0360043581169060243581169060443516606435600160f860020a03196084351660a43560c4356104f6565b341561027157600080fd5b610132600160a060020a0360043581169060243581169060443516610527565b341561029c57600080fd5b6100c8600160a060020a0360043581169060243581169060443516610552565b600160209081526000938452604080852082529284528284209052825290205460ff1681565b6102f96102f18c8c8c8c610356565b888888610449565b600160a060020a038b811691161461031057600080fd5b61032761031f8c8c8c88610356565b848484610449565b600160a060020a038c811691161461033e57600080fd5b6103498b8b8b610577565b5050505050505050505050565b6000600230868686866000604051602001526040516c01000000000000000000000000600160a060020a039687168102825294861685026014820152928516840260288401529316909102603c820152605081019190915260700160206040518083038160008661646e5a03f115156103ce57600080fd5b505060405180519695505050505050565b6103ee61031f88888888610356565b600160a060020a0388811691161461040557600080fd5b61041087878761060c565b50505050505050565b33600160a060020a031683600160a060020a031614151561043957600080fd5b61044483838361060c565b505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f115156104e457600080fd5b50506020604051035195945050505050565b61050561031f88888888610356565b600160a060020a0387811691161461051c57600080fd5b61041087878761064c565b33600160a060020a031682600160a060020a031614151561054757600080fd5b61044483838361064c565b6000602081815293815260408082208552928152828120909352825290205460ff1681565b600160a060020a03808416600090815260208181526040808320868516845282528083209385168352929052819020805460ff191660011790557f2c84fbf51a1811e3194aab1186f5579cbcb83fb90a8a5514c9ee64abb4090e629084908490849051600160a060020a03938416815291831660208301529091166040808301919091526060909101905180910390a1505050565b600160a060020a0392831660009081526001602081815260408084209587168452948152848320939095168252919093529120805460ff19169091179055565b600160a060020a038084166000908152600160209081526040808320868516845282528083209385168352929052205460ff16151561068a57600080fd5b6104448383836105775600a165627a7a723058207e3410e009a993e100ac9ee5dc401bec5b5d983d301cb22f8234d0a02e1738b10029";

    private SignedOffChainPactContractWithEvents(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SignedOffChainPactContractWithEvents(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<PactConfirmedEventResponse> getPactConfirmedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("PactConfirmed", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PactConfirmedEventResponse> responses = new ArrayList<PactConfirmedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PactConfirmedEventResponse typedResponse = new PactConfirmedEventResponse();
            typedResponse.one = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.other = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.pactId = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PactConfirmedEventResponse> pactConfirmedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("PactConfirmed", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PactConfirmedEventResponse>() {
            @Override
            public PactConfirmedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PactConfirmedEventResponse typedResponse = new PactConfirmedEventResponse();
                typedResponse.one = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.other = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.pactId = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
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

    public static RemoteCall<SignedOffChainPactContractWithEvents> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedOffChainPactContractWithEvents.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignedOffChainPactContractWithEvents> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedOffChainPactContractWithEvents.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static SignedOffChainPactContractWithEvents load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedOffChainPactContractWithEvents(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SignedOffChainPactContractWithEvents load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedOffChainPactContractWithEvents(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class PactConfirmedEventResponse {
        public String one;

        public String other;

        public String pactId;
    }
}
