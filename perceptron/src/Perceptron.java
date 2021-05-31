import java.util.ArrayList;
import java.util.List;

public class Perceptron {

  // List<Double> listaWektorWag = new ArrayList<>();
    double[] wektorWag;
   int iloscWymiarow;
   double odchylenie;
   double alfa;
   int iteracjePoD;
   private double accuracy;
   String wartoscDla1;
   String wartoscDla0;


   public Perceptron(double alfa,int iteracjePoD){

       this.alfa=alfa;
       odchylenie= 1-(Math.random() * 2);
       this.iteracjePoD=iteracjePoD;

   }

   public void wyucz(Object [] linijkiPlikuTren){

       double net;
       double d_i;
       double y_i;
       final double E_max = 0.0;
       double E=0;
       iloscWymiarow=((String)linijkiPlikuTren[0]).split(",").length-1;
       System.out.println(iloscWymiarow);
       wektorWag= new double[iloscWymiarow];
       double waga;
       wartoscDla1=((String)linijkiPlikuTren[0]).split(",")[iloscWymiarow];

       for(int i=0;i<iloscWymiarow;i++) {

           waga = 1-(Math.random() * 2);
           wektorWag[i]=waga;
           System.out.println(waga);
       }
      //  odchylenie=Math.random();
       for(int x=0;x<iteracjePoD;x++) {

           E=0;
           for (int i = 0; i < linijkiPlikuTren.length; i++) {



               net = 0;
               String[] linijkaTreningowa = ((String) linijkiPlikuTren[i]).split(",");
               if(!linijkaTreningowa[iloscWymiarow].equals(wartoscDla1))
                   wartoscDla0=linijkaTreningowa[iloscWymiarow];

                   for (int j = 0; j < iloscWymiarow; j++) {
                   net += wektorWag[j] * Double.parseDouble(linijkaTreningowa[j]);
               }

               net -= odchylenie;

               //obliczanie wartosci wyjsciowej perceotronu
               if (net >= 0)
                   y_i = 1;
               else y_i = 0;

               //obliczanie oczekiwanej wartosci wyjsciowej perceptronu

               d_i = (linijkaTreningowa[iloscWymiarow].equals(wartoscDla1) ? 1 : 0);
           //   System.out.println("wartoscdla1 "+wartoscDla1+"    "+linijkaTreningowa[iloscWymiarow] +"  " +d_i+"   "+y_i);
               //korygowanie

               for (int j = 0; j < iloscWymiarow; j++) {
                   wektorWag[j] = wektorWag[j] + (alfa * (d_i - y_i) * Double.parseDouble(linijkaTreningowa[j]));

               //    System.out.println("waga "+ wektorWag[j]);

               }

               odchylenie = odchylenie - (alfa * (d_i - y_i));
               E += (d_i - y_i) * (d_i - y_i);
            //   System.out.println("odchylenie "+odchylenie);

           }
           for (double e : wektorWag)
               System.out.println("WAGA " + e);
           System.out.println(odchylenie);

           E /= linijkiPlikuTren.length;
           System.out.println("E " + E);
           if (E<=E_max){
               break;
           }

       }
   }


   public double sprawdz(Object[] linijkiPlikuTest){
       int licznik=0;
       int mianownik=0;
      // double y_i;
       String wartoscZgadnieta;

       for (int i = 0; i < linijkiPlikuTest.length; i++) {
           double net = 0;
           String[] linijkaTestowa = ((String) linijkiPlikuTest[i]).split(",");
           for (int j = 0; j < iloscWymiarow; j++) {
               net += wektorWag[j] * Double.parseDouble(linijkaTestowa[j]);
               net -= odchylenie;

           }
           if (net >= 0)
               wartoscZgadnieta=wartoscDla1;
           else
               wartoscZgadnieta=wartoscDla0;


           if(linijkaTestowa[iloscWymiarow].equals(wartoscZgadnieta))
               licznik++;

           mianownik++;
           System.out.println(wartoscZgadnieta );
           }

       System.out.println(licznik +"/"+ mianownik);
       return (double)licznik/(double)mianownik;
       }

    public String sprwdzJeden(String linijkaTest) {

        String wartoscZgadnieta;
        double net = 0;

        String[] linijkaTestowa = linijkaTest.split(",");

        for (int j = 0; j < iloscWymiarow; j++)
            net += wektorWag[j] * Double.parseDouble(linijkaTestowa[j]);
          net -= odchylenie;

            if (net >= 0)
                wartoscZgadnieta=wartoscDla1;
            else
                wartoscZgadnieta=wartoscDla0;


        return  wartoscZgadnieta;

    }


}
