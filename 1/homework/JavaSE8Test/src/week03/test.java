package week03;


import  java.util. Scanner;
public class test {
    public static void main (String[]args){
        System.out.println("请输入一个摄氏温度c=");
        Scanner sc= new    Scanner(System.in);
        double c=sc.nextDouble();
        double F=(9*c)/5+32;
        System.out.println("请输入一个华氏温度="+F);
        sc.close();
        }
}

