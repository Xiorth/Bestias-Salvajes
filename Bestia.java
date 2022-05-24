public class Bestia
{
    private String nombre;
    private int salud;

    public Bestia(String nombre, int salud){
        this.nombre = nombre;
        this.salud = salud;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getSalud(){
        return this.salud;
    }

    @Override
    public String toString(){
        String texto = "|| CATEGORIA: Bestia " + this.getNombre() + " SALUD: " + this.getSalud() + " ||";
        return texto;

    }

    public void Disparar(){ 
        if(this.salud >= 1){ 
            this.salud = this.salud - 5; 
        } 

    }

    public void BombaAtomica(){ 
        this.salud = this.salud - this.salud; 
    } 

    public void Mutante(){
        if (this.salud >= 1){
            this.salud = this.salud * 2;  
        }
    }

    public void Conversion(){

        if(this.nombre.equals("Espacial")){
            this.nombre = this.nombre;
        }else{ 
            this.nombre = "Espacial"; 
        } 
    }
}