package cmsc123lab3;

// LABORATORY EXERCISE NO. 3 TESTER
// Created by: Jayvee B. Castañeda

// !!! W A R N I N G !!!
// DO NOT EDIT THE CONTENTS OF THIS FILE UNLESS PROMPTED TO DO SO
// ANY UNSOLICITED MODIFICATIONS TO THIS FILE WILL RESULT TO A SCORE OF '0' IN THIS EXERCISE

import java.util.Scanner;
import java.util.Random;

public class Lab3Tester{

	public static String randomString(){
		Random rng = new Random();
		int length = 25;
		String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "!@#$%^&*+-/=?,.";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++){
	        text[i] = allChars.charAt(rng.nextInt(allChars.length()));
	    }
	    return new String(text);
	}

	// ArrayQueue Tester
	public static void ArrayQueueTest() throws NullPointerException{
		int score = 0;
		int TOTAL = 50;
		ArrayQueue testArray = new ArrayQueue(5);
		
		// Initial Test for 'size'
		try{
			if (testArray.isEmpty()){
				score+=2;
			}
		}catch(Exception e){
			System.out.println("ERROR: Problem initializing queue!" + e);
			return;
		}

		String[] randStrings = new String[10];
		// Initial Test for 'enqueue()'
		try{
			for (int i=0; i<10; i++){
				randStrings[i] = randomString();
				testArray.enqueue(randStrings[i]);
			}

			if (testArray.getSize() == 10){
				score+=2;
			}
		}catch(Exception e){
			System.out.println("ERROR: enqueue() is not enqueueing! " + e);
			return;
		}

		try{
			int testArraySize = testArray.getSize();
			for (int i=0; i<testArraySize; i++){
				if ((testArray.getContents()[i]).getValue() == randStrings[i]){
					score+=1;
				}
			}
		}catch(Exception e){
			System.out.println("ERROR: enqueue() not working properly! " + e);
			return;
		}

		for (int i=0; i<10; i++){
			testArray.dequeue();
		}

		randStrings = new String[10];
		for (int i=0; i<10; i++){
			randStrings[i] = randomString();
			testArray.enqueue(randStrings[i]);
		}

		int testArraySize = testArray.getSize();
		for (int i=0; i<testArraySize; i++){
			if ((testArray.getContents()[i].getValue()) == randStrings[i]){
				score+=2;
			}
		}

		for (int i=0; i<5; i++){
			int prevSize = testArray.getSize();
			String dequeued = testArray.front().getValue();
			String removed = testArray.dequeue().getValue();

			try {
				if (testArray.getSize() == (prevSize - 1)){
					score+=1;
				}
				if (dequeued == removed){
					score+=1;
				}
				if (randStrings[i] == removed){
					score+=1;
				}
			}catch(Exception e){
				System.out.println("ERROR: dequeue() not working properly! " + e);
			}
		}

		for (int i=5; i<10; i++){
			testArray.dequeue();
		}

		if (testArray.isEmpty()){
			score+=1;
		}

		System.out.println("Your TOTAL SCORE is " + score + "/" + TOTAL + ".");
		System.out.println("Percentage: " + (score*100/TOTAL) + "%");
		if (score == TOTAL){
			System.out.println("PERFECT SCORE!!!");
		}	
	}

	// SLLQueue Tester
	public static void SLLQueueTest() throws NullPointerException{
		float score = 0;
		int TOTAL = 50;
		SLLQueue testSLL = new SLLQueue();
		
		if (testSLL.isEmpty()){
			score+=2;
		}
		try {
			String front = testSLL.front().getValue();
		} catch (NullPointerException exception){
			score+=4;
		}

		String[] randStrings1 = new String[10];
		for (int i=0; i<10; i++){
			randStrings1[i] = randomString();
			testSLL.enqueue(randStrings1[i]);
		}

		if (testSLL.getSize() == 10){
			score+=3;
		}

		int i = 0;
		SLLNode current = testSLL.front();
		if (current.getValue() == randStrings1[i]){
			while (current != null){
				if (current.getValue() == randStrings1[i]){
					score+=1;
				}
				current = current.getNext();
				i+=1;
			}
		}
		
		i = 0;
		randStrings1 = new String[10];
		current = testSLL.front();

		while (current != null){
			randStrings1[i] = randomString();
			current.setValue(randStrings1[i]);
			current = current.getNext();
			i+=1;
		}

		i = 0;
		current = testSLL.front();
		while (current != null){
			if (current.getValue() == randStrings1[i]){
				score+=1;
				current = current.getNext();
				i+=1;
			}
		}

		for (i=0; i<5; i++){
			int prevSize = testSLL.getSize();
			SLLNode removed = testSLL.dequeue();
			if (testSLL.front() != null){
				if (removed.getValue() == randStrings1[i]){
					score+=1;
				}
				if (removed.getNext() == null){
					score+=0.5;
				}
				if (testSLL.front().getValue() != randStrings1[i]){
					score+=1;
				}
				if (testSLL.getSize() == (prevSize - 1)){
					score+=0.5;
				}
			}
		}

		for (i=5; i<10; i++){
			testSLL.dequeue();
		}

		if (testSLL.isEmpty()){
			score+=2;
		}

		try {
			String front = testSLL.front().getValue();
		} catch (NullPointerException exception){
			score+=4;
		}

		System.out.println("Your TOTAL SCORE is " + score + "/" + TOTAL + ".");
		System.out.println("Percentage: " + (score*100/TOTAL) + "%");
		if (score == TOTAL){
			System.out.println("PERFECT SCORE!!!");
		}
	}


	// Main
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("LABORATORY EXERCISE #3 TESTER\nOptions:\n1 - Array Queue\n2 - SLL Queue\n* - Exit");
		System.out.print("Choice:");
		int choice = scanner.nextInt();

		if (choice == 1){
			ArrayQueueTest();
		}
		else if (choice == 2){
			SLLQueueTest();
		}
		else{
			System.exit(0);
		}
	}
}