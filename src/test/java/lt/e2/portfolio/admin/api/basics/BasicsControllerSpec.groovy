package lt.e2.portfolio.admin.api.basics

import static lt.e2.portfolio.admin.TestConstants.*

import lt.e2.portfolio.admin.model.Basics
import lt.e2.portfolio.admin.service.basics.BasicsService
import spock.lang.Specification
import spock.lang.Subject

class BasicsControllerSpec extends Specification {

    private BasicsService basicsService = Mock()

    @Subject
    private BasicsEndpoints controller

    def "setup"() {
        controller = new BasicsController(basicsService)
    }

    def "get basic data"() {
        given:
        final def mock = mockBasicData()

        when:
        final def result = controller.getData()

        then:
        1 * basicsService.getBasics() >> mock

        and:
        mock == result
    }

    def "create basic data"() {
        given:
        final def request = mockBasicData()

        when:
        controller.createData(request)

        then:
        1 * basicsService.createBasics(request)
    }

    def "update basic data"() {
        given:
        final def request = mockBasicData()

        when:
        controller.updateData(request)

        then:
        1 * basicsService.updateBasics(request)
    }

    private Basics mockBasicData() {
        return Basics.builder()
                .name(NAME)
                .surname(SURNAME)
                .position(POSITION)
                .city(CITY)
                .country(COUNTRY)
                .description(DESCRIPTION)
                .companyName(COMPANY_NAME)
                .companyUrl(COMPANY_URL)
                .build()
    }
}
