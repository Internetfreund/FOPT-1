package pp.ampel;

public class Auto extends Thread
{
    private Ampel[] ampeln;

    public Ampel[] getAmpel()
    {
        return ampeln;
    }

    public Auto(Ampel[] a)
    {
        this.ampeln = a.clone();
        // int i = ampeln.length;
        // this.ampeln = new Ampel[i];
        // this.ampeln = ampeln;
    }

    public void run()
    {
        for (int i = 0; i < ampeln.length; i++)
        {
            ampeln[i].passieren();
            if (i == i - 1)
            {
                i = 0;
            }
        }
    }

}
