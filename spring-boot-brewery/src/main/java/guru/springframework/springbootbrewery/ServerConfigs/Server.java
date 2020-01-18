package guru.springframework.springbootbrewery.ServerConfigs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sfg.server", ignoreUnknownFields = false)
public class Server {
    private String hostingServer;

    public void setHostingServer(String hostingServer) {
        this.hostingServer = hostingServer;
    }

    public String getHostingServer() {
        return hostingServer;
    }
}
