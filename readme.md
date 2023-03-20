## Run the API
To test this API I have been using PostMan. Below are instructions of how to test each step of the game.
The requests will return a JSON with Game status och Player status.

## Play the game

### 1. Start Game
**Request**: POST

**URL**: localhost:8080/api/games

**JSON**: {"name": "Player1 Name"}

### 2. Player 2 joins
**Request**: PUT

**URL**: localhost:8080/api/games/{id}/join

**JSON**:{"name": "Player2 Name"}

### 3. Play move
**Request**: PUT

**URL**: localhost:8080/api/games/{id}/move

**JSON**: {"name": "Player Name","move": "paper"}

### 4. View Game status
**Request**: GET

**URL**:localhost:8080/api/games/{id}


## Areas of Improvement
Since this application is a proof of concept there are areas of improvement when developing the final product.
Below areas have been identified.

### Player ID
The players are identified by their name. In a larger application it is better if the user had a unique ID instead. 
Currently, two players can have the same username which would confuse the application.

### Multiple players
Traditionally Rock, Paper, Scissors is played by two players (as specified in the requirements of this project), but sometimes this type of game is played by more people. 
If that is a future requirement the players can be saved on the Game object as an ArrayList instead as two objects hence allowing a flexible number of players.