public class Location {
    /** Name of location */
    public String name;
    /** special rooms */
    static Location start = new Location("the bus stop");
    static Location keyRoom= new Location("key room!"); //Playground
    static Location bossRoom = new Location("Moms house!"); //Home Town
    static Location potionRoom = new Location("the hospital!"); //Hospital
    static Location miniBossRoom = new Location("dads home"); //The other side
    static Location roomWep = new Location("Weapon room"); //Village
    /** normal rooms */
    static Location roomA = new Location("(A) On the road. You can go two ways, which way you wanna go?"); //Road
    static Location roomB = new Location("(B)"); //Road
    static Location roomC = new Location("(C)"); //Home town
    static Location roomD = new Location("(D)"); //Home town
    static Location roomE = new Location("(E)"); //Hospital
    static Location roomF = new Location("(F)"); //Home town
    static Location roomG = new Location("(G)"); //Home town
    static Location roomH = new Location("(H)"); //Road
    static Location roomI = new Location("(I)"); //Hospital
    static Location roomJ = new Location("(J)"); //The other side
    static Location roomK = new Location("(K)"); //The other side
    static Location roomL = new Location("(L)"); //Playground
    static Location roomM = new Location("(M)"); //Playground
    static Location roomN = new Location("(N)"); //Playground
    static Location roomO = new Location("(O)"); //Playground
    static Location roomP = new Location("(P)"); //Playground
    static Location roomQ = new Location("(Q)"); //Village
    static Location roomR = new Location("(R)"); //Village
    static Location roomS = new Location("(S))"); //Village
    static Location roomT = new Location("(T)"); //Village
    static Location roomU = new Location("(U)"); //Home town


    @Override
    public String toString() {
        String toPrint = this.name;
        return toPrint;
    }

    /** A connecting location */
    public Location north, south, east, west;

    public Location(String name) {
        this.name = name;
        this.key = false;
        this.potions = 0;
    }
    // Using ArrayList, so we can potentially have 1000 items in a room, no issue.
    /** An array of all the items in the room */
    public Item item;
    public Boolean key;
    public int potions;
    public Enemy enemy;

    /** Checks to see if there's a room in the given direction */
    public boolean dirExists(String dir){
        if(stringToDir(dir)!=null){
            return true;
        }
        return false;
    }
    public Location stringToDir(String dir){
        switch (dir) {
            case "north":
                return north ;
            case "south":
                return south;
            case "west":
                return west ;
            case "east":
                return east ;
        }
        return this;
    }
    public Location () {
        Location.start.north = Location.roomA;
        Location.start.west = Location.roomB;
        Location.start.south = Location.roomH;

        Location.roomA.south = Location.start;
        Location.roomA.east = Location.roomC;

        Location.roomB.west = Location.roomP;
        Location.roomB.east = Location.start;

        Location.roomC.east = Location.roomD;
        Location.roomC.west = Location.roomA;

        Location.roomD.west = Location.roomC;
        Location.roomD.south = Location.potionRoom;
        Location.roomD.north = Location.roomF;

        Location.roomE.north = Location.potionRoom;
        Location.roomE.west = Location.roomI;
        Location.roomE.south = Location.roomJ;

        Location.roomF.south = Location.roomD;
        Location.roomF.north = Location.roomG;

        Location.roomG.west = Location.roomU;
        Location.roomG.south = Location.roomF;
        Location.roomG.east = Location.bossRoom;

        Location.roomH.north = Location.start;
        Location.roomH.east = Location.roomI;

        Location.roomI.west = Location.roomH;
        Location.roomI.east = Location.roomE;

        Location.roomJ.north = Location.roomE;
        Location.roomJ.south = Location.miniBossRoom;

        Location.roomK.east = Location.miniBossRoom;
        Location.roomK.west = Location.roomL;

        Location.roomL.east = Location.roomK;
        Location.roomL.west = Location.roomM;

        Location.roomM.east = Location.roomL;
        Location.roomM.west = Location.keyRoom;

        Location.roomN.south = Location.keyRoom;
        Location.roomN.north = Location.roomO;

        Location.roomO.south = Location.roomN;
        Location.roomO.north = Location.roomP;

        Location.roomP.south = Location.roomO;
        Location.roomP.east = Location.roomB;
        Location.roomP.north = Location.roomQ;

        Location.roomQ.south = Location.roomP;
        Location.roomQ.north = Location.roomR;

        Location.roomR.south = Location.roomQ;
        Location.roomR.north = Location.roomWep;

        Location.roomS.west = Location.roomWep;
        Location.roomS.east = Location.roomT;

        Location.roomT.west = Location.roomS;
        Location.roomT.east = Location.roomU;

        Location.roomU.west = Location.roomT;
        Location.roomU.east = Location.roomG;

        Location.potionRoom.south = Location.roomE;
        Location.potionRoom.north = Location.roomD;

        Location.miniBossRoom.west = Location.roomK;
        Location.miniBossRoom.north = Location.roomJ;

        Location.keyRoom.east = Location.roomM;
        Location.keyRoom.north = Location.roomN;

        Location.roomWep.south = Location.roomR;
        Location.roomWep.east = Location.roomS;

        Location.bossRoom.east = Location.roomG;

        Location.keyRoom.key = true;
        Location.potionRoom.potions = 5;

        Location.bossRoom.enemy = Enemy.VeryAngryMan;
        Location.miniBossRoom.enemy = Enemy.AngryMan;
        Location.potionRoom.enemy = Enemy.Nurse;

    }
}
//