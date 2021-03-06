package yashchex.api;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Yashchex extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610c91806100206000396000f3006080604052600436106100ae5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632be4b94c81146100b357806334e97ec2146101185780637335d28a1461023457806386dcb95e146102695780639506834f14610292578063a665b9d9146102f9578063a7c3552d1461032c578063a8c20d93146103ce578063bc10242814610435578063c4509b4f14610459578063c74073a11461047a575b600080fd5b3480156100bf57600080fd5b506100c861049b565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101045781810151838201526020016100ec565b505050509050019250505060405180910390f35b34801561012457600080fd5b50610139600160a060020a03600435166104fe565b6040518086151515158152602001851515151581526020018060200180602001848152602001838103835286818151815260200191508051906020019080838360005b8381101561019457818101518382015260200161017c565b50505050905090810190601f1680156101c15780820380516001836020036101000a031916815260200191505b50838103825285518152855160209182019187019080838360005b838110156101f45781810151838201526020016101dc565b50505050905090810190601f1680156102215780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561024057600080fd5b50610255600160a060020a0360043516610694565b604080519115158252519081900360200190f35b34801561027557600080fd5b50610290600160a060020a03600435811690602435166106b2565b005b34801561029e57600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610290958335600160a060020a03169536956044949193909101919081908401838280828437509497506107169650505050505050565b34801561030557600080fd5b5061031a600160a060020a03600435166107bc565b60408051918252519081900360200190f35b34801561033857600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526102909482351515946024803515159536959460649492019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506107d79650505050505050565b3480156103da57600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610290958335600160a060020a03169536956044949193909101919081908401838280828437509497506108979650505050505050565b34801561044157600080fd5b50610139600160a060020a0360043516602435610939565b34801561046557600080fd5b50610290600160a060020a0360043516610aee565b34801561048657600080fd5b50610290600160a060020a0360043516610b83565b606060008054806020026020016040519081016040528092919081815260200182805480156104f357602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116104d5575b505050505090505b90565b600160a060020a03811660009081526002602052604081208054829160609182918491908290600019830183811061053257fe5b600091825260209182902060049190910201805460038201546001808401805460408051600261010095841615860260001901909316839004601f81018a90048a0282018a0190925281815296985060ff808716989490960490951695919490880193928591908301828280156105ea5780601f106105bf576101008083540402835291602001916105ea565b820191906000526020600020905b8154815290600101906020018083116105cd57829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850879450925084019050828280156106785780601f1061064d57610100808354040283529160200191610678565b820191906000526020600020905b81548152906001019060200180831161065b57829003601f168201915b5050505050915096509650965096509650505091939590929450565b600160a060020a031660009081526003602052604090205460ff1690565b600160a060020a0380831660009081526001602052604090205483911633146106da57600080fd5b50600160a060020a039182166000908152600560205260409020805473ffffffffffffffffffffffffffffffffffffffff191691909216179055565b806040518082805190602001908083835b602083106107465780518252601f199092019160209182019101610727565b51815160209384036101000a60001901801990921691161790526040805192909401829003909120600160a060020a0388166000908152600490925292902054909114925061079791505057600080fd5b50600160a060020a03166000908152600360205260409020805460ff19166001179055565b600160a060020a031660009081526002602052604090205490565b336000908152600260209081526040808320815160a081018352881515815287151581850190815292810187815260608201879052426080830152825460018181018086559488529686902083516004909202018054955115156101000261ff001992151560ff199097169690961791909116949094178455518051929591946108679392850192910190610bcd565b5060608201518051610883916002840191602090910190610bcd565b506080820151816003015550505050505050565b600160a060020a038281166000908152600560205260409020541633146108bd57600080fd5b806040518082805190602001908083835b602083106108ed5780518252601f1990920191602091820191016108ce565b51815160001960209485036101000a019081169019919091161790526040805194909201849003909320600160a060020a03909716600090815260049093529091209490945550505050565b600160a060020a0382166000908152600260205260408120548190606090819083908190871061096857600080fd5b600160a060020a038816600090815260026020526040902080548890811061098c57fe5b600091825260209182902060049190910201805460038201546001808401805460408051600261010095841615860260001901909316839004601f81018a90048a0282018a0190925281815296985060ff80871698949096049095169591949088019392859190830182828015610a445780601f10610a1957610100808354040283529160200191610a44565b820191906000526020600020905b815481529060010190602001808311610a2757829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815295985087945092508401905082828015610ad25780601f10610aa757610100808354040283529160200191610ad2565b820191906000526020600020905b815481529060010190602001808311610ab557829003601f168201915b5050505050915095509550955095509550509295509295909350565b600160a060020a03808216600090815260016020526040902054161515610b805760008054600181810183557f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5639091018054600160a060020a03851673ffffffffffffffffffffffffffffffffffffffff19918216811790925590835260209190915260409091208054909116331790555b50565b600160a060020a038082166000908152600160205260409020548291163314610bab57600080fd5b50600160a060020a03166000908152600360205260409020805460ff19169055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610c0e57805160ff1916838001178555610c3b565b82800160010185558215610c3b579182015b82811115610c3b578251825591602001919060010190610c20565b50610c47929150610c4b565b5090565b6104fb91905b80821115610c475760008155600101610c515600a165627a7a7230582031ac4b33ec1d378c4aa743b3ea6709c3b439295b9ffb72e3ffaf4ed7dda7cc710029";

    public static final String FUNC_GETBOXES = "getBoxes";

    public static final String FUNC_GETLASTSTATE = "getLastState";

    public static final String FUNC_IFCANBEOPENED = "ifCanBeOpened";

    public static final String FUNC_SETRECEIVER = "setReceiver";

    public static final String FUNC_OPEN = "open";

    public static final String FUNC_GETSTATESCOUNT = "getStatesCount";

    public static final String FUNC_STATE = "state";

    public static final String FUNC_SETSECRET = "setSecret";

    public static final String FUNC_GETSTATE = "getState";

    public static final String FUNC_ADDBOX = "addBox";

    public static final String FUNC_CLOSE = "close";

    protected Yashchex(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Yashchex(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<List> getBoxes() {
        final Function function = new Function(FUNC_GETBOXES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Tuple5<Boolean, Boolean, String, String, BigInteger>> getLastState(String box) {
        final Function function = new Function(FUNC_GETLASTSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<Boolean, Boolean, String, String, BigInteger>>(
                new Callable<Tuple5<Boolean, Boolean, String, String, BigInteger>>() {
                    @Override
                    public Tuple5<Boolean, Boolean, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Boolean, Boolean, String, String, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> ifCanBeOpened(String box) {
        final Function function = new Function(FUNC_IFCANBEOPENED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setReceiver(String box, String receiver) {
        final Function function = new Function(
                FUNC_SETRECEIVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box), 
                new org.web3j.abi.datatypes.Address(receiver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> open(String box, String secret) {
        final Function function = new Function(
                FUNC_OPEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box), 
                new org.web3j.abi.datatypes.Utf8String(secret)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getStatesCount(String box) {
        final Function function = new Function(FUNC_GETSTATESCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> state(Boolean ok, Boolean opened, String location, String error) {
        final Function function = new Function(
                FUNC_STATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(ok), 
                new org.web3j.abi.datatypes.Bool(opened), 
                new org.web3j.abi.datatypes.Utf8String(location), 
                new org.web3j.abi.datatypes.Utf8String(error)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setSecret(String box, String secret) {
        final Function function = new Function(
                FUNC_SETSECRET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box), 
                new org.web3j.abi.datatypes.Utf8String(secret)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<Boolean, Boolean, String, String, BigInteger>> getState(String box, BigInteger index) {
        final Function function = new Function(FUNC_GETSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<Boolean, Boolean, String, String, BigInteger>>(
                new Callable<Tuple5<Boolean, Boolean, String, String, BigInteger>>() {
                    @Override
                    public Tuple5<Boolean, Boolean, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Boolean, Boolean, String, String, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addBox(String box) {
        final Function function = new Function(
                FUNC_ADDBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> close(String box) {
        final Function function = new Function(
                FUNC_CLOSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(box)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Yashchex> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Yashchex.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Yashchex> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Yashchex.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Yashchex load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Yashchex(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Yashchex load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Yashchex(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
