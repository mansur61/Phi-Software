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
        pairs.add("12 TL");
        //yedek.add(pairs);


        pairs.add("554 TL");
        pairs.add("124 TL");


        pairs.add("5548 TL");
        pairs.add("1240 TL");

        yedek.add(pairs);


        //stocktInfo(colors, sizes, models); // A
        /*
        stocktInfo(colors, sizes, models); çıktısı
            S - mavi - kot
            S - yeşil - kot
            S - mor - kot
         */
        //stocktInfo(); // ilgili beden ve renkten hangi modeller var // B
        //stocktInfo(sizes, models); // ilgili bedene göre renkleri sunar  // C
        //stocktInfo(models, colors); // ilgili modele ait hangi renkler var // C
        //stockInfo(yedek,"S","M","XS","XL"); // D // İlgili beden boyutundan/model/renk/... stokta kaç adet olduğunu bul.
        //stocktInfo(yedek,"S","M","XS","XL"); // E // iligili bedene ait ürünün belirlenen dinamik fiyata göre sunulması
        stocktInfo(colors, sizes, models,pairs); // F , E ile aynı işlevi görür


    }
    // A
    private  static  void stocktInfo(ArrayList<String> colors,ArrayList<String> sizes,ArrayList<String> models){
        //System.out.println(colors.size() + "-" + sizes.size() + "-" + models.size());
        try {
            if(colors.size() != 0 && sizes.size() != 0 && models.size() != 0){
                for (int i = 0;i<sizes.size();i++){
                    for (int k = 0;k<models.size();k++){
                        for (int j = 0;j<colors.size();j++){
                            System.out.print(sizes.get(i) + "-" +colors.get(j) +"-"+ models.get(k) + "\n");
                        }
                        System.out.println("-------");
                    }
                    System.out.println("\n");
                }
            }else{
                System.out.println("productInfo, değerlerinden en az bir tane giriniz");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    // B
    private static  void stocktInfo(){

        if(yedek.size() != 0 ){
            System.out.println(yedek);
            try{
                for (int i = 0;i<yedek.get(0).size();i++){ //renk
                    for (int k = 0;k<yedek.get(1).size();k++){ //beden
                        if(k + 1 < yedek.get(1).size()){
                            if(yedek.get(1).get(k) != yedek.get(1).get(k+1)){
                                for (int j = 0;j<yedek.get(2).size();j++){ // model

                                    System.out.print(yedek.get(1).get(k) + "-" +yedek.get(0).get(i) +"-"+ yedek.get(2).get(j) + "\n");
                                }
                                System.out.println("-------");
                            }
                        }else{
                            for (int j = 0;j<yedek.get(2).size();j++){ // model

                                System.out.print(yedek.get(1).get(k) + "-" +yedek.get(0).get(i) +"-"+ yedek.get(2).get(j) + "\n");
                            }
                            System.out.println("-------");
                        }
                    }
                    System.out.println("\n");
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("index değeri sınırı aşıldı");
            }

        }else{
            System.out.println("productInfo, değerlerinden en az bir tane giriniz");
        }


    }
    // C
    private  static  void stocktInfo(ArrayList<String> sizes,ArrayList<String> models){
        try {
            for (int i = 0;i<sizes.size();i++){
                for (int k = 0;k<models.size();k++){
                    //for (int j = 0;j<colors.size();j++){
                    System.out.print(sizes.get(i) +"-"+ models.get(k) + "\n");
                    //}
                    // System.out.println("-------");
                }
                System.out.println("\n");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

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
        //System.out.println(products);
        try {
            ArrayList<String> tut = new ArrayList<>();

            for (String  word: boyutlar) {
                System.out.println(word);
                for (int j = 0; j < products.size(); j++) {
                    for (int k = 0; k < products.get(j).size(); k++) {
                        if (word == products.get(j).get(k)) {
                            //products.remove(products.get(j));
                            for (int m = 0; m<products.get(j).size();m++){
                                //if(products.get(j).get(k) != products.get(j).get(m+1)) {
                                tut.add(products.get(j).get(m));
                                //}
                            }
                            products.remove(products.get(j));
                            break;
                        }
                    }
                }
            }
            //System.out.println(products);
            //System.out.println(tut);
            for (int i = 0;i<tut.size();i++){ // size
                for (int w = i+1;w<tut.size();w++) {
                    if(tut.get(i) == tut.get(w)){
                        tut.remove(tut.get(w));
                    }
                }
                //System.out.println(tut);
                for (int j = 0;j<products.get(1).size();j++){ //models
                    for (int k = 0;k<products.get(2).size();k++){ //pairs
                        for (int m = 0;m<products.get(0).size();m++){ //renk
                            System.out.println(tut.get(i) + "-"+products.get(0).get(m) + "-"+products.get(1).get(j)+"-"+products.get(2).get(k));
                        }

                    }
                    System.out.println("---------------");
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    // F
    private  static  void stocktInfo(ArrayList<String> colors,ArrayList<String> sizes,ArrayList<String> models,ArrayList<String> ...c){

        try {
            if(colors.size() != 0 && sizes.size() != 0 && models.size() != 0){
                for (ArrayList<String> pairs:c){
                    for (int m = 0;m<pairs.size();m++){
                        for (int i = 0;i<sizes.size();i++){
                            for (int k = 0;k<models.size();k++){
                                for (int j = 0;j<colors.size();j++){
                                    //for (ArrayList<String> pairs:c) {
                                    //  for (int m = 0;m<pairs.size();m++)
                                    System.out.print(sizes.get(i) + "-" + colors.get(j) + "-" + models.get(k) + "-" + pairs.get(m)+ "\n");
                                    //}
                                }
                                System.out.println("-------");
                            }
                            System.out.println("\n");
                        }
                    }

                }


            }else{
                System.out.println("productInfo, değerlerinden en az bir tane giriniz");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



}
