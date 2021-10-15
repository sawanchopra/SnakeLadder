package com.example.snakeladder;

import com.example.snakeladder.models.Ladder;
import com.example.snakeladder.models.Player;
import com.example.snakeladder.models.Snake;
import com.example.snakeladder.service.SnakeAndLadderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SnakeladderApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of snakes needed in the board");
		int noOfSnakes = scanner.nextInt();
		List<Snake> snakes = new ArrayList<Snake>();
		for (int i = 0; i < noOfSnakes; i++) {
			System.out.println("enter the start and end values for snakes");
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}

	
		System.out.println("Enter the no of Ladders needed in the board");
		int noOfLadders = scanner.nextInt();
		List<Ladder> ladders = new ArrayList<Ladder>();
		for (int i = 0; i < noOfLadders; i++) {
			System.out.println("enter the start and end values for ladders");
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}
		
		System.out.println("enter the no of turns you want to play");
		int turns = scanner.nextInt();
		
		System.out.println("enter true for crooked dice else enter false");
		Boolean flag =scanner.nextBoolean();
		
		System.out.println("enter player Name");
		Player player=new Player(scanner.next());


		SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
		snakeAndLadderService.setPlayers(player);
		snakeAndLadderService.setSnakes(snakes);
		snakeAndLadderService.setLadders(ladders);

		snakeAndLadderService.startGame(flag,turns);
		//SpringApplication.run(SnakeladderApplication.class, args);
	}

}
