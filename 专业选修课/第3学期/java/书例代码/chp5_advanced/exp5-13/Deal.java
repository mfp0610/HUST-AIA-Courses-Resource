import java.util.*;
class Deal {
    public static void main(String args[]) {
        int numHands = Integer.parseInt(args[0]);
        int cardsPerHand = Integer.parseInt(args[1]);

       // 生成一副牌（含52张牌）。
        String[] suit = new String[] {"spades", "hearts", "diamonds", "clubs"};
        String[] rank = new String[]
            {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
        List<String> deck = new ArrayList<String>();
        for (String ss : suit)
            for (String sr : rank)
                deck.add(sr + " of " + ss);

        Collections.shuffle(deck); //随机改变deck中元素的排列次序，即洗牌。

        for (int i=0; i<numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand)); //生成一手牌并将其输出。
    }

    public static List dealHand(List<String> deck, int n) {
        int deckSize = deck.size();
        List<String> handView = deck.subList(deckSize-n, deckSize); //从deck中截取一个子链表。
        List<String> hand = new ArrayList<String>(handView);  //利用该子链表创建一个链表。
        handView.clear(); //将子链表清空。
        return hand;
    }
}
