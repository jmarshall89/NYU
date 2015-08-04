//package Java.main;
//
////================================================================================================
//// The order processor class
//// This class extends Thread so that many threads can be started
//// the sleep method here is not necessary, simulate real world time taking to process orders
////================================================================================================
//public class OrderProcess extends Thread
//{
//    private static int ordersProcessed;                 //keep a count of the orders processed
//    OrderManager mgr = OrderApp.MGR;                    //Access the manager class
//
//    public OrderProcess(String name)                    //constructor
//    {
//        super(name);                                    //call super & pass it the name
//    }
//
//    public void run()                                   //the run method
//    {
//        Order order;
//
//        while(ordersProcessed < OrderApp.MAX_ORDERS)    //or while(true) to keep running
//        {
//            addOrdersProcessed();                       //add 1 to orders processed
//
//            order = mgr.pullOrder();                    //get next available order
//
//            System.out.println("\t\t\t\t" + this.getName() + " processing " + order);
//
//            try
//            {                                                   //delay up to 3 seconds
//                Thread.sleep( (long) (Math.random() * 3000));   //to simulate real world
//            }                                                   //taking time to process order
//            catch (InterruptedException e)
//            {}                                                  //ignore interruptions
//        }
//        System.out.println("\t\t\t\t-->" + this.getName() + " is shutting down");
//        return;
//    }
//
//    private synchronized void addOrdersProcessed()        //synchronized so only 1 thread
//    {                                                     //can add to static field at a time
//        ordersProcessed++;
//    }
//}