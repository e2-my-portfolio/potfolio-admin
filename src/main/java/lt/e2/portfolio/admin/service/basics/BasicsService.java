package lt.e2.portfolio.admin.service.basics;

import lt.e2.portfolio.admin.model.Basics;

public sealed interface BasicsService permits BasicsServiceImpl {

    Basics getBasics();

    void createBasics(Basics basics);

}
