import java.util.Scanner;

class CricketPlayer
{
	String name;
	int totalRuns;
	int totalInnings;
	int totalNotOuts;
	float battingAvg;
	
	CricketPlayer(String param1, int param2, int param3, int param4)
	{
		name = param1;
		totalRuns = param2;
		totalInnings = param3;
		totalNotOuts = param4;
		battingAvg = 0.0f;
	}
	
	static void average(CricketPlayer object)
	{
		object.battingAvg = object.totalRuns / object.totalNotOuts;
	}
	
	static void sort(CricketPlayer arr[], int size)
	{
		int i;
		int j;
		String name;
		
		for(i = 0; i < size-1; i++)
		{
			if(arr[i].battingAvg < arr[i+1].battingAvg)
			{
				name = arr[i].name;
				arr[i].name = arr[i+1].name;
				arr[i+1].name = name;
				
				arr[i].battingAvg = arr[i].battingAvg + arr[i+1].battingAvg;
				arr[i+1].battingAvg = arr[i].battingAvg - arr[i+1].battingAvg;
				arr[i].battingAvg = arr[i].battingAvg - arr[i+1].battingAvg;							

				arr[i].totalRuns = arr[i].totalRuns + arr[i+1].totalRuns;
				arr[i+1].totalRuns = arr[i].totalRuns - arr[i+1].totalRuns;
				arr[i].totalRuns = arr[i].totalRuns - arr[i+1].totalRuns;
				
				arr[i].totalInnings = arr[i].totalInnings + arr[i+1].totalInnings;
				arr[i+1].totalInnings = arr[i].totalInnings - arr[i+1].totalInnings;
				arr[i].totalInnings = arr[i].totalInnings - arr[i+1].totalInnings;
											
				arr[i].totalNotOuts = arr[i].totalNotOuts + arr[i+1].totalNotOuts;
				arr[i+1].totalNotOuts = arr[i].totalNotOuts - arr[i+1].totalNotOuts;
				arr[i].totalNotOuts = arr[i].totalNotOuts - arr[i+1].totalNotOuts;
			}
		}
	}
	
	public static void main(String args[])
	{
		int i;
		int size;
		int outs;
		int score;
		String name;
		int innings;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Total Players : ");
		size = scanner.nextInt();
		
		CricketPlayer player[] = new CricketPlayer[size];
		
		for(i = 0; i < size; i++)
		{
			System.out.print("Enter player " + (i+1) + " details : ");

			System.out.print("Enter Player Name : ");
			name = scanner.next();

			System.out.print("Enter Player Total Runs Scored : ");
			score = scanner.nextInt();

			System.out.print("Enter Player Total Innings Played : ");
			innings = scanner.nextInt();

			System.out.print("Enter Player Total Outs : ");
			outs = scanner.nextInt();
			
			player[i] = new CricketPlayer(name, score, innings, outs);
			
			CricketPlayer.average(player[i]);
		}
		
		CricketPlayer.sort(player, size);
		
		System.out.println("-------------------[Player Details]--------------------");
		for(i = 0; i < size; i++)
		{
			System.out.println("Name : " + player[i].name);
			System.out.println("Total Runs : " + player[i].totalRuns);
			System.out.println("Total Innings : " + player[i].totalInnings);
			System.out.println("Total Not-Outs : " + player[i].totalNotOuts);
			System.out.println("Batting Average : " + player[i].battingAvg);
			System.out.println("--------------------------------------------------------");			
		}
		
		scanner.close();
	}
}

