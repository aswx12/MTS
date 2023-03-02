package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.unique.*;
import com.megacrit.cardcrawl.actions.defect.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import suikaMod.DefaultMod;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Iterator;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class all3 extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(all3.class.getSimpleName());
    public static final String IMG = makeCardPath("Attack.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = -1;
    private static final int UPGRADED_COST = -1;

    private static final int DAMAGE = 1;
    private static final int UPGRADE_DAMAGE = 2;
    private static final int dmgPerEnergyValue = 2;
    private static final int UPGRADE_dmgPerEnergyValue = 3;
    private static final int vampDmgValue = 3;
    private static final int UPGRADE_vampDmgValue = 4;

    // /STAT DECLARATION/

    public all3()
    {
        super(ID, "all3", IMG, "!D! & !suikaMod:DPE! & !suikaMod:Vamp!", COST, TYPE, COLOR, RARITY, TARGET);

        this.baseDamage = DAMAGE;
        dmgPerEnergy = this.baseDmgPerEnergy = dmgPerEnergyValue;
        vampDmg = this.baseVampDmg = vampDmgValue;

        isMultiDamage = true;
        //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(
                new DamageAllEnemiesAction(p, multiDamage, this.damageTypeForTurn, AttackEffect.SLASH_HORIZONTAL));
        this.addToBot(
                new WhirlwindAction(p, this.multiDPE, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
        this.addToBot(
                new VampireDamageAllEnemiesAction(p, this.multiVampDmg, this.damageTypeForTurn, AttackEffect.NONE));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(UPGRADE_DAMAGE);
            upgradeDPE(UPGRADE_dmgPerEnergyValue);
            upgradeVampDmg(UPGRADE_vampDmgValue);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}