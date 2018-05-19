package yashchex.api;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.List;

public class ContractAPITest {
    private static ContractAPI contractAPI;

    @BeforeClass
    public static void init() {
        contractAPI = new ContractAPI();
    }

    @Test
    public void createNewContract() throws Exception {
        Yashchex contract = contractAPI.createContract();

        String boxAddress = "0x" + System.currentTimeMillis();
        contract.addBox(boxAddress).send();
        List boxes = contract.getBoxes().send();
        Assert.assertEquals("Incorrect number of boxes", boxes.size(), 1);
    }

    @Test
    public void loadContract() throws Exception {
        Yashchex contract = contractAPI.getContract();

        String boxAddress = "0x" + System.currentTimeMillis();
        TransactionReceipt transactionReceiptFirstBox = contract.addBox(boxAddress + "1").send();
        TransactionReceipt transactionReceiptSecondBox = contract.addBox(boxAddress + "2").send();
        List boxes = contract.getBoxes().send();
        Assert.assertTrue("Incorrect number of boxes", boxes.size() >= 2);

        BigInteger statesCount = contract.getStatesCount(boxAddress + "2").send();
        Assert.assertEquals("Incorrect number of states", statesCount, BigInteger.ZERO);
    }
}