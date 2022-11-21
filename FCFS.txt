import java.io.*;
import java.util.Scanner;
public class fcfs
{
	public static void main(String args[]) {
	    //Declare DS 
	    int i,no_p,burst_time[],wt[],TT[];
	    float avg_wait=0,avg_TT=0;
	    // Initialize DS 
	    burst_time = new int[50];
	    wt = new int[50];
	    TT = new int[50];
	    wt[0]=0;
	    
	    //Take input
	    Scanner s=new Scanner(System.in);
	    System.out.println("Enter No. of Processes");
	    no_p=s.nextInt();
		System.out.println("Enter Burst time for processes");
		for(i=0;i<no_p;i++)
		{
		    System.out.println("\tP"+(i+1)+": ");
		    burst_time[i]=s.nextInt();
		}
		//calculate WT and avg_wait
		for(i=1;i<no_p;i++)
		{
		    wt[i]=burst_time[i-1]+wt[i-1];
		    avg_wait+=wt[i];
		}
		avg_wait/=no_p;
		for(i=0;i<no_p;i++)
		{
		    TT[i]=burst_time[i]+wt[i];
		    avg_TT+=TT[i];
		}
		avg_TT/=no_p;
		System.out.println("\n*********************************************************");
		System.out.println("\tProcesses");
		System.out.println("\n*********************************************************");
		System.out.println("Processes\tBurst Time\tWait time\tTurnAround Time");
		System.out.println("\tP"+(i+1)+"\t "+burst_time[i]+"\t "+wt[i]+"\t "+TT[i]);
		System.out.println("\nAverage Wait time :" +avg_wait);
		System.out.println("\nAverage Turnaround Time : " +avg_TT);

		
	}
}
