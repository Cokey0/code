package Java.EP2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class GUI {
private int[] array;
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("GUI");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 创建文本框
        JTextField textField = new JTextField();
        textField.setBounds(10, 50, 550, 30);
        frame.add(textField);

        JTextField textField2 = new JTextField();
        textField2.setBounds(10, 100, 550, 30);
        frame.add(textField2);

        // 创建按钮
        JButton button = new JButton("判断数组状态");
        button.setBounds(10, 320, 100, 30);
        frame.add(button);

        JButton sequentialSearchButton = new JButton("顺序检索");
        sequentialSearchButton.setBounds(130, 320, 100, 30);
        frame.add(sequentialSearchButton);

        JButton button3 = new JButton("二分检索");
        button3.setBounds(250, 320, 100, 30);
        frame.add(button3);

        JButton button4 = new JButton("三分检索");
        button4.setBounds(370, 320, 100, 30);
        frame.add(button4);

        JButton button5 = new JButton("二分找最值");
        button5.setBounds(490, 320, 100, 30);
        frame.add(button5);

        JButton autoInputButton = new JButton("自动生成唯一数组");
        autoInputButton.setBounds(10, 280, 100, 30);
        frame.add(autoInputButton);

        JButton manualInputButton = new JButton("键盘输入数组");
        manualInputButton.setBounds(130, 280, 100, 30);
        frame.add(manualInputButton);

        // 为按钮添加事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取文本框内容并显示
                String inputText = textField.getText();
                JOptionPane.showMessageDialog(frame, "你输入的内容是: " + inputText);
            }
        });

        sequentialSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取数组并进行顺序检索
                String tempSearch = JOptionPane.showInputDialog(frame, "请输入要检索的数");
                int searchNum = Integer.parseInt(tempSearch);

                String inputText = textField.getText();
                int[] arr = new int[inputText.length()];
                for (int i = 0; i < inputText.length(); i++) {
                    arr[i] = Integer.parseInt(inputText.charAt(i) + "");
                }
                int[] result = new int[arr.length];
                int index = 0;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] > arr[j]) {
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != arr[0]) {
                        result[index] = arr[i];
                        index++;
                    }
                }
                JOptionPane.showMessageDialog(frame, "顺序检索结果: " + result);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取文本框内容并显示
                String inputText = textField.getText();
                int[] arr = new int[inputText.length()];
                for (int i = 0; i < inputText.length(); i++) {
                    arr[i] = Integer.parseInt(inputText.charAt(i) + "");
                }
                int[] result = new int[arr.length];
                int index = 0;
                for (int i = 0; i < arr.length; i++) {
                    int left = 0;
                    int right = arr.length - 1;
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (arr[mid] == arr[i]) {
                            result[index] = arr[mid];
                            index++;
                            break;
                        } else if (arr[mid] < arr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                JOptionPane.showMessageDialog(frame, "二分检索结果: " + result);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取文本框内容并显示
                String inputText = textField.getText();
                int[] arr = new int[inputText.length()];
                for (int i = 0; i < inputText.length(); i++) {
                    arr[i] = Integer.parseInt(inputText.charAt(i) + "");
                }
                int[] result = new int[arr.length];
                int index = 0;
                for (int i = 0; i < arr.length; i++) {
                    int left = 0;
                    int right = arr.length - 1;
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (arr[mid] == arr[i]) {
                            result[index] = arr[mid];
                            index++;
                            break;
                        } else if (arr[mid] < arr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != arr[0]) {
                        result[index] = arr[i];
                        index++;
                    }
                }
                JOptionPane.showMessageDialog(frame, "三分检索结果: " + result);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取文本框内容并显示
                String inputText = textField.getText();
                int[] arr = new int[inputText.length()];
                for (int i = 0; i < inputText.length(); i++) {
                    arr[i] = Integer.parseInt(inputText.charAt(i) + "");
                }
                int[] result = new int[arr.length];
                int index = 0;
                for (int i = 0; i < arr.length; i++) {
                    int left = 0;
                    int right = arr.length - 1;
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (arr[mid] == arr[i]) {
                            result[index] = arr[mid];
                            index++;
                            break;
                        } else if (arr[mid] < arr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                int min = arr[0];
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    } else if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                JOptionPane.showMessageDialog(frame, "二分找最值结果: " + min + " " + max);
            }
        });

        autoInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，生成一个唯一数组并显示
                String tempString = JOptionPane.showInputDialog(frame, "请输入数组长度");
                int arrayLength = Integer.parseInt(tempString);
                Random random = new Random();
                int length = 10;
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
              textField.setText(Arrays.toString(arr));
                JOptionPane.showMessageDialog(frame, "自动生成的数组: " + Arrays.toString(arr));
            }
        });

        manualInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取键盘输入的数组并显示
                String inputText = JOptionPane.showInputDialog(frame, "请输入数组元素，用空格分隔");
                int[] arr = new int[inputText.length()];
                for (int i = 0; i < inputText.length(); i++) {
                    arr[i] = Integer.parseInt(inputText.charAt(i) + "");
                }
                if(arr.length == 0){
                    JOptionPane.showMessageDialog(frame, "输入的数组为空！");
                    return;
                }
                textField.setText(Arrays.toString(arr));
                JOptionPane.showMessageDialog(frame, "键盘输入数组: " + Arrays.toString(arr));

            }
        });

        // 设置窗口可见
        frame.setVisible(true);
    }
}
