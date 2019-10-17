package demo.Lambda;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MagicLambda {
    private List<Product> products = new ArrayList<Product>();

    @Before
    public void init(){
        products.add(new Product(1L,"苹果手机",8888.88));
        products.add(new Product(2L,"华为手机",6666.88));
        products.add(new Product(3L,"联想笔记本",10000.88));
        products.add(new Product(4L,"机械键盘",222.88));
        products.add(new Product(5L,"雷蛇鼠标",111.88));

    }


    public List<Product> filterProduct(List<Product> products,Mypredicate<Product> predicate){
        List<Product> list = new ArrayList<Product>();
        for (Product product: products
             ) {
            if (predicate.test(product)){
               list.add(product);
            }
            
        }
        return list;
    }


//    public List<Product> filterProductByName(List<Product> products){
//        List<Product> list = new ArrayList<Product>();
//        for (Product product:products
//             ) {
//            if (product.getName().contains("手机")){
//                list.add(product);
//            }
//
//        }
//        return list;
//    }

//    public List<Product> filterProductByPrice(List<Product> products){
//        List<Product> list = new ArrayList<Product>();
//        for (Product product:products
//        ) {
//            if (product.getPrice() > 1000 ){
//                list.add(product);
//            }
//
//        }
//        return list;
//
//    }

    @Test
    public void test1() throws Exception{
        List<Product> list = filterProduct(products,new FilterProductByName());
//        List<Product> list = filterProductByPrice(products);
        for (Product product:list
             ) {
            System.out.println(product);

        }
    }


    @Test
    public void test4() throws Exception{
        filterProduct(products,(p) -> p.getPrice() > 1000 ).forEach(System.out::println);
    }



}
