class Comprador{
    Moneda D;
    Bebida A;
    Dulce C;
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cual, Expendedor exp){

        if(cual == exp.SPRITE || cual== exp.COCA) {
            try {
                A = exp.comprarBebida(m, cual);
            } catch (PagoIncorrectoException e) {
                throw new RuntimeException(e);
            }
        }
        else if(cual == exp.SNICKERS || cual== exp.SUPER8){
            try {
                try {
                    C= exp.comprarDulce(m,cual);
                } catch (NoHayProductoException e) {
                    throw new RuntimeException(e);
                }
            } catch (PagoIncorrectoException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                A= exp.comprarBebida(m,cual);
            } catch (PagoIncorrectoException e) {
                throw new RuntimeException(e);
            }
        }

        int suma = 0;

        try{
            D = exp.getVuelto();
        }catch (PagoInsuficienteException ex){}

        if (D == m && m != null) {
            vuelto = D.getValor();
        } else if (D == m && m==null) {
            vuelto = 0;
        } else {
            while (D != null && D != m) {
                vuelto = D.getValor() + suma;
                suma = vuelto;
                try {
                    D = exp.getVuelto();
                } catch (PagoInsuficienteException e) {
                    throw new RuntimeException(e);
                }
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
