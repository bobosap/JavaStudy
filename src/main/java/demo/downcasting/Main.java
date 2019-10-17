package demo.downcasting;

public class Main {

    public static final int THINKPAD = 0;
    public static final int MOUSE = 1;
    public static final int KEYBOARD = 2;




    public static void main(String[] args) {
	// write your code here
        ShopCar shopcar = new ShopCar();
        shopcar.add(new Thinkpad());
        shopcar.add(new Mouse());
        shopcar.add(new Keyboard());


        //get size
        System.out.println("购物车存放电子产品数量位-->"+shopcar.getSize());

//        Electronics electronic = shopcar.getListItem(0);
        Thinkpad thinkpad = (Thinkpad)shopcar.getListItem(THINKPAD);
        thinkpad.boot();
        thinkpad.program();


        Mouse mouse = (Mouse) shopcar.getListItem(MOUSE);
        mouse.move();

        Keyboard keyboard = (Keyboard) shopcar.getListItem(KEYBOARD);
        keyboard.input();

    }
}
