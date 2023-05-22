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
public class PoisonNeedles extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(PoisonNeedles.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.RARE; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 2;  
    private static final int UPGRADED_COST = 3; 

    private static final int DAMAGE = 1;
    private static final int UPGRADE_DAMAGE= 3;
    private int repeatTIME = 5;
    private final int UPGRADE_repeatTIME = 6;
    private static final int aPOISON = 1;
    private static final int UPGRADE_aPOISON = 3;

    // /STAT DECLARATION/

    private static String desc ="Deal !D! Damage and apply 1 Poison  NL (5 times)";
    private static final String upDesc="Deal !D! Damage and apply 3 Poison  NL (6 times)";
    public PoisonNeedles ()
    { 
        super(ID, "Poison Needles", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        aPoisonValue = aBasePoisonValue= aPOISON;

                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for (int i = 0; i < repeatTIME; i++) {
        this.addToBot(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));
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
            repeatTIME = UPGRADE_repeatTIME;
            this.upgradeAPoisonValue(UPGRADE_aPOISON);
            upgradeBaseCost(UPGRADED_COST);
            rawDescription=upDesc;
            initializeDescription();
        }
    }
}