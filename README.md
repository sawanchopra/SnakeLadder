# Welcome to SnakeLadder


#Story #1:Basic Board 
On a board (Of size 100), for a Dice throw a player should move from initial position by the number on dice throw

Ans:-created SnakeAndLadderService with Size 100 (Line :-12,SnakeAndLadderService),
and Dice Service to roll on the dice with 1-6 values(Line :-6,Diceservic).



#Story #2:Add a snake on the board 
 snake moves a player from its start position to end position 
where start position > end position

Ans :- added setSnakes method to add snakes to the Board and Handled (Line :-37,SnakeAndLadderService)
       added the Logic for having Start Position > end position (Line :-53 ,SnakeAndLadderService)
	   
#Test Data Case Test data: Add a snake at position 14 moving the player to position 7

Ans :- Test Case Class added (Line :-25,SnakeladderApplicationTests) 
and test DataFile is Palced in (src/main/resources/testcase)

Sample Response highlighted when it went from 8 -> +4 =12 -> +2 ->14 
(but as 14 test data is given as snake start so it reaches snakes end-7)

sawan rolled a 6 and moved from 0 to 6
sawan rolled a 2 and moved from 6 to 8
#sawan rolled a 4 and moved from 8 to 12 -----
#sawan rolled a 2 and moved from 12 to 7 -----
sawan rolled a 4 and moved from 7 to 11

	   
	   
#Story #3: Make A Crooked Dice	   

A Dice that only throws Even numbers.
The can game can be started with normal dice or crooked 
dice

Ans:- Added a code to generate even number (2,4,6) (Line :-10,Diceservice),
      Added the Logic of having a flag to decide which dice to start the game 
	  (line :-40 ,SnakeladderApplication) ,(Line 96,SnakeAndLadderService )
	   
	   
	   

