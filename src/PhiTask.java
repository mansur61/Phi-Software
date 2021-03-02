import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PhiTask {
    public  static ArrayList<ArrayList<String>> urunDetay = new ArrayList<>();

    public static void main(String[] args) {

        urunBilgisi("Kazak","S","mavi");
        urunBilgisi("kaZAk","XS","yesil");
        urunBilgisi("kazak","XS","mor");
        urunBilgisi("kazak3","XXL","mor");

        // En güzel yazdırma şekli
        //yazdir();

    }
    // urunDetay ile başka ürün veya özelliikerini ekleyebilme durumu olsun

    public static void urunBilgisi(String urun_adi,String beden_boyutu,String urun_rengi) {
        ArrayList<String> urunOzellik = new ArrayList<>();
        boolean ayniUrunMu = true;
        // Ürün özelliklerini ekle
        urunOzellik.add(urun_adi.toUpperCase());
        urunOzellik.add(beden_boyutu.toUpperCase());
        urunOzellik.add(urun_rengi.toUpperCase());
        if ( (!urun_adi.isEmpty() && !urun_adi.isBlank() ) && (!beden_boyutu.isEmpty() && !beden_boyutu.isBlank())
        && (!urun_rengi.isEmpty() && !urun_rengi.isBlank()) && (!urun_adi.equals(beden_boyutu) )  && ( !urun_adi.equals(urun_rengi) )
        && (!urun_rengi.equals(beden_boyutu) ) ){
            try {
                if (urunDetay.size() > 0) {
                    for (int i = 0; i < urunDetay.size(); i++) {
                        if (urunDetay.get(i).contains(urun_adi.toUpperCase())) {
                            // aynı ürün fakat özellikleri farklı olma durumu
                            if (!urunDetay.get(i).contains(beden_boyutu.toUpperCase()) && !urunDetay.get(i).contains(urun_rengi.toUpperCase())) { // renk ve beden aynı değilse
                                urunDetay.get(i).add(beden_boyutu.toUpperCase());
                                urunDetay.get(i).add(urun_rengi.toUpperCase());
                            } else if (!urunDetay.get(i).contains(beden_boyutu.toUpperCase())) { // beden aynı değilse
                                urunDetay.get(i).add(beden_boyutu.toUpperCase());
                                urunDetay.get(i).add("");
                            } else if (!urunDetay.get(i).contains(urun_rengi.toUpperCase())) { // renk aynı değilse
                                urunDetay.get(i).add("");
                                urunDetay.get(i).add(urun_rengi.toUpperCase());
                            }
                            ayniUrunMu = true;
                            break;
                        } else {  ayniUrunMu = false; }
                    }
                    if (!ayniUrunMu)
                        urunDetay.add(urunOzellik);
                } else { urunDetay.add(urunOzellik);  }
                // teker teker görüp irdeleme babından yazdırılma durumu
                System.out.println(urunDetay);
                for (int i = 0; i < urunDetay.size(); i++) {
                    System.out.print(urunDetay.get(i).get(0) + " , ürününün ");
                    for (int j = 1; j < urunDetay.get(i).size(); j++) {
                        if (j % 2 == 1) {
                            if (!urunDetay.get(i).get(j).isEmpty()) {  System.out.print("\tbedeni " + urunDetay.get(i).get(j)+" "); } else { System.out.print("\t"); }
                        } else {
                            if (!urunDetay.get(i).get(j).isEmpty()) { System.out.print("rengi " + urunDetay.get(i).get(j) + " "+"\n"); } else {System.out.print("\t"); }
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {System.out.println(e.getMessage()); }
        }else{
            System.out.println("Ürün adı ve özelliklerini belirlerken boş bırakmayın veya aynı değer girmemeye dikkat ediniz.");
        }
    }
    public static void yazdir(){
        try {
            System.out.println(urunDetay);
            for (int i = 0;i<urunDetay.size();i++){
                System.out.print(urunDetay.get(i).get(0)+" , ürününün ");
                for (int j = 1;j<urunDetay.get(i).size();j++){
                    if (j % 2 == 1){
                        if (!urunDetay.get(i).get(j).isEmpty()) {  System.out.print("\tbedeni " + urunDetay.get(i).get(j)+" "); }
                    }else{
                        if (!urunDetay.get(i).get(j).isEmpty()) { System.out.print("rengi " + urunDetay.get(i).get(j) + " "+"\n"); }                    }
                }
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }


    }

}