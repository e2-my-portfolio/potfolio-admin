package lt.e2.portfolio.admin.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("app.firebase")
public record FirebaseProperties(
        String authFile,
        String databaseUrl,
        String storageUrl
) { }
