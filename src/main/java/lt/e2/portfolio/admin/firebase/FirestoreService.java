package lt.e2.portfolio.admin.firebase;

import com.google.cloud.firestore.Firestore;
import lt.e2.portfolio.admin.model.FirebaseObject;
import lt.e2.portfolio.admin.firebase.constant.Collection;

public sealed interface FirestoreService permits FirestoreServiceImpl {

    /** Get Firestore instance
     * @return Firestore instance
     * @see Firestore
     * */
    Firestore getFirestore();

    /**
     * Get document object from Firestore<br>
     * <b>Example:</b> <code>firestoreService.get(Collection.MY_COLLECTION, MyCollection.class)</code>
     * @param collectionName Firestore collection name.
     *                       Use string or Collection constant
     * @param clazz Class in which json document object should be mapped
     * @return Firestore Document
     * @see Object
     * @see Collection
     * */
    Object get(String collectionName, Class<?> clazz);

    /**
     * Create new document in Firestore
     * @param collectionName Firestore collection name.
     *                       Use string or Collection constant
     * @param object document object which should be created
     * @return Firestore Document ID
     * @see Object
     * @see Collection
     * */
    String create(String collectionName, Object object);

    /**
     * Update existing document in Firestore
     * @param collectionName Firestore collection name.
     *                       Use string or Collection constant
     * @param object document object which should be created
     * @return Updated Firestore Document
     * @see Object
     * @see Collection
     * @see FirebaseObject
     * */
    Object update(String collectionName, FirebaseObject object);

}
