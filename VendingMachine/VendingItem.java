import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VendingItem {
    public VendingItem() {
        
     // Hashmap for passing money value
    final HashMap<String,Double> itemCosts=new HashMap<>();
    itemCosts.put("Select a Candy",0.0);
    itemCosts.put("Freddo Frog", 2.50);
    itemCosts.put("Flake",3.00);
    itemCosts.put("Jelly Snakes",3.50);
    itemCosts.put("Snickers", 3.75);
    itemCosts.put("Select a Gum",0.0);
    itemCosts.put("Bubble Gum", 2.00);
    itemCosts.put("Extra",3.00);
    itemCosts.put("Mentos",3.50);
    itemCosts.put("Minties",5.50);
    itemCosts.put("Smiths",3.00);
    itemCosts.put("Select a Chips",0.0);
    itemCosts.put("Doritos",3.50);
    itemCosts.put("Thins",4.50);
    itemCosts.put("Pringles",6.00);

        // Create a new JFrame
        final JFrame frame = new JFrame("Vending Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create a JPanel
        final JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 2000, 900);
        frame.add(panel);

        // Create a JLabel
        final JLabel label = new JLabel("Please enter the items you would like to purchase:");
        label.setBounds(300, 30, 500, 30);
        panel.add(label);

        // Create JComboBox for candies
        final String[] candies = {"Select a Candy","Freddo Frog", "Flake", "Jelly Snakes", "Snickers"};
        JLabel canlbl=new JLabel("Select a candy");
        final JComboBox<String> candyBox = new JComboBox<>(candies);
        candyBox.setBounds(600, 30, 109, 30);
        panel.add(candyBox);
        panel.add(canlbl);

        // Create JComboBox for gum
        // JLabel gumLabel = new JLabel("Gum");
        // gumLabel.setBounds(710, 5, 100, 30); // Added label for gum
        // panel.add(gumLabel);
        
        final String[] gumChoices = {"Select a Gum","Bubble Gum", "Extra", "Mentos", "Minties"};
        final JComboBox<String> gumBox = new JComboBox<>(gumChoices);
        gumBox.setBounds(717, 30, 100, 30);
        panel.add(gumBox);
        // JLabel gumlbl =new JLabel("Select a gum");
        // panel.add(gumlbl);
        // gumlbl.setVisible(true);

        // Create JComboBox for chips
        final String[] chipChoices = {"Select a Chips","Smiths", "Doritos", "Thins", "Pringles"};
        final JComboBox<String> chipBox = new JComboBox<>(chipChoices);
        chipBox.setBounds(827, 30, 109, 30);
        panel.add(chipBox);

        // Create TextArea
        final JTextArea textField = new JTextArea();
        textField.setBounds(60, 70, 1300, 550);
        textField.setMargin( new Insets(10,10,10,10) );
        textField.setFont(new Font("Serif",Font.PLAIN,20));
        panel.add(textField);
        // Create total cost button
        final JButton totalCostButton = new JButton("Show Total Cost");
        totalCostButton.setBounds(450, 650, 130, 30);
        panel.add(totalCostButton);

        // Create pay cost button
        final JButton payButton = new JButton("Pay Cost");
        payButton.setBounds(600, 650, 100, 30);
        panel.add(payButton);

        // Create release item button
        final JButton releaseButton = new JButton("Release Item");
        releaseButton.setBounds(720, 650, 120, 30);
        panel.add(releaseButton);

        // Create exit button
        final JButton exitButton = new JButton("Exit");
        exitButton.setBounds(860, 650, 100, 30);
        panel.add(exitButton);

        // ActionListner for Sum the selected items
        
        totalCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCandy = (String)candyBox.getSelectedItem();
                String selectedGum = (String)gumBox.getSelectedItem();
                String selectedChips = (String)chipBox.getSelectedItem();

                final double totalCost =  itemCosts.get((String) candyBox.getSelectedItem()) +
                                    itemCosts.get((String) gumBox.getSelectedItem()) +
                                    itemCosts.get((String) chipBox.getSelectedItem());
                                    if ("Select a Candy".equals(selectedCandy) ||
                                    "Select a Gum".equals(selectedGum) ||
                                    "Select a Chips".equals(selectedChips)) {
                                    
                                    JOptionPane.showMessageDialog(null, "Please select items", "", JOptionPane.ERROR_MESSAGE);
                                    return;  // Exit the method if any item is not selected
                                }
                if(textField!=null){
                    textField.setText("Total cost to be paid  by you is : $" + totalCost);
                }

            }
        });
        payButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String input = JOptionPane.showInputDialog(null, "Enter the value of the bank note, which must be greater than the total cost to be paid (e.g., 5, 10, 20, 50, 100).");
                try {
                    int value = Integer.parseInt(input);
                    if (value >= 5 && value <= 100) {
                    } else {
                        JOptionPane.showMessageDialog(null, "The value must be between 5 and 100.");
                        return;
                    }
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
                    return;
                }
                
                double inpt = Double.parseDouble(input);
                
                if (input != null) {
                    try {
                        
                        // double payButton = Double.parseDouble(input);
                        // Do something with the cost value
                        // JOptionPane.showMessageDialog(frame, "Cost set to: " + payButton);

                        final double totalCost =  itemCosts.get((String) candyBox.getSelectedItem()) +
                        itemCosts.get((String) gumBox.getSelectedItem()) +
                        itemCosts.get((String) chipBox.getSelectedItem());
                        textField.setText("Your purchase has been completed. Here is your receipt:\n\n\n" +
                        "\t\tVending Machine\n" +
                        "\t----------------------------------------\n" +
                        "\t" + candyBox.getSelectedItem() + "\t\t$" + itemCosts.get(candyBox.getSelectedItem()) + "\n" +
                        "\t" + gumBox.getSelectedItem() + "\t\t$" + itemCosts.get(chipBox.getSelectedItem()) + "\n" +
                        "\t" + chipBox.getSelectedItem() + "\t\t$" + itemCosts.get(chipBox.getSelectedItem())
                        +"\n\n\tTotal Cost"+"\t\t$"+totalCost +"\n\tAmount paid"+ "\t\t$"+input+"\n\t"+"Change\t\t$"+(inpt-totalCost)+"\n\t"+"\t----------------------------------------\n"
                        +"\n\n\t"+"\tABN: 6723956789"+"\n\t"+"\tThank you for shopping at this Vending Machine!");
                        
                    } catch (NumberFormatException ex) {
                        
                        JOptionPane.showMessageDialog(frame, "Invalid cost input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            
        });

        // ActionListner for ReleaseItem
        releaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(textField!=null){
                    textField.setText("Please collect the item from the dispenser");
                    return;
                }
            }
        });

        //  ActionListner for exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
                }
        });

        // Set frame visibility to true
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new VendingItem();
    }
}
