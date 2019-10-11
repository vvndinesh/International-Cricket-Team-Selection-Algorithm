import java.util.Scanner;

public class CricketChamp
{
	int i,j,m,n,type,empty=0,overs=0;
	String temp="";
	Scanner s= new Scanner(System.in);
	Scanner in= new Scanner(System.in);
	String[] batsman= new String[20];
	String[] bowler= new String[20];
	int[] batAge= new int[20];
	int[] bowAge= new int[20];
	int[] runs= new int[20];
	int[] wkts= new int[20];
	int[] wcbat= new int[10];
	int[] wcbowl= new int[10];
	int[] battotal= new int[10];
	int[] bowltotal= new int[10];

	//Entering details of players
	public void details()
	{
		for(i=1;i<=10;i++)
		{
			type=1;
			System.out.print("Enter the name of Batsman"+" "+i+" :");
			batsman[i]=s.nextLine();
			System.out.print("Enter Age : ");
			batAge[i]=in.nextInt();
			System.out.print("Total runs scored by Batsman : ");
			runs[i]=in.nextInt();
			System.out.println("");
		}
		for(i=1;i<=10;i++)
		{
			type=2;
			System.out.print("Enter the name of Bowler"+" "+i+" :");
			bowler[i]=s.nextLine();
			System.out.print("Enter Age : ");
			bowAge[i]=in.nextInt();
			System.out.print("Total runs scored by Bowler : ");
			wkts[i]=in.nextInt();
			System.out.println("");
		}
	}

	//print the names of the team
	public void board()
	{
		m=10;n=10;
		System.out.println("*****************       Team List        *******************");
		System.out.println("Player Name"+"    "+"Age"+"    "+"Role"+"    "+"Runs/Wickets");
		System.out.println("************************************************************");
		printbat();
		printbowl();
		System.out.println("");
	}

	//Print Worlcup team list
	public void wcboard()
	{
		m=6;n=5;
		System.out.println("*****************    WorldCup Team List    *****************");
		System.out.println("Player Name"+"    "+"Age"+"    "+"Role"+"    "+"Runs/Wickets");
		System.out.println("************************************************************");
		printbat();
		printbowl();
		wcmatch();
	}

	public void printbat()
	{
		sortbat();  				//Running the method sortbat();
		for (i=1;i<=m;i++ ) 
		{
			System.out.println(" "+batsman[i]+"          "+batAge[i]+"    "+"Batsman"+"    "+runs[i]);
		}
	}

	public void printbowl()
	{
		sortbowl(); 				//Running the method sortbowl();
		for (i=1;i<=n;i++ )
		{
			System.out.println(" "+bowler[i]+"          "+bowAge[i]+"    "+"Bowler"+"    "+wkts[i]);
		}
	}

	public void wcmatch()
	{
		System.out.println("");
		System.out.println("*******  Lets start the game  *******");
		System.out.print("Enter the No.of overs: ");
		overs=in.nextInt(); 
		System.out.println("*************************************");
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=overs;j++)
			{
				System.out.print("Enter score of"+" "+batsman[i]+" "+"in over"+" "+j+": ");
				wcbat[i]=in.nextInt();
				battotal[i]=wcbat[i]+battotal[i];
			}
			System.out.println("*************************************");
		}
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=overs;j++)
			{
				System.out.print("Enter wickets taken by"+" "+bowler[i]+" "+"in over"+" "+j+": ");
				wcbowl[i]=in.nextInt();
				bowltotal[i]=wcbowl[i]+bowltotal[i];
			}
			System.out.println("*************************************");
		}
		System.out.println("");
		match();
	}

	void match()
	{
		for(i=1;i<=m;i++)
		{
			System.out.println(" "+batsman[i]+"     "+"Batsman"+"    "+battotal[i]);
		}
		for(i=1;i<=n;i++)
		{
			System.out.println(" "+bowler[i]+"     "+"Bowler"+"    "+bowltotal[i]);
		}
		System.out.println("");
		maxscore();
		maxwickets();
	}

	void maxscore()
	{
		for(i=1;i<=m;i++)
		{
			for(j=i+1;j<=m;j++)
			{
				if(battotal[i]<battotal[j])
				{
					battotal[i]=battotal[j];		   
					batsman[i]=batsman[j]; 				//sorting name
				}
			}
		}
		System.out.println("Max Score of the match: "+batsman[1]);
	}

	void maxwickets()
	{	
		for(i=1;i<=n;i++)
		{
			for(j=i+1;j<=n;j++)
			{
				if(bowltotal[i]<bowltotal[j])
				{
					bowltotal[i]=bowltotal[j];	   
					bowler[i]=bowler[j];				//sorting name
				}
			}
		}
		System.out.println("Max wickets taken by: "+bowler[1]);
	}

	//Sorting batsman
	void sortbat()
	{  			     				  //Only batsman are sorted in this method
		for (i=1;i<=10;i++) 
		{
		for(j=i+1;j<=10;j++)
		{
			if(runs[i]<runs[j])
			{
				empty=runs[i];          //sorting runs
				runs[i]=runs[j];
				runs[j]=empty;
				
				temp=batsman[i];		   //sorting name
				batsman[i]=batsman[j];
				batsman[j]=temp;

				empty=batAge[i];			//sorting age
				batAge[i]=batAge[j];
				batAge[j]=empty;
			}
		}
		}
	}

		//sorting bowlers
	void sortbowl()
	{   							//Only bowlers are sorted in this method
		for (i=1;i<=10;i++ )
		{
		for(j=i+1;j<=10;j++)
		{
			if(wkts[i]<wkts[j])
			{
				empty=wkts[i];			//sorting wickets
				wkts[i]=wkts[j];
				wkts[j]=empty;
				
				temp=bowler[i];		   //sorting name
				bowler[i]=bowler[j];
				bowler[j]=temp;

				empty=bowAge[i];			//sorting age
				bowAge[i]=bowAge[j];
				bowAge[j]=empty;
			}
		}
		}
	}


	public static void main(String[] args)
	{
		CricketChamp check= new CricketChamp();
		check.details();
		check.board();
		check.wcboard();
	}
} 

