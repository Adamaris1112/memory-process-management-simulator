import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorGUI extends JFrame {
    private JTextArea memoryDisplay;
    private JTextField processNameField;
    private JTextField memoryRequiredField;
    private JButton createProcessButton;

    public SimulatorGUI() {
        setTitle("Memory Process Management Simulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        memoryDisplay = new JTextArea();
        memoryDisplay.setEditable(false);
        add(new JScrollPane(memoryDisplay), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        processNameField = new JTextField(15);
        memoryRequiredField = new JTextField(5);
        createProcessButton = new JButton("Create Process");

        inputPanel.add(new JLabel("Process Name:"));
        inputPanel.add(processNameField);
        inputPanel.add(new JLabel("Memory Required:"));
        inputPanel.add(memoryRequiredField);
        inputPanel.add(createProcessButton);

        add(inputPanel, BorderLayout.SOUTH);

        createProcessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProcess();
            }
        });
    }

    private void createProcess() {
        String processName = processNameField.getText();
        String memoryRequired = memoryRequiredField.getText();

        // Logic to create a process and update memoryDisplay
        // This will involve calling the MemoryManager class methods

        memoryDisplay.append("Process Created: " + processName + " with " + memoryRequired + " MB\n");
        processNameField.setText("");
        memoryRequiredField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimulatorGUI gui = new SimulatorGUI();
            gui.setVisible(true);
        });
    }
}