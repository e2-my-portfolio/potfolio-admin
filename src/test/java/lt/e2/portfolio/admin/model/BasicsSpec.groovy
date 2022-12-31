package lt.e2.portfolio.admin.model

import static lt.e2.portfolio.admin.TestConstants.*

import spock.lang.Specification

class BasicsSpec extends Specification {

    def "Should create not empty values map"() {
        given:
            final FirebaseObject object = new Basics(
                    NAME,
                    MIDDLE_NAME,
                    SURNAME,
                    POSITION,
                    "",
                    "",
                    DESCRIPTION,
                    "",
                    "")

            final expectation = new HashMap()
            expectation.put("name", NAME)
            expectation.put("surname", SURNAME)
            expectation.put("position", POSITION)
            expectation.put("description", DESCRIPTION)
        when:
            final def result = object.valuesMap()
        then:
            expectation == result
    }

}
