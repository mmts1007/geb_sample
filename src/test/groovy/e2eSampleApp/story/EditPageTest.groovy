package e2eSampleApp.story

import e2eSampleApp.page.DetailPage
import e2eSampleApp.page.EditPage
import e2eSampleApp.page.IndexPage
import geb.spock.GebReportingSpec

class EditPageTest extends GebReportingSpec {
    def 'Edit ボタンを押した時 Edit ページへ遷移すること'() {
        given:
        to IndexPage

        when:
        $('a', text: 'Edit')[0].click()

        then:
        waitFor { at EditPage }
    }

    def 'Update Task ボタンを押した時 Task が更新され、Detail ページへ遷移すること'() {
        def time = System.currentTimeMillis()

        given:
        go 'http://192.168.99.100:3000/tasks/1/edit'

        when:
        $('#task_name').value("update_task_name_$time")
        $('#task_description').value("update_task_description_$time")
        $('#task_create_by').value("update_create_by_$time")
        $('input', value: 'Update Task').click()

        then:
        waitFor { at DetailPage }
        $('dd', text: "update_task_name_$time").isDisplayed()
        $('dd', text: "update_task_description_$time").isDisplayed()
        $('dd', text: "update_create_by_$time").isDisplayed()
    }

    def 'Cancel ボタンを押した時 Index に遷移すること'() {
        given:
        go 'http://192.168.99.100:3000/tasks/1/edit'

        when:
        $('a', text: 'Cancel').click()

        then:
        waitFor { at IndexPage }
    }
}
