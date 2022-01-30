package TwitchBot;



public class Scan {
    static boolean Find(String ToFind, String Context){
        String[] SplittedContext = Context.split(" ");
        char[] CharactersWithinContext;
        for(String NavigateContext: SplittedContext){
            if(NavigateContext.toLowerCase().contains(ToFind)){
                CharactersWithinContext = NavigateContext.toLowerCase().toCharArray();
                for(char FindCharacters: CharactersWithinContext){
                    if(FindCharacters != 's' || FindCharacters != 'i')
                        return false;
                }}}
    return true;
    }
}
