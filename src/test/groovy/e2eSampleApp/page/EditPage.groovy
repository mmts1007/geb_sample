package e2eSampleApp.page

import geb.Page

class EditPage extends Page {
    static at = { $('h1').text() == 'Edit Task' }
}
