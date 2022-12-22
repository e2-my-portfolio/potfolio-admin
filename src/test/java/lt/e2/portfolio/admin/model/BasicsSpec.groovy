package lt.e2.portfolio.admin.model

import spock.lang.Specification

class BasicsSpec extends Specification {

    def "Should create not empty values map"() {
        given:
            FirebaseObject object = new Basics(
                    "Jack",
                    null,
                    "Sparrow",
                    "Captain",
                    "",
                    "",
                    "Pirate",
                    "",
                    "")

            final expectation = new HashMap()
            expectation.put("name", "Jack")
            expectation.put("surname", "Sparrow")
            expectation.put("position", "Captain")
            expectation.put("description", "Pirate")
        when:
            final def result = object.valuesMap()
        then:
            expectation == result
    }

}
