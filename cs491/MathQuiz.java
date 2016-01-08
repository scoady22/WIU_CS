//Sean Coady
//Programming Assignment 1
//10-30-13

import java.util.*;


public class MathQuiz
{
	//Creates a math quiz consisting of 10 questions, populated by randomly generated numbers.
   //Passes randomly generated numbers (num1,num2) into an instance of Compute (c) to perform the user-chosen type of quiz.
   //A player selects either addition, subtraction, multiplication, or division (operand).
   
   public static void main(String[] args)
	{
		//instance variables
      StudentRecord student = new StudentRecord();
      Compute c = new Compute();
		int operand;
		int num1;
		int num2;
		int score;
		int count=1;
		
      //declaring scanner for user input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in your name:");
		student.setName(scanner.nextLine());
      System.out.println("What type of quiz? 1. Addition 2. Subtraction 3. Multiplication 4. Division");
      operand = scanner.nextInt();
      
		//loop 10 times to complete the quiz
      //passes random numbers into the Compute instance with the chosen operation (1-4).
      //Prints out score after each question is answered.
		for(int i=0;i<=10;i++)
		{
			num1 = (int)((Math.random()* 100) - (Math.random()*100));
         num2 = (int) ((Math.random() * 100) - (Math.random() * 100));
         
         //addition
         if (operand == 1)
         {
    			System.out.println(count+". ");      
			   c.add(num1,num2,student);
            System.out.println("Current score: "+student.getScore());
				count++;
         }
         //subtraction
         else if( operand == 2)
         {
     			System.out.println(count+". ");          
			   c.subtract(num1,num2,student);
				System.out.println("Current score: "+student.getScore());
				count++;
         }
         //multiplcation
         else if(operand == 3)
         {
				System.out.println(count+". ");    
            c.multiply(num1,num2,student);
				System.out.println("Current score: "+student.getScore());
				count++;
         }
         //division
         else if(operand == 4)
         {
				System.out.println(count+". ");    
            c.divide(num1,num2,student);
				System.out.println("Current score: "+student.getScore());
				count++;
         }
       }
       //quiz finished. prints results.
       System.out.println("Quiz finished. Score for: "+student.getName()+", "+student.getScore()+" / 10");
       
         
    }    
}