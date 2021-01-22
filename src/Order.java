import javax.xml.crypto.Data;

public class Order {
    /*
    该有哪些属性，依据是什么
    依据：数据库有哪些字段。那么类就有哪些属性
     */
    private User user;
    private Product product;
    private int ammount;
    private float totalPay;
    private float actualPay;
    private Data orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public float getActualPay() {
        return actualPay;
    }

    public void setActualPay(float actualPay) {
        this.actualPay = actualPay;
    }

    public Data getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Data orderDate) {
        this.orderDate = orderDate;
    }
}
