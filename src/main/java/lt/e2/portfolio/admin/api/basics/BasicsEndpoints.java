package lt.e2.portfolio.admin.api.basics;

import io.swagger.v3.oas.annotations.tags.Tag;
import lt.e2.portfolio.admin.api.DataManageEndpoints;
import lt.e2.portfolio.admin.model.Basics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Basics", description = "Basics for portfolio Home page")
@RequestMapping("/basics")
public sealed interface BasicsEndpoints extends DataManageEndpoints<Basics> permits BasicsController {
}
