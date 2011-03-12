@Grab('org.spockframework:spock-core:0.5-groovy-1.8')
@GrabExclude('org.codehaus.groovy:groovy-all:1.8.0-beta-3')
import spock.lang.*

class UnrolledSpec extends Specification {
	
	@Unroll({"The sum of $a and $b should be $sum."})
	def "All is well in math-land"() {
		expect:
		sum == a + b
		
		where:
		a	| b	| sum
		1	| 5	| 6
		6	| 2	| 8
		10	| 2 | 11
	}
}