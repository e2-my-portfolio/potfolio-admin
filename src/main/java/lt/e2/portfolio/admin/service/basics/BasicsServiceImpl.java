package lt.e2.portfolio.admin.service.basics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.firebase.FirestoreService;
import lt.e2.portfolio.admin.firebase.constant.Collection;
import lt.e2.portfolio.admin.model.Basics;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
final class BasicsServiceImpl implements BasicsService {

    private final FirestoreService<Basics> firestoreService;

    @Override
    public Basics getBasics() {
        return firestoreService.get(Collection.BASICS, Basics.class);
    }

    @Override
    public void createBasics(Basics basics) {
        firestoreService.create(Collection.BASICS, basics);
    }

    @Override
    public void updateBasics(Basics basics) {
        firestoreService.update(Collection.BASICS, basics);
    }

}
