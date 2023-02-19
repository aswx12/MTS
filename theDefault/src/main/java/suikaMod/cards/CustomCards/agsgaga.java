package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.unique.*;
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

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class agsgaga extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(agsgaga.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private int hADD_AMOUNT_RANDOM_COLORLESS = 1;
    private final int UPGRADE_hAMOUNT_RANDOM_COLORLESS = 2;
    private int dADD_AMOUNT_RANDOM_COLORLESS = 1;
    private final int UPGRADE_dAMOUNT_RANDOM_COLORLESS = 2;

    // /STAT DECLARATION/

    public agsgaga ()
    { 
        super(ID, "agsgaga", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);
        
                //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
                 AddRandomColorless(hADD_AMOUNT_RANDOM_COLORLESS,"Hand");
         AddRandomColorless(dADD_AMOUNT_RANDOM_COLORLESS,"Discard");
    }

    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
                        hADD_AMOUNT_RANDOM_COLORLESS=UPGRADE_hAMOUNT_RANDOM_COLORLESS;
            dADD_AMOUNT_RANDOM_COLORLESS=UPGRADE_dAMOUNT_RANDOM_COLORLESS;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}