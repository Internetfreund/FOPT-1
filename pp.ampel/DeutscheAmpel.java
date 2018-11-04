package pp.ampel;

public class DeutscheAmpel implements Ampel
{
    private boolean gruen;
    private int naechsterAnkommender;
    private int naechsterFahrender;
    
    public int getNaechsterAnkommender()
    {
        return naechsterAnkommender;
    }
    
    public int getNaechsterFahrender()
    {
        return naechsterFahrender;
    }

    public DeutscheAmpel()
    {
        this.gruen = true;
        this.naechsterAnkommender = 0;
        this.naechsterFahrender = 0;
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
        int meineNummer = naechsterAnkommender++;
        while (!gruen || meineNummer != getNaechsterFahrender())
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        naechsterFahrender++;
        notifyAll();
    }

    public synchronized int wartendeFahrzeuge()
    {
        int wartendeAutos = getNaechsterAnkommender() - getNaechsterFahrender();
        return wartendeAutos;
    }
}
