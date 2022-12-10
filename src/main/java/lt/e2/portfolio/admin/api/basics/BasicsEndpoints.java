package lt.e2.portfolio.admin.api.basics;

import lt.e2.portfolio.admin.api.DataManageEndpoints;
import lt.e2.portfolio.admin.model.Basics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basics")
public sealed interface BasicsEndpoints extends DataManageEndpoints<Basics> permits BasicsController {
}
