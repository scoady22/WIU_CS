//Sean Coady
//CS 460(G)
//14 April 2014

import java.util.*;
import java.math.*;
import java.io.*;
public class GA
{
	public static void main(String[] args)
	{
		int popsize =8;
		int generation = 1;	
		generate(popsize,generation);
		
	}
   
	public static void generate(int popsize, int generation)
		{

			String[] pB = new String[popsize];
			int[] fitness = new int[popsize];
			int[] fitP = new int[popsize];
			double fitAvg = 0.0;
			double fitSum = 0.0;
			int fitMax = 0;
			double avg = 0.0;
			int max = 0;
			int sum = 0;
			int p[] = new int[popsize];
		  for(int i=0;i<popsize;i++)
		  {
		  		
				Random rand = new Random();
				p[i] = rand.nextInt(31);
				sum += p[i];
				fitness[i] = p[i]*p[i];
				fitSum += fitness[i];
				if( p[i] > max)
				{
					max = p[i];
					fitMax = fitness[i];
				}
				pB[i] = String.format("%5s", Integer.toBinaryString(p[i])).replace(' ', '0');

			}
			for(int k = 0; k<8;k++)
			{
				System.out.println("Population: "+pB[k]+" x = "+p[k]+" Fitness: "+fitness[k]);
			}
			
			avg = sum/popsize;
			fitAvg = fitSum/popsize;
			if(generation ==1)
			{
			System.out.println("______________________________________");
			System.out.println("Running totals for generation 1");
			System.out.println("______________________________________");
			System.out.println("Sum of x: "+sum);
			System.out.println("Sum of fitness values: "+ fitSum);
			System.out.println("______________________________________");
			System.out.println("Average of x: "+avg);
			System.out.println("Average of fitness values: "+fitAvg);
			System.out.println("______________________________________");
			System.out.println("Max value of x: "+max);
			System.out.println("Max value of f(x)=x^2 : "+fitMax);
			}
			selection(p,pB, fitness,popsize,generation);
		}
		
		public static void selection(int[] p,String [] pB, int[] fitness,int popsize,int generation)
		{
        
			int i,j,first,temp;
			int selectInt=0;
			int select = 0;
			int flag=0;
			int[] selectCount = new int[popsize];
			String[] selected = new String[popsize];
		   for(i=p.length-1;i>0;i--)
         {
            first =0;
            for(j=1;j<=i;j++)
            {
               if(p[j]<p[first])
                  first =j;
            }
            temp=p[first];
            p[first]=p[i];
            p[i]=temp;
         }
			   System.out.println("___________________________________________");
			   System.out.println("Selected for mating:  ");
			   for(int k = 0;k<popsize;k++)
			   {
				   selected[k] = String.format("%5s", Integer.toBinaryString(p[k])).replace(' ', '0');
				   System.out.println(selected[k] + "(x="+p[k]+")");	
			   }
			crossover(selected,popsize,generation);
		}
		
		public static void crossover(String[] selected,int popsize,int generation)
		{
			int crossoverPoint;
			int k=0;
         int crossed=0;
			String firstString;
			String secondString;
			String[] newGene = new String[8];
         System.out.println("___________________________________________");
         System.out.println("Children: ");
			System.out.println("___________________________________________");
					while (k < 7)
               {
						Random rand = new Random();
						crossoverPoint = rand.nextInt(5);   
						firstString = selected[k].substring(0,crossoverPoint);
						secondString = selected[k+1].substring(0+crossoverPoint, 5);
						//2 children produced
                  
						newGene[k] = new StringBuilder().append(firstString).append(secondString).toString();
                  newGene[k+1] = new StringBuilder().append(secondString).append(firstString).toString();
						System.out.println(newGene[k]+" = "+ selected[k]+" and "+selected[k+1]+" at crossover: "+crossoverPoint);
						System.out.println(newGene[k+1]+" = "+ selected[k+1]+" and "+selected[k]+" at crossover: "+crossoverPoint);
                  
                  if(k==6)
                  {
                     k++;
                  }
                  else
                  {
                  k = k+2;
                  }
                  crossed++;
					
					}
               mutation(newGene,popsize,generation);

	  }		
			public static void mutation(String[] newGene, int popsize,int generation)
			{
				//mutation prob 5% on each chromosome
				int mutationProb;
				//change string into char array to flip bits
				char[] newGeneChars = new char[5];
				String[] mutated = new String[8];
				String[] mutatedGene = new String[8];
				for(int i = 0; i<8; i++)
				{
					newGeneChars = newGene[i].toCharArray();	
					for(int k = 0; k<5; k++)
					{
						
							Random rand = new Random();
							mutationProb = rand.nextInt(20);
							if(mutationProb == 1)
							{
									if(newGeneChars[k] == '1')
									{
										newGeneChars[k] = '0';
									}
									else
									{
										newGeneChars[k] = '1';
									}
							}
							mutated[i] = String.valueOf(newGeneChars);
					 }
					
				}
				
				   System.out.println("_________________________________");
				   System.out.println("Updated genes after mutation: ");
				   for(int j = 0; j<8;j++)
				   {
					   System.out.println(mutated[j]);
				   }
				      System.out.println("_________________________________");
			         checkSolution(mutated,popsize,generation);	
            
				
				
		   }
		public static void checkSolution(String[] mutated,int popsize,int generation)
		{
			int[] dec = new int[popsize];
			
			int[] mutatedFitness = new int[popsize];
			double newAvg=0.0;
			double newFitAvg=0.0;
			int newMax=0;
			int newFitMax=0;
			int newSum =0;
			int newFitSum =0;
         //binary conversion
			for(int i = 0; i<8;i++)
			{
					if(mutated[i].charAt(0) == '1')
					{
						dec[i]+=16;
					}
					if(mutated[i].charAt(1) == '1')
					{
						dec[i]+=8;
					}
					if(mutated[i].charAt(2) =='1')
					{
						dec[i]+=4;
					}
					if(mutated[i].charAt(3) == '1')
					{
						dec[i]+=2;
					}
					if(mutated[i].charAt(4) == '1')
					{
						dec[i]+=1;
					}
			}
			for(int k=0;k<8;k++)
			{
				newSum += dec[k];
				mutatedFitness[k] = dec[k]*dec[k];
				newFitSum += mutatedFitness[k];
				if( dec[k] > newMax)
				{
					newMax = dec[k];
					newFitMax = mutatedFitness[k];
				}
			}
			
			newAvg = newSum/8;
			newFitAvg = newFitSum/8;
			for(int i = 0; i<8;i++)
			{
				System.out.println("Population: "+mutated[i]+" x = "+dec[i]+" Fitness: "+mutatedFitness[i]);
			
			}
			if(newAvg >= 29)
			{
				System.out.println("Solution found with genes: ");
				for(int l = 0; l<8; l++)
				{
					System.out.println(mutated[l] +" , x= "+dec[l]+" , fitness: "+mutatedFitness[l]);
				}
			
				
			System.out.println("______________________________________");
			System.out.println("New Totals: ");
			System.out.println("______________________________________");
			System.out.println("Sum of x: "+newSum);
			System.out.println("Sum of fitness values: "+ newFitSum);
			System.out.println("______________________________________");
			System.out.println("Average of x: "+newAvg);
			System.out.println("Average of fitness values: "+newFitAvg);
			System.out.println("______________________________________");
			System.out.println("Max value of x: "+newMax);
			System.out.println("Max value of f(x)=x^2 : "+newFitMax);
			System.out.println("______________________________________");;
			}
			else
			{
			generation++;
			
			selection(dec, mutated, mutatedFitness, popsize, generation);
			}
	}
 }		



			

			
				
	
	