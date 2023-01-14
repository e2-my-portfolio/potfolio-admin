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
class BasicsServiceImpl implements BasicsService {

    private final FirestoreService<Basics> firestoreService;

    @Override
    public Basics getData() {
        return firestoreService.get(Collection.BASICS, Basics.class);
    }

    @Override
    public String createData(Basics data) {
        return firestoreService.create(Collection.BASICS, data);
    }

    @Override
    public Basics updateData(Basics data) {
        return firestoreService.update(Collection.BASICS, data);
    }
}
