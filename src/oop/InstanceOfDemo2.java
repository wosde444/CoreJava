package oop;


//有int型的orderId，String型的OrderName，
//相应的getter()和setter()方法，两个参数的构造器，
// 重写父类的equals()方法：public boolean equals(Object obj)，
// 并判断测试类中创建的两个对象是否相等。
class Order{
    int orderId;
    String orderName;

    public Order(int orderId,String orderName){
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public boolean equals(Order order) {
        if (this == order){
            return true;
        }
        if (this.orderId == order.getOrderId()){
            return true;
        }
        return false;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "订单号为："+this.getOrderId()+"   订单名为："+this.getOrderName();
    }
}
public class InstanceOfDemo2 {
    public static void main(String[]args){
        Order o1 = new Order(1,"SSS");
        Order o2 = o1;
        Order o3 = new Order(1,"eee");
        Order o4 = new Order(1,"SSS");
        Order o5 = new Order(2,"SSS");

        System.out.println(o1.equals(o2));//true
        System.out.println(o1.equals(o3));//true
        System.out.println(o1.equals(o4));//true
        System.out.println(o1.equals(o5));//false
        System.out.println(o1);

    }
}
