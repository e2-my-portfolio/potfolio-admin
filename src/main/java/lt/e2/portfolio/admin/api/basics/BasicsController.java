package lt.e2.portfolio.admin.api.basics;

import lt.e2.portfolio.admin.model.Basics;
import org.springframework.stereotype.Controller;

@Controller
final class BasicsController implements BasicsEndpoints {

    @Override
    public Basics getData() {
        return null;
    }

    @Override
    public void createData(Basics data) {

    }

}
