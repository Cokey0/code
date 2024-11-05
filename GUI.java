package Java.EP2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("简单的GUI示例");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 创建文本框
        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 300, 30);
        frame.add(textField);

        // 创建按钮
        JButton button = new JButton("点击我");
        button.setBounds(150, 100, 100, 30);
        frame.add(button);

        // 为按钮添加事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，获取文本框内容并显示
                String inputText = textField.getText();
                JOptionPane.showMessageDialog(frame, "你输入的内容是: " + inputText);
            }
        });

        // 设置窗口可见
        frame.setVisible(true);
    }
}
