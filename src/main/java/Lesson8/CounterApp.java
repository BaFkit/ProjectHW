package Lesson8;
// Доработанный счетчик
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private int memory;

    public CounterApp(int initialValue){
        setTitle("Счетчик");
        setBounds(400,400,300,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.BOLD, 32);
        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        memory = 0;
        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton indecrementButton = new JButton(">");
        indecrementButton.setFont(font);
        add(indecrementButton, BorderLayout.EAST);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(font);
        add(resetButton, BorderLayout.NORTH);

        JButton memoryButton = new JButton("Memory");
        memoryButton.setFont(font);
        add(memoryButton, BorderLayout.SOUTH);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
            }
        });
        indecrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value++;
                counterValueView.setText(String.valueOf(value));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value = initialValue;
                memory = 0;
                counterValueView.setText(String.valueOf(value));
            }
        });
        memoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(memory == 0){
                    memory = value;
                }else {
                    value = memory;
                }
                counterValueView.setText(String.valueOf(value));
            }
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        new CounterApp(0);
    }
}
