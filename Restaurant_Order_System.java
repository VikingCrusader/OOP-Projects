package OOP_Projects;
import java.util.ArrayList;

public class Restaurant_Order_System {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Order o1 = new Order("Irena");
        o1.addDish("Burger");
        o1.addDish("Pizza");
        Order o2 = new Order("Susan");
        o2.addDish("Sushi");
        o2.addDish("Cola");
        o2.addDish("Chips");
        Order o3 = new Order("Ellen");
        o3.addDish("Steak");
        o3.addDish("Wine");
        o3.addDish("Fried Chicken");
        o3.addDish("Rice");
        manager.addOrder(o1);
        manager.addOrder(o2);
        manager.addOrder(o3);
        OrderProcessor processor1 =  (ord) -> {
            System.out.println(ord.customerName+" ordered "+ord.dishes.size()+" dishes");
        };
        OrderProcessor processor2 =  (ord) -> {
            for(String i : ord.dishes){
                System.out.println("CustomerName: "+ord.customerName+" food:  "+i);
            }
        };
        OrderProcessor processor3 =  (ord) -> {
            for(String i : ord.dishes){
                i = i.toLowerCase();
                if(i.contains("chicken")){
                    System.out.println("Attention, the order is Chicken included.");
                }
            }
        };
        manager.addProcessor(processor1);
        manager.addProcessor(processor2);
        manager.addProcessor(processor3);
        manager.processOrders(o1);
        manager.processOrders(o2);
        manager.processOrders(o3);
    }
}

//管理订单
class Order {
    String customerName;
    ArrayList<String> dishes = new ArrayList<>();  //（点的菜名列表）
    Order(String customerName) {
        this.customerName = customerName;
    }
    void addDish(String dish) {
        this.dishes.add(dish);
    }
}

//订单处理器接口
interface OrderProcessor {
    void process(Order order);
}

//管理所有订单和处理器
class OrderManager{
    ArrayList<Order> orders = new ArrayList<>(); //保存订单
    ArrayList<OrderProcessor> orderProcessors = new ArrayList<>(); //保存处理器
    void addOrder(Order order) {
        this.orders.add(order);
    }
    void addProcessor(OrderProcessor processor) {
        this.orderProcessors.add(processor);
    }
    void processOrders(Order order) {
        for(OrderProcessor processor : orderProcessors){
            processor.process(order);
        }
    }
}