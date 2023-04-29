public class Main {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(2,500,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = null;
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda100();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda100();
        c = new Comprador(m,exp.SUPER8,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SUPER8,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SUPER8,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SUPER8,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
    }
}
