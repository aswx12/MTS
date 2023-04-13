package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.powers.StrengthPower;


public class DoubleStrAction extends AbstractGameAction
{
    //private AbstractPlayer p;

    public DoubleStrAction(AbstractCreature target, AbstractCreature source) {
        this.actionType = ActionType.WAIT;
        //this.p = AbstractDungeon.player;
        this.target = target;
        this.source = source;
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_XFAST && this.target.hasPower("Strength") && this.target != null) {
            int strAmt = this.target.getPower("Strength").amount;
            this.addToTop(new ApplyPowerAction(this.target, this.source, new StrengthPower(this.target, strAmt), strAmt));
        }
        this.tickDuration();
    }
}