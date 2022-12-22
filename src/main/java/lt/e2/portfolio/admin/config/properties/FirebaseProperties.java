package lt.e2.portfolio.admin.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("app.firebase")
public class FirebaseProperties {

    private String authFile;
    private String databaseUrl;
    private String storageUrl;

}
