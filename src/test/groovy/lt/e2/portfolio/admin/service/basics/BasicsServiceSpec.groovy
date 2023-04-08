package lt.e2.portfolio.admin.service.basics

import lt.e2.portfolio.admin.TestUtils
import lt.e2.portfolio.admin.firebase.FirestoreService
import lt.e2.portfolio.admin.firebase.constant.Collection
import lt.e2.portfolio.admin.model.Basics
import spock.lang.Specification
import spock.lang.Subject

class BasicsServiceSpec extends Specification {

    private FirestoreService<Basics> firestoreService = Mock()

    @Subject
    private BasicsService service

    def "setup"() {
        service = new BasicsServiceImpl(firestoreService)
    }

    def "call firestore service when getting basics data"() {
        given:
        final def basics = TestUtils.mockBasics()

        when:
        final def result = service.getData()

        then:
        1 * firestoreService.get(Collection.BASICS, Basics.class) >> basics

        and:
        basics == result
    }

    def "call firestore service once when creating basics data"() {
        given:
        final def basics = TestUtils.mockBasics()

        when:
        service.createData(basics)

        then:
        1 * firestoreService.create(Collection.BASICS, basics)
    }

    def "call firestore service once when updating basics data"() {
        given:
        final def basics = TestUtils.mockBasics()

        when:
        service.updateData(basics)

        then:
        1 * firestoreService.update(Collection.BASICS, basics)
    }

}
