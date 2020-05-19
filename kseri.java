import java.util.Scanner;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class kseri {
	static List<String[]> deck = new ArrayList<>();
	static List<String[]> playerDeck = new ArrayList<>();
	static List<String[]> CPUDeck = new ArrayList<>();
	static List<String[]> discardedDeck = new ArrayList<>();
	static List<String[]> playerDiscarded = new ArrayList<>();
	static List<String[]> cpuDiscarded = new ArrayList<>();

	static int playerPoints = 0;
	static int cpuPoints = 0;
	static int playerCardscount = 0;
	static int input = 0;
	static int round = 6;
	static Random rnd = new Random();
	static int hands = 0;
	static Boolean lastround=false;
	static String lastDiscardedcard = "";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
  	public static void main(final String[] args) {
	deck.add(new String[] {"c3", "3"});
	deck.add(new String[] {"c2", "2"});
	deck.add(new String[] {"c7", "7"});
	deck.add(new String[] {"c12", "12"});
	deck.add(new String[] {"d6", "6"});
	deck.add(new String[] {"c8", "8"});
	deck.add(new String[] {"c9", "9"});
	deck.add(new String[] {"c11", "11"});
	deck.add(new String[] {"c1", "1"});
	deck.add(new String[] {"c13", "13"});
	deck.add(new String[] {"d1", "1"});
	deck.add(new String[] {"d3", "3"});
	deck.add(new String[] {"d4", "4"});
	deck.add(new String[] {"c4", "4"});
	deck.add(new String[] {"d8", "8"});
	deck.add(new String[] {"d9", "9"});
	deck.add(new String[] {"c10", "10"});
	deck.add(new String[] {"d7", "7"});
	deck.add(new String[] {"d13", "13"});
	deck.add(new String[] {"h1", "1"});
	deck.add(new String[] {"d10", "10"});
	deck.add(new String[] {"d12", "12"});
	deck.add(new String[] {"h4", "4"});
	deck.add(new String[] {"d11", "11"});
	deck.add(new String[] {"h3", "3"});
	deck.add(new String[] {"h13", "13"});
	deck.add(new String[] {"h2", "2"});
	deck.add(new String[] {"h12", "12"});
	deck.add(new String[] {"c6", "6"});
	deck.add(new String[] {"h5", "5"});
	deck.add(new String[] {"h7", "7"});
	deck.add(new String[] {"h6", "6"});
	deck.add(new String[] {"d2", "2"});
	deck.add(new String[] {"h11", "11"});
	deck.add(new String[] {"d5", "5"});
	deck.add(new String[] {"s1", "1"});
	deck.add(new String[] {"s3", "3"});
	deck.add(new String[] {"s2", "2"});
	deck.add(new String[] {"s11", "11"});
	deck.add(new String[] {"c5", "5"});
	deck.add(new String[] {"h10", "10"});
	deck.add(new String[] {"s13", "13"});
	deck.add(new String[] {"s4", "4"});
	deck.add(new String[] {"h9", "9"});
	deck.add(new String[] {"s6", "6"});
	deck.add(new String[] {"s8", "8"});
	deck.add(new String[] {"h8", "8"});
	deck.add(new String[] {"s7", "7"});
	deck.add(new String[] {"s9", "9"});
	deck.add(new String[] {"s10", "10"});
	deck.add(new String[] {"s5", "5"});
	deck.add(new String[] {"s12", "12"});

    final Scanner read = new Scanner(System.in);
	Collections.shuffle(deck);
	Collections.shuffle(deck);
	giveCards(deck);

    while (true ) {
      	input = read.nextInt()-1;
		if(input+1 > playerDeck.size())
		{
			//System.out.println(ANSI_YELLOW+"Please select valid card: "+showDeckcontent(playerDeck)+ ANSI_RESET);
		} else {
			playerPlay();
			CPUPlay(round);
			System.out.println("--------------------------");
			System.out.println(ANSI_GREEN+"Your cards:"+showDeckcontent(playerDeck).toString()+ ANSI_RESET);
			System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());
			System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ANSI_RESET);
			if((playerDeck.isEmpty() || CPUDeck.isEmpty()) && lastround) {
				int decka = 52-discardedDeck.size();
				if(playerCardscount>decka/2) {
					playerPoints+=3;
				}
				System.out.println("Finished - Player score:"+playerPoints+" CPU score:"+cpuPoints);
				System.exit(1);
			}
			round--;
			if (round<=0) {
				round = 6;
				hands++;
				giveCards(deck);
			}
		}
		if(deck.size()<1) {
			lastround = true;
		}
    }
  }

	public static void giveCards(List<String[]> deck) 
	{
		for (int i = 0; i <6; i++) {
			playerDeck.add(new String[] {deck.get(i)[0].toString(),deck.get(i)[1].toString()});
			deck.remove(i);
		}

		if(deck.size()<=6) {
			CPUDeck.add(new String[] {deck.get(0)[0].toString(),deck.get(0)[1].toString()});
			CPUDeck.add(new String[] {deck.get(1)[0].toString(),deck.get(1)[1].toString()});
			CPUDeck.add(new String[] {deck.get(2)[0].toString(),deck.get(2)[1].toString()});
			CPUDeck.add(new String[] {deck.get(3)[0].toString(),deck.get(3)[1].toString()});
			CPUDeck.add(new String[] {deck.get(4)[0].toString(),deck.get(4)[1].toString()});
			CPUDeck.add(new String[] {deck.get(5)[0].toString(),deck.get(5)[1].toString()});
			deck.removeAll(deck);
		} else {
			for (int i = 0; i <6; i++) {
				CPUDeck.add(new String[] {deck.get(i)[0].toString(),deck.get(i)[1].toString()});
				deck.remove(i);
			}  
		}

		if(hands==0) {
			for(int i=0; i<4;i++) {
				discardedDeck.add(new String[] {deck.get(i)[0].toString(),deck.get(i)[1].toString()});
				deck.remove(i);
			}
			if(discardedDeck.get(3)[1] == "11"){
				discardedDeck.remove(3);
				//TODO we must check again for JACK after the removal of the latest
				//TODO probably with while
				discardedDeck.add(3,new String[] {deck.get(0)[0].toString(),deck.get(0)[1].toString()});
			}
		}
		System.out.println("--------------------------");
		System.out.println(ANSI_GREEN+"Your cards:"+showDeckcontent(playerDeck).toString()+ ANSI_RESET);
		System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());
		System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ANSI_RESET);
		System.out.println("--------------------------");

	}

  	public static void playerPlay() 
	{
		throwCard(new String[] {playerDeck.get(input)[0],playerDeck.get(input)[1]},"p1");
		playerDeck.remove(input);
		//System.out.println("--------------------------");
		//System.out.println(ANSI_GREEN+"Your cards: "+showDeckcontent(playerDeck).toString()+ ANSI_RESET);
	}	

  	public static void CPUPlay(int round) {
		int lastCardpile = 0;
		if(!discardedDeck.isEmpty()) {
			lastCardpile = Integer.parseInt(discardedDeck.get(discardedDeck.size()-1)[1]);
		}
		
		Boolean hasJack = false;
		int jackPos = 0;
		
		Boolean canTakeAll = false;
		int takeAll = 0;

		Boolean canKseri = false;

		for(int i = 0; i < CPUDeck.size(); i++ ){
			if( CPUDeck.get(i)[1] == "11") {
				hasJack = true;
				//System.out.println(ANSI_RED+"CPU HAS JACK"+ANSI_RESET);
				jackPos = i;
			}
			if(!discardedDeck.isEmpty() && (Integer.parseInt(CPUDeck.get(i)[1]) == lastCardpile)) {
				canTakeAll = true;
				takeAll = i;
				if(discardedDeck.size()==1) {
					canKseri = true;
				}
			}
		}
		if(hasJack && discardedDeck.size()>3) {
			throwCard(new String[] {CPUDeck.get(jackPos)[0].toString(),CPUDeck.get(jackPos)[1].toString()},"cpu");
			CPUDeck.remove(jackPos);
			//cpuDiscarded.add(new String[] {CPUDeck.get(jackPos)[0].toString(),CPUDeck.get(jackPos)[1].toString()});
			//System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());
			//System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ ANSI_RESET);
			return;
		}
		if(canKseri) {
			throwCard(new String[] {CPUDeck.get(takeAll)[0].toString(),CPUDeck.get(takeAll)[1].toString()},"cpu");
			CPUDeck.remove(takeAll);
			//System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());
			//System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ ANSI_RESET);
			return;
		}
		if(canTakeAll) {
			throwCard(new String[] {CPUDeck.get(takeAll)[0].toString(),CPUDeck.get(takeAll)[1].toString()},"cpu");
			CPUDeck.remove(takeAll);
			////System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ ANSI_RESET);
			//System.out.println(ANSI_YELLOW+"Player's turn"+ ANSI_RESET);
			//System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());

			return;
		}

		//TODO we must throw the least valueble card. For now, random
		System.out.println("prin");
		int playcard = rnd.nextInt(round);
		Boolean loopa = true;
		while(loopa) {
			if(CPUDeck.get(playcard)[1] == "11" && discardedDeck.size()>=3)
			{
				playcard = rnd.nextInt(round);	
			} else {
				loopa = false;
			}
		}
		System.out.println("meta");
		
		if(discardedDeck.isEmpty()) {
			discardedDeck.add(new String[] {CPUDeck.get(playcard)[0].toString(),CPUDeck.get(playcard)[1].toString()});
		} else {
			//TODO  If discard pile is not empty, we need to compute what to do, which one to throw
			throwCard(new String[] {CPUDeck.get(playcard)[0].toString(),CPUDeck.get(playcard)[1].toString()},"cpu");
			//System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());

		}
		CPUDeck.remove(playcard);
		//System.out.println(ANSI_CYAN+showDeckcontent(discardedDeck)+ ANSI_RESET);
		System.out.println(ANSI_RED+"CPU cards: "+showDeckcontent(CPUDeck).toString());
  	}

	public static void throwCard(String[] card, String who) {
		if(!discardedDeck.isEmpty()) {
			int lastDiscardcard = Integer.parseInt(discardedDeck.get(discardedDeck.size()-1)[1]);

			if(lastDiscardcard == Integer.parseInt(card[1])) {
				if(discardedDeck.size()==1) {
					// ΞΕΡΗ
					if(who == "cpu") { 
						//TODO ξερη με βαλε 20 ποντους
						cpuPoints += 10;
						calculateScore(card[0], "cpu");
					} else {
						playerPoints += 10;
						playerCardscount +=2;
						calculateScore(card[0], "player");
					}
					discardedDeck.removeAll(discardedDeck);
					System.out.println(ANSI_PURPLE +"ΞΕΡΗ by "+who+ANSI_RESET);
					return;
				} else {
					discardedDeck.add(card);
					if(who == "cpu") {
						for(int i=0;i<discardedDeck.size();i++) {
							calculateScore(discardedDeck.get(i)[0],"cpu");
						}
						System.out.println(ANSI_PURPLE +"CPU take all!!"+ANSI_RESET);
					} else {
						for(int i=0;i<discardedDeck.size();i++) {
							playerCardscount +=1;
							calculateScore(discardedDeck.get(i)[0],"player");
						}
						System.out.println(ANSI_YELLOW+"You take all!!"+ANSI_RESET);
					}
					discardedDeck.removeAll(discardedDeck);
					return;
				}
			} else if(Integer.parseInt(card[1]) == 11) {
				discardedDeck.add(card);
				if(who == "cpu") {
						for(int i=0;i<discardedDeck.size();i++) {
							calculateScore(discardedDeck.get(i)[0],"cpu");
						}
						System.out.println(ANSI_PURPLE +"CPU take all!!"+ANSI_RESET);
				} else {
						for(int i=0;i<discardedDeck.size();i++) {
							playerCardscount +=1;
							calculateScore(discardedDeck.get(i)[0],"player");
						}
						System.out.println(ANSI_YELLOW+"You take all!!"+ANSI_RESET);
				}
				discardedDeck.removeAll(discardedDeck);
				return;
			}	 
		}
		discardedDeck.add(card);
	}

	public static String showDeckcontent(List<String[]> deck) {
		String result = "";
        int keyboard;
        for(int i=0;i<deck.size();i++)
        {
			keyboard = i+1;
			result += deck.get(i)[0]+" ";
        }
		keyboard = 1;
		return result;
	}

	public static void calculateScore(String card, String who)
	{	
		// 10 KAΡΟ d10 ->2p
		// ΑΣΣΟΙ Κ Q J 10 s2 ->1p
		//ξερη σε βαλε -> 20p
		// c clubs τριφυλλι
		// d diamonds καρο
		// h hearts κουπες
		// s spades σπαθι

		if(who=="cpu") {
			switch (card) {
				case "d10":
					cpuPoints +=2;
					break;
				case "s2":
				case "c1":
				case "d1":
				case "h1":
				case "s1":
				case "c11":
				case "d11":
				case "h11":
				case "s11":
				case "c12":
				case "d12":
				case "h12":
				case "s12":
				case "c13":
				case "d13":
				case "h13":
				case "s13":
				case "c10":
				case "h10":
				case "s10":
					cpuPoints +=1;
					break;
			}
		} else {
			playerCardscount ++;
			switch (card) {
				case "d10":
					cpuPoints +=2;
					break;
				case "s2":
				case "c1":
				case "d1":
				case "h1":
				case "s1":
				case "c11":
				case "d11":
				case "h11":
				case "s11":
				case "c12":
				case "d12":
				case "h12":
				case "s12":
				case "c13":
				case "d13":
				case "h13":
				case "s13":
				case "c10":
				case "h10":
				case "s10":
					cpuPoints +=1;
					break;
			}
		}
	}
}
