package e2eSampleApp.page

import geb.Page

class DetailPage extends Page {
    static at = { $('h1').text() == 'Task' }
}
