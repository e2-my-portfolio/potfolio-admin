package lt.e2.portfolio.admin.api.experiences;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.model.Experience;
import lt.e2.portfolio.admin.service.experiences.ExperiencesService;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
final class ExperiencesController implements ExperiencesEndpoints {

    private final ExperiencesService experiencesService;

    @Override
    public List<Experience> getData() {
        return experiencesService.getData();
    }

    @Override
    public String createData(List<Experience> data) {
        return experiencesService.createData(data);
    }

    @Override
    public List<Experience> updateData(List<Experience> data) {
        return experiencesService.updateData(data);
    }

}
