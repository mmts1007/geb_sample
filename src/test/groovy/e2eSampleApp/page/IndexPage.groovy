package e2eSampleApp.page

import geb.Page

class IndexPage extends Page {
    static url = 'http://192.168.99.100:3000/tasks'

    static at = { $('h1').text() == 'Tasks' }
}
