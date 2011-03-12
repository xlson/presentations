package democonsole

import java.awt.event.ActionEvent
class DemoConsoleController {
    GroovyShell shell = new GroovyShell()

    // these will be injected by Griffon
    def model
    def view

    def executeScript = { evt = null ->
        model.enabled = false
        doOutside {
            def result
            try {
                result = shell.evaluate(model.scriptSource)
            } finally {
                edt {
                    model.enabled = true
                    model.scriptResult = result
                }
            }
        }
    }
}