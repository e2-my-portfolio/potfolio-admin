package lt.e2.portfolio.admin.api.stories;

import lombok.RequiredArgsConstructor;
import lt.e2.portfolio.admin.model.Stories;
import lt.e2.portfolio.admin.service.stories.StoriesService;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
final class StoriesController implements StoriesEndpoints {

    private final StoriesService storiesService;

    @Override
    public List<Stories> getData() {
        return storiesService.getData();
    }

    @Override
    public String createData(List<Stories> data) {
        return storiesService.createData(data);
    }

    @Override
    public List<Stories> updateData(List<Stories> data) {
        return storiesService.updateData(data);
    }
}
