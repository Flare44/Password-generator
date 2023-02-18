import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    boolean secureMode = false;
    boolean customMode = false;
    private JTextField lengthInput;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public boolean getsecureMode() {
        return this.secureMode;
    }

    public boolean getcustomMode() {
        return this.customMode;
    }

    // Creates frame with BorderLayout
    public MainFrame() {
        JFrame frame = new JFrame();

        // editv
        frame.setResizable(false);
        // edit ^
        frame.setTitle("Password generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(0x1E1F22));
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = createMainPanel();
        JPanel leftPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel rightPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel topPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel bottomPanel = createSidePanel(50, new Color(0x1E1F22));

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(leftPanel, BorderLayout.EAST);
        frame.add(rightPanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    // Creates the mainPanel (here is all the content)
    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0x1E1F22));
        mainPanel.setPreferredSize(new Dimension(500, 500));
        mainPanel.setLayout(new GridLayout(2,1));

        mainPanel.add(createInputPanel());
        mainPanel.add(createOutputPanel());

        return mainPanel;
    }

    // Structure the layout
    private JPanel createInputPanel() {
        JPanel input = createSidePanel(100, new Color(0x1E1F22));
        input.setLayout(new GridLayout(2,1));

        input.add(createPasswordInput());
        input.add(createModesInput());

        return input;
    }

    // Creates Panel with label and text field to enter the length of the password
    private JPanel createPasswordInput() {
        JPanel passwordPanel= createSidePanel(100, new Color(0x1E1F22));
        passwordPanel.setLayout(new GridBagLayout());
        
        JLabel passwortLabel = new JLabel("Length of password:");
        passwortLabel.setForeground(Color.white);
        passwortLabel.setFont(new Font("Roboto", Font.BOLD, 13));
        passwordPanel.add(passwortLabel);

        lengthInput = new JTextField();
        lengthInput.setHorizontalAlignment(JTextField.CENTER);
        lengthInput.setPreferredSize(new Dimension(28,20));
        lengthInput.setBorder(null);
        passwordPanel.add(lengthInput);
        return passwordPanel;
    }

    // Create the panel where you can choose the modes
    private JPanel createModesInput() {
        JPanel modus = createSidePanel(100, new Color(0x1E1F22));
        modus.setLayout(new GridLayout(2,2, 5, 10));
        JCheckBox secureModeCheckBox = secureModeCheckBox();
        JCheckBox customModeCheckBox = customModeCheckBox();
        
        // Check which checkbox is selected (secure)
        secureModeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secureModeCheckBox.isSelected()) {
                    customModeCheckBox.setEnabled(false);
                    secureMode = true;
                    //System.out.println("secure is active");
                } else {
                    customModeCheckBox.setEnabled(true);
                    secureMode = false;
                    //System.out.println("secure is not active");
                }
            }
        });

        JPanel panel1 = createCustomInputPanel();
        JPanel panel2 = createCustomInputPanel2();
        panel1.setVisible(false);
        panel2.setVisible(false);

        // Check which checkbox is selected (custom)
        customModeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customModeCheckBox.isSelected()) {
                    secureModeCheckBox.setEnabled(false);
                    customMode = true;
                    panel1.setVisible(true);
                    panel2.setVisible(true);
                    //System.out.println("customMode is active");
                } else {
                    secureModeCheckBox.setEnabled(true);
                    customMode = false;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    //System.out.println("customMode is not active");
                }
            }
        });
        
        modus.add(secureModeCheckBox);
        modus.add(customModeCheckBox);
        modus.add(panel1);
        modus.add(panel2);
        return modus;
    }


    private JCheckBox secureModeCheckBox() {
        JCheckBox secureModeerButton = new JCheckBox("secureMode");
        secureModeerButton.setBackground(new Color(0x1E1F22));
        secureModeerButton.setForeground(Color.white);
        secureModeerButton.setFont(new Font("Roboto", 0, 13));
        secureModeerButton.setHorizontalAlignment(JCheckBox.RIGHT);
        secureModeerButton.setHorizontalTextPosition(JCheckBox.LEFT);
        secureModeerButton.setFocusPainted(false);
        secureModeerButton.setFocusable(false);
        return secureModeerButton;
    }
    
    private JCheckBox customModeCheckBox() {
        JCheckBox customModeButton = new JCheckBox("customMode");
        customModeButton.setBackground(new Color(0x1E1F22));
        customModeButton.setForeground(Color.white);
        customModeButton.setFont(new Font("Roboto", 0, 13));
        customModeButton.setHorizontalAlignment(JCheckBox.LEFT);
        customModeButton.setHorizontalTextPosition(JCheckBox.LEFT);
        customModeButton.setFocusPainted(false);
        customModeButton.setFocusable(false);
        return customModeButton;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = createSidePanel(100, new Color(0x1E1F22));
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));

        JTextPane outputMessage = new JTextPane();
        outputMessage.setContentType("");
        outputMessage.setEditable(false);
        outputMessage.setBackground(new Color(0x1E1F22));
        outputMessage.setBorder(null);
        outputMessage.setForeground(Color.white);
        outputMessage.setFont(new Font("Roboto",0,20));

        // To align message
        StyledDocument doc = outputMessage.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        outputMessage.setText("");

        JButton generateButton = new JButton("generate");
        generateButton.setAlignmentX(0.5f);
        generateButton.setFocusable(false);
        generateButton.setFocusPainted(false);
        generateButton.setBackground(new Color(0x2F2F31));
        generateButton.setForeground(Color.white);
        generateButton.setBorder(BorderFactory.createEmptyBorder(7,10,7,10));
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // secureMode 
                 if (getsecureMode()) {

                     try {
                         int length = 0;
                         if(!lengthInput.getText().isEmpty()) {
                             length = Integer.parseInt(lengthInput.getText());
                         }

                         if (length < 0) {
                             outputMessage.setText("Please enter a number between 0 and 100");
                         } else if (length > 100) {
                             outputMessage.setText("The maximum length is 100");
                         } else {
                             outputMessage.setText(CreatePassword.generate("secureMode",length));
                         }
                     } catch(IllegalArgumentException exception) {
                         outputMessage.setText("Please enter a number between 0 and 100");
                     }

                     // customMode 

                 } else if(getcustomMode()) {
                     try {
                         int length = 0;
                         if(!lengthInput.getText().isEmpty()) {
                             length = Integer.parseInt(lengthInput.getText());
                         }

                         if (length < 0) {
                             outputMessage.setText("Please enter a number between 0 and 100");
                         } else if (length > 100) {
                             outputMessage.setText("The maximum length is 100");
                         }
                         // length is now valid
                         int smallCharacters = 0;
                         int capitalCharacters = 0;
                         int numbers = 0;
                         int specialCharacters = 0;

                         if(!textField1.getText().isEmpty()) {
                             smallCharacters = Integer.parseInt(textField1.getText());
                         }

                         if (!textField2.getText().isEmpty()) {
                             capitalCharacters = Integer.parseInt(textField2.getText());
                         }

                         if (!textField3.getText().isEmpty()) {
                             numbers = Integer.parseInt(textField3.getText());
                         }

                         if (!textField4.getText().isEmpty()) {
                             specialCharacters = Integer.parseInt(textField4.getText());
                         }

                         if (smallCharacters + capitalCharacters + numbers + specialCharacters > length) {
                             outputMessage.setText("The length of your password is not big enough for your preferences");
                         } else if(smallCharacters < 0 || capitalCharacters < 0 || numbers < 0 || specialCharacters < 0) {
                             outputMessage.setText("Please enter a number between 0 and 100");
                         } else {
                             outputMessage.setText(CreatePassword.generate("customMode", length, smallCharacters, capitalCharacters, numbers, specialCharacters));
                         }

                     } catch(IllegalArgumentException exception) {
                         outputMessage.setText("Please enter a number between 0 and 100");
                     }
                 }
            }
        });

        // for better alignment
        outputMessage.setAlignmentX(0.5f);
        outputPanel.add(Box.createRigidArea(new Dimension(0,25)));
        outputPanel.add(generateButton);
        outputPanel.add(Box.createRigidArea(new Dimension(0,30)));
        outputPanel.add(outputMessage);
        
        return outputPanel;
    }

    private JPanel createSidePanel(int height, Color color) {
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(color);
        sidePanel.setPreferredSize(new Dimension(100, height));
        return sidePanel;
    }

    private JPanel createCustomInputPanel() {
        JPanel customMode = createSidePanel(100, new Color(0x1E1F22));
        customMode.setLayout(new GridLayout(2,1));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.setBackground(new Color(0x1E1F22));
        panel1.add(createLabel("small characters"));
        JPanel amountSmall = createPanelForTextFields1();
        panel1.add(amountSmall);


        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.setBackground(new Color(0x1E1F22));
        panel2.add(createLabel("capital characters"));
        JPanel amountBig = createPanelForTextFields2();
        panel2.add(amountBig);

        customMode.add(panel1);
        customMode.add(panel2);

        return customMode;
    }

    private JPanel createCustomInputPanel2() {
        JPanel customMode = createSidePanel(100, new Color(0x1E1F22));
        customMode.setLayout(new GridLayout(2,2));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,2));
        panel3.setBackground(new Color(0x1E1F22));
        panel3.add(createLabel("numbers"));
        JPanel amountNumbers = createPanelForTextFields3();
        panel3.add(amountNumbers);


        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2));
        panel4.setBackground(new Color(0x1E1F22));
        panel4.add(createLabel("special characters"));
        JPanel amountSpecial = createPanelForTextFields4();
        panel4.add(amountSpecial);

        customMode.add(panel3);
        customMode.add(panel4);
        return customMode;
    }

    private JLabel createLabel(String text) {
        JLabel checkBox = new JLabel("Minimum amount of " + text + ":");
        checkBox.setHorizontalAlignment(JLabel.RIGHT);
        checkBox.setFocusable(false);
        checkBox.setForeground(Color.white);
        return checkBox;
    }

    // help-method for text-fields
    private JPanel createPanelForTextFields1() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField1 = createTextField();
        textField1.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField1);
        return panel;
    }

    // help-method for text-fields
    private JPanel createPanelForTextFields2() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField2 = createTextField();
        textField2.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField2);
        return panel;
    }

    // help-method for text-fields
    private JPanel createPanelForTextFields3() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField3= createTextField();
        textField3.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField3);
        return panel;
    }

    // help-method for text-fields
    private JPanel createPanelForTextFields4() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField4 = createTextField();
        textField4.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField4);
        return panel;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(28,20));
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.LEFT);

        return textField;
    }



}
