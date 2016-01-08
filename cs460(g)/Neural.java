import java.util.Scanner;

//Sean Coady
//Homework 6 - Neural Networks
//19 April 2014

public class Neural
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		double n1 =0.0;
		double n2=0.0;
		int threshold=0;
		double learning=0.0;
		int epoch;
		int op =0;
		System.out.println("Enter n1: ");
		n1 =scanner.nextDouble();
		System.out.println("Enter n2: ");
		n2 = scanner.nextDouble();
		System.out.println("Enter threshold value: ");
		threshold = scanner.nextInt();
		System.out.println("Enter learning coefficient: ");
		learning = scanner.nextDouble();
		System.out.println("Operation: ");
		op = scanner.nextInt();
		
		epoch = 1;
		if(op==1)
		{
			findSolution(n1,n2,threshold,learning,epoch);
		}
		else if(op ==2)
		{
			findAndSolution(n1,n2,threshold,learning,epoch);
		}
		else if(op==3)
		{
			findNorSolution(n1,n2,threshold,learning,epoch);
			
		}
		else if(op==4)
		{
			findNegNorSolution(n1,n2,threshold,learning,epoch);
			
		}
		scanner.close();
	}

	private static void findNegNorSolution(double n1, double n2, int threshold,
			double learning, int epoch) {
		// TODO Auto-generated method stub
		int i=0;
		int[] answer = new int[4];
		double [] w1 = new double[4];
		double [] w2 = new double[4];
		for(i=0;i<4;i++)
		{
			if(i==0)
			{
				if(n1+n2 > threshold)
				{
					n1-= learning;
					n2-= learning;
					w1[i]=learning;
					w2[i]=learning;
					answer[i]=0;
					epoch++;
					System.out.println("Input: (0,0) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
				else
				{
					System.out.println("Input: (0,0) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
					w1[i] = n1;
					w2[i]= n2;
					answer[i]=1;
					
				}
				if(i==1)
				{
					n2+=learning;
					w1[i]=n1;
					w2[i] = n2;
					answer[i]=0;
					System.out.println("Input: (0,1) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
					
				}
				if(i==2)
				{
					n1+=learning;
					w1[i]=n1;
					w2[i]=n2;
					answer[i]=0;
					System.out.println("Input: (1,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
				//1,1
				if(i==3)
				{
					System.out.println("Epoch #"+epoch+" :");
					answer[0]=0;
					w1[i] = n1;
					w2[i] = n2;
					answer[i]=0;
					System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
			}
		}
		if(answer[0] == 1 && answer[1] == 0 && answer[2] == 0 && answer[3] == 0)
		{
			printNorSolution(w1,w2,epoch);
		}
		else
		{
			if(epoch < 20)
			{
			
			findNegNorSolution(n1,n2,threshold,learning,epoch);
			}
			else
			{
				System.out.println("Unable to find solution after 20 epochs. Final Solutions After 20 Epochs:");
				printNorSolution(w1,w2,epoch);
				
			}
			}
	}

	private static void findNorSolution(double n1, double n2, int threshold,
			double learning, int epoch) {
		// TODO Auto-generated method stub
		int i=0;
		int[] answer = new int[4];
		double [] w1 = new double[4];
		double [] w2 = new double[4];
		for(i=0;i<4;i++)
		{
			if(i==0)
			{
				if(n1+n2 < threshold)
				{
					n1+= learning;
					n2+= learning;
					w1[i]=learning;
					w2[i]=learning;
					answer[i]=0;
					epoch++;
					System.out.println("Input: (0,0) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
				else
				{
					System.out.println("Input: (0,0) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
					w1[i] = n1;
					w2[i]= n2;
					answer[i]=1;
					
				}
				if(i==1)
				{
					n2+=learning;
					w1[i]=n1;
					w2[i] = n2;
					answer[i]=0;
					System.out.println("Input: (0,1) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
					
				}
				if(i==2)
				{
					n1+=learning;
					w1[i]=n1;
					w2[i]=n2;
					answer[i]=0;
					System.out.println("Input: (1,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
				//1,1
				if(i==3)
				{
					System.out.println("Epoch #"+epoch+" :");
					answer[0]=0;
					w1[i] = n1;
					w2[i] = n2;
					answer[i]=0;
					System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
			}
		}
		if(answer[0] == 1 && answer[1] == 0 && answer[2] == 0 && answer[3] == 0)
		{
			printNorSolution(w1,w2,epoch);
		}
		else
		{
			if(epoch < 20)
			{
			
			findNorSolution(n1,n2,threshold,learning,epoch);
			}
			else
			{
				System.out.println("Unable to find solution after 20 epochs. Final Solutions After 20 Epochs:");
				printNorSolution(w1,w2,epoch);
				
			}
			}
	}

	private static void printNorSolution(double[] w1, double[] w2, int epoch) {
		// TODO Auto-generated method stub
		System.out.println("Solution Found in "+epoch+" epochs!");
		for(int i=0; i<4; i++)
		{
			if(i==0)
			{
				System.out.println("Input: (0,0) || Target Output: 1 || Actual Output: "+1+" || Final Weights: ("+ w1[0]+","+w2[0]+")");
			}
			else if(i==1)
			{
				System.out.println("Input: (0,1) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[0]+","+w2[0]+")");
			}
			else if(i==2)
			{
				System.out.println("Input: (1,0) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[0]+","+w2[0]+")");
			}
			else if(i==3)
			{
				System.out.println("Input: (1,1) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[0]+","+w2[0]+")");
			}
		}
	}

	private static void findAndSolution(double n1, double n2, int threshold,
			double learning, int epoch) {
		// TODO Auto-generated method stub
		int i=0;
		int[] answer = new int[4];
		double [] w1 = new double[4];
		double [] w2 = new double[4];
		for(i=0;i<4;i++)
		{
			//0,0
			if(i==0)
			{
				System.out.println("Epoch #"+epoch+" :");
				answer[0]=0;
				w1[i] = n1;
				w2[i] = n2;
				answer[i]=0;
				System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
			}
			//0,1
			if(i==1)
			{
				n2+=learning;
				w1[i]=n1;
				w2[i]=n2;
				answer[i]=0;
				System.out.println("Input: (0,1) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
			}
			if(i==2)
			{
				n1+=learning;
				w1[i]=n1;
				w2[i] = n2;
				answer[i]=0;
				System.out.println("Input: (1,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				
			}
			if(i==3)
			{
				if(n1+n2 < threshold)
				{
					n1+= learning;
					n2+= learning;
					w1[i]=learning;
					w2[i]=learning;
					answer[i]=0;
					epoch++;
					System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
				}
				else
				{
					System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
					w1[i] = n1;
					w2[i]= n2;
					answer[i]=1;
					printAndSolution(w1,w2, epoch);
					
				}
			}
		}
		if(answer[0] == 0 && answer[1] == 0 && answer[2] == 0 && answer[3] == 1)
		{
			printAndSolution(w1,w2,epoch);
		}
		else
		{
			findAndSolution(n1,n2,threshold,learning,epoch);
		}
		
	}
	private static void printAndSolution(double[] w1, double[] w2, int epoch)
	{
		
		System.out.println("Solution Found in "+epoch+" epochs!");
		for(int i=0; i<4; i++)
		{
			if(i==0)
			{
				System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==1)
			{
				System.out.println("Input: (0,1) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==2)
			{
				System.out.println("Input: (1,0) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==3)
			{
				System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+1+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
		}
		
	}

	//recursively increment weights until function has output of 0111 (OR)
	//prints out results of n1,n2 (weights) when this criteria has been satisfied
	public static void findSolution(double n1, double n2, int threshold, double learning, int epoch)
	{
			
			//case 0 = 0,0 case 1 = 0,1 case 2 = 1,0 case 3 = 1,1
		    int i=0;
		    int[] answer = new int[4];
		    double [] w1= new double[4];
		    double[] w2 = new double[4];
		    
			for(i =0; i<4;i++)
			{
				
					//0,0
					if(i==0)
					{
						System.out.println("Epoch #"+epoch+" :");
						answer[0]=0;
						w1[i] = n1;
						w2[i] = n2;
						System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
					}
					//0,1
					if(i==1)
					{
						if((n2) < threshold)
						{
							n2 += learning;
							w1[i] = n1;
							w2[i] = n2;
							System.out.println("Input: (0,1) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
						}
						else
						{
							w1[i] = n1;
							w2[i] = n2;
							System.out.println("Input: (0,1) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
							answer[1] = 1;
						}				
					}		
					//1,0
					if(i==2)
					{
						if((n1) < threshold)
						{
							n1 += learning;
							w1[i] = n1;
							w2[i] = n2;
							System.out.println("Input: (1,0) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
						}
						else
						{
							System.out.println("Input: (1,0) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
							w1[i] = n1;
							w2[i] = n2;
							answer[2] = 1;
						}			
					}
					
					//1,1
					if(i==3)
					{
						if((n1+n2) < threshold)
						{
							n1 += learning;
							n2 += learning;
							w1[i] = n1;
							w2[i] = n2;
							System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+0+" || Updated Weights: ("+ n1+","+n2+")");
							epoch++;	
						}
						else
						{
							System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+1+" || Updated Weights: ("+ n1+","+n2+")");
							w1[i] = n1;
							w2[i] = n2;
							answer[3]=1;
							epoch++;
						}		
					}
			}
			if(answer[0] == 0 && answer[1] == 1 && answer[2] == 1 && answer[3] == 1)
			{
				printSolution(w1,w2,epoch);
			}
			else
			{
				findSolution(n1,n2,threshold,learning,epoch);
			}
		}

	private static void printSolution(double[] w1, double[] w2, int epoch) {
		// TODO Auto-generated method stub
		
		System.out.println("Solution Found in "+epoch+" epochs!");
		for(int i=0; i<4; i++)
		{
			if(i==0)
			{
				System.out.println("Input: (0,0) || Target Output: 0 || Actual Output: "+0+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==1)
			{
				System.out.println("Input: (0,1) || Target Output: 1 || Actual Output: "+1+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==2)
			{
				System.out.println("Input: (1,0) || Target Output: 1 || Actual Output: "+1+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
			else if(i==3)
			{
				System.out.println("Input: (1,1) || Target Output: 1 || Actual Output: "+1+" || Final Weights: ("+ w1[i]+","+w2[i]+")");
			}
		}
		
	}
}