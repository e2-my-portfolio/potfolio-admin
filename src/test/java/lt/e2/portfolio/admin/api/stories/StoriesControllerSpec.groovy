package lt.e2.portfolio.admin.api.stories

import lt.e2.portfolio.admin.model.Stories
import lt.e2.portfolio.admin.service.stories.StoriesService
import spock.lang.Specification

class StoriesControllerSpec extends Specification {

    private StoriesService storiesService = Mock()

    private StoriesEndpoints controller

    def "setup"() {
        controller = new StoriesController(storiesService)
    }

    def "get stories data"() {
        given:
        final def mock = mockStoriesData()

        when:
        final def result = controller.getData()

        then:
        1 * storiesService.getData() >> mock

        and:
        mock == result
    }

    def "create stories data"() {
        given:
        final def request = mockStoriesData()

        when:
        final def result = controller.createData(request)

        then:
        1 * storiesService.createData(request) >> "1"

        and:
        result == "1"
    }

    def "update stories data"() {
        given:
        final def request = mockStoriesData()

        when:
        final def response = controller.updateData(request)

        then:
        1 * storiesService.updateData(request) >> Collections.emptyList()

        and:
        response == Collections.emptyList()
    }

    private List<Stories> mockStoriesData() {
        return List.of(
                new Stories("id1", "Story 1", "My story 1"),
                new Stories("id1", "Story 2", "My story 2")
        )
    }
}
