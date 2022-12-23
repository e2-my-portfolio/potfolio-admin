package lt.e2.portfolio.admin.api.basics;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.model.Basics;
import lt.e2.portfolio.admin.service.basics.BasicsService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
final class BasicsController implements BasicsEndpoints {

    private final BasicsService service;

    @Override
    public Basics getData() {
        return service.getBasics();
    }

    @Override
    public void createData(Basics data) {
        service.createBasics(data);
    }

    @Override
    public void updateData(Basics data) {
        service.updateBasics(data);
    }

}
