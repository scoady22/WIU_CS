 private void dealCards(UnoCard[] deck)
    {
        UnoCard[] playerHand = new UnoCard[54];
        int numOfCards=0;
        UnoCard[] cpuHand = new UnoCard[54];
        int cpuNumOfCards=0;
        int[] removed = new int[54];
        int card;
        
        //player
        for(int i=0;i<7;i++)
        {
            Random rand = new Random();
            card = rand.nextInt(54);
            if(deck[card].getNum() != -1)
            {
            playerHand[i].setNum(deck[card].getNum());
            playerHand[i].setColor(deck[card].getColor());
            numOfCards++;
            deck[card].setNum(-1);
            }
            
        }
        
        //cpu
        for(int j=0;j<7;j++)
        {
            Random rand = new Random();
            card = rand.nextInt(54);
            if(deck[card].getNum() != -1)
            {
            cpuHand[j].setNum(deck[card].getNum());
            cpuHand[j].setColor(deck[card].getColor());
            deck[card].setNum(-1);
            }
        }