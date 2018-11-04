package pp.ampel;

public class AmpelSteuerung extends Thread
{
    private Ampel[] ampeln;

    public Ampel[] getAmpel()
    {
        return this.ampeln;
    }

    public AmpelSteuerung(Ampel ampeln[])
    {
        int i = ampeln.length;
        this.ampeln = new Ampel[i];
        this.ampeln = ampeln;
    }

    public void run()
    {
        for (int i = 0; i < ampeln.length; i++)
        {
            ampeln[i].schalteGruen();
            try
            {
                sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
            ampeln[i].schalteRot();
            try
            {
                sleep(10000);
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
