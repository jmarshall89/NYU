import java.util.HashMap;

/**
 * Created by jmarshall on 6/30/15.
 */
public class AILogic {

    HashMap<Integer, Integer[][]> logicLookup = new HashMap();
    HashMap<Integer, Integer[][]> logicLookupSoft = new HashMap();
    String[] decision = new String[2];

    public AILogic() {
        buildLogicLookup();
    }

    private void buildLogicLookup() {
        Integer[] dealer23Hit = {2,3,4,5,6,7,8,9,10,11,12};
        Integer[] dealer23Stay = {13,14,15,16,17,18,19,20,21};
        Integer[] dealer456Hit = {2,3,4,5,6,7,8,9,10,11};
        Integer[] dealer456Stay = {12,13,14,15,16,17,18,19,20,21};
        Integer[] dealer7PlusHit = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Integer[] dealer7PlusStay = {17,18,19,20,21};
        Integer[] softDealer278Hit = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        Integer[] softDealer278Stay = {18,19,20,21};
        Integer[] softDealer3456PlusHit = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        Integer[] softDealer456PlusStay = {19,20,21};

//        Now put in a double array with hit first
        Integer[][] dealer23 = {dealer23Hit, dealer23Stay};
        Integer[][] dealer456 = {dealer456Hit, dealer456Stay};
        Integer[][] dealer7Plus = {dealer7PlusHit, dealer7PlusStay};
        Integer[][] softDealer278 = {softDealer278Hit, softDealer278Stay};
        Integer[][] softDealer3456Plus = {softDealer3456PlusHit, softDealer456PlusStay};

        decision[0] = "h";
        decision[1] = "s";

        logicLookup.put(2, dealer23);
        logicLookup.put(3,dealer23);
        logicLookup.put(4, dealer456);
        logicLookup.put(5, dealer456);
        logicLookup.put(6, dealer456);
        logicLookup.put(7, dealer7Plus);
        logicLookup.put(8, dealer7Plus);
        logicLookup.put(9, dealer7Plus);
        logicLookup.put(10, dealer7Plus);
        logicLookup.put(11, dealer7Plus);

        logicLookupSoft.put(2, softDealer278);
        logicLookupSoft.put(3, softDealer3456Plus);
        logicLookupSoft.put(4, softDealer3456Plus);
        logicLookupSoft.put(5, softDealer3456Plus);
        logicLookupSoft.put(6, softDealer3456Plus);
        logicLookupSoft.put(7, softDealer278);
        logicLookupSoft.put(8, softDealer278);
        logicLookupSoft.put(9, softDealer3456Plus);
        logicLookupSoft.put(10, softDealer3456Plus);
        logicLookupSoft.put(11, softDealer3456Plus);
    }

    public String aiDecision(Person player, Person dealer){

        Integer playerPoints;
        Card dealerShowing;
        Integer dealerShowPoints;
        HashMap<Integer, Integer[][]> lookupUsed;
        boolean isSoft;

        playerPoints = player.getPoints();
        dealerShowing = dealer.getHand().get(0);
        dealerShowPoints = dealerShowing.getPoints();
        isSoft = player.hasAce();

        if (isSoft) {
            lookupUsed = logicLookupSoft;
        } else {
            lookupUsed = logicLookup;
        }

        Integer[][] hitOrStay;
        hitOrStay = lookupUsed.get(dealerShowPoints);

        int resultIndex = 0;
        outerloop:
        for (Integer[] intArray : hitOrStay) {
            for (Integer i: intArray) {
                if (i.equals(playerPoints)) {
                    break outerloop;
                }
            }
            resultIndex++;
        }

        return decision[resultIndex];
    }


}
