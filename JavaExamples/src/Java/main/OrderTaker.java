//package Java.main;
//
////================================================================================================
//// The order taker class
//// This class extends Thread so that many threads can be started
//// the sleep method here is not necessary, simulate real world orders coming in the door
////================================================================================================
//public class OrderTaker extends Thread
//{
//    private static int ordersTaken;                 //keep a count of the orders taken
//    OrderManager mgr = OrderApp.MGR;          		//Access the manager class
//
//    public OrderTaker(String name)                  //constructor
//    {
//        super(name);                                //call super & pass it the name
//    }
//
//    public void run()                               //the run method
//    {
//        Order order;
//
//        while(ordersTaken < OrderApp.MAX_ORDERS)
//        {
//            addOrdersTaken();                               //add 1 to orders taken
//
//            String order_num = "000" + ordersTaken;         //generate an order number
//
//            order = new Order(order_num);                   //create an order
//
//            mgr.pushOrder(order);                           //add order to the queue
//
//            System.out.println(this.getName() + " created " + order);
//
//            try
//            {                                                   //delay up to 3 seconds
//                Thread.sleep( (long) (Math.random() * 3000));   //simulate real world
//            }                                                   //orders coming in the door
//            catch (InterruptedException e)
//            {}                                                  //ignore interruptions
//        }
//        System.out.println("-->" + this.getName() + " is shutting down");
//        return;
//    }
//
//    private synchronized void addOrdersTaken()          //synchronized so only 1 thread
//    {                                                   //can add to static field at a time
//        ordersTaken++;
//    }
//}