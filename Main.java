import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Expendedor exp = new Expendedor(4,500);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
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

    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public int precioBebidas,num;
    int n1 = 1, n2 = 11;

    int aux,cual,j=0,j2=0;
    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu100 = new Deposito();
        monVu = new Deposito();
        this.precioBebidas = precioBebidas;
        num=numBebidas;

        for (int i = 0; i < numBebidas; i++) {
            sprite.addBebida(new Sprite(n2));
            n2++;
        }
        for (int i = 0; i < numBebidas; i++) {
            coca.addBebida(new CocaCola(n1));
            n1++;
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
            B=m;

            if (cual == COCA && coca != null && aux>=0){// && k!=num && aux>0) {
                j++;
                return coca.getBebida();
            }
            else if(cual == SPRITE && sprite != null && aux>=0){ //&& k!=num && aux>0){
                j2++;
                return sprite.getBebida();
            }
            else{
                return null;
            }
        }
        else{

            return null;
        }
    }
    public Moneda getVuelto() {
        if(monVu!=null && B!=null) {
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
            } else if (aux == 0 && cual == COCA && j<=num) {
                return null;
            } else if (aux == 0 && cual == SPRITE && j2<=num) {
                return null;
            } else if (cual != COCA && cual != SPRITE) {
                aux=0;
                return monVu.getMoneda();
            } else if (aux < 0) {
                aux=0;
                return monVu.getMoneda();
            }
            else if(j>num && aux>0){
                aux=0;
                return monVu.getMoneda();
            }
            else if(j2>num && aux>0){
                aux=0;
                return monVu.getMoneda();
            }
            else{
                return null;
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
    public Deposito(){
        listabebida= new ArrayList<Bebida>();
        listamoneda= new ArrayList<Moneda>();
    }
    public void addBebida(Bebida x){
        listabebida.add(x);
    }
    public void addMoneda(Moneda y){
        listamoneda.add(y);
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

    public int Msize() {
        return listamoneda.size();
    }

    public Moneda getMoneda(){
        if(listamoneda.size()!=0){
            return listamoneda.remove(0);
        }
        else{
            return null;
        }
    }
    public Moneda getLastMoneda(){
        if(listamoneda.size()!=0){
            return listamoneda.remove(listamoneda.size()-1);
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
    Moneda B;
    Bebida A;
    private String sonido;
    private int vuelto;
    int aux;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        A= exp.comprarBebida(m,cualBebida);
        B=m;
        int suma=0;

        D=exp.getVuelto();

        if(D==m && D!=null){
            vuelto=D.getValor();
        }
        else if(D==null){
            vuelto=0;
        }
        else {
            while (D != null && D != m) {
                vuelto = D.getValor() + suma;
                suma = vuelto;
                D = exp.getVuelto();
            }
        }

        if (cualBebida == exp.COCA && A!=null) {
            sonido = "cocacola";
        }
        else if (cualBebida == exp.SPRITE && A!=null) {
            sonido = "sprite";
        }
        else {
            sonido = null;
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
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
