//package Java.main;
//
////=============================================================================
//// The main Order Application
////     args[0] = Number of orders to be processed.  If none 15 is used.
////     args[1] = Number of order taker threads.     If none  2 is used.
////     args[2] = Number of order processor threads. If none  2 is used.
////=============================================================================
//public class OrderApp
//{
//    static int MAX_ORDERS              = 15;            //number of orders to process
//    static int ORDER_TAKER_THREADS     = 2;             //number of OrderTaker threads
//    static int ORDER_PROCESSOR_THREADS = 2;             //number of OrderProcess threads
//
//    static OrderManager MGR = new OrderManager();       //Launch a manager class
//
//    public static void main(String[] args)
//    {
//        if (args.length > 0)
//            MAX_ORDERS              = Integer.parseInt(args[0]);
//        if (args.length > 1)
//            ORDER_TAKER_THREADS     = Integer.parseInt(args[1]);
//        if (args.length > 2)
//            ORDER_PROCESSOR_THREADS = Integer.parseInt(args[2]);
//
//        System.out.println(Thread.currentThread().getName()        + " is creating:");
//        System.out.println("- An order queue with maximum orders " + MAX_ORDERS);
//        System.out.println("- Starting " + ORDER_TAKER_THREADS     + " order taker threads.    ");
//        System.out.println("- Starting " + ORDER_PROCESSOR_THREADS + " order processor threads.");
//        System.out.println();
//        System.out.println("     OrderTaker threads     \t      OrderProcessor threads    \n"
//                + "============================\t==================================");
//
//        for (int i=1; i <= ORDER_TAKER_THREADS; i++)        //create the OrderTaker threads
//        {
//            String name  = "Taker-" + i;
//            OrderTaker t = new OrderTaker(name);            //create a thread
//            t.start();                                      //start it
//        }
//
//        try {
//            Thread.sleep(500);                              //delay by 1/2 second
//        }
//        catch(InterruptedException ex)
//        {
//            Thread.currentThread().interrupt();
//        }
//
//        for (int i=1; i <= ORDER_PROCESSOR_THREADS; i++)    //create the OrderProcess threads
//        {
//            String name    = "Processor-" + i;
//            OrderProcess p = new OrderProcess(name);        //create a thread
//            p.start();                                      //start it
//        }
//    }
//}