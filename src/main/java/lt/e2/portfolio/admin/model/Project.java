package lt.e2.portfolio.admin.model;

import lombok.Builder;

@Builder
public record Project(String name, String description) implements FirebaseObject {
}
