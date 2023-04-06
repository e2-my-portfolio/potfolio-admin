package lt.e2.portfolio.admin.service.skills;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.firebase.FirestoreService;
import lt.e2.portfolio.admin.firebase.constant.Collection;
import lt.e2.portfolio.admin.model.SkillsGroup;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
class SkillsServiceImpl implements SkillsService {

    private final FirestoreService<SkillsGroup> firestoreService;

    @SneakyThrows
    @Override
    public List<SkillsGroup> getData() {
        return firestoreService.getCollection(Collection.SKILLS)
            .orderBy("order")
            .get()
            .get()
            .getDocuments()
            .stream()
            .map(snapshot -> snapshot.toObject(SkillsGroup.class))
            .toList();
    }

    @Override
    public String createData(List<SkillsGroup> data) {
        final var order = new AtomicInteger(0);
        StringBuilder builder = new StringBuilder();
        data.forEach(object -> {
            order.getAndIncrement();
            object.setOrder(order.get());
            builder.append("ID: ")
                    .append(firestoreService.create(Collection.SKILLS, object))
                    .append("; ");
        });
        return builder.toString().trim();
    }

    @Override
    public List<SkillsGroup> updateData(List<SkillsGroup> data) {
        return Collections.emptyList();
    }
}
