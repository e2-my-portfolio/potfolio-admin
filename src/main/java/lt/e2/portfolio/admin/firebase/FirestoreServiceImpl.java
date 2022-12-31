package lt.e2.portfolio.admin.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.exception.FirestoreSaveException;
import lt.e2.portfolio.admin.model.FirebaseObject;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
class FirestoreServiceImpl<T extends FirebaseObject> implements FirestoreService<T> {

    private final Firestore firestore;

    @Override
    public Firestore getFirestore() {
        return firestore;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(final String collection, final Class<?> clazz) {
        Object object = null;
        var doc = getFirstDocument(collection);
        if (doc != null && doc.exists()) {
            object = doc.toObject(clazz);
        }
        return (T) object;
    }

    @SneakyThrows
    @Override
    public String create(final String collectionName, final T object) {
        String documentId = "";
        ApiFuture<DocumentReference> addedDocRef = firestore.collection(collectionName).add(object);
        try {
            documentId = addedDocRef.get().getId();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Can't save new document to Firestore in {} collection", collectionName, e);
            Thread.currentThread().interrupt();
            throw new FirestoreSaveException();
        }
        return documentId;
    }

    @Override
    public T update(String collectionName, T object) {
        var valuesMap = object.valuesMap();
        getDocumentReferenceFromCollection(collectionName).update(valuesMap);
        return get(collectionName, object.getClass());
    }

    private DocumentSnapshot getFirstDocument(String collectionName) {
        var documentRef = getDocumentReferenceFromCollection(collectionName);
        return getDocumentSnapshot(collectionName, documentRef);
    }

    private DocumentReference getDocumentReferenceFromCollection(String collectionName) {
        return firestore.collection(collectionName).listDocuments().iterator().next();
    }

    private DocumentSnapshot getDocumentSnapshot(String collectionName, DocumentReference documentReference) {
        DocumentSnapshot snapshot = null;
        if (documentReference != null) {
            try {
                var apiFuture = documentReference.get();
                snapshot = apiFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Can't fetch document from Firestore from {} collection", collectionName, e);
                Thread.currentThread().interrupt();
            }
        }
        return snapshot;
    }
}
