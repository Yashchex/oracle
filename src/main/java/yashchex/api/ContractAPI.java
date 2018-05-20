package yashchex.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import ru.qatools.properties.PropertyLoader;
import yashchex.config.OracleConfig;

import static org.web3j.tx.gas.DefaultGasProvider.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

public class ContractAPI {
    private static final Logger log = LoggerFactory.getLogger(ContractAPI.class);

    private OracleConfig config = PropertyLoader.newInstance()
            .populate(OracleConfig.class);

    public Web3j getWeb3j() {
        Web3j web3j = null;
        try {
            web3j = Web3j.build(new HttpService(
                    "https://rinkeby.infura.io/FMT"));  // FIXME: Enter your Infura token here;
            log.info("Connected to Ethereum client version: "
                    + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return web3j;
    }

    public Credentials getCredentials() {
        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials(System.getProperty("walletPassword", ""),
                    System.getProperty("walletSource", ""));
                    log.info("Credentials are loaded");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return credentials;
    }

    public Yashchex getContract() {
        return getContract(config.contractAddress());
    }

    public Yashchex getContract(String address) {
        Yashchex contract = null;
        try {
            contract = Yashchex.load(config.contractAddress(),
                    getWeb3j(), getCredentials(),
                    GAS_PRICE, GAS_LIMIT);
            log.info("Contract is loaded");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return contract;
    }

    public Yashchex createContract() {
        Yashchex contract = null;
        try {
            contract = Yashchex.deploy(getWeb3j(), getCredentials(),
                    GAS_PRICE, GAS_LIMIT).send();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        String contractAddress = contract.getContractAddress();
        log.info("Smart contract deployed to address " + contractAddress);
        log.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);
        return contract;
    }
}
