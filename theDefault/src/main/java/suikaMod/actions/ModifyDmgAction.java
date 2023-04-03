package suikaMod.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import suikaMod.cards.AbstractDefaultCard;

import java.util.Iterator;
import java.util.UUID;

public class ModifyDmgAction extends AbstractGameAction {
    private UUID uuid;

    public ModifyDmgAction(UUID targetUUID, int amount) {
        this.setValues(this.target, this.source, amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.uuid = targetUUID;
    }

    public void update() {
        Iterator var1 = GetAllInBattleInstances.get(this.uuid).iterator();

        while(var1.hasNext()) {
            AbstractDefaultCard c = (AbstractDefaultCard)var1.next();
            c.baseDamage += this.amount;
            c.baseDmgPerEnergy +=this.amount;
            c.baseVampDmg +=this.amount;
            c.baseDPSH +=this.amount;
            c.baseDPAP+=this.amount;
            c.baseDmgPsnCondition+=this.amount;

            if (c.baseDamage < 0) {
                c.baseDamage = 0;
            }
            if (c.baseDmgPerEnergy < 0) {
                c.baseDmgPerEnergy = 0;
            }
            if (c.baseVampDmg < 0) {
                c.baseVampDmg = 0;
            }
            if (c.baseDPSH < 0) {
                c.baseDPSH = 0;
            }
            if (c.baseDPAP < 0) {
                c.baseDPAP = 0;
            }
            if (c.baseDmgPsnCondition < 0) {
                c.baseDmgPsnCondition = 0;
            }

        }

        this.isDone = true;
    }
}
