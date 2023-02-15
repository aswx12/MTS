package suikaMod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import suikaMod.cards.AbstractDefaultCard;

import static suikaMod.DefaultMod.makeID;

public class DefaultSecondMagicNumber extends DynamicVariable {

    //For in-depth comments, check the other variable(DefaultCustomVariable). It's nearly identical.

    @Override
    public String key() {
        return makeID("SecondMagic");
        // This is what you put between "!!" in your card strings to actually display the number.
        // You can name this anything (no spaces), but please pre-phase it with your mod name as otherwise mod conflicts can occur.
        // Remember, we're using makeID so it automatically puts "theDefault:" (or, your id) before the name.
    }

    @Override
    public boolean isModified(AbstractCard card) {
        return ((AbstractDefaultCard) card).aIsVulnerableValueModified;

    }

    @Override
    public int value(AbstractCard card) {
        return ((AbstractDefaultCard) card).aVulnerableValue;
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((AbstractDefaultCard) card).aBaseVulnerableValue;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((AbstractDefaultCard) card).aUpgradedVulnerableValue;
    }
}