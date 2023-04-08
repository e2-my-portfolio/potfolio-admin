package lt.e2.portfolio.admin.model;

import lombok.Builder;

@Builder
public record Company(String name, String location) implements FirebaseObject {
}
