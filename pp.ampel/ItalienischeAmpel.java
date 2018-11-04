package pp.ampel;

public class ItalienischeAmpel implements Ampel
{
    private boolean gruen;
    private int naechsterAnkommender;

    public ItalienischeAmpel()
    {
        gruen = true;
        naechsterAnkommender = 0;
    }

    public synchronized void schalteRot()
    {
        gruen = false;
    }

    public synchronized void schalteGruen()
    {
        gruen = true;
        notifyAll();
    }

    public synchronized void passieren()
    {
        naechsterAnkommender++;
        while (!gruen)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        naechsterAnkommender = 0;
    }

    public synchronized int wartendeFahrzeuge()
    {
        return naechsterAnkommender;
    }

}
