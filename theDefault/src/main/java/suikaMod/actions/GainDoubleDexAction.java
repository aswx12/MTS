package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class GainDoubleDexAction extends AbstractGameAction
{
    private AbstractPlayer p;

    public GainDoubleDexAction() {
        this.actionType = ActionType.WAIT;
        this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_XFAST && this.p.hasPower("Dexterity")) {
            int Amt = this.p.getPower("Dexterity").amount;
            this.addToTop(new ApplyPowerAction(this.p, this.p, new DexterityPower(this.p, Amt), Amt));
        }

        this.tickDuration();
    }
}
