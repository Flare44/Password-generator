import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    boolean sicher = false;
    boolean individuell = false;
    private JTextField lengthInput;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public boolean getSicher() {
        return this.sicher;
    }

    public boolean getIndividuell() {
        return this.individuell;
    }
    public MainFrame() {
        JFrame frame = new JFrame();

        //ÄNDERN v
        frame.setResizable(false);
        // ÄNDERN ^
        frame.setTitle("Passwort Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(0x1E1F22));
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = createMainPanel();
        JPanel leftPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel rightPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel topPanel = createSidePanel(50, new Color(0x1E1F22));
        JPanel bottomPanel = createSidePanel(50, new Color(0x1E1F22));

        //ImageIcon image = new ImageIcon("iconBild.png");
        //frame.setIconImage(image.getImage());



        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(leftPanel, BorderLayout.EAST);
        frame.add(rightPanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);




        frame.setVisible(true);

    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0x1E1F22));
        mainPanel.setPreferredSize(new Dimension(500, 500));
        mainPanel.setLayout(new GridLayout(2,1));

        mainPanel.add(createInputPanel());

        mainPanel.add(createOutputPanel());

        return mainPanel;
    }

    private JPanel createInputPanel() {
        JPanel input = createSidePanel(100, new Color(0x1E1F22));
        input.setLayout(new GridLayout(2,1));

        input.add(createPasswordInput());
        input.add(createModiInput());

        return input;
    }

    private JPanel createPasswordInput() {
        JPanel passwortLength = createSidePanel(100, new Color(0x1E1F22));
        passwortLength.setLayout(new GridBagLayout());
        JLabel passwortLabel = new JLabel("Passwortlänge:");

        passwortLabel.setForeground(Color.white);
        passwortLabel.setFont(new Font("Roboto", Font.BOLD, 13));
        passwortLength.add(passwortLabel);

        lengthInput = new JTextField();
        lengthInput.setHorizontalAlignment(JTextField.CENTER);
        lengthInput.setPreferredSize(new Dimension(28,20));
        lengthInput.setBorder(null);
        passwortLength.add(lengthInput);
        return passwortLength;
    }

    private JPanel createModiInput() {
        JPanel modus = createSidePanel(100, new Color(0x1E1F22));
        modus.setLayout(new GridLayout(2,2, 5, 10));
        JCheckBox sicherCheckBox = sicherCheckBox();
        JCheckBox individuellCheckBox = individuellCheckBox();

        sicherCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sicherCheckBox.isSelected()) {
                    individuellCheckBox.setEnabled(false);
                    sicher = true;
                    System.out.println("sicher ist aktiviert");
                } else {
                    individuellCheckBox.setEnabled(true);
                    sicher = false;
                    System.out.println("sicher ist deaktiviert");
                }
            }
        });

        JPanel panel1 = createIndividuellInput();
        JPanel panel2 = createIndividuellInput2();
        panel1.setVisible(false);
        panel2.setVisible(false);

        individuellCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (individuellCheckBox.isSelected()) {
                    sicherCheckBox.setEnabled(false);
                    individuell = true;
                    panel1.setVisible(true);
                    panel2.setVisible(true);
                    System.out.println("individuell ist aktiviert");
                } else {
                    sicherCheckBox.setEnabled(true);
                    individuell = false;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    System.out.println("individuell ist deaktiviert");
                }
            }
        });



        modus.add(sicherCheckBox);
        modus.add(individuellCheckBox);
        modus.add(panel1);
        modus.add(panel2);
        return modus;
    }


    private JCheckBox sicherCheckBox() {
        JCheckBox sichererButton = new JCheckBox("Sicher");
        sichererButton.setBackground(new Color(0x1E1F22));
        sichererButton.setForeground(Color.white);
        sichererButton.setFont(new Font("Roboto", 0, 13));
        sichererButton.setHorizontalAlignment(JCheckBox.RIGHT);
        sichererButton.setHorizontalTextPosition(JCheckBox.LEFT);
        sichererButton.setFocusPainted(false);
        sichererButton.setFocusable(false);
        return sichererButton;
    }

    private JCheckBox individuellCheckBox() {
        JCheckBox individuellerButton = new JCheckBox("Individuell");
        individuellerButton.setBackground(new Color(0x1E1F22));
        individuellerButton.setForeground(Color.white);
        individuellerButton.setFont(new Font("Roboto", 0, 13));
        individuellerButton.setHorizontalAlignment(JCheckBox.LEFT);
        individuellerButton.setHorizontalTextPosition(JCheckBox.LEFT);
        individuellerButton.setFocusPainted(false);
        individuellerButton.setFocusable(false);
        return individuellerButton;
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

        StyledDocument doc = outputMessage.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        outputMessage.setText("");

        JButton generateButton = new JButton("Generieren");
        generateButton.setAlignmentX(0.5f);
        generateButton.setFocusable(false);
        generateButton.setFocusPainted(false);
        generateButton.setBackground(new Color(0x2F2F31));
        generateButton.setForeground(Color.white);
        generateButton.setBorder(BorderFactory.createEmptyBorder(7,10,7,10));
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sicherer Modus
                 if (getSicher()) {

                     try {
                         int length = 0;
                         if(!lengthInput.getText().isEmpty()) {
                             length = Integer.parseInt(lengthInput.getText());
                         }

                         if (length < 0) {
                             outputMessage.setText("Bitte geben Sie eine ganze Zahl von 0 bis inklusive 256 an");
                         } else if (length > 256) {
                             outputMessage.setText("Die maximale Passwortlänge beträgt 256");
                         } else {
                             outputMessage.setText(CreatePassword.generate("sicher",length));
                         }
                     } catch(IllegalArgumentException exception) {
                         outputMessage.setText("Bitte geben Sie eine ganze Zahl von 0 bis inklusive 256 an");
                     }

                     //Individueller Modus

                 } else if(getIndividuell()) {
                     try {
                         int length = 0;
                         if(!lengthInput.getText().isEmpty()) {
                             length = Integer.parseInt(lengthInput.getText());
                         }

                         if (length < 0) {
                             outputMessage.setText("Bitte geben Sie eine ganze Zahl von 0 bis inklusive 256 an");
                         } else if (length > 256) {
                             outputMessage.setText("Die maximale Passwortlänge beträgt 256");
                         }
                         // Länge ab hier valid
                         int kleinbuchstaben = 0;
                         int grossbuchstaben = 0;
                         int zahlen = 0;
                         int sonderzeichen = 0;

                         if(!textField1.getText().isEmpty()) {
                             kleinbuchstaben = Integer.parseInt(textField1.getText());
                         }

                         if (!textField2.getText().isEmpty()) {
                             grossbuchstaben = Integer.parseInt(textField2.getText());
                         }

                         if (!textField3.getText().isEmpty()) {
                             zahlen = Integer.parseInt(textField3.getText());
                         }

                         if (!textField4.getText().isEmpty()) {
                             sonderzeichen = Integer.parseInt(textField4.getText());
                         }

                         if (kleinbuchstaben + grossbuchstaben + zahlen + sonderzeichen > length) {
                             outputMessage.setText("Passwortlänge nicht groß genug für die geforderten Werte");
                         } else if(kleinbuchstaben < 0 || grossbuchstaben < 0 || zahlen < 0 || sonderzeichen < 0) {
                             outputMessage.setText("Bitte geben Sie eine ganze Zahl von 0 bis inklusive 256 an");
                         } else {
                             outputMessage.setText(CreatePassword.generate("individuell", length, kleinbuchstaben, grossbuchstaben, zahlen, sonderzeichen));
                         }

                     } catch(IllegalArgumentException exception) {
                         outputMessage.setText("Bitte geben Sie eine ganze Zahl von 0 bis inklusive 256 an");
                     }
                 }
            }
        });


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

    private JPanel createIndividuellInput() {
        JPanel individuell = createSidePanel(100, new Color(0x1E1F22));
        individuell.setLayout(new GridLayout(2,1));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.setBackground(new Color(0x1E1F22));
        panel1.add(createLabel("Kleinbuchstaben"));
        JPanel anzahlKlein = createPanelForTextFields1();
        panel1.add(anzahlKlein);


        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.setBackground(new Color(0x1E1F22));
        panel2.add(createLabel("Großbuchstaben"));
        JPanel anzahlGross = createPanelForTextFields2();
        panel2.add(anzahlGross);

        individuell.add(panel1);
        individuell.add(panel2);

        return individuell;
    }

    private JPanel createIndividuellInput2() {
        JPanel individuell = createSidePanel(100, new Color(0x1E1F22));
        individuell.setLayout(new GridLayout(2,2));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,2));
        panel3.setBackground(new Color(0x1E1F22));
        panel3.add(createLabel("Zahlen"));
        JPanel anzahlZahlen = createPanelForTextFields3();
        panel3.add(anzahlZahlen);


        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2));
        panel4.setBackground(new Color(0x1E1F22));
        panel4.add(createLabel("Sonderzeichen"));
        JPanel anzahlSonder = createPanelForTextFields4();
        panel4.add(anzahlSonder);

        individuell.add(panel3);
        individuell.add(panel4);
        return individuell;
    }

    private JLabel createLabel(String text) {
        JLabel checkBox = new JLabel("Anzahl " + text + ":");
        checkBox.setHorizontalAlignment(JLabel.RIGHT);
        checkBox.setFocusable(false);
        checkBox.setForeground(Color.white);
        return checkBox;
    }

    private JPanel createPanelForTextFields1() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField1 = createTextField();
        textField1.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField1);
        return panel;
    }

    private JPanel createPanelForTextFields2() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField2 = createTextField();
        textField2.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField2);
        return panel;
    }

    private JPanel createPanelForTextFields3() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1F22));
        panel.setLayout(new FlowLayout(0,4,7));
        textField3= createTextField();
        textField3.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField3);
        return panel;
    }

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
