@Grab('org.codehaus.geb:geb-core:0.5.1')
@Grab('org.seleniumhq.selenium:selenium-firefox-driver:2.0a7')
import geb.Browser
 
Browser.drive("http://google.se/") {
	assert title == 'Google'
	$("input", name: "q").value("Dyncon 2011")
	$("input", name: "btnG").click()

	waitFor { title.startsWith("Dyncon 2011") }

	def firstLink = $("li.g", 0).find("a.l")
    assert firstLink.text() == "Dyncon 2011"
	firstLink.click()
}