package suikaMod.cards;

import basemod.abstracts.CustomCard;

public abstract class AbstractDefaultCard extends CustomCard
{

    // Custom Abstract Cards can be a bit confusing. While this is a simple base for simply adding a second magic number,
    // if you're new to modding I suggest you skip this file until you know what unique things that aren't provided
    // by default, that you need in your own cards.

    // In this example, we use a custom Abstract Card in order to define a new magic number. From here on out, we can
    // simply use that in our cards, so long as we put "extends AbstractDynamicCard" instead of "extends CustomCard" at the start.
    // In simple terms, it's for things that we don't want to define again and again in every single card we make.

    //region vulnerable
    public int aVulnerableValue;        // Just like magic number, or any number for that matter, we want our regular, modifiable stat
    public int aBaseVulnerableValue;    // And our base stat - the number in it's base state. It will reset to that by default.
    public boolean aUpgradedVulnerableValue; // A boolean to check whether the number has been upgraded or not.
    public boolean aIsVulnerableValueModified; // A boolean to check whether the number has been modified or not, for coloring purposes. (red/green)

    public int gVulnerableValue;
    public int gBaseVulnerableValue;
    public boolean gUpgradedVulnerableValue;
    public boolean gIsVulnerableValueModified;
    //endregion

    //region weak
    public int aWeakValue;
    public int aBaseWeakValue;
    public boolean aUpgradedWeakValue;
    public boolean aIsWeakValueModified;

    public int gWeakValue;
    public int gBaseWeakValue;
    public boolean gUpgradedWeakValue;
    public boolean gIsWeakValueModified;
    //endregion

    //region poison
    public int aPoisonValue;
    public int aBasePoisonValue;
    public boolean aUpgradedPoisonValue;
    public boolean aIsPoisonValueModified;

    public int gPoisonValue;
    public int gBasePoisonValue;
    public boolean gUpgradedPoisonValue;
    public boolean gIsPoisonValueModified;
    //endregion

    //region poison
    public int aStrValue;
    public int aBaseStrValue;
    public boolean aUpgradedStrValue;
    public boolean aIsStrValueModified;

    public int gStrValue;
    public int gBaseStrValue;
    public boolean gUpgradedStrValue;
    public boolean gIsStrValueModified;
    //endregion

    public AbstractDefaultCard(final String id,
                               final String name,
                               final String img,
                               final int cost,
                               final String rawDescription,
                               final CardType type,
                               final CardColor color,
                               final CardRarity rarity,
                               final CardTarget target)
    {

        super(id, name, img, cost, rawDescription, type, color, rarity, target);

        // Set all the things to their default values.
        isCostModified = false;
        isCostModifiedForTurn = false;

        isDamageModified = false;
        isBlockModified = false;

        isMagicNumberModified = false;

        aIsVulnerableValueModified = false;
        aIsWeakValueModified = false;
        aIsPoisonValueModified = false;
        aIsStrValueModified = false;

        gIsVulnerableValueModified=false;
        gIsWeakValueModified=false;
        gIsPoisonValueModified= false;
        gIsStrValueModified=false;
    }

    public void displayUpgrades()
    { // Display the upgrade - when you click a card to upgrade it
        super.displayUpgrades();
        if (aUpgradedVulnerableValue)
        { // If we set upgradedDefaultSecondMagicNumber = true in our card.
            aVulnerableValue = aBaseVulnerableValue; // Show how the number changes, as out of combat, the base number of a card is shown.
            aIsVulnerableValueModified = true; // Modified = true, color it green to highlight that the number is being changed.
        }

        if (aUpgradedWeakValue)
        {
            aWeakValue = aBaseWeakValue;
            aIsWeakValueModified = true;
        }

        if (aUpgradedPoisonValue)
        {
            aPoisonValue = aBasePoisonValue;
            aIsPoisonValueModified = true;
        }

        if (aUpgradedStrValue)
        {
            aStrValue = aBaseStrValue;
            aIsStrValueModified = true;
        }

        if (gUpgradedVulnerableValue)
        {
            gVulnerableValue = gBaseVulnerableValue;
            gIsVulnerableValueModified = true;
        }

        if (gUpgradedWeakValue)
        {
            gWeakValue = gBaseWeakValue;
            gIsWeakValueModified = true;
        }

        if (gUpgradedPoisonValue)
        {
            gPoisonValue = gBasePoisonValue;
            gIsPoisonValueModified = true;
        }

        if (gUpgradedStrValue)
        {
            gStrValue = gBaseStrValue;
            gIsStrValueModified = true;
        }

    }

    @Override
    protected void upgradeDamage(int amount)
    {
        this.baseDamage = amount;
        this.upgradedDamage = true;
    }

    @Override
    protected void upgradeBlock(int amount)
    {
        this.baseBlock = amount;
        this.upgradedBlock = true;
    }

    @Override
    protected void upgradeMagicNumber(int amount)
    {
        this.baseMagicNumber = amount;
        this.magicNumber = this.baseMagicNumber;
        this.upgradedMagicNumber = true;
    }

    //region apply
    public void upgradeAVulnerableValue(int amount)
    { // If we're upgrading (read: changing) the number. Note "upgrade" and NOT "upgraded" - 2 different things. One is a boolean, and then this one is what you will usually use - change the integer by how much you want to upgrade.
        aBaseVulnerableValue = amount; // Upgrade the number by the amount you provide in your card.
        aVulnerableValue = aBaseVulnerableValue; // Set the number to be equal to the base value.
        aUpgradedVulnerableValue = true; // Upgraded = true - which does what the above method does.
    }

    public void upgradeAValues(int amount, int baseValue, int value, boolean upgradeBool)
    {
        baseValue=amount;
        value=baseValue;
        upgradeBool=true;
    }

    public void upgradeAWeakValue(int amount)
    {
        aBaseWeakValue = amount;
        aWeakValue = aBaseWeakValue;
        aUpgradedWeakValue = true;
    }

    public void upgradeAPoisonValue(int amount)
    {
        aBasePoisonValue = amount;
        aPoisonValue = aBasePoisonValue;
        aUpgradedPoisonValue = true;
    }

    public void upgradeAStrValue(int amount)
    {
        aBaseStrValue = amount;
        aStrValue = aBaseStrValue;
        aUpgradedStrValue = true;
    }
    //endregion

    //region Gain

    public void upgradeGVulnerableValue(int amount)
    {
        gBaseVulnerableValue = amount;
        gVulnerableValue = gBaseVulnerableValue;
        gUpgradedVulnerableValue = true;
    }

    public void upgradeGWeakValue(int amount)
    {
        gBaseWeakValue = amount;
        gWeakValue = gBaseWeakValue;
        gUpgradedWeakValue = true;
    }

    public void upgradeGPoisonValue(int amount)
    {
        gBasePoisonValue = amount;
        gPoisonValue = gBasePoisonValue;
        gUpgradedPoisonValue = true;
    }

    public void upgradeGStrValue(int amount)
    {
        gBaseStrValue = amount;
        gStrValue = gBaseStrValue;
        gUpgradedStrValue = true;
    }
    //endregion
}
