package suny.example.hazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCastConfiguration {

    @Bean
    public Config hazelcastLocalConfig() {
        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        // member means hc service member
        joinConfig.getTcpIpConfig().setEnabled(true).addMember("localhost");
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getKubernetesConfig().setEnabled(false);
        return config;
    }

}