package lt.e2.portfolio.admin.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("app.swagger")
public class SwaggerProperties {

    private String version;
    private String title;
    private String description;

}
