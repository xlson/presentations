// Normal string
String message = 'got $5?'

// Double quoted string supports macros
String longerMessage = "Have you $message"

// Multiline strings available as well
String email = """Hi!
How are you?

/Leo"""

println message
println longerMessage
println email
