import java.util.ArrayList;

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