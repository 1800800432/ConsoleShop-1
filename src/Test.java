import javafx.scene.control.Tab;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    static int count = 0;
    static Product carts[] = new Product[3];//�������ﳵ��������ģ�⣩

    public static void main(String[] args) throws ClassNotFoundException {
        /*
        CTRL+ALT+L
         */
        boolean bool = true;
        while (bool) {
            System.out.println("�������û�����");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//��������

            System.out.println("���������룺");
            String password = sc.next();

            //File file=new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");//  /��ʾ�ľ���classpath

            InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /��ʾ�ľ���classpath

            ReadUserExcel readExcel = new ReadUserExcel();//��������
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    bool = false;
                    /*
                    ��ʾ��Ʒ����Ϣ
                     */
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.getAllProduct(inPro);
                    for (Product product : products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t\t" + product.getPrice());
                        System.out.println("\t\t" + product.getDesc());
                    }
                    /*
                    ��������
                     */
                    shopping(sc, inPro, readProductExcel, products);
                    int choose = sc.nextInt();
                    while (true) {
                        if (choose == 1) {
                            for (int j = 0; j < carts.length; j++) {
                                if (carts[j] != null) {
                                    System.out.print(carts[j].getId());
                                    System.out.print("\t" + carts[j].getName());
                                    System.out.print("\t\t" + carts[j].getPrice());
                                    System.out.println("\t\t" + carts[j].getDesc());
                                }
                            }
                            System.out.println("�鿴���ﳵ�밴��1��");
                            System.out.println("���������밴��2��");
                            System.out.println("�����밴��3��");
                            System.out.println("����밴��4��");
                            choose = sc.nextInt();
                        } else if (choose == 2) {
                            shopping(sc, inPro, readProductExcel, products);
                            choose = sc.nextInt();
                        } else if (choose == 3) {
                            float Price=0;
                            for (int j = 0; j < carts.length; j++) {
                                if (carts[j] != null) {
                                   Price=Price+carts[j].getPrice();
                                }
                            }//�����ܼ�
                            Order order = new Order();
                            order.setUser(users[i]);//���������û�
                            for (int k = 0; k < carts.length; k++) {
                                if (carts[k] != null) {

                                }
                            }

                            order.setTotalPay(Price);//����������Ʒ�۸�

                            Product orderProducts[]=new Product[count];

                            for (int j=0;j<carts.length;j++){
                                if(carts[j]!=null) {
                                    orderProducts[j]=carts[j];
                                }
                            }
                            order.setProducts(orderProducts);
                            //������������Ʒ���û�

                            Map<Integer,Integer> ammout=new HashMap<Integer,Integer>();
                            ammout.put(1111,2);
                            ammout.put(2222,1);

                            order.setAmmount(ammout);

                            CreateOrder.createOrder(order);
                            break;
                        } else if (choose == 4) {
                            break;
                        }

                    }
                        break;
            } else{
                System.out.println("��¼ʧ��");
            }
        }
    }

}

    /*���﷽��*/
    public static void shopping(Scanner sc, InputStream inPro, ReadProductExcel readProductExcel, Product[]
            products) throws ClassNotFoundException {
        System.out.println("��������ƷID���Ѹ���Ʒ���빺�ﳵ��");
        String pId = sc.next();
        ReadProductExcel readProductExcel1 = new ReadProductExcel();
        inPro = null;
        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /��ʾ�ľ���classpath
        Product product = readProductExcel1.getProductById(pId, inPro);
        if (product != null) {
                        /*
                        ����Ʒ���빺�ﳵ
                         */
            carts[count++] = product;
        }
        System.out.println("�鿴���ﳵ�밴��1��");
        System.out.println("���������밴��2��");
        System.out.println("�����밴��3��");
        System.out.println("�˳��밴��4��");
    }
}
