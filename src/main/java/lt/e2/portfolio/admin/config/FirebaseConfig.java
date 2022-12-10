package lt.e2.portfolio.admin.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.config.properties.FirebaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(FirebaseProperties.class)
public class FirebaseConfig {

    private final FirebaseProperties properties;

    @Bean()
    Firestore firestore() {
        return FirestoreClient.getFirestore();
    }

    @Bean
    Bucket fileBucket() {
        return StorageClient.getInstance().bucket();
    }

    @Bean
    Storage fileStorage() {
        return fileBucket().getStorage();
    }

    @SneakyThrows
    @PostConstruct
    void initFirebase() {
        final var resource = new ClassPathResource(properties.authFile());
        final var authFile = new File(resource.getURI());
        try(FileInputStream fileStream = new FileInputStream(authFile)) {
            var firebaseOptions = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(fileStream))
                    .setDatabaseUrl(properties.databaseUrl())
                    .setStorageBucket(properties.storageUrl())
                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
