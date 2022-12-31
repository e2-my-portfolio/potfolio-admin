package lt.e2.portfolio.admin.firebase.constant;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, type="string", allowableValues = {"profile-picture", "cv"})
public enum Folder {

    PROFILE_PICTURE("profile-picture"),
    CV("cv");

    final String value;

    Folder(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
