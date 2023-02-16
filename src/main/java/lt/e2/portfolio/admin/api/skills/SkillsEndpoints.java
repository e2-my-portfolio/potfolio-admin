package lt.e2.portfolio.admin.api.skills;

import io.swagger.v3.oas.annotations.tags.Tag;
import lt.e2.portfolio.admin.api.DataManageEndpoints;
import lt.e2.portfolio.admin.model.SkillsGroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Skills", description = "Skills for portfolio Skills page")
@RequestMapping("/skills")
public sealed interface SkillsEndpoints extends DataManageEndpoints<List<SkillsGroup>> permits SkillsController {
}
