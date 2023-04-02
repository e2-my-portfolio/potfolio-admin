package lt.e2.portfolio.admin.service.experiences;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.firebase.FirestoreService;
import lt.e2.portfolio.admin.firebase.constant.Collection;
import lt.e2.portfolio.admin.model.Experience;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExperiencesServiceImpl implements ExperiencesService {

    private final FirestoreService<Experience> firestoreService;

    @SneakyThrows
    @Override
    public List<Experience> getData() {
        final var firestore = firestoreService.getFirestore();
        final var documentFuture = firestore.collection(Collection.EXPERIENCES).get();
        return documentFuture.get().getDocuments()
                .stream()
                .map(snapshot -> snapshot.toObject(Experience.class))
                .toList();
    }

    @Override
    public String createData(List<Experience> data) {
        StringBuilder builder = new StringBuilder();
        data.forEach(object ->
            builder.append("ID: ")
                    .append(firestoreService.create(Collection.EXPERIENCES, object))
                    .append("; ")
        );
        return builder.toString().trim();
    }

    @Override
    public List<Experience> updateData(List<Experience> data) {
        return Collections.emptyList();
    }
}