public class App {
    public static void main(String[] args) throws Exception {
        AmbulatorioVeterinario a = new AmbulatorioVeterinario(2, 2);
        Animale gatti[] = {
            new Animale("gatto",a,"gatto1"),
            new Animale("gatto",a,"gatto2"),
            new Animale("gatto",a, "gatto3")
        };

        Animale cani[] = {
            new Animale("cane",a, "cane1"),
            new Animale("cane",a, "cane2"),
            new Animale("cane",a, "cane3")
        };

        for(int i=0; i<3; i++){
            cani[i].start();
        }

        for(int i=0; i<3; i++){
            gatti[i].start();
        }

        

    }
}
