package lt.e2.portfolio.admin.api.experiences;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.model.Experience;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
final class ExperienceController implements ExperiencesEndpoints {

    @Override
    public List<Experience> getData() {
        return null;
    }

    @Override
    public String createData(List<Experience> data) {
        return null;
    }

    @Override
    public List<Experience> updateData(List<Experience> data) {
        return null;
    }

}
