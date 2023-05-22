package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.unique.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import suikaMod.DefaultMod;
import suikaMod.actions.*;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;


@AutoAdd.Ignore
public class ActionTestFile extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(ActionTestFile.class.getSimpleName());
    public static final String IMG = makeCardPath("Attack.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int UPGRADED_COST = 1;

    static final int DMG = 1;

    private static String DESC = "!D!";
    private static final String upDesc = "upTest";


    // /STAT DECLARATION/

    public ActionTestFile()
    {
        super(ID, "ActionTestFile", IMG, DESC, COST, TYPE, COLOR, RARITY, TARGET);

        baseDamage = DMG;
        isMultiDamage = true;
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTags.STRIKE);


    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new DoubleVulnerableAction(p,p));
        this.addToBot(new DoubleWeakAction(p,p));
        this.addToBot(new DoublePoisonAction(p,p));
        this.addToBot(new DoubleStrAction(p,p));

        this.addToBot(new DoubleVulnerableAction(m,p));
        this.addToBot(new DoubleWeakAction(m,p));
        this.addToBot(new DoublePoisonAction(m,p));
        this.addToBot(new DoubleStrAction(m,p));

    }

    public void triggerOnManualDiscard()
    {

    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeBaseCost(UPGRADED_COST);
            rawDescription = upDesc; //dis is da wae
            initializeDescription();
        }

    }

}