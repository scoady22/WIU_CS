//Sean Coady
//Compute.java
import java.util.*;

//utility class, Compute, which performs the 4 operations that the MathQuiz advertises. (+,-,*,/)

public class Compute
{
 	//global variables  
	int score;
   int sum;
   int answer;
   int diff;
   int prod;
   double quotient;
   int wflag = 0; //flag that allows 2 attempts per question
   Scanner scanner = new Scanner(System.in);
  
  	 //adds passed in values of num1 and num2, and updates the score of the student
	 //each question is allowed 2 attempts, if the second attempt is incorrect,
	 //the program will print out the correct answer and move on.
    public void add(int num1, int num2,StudentRecord student)
	   {
		
	   	sum = num1+num2;
	   	System.out.println("What is "+num1+" + "+num2+" ?");
	   	answer = scanner.nextInt();
	   	if (answer == sum)
	   	{
	   		System.out.println("Correct!");
	   		score++;
	   		student.setScore(score);
	   	}
	   	else if(answer!= sum && wflag ==0)
         {
         System.out.println("Incorrect - one attempt remaining");
         wflag=1;
         add(num1,num2,student);
	   	}
         else
         {
	   		System.out.println("Sorry - incorrect. The answer was: "+sum);
				wflag=0;
         }
       
	   }
	   	
      //subtracts passed in values of num1 and num2, and updates the score of the student
	 	//each question is allowed 2 attempts, if the second attempt is incorrect,
	 	//the program will print out the correct answer and move on.    
		  public void subtract(int num1, int num2,StudentRecord student)
	   {
	   	int diff = num1-num2;
	   	System.out.println("What is "+num1+" - "+num2+" ?");
	   	answer = scanner.nextInt();
	   	if (answer == diff)
	   	{
	   		System.out.println("Correct!");
	   		score++;
	   		student.setScore(score);
	   	}
	   	else if(answer!= diff && wflag ==0)
         {
         System.out.println("Incorrect - one attempt remaining");
         wflag=1;
         add(num1,num2,student);
	   	}
         else
         {
	   		System.out.println("Sorry - incorrect. The answer was: "+diff);
				wflag=0;
         }
       
	   }
		
		 //multiplies passed in values of num1 and num2, and updates the score of the student
	    //each question is allowed 2 attempts, if the second attempt is incorrect,
	    //the program will print out the correct answer and move on.
        public void multiply(int num1, int num2,StudentRecord student)
	   {

	      prod = num1*num2;
	   	System.out.println("What is "+num1+" * "+num2+" ?");
	   	answer = scanner.nextInt();
	   	if (answer == prod)
	   	{
	   		System.out.println("Correct!");
	   		score++;
	   		student.setScore(score);
	   	}
	   	else if(answer!= prod && wflag ==0)
         {
         System.out.println("Incorrect - one attempt remaining");
         wflag=1;
         add(num1,num2,student);
	   	}
         else
         {
	   		System.out.println("Sorry - incorrect. The answer was: "+prod);
				wflag=0;
         }
       
       
	   }
       public void divide(int num1, int num2,StudentRecord student)
	   {
         double answer1;
	      quotient = num1/num2;
	   	System.out.println("What is "+num1+" / "+num2+" ?");
	   	answer1 = scanner.nextDouble();
	   	if (answer == quotient)
	   	{
	   		System.out.println("Correct!");
	   		score++;
	   		student.setScore(score);
	   	}
	   	else if(answer1!= quotient && wflag ==0)
         {
         System.out.println("Incorrect - one attempt remaining");
         wflag=1;
         add(num1,num2,student);
	   	}
         else
         {
	   		System.out.println("Sorry - incorrect. The answer was: "+quotient);
				wflag=0;
         }
       
        
	   }
 }