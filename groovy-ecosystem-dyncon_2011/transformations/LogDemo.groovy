import groovy.util.logging.*

@Log
class LogDemo {
	
	def usesLogger() {
		log.info "Uses the log annotation."
	}
	
	static void main(String[] args) {
		new LogDemo().usesLogger()
	}
}