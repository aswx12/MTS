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
public class b extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(b.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private int hADD_AMOUNT_RANDOM_ATTACK = 2;
    private final int UPGRADE_hAMOUNT_RANDOM_ATTACK = 3;
    private int hADD_AMOUNT_RANDOM_SKILL = 2;
    private final int UPGRADE_hAMOUNT_RANDOM_SKILL = 3;
    private int hADD_AMOUNT_RANDOM_COLORLESS = 2;
    private final int UPGRADE_hAMOUNT_RANDOM_COLORLESS = 3;
    private int dADD_AMOUNT_RANDOM_COLORLESS = 2;
    private final int UPGRADE_dAMOUNT_RANDOM_COLORLESS = 3;

    // /STAT DECLARATION/

    public b ()
    { 
        super(ID, "b", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);
        
                //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
                 AddRandomCardHand(hADD_AMOUNT_RANDOM_ATTACK,CardType.ATTACK);
         AddRandomCardHand(hADD_AMOUNT_RANDOM_SKILL,CardType.SKILL);
         AddRandomColorless(hADD_AMOUNT_RANDOM_COLORLESS,"Hand");
         AddRandomColorless(dADD_AMOUNT_RANDOM_COLORLESS,"Discard");
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) { //unplayable
        return false;
    }
    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
                        hADD_AMOUNT_RANDOM_ATTACK=UPGRADE_hAMOUNT_RANDOM_ATTACK;
            hADD_AMOUNT_RANDOM_SKILL=UPGRADE_hAMOUNT_RANDOM_SKILL;
            hADD_AMOUNT_RANDOM_COLORLESS=UPGRADE_hAMOUNT_RANDOM_COLORLESS;
            dADD_AMOUNT_RANDOM_COLORLESS=UPGRADE_dAMOUNT_RANDOM_COLORLESS;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}