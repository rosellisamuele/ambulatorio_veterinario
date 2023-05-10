public class AmbulatorioVeterinario {
        
    private final int nPostiCani;
    private final int nPostiGatti;
    private int cani;
    private int gatti;
    private int gattiInAttesa;

    public AmbulatorioVeterinario(int nPostiCani, int nPostiGatti){
        this.nPostiCani = nPostiCani;
        this.nPostiGatti = nPostiGatti;
        this.cani = this.gatti = 0;
        this.gattiInAttesa = 0;
    }

    public synchronized void entra(String t) {
        String name = Thread.currentThread().getName();

        if(t.equalsIgnoreCase("gatto")){
            gattiInAttesa++;
        }

        while ( (t.equalsIgnoreCase("cane") && ( gatti >0 || gattiInAttesa > 0) ) ||
                (t.equalsIgnoreCase("gatto") && cani>0)||
                (gatti == nPostiGatti)  || ( cani == nPostiCani)  
        )  {
            try{ 
                wait();
            }catch(Exception e) {}
        }

        

        System.out.println(name+": entra nell'ambulatorio");
        
        if ( t.equalsIgnoreCase("cane") ) {
            cani++;
        }else if( t.equalsIgnoreCase("gatto")){
            gatti++;
            gattiInAttesa--;
        }
    }

    public synchronized void esce(String t){
        String name = Thread.currentThread().getName();

        if(t.equals("cane")){
            cani--;
        }else if(t.equals("gatto")){
            gatti--;
        }
        System.out.println(name+": esce dall'ambulatorio");
        notifyAll();
    }

}