package lt.e2.portfolio.admin.service.stories;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
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
        var firestore = firestoreService.getFirestore();
        ApiFuture<QuerySnapshot> querySnapshot = firestore.collection(Collection.STORIES).get();
        return querySnapshot
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
