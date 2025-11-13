package com.cfhayes.claf.demo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import com.cfhayes.claf.food.FoodLookAndFeel;
import com.cfhayes.claf.financial.FinancialLookAndFeel;
import com.cfhayes.claf.medical.MedicalLookAndFeel;
import com.cfhayes.claf.industrial.IndustrialLookAndFeel;

/**
 * Demo application to showcase CLAF Look and Feel themes.
 * Tests various Swing components with Food and Industrial themes.
 */
public class CLAFDemo extends JFrame {
    
    private JComboBox<String> lafComboBox;
    private JPanel mainPanel;
    
    public CLAFDemo() {
        initializeFrame();
        createMenuBar();
        createMainPanel();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void initializeFrame() {
        setTitle("CLAF Demo - Custom Look and Feel Showcase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        
        JMenuItem newItem = new JMenuItem("New", 'N');
        JMenuItem openItem = new JMenuItem("Open", 'O');
        JMenuItem saveItem = new JMenuItem("Save", 'S');
        JMenuItem exitItem = new JMenuItem("Exit", 'X');
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        
        // Look and Feel Menu
        JMenu lafMenu = new JMenu("Look & Feel");
        lafMenu.setMnemonic('L');
        
        JMenuItem foodLaf = new JMenuItem("Food Theme");
        JMenuItem financialLaf = new JMenuItem("Financial Theme");
        JMenuItem medicalLaf = new JMenuItem("Medical Theme");
        JMenuItem industrialLaf = new JMenuItem("Industrial Theme");
        JMenuItem systemLaf = new JMenuItem("System Default");
        
        lafMenu.add(foodLaf);
        lafMenu.add(financialLaf);
        lafMenu.add(medicalLaf);
        lafMenu.add(industrialLaf);
        lafMenu.addSeparator();
        lafMenu.add(systemLaf);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(lafMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel with Look and Feel selector
        JPanel topPanel = createLafSelectorPanel();
        
        // Center panel with component showcase
        JPanel centerPanel = createComponentShowcase();
        
        // Bottom panel with action buttons
        JPanel bottomPanel = createActionPanel();
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createLafSelectorPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new TitledBorder("Look and Feel Selection"));
        
        JLabel label = new JLabel("Choose Theme:");
        lafComboBox = new JComboBox<>(new String[]{"Food", "Medical", "Financial","Industrial", "System Default"});
        lafComboBox.setSelectedItem("Food");
        
        panel.add(label);
        panel.add(lafComboBox);
        
        return panel;
    }
    
    private JPanel createComponentShowcase() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Form Components
        JPanel formPanel = createFormPanel();
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        panel.add(formPanel, gbc);
        
        // Buttons Panel
        JPanel buttonsPanel = createButtonsPanel();
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buttonsPanel, gbc);
        
        // Lists and Trees Panel
        JPanel listsPanel = createListsPanel();
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.BOTH;
        panel.add(listsPanel, gbc);
        
        return panel;
    }
    
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Form Components"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Text Fields
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField("John Doe", 15), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField("john@example.com", 15), gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField passwordField = new JPasswordField("password", 15);
        panel.add(passwordField, gbc);
        
        // ComboBox
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Country:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JComboBox<String> countryCombo = new JComboBox<>(new String[]{"USA", "Canada", "UK", "Germany", "France"});
        panel.add(countryCombo, gbc);
        
        // Spinner
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(25, 0, 120, 1));
        panel.add(ageSpinner, gbc);
        
        // Check boxes
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JCheckBox newsletterCheck = new JCheckBox("Subscribe to newsletter", true);
        panel.add(newsletterCheck, gbc);
        
        gbc.gridy = 6;
        JCheckBox termsCheck = new JCheckBox("I agree to the terms and conditions");
        panel.add(termsCheck, gbc);
        
        // Radio buttons
        gbc.gridy = 7;
        panel.add(new JLabel("Gender:"), gbc);
        
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleRadio = new JRadioButton("Male", true);
        JRadioButton femaleRadio = new JRadioButton("Female");
        JRadioButton otherRadio = new JRadioButton("Other");
        
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        
        radioPanel.add(maleRadio);
        radioPanel.add(femaleRadio);
        radioPanel.add(otherRadio);
        
        gbc.gridy = 8;
        panel.add(radioPanel, gbc);
        
        return panel;
    }
    
    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Buttons & Controls"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Regular buttons
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JButton("Submit"), gbc);
        
        gbc.gridy = 1;
        panel.add(new JButton("Cancel"), gbc);
        
        gbc.gridy = 2;
        JButton disabledButton = new JButton("Disabled");
        disabledButton.setEnabled(false);
        panel.add(disabledButton, gbc);
        
        // Toggle button
        gbc.gridy = 3;
        JToggleButton toggleButton = new JToggleButton("Toggle Me");
        panel.add(toggleButton, gbc);
        
        // Slider
        gbc.gridy = 4;
        panel.add(new JLabel("Volume:"), gbc);
        gbc.gridy = 5;
        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        panel.add(volumeSlider, gbc);
        
        // Progress bar
        gbc.gridy = 6;
        panel.add(new JLabel("Progress:"), gbc);
        gbc.gridy = 7;
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(35);
        progressBar.setStringPainted(true);
        panel.add(progressBar, gbc);
        
        return panel;
    }
    
    private JPanel createListsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Lists & Trees"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        
        // List
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Languages:"), gbc);
        
        gbc.gridy = 1; gbc.weighty = 1.0;
        String[] languages = {"Java", "Python", "C++", "JavaScript", "Go", "Rust", "Kotlin"};
        JList<String> languageList = new JList<>(languages);
        languageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        languageList.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(languageList);
        listScrollPane.setPreferredSize(new Dimension(150, 100));
        panel.add(listScrollPane, gbc);
        
        // Text Area
        gbc.gridy = 2; gbc.weighty = 0.1;
        panel.add(new JLabel("Comments:"), gbc);
        
        gbc.gridy = 3; gbc.weighty = 1.0;
        JTextArea commentsArea = new JTextArea("This is a sample text area.\nYou can type multiple lines here.\nTry different Look and Feel themes!");
        commentsArea.setRows(4);
        commentsArea.setWrapStyleWord(true);
        commentsArea.setLineWrap(true);
        JScrollPane textScrollPane = new JScrollPane(commentsArea);
        panel.add(textScrollPane, gbc);
        
        return panel;
    }
    
    private JPanel createActionPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton aboutButton = new JButton("About CLAF");
        aboutButton.addActionListener(this::showAboutDialog);
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        
        panel.add(aboutButton);
        panel.add(exitButton);
        
        return panel;
    }
    
    
    private void showAboutDialog(ActionEvent e) {
        String message = """
                CLAF Demo Application
                
                Custom Look and Feel Library
                Version 2.0.0-SNAPSHOT
                
                Created by: Charles Hayes
                """;
        
        JOptionPane.showMessageDialog(this, message, "About CLAF", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        // Set system properties for better rendering
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // Check if theme was provided as command line argument
        String selectedTheme = null;
        if (args.length > 0) {
            selectedTheme = args[0].toLowerCase();
        } else {
            // Show CLI menu for theme selection
            selectedTheme = showThemeSelectionMenu();
        }
        
        // Validate and set the selected theme
        final String theme = validateTheme(selectedTheme);
        
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the initial Look and Feel based on selection
                setInitialTheme(theme);
                
                CLAFDemo demo = new CLAFDemo();
                demo.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "Failed to initialize CLAF Demo: " + e.getMessage(), 
                    "Initialization Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private static String showThemeSelectionMenu() {
        Scanner scanner = new Scanner(System.in);
        String theme = null;
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       CLAF Demo - Theme Selection");
        System.out.println("=".repeat(50));
        System.out.println("Available themes:");
        System.out.println("  1. Food      - Warm, organic colors");
        System.out.println("  2. Medical   - Clean, healthcare colors"); 
        System.out.println("  3. Financial - Professional, trustworthy colors");
        System.out.println("  4. Industrial- Strong, metallic colors");
        System.out.println("  5. System    - System default Look and Feel");
        System.out.println("=".repeat(50));
        
        while (theme == null) {
            System.out.print("Select a theme (1-5 or name): ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            switch (input) {
                case "1":
                case "food":
                    theme = "food";
                    break;
                case "2":
                case "medical":
                    theme = "medical";
                    break;
                case "3":
                case "financial":
                    theme = "financial";
                    break;
                case "4":
                case "industrial":
                    theme = "industrial";
                    break;
                case "5":
                case "system":
                    theme = "system";
                    break;
                default:
                    System.out.println("Invalid selection. Please choose 1-5 or enter theme name.");
            }
        }
        
        scanner.close();
        return theme;
    }
    
    private static String validateTheme(String theme) {
        if (theme == null) return "food"; // default
        
        switch (theme.toLowerCase()) {
            case "food":
            case "medical":
            case "financial":
            case "industrial":
            case "system":
                return theme.toLowerCase();
            default:
                System.out.println("Unknown theme '" + theme + "', using Food theme as default.");
                return "food";
        }
    }
    
    private static void setInitialTheme(String theme) throws Exception {
        switch (theme) {
            case "food":
                UIManager.setLookAndFeel(new FoodLookAndFeel());
                break;
            case "medical":
                UIManager.setLookAndFeel(new MedicalLookAndFeel());
                break;
            case "financial":
                UIManager.setLookAndFeel(new FinancialLookAndFeel());
                break;
            case "industrial":
                UIManager.setLookAndFeel(new IndustrialLookAndFeel());
                break;
            case "system":
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                break;
        }
    }
    
    
}