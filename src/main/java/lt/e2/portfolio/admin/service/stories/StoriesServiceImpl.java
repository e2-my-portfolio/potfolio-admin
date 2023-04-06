package lt.e2.portfolio.admin.service.stories;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.firebase.FirestoreService;
import lt.e2.portfolio.admin.firebase.constant.Collection;
import lt.e2.portfolio.admin.model.Stories;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
class StoriesServiceImpl implements StoriesService {

    private final FirestoreService<Stories> firestoreService;

    @SneakyThrows
    @Override
    public List<Stories> getData() {
        return firestoreService.getCollection(Collection.STORIES).get()
                .get()
                .getDocuments()
                .stream()
                .map(snapshot -> snapshot.toObject(Stories.class))
                .toList();
    }

    @Override
    public String createData(List<Stories> data) {
        StringBuilder builder = new StringBuilder();
        data.forEach(object -> builder
                .append("ID: ")
                .append(firestoreService.create(Collection.STORIES, object))
                .append("; "));
        return builder.toString().trim();
    }

    @Override
    public List<Stories> updateData(List<Stories> data) {
        return Collections.emptyList();
    }
}
