package demo.Lambda;

public class FilterProductByPrice implements Mypredicate<Product> {
    public boolean test(Product t) {
        return t.getPrice() > 1000;
    }
}
