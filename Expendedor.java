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

    private int aux,cual,j=-1,j2=-1,j3=-1,j4=-1;
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public static final int SNICKERS=3;

    public static final int SUPER8=4;


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

    public Bebida comprarBebida(Moneda m, int cual) throws NoHayProductoException,PagoIncorrectoException{
        this.cual=cual;
        if(m!=null) {
            aux = m.getValor() - precioBebidas;
            monVu.addFirstMoneda(m);
            B = m;

            if (cual == COCA && aux >= 0 && coca.MsizeBebida()>0) {
                return coca.getBebida();
            } else if (cual == SPRITE  && aux >= 0 && sprite.MsizeBebida()>0) {
                return sprite.getBebida();
            } else if(cual==COCA && coca.MsizeBebida()==0){ //aqui nohayproductoexceptiom porque el deposito coca esta vacio
                j=0;
                throw new NoHayProductoException("ERROR!!! NO HAY COCACOLA");
            } else if(cual== SPRITE && sprite.MsizeBebida()==0){ //aqui nohayproductoexceptiom porque el deposito sprite esta vacio
                j2=0;
                throw new NoHayProductoException("ERROR!!! NO HAY SPRITE");
            } else {
                return null;
            }
        }

        else{ // esto es de pagoincorrectoexception porque aqui te devuelve botella null si es que metes moneda null
            throw new PagoIncorrectoException("Error!!! Pago incorrecto");
        }
    }

    public Dulce comprarDulce(Moneda m, int cualdulce) throws NoHayProductoException,PagoIncorrectoException {
        this.cual = cualdulce;
        if (m != null) {
            aux = m.getValor() - precioDulces;
            monVu.addFirstMoneda(m);
            B = m;

            if (cual == SNICKERS &&  aux >= 0 && snickers.MsizeDulce()>0) {
                return snickers.getDulce();
            } else if (cual == SUPER8 && aux >= 0 && super8.MsizeDulce()>0) {
                return super8.getDulce();
            } else if(cual== SNICKERS && snickers.MsizeDulce()==0){ //aqui nohayproductoexceptiom
                j3=0;
                throw new NoHayProductoException("ERROR!!! NO HAY SNICKERS");
            } else if(cual==SUPER8 && super8.MsizeDulce()==0){ //aqui nohayproductoexceptiom
                j4=0;
                throw new NoHayProductoException("ERROR!!! NO HAY SUPER8");
            } else {
                return null;
            }
        }
        else{ // esto es de pagoincorrectoexception porque aqui te devuelve dulce null si es que metes moneda null
            throw new PagoIncorrectoException("ERROR!!! Pago Incorrecto");
        }
    }

    public Moneda getVuelto() throws PagoInsuficienteException{
        if(monVu!=null ) {
            if (aux > 0 && cual == COCA && monVu100!=null && coca.MsizeBebida()+1>0 && j!=0 ) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SPRITE && monVu100!=null && sprite.MsizeBebida()+1>0 && j2!=0) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }
            else if (aux > 0 && cual == SNICKERS && monVu100!=null && snickers.MsizeDulce()+1>0 && j3!=0) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            } else if (aux > 0 && cual == SUPER8 && monVu100!=null && super8.MsizeDulce()+1>0 && j4!=0) {
                Moneda B;
                B = monVu100.getMoneda();
                aux = aux - B.getValor();
                return B;
            }  else if (aux == 0 && cual == COCA && coca.MsizeBebida()+1>0 && j!=0) {
                return null;
            } else if (aux == 0 && cual == SPRITE && sprite.MsizeBebida()+1>0 && j2!=0) {
                return null;
            } else if (aux == 0 && cual == SNICKERS && snickers.MsizeDulce()+1>0 && j3!=0) {
                return null;
            } else if (aux == 0 && cual == SUPER8 && super8.MsizeDulce()+1>0 && j4!=0) {
                return null;

            } else if(aux<0) { // aqui pago insuficienteexception porque valor de moneda menos precio de alimento es menor a 0
                throw new PagoInsuficienteException(monVu.getMoneda());
            } else if(j==0){
                return monVu.getMoneda();
            } else if(j2==0){
                return monVu.getMoneda();
            } else if(j3==0){
                return monVu.getMoneda();
            } else if(j4==0) {
                return monVu.getMoneda();
            } else{
                return monVu.getMoneda();
            }
        }
        else{
            return null;
        }
    }
}
