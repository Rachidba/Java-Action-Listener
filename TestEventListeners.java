import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestEventListeners extends JFrame {
    private JPanel mainPanel;
    private JLabel label;
    private JButton button;
    private JCheckBox checkBox;
    private ButtonGroup buttonGroup;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JComboBox combo;

    public TestEventListeners() {
        this.mainPanel = new JPanel(new FlowLayout());
        this.label = new JLabel("");
        this.button = new JButton("Button");
        this.checkBox = new JCheckBox("CheckBox");
        this.buttonGroup = new ButtonGroup();
        this.radio1 = new JRadioButton("Radio1");
        this.buttonGroup.add(radio1);
        this.radio2 = new JRadioButton("Radio2");
        this.buttonGroup.add(radio2);
        String[] selects = {"Select1", "Select2"};
        this.combo = new JComboBox(selects);


        this.mainPanel.add(button);
        this.mainPanel.add(checkBox);
        this.mainPanel.add(radio1);
        this.mainPanel.add(radio2);
        this.mainPanel.add(combo);
        this.mainPanel.add(label);
        /*this.mainPanel.add();
        this.mainPanel.add();*/

        this.add(mainPanel);
        this.setSize(400, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == checkBox) {
                    label.setText("Check selected!");
                }
                else if (e.getSource() == button) {
                    label.setText("Button cicked");
                }
                else if (e.getSource() == radio1 || e.getSource() == radio2) {
                    if(radio1.isSelected()) {
                        label.setText("Radio1 choosed!");
                    } else {
                        label.setText("Radio2 choosed!");
                    }
                } else if (e.getSource() == combo){
                    label.setText("Item" + (combo.getSelectedIndex() + 1) + " Selected.");
                }
            }
        };
        this.checkBox.addActionListener(actionListener);
        this.button.addActionListener(actionListener);
        this.radio1.addActionListener(actionListener);
        this.radio2.addActionListener(actionListener);
        this.combo.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        new TestEventListeners();
    }
}
