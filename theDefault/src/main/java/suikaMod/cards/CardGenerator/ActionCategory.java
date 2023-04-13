package suikaMod.cards.CardGenerator;

public class ActionCategory
{
    private static ActionCategory single_instance = null;
    private ActionCategory()
    {

    }

    public static synchronized ActionCategory getInstance()
    {
        if (single_instance == null)
            single_instance = new ActionCategory();

        return single_instance;
    }
    public final String[] dmgArray={
            "Damage",
            "Modify Damage On Use",
            "Damage Per Energy Used",
            "Vampire Damage",
            "Damage If Target Poisoned",
            "Damage Per Attack Played",
            "Damage Per Skill In Hand",
    };

    public final String[] blockArry={
            "Block",
            "Double Block"
    };

    //"Reduce Cost On Hp Lost"
    public final String[] energyArray={
            "Gain Energy",
            "Double Energy",
            "Gain Energy Next Turn",
            "Gain Energy If Discard>0"

    };

    public final String[] etcArray={
            "Repeat",
            "Sacrifice HP",
            "Heal",
            "Upgrade All"
    };

    public final String[] buffArray = {
            "Apply Vulnerable",
            "Apply Weak",
            "Apply Poison",
            "Apply Strength",

            "Apply Double Vulnerable",
            "Apply Double Weak",
            "Apply Double Poison",
            "Apply Double Strength",

            "Gain Vulnerable",
            "Gain Weak",
            "Gain Poison",
            "Gain Strength",
            "Gain Dexterity",
            "Gain Intangible",

            "Gain Double Vulnerable",
            "Gain Double Weak",
            "Gain Double Poison",
            "Gain Double Strength",
            "Gain Double Dexterity",
    };
    public final String[] addCardArray = {
            "Add Copy",
            "Add Random Attack Copy",
            "Add Random Skill Copy",
            "Add Random Power Copy",
            "Add Random Colorless Copy",
            "Add Random Attack",
            "Add Random Skill",
            "Add Random Power",
            "Add Random Colorless",
    };

    public final String[] drawCardArray={
            "Choose To Draw",
            "Choose To Draw(Attack)",
            "Choose To Draw(Skill)",
            "Draw Card",
            "Draw Until x Card On Hand",
            "Draw Extra Next Turn",
            "Draw Extra At Turn Start",
            "Draw When Discard",
            "Draw Per Exhaust",
            "Draw Per Unique Orb",
            "Draw On Power Play",
    };

    public final String[] exhArray={
            "Exhaust Card",
            "Exhaust Card(Random)",
            "Exhaust Hand",
            "Exhaust Any Amount Up To",
    };

    public final String[] varLessAction={ //used to check for variableless action
            "Exhaust Hand",
            "Gain Double Vulnerable",
            "Gain Double Weak",
            "Gain Double Poison",
            "Gain Double Strength",
            "Gain Double Dexterity",
            "Apply Double Vulnerable",
            "Apply Double Weak",
            "Apply Double Poison",
            "Apply Double Strength",
            "Double Block",
            "Double Energy",
    };
}
