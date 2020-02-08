# rock-paper-scissor

Developed with Spring Boot.

Start game by writing in command line: mvn spring-boot:run\
Repackage with: mvn clean install spring-boot:repackage

# Create a game

Open up the Postman application.\
Make a POST request to localhost:8080/api/games\
In the POST request, send a JSON with your chosen name.

Example:\
{\
	"name": "Bob"\
}

A body/message will be returned in form of a long integer, might contain i minus value.\
This will be your game {id}.

Example of return value:\
4525303663931966310

# Join a game

Create another POST request in Postman, target adress:  localhost:8080/api/games/{id}/join\
In this example, {id} would be replaced with 4525303663931966310.

In the post request, include a JSON with a chosen name.

Example:\
{\
	"name": "Alice"\
}

Either one of those three strings will be returned:\
"Successfully joined the game!" -> This means the post request was succsesfull.\
"Name already taken!" -> Player one might have taken your chosen name already.\
"Sorry, this lobby is full!" -> Two players are already in the game.

# Make a move

Create another POST request in Postman, target adress:  localhost:8080/api/games/{id}/move\
In this example, it would map to localhost:8080/api/games/4525303663931966310/move

Include name and a move with either Rock, Paper och Scissors in your post request.

Example:\
{\
	"name": "Alice",\
	"move": "Rock"\
}

A return value will be received in form of a string:\
"Not a valid move!" -> This means you entered an invalid move. \
"Move added!" -> Your move was added successfully.\
"Game started!" -> Game starts if both players has entered their moves.

# Check game state

To check the current status, enter a GET request in postman: localhost:8080/api/games/{id}

This will return a string explaining the current status of the game.\
Nothing has to be added along the request, the winner will be mentioned with his or her name.

Example:\
"Bob won!"

The status is always available to you once a game has been initialized. 



