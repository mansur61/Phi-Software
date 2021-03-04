package com.company;

import java.util.ArrayList;
import java.util.List;

/*
İstenen çıktı

S - mavi - kot
S - yeşil - kot
S - mor - kot

M - mavi
M - yeşil
M - mor

XL - mavi
XL - yeşil
XL - mor

NOT: Yukarıdaki istenilen  işlev yerine getirilmiştir. Ek özellik eklenerek.
 dinamik parametre alımı sağlatılarak dinmaik fonksiyon oluşturulmaya çalışıldı. Fakat amaca göre fonksiyon dinamik olarak
 ayarlanmıştır / ayarlanmalıdır.
 Her amacı veya görevi yerine getirmemektedir.


 */
public class PhiTask2 {

    private static ArrayList<ArrayList<String>> yedek = new ArrayList<>();
    public static void main(String[] args){

        ArrayList<String > colors = new ArrayList<>();
        colors.add("mavi");
        colors.add("yeşil");
        colors.add("kırmızı");
        colors.add("mor");
        colors.add("sarı");
        yedek.add(colors);

        ArrayList<String > sizes = new ArrayList<>();
        sizes.add("S");
        sizes.add("S");
        /*sizes.add("S");
        sizes.add("S");
        sizes.add("S");
        sizes.add("S");*/
        sizes.add("XL");

        yedek.add(sizes);
        ArrayList<String > models = new ArrayList<>();
        models.add("Kot");
        models.add("Şapka");
        models.add("Kotfd");
        models.add("hırka");
        models.add("yelek");
        yedek.add(models);

        ArrayList<String > pairs = new ArrayList<>();
        pairs.add("55 TL");


        yedek.add(pairs);

        //stockInfo(yedek,"S","M","XS","XL"); // D // İlgili beden boyutundan/model/renk/... stokta kaç adet olduğunu bul.
        //stocktInfo(yedek,"S","M","XS","XL"); // E // S - mavi - kot - 55 TL mantığında sunulması


    }

    // D
    private static void stockInfo(ArrayList<ArrayList<String>> dataseta,String ...beden){
        int sayac = 0;
        try {
            for (String m: beden) {
                System.out.print(m + " den ");
                for (int i = 0; i < dataseta.size(); i++) {
                    for (int j = 0;j<dataseta.get(i).size();j++){
                        if(dataseta.get(i).get(j) == m){
                            sayac++;
                        }
                    }
                }
                System.out.print(sayac + " adet var."+"\n");
                sayac = 0;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // E
    private static  void stocktInfo(ArrayList<ArrayList<String> > products,String ...boyutlar){
        try {
            if (products.size() < 3) {
                System.out.println("Anlamlı bir yapı görmek için en az product diziniz 3 boyutlu olsun");
            } else {
            ArrayList<String> tut = new ArrayList<>();
            for (String word : boyutlar) {
                for (int j = 0; j < products.size(); j++) {
                    for (int k = 0; k < products.get(j).size(); k++) {
                        if (word == products.get(j).get(k)) {
                            for (int m = 0; m < products.get(j).size(); m++) {
                                tut.add(products.get(j).get(m));
                            }
                            products.remove(products.get(j));
                            break;
                        }
                    }
                }
            }
            // Aynı bedende 1 tane yazdırma
            for (int i = 0; i < tut.size(); i++) { // size
                for (int w = i + 1; w < tut.size(); w++) {
                    if (tut.get(i) == tut.get(w)) {
                        tut.remove(tut.get(w));
                    }
                }
                for (int j = 0; j < products.get(1).size(); j++) { //models
                    if (products.size() > 2) {
                        for (int k = 0; k < products.get(2).size(); k++) { //pairs
                            for (int m = 0; m < products.get(0).size(); m++) { //renk
                                System.out.println(tut.get(i) + "-" + products.get(0).get(m) + "-" + products.get(1).get(j) + "-" + products.get(2).get(k));
                            }
                        }
                    } else {
                        for (int m = 0; m < products.get(0).size(); m++) { //renk
                            System.out.println(tut.get(i) + "-" + products.get(0).get(m) + "-" + products.get(1).get(j));
                        }
                    }
                    System.out.println("---------------");
                }
            }
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
