package refactor.templateMethodPattern;


import java.util.function.Consumer;

/**
 * Created by xianpeng.xia
 * on 2019-04-20 23:16
 */
public class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> makeConsumerHappy) {
        Customer c = getConsumerWithId(id);
        makeConsumerHappy.accept(c);
    }

    private Customer getConsumerWithId(int id) {
        Customer customer = new Customer("aaa", 1);
        return customer;
    }

    public class Customer {

        private String name;
        private long id;

        public Customer(String name, long id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1, (Customer c) -> {
            System.out.println("hello : " + c.getName());
        });
    }
}
