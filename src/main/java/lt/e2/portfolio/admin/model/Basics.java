package lt.e2.portfolio.admin.model;

import org.springframework.lang.Nullable;

import java.util.Map;

public record Basics(
        String name,
        @Nullable String middleName,
        String surname,
        String position,
        String city,
        String country,
        String description,
        String companyName,
        String companyUrl) implements FirebaseObject {

    @Override
    public Map<String, Object> valuesMap() {
        return null;
    }
}
