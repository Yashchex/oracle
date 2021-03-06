package yashchex.config;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath({"contract.properties", "contract.secret.properties"})
public interface OracleConfig {
    @Property("contract.address")
    String contractAddress();
}
