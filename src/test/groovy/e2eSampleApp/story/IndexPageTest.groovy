package e2eSampleApp.story

import e2eSampleApp.page.IndexPage
import geb.spock.GebReportingSpec

class IndexPageTest extends GebReportingSpec {
    def 'Index ページへ遷移すること'() {
        when:
        to IndexPage

        then:
        at IndexPage
    }
}
