package lt.e2.portfolio.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface FirebaseObject {

    @JsonIgnore
    default Map<String, Object> valuesMap() {
        return Arrays.stream(this.getClass().getDeclaredFields()).filter(nonNullField()).collect(Collectors.toMap(Field::getName, getValue()));
    }

    private Predicate<Field> nonNullField() {
        return field -> {
            try {
                field.setAccessible(true);
                return isNotNullOrEmpty(field.get(this));
            } catch (IllegalAccessException e) {
                return false;
            }
        };
    }

    private Function<Field, Object> getValue() {
        return field -> {
            try {
                return field.get(this);
            } catch (IllegalAccessException e) {
                return new Object();
            }
        };
    }

    private boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String string) {
            return string.isBlank();
        } else if (object instanceof List<?> list) {
            return list.isEmpty();
        }
        return false;
    }

    private boolean isNotNullOrEmpty(Object object) {
        return !isNullOrEmpty(object);
    }

}
