import geb.spock.GebReportingSpec

class GebSample1Test extends GebReportingSpec {
    def 'Welcom ページが表示されるか'() {
        when: 'URL にアクセスした時'
        go 'http://192.168.99.100/'

        then: 'h1 タグに "It works!" と表示されるか'
        $('h1').text() == 'It works!'
    }
}
