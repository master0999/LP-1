import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        int i,j,n,burst_time[],process[],wt[],tat[],pos,temp,total=0;
        float avg_wait=0,avg_tat=0;
        
        Scanner s= new Scanner(System.in);
        System.out.println("\nEnter no. of Processes: ");
        n=s.nextInt();
        
        process = new int[n];
        burst_time= new int[n];
        wt=new int[n];
        tat=new int[n];
        
        System.out.println("\nEnter Burst Time: ");
        for(i=0;i<n;i++){
            System.out.println("\tProcess["+(i+1)+"]: ");
            burst_time[i]=s.nextInt();
            process[i]=i+1;
        }
        //Sorting
        for(i=0;i<n;i++){
            pos=i;
            for(j=i+1;j<n;j++){
                if(burst_time[i]<burst_time[pos]){
                    pos=j;
                }
            }
            temp=burst_time[i];
            burst_time[j]=burst_time[pos];
            burst_time[pos]=temp;
            
            temp=process[i];
            process[i]=process[pos];
            process[pos]=temp;
        }
        wt[0]=0;
        for(i=1;i<n;i++){
            wt[i]=0;
            for(j=0;j<i;j++){
                wt[i]+=burst_time[j];
                total+=wt[i];
            }
        }
        avg_wait=(float)total/n;
        total=0;
        System.out.println("\nProcess\tBurst TIme\tWaiting time\tTurnaround time");
        for(i=0;i<n;i++){
            tat[i]=burst_time[i]+wt[i];
            total+=tat[i];
            System.out.println("\nP"+process[i]+"\t\t"+burst_time[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
        }
        avg_tat=(float)total/n;
        System.out.println("Average Wait time : " +avg_wait);
        System.out.println("Average Turnaround Time: "+avg_tat);
        
        }
                
            
        
    }
