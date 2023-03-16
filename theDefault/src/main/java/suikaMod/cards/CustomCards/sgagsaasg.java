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


@AutoAdd.Seen
public class sgagsaasg extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(sgagsaasg.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private int rColorlessCopyV0HandQty = 1;
    private final int UPGRADE_rColorlessCopyV0HandQty = 1;
    private int rColorlessCopyV1HandQty = 1;
    private final int UPGRADE_rColorlessCopyV1HandQty = 1;
    private int rColorlessCopyV2DiscQty = 1;
    private final int UPGRADE_rColorlessCopyV2DiscQty = 1;
    private int rColorlessCopyV3DrawPQty = 1;
    private final int UPGRADE_rColorlessCopyV3DrawPQty = 1;
    private int rColorlessCopyV4BotDrawPQty = 1;
    private final int UPGRADE_rColorlessCopyV4BotDrawPQty = 1;
    private int rColorlessCopyV5TopDrawPQty = 1;
    private final int UPGRADE_rColorlessCopyV5TopDrawPQty = 1;
    private int rColorlessCopyV6HandQty = 1;
    private final int UPGRADE_rColorlessCopyV6HandQty = 1;
    private int rColorlessCopyV7HandQty = 1;
    private final int UPGRADE_rColorlessCopyV7HandQty = 1;

    // /STAT DECLARATION/

    private static String desc ="a";
    public sgagsaasg ()
    { 
        super(ID, "sgagsaasg", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);

                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
         AddRandomColorlessCopy(rColorlessCopyV0HandQty,"Hand");
         AddRandomColorlessCopy(rColorlessCopyV1HandQty,"Hand");
         AddRandomColorlessCopy(rColorlessCopyV2DiscQty,"Discard");
         AddRandomColorlessCopy(rColorlessCopyV3DrawPQty,"DrawPile");
         AddRandomColorlessCopy(rColorlessCopyV4BotDrawPQty,"BotDrawPile");
         AddRandomColorlessCopy(rColorlessCopyV5TopDrawPQty,"TopDrawPile");
         AddRandomColorlessCopy(rColorlessCopyV6HandQty,"Hand");
         AddRandomColorlessCopy(rColorlessCopyV7HandQty,"Hand");
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            rColorlessCopyV0HandQty=UPGRADE_rColorlessCopyV0HandQty;
            rColorlessCopyV1HandQty=UPGRADE_rColorlessCopyV1HandQty;
            rColorlessCopyV2DiscQty=UPGRADE_rColorlessCopyV2DiscQty;
            rColorlessCopyV3DrawPQty=UPGRADE_rColorlessCopyV3DrawPQty;
            rColorlessCopyV4BotDrawPQty=UPGRADE_rColorlessCopyV4BotDrawPQty;
            rColorlessCopyV5TopDrawPQty=UPGRADE_rColorlessCopyV5TopDrawPQty;
            rColorlessCopyV6HandQty=UPGRADE_rColorlessCopyV6HandQty;
            rColorlessCopyV7HandQty=UPGRADE_rColorlessCopyV7HandQty;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}