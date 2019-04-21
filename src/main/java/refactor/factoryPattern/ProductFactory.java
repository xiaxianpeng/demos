package refactor.factoryPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by xianpeng.xia
 * on 2019-04-21 21:37
 */
public class ProductFactory {

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        try {
            throw new IllegalAccessException("No such product " + name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");
        System.out.println(product);
    }
}
