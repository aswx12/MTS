package myMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.ChemicalX;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import myMod.powers.CommonPower;

public class UncommonPowerAction extends AbstractGameAction {
    private boolean freeToPlayOnce;
    private final int magicNumber;
    private final AbstractPlayer p;
    private final int energyOnUse;
    private final boolean upgraded;
    
    public UncommonPowerAction(final AbstractPlayer p, final AbstractMonster m,
                               final int magicNumber, final boolean upgraded,
                               final DamageInfo.DamageType damageTypeForTurn, final boolean freeToPlayOnce,
                               final int energyOnUse) {
        this.freeToPlayOnce = false;
        this.p = p;
        this.magicNumber = magicNumber;
        this.freeToPlayOnce = freeToPlayOnce;
        actionType = ActionType.SPECIAL;
        this.energyOnUse = energyOnUse;
        this.upgraded = upgraded;
    }
    
    @Override
    public void update() {
        int effect = EnergyPanel.totalCount;
        if (energyOnUse != -1) {
            effect = energyOnUse;
        }
        if (p.hasRelic(ChemicalX.ID)) {
            effect += 2;
            p.getRelic(ChemicalX.ID).flash();
        }
        if (upgraded) {
            ++effect;
        }
        if (effect > 0) {
            for (int i = 0; i < effect; ++i) {
                
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                        new CommonPower(p, p, magicNumber), magicNumber,
                        AttackEffect.BLUNT_LIGHT));
            }
            if (!freeToPlayOnce) {
                p.energy.use(EnergyPanel.totalCount);
            }
        }
        isDone = true;
    }
}
