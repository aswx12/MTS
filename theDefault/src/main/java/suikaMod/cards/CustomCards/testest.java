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
import suikaMod.actions.*;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Iterator;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Ignore
public class testest extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(testest.class.getSimpleName());
    public static final String IMG = makeCardPath("Attack.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int UPGRADED_COST = 1;

    private static final int DAMAGE = 4;
    private static final int UPGRADE_DAMAGE = 5;
    private int dmgModifyValue = 6;
    private final int UPGRADE_dmgModifyValue = 7;
    private static final int ENERGY = 0;
    private static final int UPGRADE_ENERGY = 4;
    private static final int aVULNERABLE = 0;
    private static final int UPGRADE_aVULNERABLE = 3;
    private static final int aWEAK = 0;
    private static final int UPGRADE_aWEAK = 4;

    // /STAT DECLARATION/

    private static String desc = "Deal !D! dmg NL Increases dmg by 6";
    private static final String upDesc = "Deal !D! dmg NL Increases dmg by 7 NL Gain !M! [E] , apply !suikaMod:aVul! vul, apply 4 weak";

    public testest()
    {
        super(ID, "testest", IMG, desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = ENERGY;
        aVulnerableValue = aBaseVulnerableValue = aVULNERABLE;
        aWeakValue = aBaseWeakValue = aWEAK;

        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
        this.addToBot(new ModifyDmgAction(this.uuid, dmgModifyValue));
        if (this.upgraded)
        {
            this.addToBot(new GainEnergyAction(magicNumber));
            this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.aVulnerableValue, false), this.aVulnerableValue));
            this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));
        }
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(UPGRADE_DAMAGE);
            dmgModifyValue = UPGRADE_dmgModifyValue;
            this.upgradeMagicNumber(UPGRADE_ENERGY);
            this.upgradeAVulnerableValue(UPGRADE_aVULNERABLE);
            this.upgradeAWeakValue(UPGRADE_aWEAK);
            upgradeBaseCost(UPGRADED_COST);
            rawDescription = upDesc;
            initializeDescription();
        }
    }
}