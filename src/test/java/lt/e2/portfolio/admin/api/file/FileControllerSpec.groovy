package lt.e2.portfolio.admin.api.file

import lt.e2.portfolio.admin.firebase.FireStorageService
import lt.e2.portfolio.admin.firebase.constant.Folder
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification
import spock.lang.Subject

class FileControllerSpec extends Specification {

    private FireStorageService fireStorage = Mock()

    @Subject
    private FileEndpoints controller

    def "setup"() {
        controller = new FileController(fireStorage)
    }

    def "call storage once on file upload"() {
        given:
        final def folder = Folder.CV
        final def file = mockFile()

        when:
        controller.uploadFile(folder, file)

        then:
        1 * fireStorage.uploadFile(folder.toString(), file)
    }

    private MultipartFile mockFile() {
        return new MockMultipartFile(
                "file",
                "file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                InputStream.nullInputStream()
                )
    }

}

