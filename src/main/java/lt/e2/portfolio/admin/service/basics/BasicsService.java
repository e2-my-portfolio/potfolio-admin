package lt.e2.portfolio.admin.service.basics;

import lt.e2.portfolio.admin.model.Basics;

public interface BasicsService {

    Basics getBasics();

    void createBasics(Basics basics);

    void updateBasics(Basics basics);

}
