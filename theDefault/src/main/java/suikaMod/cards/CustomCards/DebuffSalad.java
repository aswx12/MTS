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
public class DebuffSalad extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(DebuffSalad.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.RARE; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.SKILL;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 2;  
    private static final int UPGRADED_COST = 4; 

    private  int aVULNERABLE = 2;
    private final int UPGRADE_aVULNERABLE = 5;
    private static final int aWEAK = 2;
    private static final int UPGRADE_aWEAK = 5;
    private static final int aPOISON = 2;
    private static final int UPGRADE_aPOISON = 5;

    // /STAT DECLARATION/

    private static String desc ="Apply 2 Vulnerable, 2 Weak, 2 Poison NL Exhaust NL (Having salad in its name doesn't mean it's healthy)";
    private static final String upDesc="Apply 5 Vulnerable, 5 Weak, 5 Poison NL Double Vulnerable, Weak, Poison NL Exhaust NL (Salad To Heaven)";
    public DebuffSalad ()
    { 
        super(ID, "Debuff Salad", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        aVulnerableValue = aBaseVulnerableValue = aVULNERABLE;
        aWeakValue = aBaseWeakValue= aWEAK;
        aPoisonValue = aBasePoisonValue= aPOISON;

            this.exhaust=true; 
                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
         this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, aVULNERABLE, false), aVULNERABLE));
         this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));
         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));
        if(this.upgraded){
         this.addToBot(new DoubleVulnerableAction(m,p));
         this.addToBot(new DoubleWeakAction(m,p));
         this.addToBot(new DoublePoisonAction(m,p));
        }
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            aVULNERABLE=upgradeAVulnerableValue(UPGRADE_aVULNERABLE);
            this.upgradeAWeakValue(UPGRADE_aWEAK);
            this.upgradeAPoisonValue(UPGRADE_aPOISON);
            upgradeBaseCost(UPGRADED_COST);
            rawDescription=upDesc;
            initializeDescription();
        }
    }
}