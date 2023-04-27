import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(2,600,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SPRITE,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.COCA,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda100();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,exp.SNICKERS,exp);
        System.out.println(c.queSacaste()+", "+c.cuantoVuelto());
        m = null;
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

abstract class Moneda{
    public Moneda(){
        super();
    }
    public Moneda getSerie(){
        return this.getSerie();
    }
    public abstract int getValor();
}

class Expendedor {
    Moneda B;
    private Deposito coca;
    private Deposito sprite;
    private Deposito monVu;
    private Deposito monVu100;

    private Deposito super8;

    private Deposito snickers;

    private int precioBebidas,precioDulces,num;
    private int n1 = 1, n2 = 11, n3=111, n4=1111;

    private int aux,cual,j=0,j2=0,j3=0,j4=0;
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public static final int SUPER8=3;

    public static final int SNICKERS=4;

    public Expendedor(int num, int precioBebidas,int precioDulces) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu100 = new Deposito();
        monVu = new Deposito();
        snickers= new Deposito();
        super8= new Deposito();

        this.precioBebidas= precioBebidas;
        this.precioDulces=precioDulces;
        this.num=num;

        for (int i = 0; i < num; i++) {
            sprite.addBebida(new Sprite(n2));
            n2++;
        }
        for (int i = 0; i < num; i++) {
            coca.addBebida(new CocaCola(n1));
            n1++;
        }

        for (int i = 0; i < num; i++) {
            super8.addDulce(new Super8(n3));
            n3++;
        }

        for (int i = 0; i < num; i++) {
            snickers.addDulce(new Snickers(n4));
            n4++;
        }

        for (int i = 0; i < 1000; i++) {
            monVu100.addMoneda(new Moneda100());
        }
    }

    public Bebida comprarBebida(Moneda m, int cual) {
        this.cual=cual;
        if(m!=null) {
            aux = m.getValor() - precioBebidas;
            monVu.addFirstMoneda(m);
            B = m;

            if (cual == COCA && coca != null && aux >= 0) {
               j++;
               return coca.getBebida();
            } else if (cual == SPRITE && sprite != null && aux >= 0) {
                j2++;
                return sprite.getBebida();
            } else {
                return null;
            }
        }
        else{

            return null;
        }
    }

        public Dulce comprarDulce(Moneda m, int cualdulce) {
            this.cual = cualdulce;
            if (m != null) {
                aux = m.getValor() - precioDulces;
                monVu.addFirstMoneda(m);
                B = m;

                if (cual == SNICKERS && snickers != null && aux >= 0) {
                    j3++;
                    return snickers.getDulce();
                } else if (cual == SUPER8 && super8 != null && aux >= 0) {
                    j4++;
                    return super8.getDulce();
                } else {
                    return null;
                }
            }
            else{
                return null;
            }
        }

    public Moneda getVuelto(){
        if(monVu!=null ) {
            if (aux > 0 && cual == COCA && monVu100!=null && j<=num ) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SPRITE && monVu100!=null && j2<=num) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }
            else if (aux > 0 && cual == SNICKERS && monVu100!=null && j3<=num ) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SUPER8 && monVu100!=null && j4<=num) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }  else if (aux == 0 && cual == COCA && j<=num) {
                return null;
            } else if (aux == 0 && cual == SPRITE && j2<=num) {
                return null;
            } else if (aux == 0 && cual == SNICKERS && j3<=num) {
                return null;
            } else if (aux == 0 && cual == SUPER8 && j4<=num) {
                return null;
            }
            else{
                return monVu.getMoneda();
            }
        }
        else{
            return null;
        }
    }
}
abstract class Bebida{
    private int serie;

    public Bebida(int serie){
        super();
        this.serie=serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        String b="sprite";
        return b;
    }

}

class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }
    public String beber(){
        String b="cocacola";
        return b;
    }

}

class Deposito{
    private ArrayList<Bebida> listabebida;
    private ArrayList<Moneda> listamoneda;

    private ArrayList<Dulce> listadulce;

    public Deposito(){
        listabebida= new ArrayList<Bebida>();
        listamoneda= new ArrayList<Moneda>();
        listadulce= new ArrayList<Dulce>();
    }
    public void addBebida(Bebida x){
        listabebida.add(x);
    }
    public void addMoneda(Moneda y){
        listamoneda.add(y);
    }

    public void addDulce(Dulce z){
        listadulce.add(z);
    }
    public void addFirstMoneda(Moneda y){
        listamoneda.add(0,y);
    }
    public Bebida getBebida(){
        if(listabebida.size()!=0){
            return listabebida.remove(0);
        }
        else{
            return null;
        }
    }
    public Dulce getDulce(){
        if(listadulce.size()!=0){
            return listadulce.remove(0);
        }
        else{
            return null;
        }
    }

    public Moneda getMoneda(){
        if(listamoneda.size()!=0){
            return listamoneda.remove(0);
        }
        else{
            return null;
        }
    }
}

class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }
    public int getValor(){
        return 1500;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}


class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    public int getValor(){
        return 1000;
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}
class Comprador{
    Moneda D;
    Bebida A;
    Dulce C;
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cual, Expendedor exp){

        if(cual == exp.SPRITE || cual== exp.COCA) {
            A = exp.comprarBebida(m, cual);
        }
        else if(cual == exp.SNICKERS || cual== exp.SUPER8){
            C= exp.comprarDulce(m,cual);
        }
        else{
            A= exp.comprarBebida(m,cual);
        }

        int suma = 0;

        D = exp.getVuelto();

        if (D == m && m != null) {
            vuelto = D.getValor();
        } else if (D == m && m==null) {
            vuelto = 0;
        } else {
            while (D != null && D != m) {
                vuelto = D.getValor() + suma;
                suma = vuelto;
                D = exp.getVuelto();
            }
        }
        if (cual == exp.COCA && A != null) {
            sonido = A.beber();
        } else if (cual == exp.SPRITE && A != null) {
            sonido = A.beber();
        } else if (cual == exp.SNICKERS && C != null) {
            sonido = C.comer();
        } else if (cual == exp.SUPER8 && C != null) {
            sonido = C.comer();
        } else {
            sonido = null;
        }

    }

    public int cuantoVuelto(){
        return vuelto;
    }
    public String queSacaste(){
        return sonido;
    }
}
abstract class Dulce{
    private int serie;

    public Dulce(int serie){
        super();
        this.serie=serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String comer();
}

class Super8 extends Dulce {
    public Super8(int serie){
        super(serie);
    }

    public String comer() {
        String b = "nam nam";
        return b;
    }
}
class Snickers extends Dulce {
    public Snickers(int serie){
        super(serie);
    }

    public String comer(){
        String b = "num num";
        return b;
    }
}

class NoHayProductoException extends Exception{
    public NoHayProductoException(String mensaje){
        super(mensaje);
    }
}

class PagoInsuficienteException extends Exception{
    public  PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

class PagoIncorrectoException extends  Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
