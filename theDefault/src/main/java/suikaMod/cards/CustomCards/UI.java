package suikaMod.cards.CustomCards;

import suikaMod.cards.CardGenerator.ActionCategory;
import suikaMod.cards.CardGenerator.CardTemplateStrings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.StringJoiner;

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
    private JCheckBox InnateCheck;
    private JTextArea upDescField;
    private JLabel upDescLabel;
    private JCheckBox upDescCheck;
    private JPanel upDescPanel;
    private JCheckBox upInnateCheck;
    private JCheckBox upRetainCheck;
    private JCheckBox upExhaustCheck;
    private JCheckBox upEtherealCheck;
    private JTable onUpgradeActionTable;
    private JScrollPane onUpgradeScroll;
    private JScrollPane actionListScroll;
    private JLabel DefaultStateLabel;
    private JLabel onUpgradeStateLabel;
    private JButton AddRemoveOnUpgradeButton;
    private JButton removeUpActionButton;
    private JCheckBox addActionOnUpgradeCheck;
    private JPanel actionOnUpgradePanel;
    private JComboBox actionCategoryBox;
    private JPanel cardStatePanel;
    private JButton newCardButton;

    int rowIndex = 0;
    int upTableRowIndex = 0;
    int tableHeight = 0;
    int upTableHeight = 0;
    JFileChooser f = new JFileChooser();
    File workingDirectory;

    int winXPos = 500;
    int winYPos = 50;

    int cellHeight = 20;
    Point originWinPos = new Point(winXPos, 200);
    Point upActionEnabledWinPos = new Point(winXPos, 100);


    boolean cellNum;
    DefaultTableModel tabModel;
    DefaultTableModel upgradeTabModel;

    JCheckBox[] cardStates = {
            InnateCheck,
            RetainCheck,
            ExhaustCheck,
            EtherealCheck,
    };
    JCheckBox[] upCardStates = {
            upInnateCheck,
            upRetainCheck,
            upExhaustCheck,
            upEtherealCheck
    };
    String cardName;

    static UI ui;
    public static void main(String[] args)
    {
        try
        {// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if (info.getName().equals("Nimbus"))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIDefaults defaults = UIManager.getLookAndFeelDefaults();
                    defaults.put("Table.gridColor", new Color(0, 0, 0));
                    defaults.put("Table.disabled", false);
                    defaults.put("Table.showGrid", true);
                    defaults.put("Table.intercellSpacing", new Dimension(1, 1));
                    break;
                }
            }
        } catch (Exception e)
        {
            //e.printStackTrace();
        }
         ui = new UI();

    }

    ActionCategory category;
    DefaultListModel dmgListModel = new DefaultListModel();
    DefaultListModel blcListModel = new DefaultListModel();
    DefaultListModel energyListModel = new DefaultListModel();
    DefaultListModel etcListModel = new DefaultListModel();
    DefaultListModel buffListModel = new DefaultListModel();
    DefaultListModel addCardListModel = new DefaultListModel();
    DefaultListModel drawCardListModel = new DefaultListModel();
    DefaultListModel exhListModel = new DefaultListModel();

    public void ActionCategory()
    {

        category = ActionCategory.getInstance();

        for (String item : category.dmgArray)
            dmgListModel.addElement(item);
        for (String item : category.blockArry)
            blcListModel.addElement(item);
        for (String item : category.energyArray)
            energyListModel.addElement(item);
        for (String item : category.etcArray)
            etcListModel.addElement(item);
        for (String item : category.buffArray)
            buffListModel.addElement(item);
        for (String item : category.addCardArray)
            addCardListModel.addElement(item);
        for (String item : category.drawCardArray)
            drawCardListModel.addElement(item);
        for (String item : category.exhArray)
            exhListModel.addElement(item);
    }

    private void CreatedCardTrue()
    {
        cardTypeLabel.setVisible(true);
        cardTypeList.setVisible(true);
        CardPanel.setVisible(true);
        CreateButton.setVisible(true);
        CreateNewCard.setVisible(false);
        setLocation(originWinPos);
        SetWindowSize(0);
    }

    TableColumn repeatCol;
    TableColumn repeatColUp;
    int xtraTableHeight = 250;
    int xDescHeight = 90;

    String curDir;
    public UI()
    {
        //region UI Init
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardTypeLabel.setVisible(false);
        cardTypeList.setVisible(false);
        CardPanel.setVisible(false);
        upDescPanel.setVisible(false);
        actionOnUpgradePanel.setVisible(false);
        this.pack();
        setTitle("TheCreator");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        //endregion
        curDir = System.getProperty("user.dir");
        //region List & Table Init
        DefaultListModel originActionListModel = new DefaultListModel();
        DefaultListModel actionListModel = new DefaultListModel();

        for (int i = 0; i < actionList.getModel().getSize(); i++)
        {
            actionListModel.addElement(actionList.getModel().getElementAt(i));
            originActionListModel.addElement(actionList.getModel().getElementAt(i));
        }

        ActionCategory();

        actionList.setModel(dmgListModel);
        String[] colName = {"Action", "Base Value", "Upgraded Value", "Activation Condition", "Extra Option", "Repeat"};
        String[] colNameUpGrade = {"Action", "Value", "Add/Remove", "Activation Condition", "Extra Option", "Repeat"};
        tabModel = new DefaultTableModel(null, colName)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0)
                    return false;
                if ((column == 3 || column == 4 || column == 5) && getValueAt(row, 0).toString().equals("Repeat"))
                    return false;
                if (varlessTableCheck(this, row) && (column == 1 || column == 2))
                    return false;
                return (column != 4) || addCardTableCheck(this, row);
            }

            @Override
            public void setValueAt(Object value, int row, int column)
            {
                //limit cell character
                if (column >= 1 && column <= 2 && value.toString().length() >= 4)
                {
                    if (value.toString().contains("-"))
                        super.setValueAt(value.toString().substring(0, 4), row, column);
                    else
                        super.setValueAt(value.toString().substring(0, 3), row, column);
                } else
                {
                    super.setValueAt(value, row, column);
                }
            }

            @Override
            public Class getColumnClass(int column)
            {
                switch (column)
                {
                    case 0:
                    case 1:
                    case 2:
                        return String.class;
                    case 3:
                    case 4:
                        return DefaultComboBoxModel.class;
                    default:
                        return Boolean.class;
                }
            }
        };


        upgradeTabModel = new DefaultTableModel(null, colNameUpGrade)
        {
            /*   @Override
               public boolean isCellEditable(int row, int column)
               {
                   return column != 0;
               }*/
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0)
                    return false;
                if ((column == 2 || column == 3 || column == 4 || column == 5) && getValueAt(row, 0).toString().equals("Repeat"))
                    return false;
                if (varlessTableCheck(this, row) && (column == 1))
                    return false;
                return (column != 4) || addCardTableCheck(this, row);
            }

            @Override
            public void setValueAt(Object value, int row, int column)
            {
                //limit cell character
                if (column == 1 && value.toString().length() >= 4)
                {
                    if (value.toString().contains("-"))
                        super.setValueAt(value.toString().substring(0, 4), row, column);
                    else
                        super.setValueAt(value.toString().substring(0, 3), row, column);
                } else
                {
                    super.setValueAt(value, row, column);
                }
            }

            @Override
            public Class getColumnClass(int column)
            {
                switch (column)
                {
                    case 0:
                    case 1:
                        return String.class;
                    case 2:
                    case 3:
                    case 4:
                        return DefaultComboBoxModel.class;
                    default:
                        return Boolean.class;
                }
            }
        };


        tabModel.isCellEditable(0, 0);
        upgradeTabModel.isCellEditable(0, 0);
        //tabModel.getColumnClass(1);
        actionTable.setModel(tabModel);
        onUpgradeActionTable.setModel(upgradeTabModel);


        //region condi col
        DefaultComboBoxModel conditionListModel = new DefaultComboBoxModel();
        TableColumn conditionColumnDefault = actionTable.getColumnModel().getColumn(3);
        TableColumn conditionColumnUpgrade = onUpgradeActionTable.getColumnModel().getColumn(3);

        JComboBox<String> conditionList = new JComboBox<>();
        conditionListModel.addElement("None");
        conditionListModel.addElement("Enemy Intent: Attack");
        conditionList.setModel(conditionListModel);
        conditionColumnDefault.setCellEditor(new DefaultCellEditor(conditionList));
        conditionColumnUpgrade.setCellEditor(new DefaultCellEditor(conditionList));
        //endregion

        //region add target col
        DefaultComboBoxModel extraOptionListModel = new DefaultComboBoxModel();
        TableColumn extraOptionCol = actionTable.getColumnModel().getColumn(4);
        TableColumn extraOptionColUp = onUpgradeActionTable.getColumnModel().getColumn(4);

        JComboBox<String> extraOptionList = new JComboBox<>();
        extraOptionListModel.addElement("Hand");
        extraOptionListModel.addElement("Discard");
        extraOptionListModel.addElement("Draw Pile");
        extraOptionListModel.addElement("Top Draw Pile");
        extraOptionListModel.addElement("Bot Draw Pile");
        extraOptionList.setModel(extraOptionListModel);
        extraOptionCol.setCellEditor(new DefaultCellEditor(extraOptionList));
        extraOptionColUp.setCellEditor(new DefaultCellEditor(extraOptionList));
        //endregion

        DefaultComboBoxModel addRemoveModel = new DefaultComboBoxModel();
        TableColumn addRemoveCol = onUpgradeActionTable.getColumnModel().getColumn(2);

        JComboBox<String> addRemoveOption = new JComboBox<>();
        addRemoveModel.addElement("Add");
        addRemoveModel.addElement("Remove");
        addRemoveOption.setModel(addRemoveModel);
        addRemoveCol.setCellEditor(new DefaultCellEditor(addRemoveOption));


        //region repeat
        repeatCol = actionTable.getColumnModel().getColumn(5);
        repeatColUp = onUpgradeActionTable.getColumnModel().getColumn(5);

        actionTable.removeColumn(repeatCol);
        onUpgradeActionTable.removeColumn(repeatColUp);

        //endregion
        actionTable.getTableHeader().setReorderingAllowed(false);
        onUpgradeActionTable.getTableHeader().setReorderingAllowed(false);
        //endregion

        //region UI ACTION LISTENER
        CreateNewCard.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent b)
            {


                cardName = CardTemplateStrings.DeleteSpace(CardName.getText());
                if (curDir.contains("theDefault"))
                {
                    workingDirectory = new File(curDir + "/src/main/java/" + GetModId() + "/cards/CustomCards/");
                } else
                {
                    workingDirectory = new File(curDir + "/theDefault/src/main/java/" + GetModId() + "/cards/CustomCards/");
                }
                f.setCurrentDirectory(workingDirectory);

                if (!CardName.getText().isEmpty())
                {

                    f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    f.showSaveDialog(null);
                    File file = new File(f.getSelectedFile() + "/" + cardName + ".java");

                    f.setCurrentDirectory(f.getSelectedFile());
                    try
                    {
                        // create a new file with name specified
                        // by the file object
                        boolean value = file.createNewFile();
                        if (value)
                        {
                            JOptionPane.showMessageDialog(CreateNewCard, "New Card created");
                            CreatedCardTrue();
                        } else
                        {
                            JOptionPane.showMessageDialog(CreateNewCard, "Card Exists, switching to edit mode");
                            CreatedCardTrue();
                            ReadSavedFile();
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
                if (onUpgradeActionTable.isEditing())
                    onUpgradeActionTable.getCellEditor().stopCellEditing();

                //region table values check
                for (int i = 0; i < actionTable.getRowCount(); i++)
                {
                    for (int j = 1; j < 3; j++)
                    {
                        if (!inputValidator(tabModel, i, j))
                            return;
                    }
                }

                //InputValueFieldCheck(onUpgradeActionTable,upgradeTabModel);
                for (int i = 0; i < onUpgradeActionTable.getRowCount(); i++)
                {
                    if (!inputValidator(upgradeTabModel, i, 1))
                        return;
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
                String cardContent = "";
                cardContent = CreateCard();

                try
                {
                    cardName = CardTemplateStrings.DeleteSpace(CardName.getText());
                    // Creates a Writer using FileWriter
                    FileWriter output = new FileWriter(f.getSelectedFile() + "/" + cardName + ".java");

                    // Writes the  to file

                    output.write(cardContent);
                    System.out.println("Data is written to the file.");
                    JOptionPane.showMessageDialog(CreateButton, "Card Properties applied!");
                    // Closes the writer
                    output.close();

                    SaveFile();

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
                    if (data.toString().equals("Repeat") && !(existsInTable(actionTable, data)))
                    {
                        actionTable.addColumn(repeatCol);
                        tabModel.addRow(new Object[]{data.toString(), null, null, "x", "x", true});
                        tableHeight += cellHeight;
                        SetActionTableSize();
                        return;
                    }
                    if (existsInTable(actionTable, data) || existsInTable(onUpgradeActionTable, data))
                    {
                        if (!actionCategoryBox.getSelectedItem().equals("Add Card"))
                        {
                            JOptionPane.showMessageDialog(selectActionButton, "Already in List!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    if (data.toString().equals("Repeat"))
                    {
                        actionTable.addColumn(repeatCol);
                        tabModel.addRow(new Object[]{data.toString(), null, null, "x", "x", true});

                    } else if (actionVarlessCheck(data))
                    {
                        tabModel.addRow(new Object[]{data.toString(), "x", "x", "None", "x", false});
                    } else if (addCardCheck(data))
                    {
                        tabModel.addRow(new Object[]{data.toString(), null, null, "None", "None", false});
                    } else
                        tabModel.addRow(new Object[]{data.toString(), null, null, "None", "x", false});
                    //tabModel.setValueAt(data, rowIndex++, 0);
                    tableHeight += cellHeight;
                    SetActionTableSize();


                });
            }
        });
        removeActionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (actionTable.getSelectedRowCount() == 0)
                    return;
                if (actionTable.getValueAt(actionTable.getSelectedRow(), 0).toString().equals("Repeat"))
                {
                    actionTable.removeColumn(repeatCol);
                    for (int i = 0; i < actionTable.getRowCount(); i++)
                    {
                        tabModel.setValueAt(false, i, 5);
                    }
                }
                RemoveSelectedActions(actionTable, actionListModel, "actionTable");
            }
        });
        upDescCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (upDescCheck.isSelected())
                {
                    upDescPanel.setVisible(true);
                    SetWindowSize(xDescHeight);
                    if (addActionOnUpgradeCheck.isSelected())
                        setLocation(winXPos, winYPos);
                } else
                {
                    upDescPanel.setVisible(false);
                    SetWindowSize(-xDescHeight);
                    if (addActionOnUpgradeCheck.isSelected())
                        setLocation(upActionEnabledWinPos);
                }
            }
        });

        //region cardstates
        InnateCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                upInnateCheck.setSelected(InnateCheck.isSelected());
            }
        });

        RetainCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                upRetainCheck.setSelected(RetainCheck.isSelected());
            }
        });


        ExhaustCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                upExhaustCheck.setSelected(ExhaustCheck.isSelected());
            }
        });

        EtherealCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                upEtherealCheck.setSelected(EtherealCheck.isSelected());
            }
        });
        //endregion
        AddRemoveOnUpgradeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                actionList.getSelectedValuesList().stream().forEach((data) ->
                {
                    if (data.toString().equals("Repeat") && !(existsInTable(onUpgradeActionTable, data)))
                    {
                        onUpgradeActionTable.addColumn(repeatColUp);
                        upgradeTabModel.addRow(new Object[]{data.toString(), null, "x", "x", "x", true});
                        upTableHeight += cellHeight;
                        SetUpgradeActionTableSize();
                        return;
                    }
                    if (existsInTable(actionTable, data) || existsInTable(onUpgradeActionTable, data))
                    {
                        if (!actionCategoryBox.getSelectedItem().equals("Add Card"))
                        {
                            JOptionPane.showMessageDialog(AddRemoveOnUpgradeButton, "Already in List!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    if (data.toString().equals("Repeat"))
                    {
                        onUpgradeActionTable.addColumn(repeatColUp);
                        upgradeTabModel.addRow(new Object[]{data.toString(), null, "x", "x", "x", true});
                        //tabModel.isCellEditable(0,3);

                    } else if (actionVarlessCheck(data))
                    {
                        upgradeTabModel.addRow(new Object[]{data.toString(), "x", "Add", "None", "x", false});
                    } else if (addCardCheck(data))
                    {
                        upgradeTabModel.addRow(new Object[]{data.toString(), null, null, "None", "None", false});
                    } else
                        upgradeTabModel.addRow(new Object[]{data.toString(), null, "Add", "None", "x", false});
                    //actionListModel.removeElement(data);
                    //upgradeTabModel.addRow(new Object[]{data.toString(), null, "None"});
                    //upgradeTabModel.setValueAt(data, upTableRowIndex++, 0);
                    upTableHeight += cellHeight;
                    SetUpgradeActionTableSize();

                });
            }
        });
        removeUpActionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (onUpgradeActionTable.getSelectedRowCount() == 0)
                    return;
                if (onUpgradeActionTable.getValueAt(onUpgradeActionTable.getSelectedRow(), 0).toString().equals("Repeat"))
                {
                    onUpgradeActionTable.removeColumn(repeatColUp);
                    for (int i = 0; i < onUpgradeActionTable.getRowCount(); i++)
                    {
                        upgradeTabModel.setValueAt(false, i, 5);
                    }
                }
                RemoveSelectedActions(onUpgradeActionTable, actionListModel, "upActionTable");
            }
        });
        addActionOnUpgradeCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (addActionOnUpgradeCheck.isSelected())
                {
                    actionOnUpgradePanel.setVisible(true);
                    SetWindowSize(xtraTableHeight);
                    setLocation(upActionEnabledWinPos);
                } else
                {
                    actionOnUpgradePanel.setVisible(false);
                    SetWindowSize(-xtraTableHeight);
                    setLocation(originWinPos);
                }

            }
        });

        //endregion
        actionCategoryBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String matcher = actionCategoryBox.getSelectedItem().toString();
                switch (matcher)
                {
                    case "Damage":
                        actionList.setModel(dmgListModel);
                        break;
                    case "Block":
                        actionList.setModel(blcListModel);
                        break;
                    case "Energy":
                        actionList.setModel(energyListModel);
                        break;
                    case "EtcTemp":
                        actionList.setModel(etcListModel);
                        break;
                    case "Buff/Debuff":
                        actionList.setModel(buffListModel);
                        break;
                    case "Add Card":
                        actionList.setModel(addCardListModel);
                        break;
                    case "Draw Card":
                        actionList.setModel(drawCardListModel);
                        break;
                    case "Exhaust Card":
                        actionList.setModel(exhListModel);
                        break;
                }
            }
        });
        newCardButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ui.dispose();
                ui = new UI();
            }
        });
    }


    //region Utils

    public String CreateCard()
    {
        return CardTemplateStrings.CardTemplate(
                CardName,
                costField,
                upCostField,
                rarityList,
                targetList,
                cardTypeList,
                descriptionField,
                upDescField,
                upDescCheck,
                unlockCheck,
                tabModel,
                upgradeTabModel,
                addActionOnUpgradeCheck,
                cardStates,
                upCardStates);
    }

    private void ReadSavedFile()
    {
        String filePath;
        if(curDir.contains("theDefault")){
            filePath = "src/main/java/" + GetModId() + "/cards/CardData/" + cardName + ".txt";

        }
        else {
            filePath = "theDefault/src/main/java/" + GetModId() + "/cards/CardData/" + cardName + ".txt";

        }
        File fileSaved = new File(filePath);
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileSaved));
            cardTypeList.setSelectedItem(br.readLine());

            //region table
            // get the table line
            // get the columns name from the first line
            // set columns name to the jtable model
            int tableCount = Integer.parseInt(br.readLine());

            String colNameLine = br.readLine().trim();
            String[] columnsName = colNameLine.split("\\|");
            if (columnsName.length > 5)
                actionTable.addColumn(repeatCol);
            // get lines from txt file
            //Object[] tableLines = br.lines().toArray();

            // extract data from lines
            // set data to jtable model
            for (int i = 0; i < tableCount; i++)
            {
                String line = br.readLine().trim();
                String[] dataRow = line.split("\\|");
                if (dataRow.length < 6)
                {
                    addSavedValue(dataRow, false);
                } else
                {
                    addSavedValue(dataRow, Boolean.parseBoolean(dataRow[5]));
                }
            }
            tableHeight = tabModel.getRowCount() * cellHeight;
            SetActionTableSize();
            //endregion

            //region upTable
            addActionOnUpgradeCheck.setSelected(Boolean.parseBoolean(br.readLine()));

            if (addActionOnUpgradeCheck.isSelected())
            {
                actionOnUpgradePanel.setVisible(true);
                SetWindowSize(xtraTableHeight);
                setLocation(upActionEnabledWinPos);

                int upTableCount = Integer.parseInt(br.readLine());

                String colNameLineUp = br.readLine().trim();
                String[] columnsNameUp = colNameLineUp.split("\\|");
                if (columnsNameUp.length > 5)
                    onUpgradeActionTable.addColumn(repeatColUp);
                // get lines from txt file
                //Object[] tableLines = br.lines().toArray();

                // extract data from lines
                // set data to jtable model
                for (int i = 0; i < upTableCount; i++)
                {
                    String line = br.readLine().trim();//tableLines[i].toString().trim();
                    String[] dataRow = line.split("\\|");
                    if (dataRow.length < 6)
                        addSavedValueUp(dataRow, false);
                        //upgradeTabModel.addRow((dataRow));
                    else
                    {
                        addSavedValueUp(dataRow, Boolean.parseBoolean(dataRow[5]));
                        //upgradeTabModel.addRow(new Object[]{dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4], Boolean.parseBoolean(dataRow[5])});
                    }
                }
                upTableHeight = upgradeTabModel.getRowCount() * cellHeight;
                SetUpgradeActionTableSize();
            }
            //endregion

            //region cost & rarity & target
            costField.setText(br.readLine());
            upCostField.setText(br.readLine());
            rarityList.setSelectedItem(br.readLine());
            targetList.setSelectedItem(br.readLine());
            //endregion

            //region description
            int descLineCount = Integer.parseInt(br.readLine());
            StringBuilder sbDesc = new StringBuilder();
            for (int i = 0; i < descLineCount; i++)
            {
                sbDesc.append(br.readLine());
                if (i < descLineCount - 1)
                    sbDesc.append("\n");
            }
            descriptionField.setText(sbDesc.toString());
            //endregion

            //region upDescription
            upDescCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            if (upDescCheck.isSelected())
            {

                upDescPanel.setVisible(true);
                SetWindowSize(xDescHeight);
                if (addActionOnUpgradeCheck.isSelected())
                    setLocation(winXPos, winYPos);

                int upDescLineCount = Integer.parseInt(br.readLine());
                StringBuilder sbUpDesc = new StringBuilder();
                for (int i = 0; i < upDescLineCount; i++)
                {
                    sbUpDesc.append(br.readLine());
                    if (i < upDescLineCount - 1)
                        sbUpDesc.append("\n");
                }
                upDescField.setText(sbUpDesc.toString());
            }
            //endregion
            unlockCheck.setSelected(Boolean.parseBoolean(br.readLine()));

            //region cards states
            InnateCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            upInnateCheck.setSelected(Boolean.parseBoolean(br.readLine()));

            RetainCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            upRetainCheck.setSelected(Boolean.parseBoolean(br.readLine()));

            ExhaustCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            upExhaustCheck.setSelected(Boolean.parseBoolean(br.readLine()));

            EtherealCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            upEtherealCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            //endregion

            br.close();

        } catch (Exception e)
        {
            e.getStackTrace();
        }
    }

    private void addSavedValue(String[] dataRow, boolean repeat)
    {
        tabModel.addRow(new Object[]{dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4], repeat});
    }

    private void addSavedValueUp(String[] dataRow, boolean repeat)
    {
        upgradeTabModel.addRow(new Object[]{dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4], repeat});
    }


    private void SaveFile()
    {
        String filePath;
        if(curDir.contains("theDefault")){
            filePath = "src/main/java/" + GetModId() + "/cards/CardData/" + cardName + ".txt";

        }
        else {
            filePath = "theDefault/src/main/java/" + GetModId() + "/cards/CardData/" + cardName + ".txt";

        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter((filePath))))
        {
            bw.write(cardTypeList.getSelectedItem().toString());
            bw.newLine();

            //region table
            int tableItemCount = actionTable.getRowCount();
            bw.write(String.valueOf(tableItemCount));
            bw.newLine();

            StringJoiner joiner = new StringJoiner("|");
            for (int col = 0; col < actionTable.getColumnCount(); col++)
            {
                joiner.add(actionTable.getColumnName(col));
            }
            System.out.println(joiner);
            bw.write(joiner.toString());
            bw.newLine();
            for (int row = 0; row < actionTable.getRowCount(); row++)
            {
                joiner = new StringJoiner("|");
                for (int col = 0; col < actionTable.getColumnCount(); col++)
                {
                    Object obj = actionTable.getValueAt(row, col);
                    String value = obj == null ? "null" : obj.toString();
                    joiner.add(value);
                }
                System.out.println(joiner);
                bw.write(joiner.toString());
                bw.newLine();
            }
            //endregion

            //region upTable
            bw.write(String.valueOf(addActionOnUpgradeCheck.isSelected()));
            bw.newLine();
            if (addActionOnUpgradeCheck.isSelected())
            {
                int upTableItemCount = onUpgradeActionTable.getRowCount();
                bw.write(String.valueOf(upTableItemCount));
                bw.newLine();

                StringJoiner upTableJoiner = new StringJoiner("|");
                for (int col = 0; col < onUpgradeActionTable.getColumnCount(); col++)
                {
                    upTableJoiner.add(onUpgradeActionTable.getColumnName(col));
                }
                System.out.println(upTableJoiner);
                bw.write(upTableJoiner.toString());
                bw.newLine();
                for (int row = 0; row < onUpgradeActionTable.getRowCount(); row++)
                {
                    upTableJoiner = new StringJoiner("|");
                    for (int col = 0; col < onUpgradeActionTable.getColumnCount(); col++)
                    {
                        Object obj = onUpgradeActionTable.getValueAt(row, col);
                        String value = obj == null ? "null" : obj.toString();
                        upTableJoiner.add(value);
                    }
                    System.out.println(upTableJoiner);
                    bw.write(upTableJoiner.toString());
                    bw.newLine();
                }
            }
            //endregion

            //region cost
            bw.write(costField.getText());
            bw.newLine();

            bw.write(upCostField.getText());
            bw.newLine();

            //endregion

            //region rarity & target
            bw.write(rarityList.getSelectedItem().toString());
            bw.newLine();

            bw.write(targetList.getSelectedItem().toString());
            bw.newLine();
            //endregion

            //region description
            bw.write(String.valueOf(descriptionField.getLineCount()));
            bw.newLine();
            bw.write(descriptionField.getText());
            bw.newLine();

            bw.write(String.valueOf(upDescCheck.isSelected()));
            bw.newLine();
            if (upDescCheck.isSelected())
            {
                bw.write(String.valueOf(upDescField.getLineCount()));
                bw.newLine();
                bw.write(upDescField.getText());
                bw.newLine();
            }
            //endregion

            bw.write(String.valueOf(unlockCheck.isSelected()));
            bw.newLine();

            //region card states
            bw.write(String.valueOf(InnateCheck.isSelected()));
            bw.newLine();
            bw.write(String.valueOf(upInnateCheck.isSelected()));
            bw.newLine();

            bw.write(String.valueOf(RetainCheck.isSelected()));
            bw.newLine();
            bw.write(String.valueOf(upRetainCheck.isSelected()));
            bw.newLine();

            bw.write(String.valueOf(ExhaustCheck.isSelected()));
            bw.newLine();
            bw.write(String.valueOf(upExhaustCheck.isSelected()));
            bw.newLine();

            bw.write(String.valueOf(EtherealCheck.isSelected()));
            bw.newLine();
            bw.write(String.valueOf(upEtherealCheck.isSelected()));
            //endregion


        } catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }

    private boolean inputValidator(DefaultTableModel model, int i, int j)
    {
        String actionName = model.getValueAt(i, 0).toString() + "\n[" + model.getColumnName(j);
        if (model.getValueAt(i, j) == null)
        {
            JOptionPane.showMessageDialog(CreateButton, "Action: " + actionName + "] field is empty");
            return false;
        }
        for (int k = 0; k < category.varLessAction.length; k++)
        {
            if (model.getValueAt(i, 0).toString().equals(category.varLessAction[k]))
            { //compare action in table with action in varless list to skip x validation
                return true;
            }
        }

        cellNum = isNumeric(model.getValueAt(i, j).toString());
        if (!cellNum)
        {
            JOptionPane.showMessageDialog(CreateButton, "Action: " + actionName + "] field contains letter or is not whole number");
            return false;
        }
        return true;
    }

    private boolean actionVarlessCheck(Object data)
    {
        for (int i = 0; i < category.varLessAction.length; i++)
        {
            if (data.toString().equals(category.varLessAction[i]))
                return true;
        }
        return false;
    }

    private boolean addCardCheck(Object data)
    {
        for (int i = 0; i < category.addCardArray.length; i++)
        {
            if (data.toString().equals(category.addCardArray[i]))
                return true;
        }
        return false;
    }

    private boolean varlessTableCheck(DefaultTableModel tabModel, int row)
    {
        for (int i = 0; i < category.varLessAction.length; i++)
        {
            if (tabModel.getValueAt(row, 0).toString().equals(category.varLessAction[i]))
                return true;
        }
        return false;
    }

    private boolean addCardTableCheck(DefaultTableModel tabModel, int row)
    {
        for (int i = 0; i < category.addCardArray.length; i++)
        {
            if (tabModel.getValueAt(row, 0).toString().equals(category.addCardArray[i]))
                return true;
        }
        return false;
    }

    public void RemoveSelectedActions(JTable table, DefaultListModel actionListModel, String whichTable)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
/*        int actionCount = table.getRowCount();
        if(actionCount ==0)
            return;*/
        int numRows = table.getSelectedRows().length;
        for (int i = 0; i < numRows; i++)
        {
            //actionListModel.addElement(table.getValueAt(table.getSelectedRow(), 0));
            // dataSave=table.getValueAt(table.getSelectedRow(), 0).toString();
            model.removeRow(table.getSelectedRow());
           /* if (dataSave.equals("Repeat")){
                tabModel.setColumnCount(5);
            }*/
            if (whichTable.equals("actionTable"))
            {
                /* rowIndex--;*/
                tableHeight -= cellHeight;
            } else if (whichTable.equals("upActionTable"))
            {
                /*  upTableRowIndex--;*/
                upTableHeight -= cellHeight;
            }
        }
        SetActionTableSize();
    }

    public void SetWindowSize(int ExtraHeight)
    {
        setPreferredSize(new Dimension(1300, getPreferredSize().height + ExtraHeight));
        pack();
    }

    public void SetActionTableSize()
    {
        Dimension increaseHeight = new Dimension(450, tableHeight);
        actionTable.setPreferredSize(increaseHeight);

    }

    public void SetUpgradeActionTableSize()
    {
        Dimension increaseHeight = new Dimension(450, upTableHeight);
        onUpgradeActionTable.setPreferredSize(increaseHeight);
    }

    private boolean isNumeric(String text)
    {
        String regex = "-?(0|[1-9]\\d*)";
        if (text == null || text.trim().equals(""))
        {
            return false;
        }
      /*  if(text.equals("-1") || text.equals("-2"))
            return true;
        for (int iCount = 0; iCount < text.length(); iCount++)
        {
            if (!Character.isDigit(text.charAt(iCount)))
            {
                return false;
            }
        }*/
        return text.matches(regex);
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

    public boolean existsInTable(JTable table, Object entry)
    {

        // Get row and column count
        int rowCount = table.getRowCount();

        // Check against all entries
        for (int i = 0; i < rowCount; i++)
        {
            String rowEntry = "";
            rowEntry = table.getValueAt(i, 0).toString();
            if (rowEntry.equalsIgnoreCase(entry.toString()))
            {
                return true;
            }
        }
        return false;
    }

/*    public static void Test(String name,int count){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/suikaMod/cards/CardData/BattleData.txt")))*//*BufferedWriter bw = new BufferedWriter(new FileWriter( "BattleData.txt",true)))*//*
        {

            bw.write("used");
            System.out.println("Card [" + name + "] used: " + count + " Times");
            bw.newLine();
        } catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }*/

    //endregion

}
