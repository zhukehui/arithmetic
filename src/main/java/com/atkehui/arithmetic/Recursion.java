package com.atkehui.arithmetic;

/**
 * @author eternity
 * @create 2019-11-21 16:56
 * <p>
 * 递归  就是方法自己调用自己,每次调用时传入不同的变量.递归有助于编程者解决复杂的问题,同时可以让代码变得简洁。
 */
public class Recursion {
    public static void main(String[] args) {
//        test(5);
//        int result = factorial(6);
//        System.out.println(result);

        int[][] map = new int[8][7];
        //上下全部置1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归给小球找路
        setWay(map,1,1);

        //小球走过标识过的地图
        System.out.println("小球走过标识过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    //下面代码的找路策略是:下右上左

    /**
     *
     * @param map 表示地图
     * @param i  从哪个位置开始找
     * @param j  从哪个位置开始找
     * @return  如果找到通路，返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 表示路已经找到了
            return true;
        } else {
            if (map[i][j] == 0) { // 0: 可以走还没有走
                // 这里开始递归回溯
                map[i][j] = 2; // 认为该点是可以走通,但是不一定
                if (setWay(map, i + 1, j)) { // 下找
                    return true;
                } else if (setWay(map, i, j + 1)) { // 右
                    return true;
                } else if (setWay(map, i - 1, j)) { // 上
                    return true;
                } else if (setWay(map, i, j - 1)) { // 左
                    return true;
                } else {// 走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map(i)(j)!=0
                //则值 1,2,3
                return false;
            }
        }
    }


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;//阶乘：6*5*4*3*2*1
        }
    }
}
/**
 * 递归需要遵守的重要规则
 * <p>
 * 1、执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
 * 2、方法的局部变量是独立的，不会相互影响, 比如n变量
 * 3、如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
 * 4、递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死龟了:)
 * 5、当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
 */
