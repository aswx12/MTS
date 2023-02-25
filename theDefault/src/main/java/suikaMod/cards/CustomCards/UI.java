package suikaMod.cards.CustomCards;

import suikaMod.cards.CardGenerator.CardTemplateStrings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;

public class UI extends JFrame
{
    JPanel mainPanel;
    JButton CreateNewCard;
    private JTextField CardName;
    private JButton CreateButton;
    private JTextField costField;
    private JTextField upCostField;
    private JLabel cardNameLabel;
    private JLabel costLabel;
    private JLabel upCostLabel;
    private JPanel CardPanel;
    private JComboBox rarityList;
    private JLabel rarityLabel;
    private JComboBox targetList;
    private JTextArea descriptionField;
    private JLabel DescriptionLabel;
    private JLabel targetLabel;
    private JCheckBox unlockCheck;
    private JComboBox cardTypeList;
    private JLabel cardTypeLabel;
    private JList actionList;
    private JButton selectActionButton;
    private JButton removeActionButton;
    private JPanel ActionsPanel;
    private JPanel StartPanel;
    private JLabel selectionLabel;
    private JLabel selectedLabel;
    private JTable actionTable;
    private JScrollPane tableScroll;
    public JCheckBox ExhaustCheck;
    private JCheckBox EtherealCheck;
    private JCheckBox RetainCheck;
    private JCheckBox innateCheck;

    boolean test = false;
    int rowIndex = 0;
    int tableHeight = 0;
    JFileChooser f = new JFileChooser();
    File workingDirectory;

    boolean cellNum;

    public static void main(String[] args)
    {
        UI ui = new UI();

    }

    public UI()
    {

        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardPanel.setVisible(false);
        this.pack();
        setResizable(false);

        DefaultListModel originActionListModel = new DefaultListModel();
        DefaultListModel actionListModel = new DefaultListModel();
        for (int i = 0; i < actionList.getModel().getSize(); i++)
        {
            actionListModel.addElement(actionList.getModel().getElementAt(i));
            originActionListModel.addElement(actionList.getModel().getElementAt(i));
        }

        actionList.setModel(actionListModel);
        String[] colName = {"Action", "Base Value", "Upgraded Value"}; 
        DefaultTableModel tabModel = new DefaultTableModel(null, colName)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return column != 0;
            }

       /*     @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Integer.class;
            }*/
        };
        tabModel.isCellEditable(0, 0);
        //tabModel.getColumnClass(1);
        actionTable.setModel(tabModel);


        CreateNewCard.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent b)
            {
                String curDir = System.getProperty("user.dir");
                System.out.println(curDir);
                if (curDir.contains("theDefault"))
                {
                    workingDirectory = new File(System.getProperty("user.dir") + "/src/main/java/" + GetModId() + "/cards/CustomCards/");
                } else
                {
                    workingDirectory = new File(System.getProperty("user.dir") + "/theDefault/src/main/java/" + GetModId() + "/cards");
                }
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
                            CardPanel.setVisible(true);
                            CreateButton.setVisible(true);
                            CreateNewCard.setVisible(false);
                            cardTypeLabel.setVisible(false);
                            cardTypeList.setVisible(false);
                            mainPanel.setPreferredSize(new Dimension(1000,getPreferredSize().height));
                            pack();


                        } else
                        {
                            JOptionPane.showMessageDialog(CreateNewCard, "Card Exists, switching to edit mode");
                        }
                    } catch (Exception e)
                    {
                        e.getStackTrace();
                    }

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
                if (actionTable.isEditing())
                {
                    actionTable.getCellEditor().stopCellEditing();
                }

                //region table values check
                for (int i = 0; i < actionTable.getRowCount(); i++)
                {
                    for (int j = 1; j < actionTable.getColumnCount(); j++)
                    {
                        if (tabModel.getValueAt(i, j) == null)
                        {
                            JOptionPane.showMessageDialog(CreateButton, "Action: " + tabModel.getValueAt(i, 0).toString() + " [" + tabModel.getColumnName(j) + "] field is empty");
                            return;
                        }
                        cellNum = isNumeric(tabModel.getValueAt(i, j).toString());
                        if (!cellNum)
                        {
                            JOptionPane.showMessageDialog(CreateButton, "Action: " + tabModel.getValueAt(i, 0).toString() + " [" + tabModel.getColumnName(j) + "] field contains letter or is not whole number");
                            return;
                        }

                    }
                }
                //endregion

                //region cost field check
                if (costField.getText().isEmpty() || upCostField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(CreateButton, "Cost field is empty!");
                    return;
                }

                if (!isNumeric(costField.getText()) || !isNumeric(upCostField.getText()))
                {
                    JOptionPane.showMessageDialog(CreateButton, "Cost field contains letter or is not whole number!");
                    return;
                }
                //endregion

                String cardContent = CreateCard(
                        CardName,
                        costField,
                        upCostField,
                        rarityList,
                        targetList,
                        cardTypeList,
                        descriptionField,
                        unlockCheck,
                        tabModel,
                        innateCheck,
                        RetainCheck,
                        ExhaustCheck,
                        EtherealCheck);
                try
                {
                    // Creates a Writer using FileWriter
                    FileWriter output = new FileWriter(f.getSelectedFile() + "/" + CardName.getText() + ".java");

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

        selectActionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                actionList.getSelectedValuesList().stream().forEach((data) ->
                {
                    actionListModel.removeElement(data);
                    tabModel.addRow(new Object[]{null, null, null});
                    tabModel.setValueAt(data, rowIndex++, 0);
                    tableHeight += 20;
                    SetTableSize();
                });
            }
        });
        removeActionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
/*                selectedActionList.getSelectedValuesList().stream().forEach((data) ->
                {
                    actionListModel.addElement(data);
                    selectedActionListModel.removeElement(data);
                });*/

                RemoveSelectedActions(actionTable, actionListModel);
            }
        });
    }


    public void RemoveSelectedActions(JTable table, DefaultListModel actionListModel)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int numRows = table.getSelectedRows().length;
        for (int i = 0; i < numRows; i++)
        {
            actionListModel.addElement(table.getValueAt(table.getSelectedRow(), 0));
            model.removeRow(table.getSelectedRow());
            rowIndex--;
            tableHeight -= 20;
        }
        SetTableSize();
    }

    public void SetTableSize()
    {
        Dimension increaseHeight = new Dimension(450, tableHeight);
        actionTable.setPreferredSize(increaseHeight);
    }


    //region Utils
    public String CreateCard(JTextField name,
                             JTextField cost,
                             JTextField upgradeCost,
                             JComboBox rarityList,
                             JComboBox targetList,
                             JComboBox cardType,
                             JTextArea descriptionField,
                             JCheckBox seen,
                             DefaultTableModel actionTableModel,
                             JCheckBox innateCheck,
                             JCheckBox retainCheck,
                             JCheckBox exhaustCheck,
                             JCheckBox etherealCheck)
    {
        return CardTemplateStrings.CardTemplate(
                name,
                cost,
                upgradeCost,
                rarityList,
                targetList,
                cardType,
                descriptionField,
                seen,
                actionTableModel,
                innateCheck,
                retainCheck,
                exhaustCheck,
                etherealCheck);
    }

    private boolean isNumeric(String text)
    {
        if (text == null || text.trim().equals(""))
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

    private String GetModId()
    {
        return CardTemplateStrings.MODID;
    }

    public void nameModifier(String filePath, String theReplaced, String theReplacer)
    {
        String content = null;
        try
        {
            Path path = Paths.get(filePath);
            Charset charset = StandardCharsets.UTF_8;
            content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("theReplaced", "theReplacer");
            Files.write(path, content.getBytes(charset));

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    //endregion

}
