package myMod.cards.CustomCards;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class UI extends JFrame
{
    JPanel mainPanel;
    JButton CreateNewCard;
    private JTextField CardName;
    private JButton CreateButton;
    private JTextField costField;
    private JTextField upCostField;
    private JTextField dmgField;
    private JTextField upPlusDmgField;
    private JLabel cardNameLabel;
    private JLabel costLabel;
    private JLabel upCostLabel;
    private JLabel dmgLabel;
    private JLabel upPlusDmgLabel;
    private JPanel attackCardPanel;

    public static int damage;

    JFileChooser f = new JFileChooser();

    public static void main(String[] args)
    {
        UI ui = new UI();


    }

    public UI()
    {
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attackCardPanel.setVisible(false);
        this.pack();
        setResizable(false);
        //tests te=new tests();
        CreateNewCard.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent b)
            {
                String curDir = System.getProperty("user.dir");
                File workingDirectory = new File(System.getProperty("user.dir")+"/src/main/java/");
                f.setCurrentDirectory(workingDirectory);
                if (!CardName.getText().isEmpty())
                {
                    f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    f.showSaveDialog(null);
                    File file = new File(f.getSelectedFile() + "/" + CardName.getText() + ".java");

                    f.setCurrentDirectory(f.getSelectedFile());
                    try
                    {

                        // create a new file with name specified
                        // by the file object
                        boolean value = file.createNewFile();
                        if (value)
                        {
                            JOptionPane.showMessageDialog(CreateNewCard, "New Card created");
                            attackCardPanel.setVisible(true);
                            pack();

                        } else
                        {
                            JOptionPane.showMessageDialog(CreateNewCard, "Card Exists, switching to edit mode");
                        }
                    } catch (Exception e)
                    {
                        e.getStackTrace();
                    }

                    CreateButton.setVisible(true);
                    CreateNewCard.setVisible(false);
                } else
                {
                    JOptionPane.showMessageDialog(CreateNewCard, "Name Field can't be empty!");
                }
            }
        });
        CreateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent b)
            {
                if (!isNumeric(costField.getText()) ||
                        !isNumeric(upCostField.getText())||
                        !isNumeric(dmgField.getText())||
                        !isNumeric(upPlusDmgField.getText()))
                {
                    JOptionPane.showMessageDialog(CreateButton, "Cost and Damage field must be whole numbers!");
                    return;
                }

                String cardContent = CreateBasicAttCard(CardName, costField, upCostField, dmgField, upPlusDmgField);
                try
                {
                    // Creates a Writer using FileWriter
                    FileWriter output = new FileWriter(f.getSelectedFile() + "\\" + CardName.getText() + ".java");

                    // Writes the  to file
                    output.write(cardContent);
                    System.out.println("Data is written to the file.");
                    JOptionPane.showMessageDialog(CreateButton, "Card Properties applied!");
                    // Closes the writer
                    output.close();
                } catch (Exception e)
                {
                    e.getStackTrace();
                }
            }
        });
    }

    public String CreateBasicAttCard(JTextField name, JTextField cost, JTextField upgradeCost, JTextField dmg, JTextField upgradePlusDmg)
    {
        return CardTemplateStrings.BasicAttackCard(name, cost, upgradeCost, dmg, upgradePlusDmg);
    }

    private boolean isNumeric(String text)
    {
        if (text == null || text.trim().equals("") )
        {
            return false;
        }
        for (int iCount = 0; iCount < text.length(); iCount++)
        {
            if (!Character.isDigit(text.charAt(iCount)))
            {
                return false;
            }
        }
        return true;
    }

}
