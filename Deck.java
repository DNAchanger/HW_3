import java.util.ArrayList;
import java.util.Random;

public class Deck {

		private ArrayList<Card> cards;
		private ArrayList<Card> haveused;
		public int nused=0;
		
		public Deck (int nDeck){
			cards=new ArrayList<Card>();
			haveused=new ArrayList<Card>();
			for(int k=0;k<nDeck;k++)
			{
				for(int suit=1;suit<5;suit++)
				{
					for(int num=1;num<14;num++)
					{
						Card card;
						switch (suit)
						{
						case 1:
							card=new Card(Card.Suit.Club,num);
							cards.add(card);
							break;
						case 2:
							card=new Card(Card.Suit.Diamond,num);
							cards.add(card);
							break;
						case 3:
							card=new Card(Card.Suit.Heart,num);
							cards.add(card);
							break;
						case 4:
							card=new Card(Card.Suit.Spade,num);
							cards.add(card);
							break;
						}
					}
				}
			}
		
		}
	
public ArrayList<Card> getAllCards()
{
	return cards;
}
public void shuffle()
{
	Random rnd=new Random();
	int surplus=cards.size();
	for(int i=0;i<surplus;i++)
	{
		haveused.add(cards.get(0));
		cards.remove(cards.get(0));		
	}
	surplus=haveused.size();
	for(int m,n=0;n<surplus;n++)
	{
		m=rnd.nextInt(haveused.size());
		cards.add(haveused.get(0));
		haveused.remove(m);
	}
	nused=0;
}

public Card getOneCard()
	{
		if(cards.isEmpty()==true)
		{
			shuffle();
		}
		
		haveused.add(cards.get(0));
		cards.remove(cards.get(0));
		nused++;
		return cards.get(0);
	}

}

