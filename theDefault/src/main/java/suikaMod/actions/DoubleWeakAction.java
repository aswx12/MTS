package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.powers.WeakPower;

public class DoubleWeakAction extends AbstractGameAction
{
    //private AbstractPlayer p;

    public DoubleWeakAction(AbstractCreature target, AbstractCreature source) {
        this.actionType = ActionType.WAIT;
        this.target = target;
        this.source = source;
        //this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_XFAST && this.target.hasPower("Weakened") && this.target != null) {
            int Amt = this.target.getPower("Weakened").amount;
            this.addToTop(new ApplyPowerAction(this.target, this.source, new WeakPower(this.target, Amt,false), Amt));
        }

        this.tickDuration();
    }
}
