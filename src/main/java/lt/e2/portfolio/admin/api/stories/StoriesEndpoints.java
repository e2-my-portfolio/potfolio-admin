package lt.e2.portfolio.admin.api.stories;

import io.swagger.v3.oas.annotations.tags.Tag;
import lt.e2.portfolio.admin.api.DataManageEndpoints;
import lt.e2.portfolio.admin.model.Stories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Stories", description = "Stories about person for portfolio 'About' page")
@RequestMapping("/stories")
public sealed interface StoriesEndpoints extends DataManageEndpoints<List<Stories>> permits StoriesController {
}
