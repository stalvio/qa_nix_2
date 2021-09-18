package ua.com.alevel;

public class MainMathSet {

    public static void main(String[] args) {
        Number[] arrNum1 = {3, 4, 5, 7, 8,0};
        Number[] arrNum2 = {8, 4, 2, 12, 1, 30, 8, 10};
        Number[] arrNum3 = {2, 4, 5, 3};
        Number[] arrNum4 = {93, 440, 641};

        Number[][] arrOfArr = {arrNum1, arrNum2, arrNum3};

//        MathSet test1 = new MathSet(arrNum1);
          MathSet test2 = new MathSet();
//        MathSet test3 = new MathSet(new Number[]{3});

        System.out.println(test2.toString());
        test2.add(4.3,3.6,2.08,1.54,7.76,null,-10.21);

        System.out.println(test2.toString());
        System.out.println(test2.getMax());
        System.out.println(test2.getMin());
        test2.sortAsc();
        System.out.println(test2.toString());
        Number[] numArr = test2.toArray(2, 3);
        for(Number num: numArr) {
            System.out.println("num = " + num);
        }
        System.out.println(test2.cut(2,4));
        System.out.println(test2.toString());
        test2.clear(arrNum3);
        System.out.println(test2.toString());



//        test2.sortDesc(3);
//        System.out.println(test2.toString());
//        System.out.println(test2.get(4));
//        System.out.println(test2.getMax());
//        System.out.println(test2.toString());
//        System.out.println(test2.getMin());
//        System.out.println(test2.toString());
//        System.out.println(test2.get(3));
//        System.out.println(test2.getAverage());


//        System.out.println(test3.toString());



//        test1.add(arrNum1);
//        System.out.println(test1.toString());
//
//        MathSet test3 = new MathSet(arrNum2);
//        System.out.println(test3.toString());
//
//        MathSet test4 = new MathSet(3);
//        System.out.println(test4.toString());
//
//        MathSet test5 = new MathSet(arrOfArr);
//        System.out.println(test5.toString());



    }
}
