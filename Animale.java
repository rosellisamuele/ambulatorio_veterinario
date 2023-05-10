public class Animale extends Thread{
    String specie;
    AmbulatorioVeterinario ambulatorio;

    public Animale(String specie, AmbulatorioVeterinario a, String nome){
        super(nome);
        this.specie = specie;
        this.ambulatorio = a;
    }

    @Override
    public void run() {
        int randomTime = (int) (Math.random() * 4000) + 1000;
        ambulatorio.entra(specie);
        try{
            sleep(randomTime);
        }catch(Exception e) {}
        ambulatorio.esce(specie);
    }

}
