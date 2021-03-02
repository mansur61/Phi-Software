package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PhiTask {
    public  static ArrayList<ArrayList<String>> urunDetails = new ArrayList<>();

    public static void main(String[] args) {

        productInfo("Kazak","S","mavi");
        productInfo("kaZAk","XS","yesil");
        productInfo("kazak","XS","mor");
        productInfo("kazak3","XXL","mor");

        // En güzel yazdırma şekli
        //yazdir();

    }
    // urunDetail
    //urunDetails ile başka ürün veya özelliikerini ekleyebilme durumu olsun

    public static void productInfo(String product_name,String product_body_size,String product_color) {
        ArrayList<String> productAttributes = new ArrayList<>();
        boolean equalsProduct = true;
        // Ürün özelliklerini ekle
        productAttributes.add(product_name.toUpperCase());
        productAttributes.add(product_body_size.toUpperCase());
        productAttributes.add(product_color.toUpperCase());
        if ( (!product_name.isEmpty() && !product_name.isBlank() ) && (!product_body_size.isEmpty() && !product_body_size.isBlank())
                && (!product_color.isEmpty() && !product_color.isBlank()) && (!product_name.equals(product_body_size) )  && ( !product_name.equals(product_color) )
                && (!product_color.equals(product_body_size) ) ){
            try {
                if (urunDetails.size() > 0) {
                    for (int i = 0; i < urunDetails.size(); i++) {
                        if (urunDetails.get(i).contains(product_name.toUpperCase())) {
                            // aynı ürün fakat özellikleri farklı olma durumu
                            if (!urunDetails.get(i).contains(product_body_size.toUpperCase()) && !urunDetails.get(i).contains(product_color.toUpperCase())) { // renk ve beden aynı değilse
                                urunDetails.get(i).add(product_body_size.toUpperCase());
                                urunDetails.get(i).add(product_color.toUpperCase());
                            } else if (!urunDetails.get(i).contains(product_body_size.toUpperCase())) { // beden aynı değilse
                                urunDetails.get(i).add(product_body_size.toUpperCase());
                                urunDetails.get(i).add("");
                            } else if (!urunDetails.get(i).contains(product_color.toUpperCase())) { // renk aynı değilse
                                urunDetails.get(i).add("");
                                urunDetails.get(i).add(product_color.toUpperCase());
                            }
                            equalsProduct = true;
                            break;
                        } else {  equalsProduct = false; }
                    }
                    if (!equalsProduct)
                        urunDetails.add(productAttributes);
                } else { urunDetails.add(productAttributes);  }
                // teker teker görüp irdeleme babından yazdırılma durumu
                System.out.println(urunDetails);
                for (int i = 0; i < urunDetails.size(); i++) {
                    System.out.print(urunDetails.get(i).get(0) + " , ürününün ");
                    for (int j = 1; j < urunDetails.get(i).size(); j++) {
                        if (j % 2 == 1) {
                            if (!urunDetails.get(i).get(j).isEmpty()) {  System.out.print("\tbedeni " + urunDetails.get(i).get(j)+" "); } else { System.out.print("\t"); }
                        } else {
                            if (!urunDetails.get(i).get(j).isEmpty()) { System.out.print("rengi " + urunDetails.get(i).get(j) + " "+"\n"); } else {System.out.print("\t"); }
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
            System.out.println(urunDetails);
            for (int i = 0;i<urunDetails.size();i++){
                System.out.print(urunDetails.get(i).get(0)+" , ürününün ");
                for (int j = 1;j<urunDetails.get(i).size();j++){
                    if (j % 2 == 1){
                        if (!urunDetails.get(i).get(j).isEmpty()) {  System.out.print("\tbedeni " + urunDetails.get(i).get(j)+" "); }
                    }else{
                        if (!urunDetails.get(i).get(j).isEmpty()) { System.out.print("rengi " + urunDetails.get(i).get(j) + " "+"\n"); }                    }
                }
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }//  System.out.print("Mansur");
    }

}