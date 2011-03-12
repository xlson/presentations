import groovy.transform.*

@EqualsAndHashCode
class User {
	String name
	String lastname
}

def user1 = new User(name: 'Leo', lastname: 'Axelsson')
def user2 = new User(name: 'Leo', lastname: 'Axelsson')

assert user1 == user2
