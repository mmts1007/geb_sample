package e2eSampleApp.story

import e2eSampleApp.page.CreatePage
import e2eSampleApp.page.DetailPage
import e2eSampleApp.page.IndexPage
import geb.spock.GebReportingSpec

class CreatePageTest extends GebReportingSpec {
    def 'New ボタンを押した時 Create ページへ遷移すること'() {
        given:
        to IndexPage

        when:
        $('a', text: 'New').click()

        then:
        waitFor { at CreatePage }
    }

    def 'Create Task ボタンを押した時 Task が作成されること'() {
        def time = System.currentTimeMillis()

        given:
        to CreatePage

        when:
        $('#task_name').value("task_name_$time")
        $('#task_description').value("task_description_$time")
        $('#task_create_by').value("mmts1007_$time")
        $('input', value: 'Create Task').click()

        then:
        waitFor { at DetailPage }
        $('dd', text: "task_name_$time").isDisplayed()
        $('dd', text: "task_description_$time").isDisplayed()
        $('dd', text: "mmts1007_$time").isDisplayed()
    }

    def 'Cancel ボタンを押した時 Index に遷移すること'() {
        given:
        to CreatePage

        when:
        $('a', text: 'Cancel').click()

        then:
        waitFor { at IndexPage }
    }
}