package myMod;

import basemod.BaseMod;
import basemod.DevConsole;
import basemod.devcommands.ConsoleCommand;
import basemod.devcommands.hand.Hand;
import basemod.helpers.ConvertHelper;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandTest extends ConsoleCommand
{
    public CommandTest()
    {
        this.requiresPlayer = true;

        this.minExtraTokens = 1;
        this.maxExtraTokens = 2;


    }

    public void execute(String[] tokens, int depth)
    {
        try
        {
            String cardName = tokens[1];
            boolean all = tokens[1].equals("all");
            int v = Integer.parseInt(tokens[2]);
            Iterator var6 = (new ArrayList(AbstractDungeon.player.hand.group)).iterator();

            do
            {
                AbstractCard c;
                do
                {
                    if (!var6.hasNext())
                    {
                        return;
                    }

                    c = (AbstractCard) var6.next();
                } while (!all && !c.cardID.equals(cardName));
                if (c.type == AbstractCard.CardType.ATTACK)
                {
                    if (c.baseDamage != v)
                    {
                        c.upgradedDamage = true;
                    }

                    c.baseDamage = v;
                }
                c.displayUpgrades();
                c.applyPowers();
            } while (all);
        } catch (NumberFormatException var8)
        {
            Hand.cmdHandHelp();
        }
    }

    public String getCardID(String[] tokens)
    {
        return this.getCardID(tokens, this.countIndex(tokens));
    }


    public String getCardID(String[] tokens, int countIndex)
    {
        String[] cardNameArray = (String[]) Arrays.copyOfRange(tokens, 1, countIndex + 1);
        String cardName = String.join(" ", cardNameArray);
        if (BaseMod.underScoreCardIDs.containsKey(cardName))
        {
            cardName = (String) BaseMod.underScoreCardIDs.get(cardName);
        }

        return cardName;
    }

    protected int countIndex(String[] tokens)
    {
        int countIndex;
        for (countIndex = tokens.length - 1; ConvertHelper.tryParseInt(tokens[countIndex]) != null; --countIndex)
        {
        }

        return countIndex;
    }

    public ArrayList<String> extraOptions(String[] tokens, int depth)
    {
        ArrayList<String> options = ConsoleCommand.getCardOptions();
        if (options.contains(tokens[depth]))
        {
            if (tokens.length > depth + 1 && tokens[depth + 1].matches("\\d*"))
            {
                if (tokens.length > depth + 2)
                {
                    if (tokens[depth + 1].matches("\\d+"))
                    {
                        ConsoleCommand.complete = true;
                    } else if (tokens[depth + 2].length() > 0)
                    {
                        tooManyTokensError();
                    }
                }

                return ConsoleCommand.smallNumbers();
            }

            if (tokens.length > depth + 1)
            {
                tooManyTokensError();
            }
        } else if (tokens.length > depth + 1)
        {
            tooManyTokensError();
        }

        return options;
    }

}

