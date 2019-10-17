package demo.Lambda;

public class FilterProductByName implements Mypredicate<Product> {
    public boolean test(Product t) {
        return t.getName().contains("手机");
    }
}
