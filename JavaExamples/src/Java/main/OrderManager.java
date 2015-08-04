//package Java.main;//==========================================================================
//// A class that uses a linkedList object to create an order queue
////     when an order is taken,  the queue notifies the process threads
////     when the queue is empty, the process threads go into waiting state
////==========================================================================
//import java.util.LinkedList;
//
//public class OrderManager
//{
//    private static LinkedList<Order> orderQueue = new LinkedList<Order>();   //using generics
//
//
//    public synchronized void pushOrder(Order order)     //synchronized method to take an order
//    {
//        orderQueue.addLast(order);
//        //notify all waiting threads that there is an order
//        notifyAll();                                    //if you only notify 1 threads instead,
//    }                                                   //then you can change the while() below to an if()
//
//
//    public synchronized Order pullOrder()               //synchronized method to process an order
//    {
//        while (orderQueue.size() == 0)                  //while the queue is empty.  Why not if?
//        {                                               //in case multiple threads are awakened, and another
//            try                                         //thread grabbed the next order from the queue
//            {
//                System.out.println("\t\t\t\t==>" + Thread.currentThread().getName() +
//                        " is waiting");
//                wait();                                 //wait until notified
//            }
//            catch (InterruptedException e)
//            {}
//        }
//        Order o =  orderQueue.removeFirst();
//        return(o);                                      //return the order for processing
//    }
//}