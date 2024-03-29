import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class Awards
{
    private List<Player> myTeam;

    private Player MVP;
    private Player offensivePlayer;
    private Player defensivePlayer;
    private Player mostEffective;

    public Awards(List<Player> temp)
    {
        myTeam = new ArrayList<Player>();
        for(Player p : temp)
            myTeam.add(p);

        MVP = null;
        offensivePlayer = null;
        defensivePlayer = null;
        mostEffective = null;
    }

    /*   
     *   This methods determines and returns the Player selected as MVP
     */
    public Player getMVP()
    {
        MVP = new Player("MVP", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        for(int x = 0; x < myTeam.size(); x++)
        {
            if(MVP.getMVPrating() == myTeam.get(x).getMVPrating()) 
            {
                if(MVP.getSalary() > myTeam.get(x).getSalary()) MVP = myTeam.get(x);
            }
            else if (MVP.getMVPrating() < myTeam.get(x).getMVPrating())
            {
                MVP = myTeam.get(x);
            }
        }
        return MVP;
    }

    /*   
     *   This methods determines and returns the Player selected as Offensive Player
     *   
     *   remember, the Player winning MVP SHALL be selected for this award
     */
    public Player getOffensivePlayer()
    {
        offensivePlayer = new Player("Offensive", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Player m = getMVP();
        for(int x = 0; x < myTeam.size(); x++)
        {
            if(!myTeam.get(x).equals(m))
            {
                if(offensivePlayer.getPointsScored() == myTeam.get(x).getPointsScored()) 
                {
                    if(offensivePlayer.getAssistToTurnoverMargin() < myTeam.get(x).getAssistToTurnoverMargin()) offensivePlayer = myTeam.get(x);
                }
                else if (offensivePlayer.getPointsScored() < myTeam.get(x).getPointsScored())
                {
                    offensivePlayer = myTeam.get(x);
                }
            }
        }
        return offensivePlayer;
    }

    /*   
     *   This methods determines and returns the Player selected as Defensive Player
     *   
     *   remember, the Player winning MVP or Offensive Player SHALL be selected for this award
     */
    public Player getDefensivePlayer()
    {
        defensivePlayer = new Player("Defensive", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Player m = getMVP();
        Player o = getOffensivePlayer();
        for(int x = 0; x < myTeam.size(); x++)
        {
            if(!myTeam.get(x).equals(m) && !myTeam.get(x).equals(o))
            {
                if(defensivePlayer.getSteals() == myTeam.get(x).getSteals()) 
                {
                    if(defensivePlayer.getFouls() > myTeam.get(x).getFouls()) defensivePlayer = myTeam.get(x);
                }
                else if (defensivePlayer.getSteals() < myTeam.get(x).getSteals())
                {
                    defensivePlayer = myTeam.get(x);
                }
            }
        }
        return defensivePlayer;
    }

    /*   
     *   This methods determines and returns the Player selected as Most Effective Player
     *   
     *   remember, the Player winning MVP, Offensive Player or Defensive Player SHALL be selected for this award
     */
    public Player getMostEffective()
    {
        mostEffective = new Player("Most Effective", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Player m = getMVP();
        Player o = getOffensivePlayer();
        Player d = getDefensivePlayer();
        for(int x = 0; x < myTeam.size(); x++)
        {
            if(!myTeam.get(x).equals(m) && !myTeam.get(x).equals(o) && !myTeam.get(x).equals(d))
            {
                if(mostEffective.getValueRatio() == myTeam.get(x).getValueRatio()) 
                {
                    if(mostEffective.getFreeThrowMade() < myTeam.get(x).getFreeThrowMade()) mostEffective = myTeam.get(x);
                }
                else if (mostEffective.getValueRatio() < myTeam.get(x).getValueRatio())
                {
                    mostEffective = myTeam.get(x);
                }
            }
        }
        return mostEffective;
    }
}