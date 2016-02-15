package e2eSampleApp.page

import geb.Page

class CreatePage extends Page {
    static url = 'http://192.168.99.100:3000/tasks/new'

    static at = { $('h1').text() == 'New Task' }
}