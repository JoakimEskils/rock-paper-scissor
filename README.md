# rock-paper-scissor

Developed with Spring Boot.

Start game by writing in command line: mvn spring-boot:run
Repackage with: mvn clean install spring-boot:repackage

# Create a game

Open up the Postman application.
Make a post request to localhost:8080/api/games
In the post request, send a JSON with your chosen name.

Example:
{
	"name": "Bob"
}

A body/message will be returned in form of a long integer, might contain i minus value.
This will be your game {id}.

Example of return value:
4525303663931966310

# Join a game

Create another post request in Postman, target adress:  localhost:8080/api/games/{id}/join
In this example, {id} would be replaced with 4525303663931966310.

In the post request, include a JSON with a chosen name.

Example:
{
	"name": "Alice"
}

Either one of those three strings will be returned:
"Successfully joined the game!" -> This means your post request was succsesfull, thus you joined the game.
"Name already taken!" -> Player one might have taken your chosen name already.
"Sorry, this lobby is full!" -> Two players are already in the game.



