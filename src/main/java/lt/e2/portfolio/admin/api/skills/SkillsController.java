package lt.e2.portfolio.admin.api.skills;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.model.SkillsGroup;
import lt.e2.portfolio.admin.service.skills.SkillsService;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
final class SkillsController implements SkillsEndpoints {

    private final SkillsService service;

    @Override
    public List<SkillsGroup> getData() {
        return service.getData();
    }

    @Override
    public String createData(List<SkillsGroup> data) {
        return service.createData(data);
    }

    @Override
    public List<SkillsGroup> updateData(List<SkillsGroup> data) {
        return service.updateData(data);
    }
}
