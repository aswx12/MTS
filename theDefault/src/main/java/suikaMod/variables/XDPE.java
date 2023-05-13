package suikaMod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import suikaMod.cards.AbstractDefaultCard;

import static suikaMod.DefaultMod.makeID;

public class XDPE extends DynamicVariable
{

    //For in-depth comments, check the other variable(DefaultCustomVariable). It's nearly identical.

    @Override
    public String key()
    {
        return makeID("XDPE");
        // This is what you put between "!!" in your card strings to actually display the number.
        // You can name this anything (no spaces), but please pre-phase it with your mod name as otherwise mod conflicts can occur.
        // Remember, we're using makeID so it automatically puts "theDefault:" (or, your id) before the name.
    }

    @Override
    public boolean isModified(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).isDPEModified;

    }
    @Override
    public int value(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).dmgPerEnergy * EnergyPanel.getCurrentEnergy();
    }
    public void setIsModified(AbstractCard card, boolean v) {
        ((AbstractDefaultCard) card).isDPEModified = v;
    }
    @Override
    public int baseValue(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).baseDmgPerEnergy;
    }

    @Override
    public boolean upgraded(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).upgradedDPE;
    }
}