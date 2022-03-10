package NarcissisticNumber;

import java.util.Scanner;

/***
 * 三位数水仙花数
 *
 * 拓展：键盘录入数据，判断并输出此数据之内的所有水仙花数
 */

public class NarcissisticNumber {
    /*
    public static void main(String[] args){
        int i,j,k,num,a=0;
        System.out.println("一千以内的水仙花数为：");
        for(num = 100; num < 1000; num ++)
        {
            i = num % 10;
            j = num / 10 %10;
            k = num / 100;
            if(i*i*i+j*j*j+k*k*k==num){
                System.out.println(num);
                a++;
            }
        }
        System.out.println("\n共有"+a+"个\n");
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //键盘录入水仙花数的范围

        System.out.println("\n请输入要计算的水仙花数的最大范围：");
        int num = sc.nextInt();

        //检测数据是否可行
        if (num < 100) {
            System.out.println("请正确输入数据（三位整数）！");
            return;
        }

        //n用来存放数据的位数； num3存放“i*i*i+j*j*j+k*k*k”； a用来记录水仙花的数目
        int n, num3, a = 0;

        System.out.print(num + "以内的水仙花数有：");

        //num2用来遍历从100至输入的数字的所有数据
        for (int num2 = 100; num2 <= num; num2++) {
            n = wei(num2);
            num3 = jisuan(num2, n);

            //判断此数是不是水仙花数
            if (num3 == num2) {
                if (a != 0)
                    System.out.print("、 ");
                if (a % 8 == 0)
                    System.out.println("\n");
                System.out.print(num3);
                a++;
            }
        }
        if (a == 0) {
            System.out.println("\b\b\b\b\b\b\b没有水仙花数!");
            return;
        }
        System.out.println("\n共有" + a + "个水仙花数!");
    }

    //判断sum是几位数
    public static int wei(int sum) {
        int n = 0;
        while (sum > 0) {
            sum = sum / 10;
            n++;
        }
        return n;
    }

    //num为数值，n是num的位数，计算水仙花的值
    public static int jisuan(int num, int n) {
        int sum = num, num2 = 1, number = 0;
        int arr[] = new int[n];

        //将每个位的数字提取存放至数组arr[]中
        for (int i = 0; i < n; i++) {
            arr[i] = sum % 10;
            sum = sum / 10;
        }

        //计算“i*i*i+j*j*j+k*k*k”
        for (int i = 0; i < n; i++) {
            num2 = arr[i];
            for (int j = 1; j < n; j++) {
                num2 = arr[i] * num2;
            }

            //将不同位的“i*i*i”加起来
            number += num2;
        }
        return number;
    }
}
