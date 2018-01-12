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
import org.web3j.abi.datatypes.Utf8String;
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
public final class SimplePactContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6105368061001e6000396000f3006060604052600436106100565763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e4ea188811461005b578063929d898f146100d6578063a1e3e57a14610184575b600080fd5b341561006657600080fd5b6100c4600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061020195505050505050565b60405190815260200160405180910390f35b34156100e157600080fd5b610182600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650507fff0000000000000000000000000000000000000000000000000000000000000085358116956020810135955060408101359450606081013590911692506080810135915060a001356102c8565b005b341561018f57600080fd5b6101ed600160a060020a036004803582169160248035909116919060649060443590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506103c795505050505050565b604051901515815260200160405180910390f35b60006002308585856000604051602001526040516c01000000000000000000000000600160a060020a0380871682028352858116820260148401528416026028820152603c810182805190602001908083835b602083106102735780518252601f199092019160209182019101610254565b6001836020036101000a03801982511681845116808217855250505050505090500194505050505060206040518083038160008661646e5a03f115156102b857600080fd5b5050604051805195945050505050565b6102de6102d68a8a8a610201565b87878761045d565b600160a060020a038a81169116146102f557600080fd5b61030b6103038a8a8a610201565b84848461045d565b600160a060020a0389811691161461032257600080fd5b600160a060020a03808a16600090815260208181526040808320938c1683529290528190206001918990518082805190602001908083835b602083106103795780518252601f19909201916020918201910161035a565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051908190039020805460ff1916911515919091179055505050505050505050565b600160a060020a03808416600090815260208181526040808320938616835292905281812090918390518082805190602001908083835b6020831061041d5780518252601f1990920191602091820191016103fe565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040519081900390205460ff16949350505050565b60006001856040519081526020016040518091039020857f0100000000000000000000000000000000000000000000000000000000000000900485856040516000815260200160405260006040516020015260405193845260ff90921660208085019190915260408085019290925260608401929092526080909201915160208103908084039060008661646e5a03f115156104f857600080fd5b505060206040510351959450505050505600a165627a7a723058200f87d5716b7407f545962033ebee73b94753e5b49a91be336e5ef5f50c45b4db0029";

    private SimplePactContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SimplePactContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<PactConfirmedEventResponse> getPactConfirmedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("PactConfirmed", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
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

    public RemoteCall<byte[]> pactHash256(String one, String other, String pactId) {
        Function function = new Function("pactHash256", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(one), 
                new org.web3j.abi.datatypes.Address(other), 
                new org.web3j.abi.datatypes.Utf8String(pactId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public static class PactConfirmedEventResponse {
        public String one;

        public String other;

        public String pactId;
    }
}
