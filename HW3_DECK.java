import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class HW3_DECK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner k=new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String n=k.nextLine();
		int nDeck=1;
		Deck deck=new Deck(nDeck);
		
		
		
		Card newCard=deck.getOneCard();
		newCard.printCard();
		
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		
		deck.shuffle();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck))
		{
			if(!isShuffleWorking(deck,newCard,newCard2))
			{
				System.out.println("All Card: Well done! But shuffler is not working");
			}
			else
			{
				System.out.println("Well done!");
			}
		}
		else
		{
			System.out.println("All Card: Error,Please check your source code");
		}
	}
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2)
	{
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) && newCard.getRank()==newCard2.getRank())
		{
			isCorrect=false;
			return isCorrect;
		}
		for(int i=0;i<53;i++)
		{
			deck.getOneCard();
		}
		if(deck.nused!=1)
		{
			isCorrect=false;
		}
		return isCorrect;
	} 	
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck)
	{
		boolean isCorrect=true;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards)
		{
			Card.Suit suit=card.getSuit();
			int rank=card.getRank();
			if(rank>13||rank<1)
			{
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank))
			{
				checkHash.put(suit+","+rank,checkHash.get(suit+","+rank)+1);
			}
			else
			{
				checkHash.put(suit+","+rank,1);
			}
		}
		if(checkHash.keySet().size()==52)
		{
			for(int value:checkHash.values())
			{
				if(value!=nDeck)
				{
					isCorrect=false;
					break;
				}
			}
			
		}
		else
		{
			isCorrect=false;
		}
		return isCorrect;
	}
	
	
	
	
		
		
	
			
		
		
}


		

