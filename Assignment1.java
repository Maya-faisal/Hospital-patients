package Assignment1;
import java.util.Scanner;


public class Assignment1 {
	
	public static double[] summary (double [][] a)      /* define the summary method*/
	{
		double [] answer = new double[3];              /* create an array to return min , max , and avg*/
		
		double max = 0;                                /* initialize the maximum*/
		
		for(int i = 0 ; i < a.length ; i++)            /* for loop to find the maximum*/
		{
			for(int j = 0 ; j < a[i].length ; j++)
			{
				if(a[i][j] > max)
				{
					max = a[i][j];           
				}
			}
		}
		
		double min = 50;                               /* initialize the minimum*/
		
		for(int i = 0 ; i < a.length ; i++)            /* for loop to find the minimum*/
		{
			for(int j = 0 ; j < a[i].length ; j++)
			{
				if(a[i][j] < min)
				{
					min = a[i][j];
				}
			}
		}
		
		double average = 0;
		double sum = 0;
		int count = 0 ;                               /* counter to find the number of all temperatures entered*/
		
		for(int i = 0 ; i < a.length ; i++)           /*for loop to find the sum of all entered temperatures*/
		{
			for(int j = 0 ; j < a[i].length ; j++)
			{
				sum += a[i][j];
				count++;
			}
		}
		
		average = sum/count;                         /* calculate the average*/
		
		answer[0]= max;                              /*set the first element in the answer array = max index 0*/
		answer[1] = min;                             /* the second element min , index 1*/
		answer[2]= average;                          /* the third element avg , index 2*/
		
		return answer;                               /* return the array that contains max min avg*/
		
	}
	
	public static int [] countbelowaboveaverage (double [][]a)      /* define the second method*/
	{
		
		int below = 0 ;
		int above = 0 ;
		double [] ans = summary(a);                      /* call the summary method that returns  array contains max min avg*/
		
		double average = ans[2];                         /* get the third element that contains the avg from summary method*/
		
		int [] belowabove = new int[2];                  /* create belowabove array*/

	for(int i = 0 ; i < a.length ; i++)                  /* for loop to find how many temperatures below\above avg*/
	{
		for(int j = 0 ; j < a[i].length ; j++)
		{
			if(a[i][j] <= average)
			{
				below++;                                /* below counter*/
			}
			
			else
			{
				above++;                                /* above counter*/
			} 
				
		}
		  
	}
	    belowabove[0]= below;                         /* set the first element in belowabove array to #of below , index 0*/
	    belowabove[1] = above;                        /* the second element = #of above , index 1*/
	    
	    return belowabove;                            /* return the array that contains how many below and above*/
		
	}
	
	public static void sortarray (double [][]a)                         /* define the sorting method*/
	{
	   for(int i = 0 ; i < a.length ; i++)                              /* for loop to sort the array in ascending order*/
	   {
		   for(int j = 0 ; j < a[i].length ; j++)
		   {  
			   for( int x = 0 ; x < a[i].length - j - 1 ; x++)          /* loop to sort according to a row (per day)*/
			   {
				   if( a[i][x] > a[i][x+1])
				   {
					   double var = a[i][x];                            /* swap*/
					   a[i][x] = a[i][x+1];
					   a[i][x+1] = var;
					   
				   }
			   }
		   }
	   }
	
	}
	
	public static void printarray(double [][]a)                          /* define the sorted array printer method*/
	{
		sortarray(a);                                                    /* call the sort method to get the sorted array*/
		
		System.out.println("Temperatures in ascending order (per day):");
		
		for(int i = 0 ; i < a.length ; i++)                             /* loop to print the sorted array*/
		{
			System.out.print(a[i].length + " ");                       /* prints how many temperatures were taken per day*/
			
			for(int j = 0 ; j < a[i].length ; j++)    
			{
				System.out.print(a[i][j]+"   ");
			}
			
			System.out.println();
		}
	}
	
	public static void leavehospital (double [][]a)                   /* define leave hospital method*/
	{
		 for(int i = 0 ; i < a.length ; i++)                          /* for loop to sort the array in  descending order*/
		   {
			   for(int j = 0 ; j < a[i].length ; j++)
			   {
				   for( int x = 0 ; x < a[i].length - j - 1 ; x++)   /* loop to sort the array according to a row (per day)*/
				   {
					   if( a[i][x] < a[i][x+1])
					   {
						   double var = a[i][x];                   
						   a[i][x] = a[i][x+1];                      /* swap*/
						   a[i][x+1] = var;
						   
					   }
				   }
			   }
		   }
		 
		 double sum = a[a.length-1][0] + a[a.length-1][1] + a[a.length -2][0] + a[a.length-2][1];             /* call the first two elements in the descending array for the last two days (the two highest temp)*/
		 double average = sum/4;                                                                              /* calculate the average for them*/
		 
		 if( (average > 35.5 && average < 36.5) || average == 35.5 || average == 36.5)                        /* check if the average is around 35.5- 36.5*/
		 {
			 System.out.println("YES she|he can leave the average is stable it's "+ "   " + average);     
		 }
		 
		 else
		 {
			 System.out.println("NO she|he can't leave the average is not stable it's "+ "  "+ average);
		 }
		 
	}


	public static void main (String [] args) {
		
	int days;
	int reads = 0;
	
	Scanner in = new Scanner(System.in);                           /* define a scanner*/
		
	System.out.println("enter the number of days that a patient has entered the hospital");
	days = in.nextInt();                                           /* ask the user to enter number of days he stayed in the hospital*/
	
	double [][] temp = new double [days][];                        /* create the 2d array that will contain each day with its temperatures*/
	
	for(int i = 0 ; i < days ; i++)                                /* for loop to get the temperatures from the user for each day*/
	{
		System.out.println("Day" + (i+1) + " : ");
			
		System.out.println("enter the number of times that nurse read the temperature of the patient in Celsius");
		reads = in.nextInt();                                     /* ask the user to enter number of times .....*/
		
		System.out.println("enter the temperature that was read by the nurse");
		
		temp[i] = new double [reads];                            /* array to save the number of taken temperatures for each day*/
 
		for( int j = 0 ; j < reads ; j++)                        /* for loop to save the readings*/
	    {
		   temp [i][j] = in.nextDouble();                        /* ask user to enter the temperatures*/
		    	
		   while ( temp[i][j] < 30 || temp[i][j] > 45)           /* check if the entered temperature is acceptable or not*/
		   {
		      System.out.println("Error, wrong in temperatures try again between 30-45 !");
		      temp [i][j]= in.nextDouble();                      /* if yes get another reading from the user*/
		   
		   } 
		    	
		}
		    
    }
	 
	  double [] answer = summary(temp);                                                          /* create answer array = call the summary method it will return an array contains what we want */
	  System.out.println("The maximum temperature is : "+ answer[0]);                            /* print the first element max*/
	  System.out.println("The minimum temperature is : " + answer[1]);                           /* print the second element min*/
	  System.out.println("The everage of the temperatures is: "+ answer[2]);                     /* print the third element avg*/
	  
	  int [] belowabove = countbelowaboveaverage(temp);                                          /* create belowabove array = call the method it will return an array contains what we want*/
	  System.out.println("number of temperature below the average is :"+belowabove[0]);          /* print the first element*/
	  System.out.println("number of temperature above the average is:"+belowabove[1]);           /* print the second element*/
	  
	  printarray(temp);                                                                          /* call the method that print the sorted array*/
      
	  leavehospital(temp);                                                                       /* call the method the will says if he\she can leave the hospital*/
	  
	
	}
	

}