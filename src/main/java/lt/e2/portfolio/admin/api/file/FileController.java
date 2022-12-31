package lt.e2.portfolio.admin.api.file;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.firebase.FireStorageService;
import lt.e2.portfolio.admin.firebase.constant.Folder;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
final class FileController implements FileEndpoints {

    private final FireStorageService storageService;

    @Override
    public void uploadFile(final Folder folder, final MultipartFile file) {
        storageService.uploadFile(folder.getValue(), file);
    }

}
