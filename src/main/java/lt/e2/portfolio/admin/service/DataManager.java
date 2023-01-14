package lt.e2.portfolio.admin.service;

public interface DataManager<T> {

    /**
     * Get parameterized data object from repository
     * @return parameterized object (any)
     * */
    T getData();

    /**
     * Create parameterized data object in repository
     * @param data parameterized object (any)
     * @return Object ID from repository
     * */
    String createData(T data);

    /**
     * Update object in repository and return updated
     * @param data parameterized object with update values (any)
     * @return parameterized object (any)
     * */
    T updateData(T data);

}
