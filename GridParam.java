public class GridParam 
{
    //all my match grids

    private String[][] easyGrid1 = {
        {"Cat", "Fish", "Cat"},
        {"Dog", "Dog", "Fish"}
    };
    private String[][] easyGrid2 = {
        {"Apple", "Peach", "Pear"},
        {"Peach", "Pear", "Apple"}
    };
    private String[][] easyGrid3 = {
       {"Personal Computer", "Personal Computer", "Laptop"},
       {"Smart Phone", "Smart Phone", "Laptop"}
    };
 
    private String[][] mediumGrid1 = {
       {"Ford", "Cadillac", "Tesla", "Toyota"},
       {"BMW", "Tesla", "Ford", "Cadillac"},
       {"BMW", "Jeep", "Toyota", "Jeep"}
    };
    private String[][] mediumGrid2 = {
        {"Santa", "Elf", "Ornaments", "Presents"},
        {"Rudloph", "Santa", "Rudolph", "Christmas Tree"},
        {"Presents", "Christmas Tree", "Elf", "Ornaments"}
    };
    private String[][] mediumGrid3 = {
        {"Vanilla", "Neapolitan", "Caramel", "Strawberry"},
        {"Strawberry", "Chocolate", "Chocolate", "Vanilla"},
        {"Neapolitan", "Mint", "Mint", "Caramel"}
    };

    private String[][] hardGrid1 = {
        {"Homophones", "Homologous", "Homologous", "Homeostasis", "Homogenous"},
        {"Homographs", "Homonyms", "Homogenous", "Homogeneity", "Homozygous"},
        {"Homosapiens", "Homonyms", "Homographs", "Homogenize", "Homogeneity"},
        {"Homophones", "Homosapiens", "Homozygous", "Homogenize", "Homeostasis"}
    };
    private String[][] hardGrid2 = {
        {"Heliophobia", "Autophobia", "Barophobia", "Microphobia", "Megalophobia"},
        {"Ataxophobia", "Claustrophobia", "Heliophobia", "Microphobia", "Megalophobia"},
        {"Bibliophobia", "Achluophobia", "Bibliophobia", "Dystychiphobia", "Dystychiphobia"},
        {"Autophobia", "Ataxophobia", "Barophobia", "Achluophobia", "Claustrophobia"}
    };
    private String[][] hardGrid3 = {
        {"Accio", "Accio", "Wingardium Leviosa", "Lumos", "Expelliarmus"},
        {"Protego", "Expecto Patronum", "Incendio", "Expecto Patronum", "Impervius"},
        {"Confundo", "Incendio", "Evanesco", "Impervius", "Evanesco"},
        {"Expelliarmus", "Lumos", "Confundo", "Protego", "Wingardium Leviosa"}
    };
    // private variables
    private int row;
    private int column;
    private String response;
    private int diff;
    private int set;
    //sets the match grid to its difficulty and set
    public GridParam(int x, int y, int difficulty, int matchSet)
    {
        x--;
        y--;
        row = x;
        column = y;
        diff = difficulty;
        set = matchSet;
        
        
    }
    //finds the word in these grids
    public String gridWord()
    {
        if (diff == 1) {
            if (set==1)
            {
                response = easyGrid1[row][column];
                return response;
            } else if (set==2)
            {
                response = easyGrid2[row][column];
                return response;
            } else {
                response = easyGrid3[row][column];
                return response;
            }
        } else if (diff==2) {
            if (set==1)
            {
                response = mediumGrid1[row][column];
                return response;
            } else if (set==2)
            {
                response = mediumGrid2[row][column];
                return response;
            } else {
                response = mediumGrid3[row][column];
                return response;
            }
        } else {
            if (set==1)
            {
                response = hardGrid1[row][column];
                return response;
            } else if (set==2)
            {
                response = hardGrid2[row][column];
                return response;
            } else {
                response = hardGrid3[row][column];
                return response;
            }
        }
        
    }
}
