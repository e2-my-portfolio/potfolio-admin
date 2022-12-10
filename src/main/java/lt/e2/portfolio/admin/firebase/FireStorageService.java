package lt.e2.portfolio.admin.firebase;

import org.springframework.web.multipart.MultipartFile;

public sealed interface FireStorageService permits FireStorageServiceImpl {

    void uploadFile(String folder, MultipartFile file);

}
