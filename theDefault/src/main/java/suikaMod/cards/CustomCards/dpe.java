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
public class dpe extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(dpe.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = -1;  
    private static final int UPGRADED_COST = -1; 

    private static final int dmgPerEnergyValue = 2;
    private static final int UPGRADE_dmgPerEnergyValue= 3;


    // /STAT DECLARATION/

    public dpe ()
    { 
        super(ID, "dpe", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);

        baseDmgPerEnergy = dmgPerEnergyValue;
        baseDmgPerEnergy = dmgPerEnergyValue;

       isMultiDamage = true;
        //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
         this.addToBot(
                new WhirlwindAction(p, this.multiDPE, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDPE(UPGRADE_dmgPerEnergyValue);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}