package lt.e2.portfolio.admin.api.file;

import io.swagger.v3.oas.annotations.tags.Tag;
import lt.e2.portfolio.admin.firebase.constant.Folder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "File", description = "Upload file and replace if exist")
@RequestMapping("/file")
public sealed interface FileEndpoints permits FileController {

    @PostMapping(consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    void uploadFile(
            @RequestHeader("folder-name") final Folder folder,
            @RequestParam final MultipartFile file
    );


}
