import groovy.transform.*

@Immutable
class User {
	String name
	String lastname
}

def user = new User(name: 'Leo', lastname: 'Axelsson')

try {
	user.name = 'Anders'
} catch(ReadOnlyPropertyException e) {
	println("Changing a property of an Immutable object will not work.")
}


println user