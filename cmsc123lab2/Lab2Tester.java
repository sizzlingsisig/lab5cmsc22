package cmsc123lab2;
//LABORATORY EXERCISE NO. 2 TESTER
//Created by: Jayvee B. Castañeda

//!!! W A R N I N G !!!
//DO NOT EDIT THE CONTENTS OF THIS FILE UNLESS PROMPTED TO DO SO
//ANY UNSOLICITED MODIFICATIONS TO THIS FILE WILL RESULT TO A SCORE OF '0' IN THIS EXERCISE

import java.util.Scanner;
import java.util.Random;

public class Lab2Tester{

	public static String randomString(){
		Random rng = new Random();
		int length = 15;
		String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "!@#$%^&*+-/=?,.";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++){
	        text[i] = allChars.charAt(rng.nextInt(allChars.length()));
	    }
	    return new String(text);
	}

	// ArrayStack Tester
	public static void ArrayStackTest() throws NullPointerException{
		int score = 0;
		int TOTAL = 50;
		ArrayStack testArray = new ArrayStack(5);
		
		// Initial Test for 'size'
		try{
			if (testArray.isEmpty()){
				score+=2;
			}
		}catch(Exception e){
			System.out.println("ERROR: Problem initializing stack!" + e);
			return;
		}

		String[] randStrings = new String[10];
		// Initial Test for 'push()'
		try{
			for (int i=0; i<10; i++){
				randStrings[i] = randomString();
				testArray.push(randStrings[i]);
			}

			if (testArray.getSize() == 10){
				score+=2;
			}
		}catch(Exception e){
			System.out.println("ERROR: push() is not pushing! " + e);
			return;
		}
		try{
			int testArraySize = testArray.getSize();
			for (int i=0; i<testArraySize; i++){
				if ((testArray.getContents()[i]).getValue() == randStrings[testArraySize-i-1]){
					score+=1;
				}
			}
		}catch(Exception e){
			System.out.println("ERROR: push() not working properly! " + e);
			return;
		}

		for (int i=0; i<10; i++){
			testArray.pop();
		}

		randStrings = new String[10];
		for (int i=0; i<10; i++){
			randStrings[i] = randomString();
			testArray.push(randStrings[i]);
		}

		int testArraySize = testArray.getSize();
		for (int i=0; i<testArraySize; i++){
			if ((testArray.getContents()[i].getValue()) == randStrings[testArraySize-i-1]){
				score+=2;
			}
		}

		for (int i=0; i<5; i++){
			int prevSize = testArray.getSize();
			String toPop = testArray.top().getValue();
			String removed = testArray.pop().getValue();

			try {
				if (testArray.getSize() == (prevSize - 1)){
					score+=1;
				}
				if (toPop == removed){
					score+=1;
				}
				if (randStrings[prevSize-1] == removed){
					score+=1;
				}
			}catch(Exception e){
				System.out.println("ERROR: pop() not working properly! " + e);
			}
		}

		for (int i=5; i<10; i++){
			testArray.pop();
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

	// SLL Tester
	public static void SLLStackTest() throws NullPointerException{
		float score = 0;
		int TOTAL = 50;
		SLLStack testSLL = new SLLStack();
		
		if (testSLL.isEmpty()){
			score+=2;
		}
		try {
			String top = testSLL.top().getValue();
		} catch (NullPointerException exception){
			score+=4;
		}

		String[] randStrings1 = new String[10];
		for (int i=0; i<10; i++){
			randStrings1[i] = randomString();
			testSLL.push(randStrings1[i]);
		}

		if (testSLL.getSize() == 10){
			score+=3;
		}

		int i = 0;
		SLLNode current = testSLL.top();
		if (current.getValue() == randStrings1[i]){
			while (current != null){
				if (current.getValue() == randStrings1[i]){
					score+=1;
					current = current.getNext();
					i+=1;
				}
			}
		} else if (current.getValue() == randStrings1[9]){
			while (current != null){
				if (current.getValue() == randStrings1[10-i-1]){
					score+=1;
					current = current.getNext();
					i+=1;
				}
			}
		}
		
		i = 0;
		randStrings1 = new String[10];
		current = testSLL.top();

		while (current != null){
			randStrings1[i] = randomString();
			current.setValue(randStrings1[i]);
			current = current.getNext();
			i+=1;
		}

		i = 0;
		current = testSLL.top();
		while (current != null){
			if (current.getValue() == randStrings1[i]){
				score+=1;
				current = current.getNext();
				i+=1;
			}
		}

		for (i=0; i<5; i++){
			int prevSize = testSLL.getSize();
			SLLNode removed = testSLL.pop();
			if (testSLL.top() != null){
				if (removed.getValue() == randStrings1[i]){
					score+=1;
				}
				if (removed.getNext() == null){
					score+=0.5;
				}
				if (testSLL.top().getValue() != randStrings1[i]){
					score+=1;
				}
				if (testSLL.getSize() == (prevSize - 1)){
					score+=0.5;
				}
			}
		}

		for (i=5; i<10; i++){
			testSLL.pop();
		}

		if (testSLL.isEmpty()){
			score+=2;
		}

		try {
			String top = testSLL.top().getValue();
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
		System.out.println("LABORATORY EXERCISE #2 TESTER\nOptions:\n1 - Array Stack\n2 - SLL Stack\n* - Exit");
		System.out.print("Choice:");
		int choice = scanner.nextInt();

		if (choice == 1){
			ArrayStackTest();
		}
		else if (choice == 2){
			SLLStackTest();
		}
		else{
			System.exit(0);
		}
	}
}