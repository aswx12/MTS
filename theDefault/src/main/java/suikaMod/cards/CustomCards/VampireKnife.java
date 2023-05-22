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
public class VampireKnife extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(VampireKnife.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.COMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 0;  
    private static final int UPGRADED_COST = 0; 

    private static final int vampDmgValue = 3;
    private static final int UPGRADE_vampDmgValue= 5;
    private static final int ENERGY = 2;
    private static final int UPGRADE_ENERGY = 3;

    // /STAT DECLARATION/

    private static String desc ="Deal !suikaMod:DVAMP! Damage and Heal !suikaMod:DVAMP! HP NL Gain !M! Energy NL Ethereal";
    private static final String upDesc="Deal !suikaMod:DVAMP! Damage and Heal !suikaMod:DVAMP! HP NL Gain !M! Energy NL Exhaust";
    public VampireKnife ()
    { 
        super(ID, "VampireKnife", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseVampDmg = vampDmgValue;
        magicNumber = baseMagicNumber = ENERGY;

            this.isEthereal=true; 
                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(
                new VampireDamageAction(m, new DamageInfo(p, vampDmg, damageTypeForTurn), AttackEffect.NONE));
         this.addToBot(new GainEnergyAction(magicNumber));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeVampDmg(UPGRADE_vampDmgValue);
            this.upgradeMagicNumber(UPGRADE_ENERGY);
            upgradeBaseCost(UPGRADED_COST);
            rawDescription=upDesc;
            this.isEthereal=false; 
            initializeDescription();
        }
    }
}