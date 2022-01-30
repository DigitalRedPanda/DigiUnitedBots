package TwitchBot;

public class Scan {
    boolean Find(String ToFind, String Context){
        String[] SplittedContext = Context.split(" ");
        char[] CharactersWithinContext;
        for(String NavigateContext: SplittedContext){
            if(NavigateContext.equalsIgnoreCase("SI")){
                CharactersWithinContext = NavigateContext.toCharArray();
                for(char FindCharacters: CharactersWithinContext){
                    boolean FindFirstHalf = FindCharacters != 'S' || FindCharacters != 's';
                    boolean FindSecondHalf = FindCharacters != 'I' || FindCharacters != 'i';
                    if(FindFirstHalf && FindSecondHalf)
                        return false;
                }}}
        return true;
    }
}
