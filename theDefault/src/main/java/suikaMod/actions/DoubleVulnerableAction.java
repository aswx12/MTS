package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class DoubleVulnerableAction extends AbstractGameAction
{
    //private AbstractPlayer p;

    public DoubleVulnerableAction(AbstractCreature target, AbstractCreature source) {
        this.actionType = ActionType.WAIT;
        this.target = target;
        this.source = source;
        //this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_XFAST && this.target.hasPower("Vulnerable") && this.target != null) {
            int Amt = this.target.getPower("Vulnerable").amount;
            this.addToTop(new ApplyPowerAction(this.target, this.source, new VulnerablePower(this.target, Amt,false), Amt));
        }

        this.tickDuration();
    }
}