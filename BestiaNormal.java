public class BestiaNormal extends Bestia
{
    public BestiaNormal(String nombre, int salud){
        super(nombre,salud);
    }
    
    @Override
    public String toString(){
        String texto = "|| CATEGORIA: Bestia " + this.getNombre() + "   SALUD: " + this.getSalud() + " ||";
        return texto;

    }
}