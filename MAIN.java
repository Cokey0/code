// 设计一个交互界面（例如菜单）供用户选择，如果可能，最好
// 是一个图形化用户界面；
// 2、 能够人工输入或随机产生一个长度为 n 的整数数组，要求数组
// 任意两个元素都互不相同；
// 3、 设计一个算法判断要求 2 中产生的整数数组是否为未排序（输
// 出 0）、升序（输出 1）、降序（输出 2）、先升后降（输出 3）、
// 或先降后升（输出 4）状态；
// 4、 给定某具体元素，使用顺序检索算法判断该具体元素是否出现
// 在要求 2 中产生的数组中，并统计关键字比较的次数；
// 5、 给定某具体元素，使用二分检索算法判断该具体元素是否出现
// 在要求 2 中产生的升序或降序的数组中，并统计关键字比较的次
// 数；
// 6、 给定某具体元素，使用三分检索算法判断该具体元素是否出现
// 在要求 2 中产生的升序或降序的数组中，并统计关键字比较的次
// 数；
// 7、 给定先升后降（或先降后升）数组，使用二分检索思路查找该
// 数组的最大值（或最小值），并统计关键字比较的次数。
// 附加：给定某具体元素，使用二分检索算法判断该具体元素是否
// 出现在要求 2 中产生的升序或降序的数组中，若出现，返回具体元素
// 所在的位置，否则，返回小于且最接近该具体元素的位置。
package Java.EP2;

import java.util.Random;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MAIN {

    private int[] arr;
    private int length;

    // 构造函数初始化
    public MAIN(int length) {
        this.length = length;
        // arr = new int[length];
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************************************");
        System.out.println("选择数组获取方式: ");
        System.out.println("1. 随机生成唯一数组");
        System.out.println("2. 手动输入数组");
        System.out.println("******************************************************************");
        int method = scanner.nextInt();
        if (method == 1) {
            arr = uniqueRandomArray(length);
        } else if (method == 2) {
            arr = cinArray(length);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("******************************************************************");

    }

    // 生成唯一随机数组
    public int[] uniqueRandomArray(int arrayLength) {
        Random random = new Random();
        int[] arr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int temp;
            boolean unique;
            do {
                temp = random.nextInt(length * 10);
                unique = true;
                for (int j = 0; j < i; j++) {
                    if (arr[j] == temp) {
                        unique = false;
                        break;
                    }
                }
            } while (!unique);
            arr[i] = temp;
        }
        return arr;
    }

    // 手动输入数组
    public int[] cinArray(int arrayLength) {
        if (arrayLength <= 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[arrayLength];
        System.out.println("请输入数组元素(数组长度为" + arrayLength + "): ");
        for (int i = 0; i < arrayLength; i++) {
            while (true) {
                // System.out.print("请输入数组元素" + "(数组长度为" + arrayLength + ")：" + (i + 1) + ": ");
                try {
                    arr[i] = scanner.nextInt();
                    break; // 输入正确，跳出循环
                } catch (InputMismatchException e) {
                    System.out.println("输入无效，请输入一个整数。");
                    scanner.next(); // 清空无效输入
                }
            }
        }
        System.out.print("数组(n=" + arrayLength + "): ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    // 对数组进行正排序
    public int[] order(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int checkArrayOrder(int[] arr) {
        boolean isAscending = true; // 是否升序
        boolean isDescending = true; // 是否降序

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isDescending = false; // 发现升序，不是降序
            } else if (arr[i] > arr[i + 1]) {
                isAscending = false; // 发现降序，不是升序
            }
        }

        if (isAscending) {
            System.out.println("数组为升序");
            return 1; // 升序
        } else if (isDescending) {
            System.out.println("数组为降序");
            return 2; // 降序
        } else {
            // 检查是否为先升后降或先降后升
            boolean isFirstPartAscending = false;
            boolean isSecondPartDescending = false;
            boolean isFirstPartDescending = false;
            boolean isSecondPartAscending = false;

            // 检测先升后降的情况
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    if (isFirstPartDescending) {
                        System.out.println("数组为先升后降");
                        return 3; // 先升后降
                    }
                    isFirstPartAscending = true;
                } else if (arr[i] > arr[i + 1]) {
                    if (isFirstPartAscending) {
                        isFirstPartDescending = true;
                    }
                }
            }

            // 检测先降后升的情况
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    if (isFirstPartAscending) {
                        System.out.println("数组为先降后升");
                        return 4; // 先降后升
                    }
                    isFirstPartDescending = true;
                } else if (arr[i] < arr[i + 1]) {
                    if (isFirstPartDescending) {
                        System.out.println("数组为先升后降");
                        return 4; // 先降后升
                    }
                }
            }
        }

        return 0; // 未排序
    }

    // 顺序检索
    public void search(int[] array, int target) {
        System.out.println("当前数组"+Arrays.toString(array));
        int count = 1;
        int end = 2;
        for (int i = 0; i < array.length; i++, count++, end++) {
            if (array[i] == target) {
                System.out.println("元素" + target + "在数组中第" + (i + 1) + "个位置");
                break;
            }
        }
        if (end > array.length) {
            System.out.println("元素" + target + "不在数组中");
        }
        System.out.println("关键字比较次数：" + count);
    }

    // 二分检索
    public void binarySearch(int[] array, int target) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        System.out.println("原始数组"+Arrays.toString(tempArray));
        int[] orderedArray = order(tempArray);
        System.out.println("当前数组"+Arrays.toString(orderedArray));

        int low = 0;
        int high = orderedArray.length - 1;
        int count = 0;
        boolean running = true;
        while (running) {
            int mid = low + (high - low) / 2;
            count++;
            if (orderedArray[mid] == target) {
                System.out.println("元素" + target + "在数组中第" + (mid + 1) + "个位置");
                System.out.println("关键字比较次数：" + count);
                break;
            }
            if (orderedArray[mid] > target) {
                if (mid <= low) {
                    System.out.println("元素" + target + "不在数组中");
                    System.out.println("关键字比较次数：" + count);
                    running = false;
                }
            }
            if (orderedArray[mid] < target) {
                if (mid >= high) {
                    System.out.println("元素" + target + "不在数组中");
                    System.out.println("关键字比较次数：" + count);
                    running = false;
                }
            }
            if (orderedArray[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    // 三分检索
    public void ternarySearch(int[] array, int target) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        System.out.println("当前数组"+Arrays.toString(tempArray));
        int[] orderedArray = order(tempArray);
        int low = 0;
        int high = orderedArray.length - 1;
        int comparisonCount = 0;
        boolean isAscending = (orderedArray[low] < orderedArray[high]);
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            comparisonCount++;
            if (orderedArray[mid1] == target) {
                System.out.println("元素" + target + "在数组中第" + (mid1 + 1) + "个位置");
                ;
            }
            if (orderedArray[mid2] == target) {
                System.out.println("元素" + target + "在数组中第" + (mid2 + 1) + "个位置");
                ;
            }
            if (isAscending) {
                if (target < orderedArray[mid1]) {
                    high = mid1 - 1;
                } else if (target > orderedArray[mid2]) {
                    low = mid2 + 1;
                } else {
                    low = mid1 + 1;
                    high = mid2 - 1;
                }
            } else {
                if (target > orderedArray[mid1]) {
                    high = mid1 - 1;
                } else if (target < orderedArray[mid2]) {
                    low = mid2 + 1;
                } else {
                    low = mid1 + 1;
                    high = mid2 - 1;
                }
            }
        }
        System.out.println("元素" + target + "不在数组中");
        System.out.println("关键字比较次数：" + comparisonCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************************************");
        System.out.println("请输入数组长度：");
        System.out.println("******************************************************************");
        MAIN main = new MAIN(scanner.nextInt());
        boolean running = true;
        int index;

        while (running) {
            System.out.println("******************************************************************");
            System.out.println("当前数组：" + Arrays.toString(main.arr));
            System.out.println("1. 判断数组状态");
            System.out.println("2. 顺序检索");
            System.out.println("3. 二分检索");
            System.out.println("4. 三分检索");
            System.out.println("5. 二分查找最大值");
            System.out.println("0. 退出程序");
            System.out.println("******************************************************************");

            System.out.println("选择功能: ");

            try {
                index = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("*******输入无效，请输入一个整数。******");
                scanner.next(); // 清空无效输入
                continue;
            }

            switch (index) {

                case 1:// 判断数组状态
                    main.checkArrayOrder(main.arr);
                    break;
                case 2:// 顺序检索
                    System.out.println("请输入要查找的元素: ");
                    System.out.println("******************************************************************");
                    System.out.println("待查元素：");

                    main.search(main.arr, scanner.nextInt());
                    break;
                case 3:// 二分检索
                    System.out.print("请输入要查找的元素: ");
                    main.binarySearch(main.arr, scanner.nextInt());
                    break;
                case 4:// 三分检索
                    System.out.print("请输入要查找的元素: ");
                    main.ternarySearch(main.arr, scanner.nextInt());
                    break;
                case 5:// 二分查找最大值
                    break;
                case 6:// 重新获取新的数组
                    break;
                case 0: // 退出程序
                    running = false;
                    break;
                default:
                    System.out.println("无效输入！");
                    break;
            }
        }
        scanner.close();
    }
}