package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Character,Integer> dictionary = new HashMap<Character, Integer>();
        System.out.println("Введите две строки : ");
        Scanner in=new Scanner(System.in);
        boolean Flag=false;
        String str1=in.next();
        String str2=in.next();
        //ключ-кол-во
        for(int i=0;i<str1.length();i++){
            if(!dictionary.containsKey(str1.charAt(i))){ //При отсутствии в словаре заданногозначения ключа, добавляем
                dictionary.put(str1.charAt(i),1);
            }

            else dictionary.put(str1.charAt(i),(dictionary.get(str1.charAt(i)))+1); //иначе Количество +1
        }

        for(int i=0;i<str2.length();i++){
            //если такой буквы нет в словаре
            if(!dictionary.containsKey(str2.charAt(i))){
                System.out.print("Комбинация неверна");
                Flag=true;
                break;
            }
            else if(dictionary.get(str2.charAt(i))==0){
                System.out.print("Комбинация неверна");
                Flag=true;
                break;
            }
            else {
                dictionary.put(str2.charAt(i), (dictionary.get(str2.charAt(i)))-1);
                if(dictionary.get(str2.charAt(i))==0){dictionary.remove(str2.charAt(i));}
            }

        }
        if(dictionary.size() == 0){
            System.out.print("Введена правильная комбинация");
        }
        else if(!Flag)
            System.out.print("Введена неправильная комбинация");
    }
}