public class TempsExecution {
    // Renvoi le temps au format h min s ms
    public static String getTime(long ms){
        long diff = ms%1000;
        ms=ms/1000;
        String ret = diff+"ms";
        diff=ms%60;
        ms=ms/60;
        if (diff>0)
            ret = diff+"s "+ret;
        diff=ms%60;
        ms=ms/60;
        if (diff>0)
            ret = diff+"min "+ret;
        diff=ms;
        if (diff>0)
            ret = diff+"h "+ret;
        return ret;
    }
}
