@Grab('org.codehaus.geb:geb-core:0.5.1')
@Grab('org.seleniumhq.selenium:selenium-htmlunit-driver:2.0a7')
import geb.Browser
 
Browser.drive("http://xlson.com/") {
    assert title == "Leonard Axelsson"
}