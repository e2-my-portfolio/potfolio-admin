package lt.e2.portfolio.admin.firebase;

import org.springframework.web.multipart.MultipartFile;

public interface FireStorageService {

    void uploadFile(String folder, MultipartFile file);

}
