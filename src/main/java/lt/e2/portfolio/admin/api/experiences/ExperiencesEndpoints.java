package lt.e2.portfolio.admin.api.experiences;

import io.swagger.v3.oas.annotations.tags.Tag;
import lt.e2.portfolio.admin.api.DataManageEndpoints;
import lt.e2.portfolio.admin.model.Experience;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="Experiences", description = "Experiences / Working places for portfolio 'Experiences' page")

public sealed interface ExperiencesEndpoints  extends DataManageEndpoints<List<Experience>> permits ExperiencesController {
}
